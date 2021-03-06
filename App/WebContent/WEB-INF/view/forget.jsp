<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/forget.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validationEngine.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validationEngine-ja.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/panel.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/validationEngine.jquery.css" rel="stylesheet">
<title>OIC情報処理技術者試験　午前対策サイト</title>
</head>
<body class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h1 class="panel-title">お忘れの場合</h1>
		</div>
		<div class="panel-body">
			<div id="message">
				<div class="form-group">

						<label class="control-label">登録された連絡用メールアドレス(半角英数字)</label>
						<div class="row">
							<div class="col-xs-6">
								<input type="email" name="email" id="email" class="form-control">
							</div>
						</div>
						
						<label class="control-label" for="question">秘密の質問</label>
						<div class="row">
							<div class="controls col-xs-6">
								<select id="secret_id" name="secret_id" class="form-control">
									<option value="">秘密の質問を選択</option><c:forEach var="question" items="${secret}"><option value="${question.key}">${question.value}</option></c:forEach>
								</select>
							</div>
						</div>
						
						<label class="control-label">秘密の質問の答え</label>
						<div class="row">
							<div class="col-xs-6">
								<input type="text" name="secret_text" id="secret_text" class="form-control">
							</div>
						</div>
 						メールにてお知らせします<br>
 						<div style="color:red" id="message2"></div>
 						<button id="submit" class="btn btn-primary">送信</button>

				</div>
			</div>
		</div>
	</div>
	<a href="${pageContext.request.contextPath}/welcome" class="btn link">戻る</a>

</body>
</html>