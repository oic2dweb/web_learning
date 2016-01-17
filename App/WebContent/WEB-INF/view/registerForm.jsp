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
<script src="${pageContext.request.contextPath}/js/form.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/title.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/registerForm.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/validationEngine.jquery.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/panel.css" rel="stylesheet">

<title>OIC情報処理技術者試験　午前対策サイト</title>

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
<div id="main">

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h1 class="panel-title">新規登録</h1>
		</div>
		<div class="panel-body">

  <form id="registerform" class="form-horizontal" method="post" action="<% request.getContextPath();%>register">
      <div class="control-group row">
      	<div class="col-sm-3">
        	<label class="control-label" for="name">お名前</label>
        </div>
        <div class="controls col-sm-6">
          <input type="text" name="name" id="name" class="validate[required,maxSize[20]] text-input form-control" data-prompt-position="centerRight:40,0">
          <input type="hidden" value="0" class="submitCount">
          <p><span class="red">※必須</span></p>
        </div>
      </div>
      <div class="control-group row">
      	<div class="col-sm-3">
        	<label class="control-label" for="kana">お名前かな</label>
        </div>
        <div class="controls col-sm-6">
          <input type="text" name="kana" id="kana" class="validate[required,maxSize[20],custom[zkana], checkUniqueness] text-input form-control" data-prompt-position="centerRight:40,0">
          <input type="hidden" value="0" class="submitCount">
          <p><span class="red">※必須</span>（全角ひらがな）</p>
        </div>
      </div>
      <div class="control-group row">
      	<div class="col-sm-3">
        	<label class="control-label" for="student_id">学籍番号</label>
        </div>
        <div class="controls col-sm-6">
          <input type="text" name="student_id" id="student_id" class="validate[required,maxSize[5],funcCall[checkUniqueStudenId]] fm text-input form-control" data-prompt-position="centerRight:40,0">
          <input type="hidden" value="0" class="submitCount">
          <p><span class="red">※必須</span>（半角英数字５文字）</p>
        </div>
      </div>
      <div class="control-group row">
      	<div class="col-sm-3">
        	<label class="control-label" for="class">クラス</label>
        </div>
        <div class="controls col-sm-3">
          <select id="class" name="class" class="validate[required] form-control" data-prompt-position="centerRight:140,0">
            <option value="">クラスを選択</option><c:forEach var="classes" items="${classes}"><option value="${classes.key}" <c:if test="${classes.key==nowclass}">selected</c:if>>${classes.value}</option></c:forEach>
          </select>
          <p><span class="red">※必須</span></p>
        </div>
      </div>
      <div class="control-group row">
      	<div class="col-sm-3">
        	<label class="control-label" for="password">パスワード</label>
        </div>
        <div class="controls col-sm-6">
          <input type="password" name="password" id="password" class="validate[required,minSize[8],maxSize[32],custom[idkigou]] fm text-input form-control" data-prompt-position="centerRight:140,0">
          <input type="hidden" value="0" class="submitCount">
          <p><span class="red">※必須</span>（半角英数字と記号（ @ - _ ）８－３２文字以内）</p>
        </div>
      </div>
      <div class="control-group row">
      	<div class="col-sm-3">
        	<label class="control-label" for="re-password">パスワード確認</label>
        </div>
        <div class="controls col-sm-6">
          <input type="password" name="re-password" id="re-password" class="validate[required,equals[password]] text-input form-control" data-prompt-position="centerRight:10,0">
          <p><span class="red">※必須</span></p>
        </div>
      </div>
      <div class="control-group row">
      	<div class="col-sm-3">
        	<label class="control-label" for="email">連絡用メールアドレス</label>
        </div>
        <div class="controls col-sm-6">
          <input type="email" name="email" id="email" class="validate[required,maxSize[36],custom[email],funcCall[checkUniqueEmail]] text-input form-control" data-prompt-position="centerRight:40,0">
          <input type="hidden" value="0" class="submitCount">
          <p><span class="red">※必須</span>（半角英数字）<span class="formcaption"><br>※ご利用されているメールアドレス等なるべく忘れにくいものを設定してください。</span></p>
        </div>
      </div>
      <div class="control-group row">
      	<div class="col-sm-3">
        	<label class="control-label" for="email">連絡用メールアドレス確認</label>
        </div>
        <div class="controls col-sm-6">
          <input type="email" name="re-email" id="re-email" class="validate[required,equals[email]] text-input form-control"  data-prompt-position="centerRight:40,0">
          <p><span class="red">※必須</span></p>
        </div>
      </div>
      <div class="controls">
        <div id="messageBox"></div>

        <button type="submit" class="submit btn btn-primary">登録</button>
        <button type="button" onclick="location.href='${pageContext.request.contextPath}/welcome'" class="cancel btn btn-default">キャンセル</button>

      </div>
    </form>
    </div>
    </div>

</div>

</body>
</html>