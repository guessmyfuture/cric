//var dbApp = angular.module('dashboardModule', ['infinite-scroll']);
//var dbApp = angular.module("CricApp", ["dashboardModule", "teamModule", "groundModule", "tournamentModule", "file-model", "userModule", "jkuri.timepicker", "scoreModule", "AxelSoft", "ngRoute", "angular-contextual-date"]);


var dbApp = angular.module('dashboardModule', ['infinite-scroll']);
var dbApp = angular.module("CricApp", ["dashboardModule","teamModule", "groundModule", "tournamentModule", "file-model", "userModule", "jkuri.timepicker", "scoreModule", "AxelSoft", "ngRoute", "angular-contextual-date","ui.router","ui.bootstrap","jkuri.gallery"]);

function getCookie(name) {
    var value = "; " + document.cookie;
    var parts = value.split("; " + name + "=");
    if (parts.length == 2)
    {
        return parts.pop().split(";").shift();
    }
}


/*
 * dbApp.config(function ($stateProvider) { $stateProvider /*.state("state1", {
 * url: "/url1", controller: "FirstController", views: { view1: {templateUrl:
 * "templates/template1.html"}, view2: {templateUrl:
 * "templates/template2.html"}, view3: {templateUrl: "templates/template3.html"} } })
 */  
		   /*
			 * .state("a", { url: "/home", templateUrl: "partials/content.html" })
			 * .state("career-records", { url: "/career-records", templateUrl:
			 * "CareerRecords.html" }) .state("create-team", { url:
			 * "/create-team", templateUrl: "CreateTeam.html" })
			 * .state('view-team', { url:'/view-team', templateUrl:
			 * 'ViewTeam.html' }) .state('create-tournament', {
			 * url:'/create-tournament', templateUrl: 'CreateTournament.html'
			 *  }) .state('upcoming-tournaments', { url:'/upcoming-tournaments',
			 * templateUrl: 'UpcomingTournaments.html' })
			 * 
			 * .state('view-profile', { url:'/view-profile', templateUrl:
			 * 'ViewProfile.html' })
			 * 
			 * .state('edit-profile', { url:'/edit-profile', templateUrl:
			 * 'EditProfile.html' })
			 * 
			 * .state('book-ground', { url:'/book-ground', templateUrl:
			 * 'BookGround.html' })
			 * 
			 * .state('add-new-ground', { url:'/add-new-ground', templateUrl:
			 * 'AddNewGround.html' })
			 * 
			 * .state('request-match', { url:'/request-match', templateUrl:
			 * 'RequestMatch.html' }) .state('match-details', {
			 * url:'/match-details', templateUrl: 'MatchDetails.html' })
			 * 
			 * .state('friends', { url:'/friends', templateUrl: 'Friends.html' })
			 * .state('my-teams', { url:'/my-teams', templateUrl: 'MyTeams.html' })
			 * .state('schelduled-matches', { url:'/schelduled-matches',
			 * templateUrl: 'SchelduledMatches.html' })
			 * .state('completed-matches', { url:'/completed-matches',
			 * templateUrl: 'CompletedMatches.html' }) .state('view-bookings', {
			 * url:'/view-bookings', templateUrl: 'ViewBookings.html' })
			 * 
			 * });
			 */


