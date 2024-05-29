<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="ko">
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="ico/img.png">

    <title>중고나라</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <!-- 커스텀 CSS -->
    <link href="css/custom.css" rel="stylesheet">
     

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="http://code.jquery.com/jquery-3.3.1.js"></script>
  
    
    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<%
		String id = (String)session.getAttribute("id");
	%>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" >중고나라</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li id="home_li"><a href="main.jsp" id="home_button" >홈</a></li>		<!-- onclick="changeView(0)" -->
            <li id="buy_li"><a href="/jungonara/buylist?pageNum=1" id="buy_button" >삽니다</a></li>
            <li id="sb_li"><a href="/jungonara/sblist?pageNum=1" id="sb_button">팝니다</a></li>
            <li id="qna_li"><a href="/jungonara/mypagelist?buypageNum=1&sbpageNum=1&id=<%=id %>" id="mypage_button" >마이 페이지</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a><%= id %> 님 안녕하세요</a></li>
            <!-- <li><a href="#about">회원정보수정</a></li> -->
            <li><a href="./userlogout">로그아웃</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>