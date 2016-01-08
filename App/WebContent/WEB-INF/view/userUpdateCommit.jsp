<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/userUpdateCommit.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/panel.css" rel="stylesheet">
<title>OIC基本情報技術者試験　午前対策サイト</title>
</head>
<body class="container">
<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">登録変更受付</h3>
		</div>
		<div class="panel-body">
			<p id=state></p>
		</div>
	
</div>

<a href = "${pageContext.request.contextPath}/welcome" class="btn">戻る</a>
</body>
</html>