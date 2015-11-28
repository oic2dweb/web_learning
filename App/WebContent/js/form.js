$(document).ready(function(){
	//フォームの全角英数を半角英数に変換
	$('.fm').change(function(){
		var txt  = $(this).val();
		var han = txt.replace(/[Ａ-Ｚａ-ｚ０-９]/g,function(s){return String.fromCharCode(s.charCodeAt(0)-0xFEE0)});
		$(this).val(han);
	});
});