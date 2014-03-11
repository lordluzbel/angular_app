<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html ng-app="persona">
<head>
    <title>Modulo de personas</title>
    <link type="text/css" href="../css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="../css/ng-grid.min.css" rel="stylesheet">
    <style type="text/css">
        .body-container {height:150px; width: 100%; margin: 0; overflow-y: auto;}
        .table-scrollable { margin: 0; padding: 0; }

        .table thead th{
            background-color: #f1f1f1;
        }

        .gridStyle {
            border: 1px solid rgb(212,212,212);
            width: 100%;
            height: 300px
        }
    </style>

    <script type="text/javascript" src="../js/angular.min.js"></script>
    <script type="text/javascript" src="../js/angular-route.min.js"></script>
    <script type="text/javascript" src="../js/angular-resource.min.js"></script>

    <script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/ng-grid-2.0.7.min.js"></script>
    <script type="text/javascript" src="listar.js"></script>

    <script type="text/ng-template" id="/cell-template.html">
        <div>
            <a href="#editar/{{persona.id}}" data-toggle="modal" data-target="#myModal">Editar</a>
        </div>
    </script>
</head>
<body ng-controller="PersonaCtrl" ng-init="setup()">
    <div class="page-header">
        <h1>Modulo de personas</h1>
        <div style="text-align: right"><a href="<c:url value="/j_spring_security_logout" />">Logout</a></div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Editar persona</h4>
                </div>
                <div class="modal-body">
                    <div ng-view=></div>
                </div>
                <!--div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    <button type="button" class="btn btn-primary" ng-click="registrar()">Registrar</button>
                </div-->
            </div>
        </div>
    </div>

    <div class="gridStyle" ng-grid="gridOptions" style="width: 70em"></div>
</body>
</html>