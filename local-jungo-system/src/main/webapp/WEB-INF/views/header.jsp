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
<!-- <link rel="icon" href="resources/ico/img.png"> -->

<title>지역중고거래관리</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- 커스텀 CSS -->
<link href="resources/css/custom.css" rel="stylesheet">

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
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand">지역중고거래관리</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li id=""><a href="index?pageNum=1" id="order_btn">신청조회</a></li>
				<li id=""><a href="check?pageNum=1" id="check_btn">검토조회</a></li>
				<li id=""><a href="result?pageNum=1&CancelpageNum=1" id="result_btn">완료조회</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a>관리자님 안녕하세요</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>