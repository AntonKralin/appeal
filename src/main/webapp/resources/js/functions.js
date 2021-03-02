function appeal_click(){
	$( "#appeal_dialog" ).dialog( "open" );
}

function report_click(){
	$( "#report_dialog" ).dialog( "open" );
}

function edit_fild(val){
	document.getElementById('id_fild').value = val;
	document.getElementById('hides').submit();
}