/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var groundApp = angular.module('groundModule', []);
groundApp.controller("CreateNewGroundCtrl", function ($scope, $http) {
	$scope.isSuccess=false;
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
      
        var ballIds='';       
        angular.forEach($scope.addedBallTypes, function(value,key){
        	if(key==0)
        	{
        		ballIds=value.ballId;
        	}
        	else
        	{
        		ballIds=ballIds+","+value.ballId;
        	}
        });
     
        var pitches='';
        angular.forEach(pitch, function(value,key){
        	if(key==0)
        	{
        		pitches=value.name;
        	}
        	else
        	{
        		pitches=pitches+","+value.name;
        	}
        });        
      
       // alert(angular.toJson($scope.city));
      //alert($scope.a);
        
        
        var data = {
            city: $scope.city,
            area: $scope.area,
            name: $scope.groundName,
            address: $scope.groundAddress,
            landmark: $scope.landMark,
            //manager: ,            
            contactno:$scope.contactno,
            balltype: ballIds,
            pitchtype: pitches,
            slotsList:$scope.slots
        };
        //alert(angular.toJson(data));
       //console.warn("create ground data: "+angular.toJson(data));
        //return;
        var config = {
            headers: {
                'Content-Type': 'application/json'
            }
        }

        $http.post('service/rest/ground/addground', data, config)
                .success(function (data, status, headers, config) {
                    $scope.PostDataResponse = data;
                    if($scope.PostDataResponse.responseStatus=="Success")
                    {                    	
                    	$scope.isSuccess=true;
                    }

                })
                .error(function (data, status, header, config) {
                    $scope.ResponseDetails = "Data: " + data +
                            "<hr />status: " + status +
                            "<hr />headers: " + header +
                            "<hr />config: " + config;
                });
    };
});


groundApp.controller("getGroundsByNameCtrl", function ($scope, $http) {	
	$scope.searchGround=function(searchText)
	{
		//alert(searchText);
		var url="service/rest/ground/getGroundsByName?searchText="+searchText;	
		$http.get(url)
	    .then(function (res) {
	        $scope.groundList= res.data;
	        console.log(angular.toJson($scope.groundList));
	        //alert(angular.toJson($scope.groundList));
	    });	
	}
});

groundApp.controller("ViewMyBookingCtrl", function ($scope, $http) {	
	var url="service/rest/ground/myBookingHistory";	
	$http.get(url)
    .then(function (res) {
        $scope.myBookings= res.data;
        console.log(angular.toJson($scope.myBookings));
        
    });	
});

groundApp.controller("viewGroundDetailCtrl", function ($scope, $http,$routeParams) {
	//alert($routeParams.groundId);
	//return;	
	var url="service/rest/ground/getgrounddetails?groundId="+$routeParams.groundId;	
	$http.get(url)
    .then(function (res) {
        $scope.groundDetail= res.data;
        console.log(angular.toJson($scope.groundDetail));
        
    });	
});



groundApp.controller("BookGroundCtrl", function ($scope, $http) {	
	
	$scope.bindGroundDetails=function(cityObj,areaObj)
	{		
		$http.get('service/rest/ground/getGrounds?city='+cityObj.city+'&area='+areaObj.area)
          .then(function (res) {
              $scope.grounds = res.data;
              console.log(angular.toJson($scope.grounds));
          });
	}

	
	$scope.getSlotDetails = function () {       
        if(angular.isUndefined($scope.selectedGround) && angular.isUndefined($scope.date))
        {
        	alert('Choose Ground and Date');
        	return;
        }
        if(angular.isUndefined($scope.selectedGround))
        {
        	alert('Ground  Is Required');
        	return;
        }
        if(angular.isUndefined($scope.date))
        {
        	alert('Date Is Required');
        	return;
        }
        if(angular.isUndefined($scope.selectedGround.groundId))
        {
        	alert('Choose Ground Properly');
        	return;
        }
       
        var date=$scope.date;	
        var groundId=$scope.selectedGround.groundId;
        
        var url='service/rest/ground/getavailableslots?groundId='+groundId+'&date='+date;
        
		console.log(url);		
		 $http.get(url).then(function (res) {
			  $scope.availableSlots=res.data;
		 });		
	}
	
	$scope.postBookGround = function () {    
	
		 /*var data = {        		
        		groundId:$scope.selectedGround.groundId,
        		dateOfPlay:$scope.date,
        		slotId:$scope.selectedSlot.slotId,        		
        		dateOfRequest:new Date(),
        		ballTypeId:$scope.selectBallId,
        		status:'booked',
        		teamAId:1,
        		teamBId:2,        		
        		bookedBy:5           
        };	*/
		
		if(angular.isUndefined($scope.selectedMyTeam))
		{
			alert("Select Your Team");
			return;
		}
		if(angular.isUndefined($scope.selectedOpponentTeam))
		{
			alert("Select Opponent Team");
			return;
		}
		
		if(angular.isUndefined($scope.selectedMyTeam.teamID))
		{
			alert("Select Your Team");
			return;
		}
		if(angular.isUndefined($scope.selectedOpponentTeam.teamID))
		{
			alert("Select Opponent Team");
			return;
		}
		if(angular.isUndefined($scope.selectedSlot))
		{
			alert("Select The Slot");
			return;
		}	
		
		var data = {        		
        		groundId:$scope.selectedGround.groundId,
        		playingDate:$scope.date,
        		slotId:$scope.selectedSlot.slotId,
        		ballTypeId:$scope.selectBallId,        		
        		myTeam:$scope.selectedMyTeam.teamID,
        		opponentTeam:$scope.selectedOpponentTeam.teamID
        };
		
        alert("pasted Data:"+angular.toJson(data));      
             
        var config = {
            headers: {
                'Content-Type': 'application/json'
            }
        }

        $http.post('service/rest/ground/addgroundbookingdetails', data, config)
                .success(function (data, status, headers, config) {
                    $scope.PostDataResponse = data;
                    alert('Ground Booked Succesfully');
                })
                .error(function (data, status, header, config) {
                    $scope.ResponseDetails = "Data: " + data +
                            "<hr />status: " + status +
                            "<hr />headers: " + header +
                            "<hr />config: " + config;
                    alert('failed');
                });
    };
});