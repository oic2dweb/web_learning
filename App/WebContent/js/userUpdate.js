
$(document).ready(function(){
	$("#cf1").validationEngine('attach', {
	    promptPosition:"topRight"
	});
	$("#cf2").validationEngine('attach', {
	    promptPosition:"topRight"
	});
	$("#cf3").validationEngine('attach', {
	    promptPosition:"topRight"
	});


	$.ajax({
		method:'POST',
		url:CONTEXT_PATH + 'rest/user/userinfo',
		success:function(data){
			$("#name").html(data.name);
			$("#kana").html(data.kana);
		}
	});

	$('.hide1').hide();
	$('.hide2').hide();
	$('.hide3').hide();

});


	$('#open1').click(function(){
		$('.hide1').slideDown();
		$('.hide2').hide();
		$('.hide3').hide();
	});

	$('#cancel1').click(function(){
		$('.hide1').slideUp();
	});


	$('#open2').click(function(){
		$('.hide2').slideDown();
		$('.hide1').hide();
		$('.hide3').hide();
	});

	$('#cancel2').click(function(){
		$('.hide2').slideUp();
	});


	$('#open3').click(function(){
		$('.hide3').slideDown();
		$('.hide1').hide();
		$('.hide2').hide();
	});

	$('#cancel3').click(function(){
		$('.hide3').slideUp();
	});


	function checkPassword(field){
		var data = {"value":field.val()};
		var flag = false;

		var request = $.ajax({
			method:"GET",
			url:CONTEXT_PATH + "UserUpdateAjax",
			async:false,
			contentType:"json",
			data: data,
			success: function(result){
				var temp = result.result;
				if(temp != true){
					return flag = true;
				}
			}
		});

		if(flag)
			return "パスワードが間違っています";
	}

