var loadApp = angular.module('loadModule', []);

loadApp.controller('battingCareerCtrl', function ($scope, $http) {
    $http.get("json/battingCareers.json")
            .then(function (response) {
                $scope.battingCareers = response.data;

            });
});

loadApp.controller('bowlingCareerCtrl', function ($scope, $http) {
    $http.get("json/bowlingCareers.json")
            .then(function (response) {
                $scope.bowlingCareers = response.data;

            });
});

loadApp.controller('viewProfileCtrl', function ($scope, $http) {
    $http.get("json/viewProfile.json")
            .then(function (response) {
                $scope.viewProfile = response.data;
            });
});
loadApp.controller('upcomingTournamentCtrl', function ($scope, $http) {
    $http.get("json/upcomingTournament.json")
            .then(function (response) {
                $scope.upcomingTournaments = response.data;
            });
});

loadApp.controller('matchDetailCtrl', function ($scope, $http) {

    $http.get("json/matchDetails.json")
            .then(function (response) {
                $scope.matchDetails = response.data;
                //alert(angular.toJson($scope.matchDetails))
            });
});



