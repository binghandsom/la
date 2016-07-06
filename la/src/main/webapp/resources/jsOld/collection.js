function before1() {
	var count = $("#count").text();
	var againCount = parseInt(count) - 1;
	$("#count").text(againCount);
}
function after1() {
	var count = $("#count").text();
	var againCount = parseInt(count) + 1;
	$("#count").text(againCount);
}