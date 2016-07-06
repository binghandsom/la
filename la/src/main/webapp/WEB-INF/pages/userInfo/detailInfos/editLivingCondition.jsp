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
	src="${ctx }/resources/js/pages/userInfo/detailInfos/editLivingCondition.js"
	type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx }/resources/css/pages/userInfo/detailInfos/editLivingCondition.css" />
</head>
<body>
	<hr>
	<fieldset>
		<div>
			<label class="section" for="smoking">是否抽烟</label> <select
				name="smoking" id="smoking">
				<option value="" selected="selected">请选择</option>
				<option value="不吸烟">不吸烟</option>
				<option value="稍微抽一点儿">稍微抽一点儿</option>
				<option value="只在社交场合抽">只在社交场合抽</option>
				<option value="抽得很多">抽得很多</option>
			</select><label class="section" for="drinking">是否喝酒</label> <select
				name="drinking" id="drinking">
				<option value="" selected="selected">请选择</option>
				<option value="不喝酒">不喝酒</option>
				<option value="稍微喝一点">稍微喝一点</option>
				<option value="只在社交场合喝">只在社交场合喝</option>
				<option value="喝得很多">喝得很多</option>
			</select>
		</div>
		<div>

			<label class="section" for="houseAndCar">房子车子</label> <select
				name="houseAndCar" id="houseAndCar">
				<option value="" selected="selected">请选择</option>
				<option value="3">有房有车</option>
				<option value="2">有房</option>
				<option value="1">有车</option>
				<option value="0">都没有</option>
			</select><label class="section" for="cooking">厨艺</label> <select
				name="cooking" id="cooking">
				<option value="" selected="selected">请选择</option>
				<option value="2">色香味俱全</option>
				<option value="1">能做几样可口的小菜</option>
				<option value="0">有待提高</option>
			</select>
		</div>
		<div>
			<label class="section" for="housework">家务</label> <select
				name="housework" id="housework">
				<option value="" selected="selected">请选择</option>
				<option value="2">愿承担大部分家务</option>
				<option value="1">看各自忙闲，协商分担家务</option>
				<option value="0">希望对方承担大部分家务</option>
			</select><label class="section" for="deposit">存款</label> <select
				name="deposit" id="deposit">
				<option value="" selected="selected">请选择</option>
				<option value="1">3万以下</option>
				<option value="2">3-10万</option>
				<option value="3">10-50万</option>
				<option value="4">50万以上</option>
				<option value="5">保密</option>
			</select>
		</div>
	</fieldset>
	<hr>
	<div>
		<label class="section" for="consume">较大的消费</label>
		<p id="consume">
			<span><input id="consume_1" name="consume" type="checkbox"
				value="美食"><label for="consume_1">美食</label></span> <span><input
				id="consume_2" name="consume" type="checkbox" value="服饰"><label
				for="consume_2">服饰</label></span> <span><input id="consume_3"
				name="consume" type="checkbox" value="化妆"><label
				for="consume_3">化妆</label></span> <span><input id="consume_4"
				name="consume" type="checkbox" value="健身"><label
				for="consume_4">健身</label></span> <span><input id="consume_5"
				name="consume" type="checkbox" value="娱乐"><label
				for="consume_5">娱乐</label></span> <span><input id="consume_6"
				name="consume" type="checkbox" value="旅行"><label
				for="consume_6">旅行</label></span> <span><input id="consume_7"
				name="consume" type="checkbox" value="社交"><label
				for="consume_7">社交</label></span> <span><input id="consume_8"
				name="consume" type="checkbox" value="文化"><label
				for="consume_8">文化</label></span> <span><input id="consume_9"
				name="consume" type="checkbox" value="自我提升"><label
				for="consume_9">自我提升</label></span> <span><input id="consume_10"
				name="consume" type="checkbox" value="其他"><label
				for="consume_10">其他</label></span>
		</p>

	</div>
	<div>
		<label class="sectionLarge" for="selfDescription">描述一下您的性格，开朗、文静、乐观、友善、理智？</label>
		<textarea rows="6" cols="100" id="selfDescription"
			name="selfDescription"
			style="border-color: rgb(213, 213, 213); margin-left: 20px;"></textarea>
	</div>
	<hr>
	<div style="width: 300px; height: 30px; margin: 0 auto;">
		<button goWhere="nextDetailInfos" class="submit btn btn-warning">继续编辑详细信息</button>
		<button goWhere="lookingLover" class="submit btn btn-success">先睹为快</button>
	</div>


</body>
</html>