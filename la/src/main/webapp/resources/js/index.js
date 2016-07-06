$(function() {
	var speed = 600; //自定义滚动速度
	//回到顶部
	$("#toTop").click(function() {
		$("html,body").animate({
			"scrollTop": 0
		}, speed);
	});
	//回到底部
	var windowHeight = parseInt($("body").css("height")); //整个页面的高度
	$("#toBottom").click(function() {
		$("html,body").animate({
			"scrollTop": windowHeight
		}, speed);
	});
	var elm = $('.menuContainer');
	var startPos = $(elm).offset().top;
	$.event.add(window, "scroll", function() {
		var p = $(window).scrollTop();
		if (p - startPos < 250 && p - startPos > 0) {
			$(elm).css({
				"position": "fixed",
				"top": "0px",
				"width": "100%",
				"z-index": "4",
				"opacity": "1"
			});
			$(".topBar").removeAttr("class", "navbar-fixed-top");
		} else if (p - startPos > 150) {
			$(elm).css({
				"position": "fixed",
				"top": "0px",
				"width": "100%",
				"z-index": "4",
				"opacity": "0"

			});
		} else {
			$(elm).css({
				"position": "static",
				"top": "",
				"width": "",
				"z-index": "",
				"opacity": "1"
			});
		}
	});
	$(".menu>a").hover(function() {
		$(this).css("background-color", "#4f285f");
	});
	$(".menu>a").mouseleave(function() {
		$(this).css({
			"background-color": "#703987"
		});
		$(this).find("a").css({
			"color": "wheat"
		});
	});

	$("ul.searchObj>li>a").click(function() {
		//		alert(this.innerText);
		var text = this.innerText;
		$("span.searchObj").html(text);
	});
	$("div.headPic").hover(function() {
		$(this).find("img").css({
			"-webkit-transform": "scale(2.0, 2.0)",
			"-moz-transform": "scale(2.0, 2.0)",
			"-transform": "scale(2.0, 2.0)",
			"position": "relative",
			"z-index": "2"
		});
	}, function() {
		$(this).find("img").css({
			"-webkit-transform": "scale(1, 1)",
			"-moz-transform": "scale(1, 1)",
			"-transform": "scale(1, 1)",
			"position": "relative",
			"z-index": "1"
		});
	});

	$(".tdSelector>span").click(function() {
		$(this).siblings().removeClass("active");
		$(this).addClass("active");
		/*条件查找*/
	});

});