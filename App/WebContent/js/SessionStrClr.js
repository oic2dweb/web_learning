$(document).ready(function(){
	//セッションストレージのクリア

	$(".sessionstrclr").click(function(){
		sessionStorage.clear();
		sessionStorage.setItem("count",0);
		sessionStorage.setItem("kaisetsu","false");
	});

});