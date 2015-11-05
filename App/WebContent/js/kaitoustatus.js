$(document).ready(function(){
	statustable();

	function statustable(){
		$("#kaitoustatus").append("<tr>"+"<td>問</td>"+ "<td>回答</td>"+"</tr>");
		for (var i=0; i < sessionStorage.length; i++) {
			var key = sessionStorage.key(i);
			var answer = JSON.parse(sessionStorage.getItem(key));
			var pagenumber = answer.pagenum - 1;

			$("#kaitoustatus").append("<tr>"+"<td><a href='"+ CONTEXT_PATH + "login/fukushu?pagenumber=" + pagenumber + "'>"+key+"</td>"+ "<td>"+answer.uans+"</td>"+"</tr>");
		}
	}
});