// 이메일 입력
function selectDomain(obj){
	document.newMember.mail2.value=obj.value;
	if(obj.value=="") document.newMember.mail2.focus();
}

// input값의 빈칸여부와 정규식 검증
$(function(){
	$("input[type=submit]").click(function(){
		var result = $.trim($("input[type=text]").val());
		if(result!=null){
			if(document.newMember.m_password.value!=document.newMember.m_passwordConfirm.value){
				alert("비밀번호와 비밀번호 확인 값이 다릅니다!");
				document.newMember.m_password.value="";
				document.newMember.m_passwordConfirm.value="";
				document.newMember.m_password.focus();
				return false;
			}
		 	var regId = /^[a-z]+[a-z0-9]{3,19}$/g; // 영문소문자로 시작하고, 영문소문자 + 4~20자 
			var regPw = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$/; // 영어 대문자,소문자,숫자,특수문자모두 포함 + 8~16자 
			var regName = /^[가-힣]*$/; // 한글만 사용
			var regPhone = /^\d{3}-\d{3,4}-\d{4}$/; // 숫자3자리 + 숫자 3~4자리 + 숫자 4자리
			var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
			var id = $("#m_id").val();
			var pw = $("#m_password").val();
			var name = $("#m_name").val();
			var phone = $("#phone1").val() + "-" + $("#phone2").val() + "-" + $("#phone3").val();
			var email = $("#mail1").val() + "@" + $("#mail2").val();
			
			if(!regId.test(id)){
				alert("아이디는 영문 소문자로 시작하고 4~20자, 영문 소문자 또는 숫자만 입력가능합니다.");
				$("#m_id").focus();
				$("#m_id").value="";
				event.preventDefault();
			}else if(!regPw.test(pw)){		
				alert("비밀번호는 8~16자, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.");
				$("#m_password").focus();
				$("#m_password").value="";
				event.preventDefault();
			}else if(!regName.test(name)){
				alert("이름은 한글만 입력가능합니다.");
				$("#m_name").focus();
				$("#m_name").value="";
				event.preventDefault();
			}else if(!regPhone.test(phone)){
				alert("전화번호는 숫자만 입력가능합니다.");
				$("#phone1").focus();
				$("#phone1").value="";
				event.preventDefault();
			}else if(!regEmail.test(email)){
				alert("이메일 입력을 확인해주십시오.");
				$("#mail1").focus();
				$("#mail1").value="";
				event.preventDefault();
			}else{
				alert("회원가입을 축하합니다!!");
			}
		}
	})
})

// id중복체크 ajax
function checkId(){
    var m_id = $("#m_id").val();
	$.ajax({
	    url: "idCheck",
	    type: "POST",
	    data: {"m_id": m_id},
	    success: function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다 
	        if(cnt != 1){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디 
	        	 $(".id_already").css("display", "none");
	             $(".id_available").css("display", "inline-block");
	        } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
	        	$(".id_already").css("display","inline-block");
	            $(".id_available").css("display", "none");
	        	document.newMember.m_id.focus();
	            document.newMember.m_id.value="";
	        }
	    },
	    error:function(){
	        alert("에러입니다");
	    }
	})
}
// phonenumber중복체크 ajax
function checkPhone(){
	var phone1 = $("#phone1").val();
	var phone2 = $("#phone2").val();
	var phone3 = $("#phone3").val();
	$.ajax({
		url: "emailCheck",
		type: "POST",
		data: {
			"phone1": phone1,
			"phone2": phone2,
			"phone3": phone3
		},
		success: function(cnt){
			if(cnt == 0){
				$(".phone_already").css("display", "none");
			}else{
				$(".phone_already").css("display", "inline-block");
				document.newMember.phone2.focus();
				document.newMember.phone2.value="";
				document.newMember.phone3.value="";
			}
		},
		error:function(){
	        alert("에러입니다");
	    }
	})
}

// daum주소 api 
function Postcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zipcode').value = data.zonecode;
            document.getElementById("roadAddress").value = roadAddr;
            document.getElementById("jibunAddress").value = data.jibunAddress;
            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("extraAddress").value = '';
            }
            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';
            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
        }
    }).open();
}