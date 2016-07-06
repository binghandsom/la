/**
 * 用户在注册完成后编辑个人主要信息如年龄，昵称，头像等最基本的信息
 */
$(function() {
	$("#headImg").css(
			{
				'background-image' : "url(" + ctx
						+ '/resources/img/system/emptyHeadPic.png' + ")",
				"background-size" : "100%"
			});
	$("#heightSlider").slider({
		orientation : "horizontal",
		range : "min",
		min : 130,
		max : 220,
		value : 170,
		slide : function(event, ui) {
			$("#heightShow").html(ui.value + "cm");
			$("#height").val(ui.value);
		}
	});
	$("#salarySlider").slider({
		orientation : "horizontal",
		range : "min",
		min : 0,
		max : 15000,
		step : 500,
		value : 3000,
		slide : function(event, ui) {
			$("#salaryShow").html(ui.value);
			$("#salary").val(ui.value);
		}
	});

	$("#birthDaypicker").datepicker(
			{
				changeYear : true,
				/* 区域化周名为中文 */
				dayNamesMin : [ "日", "一", "二", "三", "四", "五", "六" ],
				/* 每周从周一开始 */
				firstDay : 1,
				/* 区域化月名为中文习惯 */
				monthNames : [ "1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月",
						"9月", "10月", "11月", "12月" ],
				/* 月份显示在年后面 */
				showMonthAfterYear : true,
				/* 年份后缀字符 */
				yearSuffix : "年",
				/*
				 * 格式化中文日期 （因为月份中已经包含“月”字，所以这里省略）
				 */
				dateFormat : "yy年MMdd日",
				yearRange : 'c-50:c-5',
				showOn : "button",
				buttonImage : ctx + "/resources/img/system/datePicker.png",
				buttonImageOnly : true
			});
	$("#birthDaypicker").change(
			function() {
				// alert($(this).val());
				var fullDateString = $(this).val();
				var monthBeginIndex = fullDateString.indexOf("年");
				var monthEndIndex = fullDateString.indexOf("月");
				var dateEndIndex = fullDateString.indexOf("日");
				var month = parseInt($(this).val().substring(
						monthBeginIndex + 1, monthEndIndex));
				var date = parseInt($(this).val().substring(monthEndIndex + 1,
						dateEndIndex));
				// alert(month + " " + day);
				var constellation = getConstellation(month, date);
				$("#constellation").val(constellation);
				$("#constellationShow").html(constellation);
				$(".messBirthDay").html("");
			});

	$("#radio").buttonset();
	var nickNameOk = $("#nickNameOk");
	$("input[name=nickName]")
			.blur(
					function() {
						var nickName = $(this).val().trim();
						// alert(nickName);

						nickNameOk.value = false;
						if (nickName == "") {
							nickNameOk.val(false);
							$("label.messNickName").css({
								"color" : "red"
							}).html("昵称为必填信息");
						} else {

							$
									.ajax({
										url : ctx
												+ "/userMainInfo/checkNickName",
										data : "nickName=" + nickName,
										type : 'POST',
										async : false,
										contentType : "application/x-www-form-urlencoded; charset=UTF-8",
										success : function(result) {
											if (result.success) {
												nickNameOk.val(true);
												$("label.messNickName").css({
													"color" : "green"
												}).html("昵称可用");
											} else {
												nickNameOk.val(false);
												$("label.messNickName").css({
													"color" : "red"
												}).html("昵称已被注册，不可用");
											}
										}
									});
						}
					});
	$("#choosePicBtn").click(function() {
		$("#headPicFile").click();
	});
	$(".submit>button").click(function() {
		// alert($(this).attr("goWhere"));
		$("#goWhere").val($(this).attr("goWhere"));
		$("form").submit();
	});
});

function fileUpload_onselect() {
	var path = $("#headPicFile").val();
	if ($("#headPicFile").val() == "") {
		$("label.messHeadPic").css({
			"color" : "red"
		}).html("您还没选择头像");
		$("#headPicOk").val(false);
	} else {
		var uploadUrl = encodeURI(encodeURI(ctx + "/userMainInfo/isPictureFile"));
		$.ajaxFileUpload({
			url : uploadUrl,
			secureuri : false, // 是否启用安全提交,默认为false
			fileElementId : 'headPicFile', // 文件选择框的id属性
			dataType : 'text',
			success : function(data, success) {
				// alert(data.success);
				$("#headPicOk").val(data.success);
				if (!data.success) {
					$("label.messHeadPic").css({
						"color" : "red"
					}).html(data.message.reason);
				} else {
					var picName = data.message.picName;
					var random = Math.random();
					$("#headImg").css(
							{
								'background' : "url(" + ctx
										+ "/userMainInfo/loadPhoto?picName="
										+ picName
										+ "&picType=tempPicture&random="
										+ random + ") no-repeat",
								"background-size" : "300px 300px"
							});

					$("label.messHeadPic").css({
						"color" : "green"
					}).html("头像可用");
				}
			},
			error : function(data, status, e) {
				$("label.messHeadPic").css({
					"color" : "red"
				}).html("图片文件异常");
				$("#headPicOk").val(false);
			}
		});
	}

}

/* 检查表单信息 */
function checkForm() {
	var nickNameOk = $("#nickNameOk");
	if ($("input[name=nickName]").val().trim() == "") {
		$("label.messNickName").css({
			"color" : "red"
		}).html("昵称为必填项");
		return false;
	}
	if (nickNameOk.val() + "" == "false") {
		$("label.messNickName").css({
			"color" : "red"
		}).html("昵称已被注册，不可用");
		return false;
	}
	// alert($("form").serialize());
	if ($("#birthDaypicker").val() == "") {
		$("label.messBirthDay").css({
			"color" : "red"
		}).html("生日为必填信息");
		return false;
	}
	// alert($("#headPicOk").val());
	if ($("#headPicOk").val() + "" == "false") {
		$("label.messHeadPic").css({
			"color" : "red"
		}).html("头像为必填信息");
		return false;
	}
	return true;
}
/* 获取星座 */
function getConstellation(month, date) {
	var value = "";

	if (month == 1 && date >= 20 || month == 2 && date <= 18) {
		value = "水瓶座";
	}
	if (month == 2 && date >= 19 || month == 3 && date <= 20) {
		value = "双鱼座";
	}
	if (month == 3 && date >= 21 || month == 4 && date <= 19) {
		value = "白羊座";
	}
	if (month == 4 && date >= 20 || month == 5 && date <= 20) {
		value = "金牛座";
	}
	if (month == 5 && date >= 21 || month == 6 && date <= 21) {
		value = "双子座";
	}
	if (month == 6 && date >= 22 || month == 7 && date <= 22) {
		value = "巨蟹座";
	}
	if (month == 7 && date >= 23 || month == 8 && date <= 22) {
		value = "狮子座";
	}
	if (month == 8 && date >= 23 || month == 9 && date <= 22) {
		value = "处女座";
	}
	if (month == 9 && date >= 23 || month == 10 && date <= 22) {
		value = "天秤座";
	}
	if (month == 10 && date >= 23 || month == 11 && date <= 21) {
		value = "天蝎座";
	}
	if (month == 11 && date >= 22 || month == 12 && date <= 21) {
		value = "射手座";
	}
	if (month == 12 && date >= 22 || month == 1 && date <= 19) {
		value = "摩羯座";
	}
	return value;
}