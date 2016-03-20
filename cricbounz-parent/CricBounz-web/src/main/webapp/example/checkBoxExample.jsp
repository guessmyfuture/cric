<%-- 
    Document   : checkBoxExample
    Created on : Feb 25, 2016, 1:39:31 PM
    Author     : Coeuz 4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>   
        <script src="../js/angular.min.js" type="text/javascript"></script>
    </head>
    <body ng-app="myApp" ng-controller="myController">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">{{title}}</h3>
            </div>
            <div class="panel-body">
                <h3>Checkboxes</h3>
                <p>
                    The checkbox list comes from a complete array of options, the selected values are a different array.  There are two problems:
                <ul>
                    <li>setting initial checkboxes ::  <strong>SOLVED</strong></li>
                    <li>syncing the target with the selectors ::  <strong>SOLVED</strong></li>
                </ul>
                </p>

                <p ng-repeat="item in allOptions" class="item" id="{{item.id}}">
                    {{item.id}} <input type="checkbox" ng-change="sync(bool, item)" ng-model="bool" ng-checked="isChecked(item.id)"> Click this to sync this item with the target array.  {{item}} Selected: {{bool}} 

                <h3>Final Data Array</h3>
                <pre>{{data| json}}</pre>

                <h3>All Checkboxes Array</h3>
                <pre>{{allOptions| json}}</pre>

            </div>
        </div>  
        <script>
                    var lb = ""; // used for console.log()
                    var myApp = angular.module("myApp", []);

                    myApp.controller('myController', function ($scope) {
                        $scope.title = 'AngularJS Checkboxes Bound to Target Array with Initial Selections Checked';
                        $scope.content = '';

                        $scope.isChecked = function (id) {
                            var match = false;
                            for (var i = 0; i < $scope.data.length; i++) {
                                if ($scope.data[i].id == id) {
                                    match = true;
                                }
                            }
                            return match;
                        };

                        $scope.allOptions = [
                            {
                                "id": "1",
                                "data": "one",
                            },
                            {
                                "id": "2",
                                "data": "two",
                            },
                            {
                                "id": "3",
                                "data": "three",
                            },
                        ];

                        $scope.data = [];

                        $scope.sync = function (bool, item) {
                            if (bool) {
                                // add item
                                $scope.data.push(item);
                            } else {
                                // remove item
                                for (var i = 0; i < $scope.data.length; i++) {
                                    if ($scope.data[i].id == item.id) {
                                        $scope.data.splice(i, 1);
                                    }
                                }
                            }
                        };

                    });


        </script>
    </body>
