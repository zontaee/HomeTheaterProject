<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
function checkEmail(){
	var m_id = $("#m_id").val();
	var m_email = $("#m_email").val();
	$.ajax({
		url: "checkEmail_Pw",
		type: "POST",
		data: {
			"m_id": m_id,
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
					var m_id = $("#m_id").val();
					var m_email = $("#m_email").val();
					$.ajax({
						url: "sendTempPw",
						type: "GET",
						data: {
							"m_id": m_id,
							"m_email": m_email		
						},
						success: function(){
							alert("임시 비밀번호를 발송했습니다. 메일을 확인해주세요.");
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
</script>
<title>비밀번호 찾기</title>
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
  			<b>FIND PASSWORD</b>	
  			<h6>가입시 기입한 이메일 주소와 입력한 이메일 주소가 같아야, 임시 비밀번호를 받을 수 있습니다.</h6>	
  		</div>
    	<div>
    		<form action="loginForm" name="emailCert">
		    	<br><br>
		    	<b>아이디</b><br>
		    	<input type="text" id="m_id" name="m_id" required><br><br>
		    	<b>이메일 주소</b><br> 
		    	<input type="text" id="m_email" name="m_email" onchange="checkEmail()" required><br>
		    	<b class="emailFind">가입하신 이메일과 같습니다. 발급버튼을 눌러주세요.<br>(시간이 조금 걸릴수도 있습니다. 잠시만 기다려주세요.)</b>
		     	<b class="emailNotFind">가입하신 이메일과 다릅니다. 다시 입력해주세요.</b><br>
		    	<input type="button" id="sendEmail" value="임시 비밀번호 발급"><br>
		    	
		    	<input type="submit" value="확인">
		    	<input type="button" value="취소" onclick="location.href='loginForm'">
	    	</form>
    	</div>
 	<%@ include file="../footer.jsp"%>
 </div>
</div>
</body>
</html>