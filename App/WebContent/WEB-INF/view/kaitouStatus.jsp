<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/kaitoustatus.js"></script>
<title>OIC基本情報技術者試験　午前対策サイト</title>
</head>
<body>
<h1>回答状況</h1>
<table id="kaitoustatus"></table>

<input type="button" name="mback" value="戻る" onclick="window.location='${pageContext.request.contextPath}/login/mondai'">
</body>
</html>