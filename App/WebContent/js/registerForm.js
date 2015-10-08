//registerForm.jsp用のjsファイル

$(document).ready(function(){
		$("#registerform").validationEngine('attach', {
		    promptPosition:"topRight"
		});
	});

//メールとユーザーIDに関するユニークチェックのAJAX処理

	function checkUniqueUsername(field, rules, i, options){
		var data = '{"attribute":"username", "value":"' + field.val() + '"}';
		
		var flag = false;
		$.ajax({
			method:'POST',
			url:CONTEXT_PATH + 'rest/user/unique',
			data: data,
			async:false,
			contentType:'application/json',
			success: function(result){
				if(result != 'REGISTER_OK'){
					return flag = true;
				}
			}
		});
		
		if(flag)
			return "同じユーザーIDは登録されています。";
	}
	
	function checkUniqueEmail(field, rules, i, options){
		var data = '{"attribute":"email", "value":"' + field.val() + '"}';
		
		var flag = false;
		$.ajax({
			method:'POST',
			url:CONTEXT_PATH + 'rest/user/unique',
			data: data,
			async:false,
			contentType:'application/json',
			success: function(result){
				if(result != 'REGISTER_OK'){
					return flag = true;
				}
			}
		});
		
		if(flag)
			return "同じメールは登録されています。";
	}


