/**
 * 
 */
$(function() {
	var x = $("div.detailMenu>a[href='" + ctx
			+ "/detailInfos/editLoveAttitude']", window.parent.document);
	beActive(x);
	$("#loveTimes").selectmenu({});

	$("#dislikedShengxiao").selectmenu({});
	$("#whenShouldMarry").selectmenu({});
	$("#wantChild").selectmenu({});
	$("#liveWithParents").selectmenu({});
	$("#liveWithParentsInLaw").selectmenu({});
	$("#whetherAcceptDistance").selectmenu({});

	$("button.submit")
			.click(
					function() {

						var loveTimes = $("#loveTimes option:selected").val();
						var dislikedShengxiao = $(
								"#dislikedShengxiao option:selected").val();
						var whenShouldMarry = $(
								"#whenShouldMarry option:selected").val();
						var wantChild = $("#wantChild").val();
						var liveWithParents = $("#liveWithParents").val();
						var liveWithParentsInLaw = $("#liveWithParentsInLaw")
								.val();
						var whetherAcceptDistance = $("#whetherAcceptDistance")
								.val();
						var desiredEngagementWays = "";

						var desired_engagement_way = $("input[name='desired_engagement_way']");
						for (var i = 0; i < desired_engagement_way.length; i++) {
							if (desired_engagement_way[i].checked) {
								desiredEngagementWays += desired_engagement_way[i].value
										+ ",";
							}
						}

						var goWhere = $(this).attr("goWhere");
						var data = JSON.stringify({
							loveTimes : loveTimes,
							dislikedShengxiao : dislikedShengxiao,
							whenShouldMarry : whenShouldMarry,
							wantChild : wantChild,
							liveWithParents : liveWithParents,
							liveWithParentsInLaw : liveWithParentsInLaw,
							whetherAcceptDistance : whetherAcceptDistance,
							desiredEngagementWays : desiredEngagementWays
						});
						$
								.ajax({
									url : ctx
											+ "/detailInfos/doEditLoveAttitude",
									data : data,
									type : 'POST',
									async : false,
									contentType : "application/json;charset=utf-8", //
									success : function(result) {
										if (result.success) {
											window.location.href = ctx
													+ "/detailInfos/editMatingPreference";
										} else {
											alert("发生了未知错误");
										}
									}
								});
					});
});
function beActive(obj) {
	$("div.detailMenu>a", window.parent.document).removeClass("active");
	obj.addClass("active");
}