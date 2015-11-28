$(document).ready(function(){

	if(sessionStorage.getItem("selectpage")!=null){
		SelectLink(sessionStorage.getItem("selectpage"));
	}else{
		SelectLink("#bunya");
	}

	$('#select_class').submit(function(){
		var count = $('input[name="subid"]:checked').length;
		if(0==count){
			$('#message').html('<font color="red">※出題する項目を一つ以上選択してください</font>');
			return false;
		}
	});

	$('input[value="選択"]').click(function(){
		$('.'+$(this).attr('name')).prop("checked",true);
	});

	$('input[value="解除"]').click(function(){
		$('.'+$(this).attr('name')).prop("checked",false);
	});
	$('#nendobetu').click(function(){
		$('#nendoquestion').html("");
	});

});
function SelectLink(id){
	$('#bunya').hide();
	$('#nendo').hide();
	$('#mogi').hide();
	$('#hukusyu').hide();
	$(id).show();
	sessionStorage.setItem("selectpage",id);
}