$(document).ready(function(){
	//セッションストレージのクリア
	//sessionStorage.clear();
	$("#nendobetu").click(function(){
		$("#yeardata").val("");
	});
	
	$("#yeardata").change(function () {
		$("#seyear").submit();
	});
	
});