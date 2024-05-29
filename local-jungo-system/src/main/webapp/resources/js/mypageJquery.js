$(document).ready(function() {
	$("#buy tbody tr td #buyDelete").click(function() {
		var current = Number($(this).parent().attr('id'));
		$(location).attr("href", "/jungonara/buydelete?buyid="+current);
	})
	$("#sb tbody tr td #sbDelete").click(function() {
		var current = Number($(this).parent().attr('id'));
		$(location).attr("href", "/jungonara/sbdelete?sbid="+current);
	})
	$("#buy tbody tr td #buyStatus").click(function() {
		var current = Number($(this).parent().attr('id'));
		$(location).attr("href", "/jungonara/buystatus?buyid="+current);
	})
	$("#sb tbody tr td #sbStatus").click(function() {
		var current = Number($(this).parent().attr('id'));
		$(location).attr("href", "/jungonara/sbstatus?sbid="+current);
	})
})