<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/meinMenu.js"></script>


<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/title.css" rel="stylesheet">

<title>OIC基本情報技術者試験　午前対策サイト</title>

</head>
<body>

<div id="main">

  <h1 id="subtitle">
  メインメニュー
  </h1>

  <ul class="breadrumb">
    <li><a href="${pageContext.request.contextPath}/welcome">ログインメニュー</a><span class="divider"> > </span></li>
    <li class="active"><a href="#">メインメニュー</a></li>
  </ul>

</div>
<a href="${pageContext.request.contextPath}/login/nendobetu">年度別モード</a><br>
<a href="${pageContext.request.contextPath}/login/mogi">模擬試験モード</a>
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
			<td><input type="checkbox" name="subid" value="1" class="tecno">基礎理論(${count[0]})</td>
			<td><input type="checkbox" name="subid" value="3" class="tecno">コンピュータ構成要素(${count[2]})</td>
		<td><input type="checkbox" name="subid" value="7" class="tecno">ヒューマンインターフェース基礎理論(${count[6]})</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="subid" value="2" class="tecno">アルゴリズムとプログラミング(${count[1]})</td>
			<td><input type="checkbox" name="subid" value="4" class="tecno">システム構成要素(${count[3]})</td>
			<td><input type="checkbox" name="subid" value="8" class="tecno">マルチメディア(${count[7]})</td>
		</tr>
		<tr>
			<td></td>
			<td><input type="checkbox" name="subid" value="5" class="tecno">ソフトウェア(${count[4]})</td>
			<td><input type="checkbox" name="subid" value="9" class="tecno">データベース(${count[8]})</td>
		</tr>
		<tr>
			<td></td>
			<td><input type="checkbox" name="subid" value="6" class="tecno">ハードウェア(${count[5]})</td>
			<td><input type="checkbox" name="subid" value="10" class="tecno">ネットワーク(${count[9]})</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td><input type="checkbox" name="subid" value="11" class="tecno">セキュリティ(${count[10]})</td>
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
			<td><input type="checkbox" name="subid" value="12" class="manege">システム開発技術(${count[11]})</td>
			<td><input type="checkbox" name="subid" value="14" class="manege">プロジェクトマネジメント(${count[13]})</td>
			<td><input type="checkbox" name="subid" value="15" class="manege">サービスマネジメント(${count[14]})</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="subid" value="13" class="manege">ソフトウェア開発管理技術(${count[12]})</td>
			<td></td>
			<td><input type="checkbox" name="subid" value="16" class="manege">システム監査(${count[15]})</td>
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
			<td><input type="checkbox" name="subid" value="22" class="stora">企業活動(${count[21]})</td>
			<td><input type="checkbox" name="subid" value="19" class="stora">経営戦略マネジメント(${count[18]})</td>
			<td><input type="checkbox" name="subid" value="17" class="stora">システム戦略(${count[16]})</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="subid" value="23" class="stora">法務(${count[22]})</td>
			<td><input type="checkbox" name="subid" value="20" class="stora">技術戦略マネジメント(${count[19]})</td>
			<td><input type="checkbox" name="subid" value="18" class="stora">システム企画(${count[17]})</td>
		</tr>
	</tbody>
</table>
<input type="submit" value="出題開始">
</form>

</body>
</html>