//registerForm.jsp用のjsファイル

//メールとユーザーIDに関するユニークチェックのAJAX処理
$(document).ready(function(){
	$('#name').on('focus', function(){
		checkNotNull($(this), true);
	});	
	$('#name').on('keyup', function(){
		checkNotNull($(this), true);
	});
	
	$('#kana').on('focus', function(){
		checkNotNull($(this), true);
	});	
	$('#kana').on('keyup', function(){
		checkNotNull($(this), true);
	});
	
	$('#username').on('focus', function(){
		checkNotNull($(this), false);
	});
	$('#username').on('keyup', function(){
		flag = checkNotNull($(this), false);
		if(flag){
			flag = checkAlphaNumeric($(this), false);
		}
		if(flag){
			checkUnique($(this));
		}
	});
	
	$('#password').on('focus', function(){
		checkNotNull($(this), false);
	});
	$('#password').on('keyup', function(){
		flag = checkNotNull($(this), false);
		if(flag){
			checkMinLength($(this), 4);
		}
	});
	
	$('#email').on('focus', function(){
		checkNotNull($(this), false);
	});
	$('#email').on('keyup', function(){
		flag = checkNotNull($(this), false);
		if(flag){
			flag = checkEmail($(this), false);
		}
		if(flag){
			checkUnique($(this));
		}
	});
	
	$('form').submit(function(e) {
	     e.preventDefault();
	     total = 0;
	     $('.submitCount').each(function(index, element){
				total += parseInt($(element).val());
			});
		if(total < 5){
			$('input[type=submit]').attr("disabled", "true");
			return;
		}else{
			$(this).unbind('submit').submit();
		}
	});
	
	window.setInterval(submitSwitch, 1000);
});

function checkNotNull($obj, isOk){
	if($obj.val().length <= 0){
		showMessage('REGISTER_REQUIRED', $obj);
		$obj.next().val(0);
		return false;
	}else{
		if(isOk){
			showMessage('REGISTER_OK', $obj);
			$obj.next().val(1);
		}
		return true;
	}
}

function checkMinLength($obj, len){
	if($obj.val().length > 0 && $obj.val().length < len){
		showMessage('REGISTER_MIN_LENGTH', $obj, len);
		$obj.next().val(0);
		return false;
	}else{
		showMessage('REGISTER_OK', $obj);
		$obj.next().val(1);
		return true;
	}
}

function checkAlphaNumeric($obj, isOk){
	if( /[^a-zA-Z0-9]/.test($obj.val())){
		showMessage('REGISTER_ALPHANYMERIC_REQUIRED', $obj);
		$obj.next().val(0);
		return false;
	}else{
		if(isOk){
			showMessage('REGISTER_OK', $obj);
			$obj.next().val(1);
		}
		return true;
	}
}

function checkEmail($obj, isOk){
	var regex = /\S+@\S+\.\S+/;
	if(!regex.test($obj.val())){
		showMessage('REGISTER_WRONG_EMAIL', $obj);
		$obj.next().val(0);
		return false;
	}else{
		if(isOk){
			showMessage('REGISTER_OK', $obj);
			$obj.next().val(1);
		}
		return true;
	}
}

function checkUnique($obj){
	var attribute = $obj.attr('name');
	var value = $obj.val();
	var data = '{"attribute":"' + attribute + '", "value":"' + value + '"}';
	$.ajax({
		method:'POST',
		url:CONTEXT_PATH + 'rest/user/unique',
		data: data,
		contentType:'application/json',
		success: function(result){
			if(result == 'REGISTER_OK'){
				$obj.next().val(1);
			}else{
				$obj.next().val(0);
			}
			showMessage(result, $obj);
		}
 	});
}
//サーバサイドから届いたキーを使って、メッセージを表示
function showMessage(result, $obj, len){
	if(len && len > 0){
		$obj.parent().next().html(messages[result] + len);
		return;
	}
	$obj.parent().next().html(messages[result]);
}

function submitSwitch(){
	total = 0;
	$('.submitCount').each(function(index, element){
		total += parseInt($(element).val());
	});
	if(total < 5){
		$('input[type=submit]').attr("disabled", "true");
	}else{
		$('input[type=submit]').removeAttr("disabled");
	}
}