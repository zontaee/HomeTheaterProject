<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<link rel="stylesheet" href="css/member_css/MemberSearchTotalList.css">
<title>통합검색</title>
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
						<td><b>제목 :</b> ${movie.mo_title}<br>
							<b>감독 :</b> ${movie.mo_director}<br>
							<b>배우 :</b> ${movie.mo_actor}<br>
							<b>장르 :</b> ${movie.mo_genre}<br>
							<b>연령듭급 :</b> ${movie.mo_age}<br>
							<b>상영시간 :</b> ${movie.mo_playTime} 시간<br>
							<b>개봉날짜 :</b> ${movie.mo_openDate}<br>
							<input class="btn" type="button" value="상세보기" onclick="location.href='movieDetail?mo_number=${movie.mo_number}'" style="font-weight: bold;">
							<input class="btn" type="button" value="예매하기" onclick="location.href='/reservation?mo_number=${movie.mo_number}'" style="font-weight: bold;">
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
  <div class="boardList">
 	<c:if test="${fn:length(searchBoardList)==0}">
		<div class="subject">
			<b id="header">게시판정보</b>
		</div>
		<hr>
		<h2>**** 입력하신 게시물 정보가 없습니다. ****</h2>
	</c:if>
 	<c:if test="${fn:length(searchBoardList)!=0 }">
			<div class="subject">
				<b id="header">게시판정보</b>
			</div>
			<hr>
				<table>
					<tr>
						<th>카테고리</th>
						<th>제목</th>
						<th>업로드날짜</th>
						<th>조회수</th>
						<th>작성자</th>
					</tr>				
					<c:forEach var="board" items="${searchBoardList }">
					<tr>
						<td>${board.board_category}</td>
						<td><a href="YM_views/noticeContents?board_no=${board.board_no }&board_category=${board.board_category}">${board.board_title}</a></td>
						<td>${board.board_date}</td>
						<td>${board.board_hit}</td>
						<td>${board.memberId}</td>
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