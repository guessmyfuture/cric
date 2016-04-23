/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var scoreApp = angular.module('scoreModule', []);

scoreApp.controller('scoreCtrl', function ($scope, $rootScope, $http) {
    $scope.legalBallCount = 0;
    $scope.totalBallCount = 0;
    $scope.grandTotalBallCount = 0;
    $scope.currentIndex = -1;
    $scope.ballIndex = 0;
    $scope.extraRun = 0;
    $scope.noOfOvers = 0;
    $scope.isBatsManOut = false;

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
    $scope.isMaiden = true;

    $scope.bmNonStriker = {};
    $scope.bmStriker = {};
    $scope.currentBowler = {};
    $scope.nextBowler = {};
    $scope.bmNonStrikerInnings1 = {};
    $scope.bmStrikerInnings1 = {};
    $scope.currentBowlerInnings1 = {};
    $scope.nextBowlerInnings1 = {};
    $scope.bmNonStrikerInnings2 = {};
    $scope.bmStrikerInnings2 = {};
    $scope.currentBowlerInnings2 = {};
    $scope.nextBowlerInnings2 = {};


    $scope.isFirstInningOver = false;

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
    $scope.bowlerModal = false;

    $scope.addRunToScoreBox = function (run)
    {
        console.log("Entering The Method Name--->addRunToScoreBox()");
        $scope.disableBallType(false);
        $scope.grandTotalBallCount++;
        $scope.totalBallCount++;
        $scope.isRunButton = true;
        $scope.run = parseInt(run);
        $scope.scoreBox[$scope.ballIndex]["run"] = $scope.run;

        if ($scope.isBatsManOut)
        {
            $scope.isBatsManOut = false;
            return;
        }

        //over change
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
            //current
            if ($scope.innings == 1)
            {
                $scope.innings1BowlersList.push($scope.currentBowler);
                $scope.currentBowler = {};
            }
            if ($scope.innings == 2)
            {
                $scope.innings2BowlersList.push($scope.currentBowler);
                $scope.currentBowler = {};
            }

            $scope.bowlerModal = true;
            $scope.watchOver();
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
            console.log("No Ball Not  Scored By Batsman");
            $scope.scoreBox[$scope.ballIndex]["nbFlag"] = true;
            $scope.scoreBox.push({});
            $scope.bmStriker["balls"] += 1;
            $scope.extraRun += $scope.run + 1;
            $scope.ballIndex++;
            $scope.swapOddPlayers();
            return;
        }

        if ($scope.ballType == "NB" && $scope.actionType == "SBB")
        {
            console.log("No Ball With Scored By Batsman");
            $scope.scoreBox[$scope.ballIndex]["nbFlag"] = true;
            $scope.scoreBox.push({});
            $scope.updatePlayerScore();
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
        $scope.watchOver();

    }

    $scope.loadBatsmanList = function ()
    {
        console.log("Entering The Method Name--->loadBatsmanList()");
        if ($scope.innings == 1)
        {
            $http.get("json/batsman_innings1.json").then(function (response) {
                $scope.batsmanList = response.data;
            });
        }
        if ($scope.innings == 2)
        {
            $http.get("json/batsman_innings2.json").then(function (response) {
                $scope.batsmanList = response.data;
            });
        }
    }
    $scope.loadBowlerList = function ()
    {
        console.log("Entering The Method Name--->loadBowlerList()");
        if ($scope.innings == 1)
        {
            $http.get("json/bowler_innings1.json").then(function (response) {
                $scope.bowlerList = response.data;
            });
        }
        if ($scope.innings == 2)
        {
            $http.get("json/bowler_innings2.json").then(function (response) {
                $scope.bowlerList = response.data;
            });
        }
    }

    $scope.currentInningsSetPlayer = function ()
    {
        console.log("Entering The Method Name--->currentInningsSetPlayer()");
        if ($scope.innings == 1)
        {
            $scope.bmNonStrikerInnings1 = $scope.bmNonStriker
            $scope.bmStrikerInnings1 = $scope.bmStriker;
            $scope.currentBowlerInnings1 = $scope.currentBowler;
            $scope.nextBowlerInnings1 = $scope.nextBowler;
        }
        if ($scope.innings == 2)
        {
            $scope.bmNonStrikerInnings2 = $scope.bmNonStriker
            $scope.bmStrikerInnings2 = $scope.bmStriker;
            $scope.currentBowlerInnings2 = $scope.currentBowler;
            $scope.nextBowlerInnings2 = $scope.nextBowler;

            $scope.bmNonStrikerInnings1 = {};
            $scope.bmStrikerInnings1 = {};
            $scope.currentBowlerInnings1 = {};
            $scope.nextBowlerInnings1 = {};
        }
    }
    $scope.currentInningsSetPlayerAfterOut = function ()
    {
        console.log("Entering The Method Name--->currentInningsSetPlayerAfterOut()");
        if ($scope.innings == 1)
        {
            $scope.bmNonStrikerInnings1 = $scope.bmNonStriker
            $scope.bmStrikerInnings1 = $scope.bmStriker;
            $scope.currentBowlerInnings1 = $scope.currentBowler;
            $scope.nextBowlerInnings1 = $scope.nextBowler;
        }
        if ($scope.innings == 2)
        {
            $scope.bmNonStrikerInnings2 = $scope.bmNonStriker
            $scope.bmStrikerInnings2 = $scope.bmStriker;
            $scope.currentBowlerInnings2 = $scope.currentBowler;
            $scope.nextBowlerInnings2 = $scope.nextBowler;

            $scope.bmNonStrikerInnings1 = {};
            $scope.bmStrikerInnings1 = {};
            $scope.currentBowlerInnings1 = {};
            $scope.nextBowlerInnings1 = {};
        }
    }

    $scope.addCurrentBatsman = function (index, userId) {
        console.log("Entering The Method Name--->addCurrentBatsman()");
        //console.log(index + "  " + userId);
        var searchField = "id";
        for (var i = 0; i < $scope.batsmanList.length; i++)
        {
            if ($scope.batsmanList[i][searchField] == userId) {
                $scope.batsmanList[i].addedStatus = true;
                $scope.addInningsList();
                $scope.bmStriker = $scope.batsmanList[i];
                if ($scope.innings == 1)
                {
                    $scope.bmStrikerInnings1 = $scope.bmStriker;
                }
                if ($scope.innings == 2)
                {
                    $scope.bmStrikerInnings2 = $scope.bmStriker;
                }
                //var item = {};
                //item["userId"] = userId;
                //$scope.addedUserListIds.push(item);
                //console.log(angular.toJson($scope.addedBatsmanList));
            }
        }
        $scope.batsmanList.splice(index, 1);
        $scope.batsmanModal = false;
    }

    $scope.addCurrentBowler = function (index, userId) {
        console.log("Entering The Method Name--->addCurrentBowler()");
        $scope.bowlerModal = false;
        console.log(index + "  " + userId);
        var searchField = "id";
        for (var i = 0; i < $scope.bowlerList.length; i++)
        {
            if ($scope.bowlerList[i][searchField] == userId) {
                $scope.bowlerList[i].addedStatus = true;
                $scope.nextBowler = $scope.currentBowler;
                $scope.currentBowler = $scope.bowlerList[i];
                if ($scope.innings == 1)
                {
                    $scope.currentBowlerInnings1 = $scope.currentBowler;
                }
                if ($scope.innings == 2)
                {
                    $scope.currentBowlerInnings2 = $scope.currentBowler;
                }
                //var item = {};
                //item["userId"] = userId;
                //$scope.addedUserListIds.push(item);
                // console.log(angular.toJson($scope.addedBowlerList));
            }
        }
        $scope.bowlerList.splice(index, 1);
    }

    $scope.addBatsmanList = function (index, userId) {
        console.log("Entering The Method Name--->addBatsmanList()");
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
        console.log("Entering The Method Name--->addBowlerList()");
        //console.log(index + "  " + userId);
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
        console.log("Entering The Method Name--->disableAllAction()");
        $scope.isByes = true;
        $scope.isLegByes = true;
        $scope.isScoredbyBatsman = true;
        $scope.isWicket = true;
        $scope.isDotBall = true;
    }
    $scope.disableBallType = function (boolFlag)
    {
        console.log("Entering The Method Name--->disableBallType()");
        $scope.isLegalDelivery = boolFlag;
        $scope.isWide = boolFlag;
        $scope.isNoBall = boolFlag;
    }
    $scope.enableScoreButton = function (action)
    {
        console.log("Entering The Method Name--->enableScoreButton()");
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
        console.log("Entering The Method Name--->swapOddPlayers()");
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
        console.log("Entering The Method Name--->swapEvenPlayers()");
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
        console.log("Entering The Method Name--->countOver()");
        if ($scope.ballType == "NB" && $scope.actionType == "SBB")
        {
            return;
        }
        $scope.legalBallCount++;
        console.log("ball count " + $scope.legalBallCount);
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
        console.log("Entering The Method Name--->addInningsList()");
        if ($scope.innings == 1)
        {
            $scope.innings1BatsManList.push($scope.bmStriker);
            $scope.bmStriker = {};

            //$scope.bmStrikerInnings1=$scope.bmStriker;
            ///alert(angular.toJson($scope.innings1BatsManList));
        }
        if ($scope.innings == 2)
        {
            $scope.innings2BatsManList.push($scope.bmStriker);
            $scope.bmStriker = {};
        }
    }

    $scope.currentBatsmanOut = function ()
    {
        console.log("Entering The Method Name--->currentBatsmanOut()");
        $scope.currentInningsSetPlayerAfterOut();
        $scope.currentBowler["wickets"] += 1;
        if (parseInt($scope.wicketType) == 3)
        {
            $scope.scoreBox[$scope.ballIndex]["outFlag"] = true;
            $scope.isRunOut = true;
            $scope.runOutModal = true;
            //$scope.batsmanModal = true;
            //$scope.loadBatsmanList();
            ///$scope.batsmanModal = true;
        } else
        {
            //$scope.addInningsList();
            $scope.scoreBox[$scope.ballIndex]["outFlag"] = true;
            $scope.addRunToScoreBox(0);
            $scope.updatePlayerScore();
            if (($scope.innings1BatsManList.length > 2 && !$scope.isFirstInningOver) || (($scope.noOfOvers * 6) == $scope.legalBallCount && !$scope.isFirstInningOver))
            {
                $scope.isFirstInningOver = true;
                $scope.innings = 2;
                $scope.noOfOvers = 0;
                $scope.legalBallCount = 0;
                $scope.innings1BatsManList.push($scope.bmNonStriker);
                $scope.innings1BatsManList.push($scope.bmStriker);
                $scope.bmNonStriker = {};
                $scope.bmStriker = {};
                $scope.playerbModal = true;

            } else
            {
                $scope.loadBatsmanList();
                $scope.batsmanModal = true;
            }
            if (($scope.innings2BatsManList.length > 2 && $scope.isFirstInningOver) || (($scope.noOfOvers * 6) == $scope.legalBallCount && !$scope.isFirstInningOver))
            {
                $scope.isSecondInningOver = true;
                $scope.noOfOvers = 0;
                $scope.legalBallCount = 0;
                $scope.innings2BatsManList.push($scope.bmNonStriker);
                $scope.innings2BatsManList.push($scope.bmStriker);
                $scope.bmNonStriker = {};
                $scope.bmStriker = {};
                //  $scope.playerbModal = true;
                alert('Game Over');
            }
        }
    }

    $scope.watchOver = function () {
        console.log("Entering The Method Name--->watchOver()");
        // console.log('Jaiganesh -->' + ($scope.noOfOvers * 6) + '  ' + $scope.legalBallCount + '  ' + $scope.isFirstInningOver);
        if (($scope.noOfOvers * 6) == $scope.legalBallCount && !$scope.isFirstInningOver)
        {
            if ($scope.innings == 1)
            {
                $scope.isFirstInningOver = true;
                $scope.innings = 2;
                $scope.legalBallCount = 0;
                $scope.innings1BatsManList.push($scope.bmNonStriker);
                $scope.innings1BatsManList.push($scope.bmStriker);
                $scope.innings1BowlersList.push($scope.currentBowler);

                $scope.bmNonStriker = {};
                $scope.bmStriker = {};
                $scope.currentBowler = {};
                $scope.loadBowlerList();
                $scope.loadBatsmanList();

                $scope.playerbModal = true;
                $scope.bowlerModal = false;
            }
        }
        /*if (($scope.noOfOvers * 6) == $scope.legalBallCount && $scope.isFirstInningOver)
         {
         if ($scope.innings == 2)
         {
         $scope.isSecondInningOver = true;
         if ($scope.isMaiden)
         {
         $scope.currentBowler["maiden"] += 1;
         }
         $scope.innings2BatsManList.push($scope.bmNonStriker);
         $scope.innings2BatsManList.push($scope.bmStriker);
         $scope.innings2BowlersList.push($scope.currentBowler);
         
         $scope.bmNonStriker = {};
         $scope.bmStriker = {};
         $scope.currentBowler = {};
         $scope.bowlerModal = false;
         alert("Game Over");
         //$scope.loadBowlerList();
         //$scope.loadBatsmanList();
         //$scope.playerbModal = true;
         // $scope.bowlerModal = false;
         }
         }*/
    }
    $scope.updatePlayerScore = function ()
    {
        console.log("Entering The Method Name--->updatePlayerScore()");
        /*Updating Current Batsman(Striker) Scores */
        $scope.bmStriker["runs"] += $scope.run;
        $scope.bmStriker["balls"] += 1;
        $scope.bmStriker["four"] += ($scope.run == 4) ? 1 : 0;
        $scope.bmStriker["six"] += ($scope.run == 6) ? 1 : 0;
        $scope.bmStriker["strikeRate"] = ($scope.bmStriker["runs"] * 100) / $scope.bmStriker["balls"];

        //put over logic here
        $scope.countOver();
        /*Updating Current Bowler Scores */
        $scope.isMaiden = false;

        /*Updating Current Bowler Status */
        $scope.currentBowler["over"] = $scope.over;
        //$scope.currentBowler["maiden"] += $scope.run;
        $scope.currentBowler["runs"] += $scope.run;
        //$scope.currentBowler["wickets"] += 1;
        //$scope.currentBowler["economy"] += 1;

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

dbApp.directive("modalShow", function () {
    return {
        restrict: "A",
        scope: {
            modalVisible: "="
        },
        link: function (scope, element, attrs) {
            //Hide or show the modal
            scope.showModal = function (visible) {
                if (visible)
                {
                    element.modal("show");
                } else
                {
                    element.modal("hide");
                }
            }

            //Check to see if the modal-visible attribute exists
            if (!attrs.modalVisible)
            {
                //The attribute isn't defined, show the modal by default
                scope.showModal(true);
            } else
            {
                //Watch for changes to the modal-visible attribute
                scope.$watch("modalVisible", function (newValue, oldValue) {
                    scope.showModal(newValue);
                });

                //Update the visible value when the dialog is closed through UI actions (Ok, cancel, etc.)
                element.bind("hide.bs.modal", function () {
                    scope.modalVisible = false;
                    if (!scope.$$phase && !scope.$root.$$phase)
                        scope.$apply();
                });
            }
        }
    };

});