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
    <body ng-app="radioExample">        
        <form name="myForm" ng-controller="ExampleController">
            <label>
                <input type="radio" ng-model="color.name" ng-value="red">
                Red
            </label><br/>
            <label>
                <input type="radio" ng-model="color.name" ng-value="green">
                Green
            </label><br/>
            <label>
                <input type="radio" ng-model="color.name" ng-value="blue">
                Blue
            </label><br/>
            <tt>color = {{color.name| json}}</tt><br/>
        </form>
        <script>
            angular.module('radioExample', [])
                    .controller('ExampleController', ['$scope', function ($scope) {
                            
                            $scope.red = {
                                "id": "1",
                                "value": "red"
                            };
                              
                            $scope.green = {
                                "id": "2",
                                "value": "green"
                            };
                              
                            $scope.blue = {
                                "id": "3",
                                "value": "blue"
                            };
                        }]);
        </script>
    </body>
</html>
