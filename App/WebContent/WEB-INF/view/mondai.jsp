<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/mondai.js"></script>

<title>OIC基本情報技術者試験　午前対策サイト</title>
</head>
<body>
	<span id="pagenumber"></span>/${fn:length(question)}問
	<input type="hidden" id="allque" value="${fn:length(question)}">
	<div id="question"></div><br><br>
	<label><input type="radio" name="ans" value="ア">ア：<span id="ans1"></span></label><br>
	<label><input type="radio" name="ans" value="イ">イ：<span id="ans2"></span></label><br>
	<label><input type="radio" name="ans" value="ウ">ウ：<span id="ans3"></span></label><br>
	<label><input type="radio" name="ans" value="エ">エ：<span id="ans4"></span></label><br><br>
	<input type="button" id="back" value="前の問題へ">
	<input type="button" id="open" value="解説を表示">
	<input type="button" id="next" value="次の問題へ">
	<input type="button" id="status" value="回答状況" onclick="window.location='${pageContext.request.contextPath}/login/kaitoustatus'">
	<input type="button" id="result" value="回答結果へ" onclick="window.location='${pageContext.request.contextPath}/login/kaitouresult'">
	<br><br>
	<div id="sei"></div>
	<div id="kaisetu"></div><br><br>
	<input type="button" id="" value="メインメニューへ" onclick="window.location='${pageContext.request.contextPath}/login/mainmenu'">
</body>
</html>