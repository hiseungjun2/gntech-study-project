/**
 * 
 */
$(document).ready(function() {
	$("#sb tbody tr td").click(function() {
		var num = $(this).attr('id');
		$(location).attr("href", "/jungonara/sblistinfo?num="+num);
	})
	$("#back").click(function() {
		var current = Number($("h3").attr('id'))-1;
		$(location).attr("href", "/jungonara/sblistinfo?num="+current);
	})
	$("#next").click(function() {
		var current = Number($("h3").attr('id'))+1;
		$(location).attr("href", "/jungonara/sblistinfo?num="+current);
	})
	$("#backList").click(function() {
		history.go(-1);
	})
})