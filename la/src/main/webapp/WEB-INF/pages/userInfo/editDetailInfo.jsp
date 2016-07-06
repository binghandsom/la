<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/inc/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详细信息</title>
<%-- <script src="${ctx }/resources/js/pages/userInfo/editMainInfo.js"
	type="text/javascript" charset="utf-8"></script> --%>

</head>

<body>

	编辑个人详细信息
	<div class="container-fluid" style="border: solid 1px;">kdkfksdk</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-3 col-xm-3"
				style="border: solid 1px;">
				<img alt="" src="${ctx}/resources/img/touxiangDemo.jpg" width="150"
					height="150" style="margin: 0 auto; display: block">
				<div style="text-align: center;">生疏的爱</div>
				<div class="list-group detailMenu">
					<a href="${ctx }/detailInfos/editInterests" target="contentFrame"
						class="list-group-item list-group-item-warning">兴趣爱好</a> <a
						href="${ctx }/detailInfos/editLivingCondition"
						target="contentFrame"
						class="list-group-item list-group-item-warning">生活状态</a> <a
						href="${ctx }/detailInfos/editWorkingCondition"
						target="contentFrame"
						class="list-group-item list-group-item-warning">工作情况</a> <a
						href="${ctx }/detailInfos/editLoveAttitude" target="contentFrame"
						class="list-group-item list-group-item-warning">恋爱态度</a> <a
						href="${ctx }/detailInfos/editMatingPreference"
						target="contentFrame"
						class="list-group-item list-group-item-warning">择偶要求</a> <a
						href="${ctx }/detailInfos/editPhotos" target="contentFrame"
						class="list-group-item list-group-item-warning">我的相册</a>
				</div>
			</div>
			<div class="col-lg-9 col-md-9 col-sm-9 col-xm-9"
				style="border: solid 1px;">
				<iframe name="contentFrame" id="contentFrame"
					src="${ctx }/detailInfos/editInterests" scrolling="no"
					frameborder="none" style="width: 100%; height: 100%"
					onload="this.height=this.contentWindow.document.documentElement.scrollHeight">
				</iframe>
			</div>
		</div>
	</div>
</body>
</html>