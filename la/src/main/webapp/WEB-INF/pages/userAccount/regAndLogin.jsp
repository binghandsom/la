<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/inc/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录注册</title>

<script src="${ctx }/resources/js/pages/userAccount/regAndLogin.js"
	type="text/javascript" charset="utf-8"></script>

</head>

<body>

	<div class="row container-fluid">

		<div class="col-lg-6 col-sm-6 col-md-6">
			<div class="" style="border-right: dashed 1px #008000">
				<a class="navbar-brand" href="#"><img height="70px"
					src="${ctx }/resources/img/signature.png" /></a>

			</div>

		</div>
		<div class="col-lg-6 col-sm-6 col-md-6" style="padding-top: 30px;">
			<div id="loginForm">
				<label>账号</label><input type="text" name="email" id="email" value=""
					placeholder="手机/邮箱" /> <label>密码</label><input type="password"
					name="password" id="loginPassword" value="" placeholder="登录密码" />
				<button id="login" class="btn btn-warning">登录</button>
			</div>
			<input type="checkbox" name="remem" id="remem" value="false" /><span
				style="color: darkgray;">下次自动登陆</span> &nbsp;&nbsp;&nbsp; <a
				href="${ ctx}/userAccount/changePass">重置密码？</a> <label
				id="loginError" style="display: inline; color: red;"></label>
		</div>
	</div>
	<div class="row ">

		<div class="col-lg-12 col-sm-12 col-md-12">
			<div class="form"
				style="z-index: 1; position: absolute; width: 300px; right: 180px; background: grey; opacity: 0.8; margin-top: 80px; padding: 15px 15px;">
				<div class="form-signin" id="regForm">
					<h2 class="form-signin-heading" style="color: wheat;">注册账号</h2>

					<div id="whichWayReg">
						<label><span>选择何种注册方式</span> <span
							class="btn-group-sm btn-group" style="display: inline;"
							role="group">
								<button type="button" class="btn  btn-primary">手机</button>
								<button type="button" class="btn  btn-default">邮箱</button>
						</span></label> <br> <br>

					</div>

					<input type="email" id="inputEmail" class="form-control regAccount"
						style="display: none;" name="email" placeholder="电子邮箱" required>
					<input type="phone" id="inputPhone" name="phone"
						class="form-control regAccount" style="" placeholder="手机号码"
						value="" required> <label class="messAccount mess"
						style="color: red;"></label> <br /> <input type="password"
						id="inputPassword" name="password" class="form-control"
						placeholder="密码" oncopy="return false" onpaste="return false">
					<label class="messPass mess" style="color: red;"></label> <br /> <input
						type="password" id="rePassword" name="rePassword" value=""
						class="form-control" placeholder="确认密码" oncopy="return false"
						onpaste="return false"> <label class="messRepass mess"
						style="color: red;"></label> <br />
					<button class="btn-xs btn-info" id="getValidateCode">获取手机验证码</button>
					<input name="validateCode" style="width: 6em;" placeholder="请获取验证码"
						disabled="disabled" /> <br /> <label class="messVali mess"
						style="color: red;"></label> <br />
					<button id="registerBtn" class="btn btn-lg btn-success btn-block">免费注册</button>

				</div>

			</div>

			<div id="carousel-example-generic" class="carousel slide "
				data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="${ctx }/resources/img/poster1.jpg"
							style="height: 600px; width: 100%;" alt="">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img src="${ctx }/resources/img/poster2.jpg"
							style="height: 600px; width: 100%;" alt="...">
						<div class="carousel-caption"></div>
					</div>
				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
	<div class=""
		style="width: 100%; padding-top: 20px; padding-bottom: 15px; vertical-align: middle; align: center; text-align: center">
		<span style="color: gray">联系我们：xxxxxx@xxx.com</span> <br /> <span
			style="color: gray">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;123456789</span>
	</div>
</body>

</html>