dbApp.config(function ($routeProvider) {
    $routeProvider
            // route for the home page
            .when('/', {
                templateUrl: 'partials/content.html',
                css: 'css/tab_pane1.css'
            })
            // route for the Career Records
            .when('/career-records', {
                templateUrl: 'CareerRecords.html'
                        // controller: 'aboutController'
            })
            // route for the Create Team
            .when('/create-team', {
                templateUrl: 'CreateTeam.html'
                        // controller: 'aboutController'
            })
            // route for the View Teams
            .when('/view-team', {
                templateUrl: 'ViewTeam.html'
                        // controller: 'aboutController'
            })
            // route for the Create New Tournamnet
            .when('/create_tournament', {
                templateUrl: 'CreateTournament.html'
                        // controller: 'tournamnetCtrl'
            })
            // route for the Create New Tournamnet
            .when('/upcoming_tournaments', {
                templateUrl: 'UpcomingTournaments.html'
                        // controller: 'UpcomingTournamentsCtrl'
            })
            // route for the View Profile
            .when('/view_profile', {
                templateUrl: 'ViewProfile.html'
                        // controller: 'UpcomingTournamentsCtrl'
            })
            // route for the View Profile
            .when('/edit_profile', {
                templateUrl: 'EditProfile.html'
                        // controller: 'UpcomingTournamentsCtrl'
            })

            // route for the Book New Ground
            .when('/book_ground', {
                templateUrl: 'BookGround.html'
                        // controller: 'UpcomingTournamentsCtrl'
            })
            // route for the Book New Ground
            .when('/add_new_ground', {
                templateUrl: 'AddNewGround.html'
                        // controller: 'UpcomingTournamentsCtrl'
            })
            // route for the Request Match
            .when('/request_match', {
                templateUrl: 'RequestMatch.html'
                        // controller: 'UpcomingTournamentsCtrl'
            })
            // route for the Request Match
            .when('/match_details', {
                templateUrl: 'MatchDetails.html'
                        // controller: 'UpcomingTournamentsCtrl'
            })
            // /next changes by kavi

            // route for the Request Match
            .when('/friends', {
                templateUrl: 'Friends.html'
                        // controller: 'UpcomingTournamentsCtrl'
            })
            .when('/my_teams', {
                templateUrl: 'MyTeams.html'
                        // controller: 'UpcomingTournamentsCtrl'
            })
            .when('/schelduled_matches', {
                templateUrl: 'SchelduledMatches.html'
                        // controller: 'UpcomingTournamentsCtrl'
            })
            .when('/completed_matches', {
                templateUrl: 'CompletedMatches.html'
                        // controller: 'UpcomingTournamentsCtrl'
            })
            .when('/view_bookings', {
                templateUrl: 'ViewBookings.html'
               // controller: 'UpcomingTournamentsCtrl'
            })
            // route for the Player(User) Profile
            .when('/user_profile/:userId', {
                templateUrl: 'UserProfile.html',
                controller: 'viewMyTeamCtrl'
            })
             // route for the Player(User) Profile
            .when('/detail_team_view/:teamId', {
                templateUrl: 'TeamDetailView.html',
                controller: 'detailTeamViewCtrl'
            })
            // route for the Player(User) Profile
            .when('/user_profile/:userId', {
                templateUrl: 'UserDetailProfile.html',
                controller: 'viewUserProfileCtrl'
            })
            .otherwise({
                redirectTo: '/'
              });
            // $locationProvider.html5Mode(true);
}).run(function ($rootScope,$http) {       
	/*
	 * $http.get('service/rest/user/getcurrentuser') .then(function (res) {
	 * $rootScope.currentUser=res.data; });
	 */	
    });

dbApp.controller('dateController', function ($scope) {
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




dbApp.directive('enterSubmit', function () {
    return {
        restrict: 'A',
        link: function (scope, elem, attrs) {

            elem.bind('keydown', function (event) {
                var code = event.keyCode || event.which;

                if (code === 13) {
                    if (!event.shiftKey) {
                        event.preventDefault();
                        scope.$apply(attrs.enterSubmit);
                    }
                }
            });
        }
    }
});


dbApp.directive('checkImage', function($http) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            attrs.$observe('ngSrc', function(ngSrc) {
                $http.get(ngSrc).success(function(){
                    // alert('image exist');
                }).error(function(){
                    // alert('image not exist');
                    element.attr('src', 'images/default_user.png'); // set
																	// default
																	// image
                });
            });
        }
    };
});

dbApp.directive('fileBrowseButton', function () {
    return {
        link: function (scope, element, attributes) {

            var el = angular.element(element)
            var button = el.children()[0]

            el.css({
                position: 'relative',
                overflow: 'hidden',
                width: button.offsetWidth,
                height: button.offsetHeight
            })

            var fileInput = angular.element('<input type="file" multiple />')
            fileInput.css({
                position: 'absolute',
                top: 0,
                left: 0,
                'z-index': '2',
                width: '100%',
                height: '100%',
                opacity: '0',
                cursor: 'pointer'
            })
            el.append(fileInput)
        }
    }
})


/* image File Upload Concept */
dbApp.directive('ngFiles', ['$parse', function ($parse) {
        function fn_link(scope, element, attrs) {
            var onChange = $parse(attrs.ngFiles);
            element.on('change', function (event) {
                onChange(scope, {$files: event.target.files});
            });
        }
        ;
        return {
            link: fn_link
        }
    }]);
