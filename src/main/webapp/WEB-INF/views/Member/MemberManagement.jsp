<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<link rel="stylesheet" href="css/member_css/MemberMemberManagement.css">
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
		<c:forEach var="memberJpa" items="${memberList}" varStatus="status">
			<tr><td>${status.index+1}</td>
				<td><input type="text" id="memberId${status.index}" class="memberId" value="${memberJpa.memberId}" readonly></td>
				<td><input type="text" id="memberName${status.index}" value="${memberJpa.memberName}"></td>
				<td><input type="text" id="memberPhonenumber${status.index}" value="${memberJpa.memberPhonenumber}"></td>
				<td><input type="text" id="memberAddress${status.index}" class="memberAddress" value="${memberJpa.memberAddress}"></td>
				<td><input type="text" id="memberEmail${status.index}" value="${memberJpa.memberEmail}"></td>
				<td><input type="text" id="m_point${status.index}" class="m_point" value="${memberJpa.m_point}"></td>
				<td><input type="button" class="button" value="수정" onclick="updateMember(${status.index})"></td>
				<td><input type="button" class="button" value="삭제" onclick="deleteMember(${status.index})"></td>
			</tr>
		</c:forEach>
	</table>
 	
 	
 	<%@ include file="../footer.jsp"%>
 </div>
</div>
<script type="text/javascript" src="js/memberJpa/MemberManagement.js"></script>
</body>
</html>