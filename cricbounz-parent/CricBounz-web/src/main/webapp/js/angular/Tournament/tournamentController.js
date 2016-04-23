/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var groundApp = angular.module('tournamentModule', []);
groundApp.controller("CreateNewTourmentCtrl", function ($scope, $http) {
    $scope.postNewTournament = function () {      
       
        var data = {
            tournament: $scope.tournament,
            city: $scope.city,
            area: $scope.area,
            contact1: $scope.contact1,
            contact2: $scope.contact2, 
            ballId: $scope.selectBallId,
            regStartDate: $scope.regStartDate,
            regEndDate: $scope.regEndDate,
            trmStartDate: $scope.trmStartDate,
            trmEndDate: $scope.trmEndDate,
            winPrizeDetails: $scope.winPrizeDetails,
            runPrizeDetails: $scope.runPrizeDetails            
        };
        
       console.warn("I am Sending to Rest Server: "+angular.toJson(data));
      
        var config = {
            headers: {
                'Content-Type': 'application/json'
            }
        }        
         
        $http.post('rest/tournament/', data, config)
                .success(function (data, status, headers, config) {
                    $scope.PostDataResponse = data;

                })
                .error(function (data, status, header, config) {
                    $scope.ResponseDetails = "Data: " + data +
                            "<hr />status: " + status +
                            "<hr />headers: " + header +
                            "<hr />config: " + config;
                });
    };
});


angular.module('myApp', ['ngAnimate', 'ui.bootstrap']);
angular.module('myApp').controller('dateController', function ($scope) {
    $scope.today = function () {
        $scope.dt = new Date();
    };
    $scope.mindate = new Date();
    $scope.dateformat="MM/dd/yyyy";
    $scope.today();
    $scope.showcalendar = function ($event) {
        $scope.showdp = true;
    };
    $scope.showdp = false;
});

angular.module('myApp', ['ngAnimate', 'ui.bootstrap']);
angular.module('myApp').controller('myCntrl', function ($scope) {
    $scope.today = function () {
        $scope.dt = new Date();
    };
    $scope.mindate = new Date();
    $scope.dateformat="MM/dd/yyyy";
    $scope.today();
    $scope.showcalendar = function ($event) {
        $scope.showdp = true;
    };
    $scope.showdp = false;
});

/*
groundApp.controller("BookGroundCtrl", function ($scope, $http) {   
    $scope.postBookGround = function () {        
        alert('Posted '+$scope.selectBallId);
        var data = {
            city: $scope.city,
            area: $scope.area,
            groundName: $scope.groundName,
            groundAddress: $scope.groundAddress,
            landMark: $scope.landMark
        };
        alert(angular.toJson($scope.addedBallTypes));
        var config = {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
            }
        }

        $http.post('Server.jsp', data, config)
                .success(function (data, status, headers, config) {
                    $scope.PostDataResponse = data;

                })
                .error(function (data, status, header, config) {
                    $scope.ResponseDetails = "Data: " + data +
                            "<hr />status: " + status +
                            "<hr />headers: " + header +
                            "<hr />config: " + config;
                });
    };
});*/