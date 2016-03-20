$(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});
$(document).ready(function () {
  //called when key is pressed in textbox
  $("#quantity").keypress(function (e) {
     //if the letter is not digit then display error and don't type anything
     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        //display error message
        $("#errmsg").html("Digits Only").show().fadeOut("slow");
               return false;
    }
   });
});
$(document).ready(function() { 
	initCaptcha();
	
	setInterval(function() {
		initCaptcha();
	}, 10000);
});

function initCaptcha() {
	var captcha = generateCaptcha(),
		captchaAns = eval(captcha);
	
	$("#captcha")
		.attr("placeholder", captcha+" = ")
		.on("keyup", function() {
			if ($(this).val() !== "" && $(this).val() == captchaAns)
				$(this).addClass("correct");
			else
				$(this).removeClass("correct");
		});
}

function generateCaptcha() {
	var randomNo = function(n) {
		return Math.floor(Math.random()*n + 1);
	}

	var randomOp = function() {
		return "+-*"[randomNo(3)-1];
	}
	return randomNo(10)+" "+randomOp()+" "+randomNo(10);
}

