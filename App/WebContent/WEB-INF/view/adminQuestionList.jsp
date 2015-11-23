<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tbody>
		<c:forEach var="que" items="${qlist}">
			<tr>
				<td><a href="${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/entry?no=${que.no}">${que.no}</a></td><td>${que.question}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<input type="button" id="" value="戻る" onclick="window.location='${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/entry'">
</body>
</html>