<%-- 
    Document   : ValidationFormDummy
    Created on : Feb 19, 2016, 5:16:08 PM
    Author     : Coeuz 4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/angular.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div ng-app="validationApp" ng-controller="mainController">
            <div class="container">
                <div class="row"> 
                    <div class="col-sm-6">
                        <!-- FORM ============ -->
                        <form name="userForm" ng-submit="submitForm()" novalidate>
                            <fieldset>
                                <!-- Form Name -->
                                <legend>Create Team</legend>
                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="textinput">Team Name</label>  
                                    <div class="col-md-4">
                                        <input type="text" ng-model="teamName" name="teamName" placeholder="Team Name" class="form-control input-md" required>
                                          <p ng-show="userForm.teamName.$invalid && !userForm.teamName.$pristine" class="help-block">Team name is required.</p>
                                    </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-md-4 control-label" for="textinput">Captain Name</label>  
                                    <div class="col-md-4">
                                        <input type="text" ng-model="captainName" name="captainName" placeholder="Captain Name" class="form-control input-md" required>
                                          <p ng-show="userForm.captainName.$invalid && !userForm.captainName.$pristine" class="help-block">captainName is required.</p>
                                    </div>
                                </div>
                            </fieldset>
                            
                            
                            

                            <!-- USERNAME -->
                            <div class="form-group" ng-class="{'has-error' : userForm.username.$invalid && !userForm.username.$pristine }">
                                <label>Username</label>
                                <input type="text" name="username" class="form-control" ng-model="user.username" ng-minlength="3" ng-maxlength="8">
                                <p ng-show="userForm.username.$error.minlength" class="help-block">Username is too short.</p>
                                <p ng-show="userForm.username.$error.maxlength" class="help-block">Username is too long.</p>
                            </div>

                            <!-- EMAIL -->
                            <div class="form-group" ng-class="{'has-error': userForm.email.$invalid && !userForm.email.$pristine }">
                                <label>Email</label>
                                <input type="email" name="email" class="form-control" ng-model="user.email">
                                <p ng-show="userForm.email.$invalid && !userForm.email.$pristine" class="help-block">Enter a valid email.</p>
                            </div>

                            <button type="submit" class="btn btn-primary" ng-disabled="userForm.$invalid">Submit</button>

                        </form>
                    </div>                 
                </div>
            </div>
            <script>
                        // create angular app
                        var validationApp = angular.module('validationApp', []);

                        // create angular controller
                        validationApp.controller('mainController', function ($scope) {

                            // function to submit the form after all validation has occurred			
                            $scope.submitForm = function () {

                                // check to make sure the form is completely valid
                                if ($scope.userForm.$valid) {
                                    alert('our form is amazing');
                                }

                            };

                        });
            </script>
    </body>
</html>
