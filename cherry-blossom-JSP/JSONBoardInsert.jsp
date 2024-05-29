<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String title = request.getParameter("title");
	String date=request.getParameter("date");
	String id=request.getParameter("id");
	String name=request.getParameter("name");
	String map = request.getParameter("map");
	String content = request.getParameter("content");
	
	Connection conn=null;   
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(
				//"jdbc:mysql://localhost:3306/report_project", 
				"jdbc:mysql://localhost:3306/tmdwns9738",
				//"root", "fifa2002");
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
				"ALTER TABLE reportProject_board AUTO_INCREMENT=1");
	   pstmt1.executeUpdate();
	   PreparedStatement pstmt2 = conn.prepareStatement(
			"SET @COUNT = 0");
	   pstmt2.executeUpdate();
	   PreparedStatement pstmt3 = conn.prepareStatement(
				"UPDATE reportProject_board SET board_id = @COUNT:=@COUNT+1");
	   pstmt3.executeUpdate();
		// pstmt=conn.prepareStatement(      
		//		"INSERT INTO user VALUES(?,?,?,?,?,?,?)");
		pstmt=conn.prepareStatement(
				"INSERT INTO reportProject_board(board_title, board_date, user_id, user_name, board_map, board_content) VALUES(?,?,?,?,?,?)");
		pstmt.setString(1, title);
		pstmt.setString(2, date);
		pstmt.setString(3, id);
		pstmt.setString(4, name);
		pstmt.setString(5,map);
		pstmt.setString(6, content);
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