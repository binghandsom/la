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
	src="${ctx }/resources/js/pages/userInfo/detailInfos/editMatingPreference.js"
	type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx }/resources/css/pages/userInfo/detailInfos/editMatingPreference.css" />


</head>
<body>
	<h2>理想中的另一半应该满足的要求：</h2>
	<hr />
	<input type="hidden" name="minAge" value="18">
	<input type="hidden" name="maxAge" value="25">
	<input type="hidden" name="minSalary" value="3000">
	<input type="hidden" name="maxSalary" value="4000">
	<input type="hidden" name="minHeight">
	<input type="hidden" name="maxHeight">
	<fieldset>
		<div>
			<label class="section" for="marriage">婚姻状态</label> <select
				name="marriage" id="marriage">
				<option value="" selected="selected">不限</option>
				<option value="">未婚</option>
				<option value="">离异</option>
				<option value="">丧偶</option>
			</select>
		</div>
		<div>
			<label class="section" for="workingProvince">工作省份</label> <select
				name="workingProvince" id="workingProvince">
				<option value="" selected="selected">请选择</option>
				<option value="">省份1</option>
				<option value="">省份1</option>
				<option value="">省份1</option>
				<option value="">省份1</option>
				<option value="">省份1</option>
				<option value="">省份1</option>
			</select><label class="section" for="workingCity">工作城市</label> <select
				name="workingCity" id="workingCity">
				<option value="" selected="selected">请选择</option>
				<option value="">某城市</option>
				<option value="">某</option>
			</select>
		</div>
		<div>
			<label class="section" for="homeProvince">家乡省份</label> <select
				name="homeProvince" id="homeProvince">
				<option value="" selected="selected">请选择</option>
				<option value="">省份1</option>
				<option value="">省份1</option>
				<option value="">省份1</option>
				<option value="">省份1</option>
				<option value="">省份1</option>
				<option value="">省份1</option>
			</select><label class="section" for="homeCity">家乡城市</label> <select
				name="homeCity" id="homeCity">
				<option value="" selected="selected">请选择</option>
				<option value="">某城市</option>
				<option value="">某</option>
			</select>
		</div>
		<div>

			<label class="section" for="eduLevel">受教育水平</label> <select
				name="eduLevel" id="eduLevel">
				<option value="" selected="selected">请选择</option>
				<option value="">高中及以下</option>
				<option value="">中专</option>
				<option value="">大专</option>
				<option value="">大学本科</option>
				<option value="">硕士</option>
				<option value="">博士</option>
			</select><label class="section" for="haveChild">是否有孩子</label> <select
				name="haveChild" id="haveChild">
				<option value="" selected="selected">请选择</option>
				<option value="想要孩子">没有</option>
				<option value="不想要孩子">有</option>
				<option value="视情况而定">视情况而定</option>
			</select>
		</div>
		<label for="salary-range">月薪</label> <span id="salaryRangeShow">3000~4000</span>
		<div id="salary-range"></div>
		<label for="age-range">年龄</label> <span id="ageRangeShow">18岁~25岁</span>
		<div id="age-range"></div>
		<label for="height-range">身高</label> <span id="heightRangeShow">150cm~180cm</span>
		<div id="height-range"></div>

	</fieldset>
	<hr>
	<div style="width: 300px; height: 30px; margin: 0 auto;">
		<button goWhere="" class="submit btn btn-warning">继续编辑详细信息</button>
		<button goWhere="lookingLover" class="submit btn btn-success">先睹为快</button>

	</div>
</body>
</html>