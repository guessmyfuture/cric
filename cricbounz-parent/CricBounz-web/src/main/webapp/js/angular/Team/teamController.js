/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var teamApp = angular.module('teamModule', []);

teamApp.controller('teamDetailViewCtrl', function ($scope, $routeParams, $http) {	
	getmydata = function() {
	    return $http.get('service/rest/team/getTeamFullDetails?teamId=' + $routeParams.teamId)
	        .success(function(data) 
	        {
	        	$scope.team1 = data;
	        });
	    }

	// do the ajax call
	getmydata().then(function(data) {		 
		$scope.team=$scope.team1;
		//alert("detailTeamViewCtrl "+angular.toJson($scope.team));
	});	
	
});

teamApp.controller('teamPlayersCtrl', function ($scope, $routeParams, $http) {	
	getmydata = function() {
	    return $http.get('service/rest/team/getTeamFullDetails?teamId=' + $routeParams.teamId)
	        .success(function(data) 
	        {
	        	$scope.teamPlayers1 = data;
	        });
	    }

	// do the ajax call
	getmydata().then(function(data) {		 
		$scope.teamPlayers=$scope.teamPlayers1;
		//alert("detailTeamViewCtrl "+angular.toJson($scope.teamPlayers));
	});	
	
});


//team work
teamApp.controller('viewMyTeamsCtrl', function ($scope, $routeParams, $http, $rootScope) {
	$scope.opponentTeamList=[];
	
	$scope.loadMyTeams=function() 
	{
	$http.get("service/rest/team/getMyTeams/")
     .then(function (response) {
         $scope.myTeamList = response.data;
     });
	}
	$scope.loadMyTeams();	
	
	$scope.searchMyTeams=function(stext) 
	{	
     var url="service/rest/team/getALLTeams?searchText="+stext;
     //alert(url);
	 $http.get(url)
     .then(function (response) {
        $scope.opponentTeamList = response.data;
        //alert(angular.toJson($scope.opponentTeamList));
        angular.forEach($scope.opponentTeamList,function(value,key){
        	 angular.forEach($scope.myTeamList,function(innerValue,innerKey){
        		 if(value.teamID==innerValue.teamID)
        			{        			  
        			 delete $scope.opponentTeamList[key];
        			}
        	 });        
        });
     }); 
	}	
});

