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
});