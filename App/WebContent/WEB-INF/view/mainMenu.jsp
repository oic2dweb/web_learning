<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/mainMenu.js"></script>
<script src="${pageContext.request.contextPath}/js/mogi.js"></script>
<script src="${pageContext.request.contextPath}/js/nendobetu.js"></script>
<script src="${pageContext.request.contextPath}/js/hukusyu.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/title.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/mainMenu.css" rel="stylesheet">

<!-- 学習履歴/アカウント情報のスクリプトCSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/c3.css" />
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
<script src="https://code.angularjs.org/1.4.2/angular-route.min.js"></script>
<script src="${pageContext.request.contextPath}/js/d3.js"></script>
<script src="${pageContext.request.contextPath}/js/c3.js"></script>
<script src="${pageContext.request.contextPath}/js/angular-chart.js"></script>
<script src="${pageContext.request.contextPath}/js/mypage.js"></script>

<title>OIC基本情報技術者試験　午前対策サイト</title>

</head>
<body class="container">
	<div class="jumbotron" id="meinmenu">
		<h2>OIC基本情報技術者試験　午前対策サイト</h2>
	</div>

<div  class="col-xs-3">
	<div class="panel panel-info">
	<ul class="nav nav-pills nav-stacked list-group">
		<li><h3 class="panel-title list-group-item list-group-item-success">   メニュー</h3></li>

		<li><a href="#meinmenu" onclick="SelectLink('#bunya')" class="list-group-item">分野別モード</a></li>
		<li><a href="#meinmenu" onclick="SelectLink('#nendo')" class="list-group-item" id="nendobetu">年度別モード</a></li>
		<li><a href="#meinmenu" onclick="SelectLink('#mogi')" class="list-group-item">模擬試験モード</a></li>
		<li><a href="#hukusyu" onclick="SelectLink('#hukusyu')" class="list-group-item">復習モード</a></li>
		<li><a href="#mypage" onclick="SelectLink('#mypage')" class="list-group-item">学習履歴/アカウント情報</a></li>

	</ul>
	</div>
</div>
<div class="col-xs-9">
<div id="bunya">
<div id="message"></div>

