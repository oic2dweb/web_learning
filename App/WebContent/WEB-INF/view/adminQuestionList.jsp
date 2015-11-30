<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="container">
	<h3>問題一覧</h3>
	<table class="table table-striped table-hover table-bordered">
		<thead>
			<tr class="info">
				<th>問題番号</th><th>問題文</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="que" items="${qlist}">
			<tr>
				<td><a href="${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/entry?no=${que.no}">${que.no}</a></td><td>${que.question}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<input type="button" class="btn btn-info" id="" value="戻る" onclick="window.location='${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/entry'">
</body>
</html>