<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String userid = request.getParameter("userid");
	String boardid=request.getParameter("boardid");
	String id = request.getParameter("id");
	String username = request.getParameter("username");
	String date = request.getParameter("date");
	String content = request.getParameter("content");
	
	Connection conn=null;   
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(
				// "jdbc:mysql://localhost:3306/report_project", 
				 "jdbc:mysql://localhost:3306/tmdwns9738", 
				// "root", "fifa2002");
				 "tmdwns9738", "Fifa2002");
		System.out.println("저장할끄다!");
	}catch(Exception e){
		e.printStackTrace();
	}
	//----------------------------------------------------------------------
	PreparedStatement pstmt=null;          
	int n=0;
	try{
		PreparedStatement pstmt1 = conn.prepareStatement(
				"ALTER TABLE reportProject_comment AUTO_INCREMENT=1");
	   pstmt1.executeUpdate();
	   PreparedStatement pstmt2 = conn.prepareStatement(
			"SET @COUNT = 0");
	   pstmt2.executeUpdate();
	   PreparedStatement pstmt3 = conn.prepareStatement(
				"UPDATE reportProject_comment SET comment_id = @COUNT:=@COUNT+1");
	   pstmt3.executeUpdate();
		// pstmt=conn.prepareStatement(      
		//		"INSERT INTO user VALUES(?,?,?,?,?,?,?)");
		pstmt=conn.prepareStatement(      
				"INSERT INTO reportProject_comment(comment_content, comment_date, user_id, user_name, board_id) VALUES(?,?,?,?,?)");
		pstmt.setString(1, content);
		pstmt.setString(2, date);
		pstmt.setString(3, userid);
		pstmt.setString(4, username);
		pstmt.setString(5, boardid);
		n=pstmt.executeUpdate();             
				
		if(n > 0){
			conn.commit();  
		}
			
	}catch(SQLException e){
		//e.printStackTrace();
		try{
			conn.rollback();
		}catch(SQLException e1){}
	}finally{
		try{
			pstmt.close();                         
		}catch(SQLException e){}
	}
%>