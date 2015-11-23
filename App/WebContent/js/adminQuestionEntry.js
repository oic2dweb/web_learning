var mainClass;
var subClass;
$(document).ready(function(){
	//分類をサーバーから取ってくる処理
	var request = $.ajax({
		type:"POST",
		url:CONTEXT_PATH+"AdminQuestionEntryAjax",
		datatype:"json",
		async: false,
		success: function(data){
			mainClass = data.mainClass;
			subClass = data.subClass;
		}
	});

	InsertMain();
	InsertSub();

	$('input[name="qimg2"]').attr("disabled","disabled");
	$('input[name="qimg3"]').attr("disabled","disabled");
	$('input[name="qimg4"]').attr("disabled","disabled");

	if($('input[name="qnumber"]').val()=="1"){
		$('input[name="back"]').hide();
	}else if($('input[name="qnumber"]').val()==$('input[name="maxnumber"]').val()){
		$('input[name="next"]').hide();
	}

	//catnameが変更された時のイベント
	$('select[name="catname"]').change(function(){
		InsertMain();
		InsertSub();

	});

	//mainnameが変更された時のイベント
	$('select[name="mainname"]').change(function(){
		InsertSub();
	});

	//問題画像が選択されたときのイベント
	$('.qimg').change(function(){
		var count=0;
		for(var i=1;i<5;i++){
			var name = $('input[name="qimg'+i+'"]')[0].files[0];
			if(name!=null){
				$('input[name="qimg'+(i+1)+'"]').removeAttr("disabled");
				count++;

			}else{
				$('input[name="qimg'+(i+1)+'"]').attr("disabled","disabled");
			}
		}
		$('input[name="qimgcnt"]').val(count);
	});

	//回答画像が選択された時のイベント
	$('.aimg').change(function(){
		for(var i=1;i<5;i++){
			if($('input[name="aimg'+i+'"]').val()!=""){
				$('input[name="haimg'+i+'"]').val(1);
			}
		}
	});

	//解説画像が選択された時のイベント
	$('input[name="kimg"]').change(function(){
		$('input[name="hkimg"]').val(1);

	});
	
	//投稿ボタンがクリックされた時のイベント
	$('.submitbt').click(function(){
		$('input[name="submitname"]').val($(this).attr('name'));
		if($('input[name="submitname"]').val()=="posting"){
			if(!$('input[name="check"]').prop('checked')){
				alert('チェックされていません');
				return false;
			}
		}
		if($('input[name="submitname"]').attr('value')!='onetimesave'){
			if($('textarea[name="question"]').val()==""&&$('input[name="qimg1"]').val()==""&&$('input[name="qimg2"]').val()==""&&$('input[name="qimg3"]').val()==""&&$('input[name="qimg4"]').val()==""){
				$('#message').html('<font color="red">問題文章又は画像が挿入されていません</font>');
				return false;
			}
		}
		$('form[name="entry"]').submit();
	});
	$('form[name="entry"]').submit(function(){
		
		

	});
});
function InsertMain(){
	$('select[name="mainname"]').html('');
	for(var i=0;i<mainClass.length;i++){
		if($('select[name="catname"] > option:selected').attr('value')==mainClass[i].catId){
			if(mainClass[i].mainId==$('input[name="hmainname"]').val()){
				$('select[name="mainname"]').append('<option value="'+mainClass[i].mainId+'" selected>'+mainClass[i].name+'</option>');
			}else{
				$('select[name="mainname"]').append('<option value="'+mainClass[i].mainId+'">'+mainClass[i].name+'</option>');
			}
		}
	}
}

function InsertSub(){
	$('select[name="subname"]').html('');
	for(var i=0;i<subClass.length;i++){
		if($('select[name="mainname"] > option:selected').attr('value')==subClass[i].mainid){
			if(subClass[i].id==$('input[name="hsubname"]').val()){
				$('select[name="subname"]').append('<option value="'+subClass[i].id+'" selected>'+subClass[i].name+'</option>');
			}else{
				$('select[name="subname"]').append('<option value="'+subClass[i].id+'">'+subClass[i].name+'</option>');
			}

		}

	}
}

