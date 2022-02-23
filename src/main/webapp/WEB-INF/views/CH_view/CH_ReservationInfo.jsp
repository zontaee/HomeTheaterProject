<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<link rel="stylesheet" href="css/CH_css/CH_ReservationInfo.css">
<title>예약정보</title>
</head>
<body>
<div class="container">
 <div class="content">	 
 	<%@ include file="../header.jsp" %>
 	<div class="subject">
 		<b id="header">예약정보</b>
 	</div>
 	<c:if test="${fn:length(checkReservationInfo)==0}">
 		<hr>
 		<h2>**** 예약정보가 없습니다. ****</h2>
 	</c:if>
 	
 	<c:if test="${fn:length(checkReservationInfo)!=0}">
	 	<c:forEach var="reservation" items="${checkReservationInfo }">
			<hr>
			<table>
				<tr>
					<b><th colspan="2">예매상세내역</th></b>
					<th></th>
				</tr>
				<tr>
					<td id="image"><img src="${reservation.mo_fileName}" style="width: 150px; height: 200px;"></td>
					<td><b>예약번호</b> : ${reservation.re_number}<br>
						<b>영화제목</b> : ${reservation.mo_title}<br>
						<b>좌석번호</b> : ${reservation.se_number}<br>
						<b>예매날짜</b> : ${reservation.se_date}일<br>
						<b>예매시간</b> : ${reservation.se_time}시<br>
						<b>회원아이디</b> :  ${reservation.m_id}<br><br>
						<input type="hidden" value=${reservation.mo_number}>
						<input class="btn" type="button" value="예매취소" 
						onclick="cancel('${reservation.re_number}','${reservation.se_date}','${reservation.se_number }','${reservation.se_time }','${reservation.mo_number}')" style="font-weight: bold;">
					</td>
				</tr>
			</table>
		</c:forEach>
	</c:if>
 	
 	<%@ include file="../footer.jsp"%>	
 </div>
</div>
<script type="text/javascript" src="js/reservation/cancel.js"></script>
</body>
</html>