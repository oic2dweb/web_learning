$(document).ready(function(){
	var data2 = JSON.parse(sessionStorage.getItem("data"));
	if(data2 != null){
		sethuku(data2);
		}


	//セッションストレージのクリア
	//sessionStorage.clear();
	$('a[href="#hukusyu"]').click(function(){
		var request = $.ajax({
            type:"GET",
            url:CONTEXT_PATH+"HukusyuAjax",
            datatype:"json",
            async: false,
            success: function(data){
            	sessionStorage.setItem("data", JSON.stringify(data));
            	sethuku(data);
            }
		});

	});
	$(document).on('click', '.btn', function(){
		//alert("aaa");
		var selectId = {"id":$(this).attr('name')};
		//alert(selectNo);
		var request = $.ajax({
			type:"POST",
            url:CONTEXT_PATH+"HukusyuAjax",
            datatype:"json",
            data:selectId,
            async: false,
            success: function(data){
            	sessionStorage.setItem("data", JSON.stringify(data));
            	sethuku(data);
            }
		});
	});
	function sethuku(data){
		$("#hukuall").html("");
		$("#hukuall").append("<tr><th>NO</th><th>論点</th><th>出題年度</th><th>復習解除</th></tr>");
		for(var i=0; i<data.question.length; i++){
    		$("#hukuall").append("<tr>"+"<td><a href='"+ CONTEXT_PATH + "login/nenmondai?pagenumber=" + (i) + "'>" + (i+1) + "</a></td>"+"<td>" + data.question[i].ronten + "</td>"+"<td>" + data.question[i].yearname + "</td>"+"<td><button class='btn' name='" + data.question[i].id + "'>解除</button></td></tr>");
    	//alert(data.question[1].ronten);
    	}
	}
});