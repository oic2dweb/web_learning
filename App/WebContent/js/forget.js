$(document).ready(function(){
	$('#submit').on('click',function(){
		var email = $('#email').val();
		$('#email').val("");
		$('#message').html("メールが送信されました。ご確認ください。");
		var data = {"email":email};
		var request = $.ajax({
			type:"POST",
			url:CONTEXT_PATH+"ForgetAjax",
			datatype:"json",
			data:data,
			success:function(data){
				if(data.flg=="false"){;
					$('#message').html("現在この機能はご利用できません、管理者にお問い合わせください。");
				}
			}
		});
	});
});



