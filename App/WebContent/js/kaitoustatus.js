$(document).ready(function(){
	statustable();

	function statustable(){
		$("#kaitoustatus").append("<tr>"+"<td>問</td>"+ "<td>回答</td>"+"</tr>");
		for (var i=0; i < sessionStorage.length; i++) {
			var key = sessionStorage.key(i);
			var answer = sessionStorage.getItem(key);

			$("#kaitoustatus").append("<tr>"+"<td>"+key+"</td>"+ "<td>"+answer+"</td>"+"</tr>");
		}
	}
});