<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>메인페이지</title>
<style>
.container{
	text-align: center;
	width: 1000px;
}
.btn{
	background-color: white;
	border-color: black;
	border: 1px solid black;
    border-radius: 10px;
    font-size: 12px;
}
a{
	color: black;
	border-radius: 5px;
	font-size: 15px;
}
h4{
	font-size: 18px;
}
.content{
	overflow-x: hidden;
	width: 1000px;
}
.movie_img{
	border: 1px solid black;
	width: 200px;
	height: 250px;
}
</style>
</head>
<body>
<div class="container">
	<div class="content">

	<%@ include file="header.jsp"%>
	<h1>______</h1>
	<h2 class="main_title">영화</h2>
	<h4 class="sub_title">현재 상영작</h4><br>
	
	<ul>
		<li><img class="movie_img" src="Img/1.jpg" alt=""></li>
		<li><img class="movie_img" src="Img/2.jpg" alt=""></li>
		<li><img class="movie_img" src="Img/3.jpg" alt=""></li>
		<li><img class="movie_img" src="Img/4.jpg" alt=""></li>
	</ul>
	<ul>
		<li><a href="#"> 영화정보 </a>|<a href="#"> 상영시간 </a>|<a href="/reservation?mo_number=1"> 예매하기 </a></li>
		<li><a href="#"> 영화정보 </a>|<a href="#"> 상영시간 </a>|<a href="#"> 예매하기 </a></li>
		<li><a href="#"> 영화정보 </a>|<a href="#"> 상영시간 </a>|<a href="#"> 예매하기 </a></li>
		<li><a href="#"> 영화정보 </a>|<a href="#"> 상영시간 </a>|<a href="#"> 예매하기 </a></li>
	</ul>
	
	<h1>______</h1>
	<h2 class="main_title">영화</h2>
	<h4 class="sub_title">상영 예정작</h4><br>

	<ul>
		<li><img class="movie_img" src="Img//1-1.jpg" alt=""></li>
		<li><img class="movie_img" src="Img//1-2.jpg" alt=""></li>
		<li><img class="movie_img" src="Img//1-3.jpg" alt=""></li>
		<li><img class="movie_img" src="Img//1-4.jpg" alt=""></li>
	</ul>
	
	<h1>______</h1>
	<h2 class="main_title">공지</h2>
	<h4 class="sub_title">Notice & News</h4><br>
	
	<ul>
		<li><i class="far fa-calendar-alt" style="font-size: 30px;"></i>
		<a href="#">공지사항1</a></li>
		<li><i class="far fa-calendar-alt" style="font-size: 30px;"></i>
		<a href="#">공지사항2</a></li>
		<li><i class="far fa-calendar-alt" style="font-size: 30px;"></i>
		<a href="#">공지사항3</a></li>
	</ul>
	<br><br><br>
	<button type="button" class="btn">더보기+</button>
	<br><br><br>
	<%@ include file="footer.jsp"%>
	</div>

</div>
</body>
</html>