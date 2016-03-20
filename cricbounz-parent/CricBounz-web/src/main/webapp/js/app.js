
var app = angular.module( 'plunker' , [] );


/*app.controller( 'MainCtrl' , function( $scope ) {

  $scope.titles = [ "Action Comics" , "Detective Comics" , "Superman" , "Fantastic Four" , "Amazing Spider-Man" ];

  $scope.addItem = function( item ) {
    if ( !_.contains( $scope.titles , item.title ) ){
      $scope.titles.push( item.title );
    } 
    $scope.item = {};
  }
});*/


app.controller( 'MainCtrl' , function( $scope ) {
    alert('');
  $scope.loadMe = function() {
     $scope.titles = [ "Tamil" , "English" , "Maths" , "Science" , "Sanskrit","Telughu","Kannada","Malayalam" ];
     alert('jai');
  }
});

