/**
 * 编辑照片页面引用
 */
$(function() {
	var x = $("div.detailMenu>a[href='" + ctx + "/detailInfos/editPhotos']",
			window.parent.document);
	beActive(x);

	$("#uploadTriggerBtn").click(function() {
		$("#previewBox").empty();
	});
	$("#addPhotoImgBtn").click(function() {
		// 加号图片点击触发文件选择事件
		$("#photoFiles").click();
		$("#previewBox img").remove();

	}).hover(
			function() {
				$(this).attr("src",
						ctx + "/resources/img/system/add_photo72pxHOVER.png");
				$(this).css({
					"cursor" : "pointer"
				});
			},
			function() {
				$(this).attr("src",
						ctx + "/resources/img/system/add_photo72px.png");
			});
	$("#confirmUploadPhotosBtn").click(function() {
		alert("确定上传");
		$.ajax({
			url : ctx + "/userMainInfo/uploadHeadPics",
			type : 'POST',
			data : x = "x",
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(data, success) {

			},
			error : function(returndata) {
				alert(returndata);
			}
		});
	});
});

function fileChanged() {
	var files = $("#photoFiles")[0].files;
	var fileLength = files.length;
	for (var i = 0; i < fileLength; i++) {
		var imgTag = "<img class='previewPic' id='previewPic" + i + "' dd='xxx"
				+ i + "' width='100px' height='100px'	src='" + ctx
				+ "/resources/img/system/loadingPicture.gif'>";
		$("#previewBox").append(imgTag);
	}

	for (var i = 0; i < fileLength; i++) {
		var formData = new FormData();
		formData.append("file", files[i]);
		if (i == 0) {
			formData.append("isNewGroup", "yes");
		}
		$.ajax({
			url : ctx + "/userMainInfo/isPictureFiles",
			type : 'POST',
			data : formData,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(data, success) {
				if (!data.success) {
					$("#previewPic" + i).attr("src",
							ctx + "/resources/img/system/badPicture.jpg");
					var ax = $("#previewPic" + i).attr("dd");
				} else {
					var picName = data.message.picName;
					var random = Math.random();
					$("#previewPic" + i).attr(
							"src",
							ctx + "/userMainInfo/loadPhoto?picName=" + picName
									+ "&picType=tempPictureList&random="
									+ random);
				}
			},
			error : function(returndata) {
				alert(returndata);
			}
		});
	}
}
function beActive(obj) {
	$("div.detailMenu>a", window.parent.document).removeClass("active");
	obj.addClass("active");
}