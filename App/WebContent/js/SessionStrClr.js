$(document).ready(function(){
	//セッションストレージのクリア

	$(".sessionstrclr").click(function(){

		var temp = sessionStorage.getItem("selectpage");
		sessionStorage.clear();
		sessionStorage.setItem("selectpage",temp);
		sessionStorage.setItem("count",0);
		sessionStorage.setItem("kaisetsu","false");
	});
	$("#hukuall").on('click','.sessionstrclr2',function(){
		var data = sessionStorage.getItem("data");
		var temp = sessionStorage.getItem("selectpage");
		sessionStorage.clear();
		sessionStorage.setItem("selectpage",temp);
		sessionStorage.setItem("data",data);
		sessionStorage.setItem("count",0);
		sessionStorage.setItem("kaisetsu","false");
	});

});