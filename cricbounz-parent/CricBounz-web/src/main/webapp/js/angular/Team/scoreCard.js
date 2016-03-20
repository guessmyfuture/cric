/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//var playerService = angular.module('playerService', []);



var scoreApp = angular.module('scoreModule', []);

//    function PlayersService() {
//      
//        this.loadBatsman = function() {
//        $http.get("json/batsman.json").then(function (response) { 
//           return response.data;
//          //  scoreApp.value("batsmanList",$scope.batsmanList);
//            
//        });
//    }
//    }
//
//scoreApp.service("loadBatsman",PlayersService);

scoreApp.service('playerservice', function ($http) {
    
    this.loadBatsman = function ($http) {
        return $http.get('json/batsman.json').success(function (data) {
            return data;
        });
    };
});


scoreApp.controller('loadPlayersCtrl', function ($scope, $http) {
    
//     playerservice.loadBatsman.then(function(resp) {
//        $scope.batsmanList = resp.data;
//    });
//    
    if ($scope.addedBatsmanList.length == 0){
   
    $http.get("json/batsman.json").then(function (response) {
           $scope.batsmanList = response.data;
          //  scoreApp.value("batsmanList",$scope.batsmanList);
            
        });
       $http.get("json/bowler.json").then(function (response) {
            $scope.bowlerList = response.data;
           //  scoreApp.value("batsmanList",$scope.batsmanList);
        });
    }
    }
);



