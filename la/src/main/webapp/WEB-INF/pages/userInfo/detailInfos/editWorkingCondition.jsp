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
	src="${ctx }/resources/js/pages/userInfo/detailInfos/editWorkingCondition.js"
	type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx }/resources/css/pages/userInfo/detailInfos/editWorkingCondition.css" />




</head>
<body>

	<hr>
	<fieldset>
		<div>
			<label class="section" for="jobKind">职业类别</label> <select
				name="jobKind" id="jobKind">
				<option value="" selected="selected">请选择</option>
				<option value="销售">销售</option>
				<option value="客户服务">客户服务</option>
				<option value="计算机/互联网">计算机/互联网</option>
				<option value="通信/电子">通信/电子</option>
				<option value="生产/制造">生产/制造</option>
				<option value="物流/仓储">物流/仓储</option>
				<option value="商贸/采购">商贸/采购</option>
				<option value="人事/行政">人事/行政</option>
				<option value="高级管理">高级管理</option>
				<option value="广告/市场">广告/市场</option>
				<option value="传媒/艺术">传媒/艺术</option>
				<option value="生物/制药">生物/制药</option>
				<option value="医疗/护理">医疗/护理</option>
				<option value="金融/银行/保险">金融/银行/保险</option>
				<option value="建筑/房地产">建筑/房地产</option>
				<option value="咨询/顾问">咨询/顾问</option>
				<option value="法律">法律</option>
				<option value="财会/审计">财会/审计</option>
				<option value="教育/科研">教育/科研</option>
				<option value="服务业">服务业</option>
				<option value="交通运输">交通运输</option>
				<option value="政府机构">政府机构</option>
				<option value="军人/警察">军人/警察</option>
				<option value="农林牧渔">农林牧渔</option>
				<option value="自由职业">自由职业</option>
				<option value="在校学生">在校学生</option>
				<option value="待业">待业</option>
				<option value="其他行业">其他行业</option>
			</select>
		</div>
		<div>
			<label class="section" for="companyKind">公司类别</label> <select
				name="companyKind" id="companyKind">
				<option value="" selected="selected">请选择</option>
				<option value="政府机关">政府机关</option>
				<option value="事业单位">事业单位</option>
				<option value="外资企业">外资企业</option>
				<option value="合资企业">合资企业</option>
				<option value="国营企业">国营企业</option>
				<option value="私营企业">私营企业</option>
				<option value="自有公司">自有公司</option>
				<option value="">其他</option>
			</select>
		</div>
		<div>
			<label class="section" for="busyDegree">工作繁忙度</label> <select
				name="busyDegree" id="busyDegree">
				<option value="" selected="selected">请选择</option>
				<option value="有双休">有双休</option>
				<option value="工作忙碌">工作忙碌</option>
				<option value="工作清闲">工作清闲</option>
				<option value="自由工作时间">自由工作时间</option>
				<option value="经常出差">经常出差</option>
			</select>
		</div>
	</fieldset>
	<hr>
	<div>
		<label class="section" for="selfDescription" style="display: inline;">描述一下自己的工作特点</label>
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