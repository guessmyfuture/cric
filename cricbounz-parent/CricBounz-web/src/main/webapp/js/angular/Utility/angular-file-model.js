//
// angular-file-model
// ==================
//
// Directive that makes the inputs with type `file` to be
// available in the `$scope` and be assigned to a model.
//

  'use strict';

  angular.module('file-model', [])
        .directive('ngFileSelect', [ '$parse', '$timeout', function($parse, $timeout) {
    return function(scope, elem, attr) {
            var fn = $parse(attr['ngFileSelect']);
            elem.bind('change', function(evt) {
                var files = [], fileList, i;
                fileList = evt.target.files;
                if (fileList != null) {
                    for (i = 0; i < fileList.length; i++) {
                        files.push(fileList.item(i));
                    }
                }
                $timeout(function() {
                    fn(scope, {
                        $files : files,
                        $event : evt
                    });
                });
            });
        };
    }]);