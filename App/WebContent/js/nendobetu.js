$(document).ready(function(){
	//セッションストレージのクリア
	sessionStorage.clear();
	
	$("select").change(function () {
		$("#seyear").submit();
	});
	
});