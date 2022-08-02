<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<link rel="stylesheet" href="css/member_css/MemberLogin.css">
<title>로그인</title>
</head>
<body>
<div class="container">
 <div class="content">
  <%@ include file="../header.jsp" %>
  	<div class="subject">
  		<b id="subject">LOGIN</b>		
  	</div>
    <div class="loginForm">
    	<form action="login" method="post">
	    	<br><br>
	    	<b id="idPw">아이디</b><br>
	    	<input type="text" id="m_id" name="m_id" placeholder="ID"><br><br>
	    	<b id="idPw">비밀번호</b><br>
	    	<input type="password" id="m_password" name="m_password" placeholder="PASSWORD"><br><br>
	    	<input class="btn" type="submit" value="로그인" style="font-weight: bold;">
    	</form>
    	<!-- 아이디 비밀번호 오류메시지 출력 -->
    <c:if test="${not empty loginMessage}">
    	<p style="color: red">
    	<i class="fas fa-thin fa-bullhorn" style="font-size: 15px;"></i> ${loginMessage}
    	<br></p>
    </c:if>
    </div>
    <div>
    	<br>
    	<a id="subForm" href="terms"><b>회원가입 |</b></a>
    	<a id="subForm" href="findIdForm"><b>아이디찾기 |</b></a>
    	<a id="subForm" href="findPwForm"><b>비밀번호찾기</b></a>
    </div>
    
    
  
  <%@ include file="../footer.jsp"%>
 </div>
</div>
</body>
</html>