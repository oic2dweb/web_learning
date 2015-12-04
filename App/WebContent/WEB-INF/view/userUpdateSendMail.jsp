<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<title>OIC基本情報技術者試験　午前対策サイト</title>
</head>
<body class="container">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">登録変更受付完了</h3>
		</div>
		<div class="panel-body">
			登録されているメールアドレス宛にメールが送信されました<br>
			記載されているURLにアクセスして頂くことで変更が完了されます<br>
		</div>
	</div>
	
	<a href="${pageContext.request.contextPath}/login/mainmenu#/testRecords">戻る</a>

</body>
</html>