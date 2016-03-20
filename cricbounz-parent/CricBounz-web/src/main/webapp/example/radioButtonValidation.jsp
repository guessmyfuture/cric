<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/angular.min.js" type="text/javascript"></script>
    </head>
    <body ng-app="radioExample">
        <form name="myForm" ng-submit="submitForm()" ng-controller="ExampleController">
            <input type="radio" ng-model="color" value="red" ng-required="!color">  Red <br/>
            <input type="radio" ng-model="color" value="green" ng-required="!color"> Green <br/>
            <input type="radio" ng-model="color" value="blue" ng-required="!color"> Blue <br/>
            <tt>color = {{color| json}}</tt><br/>
            <button type="submit">Submit</button>
        </form>
        <script>
            angular.module('radioExample', [])
                    .controller('ExampleController', ['$scope', function ($scope) {
                            $scope.color = '';
                            $scope.specialValue = {
                                "id": "12345",
                                "value": "green"
                            };

                            $scope.submitForm = function () {
                                alert('valid');
                            }
                        }]);
        </script>
    </body>
</html>
