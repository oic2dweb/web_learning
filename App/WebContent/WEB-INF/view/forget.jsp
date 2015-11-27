<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/forget.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<title>OIC基本情報技術者試験　午前対策サイト</title>
</head>
<body>
	<h1>お忘れの場合</h1>

	<div id="message">

		登録された連絡用メールアドレス(半角英数字)<br>
		<form action="#" method="post">
 			<input type="email" name="email" id="email"><br>
 			メールにてお知らせします<br>
 			<button id="submit">送信</button>
		</form>
	</div>
	<a href="${pageContext.request.contextPath}/welcome">戻る</a>

</body>
</html>