teamApp.controller('viewSearchMyTeamCtrl', function ($scope, $routeParams, $http, $rootScope) {	
	$scope.searchMyTeams=function(stext) 
	{	
		if(!angular.isUndefined($scope.searchText))
		{
			stext=$scope.searchText;
		}
       var url="service/rest/team/getALLTeams?searchText="+stext;     
		 $http.get(url)
	     .then(function (response) {
	        $scope.searchTeamList = response.data;       
	     }); 
	}	
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

teamApp.controller("CreateTeamController", function ($scope, $http, $rootScope,$rootScope) {	
	//  $scope.addedBallTypes = [];
	$scope.addedUserListIds = [];
    $scope.files = [];
    
    $scope.captain=$rootScope.loggedInUser.name;
    $scope.postCreateTeamData = function () {

        /*if ($scope.addedUserListIds.length < 11)
        {
            console.warn('You Should Add Minimum 11 Players');
        }*/       
    	var ballTypes="";
    	angular.forEach($scope.$parent.addedBallTypes,function(value,key){    		
    		if(key==0)
    	    {
    			//ballTypes=value.ballType;
    			ballTypes=value.ballId;
    		}
    		else
    		{
    			//ballTypes=ballTypes+","+value.ballType;
    			ballTypes=ballTypes+","+value.ballId;
    		}
    	});
    	
    	
    	var playerIds="";
    	angular.forEach($scope.addedUserListIds,function(value,key){
    		if(key==0)
    		{
    			playerIds=","+value.userId+",";
    		}
    		else
    	    {
    			playerIds+=value.userId+",";
    	    }
    	});
    	
    	var data = {        	
                name: $scope.name,            
                city:$scope.city,            
                area: $scope.area,
                captain: $rootScope.loggedInUser.userId,
                contactNo:$scope.contactNo,
                description:$scope.description,
                ballType:ballTypes,
                //managers:$scope.managers,
                pitchType:$scope.pitchType,
                followersUid:$scope.followersUid,
                pid:$scope.pid,
                status:false,
                players:playerIds
            }    	
        console.warn("I am Sending to Rest Server: " + angular.toJson(data));
        var config = {
            headers: {
                'Content-Type': 'application/json'
            }
        }


        $http.post('service/rest/team/createteam', data, config)
                .success(function (data, status, headers, config) {
                    $scope.PostDataResponse = data;
                    alert("Team Created Successfully");
                    /*$scope.name='';                               
                    $scope.city='';         
                    $scope.area='';
                    $scope.captain='';
                    $scope.contactNo='';
                    $scope.description='';
                    $scope.managers='';*/ 
                    $scope.submitted = false;
                })
                .error(function (data, status, header, config) {
                    $scope.ResponseDetails = "Data: " + data +
                            "<hr />status: " + status +
                            "<hr />headers: " + header +
                            "<hr />config: " + config;
                });
    };
});


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


teamApp.controller("EditTeamController", function ($scope,$http,$rootScope,$routeParams) {	

	/*$scope.userAlreadyLists=[
	                 {
	                	 userId:6,
	                	 authId:0,
	                	 name:"Marimuthu",
	                	 profileImageUrl:null,
	                	 gender:null,
	                	 phoneNo:null,
	                	 address:"no-1,Salem Street",
	                	 profileName:"Marimuthu",
	                	 battingStyle:"left hand",
	                	 bowlingStyle:"left hand",
	                	 bowlingType:"Medium",
	                	 email:"mari@gmail.com",
	                	 mobile:"2424",
	                	 state:null,
	                	 city:"Chennai",
	                	 area:"Medavakkam",
	                	 bowling:null,
	                	 batting:null,
	                	 friends:null,
	                	 status:null,
	                	 dob:"03-11-1970",
	                	 addedStatus:true
	                	}
	                 
	                 ];*/
	
		
}); 
	 
teamApp.controller('playerAutoCompleteCtrl', function ($scope, $http,$rootScope,$routeParams) {
    $scope.addedUserList = [];
    $scope.addedUserListIds = [];
    $scope.userList = {};
    //$scope.$parent.addedUserList = $scope.addedUserList;
    $scope.$parent.addedUserListIds = $scope.addedUserListIds;
    $scope.userAlreadyLists=$scope.$parent.userAlreadyLists;
    
   
    
    
$scope.userAlreadyLists=[];
	
	getmydata = function() {
	    return $http.get('service/rest/team/getTeamFullDetails?teamId=' + $routeParams.teamId)
	        .success(function(data) 
	        {
	        	$scope.team = data;
	            $scope.userAlreadyLists1=[];
	            angular.forEach($scope.team.playesDetailsList,function(value,key){
	        		//alert(angular.toJson(value));
	        		var user={
	        				 userId:value.userID,             	 
	                     	 name:value.userName,
	                     	 profileImageUrl:value.userImage,	     	                	
	                     	 addedStatus:true
	        		};
	        		$scope.userAlreadyLists1.push(user);
	        });
	});
	}

	// do the ajax call
	getmydata().then(function(data) {
		  $scope.userAlreadyLists=$scope.userAlreadyLists1;	
		  if(!angular.isUndefined($scope.userAlreadyLists))
		   {
	      angular.forEach($scope.userAlreadyLists,function(value,key){         
			  $scope.addedUserList.push(value);		 
			  var item = {};
	       item["userId"] =value.userId;
	       $scope.addedUserListIds.push(item);
	      });
	      }
		  
	});
	
 
	
    
	 $scope.updateTeam=function(){
		
		 var ballTypes="";
	    	angular.forEach($scope.ballTypes,function(value,key){    		
	    		if(key==0)
	    	    {
	    			ballTypes=value.ballType;
	    		}
	    		else
	    		{
	    			ballTypes=ballTypes+","+value.ballType;
	    		}
	    	});
	    	
	    	//alert(angular.toJson($scope.addedUserListIds));
	    	
	    	var playerIds="";
	    	angular.forEach($scope.addedUserListIds,function(value,key){
	    		if(key==0)
	    		{
	    			playerIds=","+value.userId+",";
	    		}
	    		else
	    	    {
	    			playerIds+=value.userId+",";
	    	    }
	    	});
	    	
	    	//alert("Update team3"+$scope.team.pitchType);
	    	
	    	var data = {   
	    			teamID:$scope.team.teamID,
	                name: $scope.team.name,            
	                city:$scope.team.city,            
	                area: $scope.team.area,
	                captain: $scope.team.captain,
	                contactNo:$scope.team.contactNo,
	                description:$scope.team.description,
	                ballType:ballTypes,
	                managers:$scope.team.managers,
	                pitchType:$scope.team.pitchType,
	                followersUid:$scope.team.followersUid,
	                pid:$scope.pid,
	                status:false,
	                players:playerIds,
	                createdBy:$rootScope.loggedInUser.userId
	            } 
	    	//alert(angular.toJson(data));	    	
	        console.warn("I am Sending to Rest Server: " + angular.toJson(data));
	        var config = {
	            headers: {
	                'Content-Type': 'application/json'
	            }
	        }


	        $http.post('service/rest/team/updateTeam', data, config)
	                .success(function (data, status, headers, config) {
	                    $scope.PostDataResponse = data;
	                    alert("Team Updated Successfully");
	                    /*$scope.name='';                               
	                    $scope.city='';         
	                    $scope.area='';
	                    $scope.captain='';
	                    $scope.contactNo='';
	                    $scope.description='';
	                    $scope.managers='';*/ 
	                    $scope.submitted = false;
	                })
	                .error(function (data, status, header, config) {
	                    $scope.ResponseDetails = "Data: " + data +
	                            "<hr />status: " + status +
	                            "<hr />headers: " + header +
	                            "<hr />config: " + config;
	                });
	    };		 
		 
	
        
    
    $scope.loadUser = function (stext) {    		
        if (stext == '')
        {
            $scope.userList = [];
            return;
        }
        $http.get('service/rest/user/getUserListsByName?searchText=' + stext).success(function (data, status, headers, config) {
            console.log(angular.toJson(data));        	
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
                //alert(angular.toJson($scope.userList[i]));
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


