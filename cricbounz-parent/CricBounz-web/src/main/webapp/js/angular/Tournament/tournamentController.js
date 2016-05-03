/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var tournamentApp = angular.module('tournamentModule', []);
tournamentApp.controller("CreateNewTourmentCtrl", function ($scope, $http) {
    $scope.postNewTournament = function () {    	
        var data = {
        name: $scope.name,
        registrationStartDate: $scope.regStartDate,
        registrationEndDate:$scope.regEndDate,
        tournamentStartDate: $scope.trmStartDate,
        tournamentEndDate:$scope.trmEndDate,        
        priceDetails: $scope.winPrizeDetails,       
        status:"",
        type:""
        }        
        
        /*var data = {
                name: $scope.name,  
                registrationStartDate: "",
    	        registrationEndDate:"",
    	        tournamentStartDate: "",
    	        tournamentEndDate:"",
                organizer:"aa",
                priceDetails: $scope.winPrizeDetails,
                winner:"1000",
                runner:"500",
                manOfTheSeries:"250",
                batsmanOfTheTournament:"",
                bowlerOfTheTournament:"",
                status:"",
                type:""
                }  */  	
    
        
       //alert(angular.toJson(data));
       //return;
       console.warn("I am posting to Rest Service: "+angular.toJson(data));
      
        var config = {
            headers: {
                'Content-Type': 'application/json'
            }
        }        
         
        $http.post('service/rest/tournament/create', data, config)
                .success(function (data, status, headers, config) {
                    $scope.PostDataResponse = data;
                    alert("Tournament Created Successfully");
                })
                .error(function (data, status, header, config) {
                    $scope.ResponseDetails = "Data: " + data +
                            "<hr />status: " + status +
                            "<hr />headers: " + header +
                            "<hr />config: " + config;
                });
    };
});

tournamentApp.controller("upcomingTourmentCtrl", function ($scope, $http,$filter) { 
	
    $http.get('service/rest/tournament/retrievetournamentlist?statusList=UPCOMING')
            .then(function (response) {
                $scope.upcomingTournamentList = response.data;
                //alert(angular.toJson($scope.upcomingTournamentList));
            });
    
    $scope.registerTournament=function(selectedTeam,tournamentId)
    {
    	if(angular.isUndefined(selectedTeam))
    	{
    	  alert("Select Your Team");
    	  return;
    	}
    	if(angular.isUndefined(selectedTeam.teamID))
    	{
    	  alert("Select Your Team");
    	  return;
    	}       
   var data = "teamId=" + selectedTeam.teamID+"&tournamentId="+tournamentId;					
 $http.post('service/rest/tournament/register', data, {
	headers : {
		'Content-Type' : 'application/x-www-form-urlencoded',
	}
}).success(function(data,response, status) {
	
	alert("Registered Successfully");
	
}).error(function(data, status) {
	console.debug("failed :" + status + " Data : " + data);

});


    	alert(selectedTeam.teamID);
    }
    
});


tournamentApp.controller("completedTourmentCtrl", function ($scope, $http,$filter) {	
    $http.get('service/rest/tournament/retrievetournamentlist?statusList=COMPLETED')
            .then(function (response) {
                $scope.completedTournamentList = response.data;
                //alert(angular.toJson($scope.upcomingTournamentList));
            });    
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
    $scope.dateformat="dd/MM/yyyy";
    $scope.today();
    $scope.showcalendar = function ($event) {
        $scope.showdp = true;
    };
    $scope.showdp = false;
});
