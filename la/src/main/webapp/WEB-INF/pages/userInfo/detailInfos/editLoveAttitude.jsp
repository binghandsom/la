<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ include file="/WEB-INF/inc/include.jsp"%>

<script src="${ctx }/resources/jquery-ui-1.11.4/jquery-ui.min.js"
	type="text/javascript" charset="utf-8"></script>

<link rel="stylesheet" type="text/css"
	href="${ctx }/resources/jquery-ui-1.11.4/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx }/resources/jquery-ui-1.11.4/jquery-ui.structure.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx }/resources/jquery-ui-1.11.4/jquery-ui.theme.min.css" />

<script
	src="${ctx }/resources/js/pages/userInfo/detailInfos/editLoveAttitude.js"
	type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx }/resources/css/pages/userInfo/detailInfos/editLoveAttitude.css" />


</head>
<body>
	<hr>
	<fieldset>
		<div>
			<label class="section" for="loveTimes">恋爱次数</label> <select
				name="loveTimes" id="loveTimes">
				<option value="" selected="selected">请选择</option>
				<option value="未谈过恋爱">未谈过恋爱</option>
				<option value="谈过3次以内恋爱">谈过3次以内恋爱</option>
				<option value="恋爱次数很多">恋爱次数很多</option>
			</select><label class="section" for="dislikedShengxiao">不喜欢的生肖</label> <select
				name="dislikedShengxiao" id="dislikedShengxiao">
				<option value="" selected="selected">没有不喜欢的</option>
				<option value="鼠">鼠</option>
				<option value="牛">牛</option>
				<option value="虎">虎</option>
				<option value="兔">兔</option>
				<option value="龙">龙</option>
				<option value="蛇">蛇</option>
				<option value="马">马</option>
				<option value="羊">羊</option>
				<option value="猴">猴</option>
				<option value="鸡">鸡</option>
				<option value="狗">狗</option>
				<option value="猪">猪</option>
			</select>
		</div>
		<div>

			<label class="section" for="whenShouldMarry">何时结婚</label> <select
				name="whenShouldMarry" id="whenShouldMarry">
				<option value="" selected="selected">请选择</option>
				<option value="认同闪婚">认同闪婚</option>
				<option value="一年内">一年内</option>
				<option value="两年内">两年内</option>
				<option value="三年内">三年内</option>
				<option value="时机成熟就结婚">时机成熟就结婚</option>
			</select><label class="section" for="wantChild">是否想要孩子</label> <select
				name="wantChild" id="wantChild">
				<option value="" selected="selected">请选择</option>
				<option value="想要孩子">想要孩子</option>
				<option value="不想要孩子">不想要孩子</option>
				<option value="视情况而定">视情况而定</option>
			</select>
		</div>
		<div>
			<label class="section" for="liveWithParents">婚后与父母住吗</label> <select
				name="liveWithParents" id="liveWithParents">
				<option value="" selected="selected">请选择</option>
				<option value="与自己父母同住">与自己父母同住</option>
				<option value="不与自己父母同住">不与自己父母同住</option>
				<option value="尊重伴侣意见">尊重伴侣意见</option>
				<option value="视具体情况而定">视具体情况而定</option>
			</select><label class="section" for="liveWithParentsInLaw">与对方父母同住</label> <select
				name="liveWithParentsInLaw" id="liveWithParentsInLaw">
				<option value="" selected="selected">请选择</option>
				<option value="愿意">愿意</option>
				<option value="不愿意">不愿意</option>
				<option value="视具体情况而定">视具体情况而定</option>
			</select>
		</div>
		<div>
			<label class="section" for="whetherAcceptDistance">是否接受异地</label> <select
				name="whetherAcceptDistance" id="whetherAcceptDistance">
				<option value="" selected="selected">请选择</option>
				<option value="接受">接受</option>
				<option value="不接受">不接受</option>
				<option value="视具体情况而定">视具体情况而定</option>
			</select>
		</div>
	</fieldset>
	<label class="section" for="desiredEngagementWay">喜欢的约会方式</label>
	<p id="desiredEngagementWay">
		<span><input id="desiredEngagementWay_1"
			name="desired_engagement_way" type="checkbox" value="餐厅"><label
			for="desiredEngagementWay_1">餐厅</label></span> <span><input
			id="desiredEngagementWay_2" name="desired_engagement_way"
			type="checkbox" value="茶楼"><label
			for="desiredEngagementWay_2">茶楼</label></span> <span><input
			id="desiredEngagementWay_3" name="desired_engagement_way"
			type="checkbox" value="咖啡厅"><label
			for="desiredEngagementWay_3">咖啡厅</label></span> <span><input
			id="desiredEngagementWay_4" name="desired_engagement_way"
			type="checkbox" value="酒吧"><label
			for="desiredEngagementWay_4">酒吧</label></span> <span><input
			id="desiredEngagementWay_5" name="desired_engagement_way"
			type="checkbox" value="看电影"><label
			for="desiredEngagementWay_5">看电影</label></span> <span><input
			id="desiredEngagementWay_6" name="desired_engagement_way"
			type="checkbox" value="看演出"><label
			for="desiredEngagementWay_6">看演出</label></span> <span><input
			id="desiredEngagementWay_7" name="desired_engagement_way"
			type="checkbox" value="看展览"><label
			for="desiredEngagementWay_7">看展览</label></span> <span><input
			id="desiredEngagementWay_8" name="desired_engagement_way"
			type="checkbox" value="逛街"><label
			for="desiredEngagementWay_8">逛街</label></span> <span><input
			id="desiredEngagementWay_9" name="desired_engagement_way"
			type="checkbox" value="公园散步"><label
			for="desiredEngagementWay_9">公园散步</label></span> <span><input
			id="desiredEngagementWay_10" name="desired_engagement_way"
			type="checkbox" value="郊游"><label
			for="desiredEngagementWay_10">郊游</label></span> <span><input
			id="desiredEngagementWay_11" name="desired_engagement_way"
			type="checkbox" value="户外运动"><label
			for="desiredEngagementWay_11">户外运动</label></span> <span><input
			id="desiredEngagementWay_12" name="desired_engagement_way"
			type="checkbox" value="其他"><label
			for="desiredEngagementWay_12">其他</label></span>
	</p>
	<hr>
	<div style="width: 300px; height: 30px; margin: 0 auto;">
		<button goWhere="nextDetailInfos" class="submit btn btn-warning">继续编辑详细信息</button>
		<button goWhere="lookingLover" class="submit btn btn-success">先睹为快</button>
	</div>
</body>
</html>