<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<script>
function checkEmail(){
	var m_phonenumber = $("#m_phonenumber").val();
	var m_email = $("#m_email").val();
	$.ajax({
		url: "checkEmail_Id",
		type: "POST",
		data: {
			"m_phonenumber": m_phonenumber,
			"m_email": m_email
		},
		success: function(result){
			if(result != m_email){
				$(".emailFind").css("display", "none");
				$(".emailNotFind").css("display", "inline-block");
				document.emailCert.m_email.focus();
				document.emailCert.m_email.value="";
			}else{
				$(".emailFind").css("display", "inline-block");
				$(".emailNotFind").css("display", "none");
				// 버튼 클릭시 실행
				$("#sendEmail").click(function(){
					var m_phonenumber = $("#m_phonenumber").val();
					var m_email = $("#m_email").val();
					var m_name = $("#m_name").val();
					$.ajax({
						url: "sendAuthenticationNum",
						type: "GET",
						data: {
							"m_phonenumber": m_phonenumber,
							"m_email": m_email,
							"m_name": m_name
						},
						success: function(randomPw){
							alert("인증번호를 발송했습니다. 메일을 확인해주세요.");
							document.emailCert.num.value=randomPw;
						}
					}) // ajax 끝
				}) // click function 끝
			} 
		},
		error: function(){
			alert("에러입니다");
		}
	})
}

// 인증번호 확인하기
function checkNum(){
	var inputNum = $("#inputNum").val();
	var num = $("#num").val();
	var m_phonenumber = $("#m_phonenumber").val();
	$.ajax({
		url: "checkNum",
		type: "GET",
		data: {
			"inputNum": inputNum,
			"num": num,
			"m_phonenumber": m_phonenumber
		},
		success: function(id){
			if(id!=""){
				alert("인증성공! 회원님의 아이디는: [" + id + "]입니다.");
	
			}else{
				alert("인증실패");
				document.emailCert.inputNum.focus();
				document.emailCert.inputNum.value="";
			}
		}
		})
}
</script>
<title>아이디 찾기</title>
<style>
.emailFind{
	color: black;
	display: none;
}
.emailNotFind{
	color: red;
	display: none;
}
</style>
</head>
<body>
<div class="container">
 <div class="content">
 	<%@ include file="../header.jsp" %>
 		<div class="subject">
 			<b>FIND ID</b>
 			<h6>가입시 기입한 이메일 주소와 입력한 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.</h6>
 		</div>
 		<div>
 			<form action="forward:/checkNum" name="emailCert">
 				<br><br>
 				<b>핸드폰 번호</b><br>
 				<input type="text" id="m_phonenumber" placeholder="ex) 010-1234-5678" required><br>
 				<b>이메일 주소</b><br>
 				<input type="text" id="m_email" onchange="checkEmail()" required><br>
 				<b class="emailFind">가입하신 이메일과 같습니다. 발급버튼을 눌러주세요.<br>(시간이 조금 걸릴수도 있습니다. 잠시만 기다려주세요.)</b>
		    	<b class="emailNotFind">가입하신 이메일과 다릅니다. 다시 입력해주세요.</b><br>
 				<input type="button" id="sendEmail" value="인증번호 발급"><br>
 				<input type="text" id="inputNum" placeholder="인증번호 6자리를 입력해주세요." required><br>
 				<input type="hidden" id="num" value="null">
 				<input type="submit" value="확인" onclick="checkNum()">
		    	<input type="button" value="취소" onclick="location.href='loginForm'">
 			</form>
 		</div>
 	
 	
 	<%@ include file="../footer.jsp"%>
 </div>
</div>
</body>
</html>