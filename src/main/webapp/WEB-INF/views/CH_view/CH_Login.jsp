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
	#subject{
		font-size: 25px;
	}
	.loginForm{
		border: 2px solid black;
		width: 300px;
		height: 200px;
		display: inline-block;
		text-align: center;
	}
	#idPw{
		font-size: 15px;
	}
	#subForm{
		font-size: 10px;
	}
	.btn{
		border: 1px solid white;
		width: 160px;
		height: 27px;
	}
</style>
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
		</div>
		<div>
			<br>
			<a id="subForm" href="terms"><b>회원가입 |</b></a>
			<a id="subForm" href="findIdForm"><b>아이디찾기 |</b></a>
			<a id="subForm" href="findPwForm"><b>비밀번호찾기</b></a>
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