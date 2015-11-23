$(document).ready(function(){

		var url = getParam();
		var data = {"url":url};
		var flag = false;
		var request = $.ajax({
			type:"POST",
			url:CONTEXT_PATH+"CheckUrlAjax",
			async:false,
			datatype:"json",
			data:data,
			success: function(result){
				var temp = result.result;
				if(temp == true){
					return flag = true;
				}
			}
		});

		if(flag){
			$('#state').text('登録が完了しました');
			$.ajax({
				type:"POST",
				url:CONTEXT_PATH+"UserUpdateCommitAjax",
				datatype:"json",
				data:data,
			});
		}else{
			$('#state').text('この変更受付情報は無効です');
		}
});

function getParam() {
	var url = location.href;
	parameters = url.split("?");
	params = parameters[1].split("&");
	var paramsArray = [];
	for(i=0;i<params.length;i++){
		neet = params[i].split("=");
		paramsArray.push(neet[0]);
		paramsArray[neet[0]] = neet[1];
	}
	var categorykey = paramsArray["id"];
	return categorykey;
}