<form method="post" action="${pageContext.request.contextPath}/login/mainmenu" id="select_class">
<table class="table table-striped table-hover table-bordered">
	<tbody>
		<tr class="info">
			<th colspan="3" class="thcenter">テクノロジ系<input type="button" value="選択" name="tecno" class="btn btn-success btn-sm"><input type="button" value="解除" name="tecno" class="tecno btn btn-success btn-sm"></th>
		</tr>
		<tr class="bunyatr">
			<th>・基礎理論</th>
			<th>・コンピュータシステム</th>
			<th>・技術要素</th>
		</tr>
		<tr>
			<td><label><input type="checkbox" name="subid" value="1" class="tecno ">基礎理論(${count[0]})</label></td>
			<td><label><input type="checkbox" name="subid" value="3" class="tecno">コンピュータ構成要素(${count[2]})</label></td>
			<td><label><input type="checkbox" name="subid" value="7" class="tecno">ヒューマンインターフェース(${count[6]})</label></td>
		</tr>
		<tr>
			<td><label><input type="checkbox" name="subid" value="2" class="tecno">アルゴリズムとプログラミング(${count[1]})</label></td>
			<td><label><input type="checkbox" name="subid" value="4" class="tecno">システム構成要素(${count[3]})</label></td>
			<td><label><input type="checkbox" name="subid" value="8" class="tecno">マルチメディア(${count[7]})</label></td>
		</tr>
		<tr>
			<td></td>
			<td><label><input type="checkbox" name="subid" value="5" class="tecno">ソフトウェア(${count[4]})</label></td>
			<td><label><input type="checkbox" name="subid" value="9" class="tecno">データベース(${count[8]})</label></td>
		</tr>
		<tr>
			<td></td>
			<td><label><input type="checkbox" name="subid" value="6" class="tecno">ハードウェア(${count[5]})</label></td>
			<td><label><input type="checkbox" name="subid" value="10" class="tecno">ネットワーク(${count[9]})</label></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td><label><input type="checkbox" name="subid" value="11" class="tecno">セキュリティ(${count[10]})</label></td>
		</tr>


		<tr class="info">
			<th colspan="3" class="thcenter">マネジメント系<input type="button" value="選択" name="manege" class="btn btn-success btn-sm"><input type="button" value="解除" name="manege" class="btn btn-success btn-sm"></th>
		</tr>
		<tr class="bunyatr">
			<th>・開発技術</th>
			<th>・プロジェクトマネジメント</th>
			<th>・サービスマネジメント</th>
		</tr>
		<tr>
			<td><label><input type="checkbox" name="subid" value="12" class="manege">システム開発技術(${count[11]})</label></td>
			<td><label><input type="checkbox" name="subid" value="14" class="manege">プロジェクトマネジメント(${count[13]})</label></td>
			<td><label><input type="checkbox" name="subid" value="15" class="manege">サービスマネジメント(${count[14]})</label></td>
		</tr>
		<tr>
			<td><label><input type="checkbox" name="subid" value="13" class="manege">ソフトウェア開発管理技術(${count[12]})</label></td>
			<td></td>
			<td><label><input type="checkbox" name="subid" value="16" class="manege">システム監査(${count[15]})</label></td>
		</tr>


		<tr class="info">
			<th colspan="3" class="thcenter">ストラテジ系<input type="button" value="選択" name="stora" class="btn btn-success btn-sm"><input type="button" value="解除" name="stora" class="btn btn-success btn-sm"></th>
		</tr>
		<tr class="bunyatr">
			<th>・企業と法務</th>
			<th>・経営戦略</th>
			<th>・システム戦略</th>
		</tr>
		<tr>
			<td><label><input type="checkbox" name="subid" value="22" class="stora">企業活動(${count[21]})</label></td>
			<td><label><input type="checkbox" name="subid" value="19" class="stora">経営戦略マネジメント(${count[18]})</label></td>
			<td><label><input type="checkbox" name="subid" value="17" class="stora">システム戦略(${count[16]})</label></td>
		</tr>
		<tr>
			<td><label><input type="checkbox" name="subid" value="23" class="stora">法務(${count[22]})</label></td>
			<td><label><input type="checkbox" name="subid" value="20" class="stora">技術戦略マネジメント(${count[19]})</label></td>
			<td><label><input type="checkbox" name="subid" value="18" class="stora">システム企画(${count[17]})</label></td>
		</tr>
	</tbody>
</table>
<input type="submit" value="出題開始" class="btn btn-primary btn-lg">
</form>
</div>

<div id="mogi">
出題年度
<form id = "kaishi" method = "post" action="${pageContext.request.contextPath}/login/mogi">
<select name="years" class="from-control">
<c:forEach var="years" items="${year}"><option value="${years.key}">${years.value}</option></c:forEach>
</select>
<input type="submit" value="出題開始" class="btn btn-primary btn-lg">
</form>
</div>

<div id="nendo">
	テスト
	出題年度
	<form id="seyear" method="get" action="${pageContext.request.contextPath}/login/mainmenu">
		<select id="yeardata" name="year" class="from-control">
			<option value="">年度をお選びください。</option><c:forEach var="years" items="${year}"><option value="${years.key}" <c:if test="${years.key==nowyear}">selected</c:if>>${years.value}</option></c:forEach>
		</select>
	</form>

	<table class="queall table table-striped table-hover table-bordered" >
		<thead>	
			<tr class="info">
				<th>NO</th><th>論点</th><th>分類</th>
			</tr>
		</thead>
		<tbody id="nendoquestion">
			<c:forEach var="qes" items="${question}" varStatus="status">
				<tr>
					<td>
						<a href="${pageContext.request.contextPath}/login/nenmondai?pagenumber=${status.count-1}"><c:out value="${status.count}"></c:out></a>
					</td>
					<td><c:out value="${qes.ronten}"></c:out></td>
					<td><c:out value="${qes.subclass}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<div>
	<div ng-app="app" ng-view></div>
</div>

<div id="hukusyu" class="queall">
	<table id="hukuall" class="table table-striped table-hover table-bordered"></table>

</div>
</div>
</body>
</html>