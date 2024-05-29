/**
 * 
 */
$(document).ready(function() {
	$("#notice tbody tr td").click(function() {
		var num = $(this).attr('id');
		$(location).attr("href", "/jungonara/noticelistinfo?num=" + num);
	})
	$("#back").click(function() {
		var current = Number($("h3").attr('id'))-1;
		$(location).attr("href", "/jungonara/noticelistinfo?num="+current);
	})
	$("#next").click(function() {
		var current = Number($("h3").attr('id'))+1;
		$(location).attr("href", "/jungonara/noticelistinfo?num="+current);
	})
	$("#backList").click(function() {
		$(location).attr("href", "/jungonara/noticelist?pageNum=1");
	})
})