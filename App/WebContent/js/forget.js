$(document).ready(function(){
	
	$('#submit').on('click',function(){
		var email = $('#email').val();
		var secret_id = $('#secret_id').val();
		var secret_text = $('#secret_text').val();
		$('#email').val("");
		$('#secret_text').val("");
		if(secret_id == ""){
			$('#message2').html("入力内容に誤りがあります");
			return;
		}
		

		var data = {"email":email,"secret_id":secret_id,"secret_text":secret_text};
		
		var request = $.ajax({
			type:"POST",
			url:CONTEXT_PATH+"ForgetAjax",
			datatype:"json",
			data:data,
			success:function(data){
				if(data.flg=="true"){
					$('#message').html("メールが送信されました。ご確認ください。");
				}else{
					$('#message2').html("入力内容に誤りがあります");
				}
			}
		});
	});
});



