<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/inc/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${ctx }/resources/js/pages/userAccount/changePass.js"
	type="text/javascript" charset="utf-8"></script>
<title>重设密码</title>

</head>
<body>
	<div class="form"
		style="z-index: 1; margin: 40px auto; width: 300px; padding: 15px 15px;">
		<div class="form-signin" id="regForm">
			<h2 class="form-signin-heading" style="color: wheat;">重置密码</h2>

			<input type="text" name="email" class="account form-control"
				placeholder="邮箱/手机"> <label class="messAccount mess"
				style="color: red;"></label> <br /> <input type="password"
				id="inputPassword" name="password" class="form-control"
				placeholder="密码" oncopy="return false" onpaste="return false">
			<label class="messPass mess" style="color: red;"></label> <br /> <input
				type="password" id="rePassword" name="rePassword" value=""
				class="form-control" placeholder="确认密码" oncopy="return false"
				onpaste="return false"> <label class="messRepass mess"
				style="color: red;"></label> <br />
			<button class="btn-xs btn-info" id="getValidateCode">获取验证码</button>
			<input name="validateCode" style="width: 6em;" placeholder="请获取验证码"
				disabled="disabled" /> <br /> <label class="messVali mess"
				style="color: red;"></label> <br />
			<button id="changePassBtn" class="btn btn-lg btn-success btn-block">确认修改密码</button>

		</div>

	</div>
</body>
</html>