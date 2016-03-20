<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Welcome to Cricbounz </title>
        <!-- // -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/font-awesome.css">
        <link rel="stylesheet" href="css/home.css"> 
        <link rel="stylesheet" href="css/style1.css"> 
        <link rel="stylesheet" href="css/terms.css">
        <script src="js/jquery.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.slimscroll.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scr.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <img class="img-responsive displayed" src="images/home/ban2.png" align="middle"  usemap="#banner" border="0" alt="">
                <map name="banner">
                    <area shape="rect" coords="22,16,195,77" href="" alt="logo">  
                    <a href data-toggle="modal" data-target="#myModal"><area shape="rect" coords="776,64,849,84"  alt="login"> </a>
                    <a href data-toggle="modal" data-target="#myModal"><area shape="rect" coords="877,63,967,82"  alt="login"> </a>
                </map>
            </div>
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">



                    <!-- Modal content-->
                    <div class="row modal-content">
                        <div class="modal-body" align="justify">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <div class="col-xs-6 hints">
                                <h4 class="register-heading">Register In CricBounZ</h4>
                                <h2 class="title">Get these Benefits</h2>
                                <ul class="list-unstyled" style="line-height: 2">
                                    <li><span class="fa fa-check text-success"></span> Create your Team.</li>
                                    <li><span class="fa fa-check text-success"></span> Book your Ground.</li>
                                    <li><span class="fa fa-check text-success"></span> Book your Match.</li>
                                    <li><span class="fa fa-check text-success"></span> Promote your Tournament.</li>
                                    <li><span class="fa fa-check text-success"></span> Share your cricket Records.</li>
                                    <li><span class="fa fa-check text-success"></span> Add your Friends circle.</li>	
                            </div>

                            <div class="col-xs-6">
                                <div class="panel panel-login">
                                    <div class="panel-heading">
                                        <div class="row">
                                            <div class="col-xs-6">
                                                <a href="" class="active" id="login-form-link">Login</a>
                                            </div>
                                            <div class="col-xs-6">
                                                <a href=""  id="register-form-link">Register</a>
                                            </div>
                                        </div>
                                    </div>  
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-lg-10 col-lg-offset-1">
                                                <form id="login-form" action="#" method="post" role="form" style="display: block;">
                                                    <div class="form-group">
                                                        <input required='' type='text' data-error="Bruh, that email address is invalid" required> 
                                                        <label alt='Email' placeholder='Email'></label>
                                                        <span class="help-block"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <input required='' type='password'> 
                                                        <label alt='Password' placeholder='Password'></label>
                                                        <span class="help-block"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="row">
                                                            <div class="col-sm-6 col-sm-offset-3">
                                                                <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="row">
                                                            <div class="col-lg-12">
                                                                <div class="text-center">
                                                                    <a href="#" tabindex="5" class="forgot-password">Forgot Password?</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                                <form id="register-form" action="#" method="post" role="form" style="display: none;">
                                                    <div class="form-group">
                                                        <input required='' type='text'> 
                                                        <label alt='Email' placeholder='Email'></label>
                                                        <span class="help-block"></span>				
                                                    </div>
                                                    <div class="form-group">
                                                        <input required='' type='text' name="quantity" id="quantity" /> 
                                                        <label alt='Mobile No' placeholder='Mobile No'><span id="errmsg"></span></label>
                                                    </div>
                                                    <div class="form-group">
                                                        <input required='' type='password'> 
                                                        <label alt='Password' placeholder='Password'></label>
                                                        <span class="help-block"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <input required='' type='password'> 
                                                        <label alt='Confirm Password' placeholder='Confirm Password'></label>
                                                        <span class="help-block"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type='text' id="captcha"> 
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="row">
                                                            <div class="col-sm-6 col-sm-offset-3">
                                                                <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Submit">
                                                            </div>
                                                        </div>
                                                        <p>By clicking Create an account, you agree to our <a href="">Terms</a> and that you have read our Data Policy, including our Cookie Use. </p>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                        </div>      
                    </div>


                </div>
            </div>



            <div class="row">
                <div class="col-md-1 con">	
                </div>
                <div class="col-md-7 con">
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <img class="slide-image" src="images/home/sa.jpg" width="100%" alt="">
                            </div>
                            <div class="item">
                                <img class="slide-image" src="images/home/se.jpg" width="100%" alt="">
                            </div>
                            <div class="item">
                                <img class="slide-image" src="images/home/uv.jpg" width="100%" alt="">
                            </div>
                        </div>
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                    </div>


                    <div class="row lists">
                        <div class="col-md-3">
                            <div class="row list1">
                                Top Teams
                            </div>
                            <div class="row ranks">
                                <ul>
                                    <li>
                                        <span class="text">                                 
                                            1. Unpredictable Guys - 120 Points<span>
                                                </li>
                                                <li>
                                                    <span class="text">
                                                        2. Punjab - 113 Points<span>
                                                            </li>
                                                            <li>
                                                                <span class="text">
                                                                    3. Mumbai - 110 Points<span>
                                                                        </li>
                                                                        <li>
                                                                            <span class="text">
                                                                                4. Kolkata - 106 Points<span>
                                                                                    </li>
                                                                                    <li>
                                                                                        <span class="text">
                                                                                            5. CSK - 87 Points<span>
                                                                                                </li>
                                                                                                </ul>
                                                                                                </div>
                                                                                                </div>

                                                                                                <div class="col-md-3">
                                                                                                    <div class="row list3">
                                                                                                        Top Batsman
                                                                                                    </div>
                                                                                                    <div class="row ranks">
                                                                                                        <ul>
                                                                                                            <li>
                                                                                                                <span class="text">
                                                                                                                    1. Yuvraj - 220 Runs<span>
                                                                                                                        </li>
                                                                                                                        <li>
                                                                                                                            <span class="text">
                                                                                                                                2. Kohli - 200 Runs<span>
                                                                                                                                    </li>
                                                                                                                                    <li>
                                                                                                                                        <span class="text">
                                                                                                                                            3. Rohit - 198 Runs<span>
                                                                                                                                                </li>
                                                                                                                                                <li>
                                                                                                                                                    <span class="text">
                                                                                                                                                        4. Raina - 176 Runs<span>
                                                                                                                                                            </li>
                                                                                                                                                            <li>
                                                                                                                                                                <span class="text">
                                                                                                                                                                    5. Pandya - 102 Runs<span>
                                                                                                                                                                        </li>
                                                                                                                                                                        </ul>
                                                                                                                                                                        </div>
                                                                                                                                                                        </div>

                                                                                                                                                                        <div class="col-md-3">
                                                                                                                                                                            <div class="row list1">
                                                                                                                                                                                Top Bowlers
                                                                                                                                                                            </div>
                                                                                                                                                                            <div class="row ranks">
                                                                                                                                                                                <ul>
                                                                                                                                                                                    <li>
                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                            1. Yuvraj - 18 Wickets<span>
                                                                                                                                                                                                </li>
                                                                                                                                                                                                <li>
                                                                                                                                                                                                    <span class="text">
                                                                                                                                                                                                        2. Kohli - 15 Wickets<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        3. Rohit - 14 Wickets<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        4. Pandya - 9 Wickets<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        5. Raina - 6 Wickets<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        </ul>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <div class="col-md-3">
                                                                                                                                                                                                        <div class="row list3">
                                                                                                                                                                                                        Top Allrounders
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <div class="row ranks">
                                                                                                                                                                                                        <ul>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        1. Yuvraj - 220 Runs/ 18 Wickets<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        2. Kohli - 200 Runs/ 15 Wickets<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        3. Rohit - 198 Runs/ 14 Wickets<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        4. Raina - 176 Runs/ 6 Wickets<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        5. Pandya - 102 Runs/ 9 Wickets<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        </ul>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        </div>

                                                                                                                                                                                                        <div class="row lists">
                                                                                                                                                                                                        <div class="row list2">
                                                                                                                                                                                                        MOST VIEWED
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <div class="row ranks" id="news">

                                                                                                                                                                                                        <ul>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        India-Bangladesh soap opera set for new season <span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li >
                                                                                                                                                                                                        Rohit, Nehra hand Bangladesh a thrashing, Sami, Sharjeel in as Pakistan make changes to World T20 squad <span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        Hazlewood, Smith in umpiring controversy<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        Shahid Afridi reconsidering T20I retirement<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        Sami, Sharjeel in as Pakistan make changes to World T20 squad<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        India-Bangladesh soap opera set for new season <span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        Rohit, Nehra hand Bangladesh a thrashing<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        Hazlewood, Smith in umpiring controversy<span>
                                                                                                                                                                                                        </li>

                                                                                                                                                                                                        </ul>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <div class="col-md-3 thirdcol">
                                                                                                                                                                                                        <div class="row">
                                                                                                                                                                                                        <div class="panel with-nav-tabs panel-primary">
                                                                                                                                                                                                        <div class="panel-heading">
                                                                                                                                                                                                        <ul class="nav nav-tabs navmen">
                                                                                                                                                                                                        <li class="active"><a href="#tab1primary" data-toggle="tab">Live</a></li>
                                                                                                                                                                                                        <li><a href="#tab2primary" data-toggle="tab">Upcoming</a></li>
                                                                                                                                                                                                        <li><a href="#tab3primary" data-toggle="tab">Result</a></li>
                                                                                                                                                                                                        </ul>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <div class="panel-body">
                                                                                                                                                                                                        <div class="tab-content tabs" id="matchs">
                                                                                                                                                                                                        <div class="tab-pane fade in active" id="tab1primary">
                                                                                                                                                                                                        <ul>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        <b>Ind</b> 340/4 vs <b>Ban</b> 104/3 (34.2 Overs)<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li >
                                                                                                                                                                                                        <b>NewZeland</b> 283/6 vs <b>Aus</b> 189/7 (42 Overs)<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        <b>SA</b> 421/9 vs <b>SL</b> 220/6 (39 Overs)<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        </ul>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <div class="tab-pane fade" id="tab2primary">
                                                                                                                                                                                                        <ul>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        <b>No Upcomming Matchs </b></span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        </ul>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <div class="tab-pane fade" id="tab3primary">
                                                                                                                                                                                                        <ul>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        <b>Ind</b> 340/4 vs <b>Ban</b> 240/9 Ind won by 100 Runs<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li >
                                                                                                                                                                                                        <b>NewZeland</b> 283/6 vs <b>Aus</b> 203/7 NZ won by 80 Runs <span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        <b>SL</b> 329/9 vs <b>SA</b> 334/6 SA won by 4 Wickets<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li >
                                                                                                                                                                                                        <b>Ind</b> 340/4 vs <b>Ban</b> 240/9 Ind won by 100 Runs<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        <b>SL</b> 329/9 vs <b>SA</b> 334/6 SA won by 4 Wickets<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li >
                                                                                                                                                                                                        <b>SL</b> 329/9 vs <b>SA</b> 334/6 SA won by 4 Wickets<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        </ul>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        </div>

                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <div class="row lists">
                                                                                                                                                                                                        <div class="row list2">
                                                                                                                                                                                                        Grounds List 
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <div class="row ranks" id="ground" style='background-color:#ffffff;'>
                                                                                                                                                                                                        <ul>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        Ground 1 (Medavakkam)<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li >
                                                                                                                                                                                                        Ground 2 (Solinganalur)<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        Ground 3 (Pallikaranai)<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        Ground 4 (Velachery)<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        Ground 5 (Thambaram)<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        Ground 6 (Pallavaram)<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        Ground 7 (Kasi Medu)<span>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li>
                                                                                                                                                                                                        <span class="text">
                                                                                                                                                                                                        Ground 8 (Aavadi)<span>
                                                                                                                                                                                                        </li>

                                                                                                                                                                                                        </ul>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        </div>


                                                                                                                                                                                                        <div class="panel panel-primary" style='margin-top:15px;width:100%'>
                                                                                                                                                                                                        <div class="panel-heading">
                                                                                                                                                                                                        <h3 class="panel-title">
                                                                                                                                                                                                        <span class="glyphicon glyphicon-arrow-right"></span>How is My Site?
                                                                                                                                                                                                        </h3>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <div class="panel-body">
                                                                                                                                                                                                        <ul class="list-group">
                                                                                                                                                                                                        <li class="list-group-item">
                                                                                                                                                                                                        <div class="radio">
                                                                                                                                                                                                        <label>
                                                                                                                                                                                                        <input type="radio" name="optionsRadios">
                                                                                                                                                                                                        Good
                                                                                                                                                                                                        </label>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li class="list-group-item">
                                                                                                                                                                                                        <div class="radio">
                                                                                                                                                                                                        <label>
                                                                                                                                                                                                        <input type="radio" name="optionsRadios">
                                                                                                                                                                                                        Excellent
                                                                                                                                                                                                        </label>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li class="list-group-item">
                                                                                                                                                                                                        <div class="radio">
                                                                                                                                                                                                        <label>
                                                                                                                                                                                                        <input type="radio" name="optionsRadios">
                                                                                                                                                                                                        Better
                                                                                                                                                                                                        </label>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        </li>
                                                                                                                                                                                                        <li class="list-group-item">
                                                                                                                                                                                                        <div class="radio">
                                                                                                                                                                                                        <label>
                                                                                                                                                                                                        <input type="radio" name="optionsRadios">
                                                                                                                                                                                                        Can Be Improved
                                                                                                                                                                                                        </label>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        </li>

                                                                                                                                                                                                        </ul>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <div class="panel-footer">
                                                                                                                                                                                                        <button type="button" class="btn btn-primary btn-sm">
                                                                                                                                                                                                        Vote</button>
                                                                                                                                                                                                        <a href="#">View Result</a></div>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <div class="img-responsive displayed" align="middle">
                                                                                                                                                                                                        <a href=""><img src="images/home/android.png" width="200" height="50" border="0" alt="Android"></a>
                                                                                                                                                                                                        <a href=""><img src="images/home/appstore.png" width="200" height="50" style='margin-top:10px;' border="0" alt="Appstore"></a>


                                                                                                                                                                                                        </div>

                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <!-- /.row -->


                                                                                                                                                                                                        <div class="row-fluid" style='margin-top:15px;'>
                                                                                                                                                                                                        <div class="col-md-1">
                                                                                                                                                                                                        <img src="images/home/2.jpg" width="100" height="80" style='float:left' border="0" alt="">
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <div class="col-md-10 abt">

                                                                                                                                                                                                        <div class="text-center"> <a href="#">About Us</a>    
                                                                                                                                                                                                        <a href="#">Contact Us</a>&nbsp Follow Us
                                                                                                                                                                                                        <a href="http://facebook.com" class="btn btn-social-icon btn-facebook">
                                                                                                                                                                                                        <i class="fa fa-facebook"></i></a>    
                                                                                                                                                                                                        <a class="btn btn-social-icon btn-github"><i class="fa fa-github"></i></a>
                                                                                                                                                                                                        <a class="btn btn-social-icon btn-google-plus"><i class="fa fa-google-plus"></i></a>
                                                                                                                                                                                                        <a class="btn btn-social-icon btn-instagram"><i class="fa fa-instagram"></i></a>
                                                                                                                                                                                                        <a class="btn btn-social-icon btn-linkedin"><i class="fa fa-linkedin"></i></a>
                                                                                                                                                                                                        <a class="btn btn-social-icon btn-twitter"><i class="fa fa-twitter"></i></a>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <p class="muted pull-right"><span class="glyphicon glyphicon-copyright-mark"></span> 2013 Coeuz Technology.</p>
                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <!-- <div class="col-md-2">
                                                                                                                                                                                                        <p class="muted pull-right">© 2013 Coeuz Technology.</p>
                                                                                                                                                                                                        </div> -->
                                                                                                                                                                                                        <div class="col-md-1">
                                                                                                                                                                                                        <img src="images/home/3.jpg" width="100" height="80" border="0" alt="">

                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        </div>



                                                                                                                                                                                                        </div>
                                                                                                                                                                                                        <!-- /.container -->

                                                                                                                                                                                                        <script type="text/javascript">
                                                                                                                                                                                                        $(function () {
                                                                                                                                                                                                        $('#news').slimScroll({
                                                                                                                                                                                                        color: '#439ec9'
                                                                                                                                                                                                        });
                                                                                                                                                                                                        });
                                                                                                                                                                                                        $(function () {
                                                                                                                                                                                                        $('#ground').slimScroll({
                                                                                                                                                                                                        color: '#439ec9'
                                                                                                                                                                                                        });
                                                                                                                                                                                                        });
                                                                                                                                                                                                        $(function () {
                                                                                                                                                                                                        $('#matchs').slimScroll({
                                                                                                                                                                                                        color: '#439ec9'
                                                                                                                                                                                                        });
                                                                                                                                                                                                        });

                                                                                                                                                                                                        $('#myModal').on('hidden.bs.modal', function () {
                                                                                                                                                                                                        location.reload(true);
                                                                                                                                                                                                        })

                                                                                                                                                                                                        </script>  




                                                                                                                                                                                                        </body>

                                                                                                                                                                                                        </html>
