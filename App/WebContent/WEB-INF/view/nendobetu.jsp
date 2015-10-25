<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/nendobetu.js"></script>
<link href="${pageContext.request.contextPath}/css/nendobetu.css" rel="stylesheet">
<title>OIC基本情報技術者試験　午前対策サイト</title>
</head>
<body>
テスト
出題年度
<form id="seyear" method="post" action="${pageContext.request.contextPath}/login/nendobetu">
<select id="yeardata" name="year">
<c:forEach var="years" items="${year}"><option value="${years.key}" <c:if test="${years.key==nowyear}">selected</c:if>>${years.value}</option></c:forEach>
</select>
</form>

<table class="queall" >
<tr>
<th>NO</th><th>論点</th><th>分類</th>
</tr>

<c:forEach var="qes" items="${question}" varStatus="status">
<tr>
<td>
<a href="${pageContext.request.contextPath}/login/nenmondai?pagenumber=${status.count-1}"><c:out value="${status.count}"></c:out></a>
</td>
<td><c:out value="${qes.ronten}"></c:out></td>
<td><c:out value="${qes.subclass}"></c:out></td>
</tr>
</c:forEach>
</table>


</body>
</html>