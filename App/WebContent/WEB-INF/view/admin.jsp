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
<script src="${pageContext.request.contextPath}/js/welcome.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/title.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/loginForm.css" rel="stylesheet">

<title>OIC情報処理技術者試験　午前対策サイト</title>
</head>
<body>

<div id="main">

  <h3 id="maintitle">
  OIC　情報処理技術者試験<br>午前対策サイト
  </h3>

  <div class="loginformwrap">
    <form id="loginform" class="form-vertical" method="post" action="${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/admin">
    <p>ログイン</p>
      <div class="control-group">
        <label class="control-label" for="adminid">管理者ID</label>
        <div class="controls">
          <input type="text" name="adminid" id="adminid" class="form-control">
        </div>
      </div>
      <div class="control-group">
        <label class="control-label" for="password">パスワード</label>
        <div class="controls">
          <input type="password" name="password" id="password" class="form-control">
        </div>
      </div>
      <div class="controls">
        <button type="submit" class="login btn btn-primary">ログイン</button>
      </div>
    </form>
    <div>${error}</div>
  </div>

</div>

</body>
</html>