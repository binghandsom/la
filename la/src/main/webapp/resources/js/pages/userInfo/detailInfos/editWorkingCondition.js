$(function() {
	var x = $("div.detailMenu>a[href='" + ctx
			+ "/detailInfos/editWorkingCondition']", window.parent.document);
	beActive(x);

	$("#jobKind").selectmenu({

	});

	$("#companyKind").selectmenu({

	});
	$("#busyDegree").selectmenu({

	});

	$("button.submit").click(
			function() {
				var goWhere = $(this).attr("goWhere");

				var jobKind = $("#jobKind option:selected").val();
				var companyKind = $("#companyKind option:selected").val();
				var busyDegree = $("#busyDegree option:selected").val();
				var selfDescription = $("#selfDescription").val();
				var data = JSON.stringify({
					jobKind : jobKind,
					companyKind : companyKind,
					busyDegree : busyDegree,
					selfDescription : selfDescription
				});
				$.ajax({
					url : ctx + "/detailInfos/doEditWorkingCondition",
					data : data,
					type : 'POST',
					async : false,
					contentType : "application/json;charset=utf-8", //
					success : function(result) {
						if (result.success) {
							window.location.href = ctx
									+ "/detailInfos/editLoveAttitude";
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
