<%@page import="dto.sbDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>
<div class="container">
        <div id="basic_table">
            <div class="container-body">
                <h2>팝니다</h2><br>
				<%
					request.setCharacterEncoding("UTF-8");
					sbDto sbDto = (sbDto)request.getAttribute("sbselectlistinfo");
					int count = (int)request.getAttribute("sbselectcount");
				%>
				<% if (sbDto.getSb_id() == count) { 		// 요청받은 글 번호가 글 개수와 같다면 %>
				<div class="pull-right">
					<button type="button" id="back" class="btn btn-default">이전</button>
					<button type="button" id="backList" class="btn btn-default">목록</button>
				</div>
				<%} else if (sbDto.getSb_id() == 1) {		// 요청받은 글 번호가 1이라면 %>
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
				<h3 id="<%=sbDto.getSb_id() %>"><%= sbDto.getSb_title()%></h3>
				<p id="noticeDate" class="text-right">최종수정일 : <strong><%= sbDto.getSb_update()%></strong></p><br>
				<div id="contents">
					<p id="userId"><strong>작성자 : </strong><%=sbDto.getUser_id() %></p>
					<p id="sbType"><strong>카테고리 : </strong><%=sbDto.getSb_type() %></p>
					<p id="sbSubtype"><strong>세부카테고리 : </strong><%=sbDto.getSb_subtype() %></p>
					<p id="sbTrade"><strong>거래방법 : </strong><%=sbDto.getSb_trade() %></p>
					<p id="sbPrice"><strong>가격 : </strong><%=sbDto.getSb_price() %></p><br>
					<p><strong>글 내용</strong></p>
					<p id="buyContents"><%= sbDto.getSb_contents()%></p>
				</div>
				<div class="comment">
					<form action="./sbcommentinsert" method="post">
						<input type="hidden" value="<%=id %>" name="user_id">
						<input type="hidden" value="<%=sbDto.getSb_id()%>" name="sb_id">
						<input type="hidden" value="" name="info">
						<textarea class="form-control" rows="3" name="comment_content"></textarea><br>
						<div class="pull-right">
							<button type="submit" id="write" class="btn btn-primary">작성하기</button>
							<button type="reset" id="reset" class="btn btn-default">취소</button>
						</div>
					</form><br><br><br>
					<jsp:include page="sb_comment.jsp">
						<jsp:param value="<%=sbDto.getSb_id() %>" name="sb_id"/>
						<jsp:param value="<%=id %>" name="user_id"/>
					</jsp:include>
				</div>
            </div>
        </div>
    </div>
</body>
<script>
	$(document).ready(function() {
		$("#back").click(function() {
			var current = Number($("h3").attr('id'))-1;
			$(location).attr("href", "/jungonara/sbselectinfo?num="+current);
		})
		$("#next").click(function() {
			var current = Number($("h3").attr('id'))+1;
			$(location).attr("href", "/jungonara/sbselectinfo?num="+current);
		})
		$("#backList").click(function() {
			history.go(-1);
		})
	})
</script>
</html>