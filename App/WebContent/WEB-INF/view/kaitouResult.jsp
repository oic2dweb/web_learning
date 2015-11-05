<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/kaitouresult.js"></script>
<title>OIC基本情報技術者試験　午前対策サイト</title>
</head>
<body>
<h1>回答結果</h1>
<form id="ansrsend" method="post" action="${pageContext.request.contextPath}/login/kaitouresult">
<table id="kaitouresult"></table>
	<input type="submit" class="strgclr" value="結果を保存">
</form>
</body>
</html>