<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<link rel="stylesheet" href="css/CH_css/CH_InterestMovie.css">
<title>관심영화</title>
</head>
<body>
<div class="container">
 <div class="content">
 	<%@ include file="../header.jsp" %>
	<div class="subject">
 		<b id="subject">관심영화</b>
 	</div>
 	<c:if test="${fn:length(TotalList)==0}">
 		<hr>
 		<h2>**** 관심영화 정보가 없습니다. ****</h2>
 	</c:if>
 	
 	<c:if test="${fn:length(TotalList)!=0}">
	 	<c:forEach var="movie" items="${TotalList }">
			<hr>
			<table>
				<tr>
					<td style="width: 300px;"><img src="${movie.mo_fileName}" style="width: 150px; height: 200px;" ></td>
					<td><b>제목</b> : ${movie.mo_title}<br>
						<b>감독</b> : ${movie.mo_director}<br>
						<b>배우</b> : ${movie.mo_actor}<br>
						<b>장르</b> : ${movie.mo_genre}<br>
						<b>연령듭급</b> : ${movie.mo_age}<br>
						<b>상영시간</b> : ${movie.mo_playTime} 시간<br>
						<b>개봉날짜</b> : ${movie.mo_openDate}<br><br>
						<input class="btn" type="button" value="예매하기" onclick="location.href='/reservation?mo_number=${movie.mo_number}'" style="font-weight: bold;">
					</td>
				</tr>				
			</table>
		</c:forEach>
	</c:if>
	<%@ include file="../footer.jsp"%>
 </div>
</div>
</body>
</html>