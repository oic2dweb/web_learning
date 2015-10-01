<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>新規登録</title>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${requestScope.contextPath}css/registerForm.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="${requestScope.contextPath}js/config.js"></script>
<script src="${requestScope.contextPath}js/registerForm.js"></script>

</head>
<body>

<c:if test="${messagesKey != null}">
<div id="messageBox" class="alert alert-warning">
</div>
<script>	
	$(document).ready(function(){
		$('#messageBox').html('<strong>' + messages['${messagesKey}'] + '</strong>');
	});	
</script>
</c:if>

<div>
<form action="${requestScope.contextPath}register" method="POST">
<table>

<tr>
<td>お名前</td>
<td>
<input type="text" name="name" id="name" class="form-control" maxlength="20">
<input type="hidden" value="0" class="submitCount">
</td>
<td class="error"></td>
</tr>

<tr>
<td>お名前（ひらがな）</td>
<td>
<input type="text" name="kana" id="kana" class="form-control" maxlength="20">
<input type="hidden" value="0" class="submitCount">
</td>
<td class="error"></td>
</tr>

<tr>
<td>ユーザーID</td>
<td>
<input type="text" name="username" id="username" class="form-control" maxlength="50">
<input type="hidden" value="0" class="submitCount">
</td>
<td class="error"></td>
</tr>

<tr>
<td>パスワード</td>
<td>
<input type="password" name="password" id="password" class="form-control" maxlength="8">
<input type="hidden" value="0" class="submitCount">
</td>
<td class="error"></td>
</tr>

<tr>
<td>メール</td>
<td>
<input type="text" name="email" id="email" class="form-control" maxlength="36">
<input type="hidden" value="0" class="submitCount">
</td>
<td class="error"></td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="送信" class="btn btn-primary">
<input type="reset" value="リセット" class="btn btn-warning">
</td>
<td></td>
</tr>
</table>

</form>
</div>

</body>
</html>