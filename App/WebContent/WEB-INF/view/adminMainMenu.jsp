<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/adminMainMenu.js"></script>
<script src="${pageContext.request.contextPath}/js/form.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/title.css" rel="stylesheet">


<title>OIC基本情報技術者試験　午前対策サイト</title>
</head>
<body class="container">
	<div class="row">
		<span class="pull-right"><button class="btn" onclick="location.href='${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/admin'">ログアウト</button></span>
	</div>
	<div class="row">
		<div class="jumbotron" id="meinmenu">
			<h2 class="text-center">OIC　${type_name }　午前対策サイト</h2>
			<h3 class="text-center">管理者メニュー</h3>
		</div>
	</div>
<div class="row">
	<div  class="col-xs-3">
		<div class="panel panel-info">
		<ul class="nav nav-pills nav-stacked list-group">
			<li><a href="#main" onclick="SelectLink('#main')" class="list-group-item">メインメニュー</a></li>
			<li><a href="#touroku" onclick="SelectLink('#touroku')" class="list-group-item">問題登録</a></li>
			<li><a href="#henkou" onclick="SelectLink('#henkou')" class="list-group-item">問題変更</a></li>
			<li><a href="#hozonchu" onclick="SelectLink('#hozonchu')" class="list-group-item">保存中作成物</a></li>
		</ul>
		</div>
	</div>
	<div class="col-xs-9">
		<div id="main">
		</div>
		<div id ="touroku">
			<h2>問題登録</h2>
			<p>出題年度</p>
			<form method="post" class="form-inline" role="form" action="${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/mainmenu">

				<div class="form-group">
					<label for="gengo">元号</label>
					<input type="text" name="gengo" id="gengo" value="平成" class="form-control" style="width:80px;">
				</div>
				<div class="form-group">
					<label for="nensu">年数</label>
					<input type="text" name="nensu" id="nensu" class="fm form-control" style="width:80px;">年
				</div>
				<div class="form-group">
					<label for="jiki">時期</label>
					<select name="jiki" id="jiki" size="1" class="form-control" style="width:80px;">
						<option value="春">春</option>
						<option value="秋">秋</option>
						<option value="その他">その他</option>
					</select>
				</div>
				<div class="form-group" id="jikinuryoku">
					<label for="sonotajiki">時期を入力</label>
					<input type="text" name="sonotajiki" id="sonotajiki" class="form-control">
				</div>

				<div class="form-group">
					<input type="submit" class="btn btn-primary form-control" value="登録開始">
				</div>

			</form>
			<div>${error}</div>
		</div>

		<div id="henkou">
		<h2>問題変更</h2>
		<form id="seyear" method="get" action="${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/mainmenu">
			<div class="form-group">
				<select id="yeardata" name="year">
					<option value="">年度をお選びください。</option><c:forEach var="years" items="${year}"><option value="${years.key}" <c:if test="${years.key==nowyear}">selected</c:if>>${years.value}</option></c:forEach>
				</select>
			</div>
			<div id="seyearbutton" class="form-group">
			</div>
		</form>
		</div>
		<div id="hozonchu">
			<h2>保存中作成物</h2>
			<table id="hozontable" class="table table-striped table-hover table-bordered">
				<thead>
					<tr class="info">
						<th>年度</th><th>問題数</th><th>問題登録の再開</th><th>一時中断の削除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="years" items="${noflgyear}">
						<tr>
							<td>${years.value}</td>
							<td>${quantity[years.key]}/80</td>
							<td><a href="${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/save?year_id=${years.key}">再開</a></td>
							<td><a href="${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/delete?year_id=${years.key}" id="check">削除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>