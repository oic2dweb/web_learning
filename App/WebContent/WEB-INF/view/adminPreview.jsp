<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>


<title>OIC基本情報技術者試験　午前対策サイト</title>
</head>
<body>
	<span id="pagenumber">${question.no}</span>/80問
	<div id="question">${question.question}</div><br><br>
	<label><input type="radio" name="ans" value="ア">ア：<span id="ans1">${question.ans1}</span></label><br>
	<label><input type="radio" name="ans" value="イ">イ：<span id="ans2">${question.ans2}</span></label><br>
	<label><input type="radio" name="ans" value="ウ">ウ：<span id="ans3">${question.ans3}</span></label><br>
	<label><input type="radio" name="ans" value="エ">エ：<span id="ans4">${question.ans4}</span></label><br><br>
	
	<br><br>
	<div id="sei">${question.sei}</div>
	<div id="kaisetu">${question.kaisetu}</div><br><br>
	<input type="button" id="" value="戻る" onclick="window.location='${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/entry'">
</body>
</html>