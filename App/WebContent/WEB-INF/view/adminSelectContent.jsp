<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/adminSelectContent.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/selectContent.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="container">
		<div class="box1 btn-info well well-lg"><h1>ITパスポート</h1></div>
	
	
		<div class="box2 btn-info well well-lg"><h1>基本情報技術者</h1></div>
	

		<div class="box3 btn-info well well-lg"><h1>応用情報技術</h1></div>
	
	
	<p><a href="${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/mainmenu?type=1">ITパスポート</a></p>
	<p><a href="${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/mainmenu?type=2">基本情報技術者</a></p>
	<p><a href="${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/mainmenu?type=3">応用情報技術者</a></p>
</body>
</html>