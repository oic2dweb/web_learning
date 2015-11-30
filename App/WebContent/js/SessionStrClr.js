$(document).ready(function(){
	//セッションストレージのクリア

	$(".sessionstrclr").click(function(){
		var temp = sessionStorage.getItem("selectpage");
		sessionStorage.clear();
		sessionStorage.setItem("selectpage",temp);
		sessionStorage.setItem("count",0);
		sessionStorage.setItem("kaisetsu","false");
	});

});