scoreApp.controller('scoreCtrl',function ($scope, $http) {
    $scope.legalBallCount = 0;
    $scope.totalBallCount = 0;
    $scope.grandTotalBallCount = 0;
    $scope.currentIndex = -1;
    $scope.ballIndex = 0;
    $scope.extraRun = 0;
    
    $scope.teama = "CSK";
    $scope.teamb = "RPS";

    $scope.addedBatsmanList = [];
    $scope.addedBowlerList = [];
    $scope.scoreBox = [];

    /*innings wise batsman list variable*/
    $scope.innings1BatsManList = [];
    $scope.innings2BatsManList = [];
    $scope.innings1BowlersList = [];
    $scope.innings2BowlersList = [];
    $scope.innings = 1;

    $scope.bmNonStriker = {};
    $scope.bmStriker = {};
    $scope.currentBowler = {};
    $scope.nextBowler = {};



    for (i = 0; i < 6; i++)
    {
        $scope.scoreBox.push({});
    }

    /*disable controls*/
    $scope.isScoredbyBatsman = true;
    $scope.isByes = true;
    $scope.isLegByes = true;
    $scope.isWicket = true;
    $scope.isDotBall = true;
    $scope.isRunButton = true;
    $scope.isWicketBox = true;

    /*enable Status ball type Control*/
    $scope.islegalDelivery = false;
    $scope.isWide = false;
    $scope.isNoBall = false;

    $scope.isRunOut = false;

    $scope.startPlay = false;
    $scope.actionType = '';

    /*bootstrap modal variable*/
    $scope.runOutModal = false;
    $scope.batsmanModal = false;

    $scope.loadBatsmanList = function ()
    {
        var cb=$scope.bmStriker;  
        $scope.bl=[];
        alert(batsmanList);
        $http.get("json/batsman.json").then(function (response) {
            //$scope.batsmanList = response.data; 
             angular.forEach(response.data, function(item) {               
               if(item.id!=cb["id"])
               {
                    $scope.bl.push(item);
               }
            });
        });
        $scope.batsmanList=$scope.bl;        
        
         
         
          
      
       // alert($scope.batsmanList.length);
       //for (i = 0; i < $scope.batsmanList.length; i++)
        //{
            /*delete $scope.batsmanList[i];
            if ($scope.bmStriker["id"] == $scope.batsmanList[i]["id"])
            {         
                //$scope.batsmanList[i] = {};
                //delete $scope.batsmanList[i];
                //$scope.batsmanList.splice(i, 1);
            }*/
           // alert('normal execution');
           // alert($scope.bmStriker["id"]+'  '+$scope.batsmanList[i]["id"]);
       // }
        /* 
        for (i = 0; i < $scope.batsmanList.length; i++)
        {
            if ($scope.bmNonStriker["id"] == $scope.bmNonStriker[i]["id"])
            {
                //$scope.batsmanList[i] = {};
                delete $scope.batsmanList[i];
            }
        }*/
    }
    $scope.loadBowlerList = function ()
    {
        $http.get("json/bowler.json").then(function (response) {
            $rootScope.bowlerList = response.data;
            alert( $rootScope.bowlerList );
        });
    }

    $scope.addCurrentBatsman = function (index, userId) {
        console.log(index + "  " + userId);
        var searchField = "id";
        for (var i = 0; i < $scope.batsmanList.length; i++)
        {
            if ($scope.batsmanList[i][searchField] == userId) {
                $scope.batsmanList[i].addedStatus = true;
                $scope.bmStriker = $scope.batsmanList[i];
                //var item = {};
                //item["userId"] = userId;
                //$scope.addedUserListIds.push(item);
                console.log(angular.toJson($scope.addedBatsmanList));
            }
        }
        $scope.batsmanList.splice(index, 1);
        $scope.batsmanModal = false;
    }

    $scope.addCurrentBowler = function (index, userId) {
        console.log(index + "  " + userId);
        var searchField = "id";
        for (var i = 0; i < $scope.bowlerList.length; i++)
        {
            if ($scope.bowlerList[i][searchField] == userId) {
                $scope.bowlerList[i].addedStatus = true;
                $scope.nextBowler = $scope.currentBowler;
                $scope.currentBowler = $scope.bowlerList[i];
                //var item = {};
                //item["userId"] = userId;
                //$scope.addedUserListIds.push(item);
                // console.log(angular.toJson($scope.addedBowlerList));
            }
        }
        $scope.bowlerList.splice(index, 1);
    }

    $scope.addBatsmanList = function (index, userId) {
        console.log(index + "  " + userId);
        var searchField = "id";
        for (var i = 0; i < $scope.batsmanList.length; i++)
        {
            if ($scope.batsmanList[i][searchField] == userId) {
                $scope.batsmanList[i].addedStatus = true;
                $scope.addedBatsmanList.push($scope.batsmanList[i]);
                //var item = {};
                //item["userId"] = userId;
                //$scope.addedUserListIds.push(item);
                console.log(angular.toJson($scope.addedBatsmanList));
            }
        }
        $scope.batsmanList.splice(index, 1);
    }
    $scope.addBowlerList = function (index, userId) {
        console.log(index + "  " + userId);
        var searchField = "id";
        for (var i = 0; i < $scope.bowlerList.length; i++)
        {
            if ($scope.bowlerList[i][searchField] == userId) {
                $scope.bowlerList[i].addedStatus = true;
                $scope.addedBowlerList.push($scope.bowlerList[i]);
                //var item = {};
                //item["userId"] = userId;
                //$scope.addedUserListIds.push(item);
                console.log(angular.toJson($scope.addedBowlerList));
            }
        }
        $scope.bowlerList.splice(index, 1);
    }

    $scope.disableAllAction = function ()
    {
        $scope.isByes = true;
        $scope.isLegByes = true;
        $scope.isScoredbyBatsman = true;
        $scope.isWicket = true;
        $scope.isDotBall = true;
    }
    $scope.disableBallType = function (boolFlag)
    {
        $scope.isLegalDelivery = boolFlag;
        $scope.isWide = boolFlag;
        $scope.isNoBall = boolFlag;
    }
    $scope.enableScoreButton = function (action)
    {
        $scope.actionType = action;
        if (action == "SBB")
        {
            if ($scope.ballType == "LD" || $scope.ballType == "NB")
            {
                $scope.isRunButton = false;
            }
        }
        if (action == "BYES")
        {
            $scope.isRunButton = false;
        }
        if (action == "LBYES")
        {
            if ($scope.ballType == "LD" || $scope.ballType == "NB")
            {
                $scope.isRunButton = false;
            }
        }
    }
    $scope.swapOddPlayers = function ()
    {
        var tempObj = {};
        if ($scope.run % 2 == 1)
        {
            tempObj = $scope.bmStriker;
            $scope.bmStriker = $scope.bmNonStriker;
            $scope.bmNonStriker = tempObj;
        }
    }
    $scope.swapEvenPlayers = function ()
    {
        var tempObj = {};
        if ($scope.run % 2 == 0)
        {
            tempObj = $scope.bmStriker;
            $scope.bmStriker = $scope.bmNonStriker;
            $scope.bmNonStriker = tempObj;
        }
    }
    $scope.countOver = function ()
    {
        $scope.legalBallCount++;
        $scope.over = 0;
        if ($scope.legalBallCount < 6)
        {
            $scope.over = '0.' + $scope.legalBallCount;
        }
        if ($scope.legalBallCount >= 6)
        {
            var first = 0, second = 0;
            first = Math.floor($scope.legalBallCount / 6);
            second = $scope.legalBallCount % 6;

            $scope.over = first + '.' + second;
        }
        $scope.currentBowler["over"] = $scope.over;
    }

    $scope.addInningsList = function ()
    {
        if ($scope.innings == 1)
        {
            $scope.innings1BatsManList.push($scope.bmStriker);
            $scope.bmStriker = {};
            ///alert(angular.toJson($scope.innings1BatsManList));
        }
        if ($scope.innings == 2)
        {

        }
    }

    $scope.currentBatsmanOut = function ()
    {
        $scope.loadBatsmanList();
        if ($scope.wicketType == '3')
        {
            $scope.isRunOut = true;
            $scope.runOutModal = true;
            $scope.batsmanModal = true;
        } else
        {
            $scope.addInningsList();
            $scope.batsmanModal = true;
        }
    }
    $scope.addRunToScoreBox = function (run)
    {
        $scope.disableBallType(false);
        $scope.grandTotalBallCount++;
        $scope.totalBallCount++;
        $scope.isRunButton = true;
        $scope.run = parseInt(run);
        $scope.scoreBox[$scope.ballIndex]["run"] = $scope.run;

        //alert('score box = ' + $scope.scoreBox.length + '  ball_count = ' + $scope.totalBallCount);
        if ($scope.scoreBox.length == $scope.totalBallCount)
        {
            $scope.updatePlayerScore();
            $scope.swapEvenPlayers();
            $scope.ballIndex = 0;
            $scope.totalBallCount = 0;
            $scope.scoreBox = [];
            for (i = 0; i < 6; i++)
            {
                $scope.scoreBox.push({});
            }
            return;
        }

        if ($scope.ballType == "WIDE")
        {
            $scope.scoreBox[$scope.ballIndex]["wideFlag"] = true;
            $scope.scoreBox.push({});
            $scope.extraRun += $scope.run + 1;
            $scope.ballIndex++;
            $scope.swapOddPlayers();
            return;
        }
        if ($scope.ballType == "NB" && $scope.actionType != "SBB")
        {
            $scope.scoreBox[$scope.ballIndex]["nbFlag"] = true;
            $scope.scoreBox.push({});
            $scope.extraRun += $scope.run + 1;
            $scope.ballIndex++;
            $scope.swapOddPlayers();
            return;
        }
        if ($scope.ballType == "LD" && $scope.actionType != "SBB")
        {
            //alert($scope.ballType + '  ' + $scope.actionType);
            $scope.scoreBox[$scope.ballIndex]["ldFlag"] = true;
            $scope.extraRun += $scope.run;
            $scope.ballIndex++;
            $scope.bmStriker["balls"] += 1;
            $scope.swapOddPlayers();
            $scope.countOver();
            return;
        }
        $scope.updatePlayerScore();
    }

    $scope.updatePlayerScore = function ()
    {
        /*Updating Current Batsman(Striker) Scores */
        $scope.bmStriker["runs"] += $scope.run;
        $scope.bmStriker["balls"] += 1;
        $scope.bmStriker["four"] += ($scope.run == 4) ? 1 : 0;
        $scope.bmStriker["six"] += ($scope.run == 6) ? 1 : 0;
        $scope.bmStriker["strikeRate"] = ($scope.bmStriker["runs"] * 100) / $scope.bmStriker["balls"];

        //put over logic here
        $scope.countOver();

        /*Updating Current Bowler Status */
        $scope.currentBowler["over"] = $scope.over;
        $scope.currentBowler["maiden"] += $scope.run;
        $scope.currentBowler["runs"] += $scope.bmStriker["runs"];
        $scope.currentBowler["wickets"] += 1;
        $scope.currentBowler["economy"] += 1;

        //put swapping players
        if (!$scope.isRunOut)
        {
            $scope.swapOddPlayers();
        } else
        {
            $scope.addInningsList();
        }
        $scope.ballIndex++;
    }


//unuse code
    //$scope.addToScroeCard = function ()
    //{
    //$scope.startPlay = true;
    //$scope.bmNonStriker;

    /*var batsmanStriker = {
     playerId: $scope.bmStriker["id"],
     name: $scope.bmStriker["name"],
     palyerImageUrl: $scope.bmStriker["playerImageUrl"],
     role: $scope.bmStriker["role"],
     runs: 0,
     balls: 0,
     four: 0,
     six: 0,
     strikeRate: 0
     }
     
     var batsmanNonStriker = {
     playerId: $scope.bmNonStriker["id"],
     name: $scope.bmNonStriker["name"],
     palyerImageUrl: $scope.bmNonStriker["playerImageUrl"],
     role: $scope.bmNonStriker["role"],
     runs: 0,
     balls: 0,
     four: 0,
     six: 0,
     strikeRate: 0
     }
     
     var currentBowler = {
     playerId: $scope.currentBowler["id"],
     name: $scope.currentBowler["name"],
     palyerImageUrl: $scope.currentBowler["playerImageUrl"],
     role: $scope.currentBowler["role"],
     over: 0,
     maiden: 0,
     runs: 0,
     wickets: 0,
     economy: 0
     }*/

    /*$scope.addedBatsmanList.push(batsmanStriker);
     $scope.addedBatsmanList.push(batsmanNonStriker);
     $scope.addedBowlerList.push(currentBowler);*/

    /*this code id for testing purpose only*/
//        $scope.nextBowler["name"]="Tamil language";
//        $scope.nextBowler["over"]=390;
//        $scope.nextBowler["maiden"]=867;
//        $scope.nextBowler["runs"]=905;
    // }

    /*$scope.addRun = function (run)
     {
     alert($scope.ballType);
     if ($scope.currentIndex >= 0)
     {
     if (run == 0)
     {
     
     }
     $scope.addedBatsmanList[0]["runs"] = $scope.addedBatsmanList[0]["runs"] - $scope.scoreBox[$scope.currentIndex]["run"];
     $scope.scoreBox[$scope.currentIndex]["run"] = run;
     $scope.addedBatsmanList[0]["runs"] += parseInt(run);
     $scope.currentIndex = -1;
     $scope.addedBatsmanList[0]["strikeRate"] = Math.round($scope.addedBatsmanList[0]["runs"] * 100 / $scope.addedBatsmanList[0]["balls"]);
     return;
     }
     
     for (i = 0; i < $scope.scoreBox.length; i++)
     {
     //if (angular.isUndefined($scope.scoreBox[i]["run"]))
     if ($scope.scoreBox[i]["run"] == '')
     {
     if (run == "W")
     {
     $scope.scoreBox[i]["wideFlag"] = true;
     $scope.scoreBox.push({});
     return;
     }
     if (run == "NB")
     {
     $scope.scoreBox[i]["nbFlag"] = true;
     $scope.scoreBox.push({});
     return;
     }
     $scope.legalBallCount++;
     run = parseInt(run);
     $scope.addedBatsmanList[0]["balls"] = $scope.legalBallCount;
     $scope.scoreBox[i]["run"] = run;
     if (run == 4)
     {
     $scope.addedBatsmanList[0]["four"] += 1;
     }
     if (run == 6)
     {
     $scope.addedBatsmanList[0]["six"] += 1;
     }
     $scope.addedBatsmanList[0]["runs"] += run;
     $scope.addedBatsmanList[0]["strikeRate"] = Math.round($scope.addedBatsmanList[0]["runs"] * 100 / $scope.addedBatsmanList[0]["balls"]);
     break;
     }
     
     }
     console.log(run);
     }*/

});

/*This Directive is Used for Calling Bootstrap Modal*/
dbApp.directive('modal', function () {
    return {
        template: '<div class="modal fade">' +
                '<div class="modal-dialog">' +
                '<div class="modal-content">' +
                '<div class="modal-header">' +
                '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' +
                '<h4 class="modal-title">{{ title }}</h4>' +
                '</div>' +
                '<div class="modal-body" ng-transclude></div>' +
                '</div>' +
                '</div>' +
                '</div>',
        restrict: 'E',
        transclude: true,
        replace: true,
        scope: true,
        link: function postLink(scope, element, attrs) {
            scope.title = attrs.title;

            scope.$watch(attrs.visible, function (value) {
                if (value == true)
                    $(element).modal('show');
                else
                    $(element).modal('hide');
            });

            $(element).on('shown.bs.modal', function () {
                scope.$apply(function () {
                    scope.$parent[attrs.visible] = true;
                });
            });

            $(element).on('hidden.bs.modal', function () {
                scope.$apply(function () {
                    scope.$parent[attrs.visible] = false;
                });
            });
        }
    };
});