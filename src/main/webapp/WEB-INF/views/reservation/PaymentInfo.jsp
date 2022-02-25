<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html><html><head><meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>

<title>결제</title>
<style>
.stepBar{
	font-size: 25px;
	text-align: left;
	display: flex;
	background-color: #353535;
	color: white;
	margin-top: 10px;
	margin-bottom: 1px;
}
summary{
	font-size: 18px;
	text-align: left;
	background-color: #BDBDBD;
	color: black;
}
.finalPayment{
	background-color: #BDBDBD;
}
#finalPayment{
	font-size: 15px;
}
.pay{
	display: inline-block;
	width: 700px;
}
.totalPrice{
	display: inline-block;
	width: 200px;
}
.menuBar{
	border: 2px solid black;
	width: 200px;
	height: 50px;
	margin-bottom: 10px;
	font-size: 15px;
}
td{
	border: 1px solid black;
}
</style>
</head>
<body>
<div class="container">
 <div class="content">
  <%@ include file="../header.jsp" %>

  <div class="pay">
	  
	  <br><br><br>
	  	<div><b class="stepBar">STEP 1.</b></div>
	  	<details>
	  		<summary>할인쿠폰</summary>
	  		<div class="finalPayment">
	  			<h4>쿠폰번호를 입력하세요.</h4>
	  			<input type="text" id="coupon" placeholder="xxxx-xxxx-xxxx"><br>
				<input type="button" value="사용하기" onclick="coupon()">
	  		</div>
	  	</details>
	  	<b class="stepBar">STEP 2.</b>
	  	<details>
	  		<summary>포인트 사용</summary>
	  		<div class="finalPayment">
	  			<h4>보유 포인트</h4>
	  			<input type="text" id="userpoint" value="${memberInfo.m_point}" readonly>&emsp;원
	  			<!--  <input type="button" value="조회" onclick="location.href='Payment';">-->
	  			<h4>사용할 포인트</h4>
	  			<input type="text" id="usepoint">&emsp;원<br>
				<input type="button" value="사용하기" onclick="usepoint()">
	  		</div>

	  	</details>
	  <form action="Payment" id="form" method="post">
		  <input type="hidden" name="m_id" value="${memberInfo.m_id}">
		  <input type="hidden" name="se_identify" value="${seatandTime.se_identify}">
		  <input type="hidden" name="se_time" value="${seatandTime.se_time}">
		  <input type="hidden" name="se_date" value="${seatandTime.se_date}">
		  <input type="hidden" name="se_number" value="${seatandTime.se_number}">
		  <input type="hidden" name="mo_number" value="${seatandTime.mo_number}">
		  <input type="hidden" id="pay_totalprice" name="pay_totalprice" value="13000">
		  <input type="hidden" id="m_point"        name="m_point" value="${memberInfo.m_point}">
	  	<b class="stepBar">STEP 3.</b>
	  	<details>
	  		<summary>최종결제수단</summary>
	  		<div class="finalPayment">
		  		<label id="finalPayment"><input type="radio" name="pay_how" value="신용카드" checked onclick="payhow()">신용카드</label>&emsp;&emsp;
		  		<label id="finalPayment"><input type="radio" name="pay_how" value="휴대폰결제" onclick="payhow()">휴대폰 결제</label>&emsp;&emsp;
		  		<label id="finalPayment"><input type="radio" name="pay_how" value="계좌이체" onclick="payhow()">계좌이체</label>&emsp;&emsp;
		  		<label id="finalPayment"><input type="radio" name="pay_how" value="간편결제" onclick="payhow()">간편결제</label>&emsp;&emsp;
		  		<label id="finalPayment"><input type="radio" name="pay_how" value="내통장결제" onclick="payhow()">내통장결제</label>&emsp;&emsp;
		  		<label id="finalPayment"><input type="radio" name="pay_how" value="토스" onclick="payhow()">토스</label>&emsp;&emsp;
	  		</div>
	  	</details>
	  	</div>
	  	
	  	<div class="totalPrice">
	  		<table class="menuBar">
	  			<thead>
	  			<tr>
		   			<td>결제하실 금액</td>
	   			</tr>
	   			</thead>
	   			<tbody>
	   			<tr>
	   				<td id="nowamount">13000</td>
	   			</tr>
	   			</tbody>
	  		</table>
	  		<table class="menuBar">
	  			<tr>
		   			<td id="sub">할인내역</td>
	   			</tr>
	   			<tr>
	   				<td>총 할인금액</td>
	   			</tr>
	   			<tr>
	   				<td id="dicountamount">0</td>
	   			</tr>
	  		</table>

	  		<input type="button" class="btn btn-outline-secondary" value="결제하기"
				   onclick="iamport('${memberInfo.m_id}','${memberInfo.m_address}','${memberInfo.m_email}','${memberInfo.m_phonenumber}')">
	  	</div>
	  	
	  <%@ include file="../footer.jsp"%> 
  </form>
 </div>
</div>
<script type="text/javascript" src="js/reservation/payment.js"></script>
</body>
</html>