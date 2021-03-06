<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/form.js"></script>
<script src="${pageContext.request.contextPath}/js/welcome.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/title.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/loginForm.css" rel="stylesheet">

<title>OIC情報処理技術者試験　午前対策サイト</title>
</head>
<body class="container">

<div id="main">

  <h3 id="maintitle">
  OIC　情報処理技術者試験<br>午前対策サイト
  </h3>

  <div class="loginformwrap">
    <form id="loginform" class="form-vertical" method="post" action="${pageContext.request.contextPath}/login">
    <p>ログイン</p>
      <div class="control-group">
        <label class="control-label" for="student_id">学籍番号</label>
        <div class="controls">
          <input type="text" name="student_id" id="student_id" class="form-control fm">
        </div>
      </div>
      <div class="control-group">
        <label class="control-label" for="password">パスワード</label>
        <div class="controls">
          <input type="password" name="password" id="password" class="form-control fm">
        </div>
      </div>
      <div class="controls">
        <button type="submit" class="login btn btn-primary" id="login_btn">ログイン</button>
      </div>
    </form>
    <a href="${pageContext.request.contextPath}/register" id="register" class="btn link">新規登録</a>
    <a href="${pageContext.request.contextPath}/forget" id="forget" class="btn link">お忘れの場合</a>
    <div>${error}</div>
  </div>

</div>

</body>
</html>