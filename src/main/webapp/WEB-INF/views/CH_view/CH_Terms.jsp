<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<script>
function selectAll(selectAll)  {
	  const checkboxes 
	     = document.querySelectorAll('input[type="checkbox"]');
	 	checkboxes.forEach((checkbox) => {
	    checkbox.checked = selectAll.checked
	  })
	}
</script>
<title>이용약관</title>
<style>
.agree_form{
	font-size: 17px;
	margin-top: 30px;
	background-color: #F6F6F6;
}
textarea{
	height: 100px;
	width: 700px;
}
</style>
</head>
<body>
<div class="container">
 <div class="content">
 	<%@ include file="../header.jsp" %>
	<form name="agreement" class="form-horizontal" action="joinMember" method="get" > 
		<div class="container">
			<div class="agree_form">
				&emsp;&emsp;&emsp;&emsp;<input type="checkbox" name="check" onclick="selectAll(this)">&nbsp;이용약관, 개인정보 수집 및 이용, 위치정보 이용약관(선택), 프로모션 정보 수신(선택)에 모두 동의합니다. [전체동의]<hr>
				&emsp;&emsp;&emsp;&emsp;<input type="checkbox" name="check2" required>&nbsp;HomeTheater 이용약관 동의 [필수]<br>	
				<div class="text-center">
				<textarea style="resize: none;" rows="5" cols="120" readonly>	
 여러분을 환영합니다. HomeTheater 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 HomeTheater 서비스의 이용과 관련하여 HomeTheater 서비스를 제공하는 HomeTheater 주식회사(이하 ‘HomeTheater’)와 이를 이용하는 HomeTheater 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 HomeTheater 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
				</textarea><br><br></div>
				&emsp;&emsp;&emsp;&emsp;<input type="checkbox" name="check3" required>&nbsp;개인정보 수집 및 이용 동의 [필수]<br>
				<div class="text-center">
				<textarea style="resize: none;" rows="5" cols="120" readonly>	
 개인정보보호법에 따라 HomeTheater에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.			

1. 수집하는 개인정보
이용자는 회원가입을 하지 않아도 정보 검색, 뉴스 보기 등 대부분의 HomeTheater 서비스를 회원과 동일하게 이용할 수 있습니다. 이용자가 메일, 캘린더, 카페, 블로그 등과 같이 개인화 혹은 회원제 서비스를 이용하기 위해 회원가입을 할 경우, HomeTheater는 서비스 이용을 위해 필요한 최소한의 개인정보를 수집합니다.
				</textarea><br><br></div>
				&emsp;&emsp;&emsp;&emsp;<input type="checkbox" name="check4" >&nbsp;위치정보 이용약관 동의 [선택]<br>
				<div class="text-center">
				<textarea style="resize: none;" rows="5" cols="120" readonly>	
 위치정보 이용약관에 동의하시면, 위치를 활용한 광고 정보 수신 등을 포함하는 HomeTheater 위치기반 서비스를 이용할 수 있습니다.

제 1 조 (목적)
이 약관은 HomeTheater 주식회사 (이하 “회사”)가 제공하는 위치정보사업 또는 위치기반서비스사업과 관련하여 회사와 개인위치정보주체와의 권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.
				</textarea><br><br></div>
				&emsp;&emsp;&emsp;&emsp;<input type="checkbox" name="check5">&nbsp;프로모션 정보 수신 동의 [선택]<br>
				<p style="width: 700px; height: 100px; display: inline-block;">
HomeTheater에서 제공하는 이벤트/혜택 등 다양한 정보를 휴대전화(HomeTheater앱 알림 또는 문자), 이메일로 받아보실 수 있습니다. 일부 서비스>(별도 회원체계로 운영하거나 HomeTheater 가입 이후 추가 가입하여 이용하는 서비스 등)의 경우, 개별 서비스에 대해 별도 수신 동의를 받을 수 있으며, 이때에도 수신 동의에 대해 별도로안내하고 동의를 받습니다.
				</p><br><br>
				<div class="text-center">
					<input type="button" value="취소" onclick="history.back();">
					<input type="submit" value="확인">
				</div>
			</div>	
		</div>
	</form>
 	<%@ include file="../footer.jsp"%>
 </div>
</div>
</body>
</html>