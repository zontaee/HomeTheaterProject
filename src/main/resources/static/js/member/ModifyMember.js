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
		document.changePassword.m_newPassword.value="";
		document.changePassword.m_newPasswordConfirm.value="";
		document.changePassword.m_newPassword.focus();
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