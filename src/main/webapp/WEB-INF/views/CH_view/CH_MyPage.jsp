<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>마이페이지</title>
<style>
.subject{
	text-align: center;
	margin-top: 50px;
	margin-bottom: 50px;
}
b{
	font-size: 25px;
}
#icon{
	margin-left: 50px;
	margin-right: 50px;
	border: 2px solid black;
	width: 200px;
	height: 200px;
	display: inline-block;
}
#explain1{
	margin-left: 100px; 
	margin-right: 130px;
	font-size: 15px;
}
#explain2{
	margin-left: 110px; 
	margin-right: 120px;
	font-size: 15px;
}
#explain3{
	margin-left: 120px; 
	margin-right: 120px;
	font-size: 15px;
}
</style>
</head>
<body>
<div class="container">
 <div class="content">
 	<%@ include file="../header.jsp" %>
 	<div class="subject">
 		<b>마이페이지</b>
 	</div>
 	<a id="icon" href="modifyForm"><i class="fas fa-user-alt" style="font-size: 80px; margin-top: 50px;"></i></a>
 	<a id="icon" href="findInterstMovie"><i class="fas fa-calendar-alt" style="font-size: 80px; margin-top: 50px;"></i></a>
 	<a id="icon" href="#"><i class="fas fa-star" style="font-size: 80px; margin-top: 50px;"></i></a><br><br>
 	<b id="explain1">회원정보변경</b><b id="explain2">관심영화</b><b id="explain3">예약정보</b>
 	<br><br><br><br><br><br>
 	<%@ include file="../footer.jsp"%>
 </div>
</div>
</body>
</html>