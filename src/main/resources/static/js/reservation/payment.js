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
        var lastPayPrice = $("#nowamount").text();
        var m_id = $("#m_id").val();
        var se_identify = $("#se_identify").val();
        var se_time = $("#se_time").val();
        var se_date = $("#se_date").val();
        var se_number = $("#se_number").val();
        var mo_number = $("#mo_number").val();
        var pay_totalprice = $("#pay_totalprice").val();
        var m_point = $("#m_point").val();
        var pay_how = $("#pay_how").val();
        //가맹점 식별코드
        IMP.init('imp03662835');
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : id , //결제창에서 보여질 이름
            amount : 100, //실제 결제되는 가격
            buyer_email : email,
            buyer_name : id,
            buyer_tel : phonenumber,
            buyer_addr : address,
            buyer_postcode : '123-456',
            /* 	    m_redirect_url: 'Payment' */
        }, function(rsp) {
            if (rsp.success ) {
                var msg = '결제가 완료되었습니다.';
                $.ajax({
                    url: "Payment",
                    type: "POST",
                    data: {
                        "m_id": m_id,
                        "se_identify": se_identify,
                        "se_time": se_time,
                        "se_date": se_date,
                        "se_number": se_number,
                        "mo_number": mo_number,
                        "pay_totalprice": pay_totalprice,
                        "m_point": m_point,
                        "pay_how": pay_how
                    },
                    success: function(re_number){
                        location.href="PaymentResult?re_number="+re_number;
                    }
                })
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
            }
            alert(msg);
        });
    }


