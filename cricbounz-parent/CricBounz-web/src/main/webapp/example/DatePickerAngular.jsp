<%-- 
    Document   : DatePicker
    Created on : Mar 1, 2016, 1:52:17 PM
    Author     : Coeuz 4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="date">
<head>
<!--<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/smoothness/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular.min.js"></script>-->

<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/smoothness/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script src="../js/jquery-ui.min.js" type="text/javascript"></script>
<script src="../js/angular.min.js" type="text/javascript"></script>


<meta charset=utf-8 />
<title>JS Bin</title>
</head>
<body ng-controller="dateCtrl">
  <!-- ng -->
  ng date picker:<input type="text" datepicker ng-model="date2">
  <span>{{date2}}</span>
  <script>
 angular.module("date",[])
.directive("datepicker",function(){
  return {
    restrict:"A",
    link:function(scope,el,attr){
      el.datepicker();
    }
  };
})
.controller("dateCtrl",function($scope){
  $scope.$watch("date2",function(old,newv){
    console.log(old,newv);
  });
  $scope.$watch("date",function(old,newv){
    console.log(old,newv);
  });
});    
  </script>
</body>
</html>