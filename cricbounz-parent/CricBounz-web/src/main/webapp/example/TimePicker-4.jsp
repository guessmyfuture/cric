<!DOCTYPE html>
<html ng-app="plunker">

    <head>
        <meta charset="utf-8" />
        <title>AngularJS Plunker</title>
        <script>document.write('<base href="' + document.location + '" />');</script>    
        <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" media="screen" href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">

        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
        </script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
        </script>
        <script type="text/javascript" src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
        </script>

        <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>

    </head>

    <body>
        <div class="container container-fluid" ng-controller="MainCtrl">
            var1={{var1}}<br>
            var2={{var2}}<br>
            <form class="form-horizontal" novalidate name="form" ng-submit="submit()">
                <div class="well">
                   
                    <div id="date" class="input-append" datetimez ng-model="var1">
                        <input data-format="hh:mm:ss"  type="text" id="input1" name="input1"></input>
                        <span class="add-on">
                            <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
                        </span>
                    </div>
                    
                    <div id="date" class="input-append" datetimez ng-model="var2">
                        <input data-format="hh:mm:ss"  type="text" id="input1" name="input1"></input>
                        <span class="add-on">
                            <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
                        </span>
                    </div>
                    
                    
                </div>
            </form>

        </div>
        <script>
            var app = angular.module('plunker', []);

            app.controller('MainCtrl', function ($scope) {
                $scope.var1 = '12-07-2013';
            });

            app.directive('datetimez', function () {
                return {
                    restrict: 'A',
                    require: 'ngModel',
                    link: function (scope, element, attrs, ngModelCtrl) {
                        element.datetimepicker({
                            language: 'en',
                            pickDate: false,
                        }).on('changeDate', function (e) {
                            ngModelCtrl.$setViewValue(e.date);
                            scope.$apply();
                        });
                    }
                };
            });
        </script>
    </body>

</html>
