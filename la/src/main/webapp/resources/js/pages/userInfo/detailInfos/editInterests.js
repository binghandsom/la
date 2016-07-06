/**
 * 
 */
$(function() {
	var x = $("div.detailMenu>a[href='" + ctx + "/detailInfos/editInterests']",
			window.parent.document);
	beActive(x);
	var icons = {
		header : "ui-icon-circle-arrow-e",
		activeHeader : "ui-icon-circle-arrow-s"
	};
	$("#accordion").accordion({
		icons : icons
	});
	var fondActivities = "";
	var fondSports = "";
	var fondMusics = "";
	var fondFilms = "";
	var fondFoods = "";
	var fondPlaces = "";
	var fondPets = "";
	$("button.submit").click(
			function() {
				var fond_act = $("input[name='fondActivities']");
				for (var i = 0; i < fond_act.length; i++) {
					if (fond_act[i].checked) {
						fondActivities += fond_act[i].value + ",";
					}
				}
				var fond_spo = $("input[name='fondSports']");
				for (var i = 0; i < fond_spo.length; i++) {
					if (fond_spo[i].checked) {
						fondSports += fond_spo[i].value + ",";
					}
				}
				var fond_mus = $("input[name='fondMusics']");
				for (var i = 0; i < fond_mus.length; i++) {
					if (fond_mus[i].checked) {
						fondMusics += fond_mus[i].value + ",";
					}
				}
				var fond_fil = $("input[name='fondFilms']");
				for (var i = 0; i < fond_fil.length; i++) {
					if (fond_fil[i].checked) {
						fondFilms += fond_fil[i].value + ",";
					}
				}
				var fond_foo = $("input[name='fondFoods']");
				for (var i = 0; i < fond_foo.length; i++) {
					if (fond_foo[i].checked) {
						fondFoods += fond_foo[i].value + ",";
					}
				}
				var fond_pla = $("input[name='fondPlaces']");
				for (var i = 0; i < fond_pla.length; i++) {
					if (fond_pla[i].checked) {
						fondPlaces += fond_pla[i].value + ",";
					}
				}
				var fond_pet = $("input[name='fondPets']");
				for (var i = 0; i < fond_pet.length; i++) {
					if (fond_pet[i].checked) {
						fondPets += fond_pet[i].value + ",";
					}
				}

				var goWhere = $(this).attr("goWhere");
				// alert(goWhere);
				var data = JSON.stringify({
					fondActivities : fondActivities,
					fondSports : fondSports,
					fondMusics : fondMusics,
					fondFilms : fondFilms,
					fondFoods : fondFoods,
					fondPlaces : fondPlaces,
					fondPets : fondPets
				});
				alert(data);
				$.ajax({
					url : ctx + "/detailInfos/doEditInterests",
					data : data,
					type : 'POST',
					async : false,
					contentType : "application/json;charset=utf-8", //
					success : function(result) {
						if (result.success) {
							window.location.href = ctx
									+ "/detailInfos/editLivingCondition";
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
