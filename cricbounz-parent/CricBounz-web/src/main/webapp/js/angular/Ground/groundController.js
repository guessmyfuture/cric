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
        
        var data = {
            city: $scope.city.cityName,
            area: $scope.area,
            name: $scope.groundName,
            address: $scope.groundAddress,
            landmark: $scope.landMark,
            manager: $scope.manager,            
            contactno:$scope.contactno,
            balltype: ballIds,
            pitchtype: pitches,
            groundSlotsList:$scope.slots
        };
       
       console.warn("hit the servicer: "+angular.toJson(data));
        
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

groundApp.controller("BookGroundCtrl", function ($scope, $http) {	
	
	$scope.getSlotDetails = function () {
		//alert(angular.toJson($scope.selectedGround));
		var ground=$scope.selectedGround;
		var grounId=ground.groundId;
        var date=$scope.date;		
		var url='service/rest/ground/getavailableslots?groundId='+ground.groundId+'&date='+date;
		alert(url);
		 $http.get(url).then(function (res) {
			  alert(res.data);
		 });		
	}
	
	$scope.postBookGround = function () {      
		alert("postBookGround");
        var data = {        		
        		groundId:'',
        		date:new Date,
        		slotId:23,
        		status:'true',
        		dateOfRequest:new Date(),
        		teamAId:1,
        		teamBId:2,
        		ballTypeId:3,
        		bookedBy:5           
        };
      
        var config = {
            headers: {
                'Content-Type': 'application/json'
            }
        }

        $http.post('service/rest/ground/addgroundbookingdetails', data, config)
                .success(function (data, status, headers, config) {
                    $scope.PostDataResponse = data;
                    alert('sucesss');

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