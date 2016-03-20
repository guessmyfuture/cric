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
        <br/>
        <br/>
        <h4>ng-options with simple string array - Both display and value are same string</h4>

        <select ng-model='data.stringArrVal' ng-options='str for str in stringArr'>
        </select>
        <br/> Selected Value = {{data.stringArrVal}}
        <br/>
        <br/>
        <h4>ng-options with simple string array - display is string but value is array index</h4>
        <select ng-model='data.stringArrIndexVal' ng-options='k as v for (k,v) in stringArr'>
        </select>
        <br/> Selected Value = {{data.stringArrIndexVal}}
        <br/>
        <br/>

        <h4>ng-options with an object</h4>
        <select ng-model='data.countryVal' ng-options='k as v for (k,v) in countriesObj'>
        </select>
        <br/> Selected Value = {{data.countryVal}}
        <br/>
        <br/>

        <h4>ng-options with an list of objects</h4>
        <select ng-model='data.selectedCountry' ng-options='country.isoCode as country.name for country in countriesList'>
        </select>
        <br/> Selected Value = {{data.selectedCountry}}
        <br/>
        <br/>
        <script>
                    var app = angular.module('ngexample', []);
                    app.controller('MainCtrl', function ($scope, $http) {
                        $scope.data = {};

                        $scope.stringArr = ["Yes", "No", "MayBe"];
                        $scope.countriesObj = {
                            "US": "United States of America",
                            "IN": "India",
                            "GB": "United Kingdom",
                            "JP": "Japan"
                        };

                        $scope.countriesList = [{
                                "isoCode": "US",
                                "name": "United States of America",
                                "code": "840"
                            }, {
                                "isoCode": "IN",
                                "name": "India",
                                "code": "356"
                            }, {
                                "isoCode": "GB",
                                "name": "United Kingdom",
                                "code": "826"
                            }, {
                                "isoCode": "JP",
                                "name": "Japan",
                                "code": "392"
                            }];

                    });
        </script>
    </body>

</html>