var mainClass;
var subClass;
var tags = [];
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
	$('input[name="qimg1"]').change(function(){
		var txt = $('textarea[name="question"]').html();
		$('textarea[name="question"]').html(txt.replace(/@@img1@@/g,""));
		$('textarea[name="question"]').append('@@img1@@');
	});
		
	$('input[name="qimg2"]').change(function(){
		var txt = $('textarea[name="question"]').html();
		$('textarea[name="question"]').html(txt.replace(/@@img2@@/g,""));
		$('textarea[name="question"]').append('@@img2@@');
	});
	$('input[name="qimg3"]').change(function(){
		var txt = $('textarea[name="question"]').html();
		$('textarea[name="question"]').html(txt.replace(/@@img3@@/g,""));
		$('textarea[name="question"]').append('@@img3@@');
	});
	$('input[name="qimg4"]').change(function(){
		var txt = $('textarea[name="question"]').html();
		$('textarea[name="question"]').html(txt.replace(/@@img4@@/g,""));
		$('textarea[name="question"]').append('@@img4@@');
	});
	$('input[name="aimg1"]').change(function(){
		var txt = $('textarea[name="ans1"]').html();
		$('textarea[name="ans1"]').html(txt.replace(/@@img@@/g,""));
		$('textarea[name="ans1"]').append('@@img@@');
	});
	$('input[name="aimg2"]').change(function(){
		var txt = $('textarea[name="ans2"]').html();
		$('textarea[name="ans2"]').html(txt.replace(/@@img@@/g,""));
		$('textarea[name="ans2"]').append('@@img@@');
	});
	$('input[name="aimg3"]').change(function(){
		var txt = $('textarea[name="ans3"]').html();
		$('textarea[name="ans3"]').html(txt.replace(/@@img@@/g,""));
		$('textarea[name="ans3"]').append('@@img@@');
	});
	$('input[name="aimg4"]').change(function(){
		var txt = $('textarea[name="ans4"]').html();
		$('textarea[name="ans4"]').html(txt.replace(/@@img@@/g,""));
		$('textarea[name="ans4"]').append('@@img@@');
	});
	$('input[name="kimg"]').change(function(){
		var txt = $('textarea[name="kaisetu"]').html();
		$('textarea[name="kaisetu"]').html(txt.replace(/@@img@@/g,""));
		$('textarea[name="kaisetu"]').append('@@img@@');
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
	
	
	//タグ挿入ボタン
	$(".insert_tag").click(function(){
		
		if($('textarea[name="question"]').selection().length!=0){
			$('textarea[name="question"]').selection('insert',{text:"<"+$(this).attr("name")+">",mode:'before'});
			$('textarea[name="question"]').selection('insert',{text:"</"+$(this).attr("name")+">",mode:'after'});
		}else{
			if($(this).attr('class').split(' ')[2]=='insert_tag'){
				InsertTag($(this).attr("name"));
				$(this).addClass('close_tag');
				$(this).removeClass('insert_tag');
			}else{
				var tag = "</"+$(this).attr("name")+">"
				for(var i=tags.length-1;0<=i;i--){
					if(tag==tags[i]){
						$('textarea[name="question"]').selection('insert',{text:tags[i],mode:'before'});
						delete tags[i];
					}
				}
				$(this).addClass('insert_tag');
				$(this).removeClass('close_tag');
			}
		}
		
		
		
	});
	
	//タグ閉じるボタン
	$('.close_tags').click(function(){
		for(var i=0;0<tags.length;i++){
			//$('textarea[name="question"]').append(tags.pop());
			$('textarea[name="question"]').selection('insert',{text:tags.pop(),mode:'before'});
		}
		$('.close_tag').addClass('insert_tag');
		$('.close_tag').removeClass('close_tag');
	});

	//解説画像が選択された時のイベント
	$('input[name="kimg"]').change(function(){
		$('input[name="hkimg"]').val(1);

	});

	//submitボタンが押された時のイベント
	$('.submitbt').click(function(){
		$('input[name="submitname"]').val($(this).attr('name'));
		if($('input[name="submitname"]').val()=="posting"){
			if(!$('input[name="check"]').prop('checked')){
				alert('チェックされていません');
				return false;
			}
		}
		
		if($('input[name="submitname"]').attr('value')!='onetimesave'&&$('input[name="submitname"]').attr('value')!='back'&&$('input[name="submitname"]').attr('value')!='list'){
			if($('input[name="ronten"]').val()==""){
				$('#message').html('<font color="red">論点の文章が入力されていません</font>');
				return false;
			}
			if($('textarea[name="question"]').val()==""&&$('input[name="qimg1"]').val()==""&&$('input[name="qimg2"]').val()==""&&$('input[name="qimg3"]').val()==""&&$('input[name="qimg4"]').val()==""){
				$('#message').html('<font color="red">問題文章又は画像が挿入されていません</font>');
				return false;
			}
			if($('textarea[name="ans1"]').val()==""&&$('input[name="aimg1"]').val()==""){
				$('#message').html('<font color="red">回答「ア」の文章又は画像が挿入されていません</font>');
				return false;
			}
			if($('textarea[name="ans2"]').val()==""&&$('input[name="aimg2"]').val()==""){
				$('#message').html('<font color="red">回答「イ」の文章又は画像が挿入されていません</font>');
				return false;
			}
			if($('textarea[name="ans3"]').val()==""&&$('input[name="aimg3"]').val()==""){
				$('#message').html('<font color="red">回答「ウ」の文章又は画像が挿入されていません</font>');
				return false;
			}
			if($('textarea[name="ans4"]').val()==""&&$('input[name="aimg4"]').val()==""){
				$('#message').html('<font color="red">回答「エ」の文章又は画像が挿入されていません</font>');
				return false;
			}
			switch($('select[name="sei"]').val()){
			case "ア":
			case "イ":
			case "ウ":
			case "エ":break;
			default:$('#message').html('<font color="red">正答が選択されていません</font>');return false;
			}
			if($('textarea[name="kaisetu"]').val()==""&&$('input[name="kimg"]').val()==""){
				$('#message').html('<font color="red">解説の文章又は画像が挿入されていません</font>');
				return false;
			}
		}
		/*
		var text = $('textarea[name="question"]').html();
		text = text.replace(/\r\n/g,'\n');
		text = text.replace(/\r/g,'\n');
		$('textarea[name="question"]').html(text.replace(/\n/g,'<br>'));
		*/
		$('form[name="entry"]').submit();
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
function InsertTag(str){
	var tag = "<"+str+">"
	tags.push("</"+str+">")
	//$('textarea[name="question"]').append(tag);
	$('textarea[name="question"]').selection('insert',{text:tag,mode:'before'});
}
