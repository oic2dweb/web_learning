<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/adminQuestionEntry.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/entry" method="post" name="entry" enctype="multipart/form-data">
		${year_name}
		<p>分野</p>

		<p>
			<select name="catname">
				<c:forEach items="${catNames}" var="catName">
					<option value="${catName.key}" <c:if test="${adminQuestion.catid == catName.key}">selected</c:if>>${catName.value}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<select name="mainname"></select><input type="hidden" value="${adminQuestion.mainid}" name="hmainname">
		</p>
		<p>
			<select name="subname"></select><input type="hidden" value="${adminQuestion.subid}" name="hsubname">
		</p>
		<p>論点</p>
		<p><input type="text" name="ronten" value="${adminQuestion.ronten}"></p>
		<p>問題番号</p>
		<p><input type="text" name="qnumber" value="${qnumber}" size="1" readonly>/<input type="text" value="80" name="maxnumber" size="1" readonly></p>
		<p>問題文章</p>
		<textarea rows="10" cols="75" name="question" maxlength="1024">${adminQuestion.question}</textarea>
		<p>問題画像1</p>
		<input type="file" name="qimg1" class="qimg" accept="image/gif,image/jpeg,image/png">
		<p>問題画像2</p>
		<input type="file" name="qimg2" class="qimg" accept="image/gif,image/jpeg,image/png">
		<p>問題画像3</p>
		<input type="file" name="qimg3" class="qimg" accept="image/gif,image/jpeg,image/png">
		<p>問題画像4</p>
		<input type="file" name="qimg4" class="qimg" accept="image/gif,image/jpeg,image/png">
		<input type="hidden" name="qimgcnt" value="0">
		<p>回答</p>
		<p>ア<textarea rows="1" cols="75" name="ans1" maxlength="256">${adminQuestion.ans1}</textarea></p>
		<p><input type="file" name="aimg1" class="aimg" accept="image/gif,image/jpeg,image/png"><input type="hidden" name="haimg1" value="0"></p>
		<p>イ<textarea rows="1" cols="75" name="ans2" maxlength="256">${adminQuestion.ans2}</textarea></p>
		<p><input type="file" name="aimg2" class="aimg" accept="image/gif,image/jpeg,image/png"><input type="hidden" name="haimg2" value="0"></p>
		<p>ウ<textarea rows="1" cols="75" name="ans3" maxlength="256">${adminQuestion.ans3}</textarea></p>
		<p><input type="file" name="aimg3" class="aimg" accept="image/gif,image/jpeg,image/png"><input type="hidden" name="haimg3" value="0"></p>
		<p>エ<textarea rows="1" cols="75" name="ans4" maxlength="256">${adminQuestion.ans4}</textarea></p>
		<p><input type="file" name="aimg4" class="aimg" accept="image/gif,image/jpeg,image/png"><input type="hidden" name="haimg4" value="0"></p>

		<p>正答</p>
		<select name="sei">
			<option></option>
			<option value="ア" <c:if test="${adminQuestion.sei=='ア'}">selected</c:if>>ア</option>
			<option value="イ" <c:if test="${adminQuestion.sei=='イ'}">selected</c:if>>イ</option>
			<option value="ウ" <c:if test="${adminQuestion.sei=='ウ'}">selected</c:if>>ウ</option>
			<option value="エ" <c:if test="${adminQuestion.sei=='エ'}">selected</c:if>>エ</option>
		</select>
		<p>解説</p>
		<textarea rows="10" cols="75" name="kaisetu" maxlength="1024">${adminQuestion.kaisetu}</textarea>
		<p>解説画像</p>
		<input type="file" name="kimg" accept="image/gif,image/jpeg,image/png"><input type="hidden" name="hkimg" value="0">
		<input type="button" value="前問へ" name="back" class="submitbt"><input type="button" value="次問へ" name="next" class="submitbt"><input type="button" value="プレビュー" name="preview" class="submitbt">
		<input type="button" value="一覧" name="list" class="submitbt"><input type="button" value="中断保存" name="onetimesave" class="submitbt"><input type="button" value="投稿" name="posting" class="submitbt">
		<input type="checkbox" value="" name="check">チェックを入れてから投稿ボタンを押下してください。
		<input type="hidden" name="submitname">

	</form>
</body>
</html>