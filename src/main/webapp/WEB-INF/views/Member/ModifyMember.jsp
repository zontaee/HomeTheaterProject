<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<link rel="stylesheet" href="css/member_css/MemberModifyMember.css">
<title>회원정보변경</title>
<script>
function memberDelete(){
	if(confirm("회원탈퇴 하시겠습니까?")){
		alert("탈퇴되었습니다.");
		location.href="memberDelete";
	}else{
		alert("취소되었습니다.");
	}
}
</script>
</head>
<body>
<div class="container">
 <div class="content">
 <%@ include file="../header.jsp" %>
 <div class="subject">
 	<b id="header">회원정보변경</b>
 </div><hr>
 <div class="delete">
 	<input type="button" id="delete" value="회원탈퇴" onclick="memberDelete()">
 </div>
 <form action="memberUpdate" name="memberUpdate" method="post">
 	<div class="form-grou row">
 		<label class="col-sm-2"><b>아이디:</b></label>
 		<div class="col-sm-3">
	 		<input type="text" id="id" name="m_id" value="${member.m_id}" readonly><br><br>
 		</div>
	 </div>
	 		
	 <div class="form-grou row">
 		<label class="col-sm-2"><b>비밀번호:</b></label>
 		<div class="col-sm-3">
	 		<input type="password" id="password" name="m_password" value="${member.m_password }" readonly><br><br>
 		</div>
 		<div class="col-sm-1">
 			<input type="button" id="popup_open_btn" value="비밀번호변경" >
 		</div>
	 </div>
	 		
	 <div class="form-grou row">
	 	<label class="col-sm-2"><b>이름:</b></label>
 		<div class="col-sm-3">
	 		<input type="text" id="m_name" name="m_name" value="${member.m_name}" required><br><br>
 		</div>
	 </div>
	 		
	 <div class="form-grou row">
 		<label class="col-sm-2"><b>전화번호:</b></label>
 		<div class="col-sm-3">
			<input type="text" id="phone" name="m_phonenumber" value="${member.m_phonenumber}" readonly><br><br>
 		</div>
	 </div>
	 		
	 <div class="form-grou row">
 		<label class="col-sm-2"><b>주소:</b></label>
 		<div class="col-sm-3">
			<input type="text" name="m_address" value="${member.m_address }" required><br><br>
 		</div>
	 </div>
	 		
	 <div class="form-grou row">
 	 	<label class="col-sm-2"><b>이메일:</b></label>
 		<div class="col-sm-3">
			<input type="text" id="m_email" name="m_email" value="${member.m_email }" required><br><br><br><br>
 		</div>
	 </div>
	 <input class="btn" type="submit" value="확인 " style="font-weight: bold;" onclick="checkForm()">
	 <input class="btn" type="button" value="취소" style="font-weight: bold;" onclick="history.back();">
 	 <br><br>
 </form>
 <!-- 모달창 -->
 <div id="my_modal">
    <a class="modal_close_btn"><i class="fas fa-times"></i></a><br>
    <h2>Change Password</h2><br>
    <form action="memberPwUpdate" name="changePassword" method="post">
	    <b>현재 비밀번호</b>
	    <input id="modalInput" class="currentPw" type="password" name="m_currentPassword" required><br>
	    <b>새로운 비밀번호</b>
	    <input id="modalInput" class="newPw" type="password" name="m_newPassword" required><br>
	    <b>새로운 비밀번호 확인</b>
	    <input id="modalInput" type="password" name="m_newPasswordConfirm" required><br><br>
	    <input type="hidden" name="m_id" value="${member.m_id}">
	    <input type="hidden" name="m_name" value="${member.m_name}">
	    
	    <input type="submit" class="btn" value="확인" onclick="checkPassword()">
	    <input type="button" class="btn" value="취소" onclick="location.href='modifyForm'">
    </form>
 </div>
 <%@ include file="../footer.jsp"%>
 </div>
</div>
<script type="text/javascript" src="js/member/ModifyMember.js"></script>
</body>
</html>