<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<script>
// 비밀번호 변경 체크
function checkPassword(){
	if(document.changePassword.m_newPassword.value!=document.changePassword.m_newPasswordConfirm.value){
		alert("새로운 비밀번호와 새로운 비밀번호 확인 값이 다릅니다!")
		document.changePassword.m_newPassword.value="";
		document.changePassword.m_newPasswordConfirm.value="";
		document.changePassword.m_newPassword.focus();
		return false;
	}
	if(document.memberUpdate.m_password.value!=document.changePassword.m_currentPassword.value){
		alert("현재 비밀번호가 다릅니다!");
		document.changePassword.m_currentPassword.value="";
		document.changePassword.m_currentPassword.focus();
		return false;
	}
	var regPw = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$/;
	var pw = $(".newPw").val();
	if(false === regPw.test(pw)) {
		alert('비밀번호는 8~16자, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.');
		$("#m_password").focus();
		$("#m_password").value="";
		event.preventDefault();
	}
}
// 전체 회원 수정 체크
function checkForm(){
	var regName = /^[가-힣]*$/;
	var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	var name = $("#m_name").val();
	var email = $("#m_email").val();
 	if(false === regName.test(name)) {
		alert('이름은 한글만 입력가능합니다.');
		$("#m_name").focus();
		$("#m_name").value="";
		event.preventDefault();
	}
 	if(false === regEmail.test(email)) {
		alert('이메일 입력을 확인해주십시오.');
		$("#mail1").focus();
		$("#mail1").value="";
		event.preventDefault();
	}
}
</script>
<title>회원정보변경</title>
<style>
.subject{
	text-align: center;
	margin-top: 50px;
	margin-bottom: 30px;
	font-size: 25px;
}
#header{
	font-size: 25px;
}
#delete{
	color: blue;
	font-size: 12px;
	text-decoration: underline;
}
.delete{
	text-align: right;
	margin-bottom: 10px;
}
#id{
	background-color: #EAEAEA;
}
#password{
	background-color: #EAEAEA;
}
#phone{
	background-color: #EAEAEA;
}
#popup_open_btn{
	margin-left: -100px;
}
#my_modal {
	display: none;
	width: 300px;
	padding: 20px 60px;
	background-color: #fefefe;
	border: 1px solid #888;
	border-radius: 3px;
}
#my_modal .modal_close_btn {
    position: absolute;
    top: 10px;
    right: 10px;
}
#modalInput{
	border: 1px solid black;
}
</style>
</head>
<body>
<div class="container">
 <div class="content">
 <%@ include file="../header.jsp" %>
 <div class="subject">
 <b id="header">회원정보변경</b>
 </div>
 <div class="delete">
 	<a id="delete" href="memberDelete">회원탈퇴</a>
 </div>
 <form action="memberUpdate" name="memberUpdate" method="post">
 	<div class="form-grou row">
 		<label class="col-sm-2">아이디:</label>
 		<div class="col-sm-3">
	 		<input type="text" id="id" name="m_id" value="${member.m_id}" readonly> <br>
 		</div>
	 </div>
	 		
	 <div class="form-grou row">
 		<label class="col-sm-2">비밀번호:</label>
 		<div class="col-sm-3">
	 		<input type="password" id="password" name="m_password" value="${member.m_password }" readonly>
 		</div>
 		<div class="col-sm-1">
 			<input type="button" id="popup_open_btn" value="비밀번호변경" >
 		</div>
	 </div>
	 		
	 <div class="form-grou row">
	 	<label class="col-sm-2">이름:</label>
 		<div class="col-sm-3">
	 		<input type="text" id="m_name" name="m_name" value="${member.m_name}" required> <br>
 		</div>
	 </div>
	 		
	 <div class="form-grou row">
 		<label class="col-sm-2">전화번호:</label>
 		<div class="col-sm-3">
			<input type="text" id="phone" name="m_phonenumber" value="${member.m_phonenumber}" readonly> <br>
 		</div>
	 </div>
	 		
	 <div class="form-grou row">
 		<label class="col-sm-2">주소:</label>
 		<div class="col-sm-3">
			<input type="text" name="m_address" value="${member.m_address }" required> <br>
 		</div>
	 </div>
	 		
	 <div class="form-grou row">
 	 	<label class="col-sm-2">이메일:</label>
 		<div class="col-sm-3">
			<input type="text" id="m_email" name="m_email" value="${member.m_email }" required> <br>
 		</div>
	 </div>
	 <input type="submit" value="확인 " onclick="checkForm()">
	 <input type="button" value="취소" onclick="history.back();">
 	 <br><br><br><br>
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
	    
	    <input type="submit" value="확인" onclick="checkPassword()">
	    <input type="button" value="취소" onclick="location.href='modifyForm'">
    </form>
 </div>
 <script>
     function modal(id) {
         var zIndex = 9999;
         var modal = document.getElementById(id);

         // 모달 div 뒤에 희끄무레한 레이어
         var bg = document.createElement('div');
         bg.setStyle({
             position: 'fixed',
             zIndex: zIndex,
             left: '0px',
             top: '0px',
             width: '100%',
             height: '100%',
             overflow: 'auto',
             // 레이어 색갈은 여기서 바꾸면 됨
             backgroundColor: 'rgba(0,0,0,0.4)'
         });
         document.body.append(bg);

         // 닫기 버튼 처리, 시꺼먼 레이어와 모달 div 지우기
         modal.querySelector('.modal_close_btn').addEventListener('click', function() {
             bg.remove();
             modal.style.display = 'none';
         });

         modal.setStyle({
             position: 'fixed',
             display: 'block',
             boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',

             // 시꺼먼 레이어 보다 한칸 위에 보이기
             zIndex: zIndex + 1,

             // div center 정렬
             top: '50%',
             left: '50%',
             transform: 'translate(-50%, -50%)',
             msTransform: 'translate(-50%, -50%)',
             webkitTransform: 'translate(-50%, -50%)'
         });
     }

     // Element 에 style 한번에 오브젝트로 설정하는 함수 추가
     Element.prototype.setStyle = function(styles) {
         for (var k in styles) this.style[k] = styles[k];
         return this;
     };

     document.getElementById('popup_open_btn').addEventListener('click', function() {
         // 모달창 띄우기
         modal('my_modal');
     });
 </script>
 
 
 <%@ include file="../footer.jsp"%>
 </div>
</div>
</body>
</html>