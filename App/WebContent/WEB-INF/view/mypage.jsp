<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/c3.css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
<script src="https://code.angularjs.org/1.4.2/angular-route.min.js"></script>
<script src="${pageContext.request.contextPath}/js/d3.js"></script>
<script src="${pageContext.request.contextPath}/js/c3.js"></script>
<script src="${pageContext.request.contextPath}/js/angular-chart.js"></script>

<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/mypage.js"></script>
<title>OIC基本情報技術者試験　午前対策サイト</title>
</head>
<body>

<div ng-app="app" ng-view></div>
</body>
</html>