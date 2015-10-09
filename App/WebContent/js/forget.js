$(document).ready(function(){
	$('#submit').on('click',function(){
		var email = $('#email').val();
		$('#email').val("");
		$('#message').html(messages['FORGET_MAIL_LOADING']);
		var data = {"email":email};
		var request = $.ajax({
			type:"POST",
			url:CONTEXT_PATH+"ForgetAjax",
			datatype:"json",
			data:data,
			success:function(data){
				if(data.flg=="false"){;
					$('#message').html(messages['FORGET_MAIL_ERROR']);
				}else{
					$('#true').attr("style","display:block");
					$('#false').attr("style","display:none");
				}
			}
		});
	});
});



