<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/mogi.js"></script>
<title>OIC基本情報技術者試験　午前対策サイト</title>
</head>
<body>
出題年度
<form id = "kaishi" method = "post" action="${pageContext.request.contextPath}/login/mogi">
<select name="yeardata">
<c:forEach var="years" items="${year}"><option value="${years.key}">${years.value}</option></c:forEach>
</select>
<input type="submit" value="出題開始">

</form>
</body>
</html>