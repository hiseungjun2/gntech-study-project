<%@page import="dto.noticeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>
	<div class="container">
        <div id="basic_table">
            <div class="container-body">
                <h2>공지사항</h2><br>
					<%
						request.setCharacterEncoding("UTF-8");
						noticeDto noDto = (noticeDto)request.getAttribute("noticelistinfo");
						int count = (int)request.getAttribute("noticecount");
					%>
					<% if (noDto.getNotice_id() == count) { 	// 요청받은 글 번호가 글 개수와 같다면 %>		
					<div class="pull-right">
						<button type="button" id="back" class="btn btn-default">이전</button>
						<button type="button" id="backList" class="btn btn-default">목록</button>
					</div>
					<%} else if (noDto.getNotice_id() == 1) { // 요청받은 글 번호가 1이라면 %>
					<div class="pull-right">
						<button type="button" id="next" class="btn btn-default">다음</button>
						<button type="button" id="backList" class="btn btn-default">목록</button>
					</div>
					<%} else {%>
					<div class="pull-right">
						<button type="button" id="back" class="btn btn-default">이전</button>
						<button type="button" id="next" class="btn btn-default">다음</button>
						<button type="button" id="backList" class="btn btn-default">목록</button>
					</div>
					<%} %>
					<h3 id="<%=noDto.getNotice_id() %>"><%= noDto.getNotice_title()%></h3>
					<p id="noticeDate" class="text-right">작성일 : <strong><%= noDto.getNotice_date()%></strong></p><br>
					<p id="noticeContents"><%= noDto.getNotice_contents()%></p>
            </div>
        </div>
    </div>
</body>
<!-- 커스텀 Jquery 파일 선언 -->
<script src="js/homeJquery.js?ver=1"></script>
</html>