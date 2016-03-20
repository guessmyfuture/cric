<%-- 
    Document   : CopyJson
    Created on : Feb 25, 2016, 2:24:59 PM
    Author     : Coeuz 4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="../js/angular.min.js" type="text/javascript"></script>
    </head>
    <body ng-app="MyApp">
        <div ng-controller="MyCtrl">
            <label>Primitive</label>
            <input type="text" ng-model="name">

            <label>Object</label>
            <input type="text" ng-model="user.name">

            <div class="nested" ng-controller="MyNestedCtrl">
                <label>Primitive</label>
                <input type="text" ng-model="name">

                <label>Primitive with explicit $parent reference</label>
                <input type="text" ng-model="$parent.name">

                <label>Object</label>
                <input type="text" ng-model="user.name">
            </div>
        </div>
    </body>
    <script>
        var app = angular.module("MyApp", []);

        app.controller("MyCtrl", function ($scope) {
            $scope.name = "Peter";
            $scope.user = {
                name: "Parker"
            };
        });

        app.controller("MyNestedCtrl", function ($scope) {
        });
    </script>
</html>
