<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/movieAdmin.css">
<title>수정 페이지</title>

</head>
<body>
	<div class="container">

		<%@ include file="../header.jsp"%>
		<h1>______</h1>
		<h2 class="main_title">영화 수정</h2>
		<br>
		<div class="movieInfo-form">
			<form action="adminMovieUpdate" name="updateMovie" method="post">
				<input type="hidden" name="mo_number" value="${movie.mo_number }">
				<ul>
					<li><label class="movieInfoName">영화 제목</label>
						<div class="movieInfo">
							<input type="text" id="movieTitle" name="mo_title"
								value="${movie.mo_title }">
						</div></li>
					<br>
					<li><label class="movieInfoName">영화 감독</label>
						<div class="movieInfo">
							<input type="text" id="movieDiretor" name="mo_director"
								value="${movie.mo_director }">
						</div></li>
					<br>
					<li><label class="movieInfoName">배우</label>
						<div class="movieInfo">
							<input type="text" id="movieActor" name="mo_actor"
								value="${movie.mo_actor }">
						</div></li>
					<br>
					<li><label class="movieInfoName">장르</label>
						<div class="movieInfo">
							<input type="text" id="movieGenre" name="mo_genre"
								value="${movie.mo_genre }">
						</div></li>
					<br>
					<li><label class="movieInfoName">등급</label>
						<div class="movieInfo">
							<input type="text" id="movieAge" name="mo_age"
								value="${movie.mo_age }">
						</div></li>
					<br>
					<li><label class="movieInfoName">상영시간</label>
						<div class="movieInfo">
							<input type="text" id="moviePlayTime" name="mo_playTime"
								value="${movie.mo_playTime }">
						</div></li>
					<br>
					<li><label class="movieInfoName">개봉일</label>
						<div class="movieInfo">
							<input type="text" id="movieOpenDate" name="mo_openDate"
								value="${movie.mo_openDate }">
						</div></li>
					<br>
					<li><label class="movieInfoName">추천수</label>
						<div class="movieInfo">
							<input type="text" id="movieRecommendation"
								name="mo_recommendation" value="${movie.mo_recommendation }">
						</div></li>
					<br>
					<li><label class="movieInfoName">파일경로</label>
						<div class="movieInfo">
							<input type="text" id="movieFileName" name="mo_fileName"
								value="${movie.mo_fileName }">
						</div></li>
					<br>

				</ul>

				<div class="adminBtn">
					<button type="submit" value="수정" id="movieUpdate"
						onclick="movieUpdateClick()">수정</button>
					<button type="button" id="movieUpdateCancle"
						onclick="history.back()">취소</button>
				</div>
			</form>
		</div>
		<%@include file="../footer.jsp"%>
	</div>
</body>

<script>
function movieUpdateClick(){
	alert("수정되었습니다.");
	
}
</script>
</html>