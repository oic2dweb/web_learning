<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${requestScope.getContextPath }js/forget.js"></script>
<script src="${requestScope.getContextPath }js/config.js"></script>
<title>Webラーニングシステム</title>
</head>
<body>
	<h1>お忘れの場合</h1>
	<!-- 送信前及び送信失敗時にはこちらを表示 -->
	<div id="false" style="display:block;">
	
		<!-- エラーメッセージ表示エリア -->
		<div id="message" ></div>
		
		登録された連絡用メールアドレス(半角英数字)<br>
		<form action="${requestScope.contextPath }forget" method="post">
 			<input type="email" name="email" id="email"><br>
 			メールにてお知らせします<br>
 			<input type="button" value="送信" id="submit">
 			<input type="button" onclick="window.location='${request.getContext}welcome'" value="キャンセル">
		</form>
	</div>
	
	
	<!--送信成功時にはこちらを表示 -->
	<div id="true" style="display:none;">
		<p>メールが送信されました。ご確認ください。</p>
		<a href="${request.getContext}welcome">メインメニューへ</a>
	</div>
	
</body>
</html>