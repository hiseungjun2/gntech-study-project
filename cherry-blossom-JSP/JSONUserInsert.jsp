<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String id=request.getParameter("id");
	String pw = request.getParameter("pw");
	String name=request.getParameter("name");
	String birth = request.getParameter("birth");
	String prof = request.getParameter("prof");
	String local = request.getParameter("local");
	String purp = request.getParameter("purp");
	String imgurl = request.getParameter("imgurl");
	
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
		// pstmt=conn.prepareStatement(      
		//		"INSERT INTO user VALUES(?,?,?,?,?,?,?)");
		pstmt=conn.prepareStatement(      
				"INSERT INTO reportProject_user VALUES(?,?,?,?,?,?,?,?)");
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, name);
		pstmt.setString(4, birth);
		pstmt.setString(5, prof);
		pstmt.setString(6, local);
		pstmt.setString(7, purp);
		pstmt.setString(8, imgurl);
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