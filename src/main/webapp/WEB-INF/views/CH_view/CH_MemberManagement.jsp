<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<link rel="stylesheet" href="css/CH_css/CH_MemberManagement.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>회원관리</title>
</head>
<body>
<div class="container">
 <div class="content"> 
 	<%@ include file="../header.jsp" %>
 	<div class="subject">
 		<b id="subject">회원관리</b>
 	</div>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>핸드폰번호</th>
			<th>주소</th>
			<th>이메일</th>
			<th>잔여포인트</th>	
			<th colspan="2">수정/삭제</th>
		</tr>
		<c:forEach var="member" items="${memberList}" varStatus="status">
			<tr><td>${status.index+1}</td>
				<td><input type="text" id="m_id${status.index}" class="m_id" value="${member.m_id}" readonly></td>
				<td><input type="text" id="m_name${status.index}" value="${member.m_name}"></td>
				<td><input type="text" id="m_phonenumber${status.index}" value="${member.m_phonenumber}"></td>
				<td><input type="text" id="m_address${status.index}" class="m_address" value="${member.m_address}"></td>
				<td><input type="text" id="m_email${status.index}" value="${member.m_email}"></td>
				<td><input type="text" id="m_point${status.index}" class="m_point" value="${member.m_point}"></td>
				<td><input type="button" class="button" value="수정" onclick="updateMember(${status.index})"></td>
				<td><input type="button" class="button" value="삭제" onclick="deleteMember(${status.index})"></td>
			</tr>
		</c:forEach>
	</table>
 	
 	
 	<%@ include file="../footer.jsp"%>
 </div>
</div>
<script type="text/javascript" src="js/CH_js/CH_MemberManagement.js"></script>
</body>
</html>