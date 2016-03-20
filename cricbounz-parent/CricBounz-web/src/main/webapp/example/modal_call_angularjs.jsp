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
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="../js/jquery.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/angular.min.js" type="text/javascript"></script>
        <script src="https://rawgit.com/dwmkerr/angular-modal-service/master/dst/angular-modal-service.js"></script>
    </head>
    <body> 
        <div class="container" ng-app="app" ng-controller="Controller">

            <h3>Angular Modal Service</h3>
            <a class="btn btn-default" href ng-click="show()">Show a Modal</a>
            <p>{{message}}</p>

            <!-- The actual modal template, just a bit o bootstrap -->
            <script type="text/ng-template" id="modal1.html">
                <div class="modal fade">
                <div class="modal-dialog">
                <div class="modal-content">
                <div class="modal-header">
                <button type="button" class="close" ng-click="close('Cancel')" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">jaiganesh</h4>
                </div>
                <div class="modal-body">
                <p>It's your call...</p>
                </div>
                <div class="modal-footer">
                <button type="button" ng-click="close('No')" class="btn btn-default" data-dismiss="modal">No</button>
                <button type="button" ng-click="close('Yes')" class="btn btn-primary" data-dismiss="modal">Yes</button>
                </div>
                </div>
                </div>
                </div>
            </script>
            
              <script type="text/ng-template" id="modal2.html">
                <div class="modal fade">
                <div class="modal-dialog">
                <div class="modal-content">
                <div class="modal-header">
                <button type="button" class="close" ng-click="close('Cancel')" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Ramalingam</h4>
                </div>
                <div class="modal-body">
                <p>It's your call...</p>
                </div>
                <div class="modal-footer">
                <button type="button" ng-click="close('No')" class="btn btn-default" data-dismiss="modal">No</button>
                <button type="button" ng-click="close('Yes')" class="btn btn-primary" data-dismiss="modal">Yes</button>
                </div>
                </div>
                </div>
                </div>
            </script>

        </div>
        <script>
            var app = angular.module('app', ['angularModalService']);
            app.controller('Controller', function ($scope, ModalService) {

                $scope.show1 = function () {
                    ModalService.showModal({
                        templateUrl: 'modal1.html',
                        controller: "ModalController"
                    }).then(function (modal) {
                        modal.element.modal();
                        modal.close.then(function (result) {
                            $scope.message = "You said " + result;
                        });
                    });
                };
                
                 $scope.show2 = function () {
                    ModalService.showModal({
                        templateUrl: 'modal2.html',
                        controller: "ModalController"
                    }).then(function (modal) {
                        modal.element.modal();
                        modal.close.then(function (result) {
                            $scope.message = "You said " + result;
                        });
                    });
                };
                
                $scope.show1();
                $scope.show2();

            });

            app.controller('ModalController', function ($scope, close) {

                $scope.close = function (result) {
                    close(result, 500); // close, but give 500ms for bootstrap to animate
                };

            });
        </script>
    </body>
</html>
