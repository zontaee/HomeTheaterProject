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