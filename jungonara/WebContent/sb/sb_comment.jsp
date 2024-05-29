<%@page import="dto.sbcommentDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="biz.sbcommentBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sb_id = request.getParameter("sb_id");
	
	sbcommentBiz biz = new sbcommentBiz();
	
	ArrayList<sbcommentDto> list = new ArrayList<>();
	
	try {
		list = biz.sbListComment(sb_id);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	for(sbcommentDto d : list) {
%>
		<div class="panel panel-default">
			<div class="panel-heading">
				<strong><%=d.getUser_id() %></strong>&nbsp;&nbsp;&nbsp;
				<small><%=d.getComment_date() %></small>
			</div>
			<div class="panel-body">
				<%=d.getComment_content() %>
			</div>
		</div>
<%
	}	
%>