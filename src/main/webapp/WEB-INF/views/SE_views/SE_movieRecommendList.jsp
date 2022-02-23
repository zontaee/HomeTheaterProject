<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천영화</title>
<style>
.list_image{
	border: 1px solid black;
	width: 200px;
	height: 250px;
}
</style>

</head>
<body>
	<div class="container">
		<%@ include file="../header.jsp"%>
		<h1>______</h1>
		<h2 class="main_title">추천영화</h2>
		<br>


		<ul>
			<c:forEach var="movie" items="${listRecommendMovie }">
				<li><img class="list_image" src="/${movie.mo_fileName }" alt=""><br>
					<a href="movieDetail?mo_number=${movie.mo_number }"> 영화정보 </a>|<a href="#"> 상영시간 </a>|<a href="/reservation?mo_number=${movie.mo_number }"> 예매하기 </a></li>
			</c:forEach>
		</ul>


		<br> <br> <br>
		<%@ include file="../footer.jsp"%>
	</div>
</body>

</html>