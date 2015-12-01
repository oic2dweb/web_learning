<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div ng-controller="MyPageController as mypage" >
	<div class="container">
	<div class="row" style="position:relative">
	<div style="width: 400px; float:left; margin:10px">
		<angular-chart options="mypage.options" class="chart"></angular-chart>
	</div>
	<div style="width: 250px; float:left; margin:10px">
		<table class="table table-hover">
			<tr>
			<th class="">お名前</th>
			<td class="">{{mypage.user.name}}</td>
			</tr>
			<tr>
			<th>お名前かな</th>
			<td>{{mypage.user.kana}}</td>
			</tr>
			<tr>
			<th>ユーザーID</th>
			<td>{{mypage.user.studentId}}</td>
			</tr>
			<tr>
			<th>連絡用メールアドレス</th>
			<td>{{mypage.user.email}}</td>
			</tr>
		</table>
		<a href="#/userUpdate">アカウント情報の変更</a>
	</div>
	</div>
	</div>
</div>

