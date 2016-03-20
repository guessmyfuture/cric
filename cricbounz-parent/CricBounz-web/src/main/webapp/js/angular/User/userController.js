var userApp = angular.module('userModule', []);
userApp.controller("userCtrl", function ($scope, $http) {
    $scope.RH = {
        "id": "1",
        "value": "Right Hand"
    };

    $scope.LH = {
        "id": "2",
        "value": "Left Hand"
    };    

    $scope.postEditUser = function () {
        if (!$scope.$valid) {
            $scope.submitted=true;
            alert("Form Invlid You Cannot Post");
           // return;
        }
        var data = {
            profileName: $scope.profileName,
            email: $scope.email,
            mobileNumber: $scope.mobileNumber,
            dob: $scope.dob,
            area: $scope.area,
            city: $scope.city,
            battingStyle: $scope.battingStyle,
            bowlingStyle: $scope.bowlingStyle,
            bowlingSpeed: $scope.bowlingSpeed
        };
        alert(angular.toJson(data));
        console.warn("I am Sending to Rest Server: " + angular.toJson(data));
        return;
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
