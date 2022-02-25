const addhidden = document.getElementById("form");
const newp = document.createElement("p");
const newp2 = document.createElement("h2");
const newp3 = document.createElement("p");
let discountratio = 1;
let discountsum = 0;   //할인 총합 계산
let nowamount = document.getElementById("nowamount").innerText;
let count = 0; //쿠폰은 하나만 등록하기 위한 카운팅
let pay_totalprice = document.getElementById("pay_totalprice");
let m_point = document.getElementById("m_point");


//쿠폰 번호입력시 10프로 할인 함수
const coupon = () => {
    //쿠폰번호 검증 로직
    let couponNumber = document.getElementById("coupon").value;
    if (couponNumber == "1111-1111-1111") {
        if (count == 0) {
            discountratio = 0.1;  //할인비율 10프로
            discountsum = nowamount * discountratio;    //할인 총합 계산
            nowamount -= discountsum;
            document.getElementById("nowamount").innerText = nowamount; //할인 반영 금액
            document.getElementById("dicountamount").innerText = discountsum; // 총 할인 금액
            count = count + 1;
            pay_totalprice.setAttribute("value", nowamount);
            alert("쿠폰 등록 완료")
        } else {
            alert("쿠폰은 하나만 등록 가능합니다.")
        }
    } else {
        alert("쿠폰번호를 확인해주세요.")
    }
}
//유저 포인트 사용 함수
const usepoint = () => {

    if (!document.getElementById("usepoint").value) {
        alert("사용 포인트를 올바르게 적어주세요");
    } else {
        let userpoint = parseInt(document.getElementById("userpoint").value);
        let usepoint = parseInt(document.getElementById("usepoint").value);
        let remainpoint = userpoint - usepoint;
        //포인트 사용한 할인 반영 금액
        if (usepoint > userpoint) {
            alert("사용 포인트를 올바르게 적어주세요");
        } else {

            nowamount -= usepoint;
            document.getElementById("nowamount").innerText = nowamount;
            //총 할인 금액
            discountsum += usepoint;
            document.getElementById("dicountamount").innerText = discountsum;
            pay_totalprice.setAttribute("value", nowamount);
            m_point.setAttribute("value", remainpoint);

            alert("포인트 사용 완료")

        }
    }
}

    function iamport(id,address,email,phonenumber){
    //const{IMP} = window;
    //가맹점 식별코드
    IMP.init('imp03662835');
    IMP.request_pay({
    pg : 'html5_inicis',
    pay_method : 'card',
    merchant_uid : 'merchant_' + new Date().getTime(),
    name : '티켓' , //결제창에서 보여질 이름
    amount : 100, //실제 결제되는 가격
    buyer_email : email,
    buyer_name : id,
    buyer_tel : phonenumber,
    buyer_addr : address,
    buyer_postcode : '123-456'
}, function(rsp) {
    console.log(rsp);
    if ( rsp.success ) {
    var msg = '결제가 완료되었습니다. 감사합니다';
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


