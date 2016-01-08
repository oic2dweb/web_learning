<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/config.js"></script>
<script src="${pageContext.request.contextPath}/js/adminQuestionEntry.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/panel.css" rel="stylesheet">
<meta charset="UTF-8">
<title>OIC情報処理技術者試験　午前対策サイト</title>
</head>
<body class="container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">${type_name}　${year_name}</h3>
		</div>
		<div class="panel-body">


			<form action="${pageContext.request.contextPath}/eb430180f1006fb41dd1e4eb4cdb508d/login/entry" method="post" name="entry" enctype="multipart/form-data">
				<div class="well">
				<div class="form-inline">
					<div class="form-group">
						<label class="control-label">問題番号</label>
						<input type="text" name="qnumber" value="${qnumber}" size="1" readonly>/
						<input type="text" value="${typeQuantity}" name="maxnumber" size="1" placeholder="Text" readonly>
					</div>
					&emsp;
					<div class="form-group">
						<label class="control-label">論点</label>
						<input type="text" name="ronten" value="${adminQuestion.ronten}" class="form-control" maxlength="32">
					</div>
				</div>
				</div>
				<div class="well">
					<div class="form-group">
						<label class="control-label">分野</label>
							<select name="catname" class="form-control">
								<c:forEach items="${catNames}" var="catName">
									<option value="${catName.key}" <c:if test="${adminQuestion.catid == catName.key}">selected</c:if>>${catName.value}</option>
								</c:forEach>
							</select>
							<select name="mainname" class="form-control"></select><input type="hidden" value="${adminQuestion.mainid}" name="hmainname">

							<select name="subname" class="form-control"></select><input type="hidden" value="${adminQuestion.subid}" name="hsubname">
					</div>
				</div>
				<div class="well">

					<div class="form-group">
						<label class="control-label">問題文章</label>
						<textarea rows="10" cols="75" class="form-control" name="question" maxlength="700">${adminQuestion.question}</textarea>
					</div>
					<div class="row">
						<div class="form-group col-xs-5">
							<label class="control-label">問題画像1</label>
							<input type="file" name="qimg1" class="qimg" accept="image/gif,image/jpeg,image/png">
						</div>
						<div class="col-xs-2"></div>
						<div class="form-group col-xs-5">
							<label class="control-label">問題画像2</label>
							<input type="file" name="qimg2" class="qimg" accept="image/gif,image/jpeg,image/png">
						</div>
					</div>
					<div class="row">
					<div class="form-group col-xs-5">
						<label class="control-label">問題画像3</label>
						<input type="file" name="qimg3" class="qimg" accept="image/gif,image/jpeg,image/png">
					</div>
					<div class="col-xs-2"></div>
					<div class="form-group col-xs-5">
						<label class="control-label">問題画像4</label>
						<input type="file" name="qimg4" class="qimg" accept="image/gif,image/jpeg,image/png">
					</div>
					</div>
					<input type="hidden" name="qimgcnt" value="0">
				</div>
				<div class="well">
					<label class="control-label">回答</label>

					<div class="row">
						<div class="form-group">
							<div class="col-xs-1">
								<label class="control-label">ア：</label>
							</div>
							<div class="col-xs-11">
								<textarea class="form-control" rows="1" cols="75" name="ans1" maxlength="150">${adminQuestion.ans1}</textarea>
							</div>

						</div>
					</div>
					<div class="row">
						<div class="col-xs-1"></div>
						<div class="col-xs-4">
							<input type="file" name="aimg1" class="aimg" accept="image/gif,image/jpeg,image/png"><input type="hidden" name="haimg1" value="0">
						</div>
					</div>

					<div class="row">
						<div class="form-group">
							<div class="col-xs-1">
								<label class="control-label">イ：</label>
							</div>
							<div class="col-xs-11">
								<textarea class="form-control" rows="1" cols="75" name="ans2" maxlength="150">${adminQuestion.ans2}</textarea>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-xs-1"></div>
						<div class="col-xs-4">
							<input type="file" name="aimg2" class="aimg" accept="image/gif,image/jpeg,image/png"><input type="hidden" name="haimg2" value="0">
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<div class="col-xs-1">
								<label class="control-label">ウ：</label>
							</div>
							<div class="col-xs-11">
								<textarea class="form-control" rows="1" cols="75" name="ans3" maxlength="150">${adminQuestion.ans3}</textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-1"></div>
						<div class="col-xs-4">
							<input type="file" name="aimg3" class="aimg" accept="image/gif,image/jpeg,image/png"><input type="hidden" name="haimg3" value="0">
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<div class="col-xs-1">
								<label class="control-label">エ：</label>
							</div>
							<div class="col-xs-11">
								<textarea class="form-control" rows="1" cols="75" name="ans4" maxlength="150">${adminQuestion.ans4}</textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-1"></div>
						<div class="col-xs-4">
							<input type="file" name="aimg4" class="aimg" accept="image/gif,image/jpeg,image/png"><input type="hidden" name="haimg4" value="0">
						</div>
					</div>
				</div>

				<div class="well">
					<label class="control-label">正答</label>
					<select name="sei">
						<option></option>
						<option value="ア" <c:if test="${adminQuestion.sei=='ア'}">selected</c:if>>ア</option>
						<option value="イ" <c:if test="${adminQuestion.sei=='イ'}">selected</c:if>>イ</option>
						<option value="ウ" <c:if test="${adminQuestion.sei=='ウ'}">selected</c:if>>ウ</option>
						<option value="エ" <c:if test="${adminQuestion.sei=='エ'}">selected</c:if>>エ</option>
					</select>
				</div>
				<div class="well">
					<div class="form-group">
						<label class="control-label">解説</label>
						<textarea rows="10" class="form-control" cols="75" name="kaisetu" maxlength="900">${adminQuestion.kaisetu}</textarea>
					</div>
					<label class="control-label">解説画像</label>
					<input type="file" name="kimg" accept="image/gif,image/jpeg,image/png"><input type="hidden" name="hkimg" value="0">
				</div>
					<div id="message"></div>
					<input type="button" value="前問へ" name="back" class="submitbt btn btn-info"><input type="button" value="次問へ" name="next" class="submitbt btn btn-info"><input type="button" value="プレビュー" name="preview" class="submitbt btn btn-warning">
					<input type="button" value="一覧" name="list" class="submitbt btn btn-success"><input type="button" value="中断保存" name="onetimesave" class="submitbt btn btn-success"><input type="button" value="投稿" name="posting" class="submitbt btn btn-primary">
					<input type="checkbox" value="" name="check">チェックを入れてから投稿ボタンを押下してください。
					<input type="hidden" name="submitname">

			</form>
		</div>
	</div>

</body>
</html>