<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/adminMainMenu.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/title.css" rel="stylesheet">

<title>OIC基本情報技術者試験　午前対策サイト</title>
</head>
<body>
<div id="sidemenu">
<ul>
	<li><a href="#main" onclick="SelectLink('#main')">メインメニュー</a></li>
	<li><a href="#touroku" onclick="SelectLink('#touroku')">問題登録</a></li>
	<li><a href="#henkou" onclick="SelectLink('#henkou')">問題変更</a></li>
	<li><a href="#hozonchu" onclick="SelectLink('#hozonchu')">保存中作成物</a></li>
</ul>
</div>
<div id="logoutmenu">
ログイン<br>管理者モード
<button onclick="location.href='${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/admin'">ログアウト</button>
</div>
<div id="main">
</div>
<div id ="touroku">
<h2>問題登録</h2>
<form method="post" action="${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/mainmenu">
出題年度
<div class="form-group inline">
	<label>元号</label>
	<input type="text" name="gengo" id="gengo" value="平成">
</div>
<div class="form-group inline">
	<label>年数</label>
<input type="text" name="nensu" id="nensu" class="fm">年
</div>
<div class="form-group inline">
	<label>時期</label>
	<select name="jiki" id="jiki" size="1">
		<option value="春">春</option>
		<option value="秋">秋</option>
		<option value="その他">その他</option>
	</select>
</div>
<div class="form-group inline" id="jikinuryoku">
	<label>時期を入力</label>
	<input type="text" name="sonotajiki" id="sonotajiki">
</div>
<div class="form-group">
	<button type="submit">登録開始</button>
</div>
</form>
<div>${error}</div>
</div>

<div id="henkou">
<h2>問題変更</h2>
<form id="seyear" method="get" action="${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/mainmenu">
	<div class="form-group">
	<select id="yeardata" name="year">
		<option value="">年度をお選びください。</option><c:forEach var="years" items="${year}"><option value="${years.value}" <c:if test="${years.key==nowyear}">selected</c:if>>${years.value}</option></c:forEach>
	</select>
	</div>
	<div id="seyearbutton" class="form-group">

	</div>
</form>
</div>

<div id="hozonchu">
<h2>保存中作成物</h2>
	<table id="hozontable">
		<c:forEach var="years" items="${noflgyear}">
			<tr>
				<td>${years.value}</td>
				<td>${quantity[years.key]}/80</td>
				<td><a href="${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/save?year_id=${years.key}">再開</a></td>
				<td><a href="${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/delete?year_id=${years.key}">削除</a></td>
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>