dbApp.controller('ImageUploadMultipleCtrl', function ($scope, $http) {
    $scope.fileList = [];
    $scope.curFile;
    $scope.ImageProperty = {
        file: ''
    }
    var formdata = new FormData();
    $scope.getTheFiles = function ($files) {
        angular.forEach($files, function (value, key) {
            formdata.append(key, value);
        });
    };

    // NOW UPLOAD THE FILES.
    $scope.uploadFiles = function () {
        var request = {
            method: 'POST',
            url: '/api/fileupload/',
            data: formdata,
            headers: {
                'Content-Type': undefined
            }
        };
        // SEND THE FILES.
        $http(request)
                .success(function (d) {
                    alert("fileUpload" + d);
                })
                .error(function () {
                });
    }

    $scope.setFile = function (element) {
        // get the files
        var files = element.files;
        for (var i = 0; i < files.length; i++) {
            $scope.ImageProperty.file = files[i];
            var reader = new FileReader();
            reader.onload = $scope.imageIsLoaded;
            reader.readAsDataURL(files[i]);
            $scope.$apply();
        }
    }
    $scope.imageIsLoaded = function (e) {
        $scope.$apply(function () {
            $scope.fileList.push($scope.ImageProperty);
            $scope.ImageProperty.imageData = e.target.result;
            $scope.ImageProperty.caption = $scope.caption;
            $scope.ImageProperty = {};
        });
    }
    $scope.removeFile = function (index) {
        $scope.fileList.splice(index, 1);
    }
});

dbApp.controller('videoUploadCtrl', function ($scope, $http) {
    $scope.fileList = [];
    $scope.curFile;
    $scope.ImageProperty = {
        file: ''
    }
    var formdata = new FormData();
    $scope.getTheFiles = function ($files) {
        angular.forEach($files, function (value, key) {
            formdata.append(key, value);
        });
    };

    // NOW UPLOAD THE FILES.
    $scope.uploadFiles = function () {
        var request = {
            method: 'POST',
            url: '/api/fileupload/',
            data: formdata,
            headers: {
                'Content-Type': undefined
            }
        };
        // SEND THE FILES.
        $http(request)
                .success(function (d) {
                    alert(d);
                })
                .error(function () {
                });
    }

    $scope.setFile = function (element) {
        // get the files
        var files = element.files;
        for (var i = 0; i < files.length; i++) {
            $scope.ImageProperty.file = files[i];
            var reader = new FileReader();
            reader.onload = $scope.imageIsLoaded;
            reader.readAsDataURL(files[i]);
            $scope.$apply();
        }
    }
    $scope.imageIsLoaded = function (e) {
        $scope.$apply(function () {
            $scope.fileList.push($scope.ImageProperty);
            $scope.ImageProperty.imageData = e.target.result;
            $scope.ImageProperty.caption = $scope.caption;
            $scope.ImageProperty = {};
        });
    }
    $scope.removeFile = function (index) {
        $scope.fileList.splice(index, 1);
    }
});


/*
 * dbApp.controller('ImageUploadMultipleCtrl', function ($scope) {
 * 
 * $scope.fileList = []; $scope.curFile; $scope.ImageProperty = { file: '' }
 * 
 * $scope.setFile = function (element) { // get the files var files =
 * element.files; for (var i = 0; i < files.length; i++) {
 * $scope.ImageProperty.file = files[i]; var reader = new FileReader();
 * reader.onload = $scope.imageIsLoaded; reader.readAsDataURL(files[i]);
 * $scope.$apply(); } } $scope.imageIsLoaded = function (e) {
 * $scope.$apply(function () { $scope.fileList.push($scope.ImageProperty);
 * $scope.ImageProperty.imageData = e.target.result;
 * $scope.ImageProperty.caption=$scope.caption; $scope.ImageProperty = {}; }); }
 * $scope.removeFile = function (index) { $scope.fileList.splice(index, 1); }
 * 
 * $scope.UploadFile = function () {
 * 
 * 
 * 
 * 
 * 
 * 
 * //upload files individually /*for (var i = 0; i < $scope.fileList.length;
 * i++) {
 * 
 * $scope.UploadFileIndividual($scope.fileList[i].file,
 * $scope.fileList[i].file.name, $scope.fileList[i].file.type,
 * $scope.fileList[i].file.size, i); }
 */

