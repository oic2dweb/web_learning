$(document).ready(function(){
	var data2 = JSON.parse(sessionStorage.getItem("data"));
	if(data2 != null){
		sethuku(data2);
	}
	
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
	$(document).on('click', '.btns', function(){
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
		$("#hukuall").append("<tr class='info'><th>NO</th><th>論点</th><th>出題年度</th><th>復習解除</th></tr>");
		for(var i=0; i<data.question.length; i++){
    		$("#hukuall").append("<tr>"+"<td class='thcenter col-xs-1'><a href='"+ CONTEXT_PATH + "login/nenmondai?pagenumber=" + (i) + "' class='sessionstrclr no'>" + (i+1) + "</a></td>"+"<td class='col-xs-5'>" + data.question[i].ronten + "</td>"+"<td class='col-xs-2 thcenter'>" + data.question[i].yearname + "</td>"+"<td class='thcenter col-xs-1'><button class='btns btn btn-warning btn-xs' name='" + data.question[i].id + "'>解除</button></td></tr>");

    	}
	}
});