/**
 * 
 */
$(function() {
	var x = $("div.detailMenu>a[href='" + ctx + "/detailInfos/editMatingPreference']",
			window.parent.document);
	beActive(x);
	$("#marriage").selectmenu({});
	$("#workingProvince").selectmenu({});

	$("#workingCity").selectmenu({});
	$("#homeProvince").selectmenu({});
	$("#homeCity").selectmenu({});
	$("#eduLevel").selectmenu({});
	$("#haveChild").selectmenu({});

	$("#salary-range").slider({
		range : true,
		min : 0,
		max : 20000,
		step : 500,
		values : [ 3000, 4000 ],
		slide : function(event, ui) {
			$("#salaryRangeShow").html(ui.values[0] + "~" + ui.values[1]);
			$("input[name='minSalary']").val(ui.values[0]);
			$("input[name='maxSalary']").val(ui.values[1]);
		}

	});
	$("#age-range").slider({
		range : true,
		min : 14,
		max : 60,
		step : 1,
		values : [ 18, 25 ],
		slide : function(event, ui) {
			$("#ageRangeShow").html(ui.values[0] + "岁~" + ui.values[1] + "岁");
			$("input[name='minAge']").val(ui.values[0]);
			$("input[name='maxAge']").val(ui.values[1]);
		}

	});
	$("#height-range").slider(
			{
				range : true,
				min : 140,
				max : 210,
				step : 1,
				values : [ 150, 180 ],
				slide : function(event, ui) {
					$("#heightRangeShow").html(
							ui.values[0] + "cm~" + ui.values[1] + "cm");
					$("input[name='minHeight']").val(ui.values[0]);
					$("input[name='maxHeight']").val(ui.values[1]);
				}
			});
	$("#houseAndCar").selectmenu({
		change : function(event, data) {
			alert(data.item.value);
		}
	});
	$("button.submit").click(function() {
		var goWhere = $(this).attr("goWhere");

		var marriage = $("#marriage option:selected").val();
		var workingProvince = $("#workingProvince option:selected").val();
		var workingCity = $("#workingCity option:selected").val();
		var homeProvince = $("#homeProvince option:selected").val();
		var homeCity = $("#homeCity option:selected").val();
		var eduLevel = $("#eduLevel option:selected").val();
		var haveChild = $("#haveChild option:selected").val();
		var minAge = $("input[name='minAge']").val();
		var maxAge = $("input[name='maxAge']").val();
		var minSalary = $("input[name='minSalary']").val();
		var maxSalary = $("input[name='maxSalary']").val();
		var minHeight = $("input[name='minHeight']").val();
		var maxHeight = $("input[name='maxHeight']").val();

		var data = JSON.stringify({
			marriage : marriage,
			workingProvince : workingProvince,
			workingCity : workingCity,
			homeProvince : homeProvince,
			eduLevel : eduLevel,
			homeCity : homeCity,
			haveChild : haveChild,
			minAge : minAge,
			maxAge : maxAge,
			minSalary : minSalary,
			maxSalary : maxSalary,
			minHeight : minHeight,
			maxHeight : maxHeight
		});
		$.ajax({
			url : ctx + "/detailInfos/doEditMatingPreference",
			data : data,
			type : 'POST',
			async : false,
			contentType : "application/json;charset=utf-8", //
			success : function(result) {
				if (result.success) {
					window.location.href = ctx + "/detailInfos/editPhotos";
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