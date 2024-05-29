<%@page import="com.gntech.dto.orderDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%
	List<orderDTO> list = (List)request.getAttribute("list");
	List<orderDTO> cancellist = (List)request.getAttribute("cancellist");
	int count = (int)request.getAttribute("count");
	int cancelcount = (int)request.getAttribute("cancelcount");
%>
<body>
	<div class="container">
		<div id="basic_table">
			<div class="container-body">
				<div id="buyDiv">
					<h2>완료내역</h2>
					<table id="result" class="table table-striped table-hover">
						<thead>
							<tr>
								<td class="col-md-1">번호</td>
								<td class="col-md-2">주문번호</td>
								<td class="col-md-2">판매자</td>
								<td class="col-md-3">품목명</td>
								<td class="col-md-1">가격</td>
								<td class="col-md-2">상태</td>
							</tr>
						</thead>
						<tbody>
						<%if (list.isEmpty()) { %>
							<tr>
								<td class="col-md-1"></td>
								<td class="col-md-2"></td>
								<td class="col-md-2"></td>
								<td class="col-md-3"><strong>작성된 글이 존재하지 않습니다.</strong></td>
								<td class="col-md-1"></td>
								<td class="col-md-2"></td>
							</tr>
						<% } else {
							for(orderDTO dto : list) {  %>
							<tr style="cursor: pointer;" class="data">
								<td id="<%=dto.getId() %>" class="col-md-1"><%=dto.getId() %></td>
								<td id="<%=dto.getId() %>" class="col-md-2"><%=dto.getOrder_num() %></td>
								<td id="<%=dto.getId() %>" class="col-md-2"><%=dto.getOrder_name() %></td>
								<td id="<%=dto.getId() %>" class="col-md-3"><%=dto.getPro_name() %></td>
								<td id="<%=dto.getId() %>" class="col-md-1"><%=dto.getPrice() %></td>
								<td id="<%=dto.getId() %>" class="col-md-2"><%=dto.getStatus() %></td>
							</tr>
							<% }
								}%>
						</tbody>
					</table>
					<div>
						<nav style="display: inline">
							<ul class="pagination">
								<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
								<% for(int i = 1; i<=Math.ceil(count/5.0);i++) { %>
								<li><a href="/localjungo/result?pageNum=<%=i %>&CancelpageNum=1"><%=i %></a></li>
								<%} %>
								<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
							</ul>
						</nav>
					</div>
				</div>
				<div id="sbDiv">
					<h2>취소내역</h2>
					<table id="result" class="table table-striped table-hover">
						<thead>
							<tr>
								<td class="col-md-1">번호</td>
								<td class="col-md-2">주문번호</td>
								<td class="col-md-2">판매자</td>
								<td class="col-md-3">품목명</td>
								<td class="col-md-1">가격</td>
								<td class="col-md-2">상태</td>
							</tr>
						</thead>
						<tbody>
							<%if (list.isEmpty()) { %>
								<tr>
									<td class="col-md-1"></td>
									<td class="col-md-2"></td>
									<td class="col-md-2"></td>
									<td class="col-md-3"><strong>작성된 글이 존재하지 않습니다.</strong></td>
									<td class="col-md-1"></td>
									<td class="col-md-2"></td>
								</tr>
							<% } else { 
										for(orderDTO dto : cancellist) { %>
							<tr style="cursor: pointer;" class="data">
								<td id="<%=dto.getId() %>" class="col-md-1"><%=dto.getId() %></td>
								<td id="<%=dto.getId() %>" class="col-md-2"><%=dto.getOrder_num() %></td>
								<td id="<%=dto.getId() %>" class="col-md-2"><%=dto.getOrder_name() %></td>
								<td id="<%=dto.getId() %>" class="col-md-3"><%=dto.getPro_name() %></td>
								<td id="<%=dto.getId() %>" class="col-md-1"><%=dto.getPrice() %></td>
								<td id="<%=dto.getId() %>" class="col-md-2"><%=dto.getStatus() %></td>
							</tr>
							<% }
								}%>
						</tbody>
					</table>
					<div>
						<nav style="display: inline">
							<ul class="pagination">
								<li><a href="#" aria-label="Previous"><span
										aria-hidden="true">&laquo;</span></a></li>
								<% for(int i = 1; i<=Math.ceil(count/5.0);i++) { %>
								<li><a href="/localjungo/result?pageNum=1&CancelpageNum=<%=i%>"><%=i %></a></li>
								<%} %>
								<li><a href="#" aria-label="Next"><span
										aria-hidden="true">&raquo;</span></a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<!-- 커스텀 Jquery 파일 선언 -->
<script src="resources/js/resultJquery.js?ver=13"></script>
<script src="resources/js/bootstrap.min.js"></script>
</html>