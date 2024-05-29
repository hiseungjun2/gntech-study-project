<%@page import="dto.buyDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>
	<div class="container">
        <div id="basic_table">
            <div class="container-body">
                <h2>삽니다</h2><br>
				<%
					request.setCharacterEncoding("UTF-8");
					buyDto buyDto = (buyDto)request.getAttribute("buylistinfo");
					int count = (int)request.getAttribute("buycount");
				%>
				<!------------------------- 상단 버튼 생성 부분 ------------------------------>
				<% if (buyDto.getBuy_id() == count) { // 요청받은 글 번호가 전체 글 갯수라면 %>		
				<div class="pull-right">
					<button type="button" id="back" class="btn btn-default">이전</button>
					<button type="button" id="backList" class="btn btn-default">목록</button>
				</div>
				<%} else if (buyDto.getBuy_id() == 1) { // 요청받은 글 번호가 1 이라면 %>
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
				<!------------------------------------------------------------------------------>
				<h3 id="<%=buyDto.getBuy_id() %>"><%= buyDto.getBuy_title()%></h3>
				<p id="noticeDate" class="text-right">최종수정일 : <strong><%= buyDto.getBuy_update()%></strong></p><br>
				<div id="contents">
					<p id="userId"><strong>작성자 : </strong><%=buyDto.getUser_id() %></p>
					<p id="buyType"><strong>카테고리 : </strong><%=buyDto.getBuy_type() %></p>
					<p id="buySubtype"><strong>세부카테고리 : </strong><%=buyDto.getBuy_subtype() %></p>
					<p id="buyTrade"><strong>거래방법 : </strong><%=buyDto.getBuy_trade() %></p>
					<p id="buyPrice"><strong>가격 : </strong><%=buyDto.getBuy_price() %></p><br>
					<p><strong>글 내용</strong></p>
					<p id="buyContents"><%= buyDto.getBuy_contents()%></p><br><br>
				</div>
				<div class="comment">
					<form action="./buycommentinsert" method="post">
						<input type="hidden" value="<%=id %>" name="user_id">
						<input type="hidden" value="<%=buyDto.getBuy_id()%>" name="buy_id">
						<input type="hidden" value="" name="info">
						<textarea class="form-control" rows="3" name="comment_content"></textarea><br>
						<div class="pull-right">
							<button type="submit" id="write" class="btn btn-primary">작성하기</button>
							<button type="reset" id="reset" class="btn btn-default">취소</button>
						</div>
					</form><br><br><br>
					<jsp:include page="buy_comment.jsp">
						<jsp:param value="<%=buyDto.getBuy_id() %>" name="buy_id"/>
						<jsp:param value="<%=id %>" name="user_id"/>
					</jsp:include>
				</div>
            </div>
        </div>
    </div>
</body>
<!-- 커스텀 Jquery 파일 선언 -->
<script src="js/buyJquery.js?ver=1"></script>
<script>
	
</script>
</html>