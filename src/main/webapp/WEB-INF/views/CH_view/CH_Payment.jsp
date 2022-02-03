<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html><html><head><meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
function iamport(){
	//const{IMP} = window;
	//가맹점 식별코드
	IMP.init('imp03662835');
	IMP.request_pay({
	    pg : 'html5_inicis',
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : '상품1' , //결제창에서 보여질 이름
	    amount : 0, //실제 결제되는 가격
	    buyer_email : 'iamport@siot.do',
	    buyer_name : '홍길동',
	    buyer_tel : '010-1234-5678',
	    buyer_addr : '서울 강남구 도곡동',
	    buyer_postcode : '123-456'
	}, function(rsp) {
		console.log(rsp);
	    if ( rsp.success ) {
	    	var msg = '결제가 완료되었습니다.';
	        msg += '고유ID : ' + rsp.imp_uid;
	        msg += '상점 거래ID : ' + rsp.merchant_uid;
	        msg += '결제 금액 : ' + rsp.paid_amount;
	        msg += '카드 승인번호 : ' + rsp.apply_num;
	    } else {
	    	 var msg = '결제에 실패하였습니다.';
	         msg += '에러내용 : ' + rsp.error_msg;
	    }
	    alert(msg);
	});
}

</script>
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
  <form action="Payment">
  <div class="pay">
	  
	  <br><br><br>
	  	<div><b class="stepBar">STEP 1.</b></div>
	  	<details>
	  		<summary>할인쿠폰</summary>
	  		<div class="finalPayment">
	  			<h4>쿠폰번호를 입력하세요.</h4>
	  			<input type="text" placeholder="xxxx-xxxx-xxxx"><br>
	  		</div>
	  	</details>
	  	<b class="stepBar">STEP 2.</b>
	  	<details>
	  		<summary>포인트 사용</summary>
	  		<div class="finalPayment">
	  			<h4>보유 포인트</h4>
	  			<input type="text" value="" readonly>&emsp;원
	  			<!--  <input type="button" value="조회" onclick="location.href='Payment';">-->
	  			<h4>사용할 포인트</h4>
	  			<input type="text">&emsp;원<br>
	  			<br><label><input type="checkbox">모두사용</label>
	  		</div>
	  	</details>
	  	<b class="stepBar">STEP 3.</b>
	  	<details>
	  		<summary>최종결제수단</summary>
	  		<div class="finalPayment">
		  		<label id="finalPayment"><input type="radio" name="payMethod" checked>신용카드</label>&emsp;&emsp;
		  		<label id="finalPayment"><input type="radio" name="payMethod">휴대폰 결제</label>&emsp;&emsp;
		  		<label id="finalPayment"><input type="radio" name="payMethod">계좌이체</label>&emsp;&emsp;
		  		<label id="finalPayment"><input type="radio" name="payMethod">간편결제</label>&emsp;&emsp;
		  		<label id="finalPayment"><input type="radio" name="payMethod">내통장결제</label>&emsp;&emsp;
		  		<label id="finalPayment"><input type="radio" name="payMethod">토스</label>&emsp;&emsp;
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
	   				<td>($결제하실 금액)</td>
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
	   				<td>($총 할인금액)</td>
	   			</tr>
	  		</table>
	  		<table class="menuBar">
	  			<tr>
		   			<td>결제내역</td>
	   			</tr>
	   			<tr>
	   				<td>($결제수단 $결제금액)</td>
	   			</tr>
	   			<tr>
	   				<td>남은 결제금액</td>
	   			</tr>
	   			<tr>
	   				<td>($남은 결제금액)</td>
	   			</tr>
	  		</table>
	  		<input type="button" value="결제하기" onclick="iamport();">
	  	</div>
	  	
	  <%@ include file="../footer.jsp"%> 
  </form>
 </div>
</div>

</body>
</html>