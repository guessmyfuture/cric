 function readImageURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function (e) {
                $('#teamImg').attr('src', e.target.result)               
                $('#teamImg').css('display','block');
                $('#teamImg').attr('style','border:3px solid orange;height:100px;width:150px;margin-top:5px;');
                };

                reader.readAsDataURL(input.files[0]);
            }
 }
 
 $(document).ready(function() {     
      // $('#tossModal').modal('show');
});
