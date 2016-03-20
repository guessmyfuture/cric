<!DOCTYPE html>
<html lang="en" ng-app="CricApp">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Cricbounz</title>
        <!-- Bootstrap -->  

        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link href="css/style.css" rel="stylesheet">
        <link href="css/side-menu.css" rel="stylesheet" type="text/css"/> 
        <link href="css/datepicker.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/ngTimepicker.css" rel="stylesheet" type="text/css"/>
        <link href="css/autocomplete.css" rel="stylesheet" type="text/css"/>
        <link href="css/tooltip.css" rel="stylesheet" type="text/css"/>
        <!--<link href="css/jquery-ui.min.css" rel="stylesheet" type="text/css"/> -->

        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>            
        <script src="js/jquery-ui.min.js" type="text/javascript"></script>
        <script src="js/angular.min.js" type="text/javascript"></script> 

        <script src="js/ngTimepicker.min.js" type="text/javascript"></script>
        <script src="js/bootstrap-datepicker.js" type="text/javascript"></script>
        <script src="js/jquery.ddslick.min.js" type="text/javascript"></script>

    </head>
    <body ng-controller="includeControl">
        <div ng-include="'partials/header.html'"></div>

        <div class="container-fluid">
            <div class="row no-gutters">
                <div ng-include="'partials/left_side.html'"></div>                
                <div ng-include="activateTemplate"></div>
                <div ng-include="'partials/right_side.html'"></div>                
            </div><!--end row --> 
        </div><!--#container-->

        <!-- Include all compiled plugins (below), or include individual files as needed -->   
        <script src="js/holder.js"></script>
        <script src="js/angular/com/commonController.js" type="text/javascript"></script>  
        <script src="js/angular/com/lodash.js" type="text/javascript"></script>        
        <script src="js/angular/Team/teamController.js" type="text/javascript"></script>
        <script src="js/angular//Utility/common.js" type="text/javascript"></script>
        <script src="js/angular/Utility/angular-file-model.js" type="text/javascript"></script>    
        <script src="js/angular/Ground/groundController.js" type="text/javascript"></script>
        <script src="js/angular/Tournament/tournamentController.js" type="text/javascript"></script>
        <script src="js/angular/User/userController.js" type="text/javascript"></script>
        <script src="js/angular/com/loadController.js" type="text/javascript"></script>
        <script src="js/customSelect.js" type="text/javascript"></script>
        <script src="js/angular/Team/scoreCard.js" type="text/javascript"></script>        
        <script src="js/angular/com/ng-file-upload.min.js" type="text/javascript"></script>        
    </script>
</body>
</html>
