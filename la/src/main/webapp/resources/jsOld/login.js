$(function() {
	$('#loginValidateCode').focus(function() {
		$("#loginErrorMsg").text("");
	});
	$('#registValidateCode').focus(function() {
		$("#registErrorMsg").text("");
	});
	$('#loginForm').validate({
		submitHandler : function() {
			doLogin();
		},
		rules : {
			useremail : {
				required : true,
			},
			userpassword : {
				required : true,
			}
		},
		messages : {
			useremail : {
				required : "账号不能为空",
			},
			userpassword : {
				required : "密码不能为空",
			}
		}

	});
	$('#registForm').validate({
		submitHandler : function() {
			doRegist();
		},
		rules : {
			username : {
				required : true,
			},
			useremail : {
				required : true,
				email : true
			},
			userpassword : {
				required : true,
				minlength : 6
			},
			conformuserpassword : {
				required : true,
				equalTo : '#userpassword'
			}
		},
		messages : {
			username : {
				required : "账号不能为空",
			},
			useremail : {
				required : "邮箱不能为空",
				email : "邮箱格式不对"
			},
			userpassword : {
				required : "密码不能为空",
				minlength : "密码不能低于6位!"
			},
			conformuserpassword : {
				required : "确认密码不能为空",
				equalTo : "确认密码与密码不一致"
			}
		},
	});
});

function back() {
	window.location.href = ctx + "/blogEssay/getMyblog";

}
function changeValidateCode(ValidateCodeImg) {
	var ValidateCodeImg = document.getElementById(ValidateCodeImg);
	ValidateCodeImg.src = ctx + "/blogUser/ValidateCode?random="
			+ Math.random();
}

function doLogin() {
	var data = $("#loginForm").serialize();
	var flag = false;
	$.ajax({
		type : 'POST',
		async : false,
		url : ctx + "/blogUser/loginCheck",
		data : data,
		success : function(result) {
			$("#loginErrorMsg").text(result);

			if (result == '登录成功') {
				flag = true;
			}
		}
	});
	falg = true;
	if (flag) {
		window.location.href = ctx + "/blogEssay/getMyblog";
	}
}
function doRegist() {
	var data = $("#registForm").serialize();
	var flag = false;
	$.post(ctx + "/blogUser/regist", data, function(result) {
		$("#registErrorMsg").text(result);
		if (result == '注册成功') {
			window.location.href = ctx + "/blogEssay/getMyblog";
		}
	});
}
