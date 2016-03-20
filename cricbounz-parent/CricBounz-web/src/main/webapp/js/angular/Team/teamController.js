/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var teamApp = angular.module('teamModule', []);
teamApp.controller('ballTypeCtrl', function ($scope, $http) {
    $scope.addedBallTypes = [];
    var tempBallTypes = [];
    //$scope.$parent.addedBallTypes =  $scope.addedBallTypes;
    $http.get('response/ballTypes.jsp')
            .then(function (res) {
                $scope.ballTypes = res.data;
            });

    $scope.sync = function (bool, item) {
        if (bool) {
            // add item
            tempBallTypes.push(item);
        } else {
            // remove item
            for (var i = 0; i < tempBallTypes.length; i++) {
                if (tempBallTypes[i].ballId == item.ballId) {
                    tempBallTypes.splice(i, 1);
                }
            }
        }

        $scope.addedBallTypes = angular.copy(tempBallTypes);

        for (i = 0; i < $scope.addedBallTypes.length; i++)
        {
            delete $scope.addedBallTypes[i].ballType;
        }
    };
});


teamApp.controller('viewMyTeamCtrl', function ($scope, $http) {
    $http.get("json/viewMyTeam.json")
            .then(function (response) {
                $scope.myTeam = response.data;

            });
});

teamApp.controller('battingCareerCtrl', function ($scope, $http) {
    $http.get("json/battingCareers.json")
            .then(function (response) {
                $scope.battingCareers = response.data;

            });
});

teamApp.controller('bowlingCareerCtrl', function ($scope, $http) {
    $http.get("json/bowlingCareers.json")
            .then(function (response) {
                $scope.bowlingCareers = response.data;
            });
});

teamApp.controller("CreateTeamController", function ($scope, $http) {
    //  $scope.addedBallTypes = [];
    $scope.addedUserListIds = [];
    $scope.files = [];
    $scope.postCreateTeamData = function () {

        if ($scope.addedUserListIds.length < 11)
        {
            console.warn('You Should Add Minimum 11 Players');
        }

        /*var data = {
         teamName: $scope.teamName,
         captainName: $scope.captainName,
         ballTypes: $scope.addedBallTypes,
         area: $scope.area,
         city: $scope.city,
         imageUrl: $scope.files,
         description: $scope.description,
         userList: $scope.addedUserListIds
         };*/
        /* i am neglecting image url now*/
        var data = {
            teamName: $scope.teamName,
            captainName: $scope.captainName,
            ballTypes: $scope.addedBallTypes,
            area: $scope.area,
            city: $scope.city,
            description: $scope.description,
            userList: $scope.addedUserListIds
        }

        console.warn("I am Sending to Rest Server: " + angular.toJson(data));
        var config = {
            headers: {
                'Content-Type': 'application/json'
            }
        }

        $http.post('rest/postTeam/', data, config)
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
teamApp.controller('includeControl', ['$scope', function ($scope) {
        $scope.activateTemplate = (getCookie("currentPage") == null ? 'partials/content.html' : getCookie("currentPage"));
        //'partials/content.html'";
        $scope.changeContentPage = function (pageUrl) {
            $scope.activateTemplate = pageUrl;
            document.cookie = "color=red";
            document.cookie = "currentPage=" + $scope.activateTemplate;
        }
    }]);
teamApp.directive('ngUnique', ['$http', function (async) {
        var self = this;
        self.user = {};
        console.log('team name unique loaded');
        return {
            require: 'ngModel',
            link: function (scope, elem, attrs, ctrl) {

                elem.on('blur', function (evt) {
                    scope.$apply(function () {
                        var val = elem.val();
                        var req = {"teamName": val}

                        var ajaxConfiguration = {
                            method: 'POST',
                            url: 'rest/IsTeamNameAvailable',
                            data: req
                        };
                        async(ajaxConfiguration)
                                .success(function (data, status, headers, config) {
                                    console.log('success ' + data.result);
                                    ctrl.$setValidity('unique', data.result);
                                }).error(function (data, status, headers, config) {
                            //     $scope.message = 'Unexpected Error';
                            console.log('errror' + data + " Status:" + status);
                        });
                    });
                });
            }
        }
    }]);
teamApp.controller('playerAutoCompleteCtrl', function ($scope, $http) {
    $scope.addedUserList = [];
    $scope.addedUserListIds = [];
    $scope.userList = {};
    //$scope.$parent.addedUserList = $scope.addedUserList;
    $scope.$parent.addedUserListIds = $scope.addedUserListIds;
    $scope.loadMe = function () {
        if ($scope.searchText == '')
        {
            $scope.userList = [];
            return;
        }
        $http.get('rest/user/' + $scope.searchText).success(function (data, status, headers, config) {
            console.log('success ' + data);
            $scope.userList = data;
            angular.forEach($scope.userList, function (obj) {
                obj["addedStatus"] = false;
                //obj.addedStatus = "";
            });
            for (i = 0; i < $scope.userList.length; i++)
            {
                var userList = $scope.userList[i]["userId"];
                for (j = 0; j < $scope.addedUserList.length; j++)
                {
                    var addeduserList = $scope.addedUserList[j]["userId"];
                    if (userList == addeduserList)
                    {
                        $scope.userList[i]["addedStatus"] = true;
                        //$scope.userList.splice(i, 1);
                        break;
                    }
                }
            }
        }).error(function (data, status, headers, config) {
            //     $scope.message = 'Unexpected Error';
            console.log('errror' + data + " Status:" + status);
        });
    };
    $scope.addList = function (index, userId) {
        var searchField = "userId";
        for (var i = 0; i < $scope.userList.length; i++)
        {
            if ($scope.userList[i][searchField] == userId) {
                $scope.userList[i].addedStatus = true;
                $scope.addedUserList.push($scope.userList[i]);
                var item = {};
                item["userId"] = userId;
                $scope.addedUserListIds.push(item);
            }
        }
        $scope.userList.splice(index, 1);
    }
    $scope.removeList = function (index, userId) {
        $scope.addedUserList.splice(index, 1);
        $scope.addedUserListIds.splice(index, 1);
        for (var i = 0; i < $scope.userList.length; i++)
        {
            if ($scope.userList[i]["userId"] == userId) {

                $scope.userList[i].addedStatus = false;
            }
        }
    }
});
teamApp.controller('slotAddCtrl', function ($scope) {
    $scope.slots = [];
    $scope.slots.push({});
    $scope.slots.push({});
    $scope.slots.push({});
    $scope.slots.push({});
    $scope.status = '';
    $scope.addNewSlot = function () {
        if ($scope.slots.length < 6)
        {
            $scope.slots.push({});
            $scope.status = '';
        } else
        {
            $scope.status = 'YOU CAN ADD 6 SLOTS ONLY';
        }
    }

    $scope.removeSlot = function () {
        if ($scope.slots.length > 2)
        {
            $scope.slots.splice($scope.slots.length - 1, 1);
            $scope.status = '';
        } else
        {
            $scope.status = 'ATLEAST  2 SLOTS NEEDED';
        }
    }
});

