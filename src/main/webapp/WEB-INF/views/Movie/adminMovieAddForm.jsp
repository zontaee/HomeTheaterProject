<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/movieAdmin.css">
<title>영화 등록</title>


</head>
<body>
	<div class="container">

		<%@ include file="../header.jsp"%>
		<h1>______</h1>
		<h2 class="main_title">영화 등록</h2>
		<br>
		<div class="movieInfo-form"> 
		<form action="adminMovieAdd" name="addMovie" method="post"  enctype="multipart/form-data">
			<ul>
				<li><label class="movieInfoName">영화 제목</label>
				<div class="movieInfo" >
				<input type="text" 	id="movieTitle" name="mo_title"></div></li>
				
				<br>
				<li><label class="movieInfoName">영화 감독</label>
				<div class="movieInfo" >
				<input type="text" id="movieDiretor" name="mo_director"></div></li>
			
				<br>
				<li><label class="movieInfoName">배우</label>
				<div class="movieInfo" >
				<input type="text"	id="movieActor" name="mo_actor"></div></li>
				<br>
				
				<li><label class="movieInfoName">장르</label>
				<div class="movieInfo" >
				<input type="text" id="movieGenre" name="mo_genre">
					</div></li>
				<br>
				<li><label class="movieInfoName">등급</label>
				<div class="movieInfo" >
				<input type="text" 
					id="movieAge" name="mo_age">
					</div></li>
				<br>
				<li><label class="movieInfoName">상영시간</label>
				<div class="movieInfo" >
				<input type="text" 
					id="moviePlayTime" name="mo_playTime">
					</div></li>
				<br>
				<li><label class="movieInfoName">개봉일</label>
				<div class="movieInfo" >
				<input type="text"
					id="movieOpenDate" name="mo_openDate">
					</div></li>
				<br>
				<li><label class="movieInfoName">추천수</label>
				<div class="movieInfo" >
				<input type="text"
					id="movieRecommendation" name="mo_recommendation">
					</div></li>
				<br>
				<li><label class="movieInfoName">포스터</label>
				<div class="movieInfo" >
				<input type="file" 
					id="movieFileName" name="file"></div></li>
				<br>
	    <input type="hidden" name="path" value="${pageContext.request.contextPath}/resources/static/Img/"> 
			</ul>

			<div class="adminBtn">
				<button type="submit" value="등록" id="movieAdd" onclick="movieAddClick()">등록</button>
				<button type="button" id="movieAddCancle" onclick="history.back()">취소</button>
			</div>
		</form>
		</div>
		<%@include file="../footer.jsp"%>
	</div>
</body>

<script>
function movieAddClick(){
	 <c:choose>
		<c:when test="${msg != null }">
		alert(${msg});
		</c:when>
		<c:otherwise>
		alert("등록 되었습니다.");
		</c:otherwise>
	 </c:choose>
}
 
</script>

</html>