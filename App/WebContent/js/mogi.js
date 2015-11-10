$(document).ready(function(){
	//セッションストレージのクリア
	
	$("#kaishi").submit(function(){
		sessionStorage.clear();
		sessionStorage.setItem("count",0);
	});
});