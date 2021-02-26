function appeal_click(){
	//var dialog = document.querySelector('#user_dialog');
	//dialog.showModal();
	$( "#appeal_dialog" ).dialog( "open" );
}

function report74_click(){
	window.open("report74","_blank");
}

function edit_fild(val){
	document.getElementById('id_fild').value = val;
	document.getElementById('hides').submit();
}