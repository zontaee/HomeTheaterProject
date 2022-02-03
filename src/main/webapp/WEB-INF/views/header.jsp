<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR&display=swap" rel="stylesheet"><meta charset="UTF-8">
<title>header</title>
<style>
*{
	font-family: 'Noto Serif KR', serif;

}
.logo{
	text-align: left;
	margin-bottom: -20px;
}
.top_menu{
	text-align: center;
	border-bottom: 1px solid black;
	border-top: 1px solid black;
	margin-top: 10px;
	padding-top: 10px;
}
li{
	list-style: none;
	display: inline-block;
	margin: auto 10px;
}
a:hover{
	color: black;
	background-color: #D5D5D5;
}
.menuLink{
	width: 100px;
	display: block;
}
.menuLink:hover{
	color: black;
	background-color: #D5D5D5;
}
.login_logout{
	text-align: right;
}
</style>
</head>
<body>
<div class="logo">
	<a href="#">
		<img src="Img/logo1.png" style="" width="250px" height="100">
	</a>
</div>
<div class="login_logout">
<!--  	<i class="far fa-smile" style="font-size: 16px;"></i>&nbsp;	-->
		<a href="#">Login </a>&nbsp;|&nbsp; 
		<a href="#">Join</a>
	</div>	

<nav class="top_menu">
	<ul>
		<li><a class="menuLink" href="#">영화</a></li>
		<li><a class="menuLink" href="#">추천영화</a></li>
		<li><a class="menuLink" href="#">공지사항</a></li>
		<li><a class="menuLink" href="#">고객센터</a></li>
		<li><i class="fas fa-search" style="font-size: 15px;"></i>&nbsp;
		<input type="search" style="width: 100px;" placeholder="검색"></li>
	</ul>
</nav>
</body>
</html>