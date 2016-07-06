<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/inc/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>xxx的信息主页</title>

<script src="${ctx }/resources/js/pages/userInfo/selfInfo.js"
	type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx }/resources/css/pages/userInfo/selfInfo.css" />
</head>

<body>

	<div class="container">
		<div id="photoPreviewBox">
			<img id="photoCurrentPreview" src="${ctx }/resources/img/arrow_96px - up.png" /> <a
				href="#" class="preOrNext" id="preImg"><img
				src="${ctx }/resources/img/system/preImg.png" /></a>
			<div id="listBox">
				<div id="photoListPreview">
					<a href="#" class="activeImg"><img
						src="${ctx }/resources/img/42bird.png" /></a> <a href="#"><img
						src="${ctx }/resources/img/64bird.png" /></a> <a href="#"><img
						src="${ctx }/resources/img/42bird.png" /></a> <a href="#"><img
						src="${ctx }/resources/img/64bird.png" /></a> <a href="#"><img
						src="${ctx }/resources/img/42bird.png" /></a> <a href="#"><img
						src="${ctx }/resources/img/64bird.png" /></a> <a href="#"><img
						src="${ctx }/resources/img/42bird.png" /></a> <a href="#"><img
						src="${ctx }/resources/img/64bird.png" /></a> <a href="#"><img
						src="${ctx }/resources/img/42bird.png" /></a>
				</div>
			</div>
			<a href="#" class="preOrNext" id="nextImg"><img
				src="${ctx }/resources/img/system/nextImg.png" /></a>
		</div>
	</div>
</body>

</html>