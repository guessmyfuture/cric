<!DOCTYPE html>
<html ng-app="myApp">

    <head>
        <meta charset="utf-8" />
        <title>AngularJS Plunker</title>
        <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

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

        <style>
            body {
                background-color: #e1e1e1;
                color:#444;
            }

            .fa {
                color:#fff;
            }

            #userList {
                display:none;
            }

            #loader {
                position:absolute;
                z-index:2;
                width:100%;
                text-align:center;
                top:40%;
            }

        </style>
    </head>
    <body>
        <i class="fa fa-spin fa-refresh fa-5x" id="loader"></i>
        <div class="container" ng-app="myApp" ng-controller="Main"> 
            <h1>AngularJS - Multiple Layout Grid</h1>
            <h4>with <a href="">RandomUser.me</a> API</h4>
            <hr>
            <div class="clearfix">
                <ul class="nav nav-pills pull-right">
                    <li ng-class="{'active':mode == 1}" title="list"><a href="#" ng-click="mode = 1"><i class="fa fa-list fa-4x"></i></a></li>
                    <li ng-class="{'active':mode == 2}" title="thumbs"><a href="#" ng-click="mode = 2"><i class="fa fa-th fa-4x"></i></a></li>
                    <li ng-class="{'active':mode == 3}" title="big thumbs"><a href="#" ng-click="mode = 3"><i class="fa fa-th-large fa-4x"></i></a></li>
                </ul>                
            </div>
            <hr>
            <div class="container" id="userList">
                <div class="row">
                    <!--<div ng-repeat="u in users">
                       <div class="well">
                           <a href="" ng-click="showUserModal($index)"><img src="" class="img-responsive"></a>
                           <h3 class="cap" ng-hide="mode == 1">{{u.user.name.first}}{{u | json}}</h3>
                           <p ng-show="mode == 3">
                               {{u.user.location.city}}, {{u.user.location.state}} {{u.user.location.zip}}<br>
                               {{u.user.phone}}
                           </p>
                       </div>
                   </div>-->

                    <div ng-repeat-start="u in users" ng-class="{'col-xs-4':mode == 1, 'col-xs-3':mode == 2, 'col-xs-6':mode == 3}">
                        <div class="well">
                            <a href="" ng-click="showUserModal($index)"><img src="{{u.user.picture.medium}}" class="img-responsive"></a>
                            <h3 class="cap" ng-hide="mode == 1">{{u.user.name.first}}</h3>                            
                            <p ng-show="mode == 3">
                                {{u.user.location.city}}, {{u.user.location.state}} {{u.user.location.zip}}<br>
                                {{u.user.phone}}
                            </p>
                        </div>
                    </div>
                    <div ng-class="{'col-xs-8':mode == 1, 'col-xs-6':mode == 3}" ng-hide="mode == 2 || mode == 3">
                        <h2 class="cap">{{u.user.name.first}} {{u.user.name.last}} <i ng-show="u.user.gender == 'female'" class="fa fa-female"></i><i ng-show="u.user.gender == 'male'" class="fa fa-male"></i></h2>
                        <div class="row">
                            <div class="col-sm-6">                               
                                <p>
                                    {{u.user.location.city}}, {{u.user.location.state}} {{u.user.location.zip}}<br>
                                    {{u.user.phone}}
                                </p>
                            </div>
                            <div class="col-sm-6 text-right">
                                <div class="hidden-xs">
                                    <a href="">{{u.user.email}}</a><br>
                                    <h3><span class="label label-primary">{{u.user.username}}</span></h3>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div ng-repeat-end="" ng-class="{'clearfix':mode == 1}"></div>

                </div><!--/row-->
                <hr>
            </div><!--/container-->

            <div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header bg-info">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h1 id="myModalLabel" class="text-center"></h1>                           
                        </div>
                        <div class="modal-body">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-xs-4 col-xs-offset-4"><img src="{{currUser.picture}}" class="img-thumbnail img-responsive img-circle"></div>
                                </div>
                                <hr>
                                <div class="row">
                                    <h4 class="text-center"><i class="fa fa-fw fa-map-marker fa-2x"></i> {{currUser.location.street}} {{currUser.location.city}}, {{currUser.location.state}}</h4>
                                    <h4 class="text-center"><i class="fa fa-fw fa-phone fa-2x"></i> {{currUser.cell}}</h4>
                                    <h4 class="text-center"><i class="fa fa-fw fa-envelope-o fa-2x"></i> {{currUser.email}}</h4>
                                    <h4 class="text-center"><i class="fa fa-fw fa-user fa-2x"></i> {{currUser.username}}</h4>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer bg-info">
                            <button class="btn btn-lg btn-default center-block" data-dismiss="modal" aria-hidden="true">Okay!</button>
                        </div>
                    </div>
                </div>
            </div><!--/modal-->

        </div><!--/container-->
        <script>
            var myApp = angular.module('myApp', []);
            function Main($scope, $http) {

                //$http.get('http://api.randomuser.me/?results=20').success(function (data) {
                $http.get('../json/chumma.json').success(function (data) {
                    $scope.users = data.results;
                    $('#loader').hide();
                    $('#userList').show();

                }).error(function (data, status) {
                    alert('get data error!');
                });

                $scope.showUserModal = function (idx) {
                    var user = $scope.users[idx].user;
                    $scope.currUser = user;
                    $('#myModalLabel').text(user.name.first
                            + ' ' + user.name.last);
                    $('#myModal').modal('show');
                }

                // default view is list
                $scope.mode = 1;

            }

//$(document).ready(function() {});
        </script>
    </body>
</html>
