<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.*" %>
<%
//enctype="multipart/form-data"
String dir = application.getRealPath("/report_project/img");

int max = 10*1024*1024;

try{
   if (-1 < request.getContentType().indexOf("multipart/form-data")) {
MultipartRequest mr = new MultipartRequest(request, dir, max, new DefaultFileRenamePolicy());

String orgFileName = mr.getOriginalFileName("uploaded_file");

String saveFileName = mr.getFilesystemName("uploaded_file");
   
out.println(orgFileName+"이 저장되었습니다~~~~~~.");
   }
}catch(Exception e){
   out.print(e);
out.println("@@@");
}
%>