function checkEmail(){
	var memberId = $("#memberId").val();
	var memberEmail = $("#memberEmail").val();
	$.ajax({
		url: "checkEmail_Pw",
		type: "POST",
		data: {
			"memberId": memberId,
			"memberEmail": memberEmail
		},
		success: function(result){
			if(result != memberEmail){
				$(".emailFind").css("display", "none");
				$(".emailNotFind").css("display", "inline-block");
				document.emailCert.memberEmail.focus();
				document.emailCert.memberEmail.value="";
			}else{
				$(".emailFind").css("display", "inline-block");
				$(".emailNotFind").css("display", "none");
				// 버튼 클릭시 실행
				$("#sendEmail").click(function(){
					var memberId = $("#memberId").val();
					var memberEmail = $("#memberEmail").val();
					$.ajax({
						url: "sendTempPw",
						type: "GET",
						data: {
							"memberId": memberId,
							"memberEmail": memberEmail		
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