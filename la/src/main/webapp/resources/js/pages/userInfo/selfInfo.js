$(function() {
	var photoNum = $("#photoListPreview>a").length;
	var right = 0;
	var stepLength = 50;
	var MAX_MOVE = stepLength * (photoNum - 5);
	var currentSelectIndex = 0; // 从0开始算
	var currentSelectImg = $(".activeImg")[0];
	$(".preOrNext").click(function() {
		nextOrPre($(this));
	});
	$("#photoListPreview>a").click(function() {
		currentSelectIndex = $(this).index();
		// alert(currentSelectIndex);
		right = figureoutRight(currentSelectIndex);

		activeImg(currentSelectIndex, right);

	});

	function figureoutRight(currentSelectIndex) {
		if (currentSelectIndex >= 3 && (currentSelectIndex <= (photoNum - 4))) {
			return (currentSelectIndex - 2) * stepLength;
		} else if (currentSelectIndex < 3) {
			return 0;
		} else if (currentSelectIndex > (photoNum - 4)) {
			return (photoNum - 5) * stepLength;
		}
	}

	function nextOrPre(who) {
		if (who.attr("id") == "preImg") {
			// 上一张
			if (right <= 0 && currentSelectIndex <= 0) {

			} else {
				if (currentSelectIndex > 2
						&& currentSelectIndex < (photoNum - 2)) {
					right -= stepLength;
				}
				--currentSelectIndex;
				activeImg(currentSelectIndex, right);
			}

		} else {
			// 下一张
			if (right >= MAX_MOVE && currentSelectIndex >= (photoNum - 1)) {

			} else {
				if (currentSelectIndex >= 2
						&& currentSelectIndex <= (photoNum - 4)) {
					right += stepLength;
				}
				++currentSelectIndex;
				activeImg(currentSelectIndex, right);
			}
		}
	}
});

function activeImg(currentSelectIndex, right) {
	var itemGoingActive = $("#photoListPreview>a:eq(" + currentSelectIndex
			+ ")");
	$("#photoListPreview>a").attr("class", "");
	itemGoingActive.addClass("activeImg");
	$("#photoCurrentPreview").attr("src", $(".activeImg>img").attr("src"));
	$("#photoListPreview").css({
		"right" : right + "px"
	});

}