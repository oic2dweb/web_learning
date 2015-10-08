<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${requestScope.contextPath}js/bootstrap.min.js"></script>

<link href="${requestScope.contextPath}css/bootstrap.min.css" rel="stylesheet">
<link href="${requestScope.contextPath}css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="${requestScope.contextPath}css/title.css" rel="stylesheet">
<link href="${requestScope.contextPath}css/loginForm.css" rel="stylesheet">

<title>OIC基本情報技術者試験　午前対策サイト</title>
</head>
<body>

<div id="main">

  <h1 id="maintitle">
  OIC　基本情報技術者試験　午前対策サイト
  </h1>

  <div class="loginform">
    <form class="form-vertical">
    <p>ログイン</p>
      <div class="control-group">
        <label class="control-label" for="email">Emailアドレス</label>
        <div class="controls">
          <input type="email" name="email" id="email" class="form-control">
        </div>
      </div>
      <div class="control-group">
        <label class="control-label" for="password">パスワード</label>
        <div class="controls">
          <input type="password" name="password" id="password" class="form-control">
        </div>
      </div>
      <div class="controls">
        <button type="submit" class="login">ログイン</button>
      </div>
    </form>
    <a href="${requestScope.contextPath}register" id="register">新規登録</a>
    <a href="#">お忘れの場合</a>
  </div>

</div>

</body>
</html>