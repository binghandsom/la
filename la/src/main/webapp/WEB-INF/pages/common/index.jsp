<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/inc/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录注册</title>

<script
	src="${ctx }/resources/js/common/jquery.bootstrap.newsbox.min.js"
	type="text/javascript" charset="utf-8"></script>

<!--基于bootstrup的响应式jQuery滚动新闻插件-->
<link href="${ctx }/resources/css/common/site.css" rel="stylesheet"
	type="text/css" />
<script src="${ctx }/resources/js/scrollJs.js" type="text/javascript"
	charset="utf-8"></script>
<script src="${ctx }/resources/js/index.js" type="text/javascript"
	charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx }/resources/css/index.css" />
</head>

<body>
	<nav class="navbar navbar-default topBar navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><img
				src="${ctx}/resources/img/97bird.png" /></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">链接1 <span class="sr-only">(current)</span></a></li>
				<li><a href="#">链接2</a></li>
				<li class="dropdown "><a href="#" class="dropdown-toggle "
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><span class="searchObj">查找对象 </span><span
						class="caret"></span></a>
					<ul class="dropdown-menu searchObj">
						<li><a href="#">查找对象1</a></li>
						<li><a href="#">查找对象2</a></li>
						<li><a href="#">查找对象3</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">查找对象4</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">查找对象5</a></li>
					</ul></li>
			</ul>
			<form class="navbar-form navbar-left" role="search">

				<div class="form-group">
					<input type="text" class="form-control" placeholder="查找">
				</div>
				<button type="submit" class="btn btn-default">搜一下</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">我的资料</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">我的消息 <span class="badge">5条</span><span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">消息1</a></li>
						<li><a href="#">消息2<span class="badge">2条</span></a></li>
						<li><a href="#">消息3</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">消息4<span class="badge">3条</span></a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<div class="container menuContainer">

		<div class="nav-bar navbar-inverse">
			<ul class="nav nav-pills nav-justified">
				<li class="menu"><a style="color: white;" href="#">菜单一</a></li>
				<li class="menu"><a style="color: white;" href="#">菜单二</a></li>
				<li class="menu"><a style="color: white;" href="#">菜单三</a></li>
				<li class="menu"><a style="color: white;" href="#">菜单四</a></li>
			</ul>
		</div>

	</div>
	<div class="container content">
		${userMainInfos }
		<div class="row">
			<div class="col-lg-9 col-md-9 col-sm-9">
				<c:forEach var="userMainInfo" items="${userMainInfos}"
					varStatus="status" step="1">
					<div class="col-sm-6 col-md-6">
						<div class="row personCell" style="margin-top: 10px;">
							<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5 headPic">
								<a href="#"> <img style="width: 140px; height: 170px;"
									src="${ ctx}/userMainInfo/loadPhoto?picName=${userMainInfo.headPic }&picType=headPicture"
									alt="...">
								</a>
							</div>

							<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
								<div class="mainInfo"
									style="height: 150px; width: 100%; padding-right: 5px;">
									<h3>
										昵称：<b>${userMainInfo.nickName}</b>
									</h3>
									<div class="selfInfo">18岁，${userMainInfo.height }cm，${userMainInfo.constellation}，月收入￥${userMainInfo.salary }
										&nbsp;${userMainInfo.declaration }</div>
									<div class="lookingFor">
										正在寻找：芜湖 19-22岁 169-178cm 2000-5000月收入 未婚 的男生
										<div class="sayHello">
											<a href="#"></a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				<div class="col-sm-6 col-md-6">
					<div class="row personCell" style="margin-top: 10px;">
						<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5 headPic">
							<a href="#"> <img style="width: 140px; height: 170px;"
								src="${ctx}/resources/img/touxiangDemo.jpg" alt="...">
							</a>
						</div>

						<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
							<div class="mainInfo"
								style="height: 150px; width: 100%; padding-right: 5px;">
								<h3>
									昵称：<b>可爱的狐狸</b>
								</h3>
								<div class="selfInfo">18岁，安徽芜湖，162cm，2000-5000</div>
								<div class="lookingFor">
									正在寻找：芜湖 19-22岁 169-178cm 2000-5000月收入 未婚 的男生
									<div class="sayHello">
										<a href="#"></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				

				<!--分页-->
				<nav>
				<ul class="pagination pagination-sm" style="z-index: 0;">
					<li class="disabled"><a href="#" aria-label="Previous"><span
							aria-hidden="true">&laquo;</span></a></li>
					<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
					<li class=""><a href="#">2<span class="sr-only"></span></a></li>
					<li class=""><a href="#">3 <span class="sr-only"></span></a></li>
					<li class=""><a href="#">3 <span class="sr-only"></span></a></li>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
				</nav>
			</div>
			<!--搜索-->
			<div class="col-lg-3 col-md-3 col-sm-3 rolling" style="">
				<div id="" class="col-lg-12 col-md-12 col-sm-12"
					style="margin-top: 10px; height: 580px; position: relative;">
					<div class="" style="width: 230px;">

						<table border="10px" cellspacing="5px" cellpadding="0px"
							bordercolor="whitesmoke"
							style="text-align: center; background: #a393e2; width: 100%; color: whitesmoke; font-weight: 900;">
							<tr>
								<td>星座</td>
								<td style="height: 50px;">
									<div class="tdSelector xingzuo"
										style="width: 100%; position: relative; height: 100%; display: block; vertical-align: bottom; text-align: center; overflow-y: hidden; background: #a67724; border-left: dashed 1px #567784;">
										<span>白羊</span><span>金牛</span><span>水平</span><span>摩羯</span><span>天蝎</span><span>巨蟹</span><span>双鱼</span><span>射手</span><span>处女</span><span>双子</span><span>天秤</span><span>狮子</span><span>不限</span>
									</div>
								</td>
							</tr>
							<tr>
								<td>身高</td>
								<td>
									<div class="tdSelector xingzuo"
										style="width: 100%; position: relative; height: 100%; display: block; vertical-align: bottom; text-align: center; overflow-y: hidden; background: #a67724; border-left: dashed 1px #567784;">
										<span>140-145</span><span>145-150</span><span>150-155</span><span>155-160</span><span>160-165</span><span>165-170</span><span>170-175</span><span>175-180</span><span>180-185</span><span>185-190</span><span>190-？</span><span>不限</span>
									</div>
								</td>
							</tr>
							<tr>
								<td>年龄</td>
								<td>
									<div class="tdSelector xingzuo"
										style="width: 100%; position: relative; height: 100%; display: block; vertical-align: bottom; text-align: center; overflow-y: hidden; background: #a67724; border-left: dashed 1px #567784;">
										<span>小于20</span><span>20-23</span><span>23-26</span><span>26-29</span><span>29-32</span><span>32-40</span><span>40-50</span><span>50-60</span><span>大于60</span><span>不限</span>
									</div>
								</td>
							</tr>
							<tr>
								<td>月薪</td>
								<td>
									<div class="tdSelector xingzuo"
										style="width: 100%; position: relative; height: 100%; display: block; vertical-align: bottom; text-align: center; overflow-y: hidden; background: #a67724; border-left: dashed 1px #567784;">
										<span>小于2000</span><span>2000-3000</span><span>3000-4000</span><span>4000-5000</span><span>5000-6000</span><span>6000-7000</span><span>7000以上</span><span>不限</span>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div class="matchCondition"></div>

				</div>
			</div>
		</div>
	</div>
	<div class="row container-fluid col-lg-12 col-md-12 col-sm-12">
		<div class="media col-lg-8 col-md-8 col-sm-8">
			<div class="col-lg-6 col-md-6 col-sm-6 ">
				<div class="media-left ">
					<a href="#"> <img class="media-object"
						src="${ctx}/resources/img/yongbao.jpg"
						style="width: 270px; height: 290px; padding: 10px; border: 5px solid #dedede; -moz-border-radius: 15px; -webkit-border-radius: 15px; border-radius: 15px;"
						alt="...">
					</a>
				</div>
				<div class="media-body">
					<h4 class="media-heading">我们找到了真爱</h4>
					仅仅是成为会员的第三天,CSS圆角效果
					-webkit-border-radius(CSS3中border-radius隐藏的威力)...-moz-border-radius:moz这个属性
					主要是专门支持Mozilla Firefox 火狐浏览器的CSS...
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 ">
				<div class="media-left ">
					<a href="#"> <img class="media-object"
						src="${ctx}/resources/img/yongbao.jpg"
						style="width: 270px; height: 290px; padding: 10px; border: 5px solid #dedede; -moz-border-radius: 15px; -webkit-border-radius: 15px; border-radius: 15px;"
						alt="...">
					</a>
				</div>
				<div class="media-body">
					<h4 class="media-heading">我们找到了真爱</h4>
					仅仅是成为会员的第三天,CSS圆角效果
					-webkit-border-radius(CSS3中border-radius隐藏的威力)...-moz-border-radius:moz这个属性
					主要是专门支持Mozilla Firefox 火狐浏览器的CSS...
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 ">
				<div class="media-left ">
					<a href="#"> <img class="media-object"
						src="${ctx}/resources/img/yongbao.jpg"
						style="width: 270px; height: 290px; padding: 10px; border: 5px solid #dedede; -moz-border-radius: 15px; -webkit-border-radius: 15px; border-radius: 15px;"
						alt="...">
					</a>
				</div>
				<div class="media-body">
					<h4 class="media-heading">我们找到了真爱</h4>
					仅仅是成为会员的第三天,CSS圆角效果
					-webkit-border-radius(CSS3中border-radius隐藏的威力)...-moz-border-radius:moz这个属性
					主要是专门支持Mozilla Firefox 火狐浏览器的CSS...
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 ">
				<div class="media-left ">
					<a href="#"> <img class="media-object"
						src="${ctx}/resources/img/yongbao.jpg"
						style="width: 270px; height: 290px; padding: 10px; border: 5px solid #dedede; -moz-border-radius: 15px; -webkit-border-radius: 15px; border-radius: 15px;"
						alt="...">
					</a>
				</div>
				<div class="media-body">
					<h4 class="media-heading">我们找到了真爱</h4>
					仅仅是成为会员的第三天,CSS圆角效果
					-webkit-border-radius(CSS3中border-radius隐藏的威力)...-moz-border-radius:moz这个属性
					主要是专门支持Mozilla Firefox 火狐浏览器的CSS...
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 ">
				<div class="media-left ">
					<a href="#"> <img class="media-object"
						src="${ctx}/resources/img/yongbao.jpg"
						style="width: 270px; height: 290px; padding: 10px; border: 5px solid #dedede; -moz-border-radius: 15px; -webkit-border-radius: 15px; border-radius: 15px;"
						alt="...">
					</a>
				</div>
				<div class="media-body">
					<h4 class="media-heading">我们找到了真爱</h4>
					仅仅是成为会员的第三天,CSS圆角效果
					-webkit-border-radius(CSS3中border-radius隐藏的威力)...-moz-border-radius:moz这个属性
					主要是专门支持Mozilla Firefox 火狐浏览器的CSS...
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 ">
				<div class="media-left ">
					<a href="#"> <img class="media-object"
						src="${ctx}/resources/img/yongbao.jpg"
						style="width: 270px; height: 290px; padding: 10px; border: 5px solid #dedede; -moz-border-radius: 15px; -webkit-border-radius: 15px; border-radius: 15px;"
						alt="...">
					</a>
				</div>
				<div class="media-body">
					<h4 class="media-heading">我们找到了真爱</h4>
					仅仅是成为会员的第三天,CSS圆角效果
					-webkit-border-radius(CSS3中border-radius隐藏的威力)...-moz-border-radius:moz这个属性
					主要是专门支持Mozilla Firefox 火狐浏览器的CSS...
				</div>
			</div>
		</div>
		<div class="htmleaf-container col-lg-4 col-md-4 col-sm-4">
			<div class="container mp30">
				<div class="col-md-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-list-alt"></span><b>今日推荐</b>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-xs-12">
									<ul class="demo1">
										<li class="news-item">
											<table cellpadding="4">
												<tr>
													<td><img src="${ctx}/resources/images/1.png"
														width="60" class="img-circle" /></td>
													<td>Lorem ipsum dolor sit amet, consectetur adipiscing
														elit. Nullam in venenatis enim... <a href="#">Read
															more...</a>
													</td>
												</tr>
											</table>
										</li>
										<li class="news-item">
											<table cellpadding="4">
												<tr>
													<td><img src="${ctx}/resources/images/2.png"
														width="60" class="img-circle" /></td>
													<td>Lorem ipsum dolor sit amet, consectetur adipiscing
														elit. Nullam in venenatis enim... <a href="#">Read
															more...</a>
													</td>
												</tr>
											</table>
										</li>
										<li class="news-item">
											<table cellpadding="4">
												<tr>
													<td><img src="${ctx}/resources/images/3.png"
														width="60" class="img-circle" /></td>
													<td>Lorem ipsum dolor sit amet, consectetur adipiscing
														elit. Nullam in venenatis enim... <a href="#">Read
															more...</a>
													</td>
												</tr>
											</table>
										</li>
										<li class="news-item">
											<table cellpadding="4">
												<tr>
													<td><img src="${ctx}/resources/images/4.png"
														width="60" class="img-circle" /></td>
													<td>Lorem ipsum dolor sit amet, consectetur adipiscing
														elit. Nullam in venenatis enim... <a href="#">Read
															more...</a>
													</td>
												</tr>
											</table>
										</li>
										<li class="news-item">
											<table cellpadding="4">
												<tr>
													<td><img src="${ctx}/resources/images/5.png"
														width="60" class="img-circle" /></td>
													<td>Lorem ipsum dolor sit amet, consectetur adipiscing
														elit. Nullam in venenatis enim... <a href="#">Read
															more...</a>
													</td>
												</tr>
											</table>
										</li>
										<li class="news-item">
											<table cellpadding="4">
												<tr>
													<td><img src="${ctx}/resources/images/6.png"
														width="60" class="img-circle" /></td>
													<td>Lorem ipsum dolor sit amet, consectetur adipiscing
														elit. Nullam in venenatis enim... <a href="#">Read
															more...</a>
													</td>
												</tr>
											</table>
										</li>
										<li class="news-item">
											<table cellpadding="4">
												<tr>
													<td><img src="${ctx}/resources/images/7.png"
														width="60" class="img-circle" /></td>
													<td>Lorem ipsum dolor sit amet, consectetur adipiscing
														elit. Nullam in venenatis enim... <a href="#">Read
															more...</a>
													</td>
												</tr>
											</table>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="panel-footer">留白也是一种美</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="arrowScroll">
		<div id="toTop" class="scrollItem">
			<img src="${ctx}/resources/img/arrow_96px - up.png"
				style="width: 100%; height: 100%;" />
		</div>
		<div id="toBottom" class="scrollItem">
			<img src="${ctx}/resources/img/arrow_96px - down.png"
				style="width: 100%; height: 100%;" />
		</div>
	</div>
</body>

</html>