<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.gntech.dto.orderDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	orderDTO dto = (orderDTO) request.getAttribute("select");
	/* int count = (int) request.getAttribute("buycount"); */
	Date date = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	String strDate = format.format(date);
%>
<div class="container">
	<div id="basic_table">
		<div class="container-body">
			<h2 id="<%=dto.getId()%>">신청조회</h2><br><br>
			<!------------------------- 상단 버튼 (수락 / 거절) ------------------------------>
			<div class="pull-right">
				<form class="form-inline" action="checkY" style="margin-bottom : 5px;">
					<div class="form-group">
						<button type="submit" class="btn btn-success">금액 제안</button>
						<input type="hidden" name="price" value="<%=dto.getPrice() %>">
						<input type="hidden" name="id" value="<%= dto.getId()%>">
						<input type="text" class="form-control" name="return_price" value="<%=dto.getPrice()%>">
					</div>				
				</form>
				<form action="checkN">
					<div class="form-group">
						<input type="hidden" name="id" value="<%= dto.getId()%>">	
						<button type="submit" class="btn btn-danger">구매 취소</button>
					</div>				
				</form> 
			</div>
			<!------------------------------------------------------------------------------>
			<%-- <h3 id="<%=dto.getId()()%>"><%=dto.getBuy_title()%></h3> --%>
			<div id="contents">
				<p>
					<strong>작성일 : </strong><%=dto.getOrder_date()%></p>
				<p>
					<strong>주문번호 : </strong><%=dto.getOrder_num()%></p>
				<p>
					<strong>작성자 : </strong><%=dto.getOrder_name()%></p>
				<p>
					<strong>작성자 휴대폰 : </strong><%=dto.getOrder_phone()%></p>
				<p>
					<strong>물품명 : </strong><%=dto.getPro_name()%></p>
				<p>
					<strong>판매금액 : </strong><%=dto.getPrice()%></p>
				<br> <br>
				<p>
					<strong>물품 내용</strong>
				</p>
				<p class="lead"><%=dto.getPro_content()%></p>
				<br> <br>
				<div class="row">
					<div class="col-md-8">
						<img src="http://localhost:3000/img/<%=strDate %>/<%=dto.getOrder_num() %>.jpg" class="img-responsive img-rounded">
					</div>
				</div>
				<br> <br>
			</div>
		</div>
	</div>
</div>
</body>
<!-- 커스텀 Jquery 파일 선언 -->
<script src="resources/js/indexJquery.js?ver=12"></script>
<script src="resources/js/bootstrap.min.js"></script>
</html>