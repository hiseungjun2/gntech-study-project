/**
 * 
 */
$(document).ready(function() {
	$("#index tbody .data td").click(function() {
		var num = $(this).attr('id');
		$(location).attr("href", "indexInfo?id="+num);
	})
	/*$("#checkY").click(function() {
		var num = $("h2").attr('id');
		$(location).attr("href", "checkY?id="+num);
	})
	$("#checkN").click(function() {
		var num = $("h2").attr('id');
		$(location).attr("href", "checkN?id="+num);
	})*/
})