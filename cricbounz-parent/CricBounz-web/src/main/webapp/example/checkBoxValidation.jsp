<%-- 
    Document   : checkBoxValidation
    Created on : Mar 9, 2016, 6:05:09 PM
    Author     : Coeuz 4
--%>

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
    <body ng-app="formApp" ng-controller="formController">
        <div class="col-xs-12 col-sm-10 col-sm-offset-1">
            <h2>Angular Checkboxes</h2>
            <form name="myForm">
                <!-- NAME INPUT -->
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" name="username" ng-model="username" ng-minlength="4" maxlength="8" required >
                    <span class="text-danger" ng-show="myForm.username.$invalid">4-8 characters</span>
                </div>
                <!-- MULTIPLE CHECKBOXES -->
                <label>Colors</label>
                <div class="form-group">
                    <label class="checkbox-inline" ng-repeat="color in colors">
                        <input type="checkbox" name="colors" ng-model="color.checked" ng-click="countCheck(color)">{{color.name}}
                    </label>
                    <span class="error text-danger" ng-show="colorCount == 0">Please check one color at least</span>
                </div>

                <!-- SUBMIT BUTTON (DOESNT DO ANYTHING) -->
                <button type="submit" class="btn btn-danger btn-lg" ng-disabled="myForm.username.$invalid || colorCount == 0">Send Away!</button>
            </form>
        </div>
        <script>
                    // app.js
                    var formApp = angular.module('formApp', [])
                            .controller('formController', function ($scope) {
                                $scope.colors = [{
                                        'id': '1',
                                        'name': 'red'
                                    }, {
                                        'id': '2',
                                        'name': 'green'
                                    }, {
                                        'id': '3',
                                        'name': 'blue'
                                    }];

                                $scope.colorCount = 0;
                                $scope.countCheck = function (color) {
                                    if (color.checked) {
                                        $scope.colorCount--;//opposite
                                    } else {
                                        $scope.colorCount++;
                                    }
                                };
                            });
        </script>
    </body>
</html>
