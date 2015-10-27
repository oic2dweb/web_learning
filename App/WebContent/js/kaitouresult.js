$(document).ready(function(){
	resulttable();

	function resulttable(){

		//正解一覧を配列seiに取ってくる処理
		var sei = new Array();
		var request = $.ajax({
            type:"POST",
            url:CONTEXT_PATH+"KaitouResultAjax",
            datatype:"json",
            async: false,
            success: function(data){
            	for(var i=0;i<sessionStorage.length;i++){
            		sei[i] = data[i].ans
            	}
            }
        });
		$("#kaitouresult").append("<tr>"+"<td>問</td>"+ "<td>回答</td>"+"<td>正誤</td>"+"<td>復習チェック※</td>"+"</tr>");
		for (var i=0; i < sessionStorage.length; i++) {
			var key = sessionStorage.key(i);
			var answer = sessionStorage.getItem(key);
			var seigo = "×";
			if(answer == sei[i]){
				seigo = "○";
			}
			$("#kaitouresult").append("<tr>"+"<td>"+key+"</td>"+ "<td>"+answer+"</td>"+"<td>"+seigo+"</td>"+"<td><input type='checkbox' name='revision' value='" + key + "'>復習</td>"+"</tr>");
		}
	}
});