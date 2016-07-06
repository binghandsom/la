/**
 * 修改密码页面js
 */
$(function() {
	var messageAccount = $("label.messAccount");
	var regPhone = /^(1)\d{10}$/
	var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,9})$/;
	// 这里的email，泛指账号，既可以是手机也可以是email
	var email = $("input[name=email]");
	var infoAccountOk = false;
	var infoPassOk = false;
	var infoRepassOk = false;
	var regMethod = "";
	$("input.account").bind("keyup blur", function() {
		var accountVal = email.val();
		if (regPhone.test(accountVal) || regEmail.test(accountVal)) {
			$(this).css({
				"background-color" : "#D6D6FF"
			});
			messageAccount.html("");
			if (regPhone.test(accountVal)) {
				regMethod = "phone";
			} else {
				regMethod = "email";
			}
			infoAccountOk = true;
		} else {
			messageAccount.html("账号格式不正确");
			infoAccountOk = false;
		}
		// alert(infoAccountOk);
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
	// 改密验证码，验证码发送至手机或邮箱
	var regData = "";
	$("#getValidateCode")
			.click(
					function() {
						if (infoAccountOk) {
							if (regMethod == "phone") {
								// 手机验证
								var phoneNum = email.val();
								regData = "phone=" + phoneNum
										+ "&reason=changePass";
							} else {
								// 邮箱验证
								var emailVal = email.val();
								regData = "email=" + emailVal
										+ "&reason=changePass";
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
											var obj = $("input[name=validateCode]");
											if (result.success) {
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

	$("#changePassBtn")
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
									var phoneNum = email.val();
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
											url : ctx
													+ "/userAccount/doChangePass",
											data : data,
											type : 'POST',
											async : false,
											contentType : "application/x-www-form-urlencoded; charset=UTF-8",
											success : function(result) {
												if (result.success) {
													alert("修改密码成功");
													window.location.href = ctx
															+ "/common/index";
												} else {
													if (result.message) {
														alert("修改密码失败"
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