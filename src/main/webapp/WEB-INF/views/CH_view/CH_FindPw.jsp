<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<link rel="stylesheet" href="css/CH_css/CH_FindPw.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>비밀번호 찾기</title>
</head>
<body>
<div class="container">
 <div class="content">
 	<%@ include file="../header.jsp" %>
  		<div class="subject">
  			<b id="subject">FIND PASSWORD</b><br>	
  			<h6>(가입시 기입한 이메일 주소와 입력한 이메일 주소가 같아야, 임시 비밀번호를 받을 수 있습니다.)</h6>	
  		</div>
    	<div class="findPwForm">
    		<form action="loginForm" name="emailCert">
		    	<br><br>
		    	<b id="inputTag">아이디</b><br>
		    	<input type="text" id="m_id" name="m_id" required><br><br>
		    	<b id="inputTag">이메일 주소</b><br> 
		    	<input type="text" id="m_email" name="m_email" onchange="checkEmail()" required><br>
		    	<b class="emailFind">가입하신 이메일과 같습니다. 발급버튼을 눌러주세요.<br>(시간이 조금 걸릴수도 있습니다. 잠시만 기다려주세요.)</b>
		     	<b class="emailNotFind">가입하신 이메일과 다릅니다. 다시 입력해주세요.</b>
		    	<input type="button" id="sendEmail" value="임시 비밀번호 발급"><br><br>
		    	<input type="submit" class="btn" value="확인" style="font-weight: bold;">
		    	<input type="button" class="btn" value="취소" style="font-weight: bold;" onclick="location.href='loginForm'">
	    	</form>
    	</div>
 	<%@ include file="../footer.jsp"%>
 </div>
</div>
<script type="text/javascript" src="js/CH_js/CH_FindPw.js"></script>
</body>
</html>