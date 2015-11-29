$(document).ready(function(){
	if(sessionStorage.getItem("admnselectpage")!=null){
		SelectLink(sessionStorage.getItem("admnselectpage"));
	}else{
		SelectLink("#main");
	}

	//時期でその他が選ばれたとき以外は時期入力を隠す
	var selectjiki = $('#jiki').val();
	if(selectjiki != "その他"){
		$('#jikinuryoku').hide();
	}
	$('#jiki').change(function() {
		selectjiki = $('#jiki').val();
		if(selectjiki != "その他"){
			$('#jikinuryoku').hide();
		}else{
			$('#jikinuryoku').show();
		}
	});

	var year_name = $('#yeardata').val();
	if(year_name == ""){
		$('#seyearbutton').hide();
	}
	$('#yeardata').change(function() {
		year_name = $('#yeardata').val();
		if(year_name == ""){
			$('#seyearbutton').hide();
		}else{
			$('#seyearbutton').show();
			$('#seyearbutton').html('<button type="button" onclick="location.href=\''+CONTEXT_PATH+'eb430180f1006fb41dd1e4eb4cdb508d/login/edit?year_name=' + year_name + '\'" class="btn btn-primary btn-lg">変更開始</button>');
		}
	});
	$('#check').click(function(){
		var result = confirm("本当に削除してもよろしいでしょうか？");
		if(!result){
			return false;
		}	
		
	});
});

function SelectLink(id){
	$('#main').hide();
	$('#touroku').hide();
	$('#henkou').hide();
	$('#hozonchu').hide();
	$(id).show();
	sessionStorage.setItem("admnselectpage",id);
}