<%-- 
    Document   : dynamicTextbox
    Created on : Feb 28, 2016, 7:00:13 PM
    Author     : Coeuz 4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="controllerAsExample">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="../js/angular.min.js" type="text/javascript"></script>
        <style>
            input,.style{
                color:red;
                font-size: 25px;
            }
            
            .status{
                color:red;
                font-size: 25px;
            }
        </style>
    </head>
    <body ng-controller="SettingsController1">
        <div>
            <table>
                <tr ng-repeat="slot in slots">
                    <td class="style">Slot # {{slot.id=$index+1}}</td>
                    <td><input type="text" value="" ng-model="slot.startTime" placeholder="hh:mm am"></td>
                    <td><input type="text" value="" ng-model="slot.endTime" placeholder="hh:mm pm"></td>
                </tr>    
                 <tr>
                     <td><button type="button" class="style" ng-click="addNewSlot()">Add New Slot</button></td>
                    <td><button type="button" class="style" ng-click="removeSlot()">Remove Slot</button></td>
                     <td class="status">{{status}} </td>
                </tr>
            </table>
            {{slots | json}}
        </div>
        <script>
            angular.module('controllerAsExample', [])
                    .controller('SettingsController1', function ($scope) {
                        $scope.slots = [];
                        $scope.slots.push({});
                        $scope.slots.push({});
                        $scope.slots.push({});
                        $scope.slots.push({}); 
                        $scope.status='';                        
                        $scope.addNewSlot = function () {
                            if($scope.slots.length<6)
                            {
                            $scope.slots.push({});
                             $scope.status='';
                            }
                            else
                            {
                                  $scope.status='YOU CAN ADD 6 SLOTS ONLY';
                            }
                        }
                        
                        $scope.removeSlot = function () {
                           //$scope.slots.push({});                            
                            $scope.slots.splice($scope.slots.length-1, 1);
                             $scope.status='';
                        }
                    });
        </script>
    </body>
</html>
