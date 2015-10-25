$(document).ready(function(){
	$('#select_class').submit(function(){
		var count = $('input[name="subid"]:checked').length;
		if(0==count){
			$('#message').html('<font color="red">※出題する項目を一つ以上選択してください</font>');
			return false;
		}
	});

	$('input[value="選択"]').click(function(){
		$('.'+$(this).attr('class')).prop("checked",true);
	});

	$('input[value="解除"]').click(function(){
		$('.'+$(this).attr('class')).prop("checked",false);
	});
});