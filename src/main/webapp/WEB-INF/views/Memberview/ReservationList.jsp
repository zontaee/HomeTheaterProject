<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html><html><head><meta charset="UTF-8">
<link rel="stylesheet" href="css/member_css/MemberReservationList.css">
<script>
function updateReservation(Vindex){
	var m_id = $("#m_id" + Vindex).val();
	var mo_number = $("#mo_number" + Vindex).val();
	var re_number = $("#re_number" + Vindex).val();
	var se_number = $("#se_number" + Vindex).val();
	var se_date = $("#se_date" + Vindex).val();
	var se_time = $("#se_time" + Vindex).val();
	$.ajax({
		url: "adminUpdateReservation",
		type: "POST",
		data: {
			"m_id": m_id,
			"mo_number": mo_number,
			"re_number": re_number,
			"se_number": se_number,
			"se_date": se_date,
			"se_time": se_time,
		},
		success: function(){
			alert("예매수정이 완료되었습니다.");
			location.href="reservationList";
		}
	})
}
</script>
<title>예약관리</title>
<style>
.inputValue{
	width: 50px;
	border: 1px solid white;
	text-align: center;
}
</style>
</head>
<body>
<div class="container">
 <div class="content">
 	<%@ include file="../header.jsp" %>
 	<div class="subject">
 		<b id="subject">예약관리</b>
 	</div>
 	<table border="1">
		<tr>
			<th>번호</th>
			<th>예약아이디</th>
			<th>영화번호</th>
			<th>예약번호</th>
			<th>좌석번호</th>
			<th>예매날짜</th>
			<th>예매시간</th>
			<th>수정</th>
			<th>예매취소</th>
		</tr>
		<c:forEach var="reservation" items="${reservationList}" varStatus="status">
		<tr><td>${status.index+1}</td>
			<td><input class="inputValue" type="text" id="m_id${status.index}" class="m_id" value="${reservation.m_id}" readonly></td>
			<td><input class="inputValue" type="text" id="mo_number${status.index}" value="${reservation.mo_number}"></td>
			<td><input class="inputValue" type="text" id="re_number${status.index}" value="${reservation.re_number}"></td>
			<td><input class="inputValue" type="text" id="se_number${status.index}" value="${reservation.se_number}"></td>
			<td><input class="inputValue" type="text" id="se_date${status.index}" value="${reservation.se_date}"></td>
			<td><input class="inputValue" type="text" id="se_time${status.index}" value="${reservation.se_time}"></td>
			<td><input class="button" type="button" value="수정" onclick="updateReservation(${status.index})"></td>
			<td><input class="button" type="button" value="예매취소" 
			onclick="cancel('${reservation.re_number}','${reservation.se_date}','${reservation.se_number }','${reservation.se_time }','${reservation.mo_number}')" style="font-weight: bold;"></td>
		</tr>
		</c:forEach>
	</table>
 	<%@ include file="../footer.jsp"%>
 </div>
</div>
<script type="text/javascript" src="js/cancel.js"></script>
</body>
</html>