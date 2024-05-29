/**
 * 
 */
$(document).ready(function() {
	$("#buy tbody tr td").click(function() {
		var num = $(this).attr('id');
		$(location).attr("href", "/jungonara/buylistinfo?num=" + num);
	})
	$("#back").click(function() {
		var current = Number($("h3").attr('id'))-1;
		$(location).attr("href", "/jungonara/buylistinfo?num="+current);
	})
	$("#next").click(function() {
		var current = Number($("h3").attr('id'))+1;
		$(location).attr("href", "/jungonara/buylistinfo?num="+current);
	})
	$("#backList").click(function() {
		history.go(-1);
	})
})