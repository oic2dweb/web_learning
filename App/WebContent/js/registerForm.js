//registerForm.jsp用のjsファイル

$(document).ready(function(){
		$("#registerform").validationEngine('attach', {
		    promptPosition:"topRight"
		});
	});

//メールと学籍番号に関するユニークチェックのAJAX処理

	function checkUniqueStudenId(field, rules, i, options){
		var data = '{"attribute":"student_id", "value":"' + field.val() + '"}';

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
			return "同じ学籍番号が登録されています";
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
			return "同じメールアドレスが登録されています";
	}


