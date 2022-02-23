<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<link rel="stylesheet" href="css/CH_css/CH_FindId.css">
<title>아이디 찾기</title>
</head>
<body>
<div class="container">
 <div class="content">
 	<%@ include file="../header.jsp" %>
 		<div class="subject">
 			<b id="subject">FIND ID</b><br>
 			<h6>(가입시 기입한 이메일 주소와 입력한 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.)</h6>
 		</div>
 		<div class="findIdForm">
 			<form action="forward:/checkNum" name="emailCert">
 				<br><br>
 				<b id="inputTag">핸드폰 번호</b><br>
 				<input type="text" id="m_phonenumber" placeholder="ex) 010-1234-5678" required><br><br>
 				<b id="inputTag">이메일 주소</b><br>
 				<input type="text" id="m_email" onchange="checkEmail()" required>
 				<b class="emailFind">가입하신 이메일과 같습니다. 발급버튼을 눌러주세요.<br>(시간이 조금 걸릴수도 있습니다. 잠시만 기다려주세요.)</b>
		    	<b class="emailNotFind">가입하신 이메일과 다릅니다. 다시 입력해주세요.</b><br>
 				<input type="button" id="sendEmail" value="인증번호 발급"><br>
 				<input type="text" id="inputNum" placeholder="인증번호 6자리를 입력해주세요." required><br><br>
 				<input type="hidden" id="num" value="null">
 				<input type="submit" class="btn" value="확인" style="font-weight: bold;" onclick="checkNum()">
		    	<input type="button" class="btn" value="취소" style="font-weight: bold;" onclick="location.href='loginForm'">
 			</form>
 		</div>
 	<%@ include file="../footer.jsp"%>
 </div>
</div>
<script type="text/javascript" src="js/CH_js/CH_FindId.js"></script>
</body>
</html>