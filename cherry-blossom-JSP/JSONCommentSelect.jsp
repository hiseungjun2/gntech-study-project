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
      System.out.println("공지사항이닷!");
   }catch(Exception e){
      e.printStackTrace();      
   }
   //---------------------------------------------------------------------
   PreparedStatement pstmt=null;
   ResultSet rs=null;
   
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
      // pstmt=conn.prepareStatement("SELECT * from notice");
      pstmt=conn.prepareStatement("SELECT * from reportProject_comment");
      rs=pstmt.executeQuery();
      
      JSONObject jsonMain = new JSONObject();
      JSONArray jArray = new JSONArray();   
      
      while(rs.next())
      {
         JSONObject jObject = new JSONObject();
         jObject.put("id", rs.getInt("comment_id"));
         jObject.put("content", rs.getString("comment_content"));
         jObject.put("date", rs.getString("comment_date"));
         jObject.put("userid", rs.getString("user_id"));
         jObject.put("username", rs.getString("user_name"));
         jObject.put("boardid", rs.getString("board_id"));
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