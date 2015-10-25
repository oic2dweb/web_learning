$(document).ready(function(){
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

		function getque(status){
			var data = {"status":status};
			var request = $.ajax({
				type:"POST",
				url:CONTEXT_PATH+"MondaiAjax",
				datatype:"json",
				data:data,
				success: function(data){

					$("#pagenumber").html(data.pagenumber );
					$("#question").html(data.question);
					$("#ans1").html(data.ans1);
					$("#ans2").html(data.ans2);
					$("#ans3").html(data.ans3);
					$("#ans4").html(data.ans4);
					$("#kaisetu").html(data.kaisetu);
					$("#sei").html("正解："+data.sei);
					$("input[name=ans]").attr("checked",false);

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
					$("#kaisetu").hide();
					$("#sei").hide();


				}
				});
		}




});