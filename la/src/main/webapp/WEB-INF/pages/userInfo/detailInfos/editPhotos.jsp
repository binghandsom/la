<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ include file="/WEB-INF/inc/include.jsp"%>
<script
	src="${ctx }/resources/js/pages/userInfo/detailInfos/editPhotos.js"
	type="text/javascript" charset="utf-8"></script>
<!-- ajax文件上传 -->
<script src="${ctx }/resources/js/common/ajaxfileupload.js"
	type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx }/resources/css/pages/userInfo/detailInfos/editPhotos.css" />
</head>
<body>
	<form id="uploadPhotosForm">
		<input name="photoFiles" id="photoFiles" multiple type="file"
			onchange="fileChanged()">
	</form>

	<hr>
	<button class="btn-primary" id="uploadTriggerBtn" data-toggle="modal"
		data-target="#photoChoosingModal">上传照片</button>
	<hr>
	<h3 style="color: darkred;">我的照片列表</h3>
	<div class="pictureList">
		<div class="img">
			<a href="#"> <img src="${ctx}/resources/img/touxiangDemo.jpg"
				width="160" height="160">
			</a>
			<div class="desc">在此处添加对图像的描述</div>
		</div>
		<div class="img">
			<a href="#"> <img src="${ctx}/resources/img/touxiangDemo.jpg"
				width="160" height="160">
			</a>
			<div class="desc">在此处添加对图像的描述</div>
		</div>
		<div class="img">
			<a href="#"> <img src="${ctx}/resources/img/touxiangDemo.jpg"
				width="160" height="160">
			</a>
			<div class="desc">在此处添加对图像的描述</div>
		</div>
		<div class="img">
			<a href="#"> <img src="${ctx}/resources/img/touxiangDemo.jpg"
				width="160" height="160">
			</a>
			<div class="desc">在此处添加对图像的描述</div>
		</div>
	</div>
	<hr />
	<div style="width: 300px; height: 30px; margin: 0 auto;">
		<button goWhere="" class="btn btn-warning">继续编辑详细信息</button>
		<button goWhere="lookingLover" class="btn btn-success">先睹为快</button>

	</div>
	<div class="modal fade" id="photoChoosingModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">上传照片文件</h4>
				</div>
				<div class="modal-body" style="border: solid 1px;">
					<img id="addPhotoImgBtn" alt=""
						src="${ctx}/resources/img/system/add_photo72px.png">
					<div id="previewBox" style="display: inline;">
						<img class="previewPic" alt="" width="100px" height="100px"
							src="${ctx}/resources/img/system/loadingPicture.gif">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消上传</button>
					<button type="button" id="confirmUploadPhotosBtn"
						class="btn btn-primary">上传</button>
				</div>
			</div>
		</div>
	</div>
</body>

</html>