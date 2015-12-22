<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validationEngine.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validationEngine-ja.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/userUpdate.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" rel="stylesheet">

<link href="${pageContext.request.contextPath}/css/validationEngine.jquery.css" rel="stylesheet">

<title>OIC基本情報技術者試験　午前対策サイト</title>

</head>
<body class="container">
<c:if test="${messagesKey != null}">
<div id="messageBox" class="alert alert-warning">
</div>
<script>

	$(document).ready(function(){
		$('#messageBox').html(messages['${messagesKey}']);
	});

</script>

</c:if>
<div id="main" class="well">
	<form action="${pageContext.request.contextPath}/login/usertemp" method="post" name="cf1" id="cf1" class="form-horizontal">
  
		<div class="control-group panel panel-primary">
      		<div class="panel-heading">
      			<label class="control-label" for="name">お名前</label>
      			<span><a href="#" id="open1" class="control-label">編集</a></span>
      		</div>
      		<div class="panel-body">
      			<div class="control">
	  				<span id="name" class="control-label"></span>
	   			</div>
	   			<div class="well hide1">
	   				<div class="control-group">
						<label class="control-label" for="name"></label>
						<div class="controls">
							新しいお名前のプレビュー
						</div>
					</div>
					<div class="control-group">
						<div class="row">
							<div class="col-sm-4">
        						<label class="control-label" for="name">お名前</label>
        					</div>
        				</div>
        				<div class="controls">
        					<div class="row">
        						<div class="col-sm-7">		
          							<input type="text" name="name" id="name" class="validate[required,maxSize[20],custom[zenkaku]] text-input form-control" data-prompt-position="centerRight:20,0">
								</div>
							</div>
							<input type="hidden" value="0" class="submitCount">
							<p>（全角文字）</p>
							<p>このお名前でよろしければ、パスワードを入力してください</p>
						</div>
					</div>
					<div class="control-group">
						<div class="row">
							<div class="col-sm-4">
								<label class="control-label" for="name">パスワード</label>
							</div>
						</div>			
        				<div class="controls">
        					<div class="row">
        						<div class="col-sm-7">	
          							<input type="password" name="password1" id="password1" class="validate[required],funcCall[checkPassword]] text-input form-control" data-prompt-position="centerRight:20,0">
          						</div>
          					</div>
          					<input type="hidden" value="0" class="submitCount">
						</div>
      				</div>
					<div class="controls">
						<div id="messageBox"></div>
						<div class="row">
							<div class="col-sm-12">
								<input type="button" id="cancel1" value="キャンセル" class="btn btn-default">
								<button type="submit" class="submit btn btn-info">変更を保存</button>
							</div>
						</div>	
					</div>
					<input type="hidden" name="attribute" value="name">
				</div>
	   		</div>
	  	</div>
    </form>
    
    
    <form action="${pageContext.request.contextPath}/login/usertemp" method="post" name="cf2" id="cf2" class="form-horizontal">
  		<div class="control-group panel panel-primary">
			<div class="panel-heading">
				<label class="control-label" for="name">お名前かな</label>
				<span><a href="#" id="open2" class="control-label">編集</a></span>
			</div>
			<div class="panel-body">
				<div class="controls">
					<span id="kana" class="control-label"></span>
				</div>
				<div class="well hide2">
					<div class="control-group">
						<label class="control-label" for="name"></label>
	    				<div class="controls">
							<p>新しいお名前かなのプレビュー</p>
						</div>
					</div>
					<div class="control-group">
						<div class="row">
							<div class="col-sm-4">
								<label class="control-label" for="name">お名前かな</label>
							</div>
						</div>
						<div class="controls">
							<div class="row">
        						<div class="col-sm-7">	
 									<input type="text" name="kana" id="kana" class="validate[required,maxSize[20],custom[zkana], checkUniqueness] text-input form-control" data-prompt-position="centerRight:20,0">
								</div>
							</div>
							<input type="hidden" value="0" class="submitCount">
							<p>（全角ひらがな）</p>
							<p>このお名前かなでよろしければ、パスワードを入力してください</p>
						</div>
					</div>
					<div class="control-group">
						<div class="row">
							<div class="col-sm-4">
								<label class="control-label" for="name">パスワード</label>
							</div>
						</div>
        				<div class="controls">
        					<div class="row">
        						<div class="col-sm-7">
          							<input type="password" name="password2" id="password2" class="validate[required],funcCall[checkPassword]] text-input form-control" data-prompt-position="centerRight:20,0">
        						</div>
        					</div>
        				</div>
					</div>
					<div class="controls">
        				<div id="messageBox"></div>
        				<div class="row">
							<div class="col-sm-12">
        						<input type="button" id="cancel2" value="キャンセル" class="btn btn-default">
        						<button type="submit" class="submit btn btn-info">変更を保存</button>
							</div>
						</div>
					</div>
      				<input type="hidden" name="attribute" value="kana">
				</div>
			</div>
		</div>		
	</form>
    
	<form action="${pageContext.request.contextPath}/login/usertemp" method="post" name="cf3" id="cf3" class="form-horizontal">
		<div class="control-group panel panel-primary">
        	<div class="panel-heading">
        		<label class="control-label" for="name">パスワード</label>
        		<span><a href="#" id="open3" class="control-label">編集</a></span>	
        	</div>
        	<div class="panel-body">
        		<div class="controls">
        			<span id="curpassword" class="control-label">********</span>
					
				</div>
				
				<div class="well hide3">
					<div class="control-group">
						<label class="control-label" for="name"></label>
						<div class="controls">
	      					<p>新しいパスワードのプレビュー</p>
						</div>
					</div>
					  
					<div class="control-group">
						<div class="row">
							<div class="col-sm-4">
        						<label class="control-label" for="password">新規パスワード</label>
        					</div>
        				</div>
        				<div class="controls">
        					<div class="row">
        						<div class="col-sm-7">
          							<input type="password" name="password" id="password" class="validate[required,minSize[8],maxSize[32]] text-input form-control" data-prompt-position="centerRight:20,0">
          						</div>
          					</div>
          					<input type="hidden" value="0" class="submitCount">
							<p>（半角英数字－８文字以上３２文字以内）</p>
						</div>
					</div>
					<div class="control-group">
						<div class="row">
							<div class="col-sm-4">
        						<label class="control-label" for="re-password">新規パスワード再入力</label>
        					</div>
        				</div>
        				<div class="controls">
        					<div class="row">
        						<div class="col-sm-7">
          							<input type="password" name="re-password" id="re-password" class="validate[required,equals[password]] text-input form-control" data-prompt-position="centerRight:20,0">
          						</div>
          					</div>
          					<p><span class="red">※必須</span></p>
          					<p>このパスワードでよろしければ、現在のパスワードを入力してください</p>
        				</div>
      				</div>
					<div class="control-group">
						<div class="row">
							<div class="col-sm-4">
        						<label class="control-label" for="name">現在のパスワード</label>
        					</div>
        				</div>
        				<div class="controls">
        					<div class="row">
        						<div class="col-sm-7">
          							<input type="password" name="password3" id="password3" class="validate[required],funcCall[checkPassword]] text-input form-control" data-prompt-position="centerRight:20,0">
        						</div>
        					</div>
        				</div>
      				</div>
					<div class="controls">
        				<div id="messageBox"></div>
        				<div class="row">
							<div class="col-sm-12">
        						<input type="button" id="cancel3" value="キャンセル" class="btn btn-default">
        						<button type="submit" class="submit btn btn-info">変更を保存</button>
							</div>
						</div>
      				</div>
					<input type="hidden" name="attribute" value="password">
				</div>
			</div>
		</div>
    </form>
   	<a href="#/testRecords">戻る</a>
</div>
</body>
</html>


