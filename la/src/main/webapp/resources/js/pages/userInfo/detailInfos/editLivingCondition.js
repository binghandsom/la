/**
 * 
 */
$(function() {

	$("#drinking").selectmenu();

	$("#smoking").selectmenu();
	$("#houseAndCar").selectmenu();
	$("#cooking").selectmenu();
	$("#housework").selectmenu();
	$("#deposit").selectmenu();

	$("button.submit").click(
			function() {
				var goWhere = $(this).attr("goWhere");

				var smoking = $("#smoking option:selected").val();
				var drinking = $("#drinking option:selected").val();
				var cooking = $("#cooking option:selected").val();
				var housework = $("#housework option:selected").val();
				var deposit = $("#deposit option:selected").val();
				var houseAndCar = $("#houseAndCar option:selected").val();
				var mainConsumption = "";

				var consumptions = $("input[name='consume']");
				for (var i = 0; i < consumptions.length; i++) {
					if (consumptions[i].checked) {
						mainConsumption += consumptions[i].value + ",";
					}
				}

				var selfDescription = $("#selfDescription").val();
				var data = JSON.stringify({
					smoking : smoking,
					drinking : drinking,
					cooking : cooking,
					housework : housework,
					deposit : deposit,
					houseAndCar : houseAndCar,
					mainConsumption : mainConsumption,
					selfDescription : selfDescription
				});
				$.ajax({
					url : ctx + "/detailInfos/doEditLivingCondition",
					data : data,
					type : 'POST',
					async : false,
					contentType : "application/json;charset=utf-8", //
					success : function(result) {
						if (result.success) {
							window.location.href = ctx
									+ "/detailInfos/editWorkingCondition";
						} else {
							alert("发生了未知错误");
						}
					}
				});
			});

});