<%@page import="biz.buycommentBiz"%>
<%@page import="dto.buyDto"%>
<%@page import="dto.buycommentDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String buy_id = request.getParameter("buy_id");
	
	buycommentBiz biz = new buycommentBiz();
	
	ArrayList<buycommentDto> list = new ArrayList<>();
	
	try {
		list = biz.buyListComment(buy_id);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	for(buycommentDto d : list) {
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