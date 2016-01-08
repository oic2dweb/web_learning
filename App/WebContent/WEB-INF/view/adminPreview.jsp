<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/mondai.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/panel.css" rel="stylesheet">


<title>OIC情報処理技術者試験　午前対策サイト</title>
</head>
<body class="container">
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">
				<span id="pagenumber">${question.no}</span>/${typeQuantity}問
			</h3>
		</div>
		<div class="panel-body">
			<div id="question">${question.question}</div>
		</div>
	</div>
	<label class="ans"><input type="radio" name="ans" value="ア">ア：<span id="ans1">${question.ans1}</span></label><br>
	<label class="ans"><input type="radio" name="ans" value="イ">イ：<span id="ans2">${question.ans2}</span></label><br>
	<label class="ans"><input type="radio" name="ans" value="ウ">ウ：<span id="ans3">${question.ans3}</span></label><br>
	<label class="ans"><input type="radio" name="ans" value="エ">エ：<span id="ans4">${question.ans4}</span></label><br><br>

	<div class="well kaisetu">
		<h4 id="sei">${question.sei}</h4>
		<div id="kaisetu">${question.kaisetu}</div>
	</div>
	<input type="button" id="" class="btn btn-info" value="戻る" onclick="window.location='${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/entry'">
</body>
</html>