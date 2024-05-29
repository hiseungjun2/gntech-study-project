<%@page import="com.gntech.dto.orderDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%
	List<orderDTO> list = (List<orderDTO>) request.getAttribute("list");
	int count = (int)request.getAttribute("count");
%>
<div class="container">
	<div id="basic_table">
		<div class="container-body">
			<h2>검토내역</h2>
			<!----------------------------------------------------테이블 생성----------------------------------------------->
			<div>
				<table id="check" class="table table-striped table-hover">
					<thead>
						<tr>
							<td class="col-md-1">번호</td>
							<td class="col-md-2">주문번호</td>
							<td class="col-md-2">물품명</td>
							<td class="col-md-1">진행상태</td>
							<td class="col-md-5">메모</td>
						</tr>
					</thead>
					<tbody>
						<%if (list.isEmpty()) { %>
						<tr>
							<td class="col-md-1"></td>
							<td class="col-md-2"></td>
							<td class="col-md-5"><strong>작성된 글이 존재하지 않습니다.</strong></td>
							<td class="col-md-2"></td>
							<td class="col-md-1"></td>
						</tr>
						<%} else { 
							for (orderDTO dto : list) {
						%>
						<tr style="cursor: pointer;" class="data">
							<td id="<%=dto.getId() %>" class="col-md-1"><%=dto.getId()%></td>
							<td id="<%=dto.getId() %>" class="col-md-2"><%=dto.getOrder_num()%></td>
							<td id="<%=dto.getId() %>" class="col-md-2"><%=dto.getPro_name()%></td>
							<td id="<%=dto.getId() %>" class="col-md-1"><%=dto.getStatus()%></td>
							<%if (dto.getMemo() == null) { %>
							<td id="<%=dto.getId() %>" class="col-md-5"></td>
							<%} else { %>
							<td id="<%=dto.getId() %>" class="col-md-5"><%=dto.getMemo()%></td>
							<% } %>
						</tr>
						<%
							}
						}
						%>
					</tbody>
				</table>
			</div>
			<!---------------------------------------------------------------------------------------------------------------------->
			<!----------------------------------------------------페이지네이션 선언----------------------------------------------->
			<div>
				<nav style="display: inline">
					<ul class="pagination">
						<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
						<%	for (int i = 1; i <= Math.ceil(count / 12.0); i++) { // 페이지 내 글 개수 10개로 조정	%>
						<li><a href="/localjungo/check?pageNum=<%=i%>"><%=i%></a></li>
						<%	}	%>
						<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
					</ul>
				</nav>
			</div>
			<!------------------------------------------------------------------------------------------------------------>
		</div>
	</div>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="resources/js/checkJquery.js?ver=13"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>