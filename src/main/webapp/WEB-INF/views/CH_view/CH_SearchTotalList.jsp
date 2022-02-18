<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>통합검색</title>
<style>
	table{
		text-align: left;
		border-spacing: 100px;
		border-collapse: separate;
		width: 600px;
		height: 100px;
	}
	.movieList td{
		font-size: 15px;
		text-align: left;
	}
	.bbsList td{
		font-size: 15px;
		text-align: center;
		width: 150px;
	}
	.bbsList th{
		font-size: 15px;
		text-align: center;
	}
	.subject{
		text-align: left;
		margin-top: 50px;
		margin-bottom: 30px;
	}
	#header{
		font-size: 25px;
	}
</style>
</head>
<body>
<div class="container">

	<!-- 영화검색 리스트 -->
	<div class="content">
		<div class="movieList">
			<%@ include file="../header.jsp" %>
			<c:if test="${fn:length(SearchMovieList)==0}">
				<div class="subject">
					<b id="header">영화정보</b>
				</div>
				<hr>
				<h2>**** 입력하신 영화 정보가 없습니다. ****</h2>
				<hr>
			</c:if>

			<c:if test="${fn:length(SearchMovieList)!=0 }">
				<div class="subject">
					<b id="header">영화정보</b>
				</div>
				<hr>
				<c:forEach var="movie" items="${SearchMovieList }">
					<table>
						<tr>
							<td style="width: 300px;"><img src="${movie.mo_fileName}" style="width: 150px; height: 200px;" ></td>
							<td>제목 : ${movie.mo_title}<br>
								감독 : ${movie.mo_director}<br>
								배우 : ${movie.mo_actor}<br>
								장르 : ${movie.mo_genre}<br>
								연령듭급 : ${movie.mo_age}<br>
								상영시간 : ${movie.mo_playTime} 시간<br>
								개봉날짜 : ${movie.mo_openDate}<br>
							</td>
						</tr>
					</table>
					<hr>
				</c:forEach>
			</c:if>
		</div>
	</div>
	<!-- 게시판 검색 리스트  -->
	<div class="content">
		<div class="bbsList">
			<c:if test="${fn:length(SearchBbsList)==0}">
				<div class="subject">
					<b id="header">게시판정보</b>
				</div>
				<hr>
				<h2>**** 입력하신 게시물 정보가 없습니다. ****</h2>
			</c:if>
			<c:if test="${fn:length(SearchBbsList)!=0 }">
				<div class="subject">
					<b id="header">게시판정보</b>
				</div>
				<hr>
				<table>
					<tr>
						<th>카테고리</th><th>제목</th><th>내용</th>
						<th>업로드날짜</th><th>조회수</th><th>작성자</th>
					</tr>
					<c:forEach var="bbs" items="${SearchBbsList }">
						<tr>
							<td>${bbs.bbs_category}</td><td>${bbs.bbs_title}</td>
							<td>${bbs.bbs_content}</td><td>${bbs.bbs_date}</td>
							<td>${bbs.bbs_hit}</td><td>${bbs.m_id}</td>
						</tr>
					</c:forEach>
				</table>
				<hr>
			</c:if>
		</div>
		<%@ include file="../footer.jsp"%>
	</div>
</div>
</body>
</html>