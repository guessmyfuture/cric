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
    <body ng-app="copyExample">
        <div ng-controller="ExampleController">
            <form novalidate class="simple-form">
                Name: <input type="text" ng-model="user.name" /><br />
                E-mail: <input type="email" ng-model="user.email" /><br />
                Gender: <input type="radio" ng-model="user.gender" value="male" />male
                <input type="radio" ng-model="user.gender" value="female" />female<br />
                <button ng-click="reset()">RESET</button>
                <button ng-click="update(user)">SAVE</button>
            </form>
            <pre>form = {{user| json}}</pre>
            <pre>master = {{master| json}}</pre>
        </div>

        <script>
            angular.module('copyExample', [])
                    .controller('ExampleController', ['$scope', function ($scope) {
                            $scope.master = {};

                            $scope.update = function (user) {
                                // Example with 1 argument
                                $scope.master = angular.copy(user);
                            };

                            $scope.reset = function () {
                                // Example with 2 arguments
                                //angular.copy($scope.master, $scope.user);
                                $scope.user = angular.copy($scope.master);
                            };

                            $scope.reset();
                        }]);
        </script>


    </body>
</html>