/*
 * }
 * 
 * $scope.UploadFileIndividual = function (fileToUpload, name, type, size,
 * index) { //Create XMLHttpRequest Object var reqObj = new XMLHttpRequest();
 * //event Handler reqObj.upload.addEventListener("progress", uploadProgress,
 * false); reqObj.addEventListener("load", uploadComplete, false);
 * reqObj.addEventListener("error", uploadFailed, false);
 * reqObj.addEventListener("abort", uploadCanceled, false);
 * 
 * //open the object and set method of call(get/post), url to call,
 * isasynchronous(true/False) reqObj.open("POST", "/FileUpload/UploadFiles",
 * true);
 * 
 * //set Content-Type at request header.For file upload it's value must be
 * multipart/form-data reqObj.setRequestHeader("Content-Type",
 * "multipart/form-data");
 * 
 * //Set Other header like file name,size and type
 * reqObj.setRequestHeader('X-File-Name', name);
 * reqObj.setRequestHeader('X-File-Type', type);
 * reqObj.setRequestHeader('X-File-Size', size);
 *  // send the file reqObj.send(fileToUpload);
 * 
 * function uploadProgress(evt) { if (evt.lengthComputable) { var
 * uploadProgressCount = Math.round(evt.loaded * 100 / evt.total);
 * document.getElementById('P' + index).innerHTML = uploadProgressCount; if
 * (uploadProgressCount == 100) { document.getElementById('P' + index).innerHTML = '<i
 * class="fa fa-refresh fa-spin" style="color:maroon;"></i>'; } } }
 * 
 * function uploadComplete(evt) { /* This event is raised when the server back a
 * response
 */
/*
 * document.getElementById('P' + index).innerHTML = 'Saved';
 * $scope.NoOfFileSaved++; $scope.$apply();
 */
/*
 * }
 * 
 * function uploadFailed(evt) { document.getElementById('P' + index).innerHTML =
 * 'Upload Failed..'; }
 * 
 * function uploadCanceled(evt) { document.getElementById('P' + index).innerHTML =
 * 'Canceled....'; } } });
 */

dbApp.directive('validNumber', function () {
    return {
        require: '?ngModel',
        link: function (scope, element, attrs, ngModelCtrl) {
            if (!ngModelCtrl) {
                return;
            }

            ngModelCtrl.$parsers.push(function (val) {
                if (angular.isUndefined(val)) {
                    var val = '';
                }
                var clean = val.replace(/[^0-9]+/g, '');
                if (val !== clean) {
                    ngModelCtrl.$setViewValue(clean);
                    ngModelCtrl.$render();
                }
                return clean;
            });

            element.bind('keypress', function (event) {
                if (event.keyCode === 32) {
                    event.preventDefault();
                }
            });
        }
    };
});

dbApp.filter('isEmpty', function () {
    var bar;
    return function (obj) {
        for (bar in obj) {
            if (obj.hasOwnProperty(bar)) {
                return false;
            }
        }
        return true;
    };
});
dbApp.directive('datePicker', function () {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            $(element).datepicker({
                autoclose: true,
                todayHighlight: true
            }).datepicker('update', new Date());
        }
    };
});

dbApp.controller('TodoCtrl', function ($scope, $http) {
    $http.get('response/activity.jsp')
            .then(function (res) {
                $scope.activities = res.data;
            });
    /*
	 * $scope.loadContentArea = function($scope, $http){
	 * 
	 * var myEl = angular.element( document.querySelector( '#content' ) );
	 * myEl.html('<p>test</p>') }
	 */
});

dbApp.controller('loadCity', function ($scope, $http) {
    $http.get('json/cityList.json')
            .then(function (res) {
                $scope.cityList = res.data;
                console.log(angular.toJson($scope.cityList));
            });
    
    $scope.changeCity=function()
    {
    	alert('jai');
    }
    $scope.changeArea=function()
    {
    	alert('jai');
    }
});
dbApp.controller('loadArea', function ($scope, $http) {
    $http.get('json/areaList.json')
            .then(function (res) {
                $scope.areaList = res.data;
                console.log(angular.toJson($scope.areaList));
            });
});
dbApp.controller('loadGrounds', function ($scope, $http) {
    $http.get('service/rest/ground/getallgrounds')
            .then(function (res) {
                $scope.grounds = res.data;
                alert(angular.toJson($scope.grounds));
                console.log(angular.toJson($scope.grounds));
            });
});


