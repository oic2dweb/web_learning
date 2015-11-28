<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/kaitouresult.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<title>OIC基本情報技術者試験　午前対策サイト</title>
</head>
<body class="container">
<h1>回答結果</h1>
<p>問題番号をクリックで解説を表示します</p>
<form id="ansrsend" method="post" action="${pageContext.request.contextPath}/login/kaitouresult">
	<table id="kaitouresult" class="table table-striped table-hover table-bordered"></table>
	<span id="score"></span><br>
	<input type="submit" class="strgclr btn btn-primary btn-lg" value="結果を保存">
</form>
</body>
</html>