<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>

        <link rel="stylesheet" href="../css/bootstrap.css">

        <script src="../js/analytics.js" async=""></script>
        <script src="../js/angular.js"></script>
        <script src="../js/angular-resource.js"></script>
        <script src="../js/angular-route.js"></script>

        <script src="../js/ui-bootstrap-tpls.js"></script>

        <script src="../js/jquery-latest.js"></script>
        <script src="../js/timepickerpop.js"></script>




    </head>
    <body>

        <div class="container ng-scope" ng-app="timepickerDemo">

            <div class="col-md-2"></div>
            <div class="col-md-8 ng-scope" ng-controller="DemoCtrl">

                <h1>Popup Timepicker Demo</h1>

                <div class="well">
                    <form name="form" class="form-horizontal ng-valid ng-dirty" role="form">

                        

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Popup Timepicker</label>
                            <div class="col-sm-4">
                                <timepicker-pop input-time="mytime" class="input-group ng-isolate-scope" show-meridian="showMeridian"><input value="04:15 PM" class="form-control ng-isolate-scope ng-pristine ng-valid ng-valid-time" ng-model="inputTime" time-format="" show-meridian="showMeridian" ng-focus="open()" type="text">  <div class="input-group-btn" ng-class="{open:isOpen}">     <button type="button" class="btn btn-default " ng-class="{'btn-primary':isOpen}" data-toggle="dropdown" ng-click="toggle()">         <i class="glyphicon glyphicon-time"></i></button>           <div class="dropdown-menu pull-right">  
                                            <table class="ng-isolate-scope ng-pristine ng-valid ng-valid-time" ng-model="inputTime" show-meridian="showMeridian">
                                                <tbody>
                                                    <tr class="text-center">
                                                        <td><a ng-click="incrementHours()" class="btn btn-link"><span class="glyphicon glyphicon-chevron-up"></span></a></td>
                                                        <td>&nbsp;</td>
                                                        <td><a ng-click="incrementMinutes()" class="btn btn-link"><span class="glyphicon glyphicon-chevron-up"></span></a></td>
                                                        <td class="" ng-show="showMeridian"></td>
                                                    </tr>
                                                    <tr>
                                                        <td style="width:50px;" class="form-group" ng-class="{'has-error': invalidHours}">
                                                            <input value="04" ng-model="hours" ng-change="updateHours()" class="form-control text-center ng-pristine ng-valid" ng-mousewheel="incrementHours()" ng-readonly="readonlyInput" maxlength="2" type="text">
                                                        </td>
                                                        <td>:</td>
                                                        <td style="width:50px;" class="form-group" ng-class="{'has-error': invalidMinutes}">
                                                            <input value="15" ng-model="minutes" ng-change="updateMinutes()" class="form-control text-center ng-pristine ng-valid" ng-readonly="readonlyInput" maxlength="2" type="text">
                                                        </td>
                                                        <td class="" ng-show="showMeridian"><button type="button" class="btn btn-default text-center ng-binding" ng-click="toggleMeridian()">PM</button></td>
                                                    </tr>
                                                    <tr class="text-center">
                                                        <td><a ng-click="decrementHours()" class="btn btn-link"><span class="glyphicon glyphicon-chevron-down"></span></a></td>
                                                        <td>&nbsp;</td>
                                                        <td><a ng-click="decrementMinutes()" class="btn btn-link"><span class="glyphicon glyphicon-chevron-down"></span></a></td>
                                                        <td class="" ng-show="showMeridian"></td>
                                                    </tr>
                                                </tbody>
                                            </table>         
                                        </div>   
                                    </div>
                                </timepicker-pop>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="col-md-2"></div>
        </div>



        <script type="text/javascript">
            angular.module('timepickerDemo', ['timepickerPop']).controller(
                    'DemoCtrl', function ($scope) {
                        $scope.mytime = new Date();
                        $scope.showMeridian = true;

                    });
        </script>
    </body>

</html>