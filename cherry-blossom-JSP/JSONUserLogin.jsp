<%@page import="java.sql.SQLException"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection conn=null;
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(
				// "jdbc:mysql://localhost:3306/report_project", 
				 "jdbc:mysql://localhost:3306/tmdwns9738", 
				// "root", "fifa2002");
				 "tmdwns9738", "Fifa2002");
		System.out.println("로그인 할끼다!");
	}catch(Exception e){
		e.printStackTrace();		
	}
	//---------------------------------------------------------------------
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try{
		// pstmt=conn.prepareStatement("SELECT user_id, user_pw from user");
		pstmt=conn.prepareStatement("SELECT user_id, user_pw from reportProject_user");
		rs=pstmt.executeQuery();
		
		JSONObject jsonMain = new JSONObject();
		JSONArray jArray = new JSONArray();	
		
		while(rs.next())
		{
			JSONObject jObject = new JSONObject();
			jObject.put("id", rs.getString("user_id"));
			jObject.put("pw", rs.getString("user_pw"));
			
			jArray.add(0, jObject);
		}		
		jsonMain.put("List", jArray);	
		out.println(jsonMain.toJSONString());  
		
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		try{
			rs.close();
			pstmt.close();
			conn.close();
		}catch(SQLException e){}
	}
%>