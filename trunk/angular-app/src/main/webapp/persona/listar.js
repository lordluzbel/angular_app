angular.module("persona.services", [])
    .factory("PersonaService", function($http){
        return {
            put: function(persona){
                return $http({
                    method: "POST"
                    ,url: "../rest/persona/put"
                    ,headers: {
                        "Content-Type" : "application/json"
                    }
                    ,data: JSON.stringify(persona)
                });
            }

            ,list: function(){
                return $http.post("../rest/persona/list");
            }

            ,get: function(id){
                return $http.get("../rest/persona/get/" + id);
            }
        }
    });

angular.module("persona", ["ngRoute", "persona.services"])
    .controller("PersonaCtrl", function($scope, $http, PersonaService, $routeParams){
        console.log($routeParams.id);
        if ($routeParams.id){
            PersonaService.get($routeParams.id).success(function(data){
                $scope.persona = data;
            });
        }

        $scope.listar = function(){
            PersonaService.list().success(function(data){
                console.log(data);
                $scope.list = data;
            });
        }

        $scope.registrar = function(){
            PersonaService.put($scope.persona).success(function(data){
                $scope.list.push(data);
            });
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