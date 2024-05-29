<%@page import="dto.noticeDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	@SuppressWarnings (value="unchecked")		// warning 제거
	ArrayList<noticeDto> notice = (ArrayList<noticeDto>)request.getAttribute("noticelist");
	int count = (int)request.getAttribute("noticecount");
%>
<%@include file="../header.jsp" %>
	<div class="container">
	        <div id="basic_table">
	            <div class="container-body">
	                <h2>공지사항</h2>
						<!----------------------------------------------------테이블 생성----------------------------------------------->
						<div>
							<table id="notice" class="table table-striped table-hover">
								<thead>
									<tr>
										<td class="col-md-1">번호</td>
										<td class="col-md-8">제목</td>
										<td class="col-md-2">날짜</td>
									</tr>
								</thead>
								<tbody>
								<% if (count == 0) { 	// 글 개수가 0개 라면 %>
									<tr>
										<td class="col-md-1"></td>
										<td class="col-md-8"><p><strong>작성된 글이 존재하지 않습니다</strong></p></td>
										<td class="col-md-2"></td>
									</tr>
								<% } else { 	
										for (int i = 0; i<notice.size();i++) {
				                    		noticeDto noDto = notice.get(i);
								%>
									<tr style="cursor:pointer;">
										<td id="<%=noDto.getNotice_id() %>" class="col-md-1"><%=noDto.getNotice_id()%></td>
										<td id="<%=noDto.getNotice_id() %>" class="col-md-8"><%=noDto.getNotice_title() %></td>
										<td id="<%=noDto.getNotice_id() %>" class="col-md-2"><%=noDto.getNotice_date() %></td>
									</tr>
								<%   		}
				                    	}
								%>	
								</tbody>
							</table>
				        </div>
				        <!---------------------------------------------------------------------------------------------------------------------->
				        <!----------------------------------------------------페이지네이션 선언----------------------------------------------->
				        <div> 
				        	<nav>
				        		<ul class="pagination">
								    <li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
								    <% for(int i = 1; i<=count/12+1;i++) {  %>
								    <li><a href="main.jsp?contentPage=home_table.jsp?pageNum=<%=i%>"><%=i %></a></li>
								    <%	} %>
								    <li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
								</ul>
				        	</nav>
				        </div>
				        <!------------------------------------------------------------------------------------------------------------>
	            </div>
	        </div>
	</div>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/homeJquery.js?ver=1"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>