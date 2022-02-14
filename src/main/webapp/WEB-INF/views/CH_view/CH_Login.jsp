<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>로그인</title>
<style>
.subject{
	text-align: center;
	margin-top: 50px;
	margin-bottom: 30px;
}
.loginForm{
	border: 2px solid black;
	width: 300px;
	height: 200px;
	display: inline-block;
	text-align: center;
}
b{
	font-size: 25px;
}
#subject{
	font-size: 12px;
}
#idPw{
	font-size: 15px;
}
.subForm{
	font-size: 10px;
}
</style>
</head>
<body>
<div class="container">
 <div class="content">
  <%@ include file="../header.jsp" %>
  	<div class="subject">
  		<b>LOGIN</b>		
  	</div>
    <div class="loginForm">
    	<form action="login" method="post">
	    	<br><br>
	    	<b id="idPw">아이디</b><br>
	    	<input type="text" id="m_id" name="m_id" placeholder="ID"><br><br>
	    	<b id="idPw">비밀번호</b><br>
	    	<input type="password" id="m_password" name="m_password" placeholder="PASSWORD"><br><br>
	    	<input type="submit" value="로그인">
    	</form>
    </div>
    <div class="subForm">
    	<br>
    	<a href="terms">회원가입 |</a>
    	<a href="findIdForm">아이디찾기 |</a>
    	<a href="findPwForm">비밀번호찾기</a>
    </div>
    
    <!-- 아이디 비밀번호 오류메시지 출력 -->
    <c:if test="${not empty loginMessage}">
    	<p style="color: red">
    	Warning!<br>
    	${loginMessage}
    	<br></p>
    </c:if>
  
  <%@ include file="../footer.jsp"%>
 </div>
</div>
</body>
</html>