<!DOCTYPE html>
<html ng-app="ngexample">

    <head>
        <meta name="description" content="ng-options examples">
        <meta charset="utf-8">
        <title>ngexample - ng-options</title>   
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/angular.min.js" type="text/javascript"></script>
    </head>

    <body ng-controller="MainCtrl">
        <h3>using ng-options with select</h3>

        <h4>Hardcoded select</h4>
        <select ng-model='data.hardcodeVal'>
            <option value=''></option>
            <option value='Yes'>Yes</option>
            <option value='No'>No</option>
            <option value='MayBe'>MayBe</option>
        </select>
        <br/> Selected Value = {{data.hardcodeVal}}
       
        <script>
        var app = angular.module('ngexample', []);
        app.controller('MainCtrl', function ($scope, $http) {
            $scope.data = {};
           
            $scope.countriesObj = {
                "US": "United States of America",
                "IN": "India",
                "GB": "United Kingdom",
                "JP": "Japan"
            };
        });
        </script>
    </body>

</html>