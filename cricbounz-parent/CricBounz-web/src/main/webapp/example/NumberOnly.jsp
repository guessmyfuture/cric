<!DOCTYPE html>
<html ng-app="app">

    <head>
        <meta charset="utf-8" />
        <title>AngularJS Plunker</title>
        <script>document.write('<base href="' + document.location + '" />');</script>
        <link rel="stylesheet" href="style.css" />
        <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" media="screen" href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">
        <script data-require="angular.js@1.0.x" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js" data-semver="1.0.8"></script>       
    </head>
    <body>
        <input type="text" only-digits ng-model="hu">
    <script>
        angular.module('app').directive('onlyDigits', function () {
    return {
      require: 'ngModel',
      restrict: 'A',
      link: function (scope, element, attr, ctrl) {
        function inputValue(val) {
          if (val) {
            var digits = val.replace(/[^0-9]/g, '');

            if (digits !== val) {
              ctrl.$setViewValue(digits);
              ctrl.$render();
            }
            return parseInt(digits,10);
          }
          return undefined;
        }            
        ctrl.$parsers.push(inputValue);
      }
    };
});
    </script>
</body>

</html>
