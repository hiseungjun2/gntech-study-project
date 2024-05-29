<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8"); 
	String contentPage = request.getParameter("contentPage");
	if(contentPage==null) {
	   contentPage="/homehome_table.jsp?pageNum=1";
	}
%>
<%@include file="header.jsp" %>
    <div class="container">
        <div id="basic_table">
            <div class="container-body">
                <jsp:forward page="./noticelist">
                	<jsp:param name="pageNum" value="1"/>
                </jsp:forward>
            </div>
        </div>
    </div>
    <!-- <div class="footer">
        <img src="ico/gntech.png">
        <P>경남과학기술대학교 컴퓨터공학과 21324115 김승준</P>
    </div> -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/homeJquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>