<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validationEngine.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validationEngine-ja.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/registerForm.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/title.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/registerForm.css" rel="stylesheet">
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

  <h1 id="subtitle">
  新規登録
  </h1>

  <ul class="breadrumb">
    <li><a href="${pageContext.request.contextPath}/welcome">ログインメニュー</a><span class="divider"> > </span></li>
    <li class="active"><a href="#">新規登録</a></li>
  </ul>

  <form id="registerform" class="form-horizontal" method="post" action="<% request.getContextPath();%>register">
      <div class="control-group">
        <label class="control-label" for="name">お名前</label>
        <div class="controls">
          <input type="text" name="name" id="name" class="validate[required,maxSize[20],custom[zenkaku]] text-input form-control" data-prompt-position="centerRight:150,0">
          <input type="hidden" value="0" class="submitCount">
          <p><span class="red">※必須</span>（全角文字）</p>
        </div>
      </div>
      <div class="control-group">
        <label class="control-label" for="name">お名前かな</label>
        <div class="controls">
          <input type="text" name="kana" id="kana" class="validate[required,maxSize[20],custom[zkana], checkUniqueness] text-input form-control" data-prompt-position="centerRight:170,0">
          <input type="hidden" value="0" class="submitCount">
          <p><span class="red">※必須</span>（全角ひらがな）</p>
        </div>
      </div>
      <div class="control-group">
        <label class="control-label" for="username">ユーザーID</label>
        <div class="controls">
          <input type="text" name="username" id="username" class="validate[required,maxSize[50],custom[idkigou],funcCall[checkUniqueUsername]] text-input form-control" data-prompt-position="centerRight:320,0">
          <input type="hidden" value="0" class="submitCount">
          <p><span class="red">※必須</span>（半角英数字と記号（ @ - _ ）－５０文字以内）</p>
        </div>
      </div>
      <div class="control-group">
        <label class="control-label" for="password">パスワード</label>
        <div class="controls">
          <input type="password" name="password" id="password" class="validate[required,minSize[4],maxSize[8]] text-input form-control" data-prompt-position="centerRight:280,0">
          <input type="hidden" value="0" class="submitCount">
          <p><span class="red">※必須</span>（半角英数字－４文字以上８文字以内）</p>
        </div>
      </div>
      <div class="control-group">
        <label class="control-label" for="re-password">パスワード確認</label>
        <div class="controls">
          <input type="password" name="re-password" id="re-password" class="validate[required,equals[password]] text-input form-control" data-prompt-position="centerRight:80,0">
          <p><span class="red">※必須</span></p>
        </div>
      </div>
      <div class="control-group">
        <label class="control-label" for="email">連絡用メールアドレス</label>
        <div class="controls">
          <input type="email" name="email" id="email" class="validate[required,maxSize[36],custom[email],funcCall[checkUniqueEmail]] text-input form-control" data-prompt-position="centerRight:160,0">
          <input type="hidden" value="0" class="submitCount">
          <p><span class="red">※必須</span>（半角英数字）<span class="formcaption"><br>※ご利用されているメールアドレス等なるべく忘れにくいものを設定してください。</span></p>
        </div>
      </div>
      <div class="control-group">
        <label class="control-label" for="email">連絡用メールアドレス確認</label>
        <div class="controls">
          <input type="email" name="re-email" id="re-email" class="validate[required,equals[email]] text-input form-control"  data-prompt-position="centerRight:80,0">
          <p><span class="red">※必須</span></p>
        </div>
      </div>
      <div class="controls">
        <div id="messageBox"></div>
        <span class="right">
        <button type="submit" class="submit">登録</button>

        <button type="button" onclick="location.href='${pageContext.request.contextPath}/welcome'" class="cancel">キャンセル</button>
        </span>
      </div>
    </form>

</div>

</body>
</html>