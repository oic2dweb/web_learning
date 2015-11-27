$(document).ready(function(){
	resulttable();

	$(".kaisetsu").click(function(){
		var kaisetsu = "true";
		window.location = "${pageContext.request.contextPath}/login/mondai";
	});

	$('.hukucheck').change(function(){
		if ($(this).prop("checked") == true) {
			sessionStorage.setItem("huku" + $(this).val(),1);
		}else{
			sessionStorage.setItem("huku" + $(this).val(),0);
		}
	});

	function resulttable(){
		//正解一覧を配列seiに取ってくる処理
		var sei = new Array();
		var request = $.ajax({
            type:"POST",
            url:CONTEXT_PATH+"KaitouResultAjax",
            datatype:"json",
            async: false,
            success: function(data){
            	for(var i=1;i<=sessionStorage.getItem("count");i++){
            		sei[i] = data[i-1].ans
            	}
            }
        });

		$("#kaitouresult").append("<tr  class='info'>"+"<td>問</td>"+ "<td>回答</td>"+"<td>正誤</td>"+"<td>復習チェック※</td>"+"</tr>");
		for (var i=1; i <= sessionStorage.getItem("count"); i++) {
			//var key = sessionStorage.key(i);
			//alert(key);
			var answer = JSON.parse(sessionStorage.getItem(i));
			var mondaiid = answer.mondaiid;
			var pagenumber = answer.pagenum - 1;
			var seigo = "×";
			if(answer.uans == sei[i]){
				seigo = "○";
			}
			$("#kaitouresult").append("<tr>"+"<td class='kaisetsu'><a href='"+ CONTEXT_PATH + "login/fukushu?pagenumber=" + pagenumber + "'>" + i + "</a></td>"+ "<td>"+answer.uans+"</td>"+"<td>"+seigo+"</td>"+"<td><input type='checkbox' id='hukusyu"+i+"' name='revision"+i+"' class='hukucheck' value=" + i +">復習</td>"+"</tr>");
			if(sessionStorage.getItem("huku" + i) == 1){
				$("#hukusyu" + i).attr('checked','checked');
			}
			//回答結果を保存するためにサーバに送信するデータの記述
			$("#kaitouresult").append("<input type='hidden' name='seigo' value='"+seigo+"'>");
		}
	}
});