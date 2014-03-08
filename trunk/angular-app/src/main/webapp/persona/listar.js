angular.module("persona.services", ["ngResource"])
    .factory("PersonaService", ["$resource",
        function($resource){
            return $resource("../rest/persona/:methodName", {methodName: "list"}, {
                registrar: {
                    method: "POST"
                    ,params: {
                        methodName: "put"
                        ,persona: "@persona"
                    }
                    ,isArray: false
                }
                ,obtener: {
                    method: "GET"
                    ,params: {
                        methodName: "get"
                        ,id: "@id"
                    }
                    ,isArray: false
                }
            });
        }]);


angular.module("persona", ["ngRoute", "ngGrid", "persona.services"])
    .controller("PersonaCtrl", function($rootScope, $scope, $http, PersonaService, $routeParams){
        if ($routeParams.id){
            $scope.persona = PersonaService.obtener({id: $routeParams.id});
        }

        $scope.list = [];

        //Create grid options
        $scope.gridOptions = {
            data: 'list'
            ,enableRowSelection: false
            ,enableCellEdit: true
            ,columnDefs: [
                {
                    field: "id"
                    ,headerCellTemplate: '<a href="#editar" data-toggle="modal" data-target="#myModal">Nuevo</a>'
                    ,width: "50"
                    ,cellTemplate: '<div></div><a href="#editar/{{row.getProperty(col.field)}}" data-toggle="modal" data-target="#myModal">Editar</a></div>'
                    ,enableCellEdit: false
                }
                ,{field: "id", displayName: "Id"}
                ,{field: "nombre", displayName: "Nombre"}
                ,{field: "apellidoPaterno", displayName: "Apellido Paterno"}
                ,{field: "apellidoMaterno", displayName: "Apellido Materno"}
                ,{field: "sexo", displayName: "Sexo"}
                ,{field: "fechaNacimiento", displayName: "Fecha Nac."}
            ]
        }

        //Setup method.
        $scope.setup = function(){
            //Get persona list
            $scope.list = PersonaService.query();

                /*list().success(function(data){
                $scope.list = data;
            });   */
        }

        $scope.registrar = function(){
            PersonaService.registrar($scope.persona);
            $scope.list.push($scope.persona);
            $('#myModal').modal('hide');
        }

        $scope.mostrarNombre = function(){
            alert($scope.nombrePersona);
        }
    })

    .config(['$routeProvider', function($routeProvider){
        $routeProvider.when("/editar", {
            controller: "PersonaCtrl"
            ,templateUrl: "editar.html"
        });

        $routeProvider.when("/editar/:id", {
            controller: "PersonaCtrl"
            ,templateUrl: "editar.html"
        })

        $routeProvider.otherwise({redirectTo: "/"})
    }]);