$(document).ready(function(){
	var pagenumber;	//現在の問題番号を格納する変数
	var answer = {	//ユーザーの解答を格納するオブジェクト
			uans: "",
			mondaiid: "",
			pagenum: ""
	}
	var kaisetsu = "false";	//回答結果から飛んできた時のフラグを格納する変数

		getque("");

		$("#back").click(function(){
			getque("back");
		});
		$("#next").click(function(){
			getque("next");
		});
		$("#open").click(function(){
			$("#kaisetu").slideDown();
			$("#sei").slideDown();
		});

		//ラジオボタンの選択を変えた時の処理
		$('input[name="ans"]:radio').change(function(){
			answer.uans = $('input[name="ans"]:checked').val();
			//セッションストレージにラジオボタンの値を保存
			sessionStorage.setItem(pagenumber, JSON.stringify(answer));
		});

		function getque(status){
			answer.uans = "　";	//解答をスペースで初期化
			$("input[name=ans]").attr("checked",false);	//ラジオボタンの初期化

			var data = {"status":status};
			var request = $.ajax({
				type:"POST",
				url:CONTEXT_PATH+"MondaiAjax",
				datatype:"json",
				data:data,
				success: function(data){

					answer.mondaiid = data.id;
					pagenumber = data.pagenumber;
					answer.pagenum = pagenumber;
					var ans = JSON.parse(sessionStorage.getItem(pagenumber));

					//セッションストレージに値がないとき初期化
					if(ans == null){
						sessionStorage.setItem(pagenumber, JSON.stringify(answer));
					}else if(ans.uans != "　"){
						//セッションストレージから値を取得しラジオボタンにチェック
						$('input[name="ans"]').val([ans.uans]);
					}

					$("#pagenumber").html(data.pagenumber );
					$("#question").html(data.question);
					$("#ans1").html(data.ans1);
					$("#ans2").html(data.ans2);
					$("#ans3").html(data.ans3);
					$("#ans4").html(data.ans4);
					$("#kaisetu").html(data.kaisetu);
					$("#sei").html("正解："+data.sei);

					if(data.pagenumber == "1"){
						$("#back").hide();
						$("#result").hide();
					}else{
						$("#back").show();
						$("#result").hide();
					}
					if(data.pagenumber == $("#allque").val()){
						$("#next").hide();
						$("#result").show();
					}else{
						$("#next").show();
					}
					if(kaisetsu = "false"){
						$("#open").hide();
					}
					$("#kaisetu").hide();
					$("#sei").hide();
					if(sessionStorage.getItem("count")<$('#pagenumber').html()){
						sessionStorage.setItem("count",$('#pagenumber').html());
					}
					
					
				}
				});
		}

});