
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
<title>리스트</title>


</head>
<body>
	<div class="container">
		<%@ include file="../header.jsp"%>
		<h1>______</h1>
		<h2 class="main_title">영화</h2>
		<br>


		<ul>
			<c:forEach var="movie" items="${listMovie }">
				<li><img class="list_image" src="/${movie.mo_fileName }" alt=""><br>
					<a href="movieDetail?mo_number=${movie.mo_number }"> 영화정보 </a>|<a href="#"> 상영시간 </a>|<a href="/reservation?mo_number=${movie.mo_number }"> 예매하기 </a></li>
			</c:forEach>
		</ul>


		<%-- <table>
			<tr>
				<th>영화 번호</th>
				<th>제목</th>
				<th>감독</th>
				<th>장르</th>
			</tr>
			<c:forEach var="movie" items="${listMovie }">
				<tr>
					<td>${movie.mo_number }</td>
					<td>${movie.mo_title }</td>
					<td>${movie.mo_director }</td>
					<td>${movie.mo_genre }</td>
					<td><a href="movieDetail?mo_number=${movie.mo_number}"><img
							class="list_image" src="/${movie.mo_filename }" width="175"
							height="250"></a></td>
				</tr>

			</c:forEach>
		</table> --%>
		<br> <br> <br>
		<%@ include file="../footer.jsp"%>
	</div>
</body>

</html>
