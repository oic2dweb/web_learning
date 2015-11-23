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
<body>
<c:if test="${messagesKey != null}">
<div id="messageBox" class="alert alert-warning">
</div>
<script>

	$(document).ready(function(){
		$('#messageBox').html(messages['${messagesKey}']);
	});

</script>

</c:if>
<div id="main">
  <form action="${pageContext.request.contextPath}/login/usertemp" method="post" name="cf1" id="cf1" class="form-horizontal">
  
      <div class="control-group">
        <label class="control-label" for="name">お名前</label>
        <div class="controls">
	      <span id="name" class="control-label"></span>
	      <span><a href="#" id="open1" class="control-label">編集</a></span>
	   </div>
	  </div>
	  
	  <div class="control-group hide1">
	    <label class="control-label" for="name"></label>
	    <div class="controls">
	      <p>新しいお名前のプレビュー</p>
	    </div>
	  </div>
	  
      <div class="control-group hide1">
        <label class="control-label" for="name">お名前</label>
        <div class="controls">
          <input type="text" name="name" id="name" class="validate[required,maxSize[20],custom[zenkaku]] text-input form-control" data-prompt-position="centerRight:20,0">
          <input type="hidden" value="0" class="submitCount">
          <p>（全角文字）</p>
          <p>このお名前でよろしければ、パスワードを入力してください</p>
        </div>
      </div>
      
      <div class="control-group hide1">
        <label class="control-label" for="name">パスワード</label>
        <div class="controls">
          <input type="password" name="password1" id="password1" class="validate[required],funcCall[checkPassword]] text-input form-control" data-prompt-position="centerRight:20,0">
          <input type="hidden" value="0" class="submitCount">
        </div>
      </div>
      
      <div class="controls hide1">
        <div id="messageBox"></div>
        <span class="right">
        <input type="button" id="cancel1" value="キャンセル">
        <button type="submit" class="submit">変更を保存</button>

        </span>
      </div>
      <input type="hidden" name="attribute" value="name">
    </form>
    
    
    <form action="${pageContext.request.contextPath}/login/usertemp" method="post" name="cf2" id="cf2" class="form-horizontal">
  
      <div class="control-group">
        <label class="control-label" for="name">お名前かな</label>
        <div class="controls">
	      <span id="kana" class="control-label"></span>
	      <span><a href="#" id="open2" class="control-label">編集</a></span>
	   </div>
	  </div>
	  
	  <div class="control-group hide2">
	    <label class="control-label" for="name"></label>
	    <div class="controls">
	      <p>新しいお名前かなのプレビュー</p>
	    </div>
	  </div>
	  
      <div class="control-group hide2">
        <label class="control-label" for="name">お名前かな</label>
        <div class="controls">
          <input type="text" name="kana" id="kana" class="validate[required,maxSize[20],custom[zkana], checkUniqueness] text-input form-control" data-prompt-position="centerRight:20,0">
          <input type="hidden" value="0" class="submitCount">
          <p>（全角ひらがな）</p>
          <p>このお名前かなでよろしければ、パスワードを入力してください</p>
        </div>
      </div>
      
      <div class="control-group hide2">
        <label class="control-label" for="name">パスワード</label>
        <div class="controls">
          <input type="password" name="password2" id="password2" class="validate[required],funcCall[checkPassword]] text-input form-control" data-prompt-position="centerRight:20,0">
        </div>
      </div>
      
      <div class="controls hide2">
        <div id="messageBox"></div>
        <span class="right">
        <input type="button" id="cancel2" value="キャンセル">
        <button type="submit" class="submit">変更を保存</button>

        </span>
      </div>
      <input type="hidden" name="attribute" value="kana">
    </form>
    
    
    <form action="${pageContext.request.contextPath}/login/usertemp" method="post" name="cf3" id="cf3" class="form-horizontal">
  
      <div class="control-group">
        <label class="control-label" for="name">パスワード</label>
        <div class="controls">
	      <span id="curpassword" class="control-label">********</span>
	      <span><a href="#" id="open3" class="control-label">編集</a></span>
	   </div>
	  </div>
	  
	  <div class="control-group hide3">
	    <label class="control-label" for="name"></label>
	    <div class="controls">
	      <p>新しいパスワードのプレビュー</p>
	    </div>
	  </div>
	  
      <div class="control-group hide3">
        <label class="control-label" for="password">新規パスワード</label>
        <div class="controls">
          <input type="password" name="password" id="password" class="validate[required,minSize[4],maxSize[8]] text-input form-control" data-prompt-position="centerRight:20,0">
          <input type="hidden" value="0" class="submitCount">
          <p>（半角英数字－４文字以上８文字以内）</p>
        </div>
      </div>
      
      <div class="control-group hide3">
        <label class="control-label" for="re-password">新規パスワード再入力</label>
        <div class="controls">
          <input type="password" name="re-password" id="re-password" class="validate[required,equals[password]] text-input form-control" data-prompt-position="centerRight:20,0">
          <p><span class="red">※必須</span></p>
          <p>このパスワードでよろしければ、現在のパスワードを入力してください</p>
        </div>
      </div>
      
      <div class="control-group hide3">
        <label class="control-label" for="name">現在のパスワード</label>
        <div class="controls">
          <input type="password" name="password3" id="password3" class="validate[required],funcCall[checkPassword]] text-input form-control" data-prompt-position="centerRight:20,0">
        </div>
      </div>
      
      <div class="controls hide3">
        <div id="messageBox"></div>
        <span class="right">
        <input type="button" id="cancel3" value="キャンセル">
        <button type="submit" class="submit">変更を保存</button>

        </span>
      </div>
      <input type="hidden" name="attribute" value="password">
    </form>
   <a href="#/testRecords">戻る</a>
</div>
</body>
</html>


