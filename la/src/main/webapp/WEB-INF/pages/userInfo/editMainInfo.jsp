<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/inc/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填写主要信息</title>
<script src="${ctx }/resources/js/pages/userInfo/editMainInfo.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${ctx }/resources/jquery-ui-1.11.4/jquery-ui.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${ctx }/resources/js/common/ajaxfileupload.js"
	type="text/javascript" charset="utf-8"></script>

<link rel="stylesheet" type="text/css"
	href="${ctx }/resources/jquery-ui-1.11.4/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx }/resources/jquery-ui-1.11.4/jquery-ui.structure.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx }/resources/jquery-ui-1.11.4/jquery-ui.theme.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx }/resources/css/pages/userInfo/editMainInfo.css" />

</head>

<body>
	<h1
		style="margin: 25px auto; display: block; width: 400px; color: #339977;">编辑个人基本信息</h1>



	<input id="nickNameOk" value="false" type="hidden">
	<input id="headPicOk" value="false" type="hidden">
	<form action="${ctx }/userMainInfo/doEditMainInfo"
		onsubmit="return checkForm()" method="post">
		<div class="container">
			<div class="col-lg-6 col-md-6 col-sm-6 " style="padding-left: 200px;">
				<label>昵称</label> <input name="nickName" value="" placeholder=""><label
					class="messNickName"></label>
				<hr />
				<label>性别</label> <span class="radio" id="genderInput"> <label><input
						type="radio" name="gender" value="0" checked> 女 </label> <label><input
						type="radio" name="gender" value="1"> 男 </label>
				</span>
				<hr />
				<label>生日</label> <input type="text" placeholder="点击图标选择日期"
					id="birthDaypicker" name="birthDay" readonly="readonly"
					style="width: 120px; z-index: 10;"> <label
					class="messBirthDay"></label>&nbsp;&nbsp;&nbsp; <label>星座</label> <span
					id="constellationShow"></span> <input type="hidden"
					name="constellation" id="constellation" />
				<hr />
				<label>婚姻经历</label>
				<div id="radio" style="display: inline;">
					<input type="radio" id="radio1" name="marriage" checked="checked"
						value="0"> <label for="radio1">未婚</label> <input
						type="radio" id="radio2" name="marriage" value="1"> <label
						for="radio2">离异</label> <input type="radio" id="radio3"
						name="marriage" value="2"> <label for="radio3">失偶</label>
				</div>
				<hr />
				<label>身高</label> <span id="heightShow">170cm</span>
				<div id="heightSlider"></div>
				<input type="hidden" value="170" name="height" id="height">
				<hr />
				<label>月薪</label> <span id="salaryShow">3000</span>
				<div id="salarySlider"></div>
				<input type="hidden" value="3000" name="salary" id="salary">
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6">
				<label>头像</label>
				<iframe id="headImg"> </iframe>
				<br>
				<button type="button" class="btn-primary" id="choosePicBtn">选择头像</button>
				<input type="file" name="headPic" id="headPicFile"
					style="display: none; background: #fff; border: 1px dotted #ccc"
					onchange="return fileUpload_onselect()"> <label
					class="messHeadPic"></label>
				<hr />
				<label>爱情宣言</label>
				<textarea name="declaration" cols="40" rows="4"
					style="color: darkgreen; font-family: 华文行楷; font-size: 1.5em;"
					onfocus="if(value=='关于爱情你最想说什么？'){value=''}"
					onblur="if (value ==''){value='关于爱情你最想说什么？'}">关于爱情你最想说什么？</textarea>
			</div>
		</div>
		<div class="submit" style="margin: 20 auto; width: 400px;">
			<input type="hidden" id="goWhere" name="goWhere">
			<button type="button" goWhere="editDetailInfo" class="btn btn-warning">继续编辑个人详细信息</button>
			<button type="button" goWhere="lookingLover" class="btn btn-success">详细信息以后再写，先睹为快</button>
		</div>
	</form>
</body>
</html>