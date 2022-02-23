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