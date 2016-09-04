/**
 * 
 */
 $( function() {
    $( "#datepicker" ).datepicker();
    
    $("#indt,#outdt").datepicker();

    $("#indt").datepicker("option", "maxDate", $("#outdt").val());
    $("#indt").datepicker("option", "onClose", function ( selectedDate ) {
        $("#outdt").datepicker( "option", "minDate", selectedDate );
    });

    $("#outdt").datepicker("option", "minDate", $("#indt").val());
    $("#outdt").datepicker("option", "onClose", function ( selectedDate ) {
        $("#indt").datepicker( "option", "maxDate", selectedDate );
    });
  } 
 );
 
 