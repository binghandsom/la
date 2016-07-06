$(function() {
	var regMethod = "phone";
	$("#whichWayReg button").click(function() {

		$("div#regForm input.form-control").val("");
		$("div#regForm label.mess").text("");

		var whichWay = $(this).html();

		if ("手机" == whichWay) {
			$("#inputEmail").css({
				"display" : "none"
			});
			$("#inputPhone").css({
				"display" : ""
			});
			regMethod = "phone";
			$("#getValidateCode").html("获取手机验证码");
		} else {
			$("#inputPhone").css({
				"display" : "none"
			});
			$("#inputEmail").css({
				"display" : ""
			});
			regMethod = "email";
			$("#getValidateCode").html("获取邮箱验证码");
		}
	});

	var messageAccount = $("label.messAccount");

	var regPhone = /^(1)\d{10}$/
	var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,9})$/;
	var phone = $("#inputPhone");
	var email = $("#inputEmail");
	var infoAccountOk = false;
	var infoPassOk = false;
	var infoRepassOk = false;
	$("input.regAccount").bind("keyup blur", function() {
		if (regMethod == "phone") {
			// 手机注册
			var phoneVal = phone.val().trim();
			if (regPhone.test(phoneVal)) {
				$(this).css({
					"background-color" : "#D6D6FF"
				});
				messageAccount.html("");
				infoAccountOk = true;
			} else {
				messageAccount.html("手机号码格式不正确");
				infoAccountOk = false;
			}
		} else {
			// 邮箱注册
			var emailVal = email.val();
			if (regEmail.test(emailVal)) {
				$(this).css({
					"background-color" : "#D6D6FF"
				});
				messageAccount.html("");
				infoAccountOk = true;
			} else {
				messageAccount.html("邮箱格式不正确");
				infoAccountOk = false;
			}
		}

	});
	var messagePass = $("label.messPass");
	var messRepass = $("label.messRepass");

	var regPass = new RegExp(
			"(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^0-9a-zA-Z]).{6,40}");
	var password = "";
	$("#inputPassword").keyup(function() {
		var tempPass = $(this).val();
		infoPassOk = false;
		if (tempPass.length < 6) {
			messagePass.html("密码长度必须大于6");
			messagePass.css({
				"color" : "red"
			});
			$(this).css({
				"background-color" : ""
			});
		} else if (tempPass.length > 40) {
			messagePass.css({
				"color" : "red"
			});
			$(this).css({
				"background-color" : ""
			});
			messagePass.html("密码长度过长");
		} else if (regPass.test(tempPass)) {
			messagePass.html("密码满足要求");
			password = $(this).val();
			$(this).css({
				"background-color" : "#D6D6FF"
			});
			messagePass.css({
				"color" : "yellow"
			});
			infoPassOk = true;
		} else {
			messagePass.css({
				"color" : "red"
			});
			$(this).css({
				"background-color" : ""
			});
			messagePass.html("密码必须包含数字，英文，特殊符号(如：\"* # ！.\"等)");
		}
	});
	$("#rePassword").keyup(function() {
		infoRepassOk = false;
		if ($(this).val() == password) {
			infoRepassOk = true;
			messRepass.html("");
		} else {
			messRepass.html("两次输入密码不一致");
		}

	});

	$("#loginForm").bind('keypress', function(event) {
		if (event.keyCode == "13") {
			login();
		}
	});
	// 登录方法
	$("#login").click(function() {
		login();
	});

	// 注册验证码，验证码发送至手机或邮箱
	var regData = "";
	$("#getValidateCode")
			.click(
					function() {

						if (infoAccountOk) {
							if (regMethod == "phone") {
								// 手机验证
								var phoneNum = phone.val();
								regData = "phone=" + phoneNum
										+ "&reason=register";
							} else {
								// 邮箱验证
								var emailVal = email.val();
								regData = "email=" + emailVal
										+ "&reason=register";
							}

							$
									.ajax({
										url : ctx
												+ "/userAccount/sendRegValidateCode",
										data : regData,
										type : 'POST',
										async : false,
										contentType : "application/x-www-form-urlencoded; charset=UTF-8",
										success : function(result) {
											// alert(result.success);
											if (result.success) {
												var obj = $("input[name=validateCode]");
												obj.removeAttr("disabled");
												var second = 60;
												setInterval(
														function() {
															obj
																	.attr(
																			"placeholder",
																			--second
																					+ "秒内填写");
															if (second <= 0) {
																$(
																		"input[name=validateCode]")
																		.attr(
																				"placeholder",
																				"请重新获取");
															}
														}, 1000);
											} else {
												$("label.messVali")
														.html(
																result.message.failReason);
											}
										}
									});
						}

					});
	$("input[name=validateCode]").focus(function() {
		$(this).html("");
		$("label.messVali").html("");
	});
	$("#registerBtn")
			.click(
					function() {
						// 信息填写完毕
						if (infoAccountOk && infoPassOk && infoRepassOk) {
							var valiValue = $("input[name=validateCode]").val()
									.trim();
							if ("" == valiValue) {
								$("label.messVali").html("请填写验证码");
							} else {
								// 注册请求
								var data = "";
								if (regMethod == "phone") {
									// 手机验证
									var phoneNum = phone.val();
									data = "phone=" + phoneNum + "&password="
											+ password + "&valiCode="
											+ valiValue;
								} else {
									// 邮箱验证
									var emailVal = email.val();
									data = "email=" + emailVal + "&password="
											+ password + "&valiCode="
											+ valiValue;
								}
								$
										.ajax({
											url : ctx + "/userAccount/register",
											data : data,
											type : 'POST',
											async : false,
											contentType : "application/x-www-form-urlencoded; charset=UTF-8",
											success : function(result) {
												if (result.success) {
													alert("注册成功");
													window.location.href = ctx
															+ "/userMainInfo/editMainInfo";
												} else {
													if (result.message) {
														alert("注册失败"
																+ result.message.resultMess);
													}
												}
											}
										});
							}
						} else {
							// 信息不完全
							alert("信息填写不完全");
						}
					});

});
login = function() {
	var data = "email=" + $("#loginForm #email").val() + "&password="
			+ $("#loginForm #loginPassword").val();
	$.ajax({
		type : 'POST',
		async : false,
		url : ctx + "/userAccount/loginCheck",
		data : data,
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		success : function(result) {
			if (result.success) {
				window.location.href = ctx + "/common/index";
			} else {
				$("#loginError").html(result.message.failDetail);
			}
		}
	});
}
