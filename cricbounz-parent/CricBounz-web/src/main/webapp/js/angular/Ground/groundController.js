/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var groundApp = angular.module('groundModule', []);
groundApp.controller("CreateNewGroundCtrl", function ($scope, $http) {
    $scope.postAddGround = function () {
        var pitch = [];

        if (!angular.isUndefined($scope.pitchTurf))
        {
            if ($scope.pitchTurf)
            {
                var pitch1 = {};
                pitch1.id = "1";
                pitch1.name = "Turf";
                pitch1.checked = $scope.pitchTurf;
                pitch.push(pitch1);
            }
        }
        if (!angular.isUndefined($scope.pitchMat))
        {
            if ($scope.pitchMat)
            {
                var pitch2 = {};
                pitch2.id = "2";
                pitch2.name = "Matt";
                pitch2.checked = $scope.pitchMat;
                pitch.push(pitch2);
            }
        }

        for (i = 0; i < $scope.slots.length; i++)
        {
            if (!angular.isUndefined($scope.slots[i].startTime) && !angular.isUndefined($scope.slots[i].endTime))
            {
                var st = $scope.slots[i].startTime;
                var et = $scope.slots[i].endTime;
               // alert($scope.slots[i].startTime + ' ' + $scope.slots[i].endTime);
            }
        }
      
       /* var data = {
            city: $scope.city,
            area: $scope.area,
            groundName: $scope.groundName,
            groundAddress: $scope.groundAddress,
            landMark: $scope.landMark,
            ballType: $scope.addedBallTypes,
            pitchType: pitch,
            slots: $scope.slots
        };*/
        var data = {
            city: $scope.city,
            area: $scope.area,
            groundName: $scope.groundName,
            groundAddress: $scope.groundAddress,
            landMark: $scope.landMark,
            ballType: $scope.addedBallTypes,
            pitchType: pitch,
            slots: $scope.slots
        };
        
       console.warn("I am Sending to Rest Server: "+angular.toJson(data));
        
        var config = {
            headers: {
                'Content-Type': 'application/json'
            }
        }

        $http.post('rest/ground/', data, config)
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

groundApp.controller("BookGroundCtrl", function ($scope, $http) {
    $scope.postBookGround = function () {
        alert('Posted ' + $scope.selectBallId);
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
});