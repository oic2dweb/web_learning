<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/title.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/mainMenu.css" rel="stylesheet">

<title>OIC基本情報技術者試験　午前対策サイト</title>

</head>
<body>

<script>

</script>

<div id="main">
  <div id="login">
  	<p>ログイン</p>
  	<p>ゲスト　さん <input type="submit" value="ログアウト" /></p>	
  </div>
  <h1 id="maintitle">
  OIC　基本情報技術者試験　午前対策サイト
  </h1><br><br>
  
  <ul class="breadcrumb">
    <li><a href="${pageContext.request.contextPath}/welcome">ログインメニュー</a><span class="divider"> > </span></li>
    <li class="active"><a href="#">メインメニュー</a></li>
  </ul>
  <div id="sidebar">
  <ul>
   <li><a href="#">・分野別モード</a><br></li>
   <li><a href="#">・模擬試験モード</a><br></li>
   <li><a href="#">・年度別モード</a><br></li>
   <li><a href="#">・学習履歴ステータス</a><br></li>
   <li><a href="#">・質問掲示板</a><br></li>
   </ul>
   </div>
  
  
</div>


</body>
</html>