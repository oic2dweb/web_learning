$(document).ready(function(){
	statustable();

	function statustable(){
		$("#kaitoustatus").append("<tr class='info'>"+"<td>問</td>"+ "<td>回答</td>"+"</tr>");
		for (var i=1; i <= sessionStorage.getItem("count"); i++) {
			var answer = JSON.parse(sessionStorage.getItem(i));
			var pagenumber = answer.pagenum - 1;

			$("#kaitoustatus").append("<tr>"+"<td><a href='"+ CONTEXT_PATH + "login/fukushu?pagenumber=" + pagenumber + "' class='no'>"+i+"</td>"+ "<td>"+answer.uans+"</td>"+"</tr>");
		}
	}
	$(function(){
		var limittime = 9000
		var starttime = sessionStorage.getItem("starttime");
		var time = ($.now()-starttime)/1000;
		if(time<limittime){
			$('.timer').attr("data-seconds-left",limittime-time);
		}
		if(time>limittime){
			$('.endtimer').html("00:00:00");
		}

		$('.timer').startTimer({
			onComplete: function(){
				alert("試験時間をオーバーしました。\n実際の試験では終了になりますので注意してください。");

			}

		});

	});
});