// var to use as a flag to prevent http requests from happening when one is
// already occuring
var infinite_loading = false;

/*
 * Create custom factory for the dynamic loading
 */
dbApp.factory('PostImages', function ($http) {
    /*
	 * load Load in the press releases
	 */
    var load = function (full_url, last_loaded_url) {
        infinite_loading = true;
        return $http({method: "GET", url: full_url}).then(function (result) {
            return result.data;
        });
    };

    return {load: load};
});


dbApp.factory('serverTimeAsyncService', function ($http) {
    return {
        getServerDateTime: function () {
            // since $http.get returns a promise,
            // and promise.then() also returns a promise
            // that resolves to whatever value is returned in it's
            // callback argument, we can return that.
            return $http.get('rest/gettime/').then(function (result) {
                return result.data;
            });
        }
    }
}); 

/**
 * Dashboard & Lazy Loading Controller
 */
dbApp.controller('dashBoardCtrl', ['$scope', '$http','$rootScope','PostImages', 'contextualDateService', 'serverTimeAsyncService', function ($scope, $http,$rootScope,PostImages, contextualDateService, serverTimeAsyncService)
    {	
	
       // establish vars
        $scope.postedData = [];
        $scope.currentLikeList = [];
        $scope.limit = 5;
        $scope.offset = 0;
        /* flag to see if we hit the end of the json feed */
        $scope.more_items = true;
        /* Time Stamp like Just Now,2-monutes Ago */
        $scope.openedDocAt = null;
        $scope.docWrittenAt = null;
        $scope.authorBirth = null;
        $scope.examples = [];  
        
        // $scope.currentComments=[];
        
       
        /*
		 * $http.get('service/rest/user/getcurrentuser') .then(function (res) {
		 * $scope.user=res.data; });
		 */        
        
        $scope.postUserPost = function () {
        
           /*
			 * var data = { postedUserId: "1000", postedUserName: "Sachin
			 * Tendulkar", postedUserImageUrl: "images/member.jpg", postContent:
			 * $scope.statusMessage, postedPictures: [ /* { imageId: 1,
			 * imageCaptionText: "hi my Caption1", postImageUrl:
			 * "images/post/im1.jpg" }, { imageId: 2, imageCaptionText: "hi my
			 * Caption2", postImageUrl: "images/post/im3.jpg" }, { imageId: 3,
			 * imageCaptionText: "hi my Caption3", postImageUrl:
			 * "images/post/im2.jpg" }, { imageId: 4, imageCaptionText: "hi my
			 * Caption3", postImageUrl: "images/post/im4.jpg" }, { imageId: 5,
			 * imageCaptionText: "hi my Caption1", postImageUrl:
			 * "images/post/im1.jpg" }, { imageId: 6, imageCaptionText: "hi my
			 * Caption2", postImageUrl: "images/post/im3.jpg" }
			 */
                             /*
								 * ], likes: [], comments: [], shares: null,
								 * postedType: "public" }
								 */
                    
                    
        	$scope.data ={
        	     postedUserImageUrl:"images/post/iuseid1.jpg",
        		 postedContent: $scope.statusMessage,        		 
        		 postedPictures:["images/post/im1.jpg","images/post/im2.jpg"],
        		 likedById:"",
        		 postedType:"Public",
        		 imageCaption:"User Photos"        		
        		} 


            console.warn("I am Sending to Rest Server: " + angular.toJson($scope.data));
            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            }

            $http.post('service/rest/user/savepost', $scope.data, config)
                    .success(function (data, status, headers, config) {
                       $scope.postedData.splice(0, 0,data);
                       // alert(angular.toJson(data));
                      // $scope.postedData=data;
                    	 // alert(angular.toJson($scope.postedData));
                    })
                    .error(function (data, status, header, config) {
                        $scope.ResponseDetails = "Data: " + data +
                                "<hr />status: " + status +
                                "<hr />headers: " + header +
                                "<hr />config: " + config;
                    });
        };
        
      
        
        $scope.likeUpdate = function (postId)
        {  
            $scope.postId = postId;         
            var data = {             
                postId: $scope.postId               
            };
            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            }           
              
            $http.post('service/rest/user/likeandunlike/', data, config)
                    .success(function (data, status, headers, config) { 
                    	var user=$rootScope.currentUser;
                		var uid=user.userId;
                		var uname=user.name;
                		var imageUrl=user.profileImageUrl; 
                		
                    	if(data)
                    	{	                    		
                    		var obj={
                    				userID:uid,
                    				userName:uname,
                    				likedUserImage:imageUrl
                    		  };                    		
                    		 $scope.currentLikeList.splice(0, 0, obj);                    		 
                    	}       
                    	else
                    	{
                   	   	angular.forEach($scope.currentLikeList,function(value,key){                   			 
                   			if(value.userID==uid)
                   			{  
                   				$scope.currentLikeList.splice(key, 1);                    				
                   			}
                   		});                   	    
                      	}  
                    	
                    	    	
                    })
                    .error(function (data, status, header, config) {
                        $scope.ResponseDetails = "Data: " + data +
                                "<hr />status: " + status +
                                "<hr />headers: " + header +
                                "<hr />config: " + config;
                    });          
        }

        
        $scope.updateShare = function (postId,sharedComment,sharedType)
        {	 
        	var data={
        	  postId:postId,
        	  sharedById:"3",
        	  sharedType:sharedType,
        	  sharedConetnt:sharedComment,
        	  timestamp:new Date(),
        	  status:"A"
        	}  
        	//alert(angular.toJson(data));
        	
        	  var config = {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }
        	
        	
        	  $http.post('service/rest/user/savesharedetail', data, config)
              .success(function (data, status, headers, config) {   
            	  if(data.responseStatus)
                  {
                    alert("Post shared Sucessfully");
                  }
              })
              .error(function (data, status, header, config) {
                  $scope.ResponseDetails = "Data: " + data +
                          "<hr />status: " + status +
                          "<hr />headers: " + header +
                          "<hr />config: " + config;
              });
        	
        }
        
        
        $scope.updateComment = function (postId, myComment)
        {        	
        
            /*
			 * var data = { commentId: "1", postId: postId, userId: commentedBy,
			 * commentedBy: commentedBy, userImageUrl: "images/post/img3.jpg",
			 * message: myComment, isActive: true }
			 */
        	
        	var user=$rootScope.currentUser;
    		var uid=user.userId;
    		var uname=user.name;
    		var imageUrl=user.profileImageUrl;     
    	
        	var data = {                   
                    postId: postId,                                   
                    content: myComment,
                    commentedById:uid,
        			commentedByImage:imageUrl
                }

            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            }
            $http.post('service/rest/user/savecomment', data, config)
                    .success(function (data, status, headers, config) {                                             
                        $scope.currentComments.splice(0, 0, data);
                    })
                    .error(function (data, status, header, config) {
                        $scope.ResponseDetails = "Data: " + data +
                                "<hr />status: " + status +
                                "<hr />headers: " + header +
                                "<hr />config: " + config;
                    });
        }        
     
        
        /**
		 * Lazy Loading loadMore Adjust the offset using the limit to add X
		 * number of items to the list
		 */
        $scope.loadItems = function () {
           // make sure there are more items to load
            if ($scope.more_items == true && infinite_loading == false) {
            // var url = 'response/UserPosts.jsp?limit=' + $scope.limit +
			// '&offset=' + $scope.offset;
            	// alert("limit "+$scope.limit+" "+"offset "+ $scope.offset);
            	 // var url = 'service/rest/user/getPostDetails?limit=' + 2 +
					// '&offset=' +$scope.offset;
            	var url = 'service/rest/user/getPostDetails?limit=' + $scope.limit+ '&offset=' +$scope.offset;         	
            	
            	 // load the press releases
                var getPostImages = PostImages.load(url, $scope.last_loaded_url);
                // this is only run after $http completes
                getPostImages.then(function (result) {
                    // we finished loading, set the flag back
                    infinite_loading = false;
                    // check if there were any result items in the latest feed
                    if (result.length == 0) {
                        $scope.more_items = false;
                    } else {
                        // result
                        $scope.postedData = $scope.postedData.concat(result);
                        
                        angular.forEach($scope.postedData,function(value,key){ 
                        	value.postedImagesJson=[];
                        	for(i=0;i<value.postedPictures.length;i++)
                        	{                        		
                            	var obj={
                            			img:value.postedPictures[i]
                            	}
                            	value.postedImagesJson.push(obj);
                            	
                        	}                        	
                        });
                        
                        console.log("Posted Data :"+angular.toJson($scope.postedData));
                        
                    }

                    // increment the offset for next time loadMore() is called
                    $scope.offset = $scope.limit + $scope.offset;
                    // update the last loaded url
                    $scope.last_loaded_url = url;
                });
            }
        }
    }]);
