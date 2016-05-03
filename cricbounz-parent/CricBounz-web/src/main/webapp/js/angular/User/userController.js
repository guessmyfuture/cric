var userApp = angular.module('userModule', []);



userApp.controller("viewUserProfileCtrl", function ($scope,$rootScope,$routeParams,$http) {
	$http.get('service/rest/user/getuser?userid='+$routeParams.userId)
    .success(function (data, status, headers, config) {
        $scope.user = data;
        //alert(angular.toJson(data));
    })
    .error(function (data, status, header, config) {
       
    });
	
});

userApp.controller("searchUserCtrl", function ($scope,$rootScope,$routeParams,$http) {
	$scope.searchUser = function (stext) {    		
    if (stext == '')
    {
        $scope.userList = [];
        return;
    }
    $http.get('service/rest/user/getUserListsByName?searchText=' + stext).then(function (res) {
        console.log(angular.toJson(res.data));        	
        $scope.userList = res.data;
        $scope.$parent.userList=$scope.userList;
    });
	}
});
    

userApp.controller("searchUsersList", function ($scope,$rootScope,$routeParams,$http) {	
	$scope.searchUser=function()
	{
		$http.get('service/rest/user/getfriends')
	    .success(function (data, status, headers, config) {
	        $scope.userList = data;
	        //alert(angular.toJson($scope.myFriendsList));
	    })
	    .error(function (data, status, header, config) {
	       
	    });
	}
});

userApp.controller("myFriendsController", function ($scope,$rootScope,$routeParams,$http) {	
	$http.get('service/rest/user/getfriends')
    .success(function (data, status, headers, config) {
        $scope.myFriendsList = data;
        //alert(angular.toJson($scope.myFriendsList));
    })
    .error(function (data, status, header, config) {
       
    });
});

userApp.controller("userCtrl", function ($scope,$rootScope,$http) {	
	
    $scope.RH = {
        "id": "1",
        "value": "Right Hand"
    };

    $scope.LH = {
        "id": "2",
        "value": "Left Hand"
    };

    /*$http.get('service/rest/user/getcurrentuser')
    .then(function (res) {
    	$scope.user=res.data;
    	$rootScope.currentUser=res.data;
    });*/
   
   
    // alert(angular.toJson($rootScope.loggedInUser));
    $scope.user=$rootScope.loggedInUser;
    alert($rootScope.loggedInUser);
    alert($scope.user);
    $scope.updateUser = function () {        
        console.warn("Update Profile Fired"+angular.toJson($scope.user));   
        //alert(angular.toJson($scope.user));
        var config = {
            headers: {
                'Content-Type': 'application/json'
            }
        }

        $http.post('service/rest/user/registeruser/', $scope.user, config)
                .success(function (data, status, headers, config) {
                    $scope.PostDataResponse = data;
                    if($scope.PostDataResponse.responseStatus=="Success")
                     {
                       alert("User Information Updated Successfully");
                     }

                })
                .error(function (data, status, header, config) {
                	
                    $scope.ResponseDetails = "Data: " + data +
                            "<hr />status: " + status +
                            "<hr />headers: " + header +
                            "<hr />config: " + config;
                    //alert($scope.ResponseDetails )
                });
    };
    
    
    
    
    $scope.postEditUser = function () {
        if (!$scope.$valid) {
            $scope.submitted = true;
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
