<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<link rel="stylesheet" href="css/CH_css/CH_JoinMember.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>회원가입</title>
</head>
<body>
<div class="container">
 <div class="content">
  <%@ include file="../header.jsp"%>
  	<div class="subject">
  	<b id="header">회원가입</b>
  	</div><hr>
  	<div class="loginForm">
	 	<form name="newMember" action="<%=context%>/joinMember/save" method="post">
	 		<br>
	 		<div class="form-grou row">
		 		<label class="col-sm-2"><b>아이디</b></label>
		 		<div class="col-sm-5">
			 		<input type="text" id="m_id" name="m_id" placeholder="id" required onchange="checkId()"><br><br>
		 		</div>
		 		<span class="id_already">*이미 존재하는 아이디입니다.</span>
		 		<span class="id_available">*영문 소문자 또는 영문 소문자,숫자 조합 (4~20자)</span>
	 		</div>
	 		<div class="form-grou row">
		 		<label class="col-sm-2"><b>비밀번호</b></label>
		 		<div class="col-sm-5">
			 		<input type="password" id="m_password" name="m_password" placeholder="password" required><br><br>
		 		</div>
		 		<span class="validation">*숫자,대문자,소문자,특수문자를 모두 조합 (8~16자)</span>
	 		</div>
	 		
	 		<div class="form-grou row">
		 		<label class="col-sm-2"><b>비밀번호 확인</b></label>
		 		<div class="col-sm-5">
			 		<input type="password" name="m_passwordConfirm" placeholder="passwordConfirm" required><br><br>
		 		</div>
	 		</div>
	 		
	 		<div class="form-grou row">
		 		<label class="col-sm-2"><b>이름</b></label>
		 		<div class="col-sm-5">
			 		<input type="text" id="m_name" name="m_name" placeholder="name" required><br><br>
		 		</div>
	 		</div>
	 		
	 		<div class="form-grou row">
		 		<label class="col-sm-2"><b>전화번호</b></label>
		 		<div class="col-sm-5">
					<select id="phone1" name="phone1" style="height: 20px;" required>
		              <option value="010" selected>010</option>
		              <option value="011">011</option>
		              <option value="016">016</option>
		              <option value="017">017</option>
		              <option value="019">019</option>
		           </select>
				- <input id="phone2" maxlength="4" size="4" name="phone2" required> -
				<input id="phone3" maxlength="4" size="4" name="phone3" onchange="checkPhone()" required><br><br>
		 		</div>
		 		<span class="phone_already">*이미 사용중인 핸드폰 번호입니다.</span>
	 		</div>
	 		
	 		<div class="form-grou row">
				<label class="col-sm-2"><b>우편번호</b></label>
				<div class="col-sm-5">
		            <input name="zipcode" id="zipcode" type="text" placeholder="zipcode" required>
		            <input type="button" onclick="Postcode()" value="우편번호 찾기"><br><br>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><b>도로명주소</b></label>
			    <div class="col-sm-5">
			        <input name="roadAddress" id="roadAddress"  type="text" placeholder="roadAddress" required><br>
			    </div>
			</div>
			<div class="form-group row">
			    <label class="col-sm-2"><b>지번주소</b></label>
			    <div class="col-sm-5">
			        <input name="jibunAddress" id="jibunAddress"  type="text" placeholder="jibunAddress" required><br>
			    </div>
			</div>
			<span id="guide" style="color:#6A82FB;display:none"></span>
			<div class="form-group row">
			    <label class="col-sm-2"><b>상세주소</b></label>
			    <div class="col-sm-5">
			        <input name="detailAddress"  id="detailAddress" type="text" placeholder="detailAddress" required><br>
			    </div>
			</div>
			<div class="form-group row">
			    <label class="col-sm-2"><b>참고항목</b></label>
			    <div class="col-sm-5">
			        <input name="extraAddress"id="extraAddress" type="text" placeholder="extraAddress" ><br>
			    </div>
			</div>
	 		<div class="form-grou row">
		 		<label class="col-sm-2"><b>이메일</b></label>
		 		<div class="col-sm-5">
			 		<input type="text" id="mail1" name="mail1" maxlength="50" required>@
	                <input type="text" id="mail2" name="mail2" maxlength="50" required>
	                 <select name="mail2_select" onchange="selectDomain(this)" style="height: 20px;">
	                    <option disabled="disabled" selected="selected">선택</option>
	                    <option>naver.com</option>
	                    <option>daum.net</option>
	                    <option>gmail.com</option>
	                    <option>nate.com</option>
	                    <option value="">직접입력</option>
	                </select>
		 		</div>
	 		</div>
	 		<br><br>
	 		 
	 		<input class="btn" type="submit" id="reg_submit" value="확인" style="font-weight: bold;">
	 		<input class="btn" type="button" value="취소" style="font-weight: bold;" onclick="history.back()">
	 	</form>
 	</div>
  <%@ include file="../footer.jsp"%>	
 </div>
</div>
<script type="text/javascript" src="js/CH_js/CH_JoinMember.js"></script>
</body>
</html>