/**
 * ng-infinite-scroll - v1.2.0 - 2014-12-02
 */
var mod;
mod = angular.module("infinite-scroll", []), mod.value("THROTTLE_MILLISECONDS", null), mod.directive("infiniteScroll", ["$rootScope", "$window", "$interval", "THROTTLE_MILLISECONDS", function (a, b, c, d) {
        return {scope: {infiniteScroll: "&", infiniteScrollContainer: "=", infiniteScrollDistance: "=", infiniteScrollDisabled: "=", infiniteScrollUseDocumentBottom: "="}, link: function (e, f, g) {
                var h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x;
                return x = angular.element(b), t = null, u = null, i = null, j = null, q = !0, w = !1, p = function (a) {
                    return a = a[0] || a, isNaN(a.offsetHeight) ? a.document.documentElement.clientHeight : a.offsetHeight
                }, r = function (a) {
                    return a[0].getBoundingClientRect && !a.css("none") ? a[0].getBoundingClientRect().top + s(a) : void 0
                }, s = function (a) {
                    return a = a[0] || a, isNaN(window.pageYOffset) ? a.document.documentElement.scrollTop : a.ownerDocument.defaultView.pageYOffset
                }, o = function () {
                    var b, c, d, g, h;
                    return j === x ? (b = p(j) + s(j[0].document.documentElement), d = r(f) + p(f)) : (b = p(j), c = 0, void 0 !== r(j) && (c = r(j)), d = r(f) - c + p(f)), w && (d = p((f[0].ownerDocument || f[0].document).documentElement)), g = d - b, h = g <= p(j) * t + 1, h ? (i = !0, u ? e.$$phase || a.$$phase ? e.infiniteScroll() : e.$apply(e.infiniteScroll) : void 0) : i = !1
                }, v = function (a, b) {
                    var d, e, f;
                    return f = null, e = 0, d = function () {
                        var b;
                        return e = (new Date).getTime(), c.cancel(f), f = null, a.call(), b = null
                    }, function () {
                        var g, h;
                        return g = (new Date).getTime(), h = b - (g - e), 0 >= h ? (clearTimeout(f), c.cancel(f), f = null, e = g, a.call()) : f ? void 0 : f = c(d, h, 1)
                    }
                }, null != d && (o = v(o, d)), e.$on("$destroy", function () {
                    return j.unbind("scroll", o)
                }), m = function (a) {
                    return t = parseFloat(a) || 0
                }, e.$watch("infiniteScrollDistance", m), m(e.infiniteScrollDistance), l = function (a) {
                    return u = !a, u && i ? (i = !1, o()) : void 0
                }, e.$watch("infiniteScrollDisabled", l), l(e.infiniteScrollDisabled), n = function (a) {
                    return w = a
                }, e.$watch("infiniteScrollUseDocumentBottom", n), n(e.infiniteScrollUseDocumentBottom), h = function (a) {
                    return null != j && j.unbind("scroll", o), j = a, null != a ? j.bind("scroll", o) : void 0
                }, h(x), k = function (a) {
                    if (null != a && 0 !== a.length) {
                        if (a instanceof HTMLElement ? a = angular.element(a) : "function" == typeof a.append ? a = angular.element(a[a.length - 1]) : "string" == typeof a && (a = angular.element(document.querySelector(a))), null != a)
                            return h(a);
                        throw new Exception("invalid infinite-scroll-container attribute.")
                    }
                }, e.$watch("infiniteScrollContainer", k), k(e.infiniteScrollContainer || []), null != g.infiniteScrollParent && h(angular.element(f.parent())), null != g.infiniteScrollImmediateCheck && (q = e.$eval(g.infiniteScrollImmediateCheck)), c(function () {
                    return q ? o() : void 0
                }, 0, 1)
            }}
    }]);


