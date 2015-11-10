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

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/title.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/nendobetu.css" rel="stylesheet">

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
<body>

<div id="main">

  <h1 id="subtitle">
  メインメニュー
  </h1>

</div>
<ul>
	<li><a href="#bunya" onclick="SelectLink('#bunya')">分野別モード</a></li>
	<li><a href="#nendo" onclick="SelectLink('#nendo')">年度別モード</a></li>
	<li><a href="#mogi" onclick="SelectLink('#mogi')">模擬試験モード</a></li>
	<li><a href="#mypage" onclick="SelectLink('#mypage')">学習履歴/アカウント情報</a></li>
</ul>
<div id="bunya">
<div id="message"></div>

<form method="post" action="${pageContext.request.contextPath}/login/mainmenu" id="select_class">
<table>
	<tbody>
		<tr>
			<th colspan="3">テクノロジ系<input type="button" value="選択" id="select1on" class="tecno"><input type="button" value="解除" id="select1off" class="tecno"></th>
		</tr>
		<tr>
			<th>・基礎理論</th>
			<th>・コンピュータシステム</th>
			<th>・技術要素</th>
		</tr>
		<tr>
			<td><label><input type="checkbox" name="subid" value="1" class="tecno">基礎理論(${count[0]})</label></td>
			<td><label><input type="checkbox" name="subid" value="3" class="tecno">コンピュータ構成要素(${count[2]})</label></td>
			<td><label><input type="checkbox" name="subid" value="7" class="tecno">ヒューマンインターフェース基礎理論(${count[6]})</label></td>
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


		<tr>
			<th colspan="3">マネジメント系<input type="button" value="選択" id="select2on" class="manege"><input type="button" value="解除" id="select2off" class="manege"></th>
		</tr>
		<tr>
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


		<tr>
			<th colspan="3">ストラテジ系<input type="button" value="選択" id="select3on" class="stora"><input type="button" value="解除" id="select3off" class="stora"></th>
		</tr>
		<tr>
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
<input type="submit" value="出題開始">
</form>
</div>

<div id="mogi">
出題年度
<form id = "kaishi" method = "post" action="${pageContext.request.contextPath}/login/mogi">
<select name="years">
<c:forEach var="years" items="${year}"><option value="${years.key}">${years.value}</option></c:forEach>
</select>
<input type="submit" value="出題開始">
</form>
</div>

<div id="nendo">
	テスト
	出題年度
	<form id="seyear" method="get" action="${pageContext.request.contextPath}/login/mainmenu">
		<select id="yeardata" name="year">
			<option value="">年度をお選びください。</option><c:forEach var="years" items="${year}"><option value="${years.key}" <c:if test="${years.key==nowyear}">selected</c:if>>${years.value}</option></c:forEach>
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
</div>

<div>
	<div ng-app="app" ng-view></div>
</div>

</body>
</html>