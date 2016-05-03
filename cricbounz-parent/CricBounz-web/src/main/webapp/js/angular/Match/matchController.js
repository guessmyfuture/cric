/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var matchApp = angular.module('matchModule', []);
matchApp.controller('matchCtrl', function ($scope, $http) {
  $scope.createMatch=function()
  {	  
	  var groundName="";
      if (angular.isUndefined($scope.selectedTeamA))
      {
    	  alert("please select Team-A");
    	  return;
      }
      if (angular.isUndefined($scope.selectedTeamA.teamID))
      {
    	  alert("please select Team-A");
    	  return;
      }
      if (angular.isUndefined($scope.selectedTeamB))
      {
    	  alert("please select Team-B");
    	  return;
      }
      if (angular.isUndefined($scope.selectedTeamB.teamID))
      {
    	  alert("please select Team-B");
    	  return;
      }
      if($scope.selectedTeamA.teamID==$scope.selectedTeamB.teamID)
      {
        alert("You Should Not Choose Opponent Team As Same");
        return;
      }
      if (angular.isUndefined($scope.selectedScorer))
      {
    	  alert("please select Scorer");
    	  return;
      }
      if (angular.isUndefined($scope.selectedScorer.userId))
      {
    	  alert("please select Scorer");
    	  return;
      }
      /*if (angular.isUndefined($scope.selectedVenue.groundId))
      {
    	  alert("Venue Name Is Required");
    	  return; 
      }*/
      if (angular.isUndefined($scope.selectedVenue))
      {
    	  groundName=$scope.selectedVenue;    	
      }
      else
      {
    	  groundName=$scope.selectedVenue.name;   	  
      }
      
    
      
	 /* match={
			 TeamAId:$scope.selectedTeamA.teamID,
			 TeamBId:$scope.selectedTeamB.teamID,
			 scorer:$scope.selectedScorer,
			 venue:$scope.venue,
			 overs:$scope.overs,
			 ballTypes:$scope.addedBallTypes,
			 pitch:pitchText
	  };*/	  
      
	  matchData={	    
		teamAId:$scope.selectedTeamA.teamID,
		teamBId:$scope.selectedTeamB.teamID,
		venue:groundName,
		//overs:$scope.overs,
		ballType:$scope.ballType,	
		scorer:$scope.selectedScorer.userId,
		pitchType:$scope.pitchType
	  }
	  
	  var config = {
	            headers: {
	                'Content-Type': 'application/json'
	            }
	        }
	        $http.post('service/rest/match/createMatch', matchData, config)
	                .success(function (data, status, headers, config) {
	                    $scope.PostDataResponse = data;
	                    alert("New Match Created Successfully");
	                  
	                    $scope.submitted = false;
	                })
	                .error(function (data, status, header, config) {
	                    $scope.ResponseDetails = "Data: " + data +
	                            "<hr />status: " + status +
	                            "<hr />headers: " + header +
	                            "<hr />config: " + config;
	                });    
	
  }
  
  $scope.requestMatch=function(myTeamId,opponentTeamId,matchDate,matchStart,matchEnd,teamObj)
  {	  
	  if(myTeamId==opponentTeamId)
      {
	   alert("Please Select Opponent Team Differnt One");
	   return;
	  }
	  
	  /*matchRequestData={
				//requestStatus:
				//requestedByID;
				requestedByTeam:myTeamId,
			   requestedToTeam:opponentTeamId,
			   requestedDate:
			   opponentTeamApprovalCount:
			    matchDate:
			    matchStartTime:
			    matchEndTime:
			    status;
			  }*/
	  
	  var matchRequestData={
			   requestedByTeam:myTeamId,
			   requestedToTeam:opponentTeamId,			   			  
			   transientmatchDate:matchDate,
			   matchStartTime:matchStart,
			   matchEndTime:matchEnd			   
			  }			 
	  console.log(angular.toJson(matchRequestData));
			  var config = {
			            headers: {
			                'Content-Type': 'application/json'
			            }
			        }
			        $http.post('service/rest/request/savematchreq', matchRequestData, config)
			                .success(function (data, status, headers, config) {
			                    $scope.PostDataResponse = data;
			                    alert("Match Request Sent");
			                    teamObj.matchRequestText="Request Sent";
			                    teamObj.isSent=true;
			                    teamObj.isMatchRequest=false;
			                    $scope.submitted = false;
			                })
			                .error(function (data, status, header, config) {
			                    $scope.ResponseDetails = "Data: " + data +
			                            "<hr />status: " + status +
			                            "<hr />headers: " + header +
			                            "<hr />config: " + config;
			                });    
			
	  
	  
	  //alert('match Request'+myTeamId);
  }
});

