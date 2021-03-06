<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/mondai.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/panel.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.simple.timer.js"></script>
<script src="${pageContext.request.contextPath}/js/mondai.js"></script>




<title>OIC情報処理技術者試験　午前対策サイト</title>
</head>
<body class="container">
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">
				<span id="pagenumber"></span>/${fn:length(question)}問
				<input type="hidden" id="allque" value="${fn:length(question)}">
				<input type="checkbox" id="hukusyu"/><label>復習</label>
				<span class='timer pull-right' data-seconds-left="0"></span>
				<span class='endtimer pull-right'></span>

			</h3>
		</div>

		<div class="panel-body">
			<div id="question"></div>
		</div>
	</div>

	<label class="ans"><input type="radio" name="ans" value="ア">ア：<span id="ans1"></span></label><br>
	<label class="ans"><input type="radio" name="ans" value="イ">イ：<span id="ans2"></span></label><br>
	<label class="ans"><input type="radio" name="ans" value="ウ">ウ：<span id="ans3"></span></label><br>
	<label class="ans"><input type="radio" name="ans" value="エ">エ：<span id="ans4"></span></label><br><br>

	<input type="button" id="back" value="前の問題へ" class="btn btn-info">
	<input type="button" id="next" value="次の問題へ" class="btn btn-info">


	<input type="button" id="status" value="解答状況" onclick="window.location='${pageContext.request.contextPath}/login/kaitoustatus'" class="btn btn-success">
	<input type="button" id="result" value="解答結果へ" onclick="window.location='${pageContext.request.contextPath}/login/kaitouresult'" class="btn btn-primary">
	<br><br>
	<div class="well kaisetu">
		<h4 id="sei"></h4>
		<div id="kaisetu"></div>
	</div>
	<a href="${pageContext.request.contextPath}/login/mainmenu" class="btn btn-link">メインメニューへ</a>

</body>
</html>