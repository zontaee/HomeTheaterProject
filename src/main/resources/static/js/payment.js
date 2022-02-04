const addhidden = document.getElementById("form");
const newp =document.createElement("p");
const newp2 =document.createElement("h2");
const newp3 =document.createElement("p");
let discountratio=1;
let discountsum =0;   //할인 총합 계산
let nowamount = document.getElementById("nowamount").innerText;
let count = 0; //쿠폰은 하나만 등록
//쿠폰 번호입력시 10프로 할인 함수
const coupon = () => {

    let couponNumber  = document.getElementById("coupon").value;
    if(couponNumber == "1111-1111-1111"){
        if(count == 0) {
            discountratio = 0.1;  //할인비율 10프로
            discountsum = nowamount * discountratio;    //할인 총합 계산
            nowamount -= discountsum;
            document.getElementById("nowamount").innerText = nowamount; //할인 반영 금액
            document.getElementById("dicountamount").innerText = discountsum; // 총 할인 금액
            count = count + 1;
            alert("쿠폰 등록 완료")
        }else{
            alert("쿠폰은 하나만 등록 가능합니다.")
        }
    }else {
        alert("쿠폰번호를 확인해주세요.")
    }
}
//유저 포인트 사용 함수
const usepoint =() =>{
    let userpoint       = parseInt(document.getElementById("userpoint").value);
    let usepoint        = parseInt(document.getElementById("usepoint").value);
    let remainpoint     = userpoint - usepoint;
    //포인트 사용한 할인 반영 금액
    if(usepoint>userpoint){
        alert("사용 포인트를 올바르게 적어주세요")
    }else {
        alert("포인트 사용 완료")
        nowamount -= usepoint;
        document.getElementById("nowamount").innerText = nowamount;
        //총 할인 금액
        discountsum += usepoint;
        document.getElementById("dicountamount").innerText = discountsum;
        newp.innerHTML = "<input type='hidden' name = 'pay_totalprice' value='"+nowamount+"'>";
        newp2.innerText = "히든태그 잘되는지 확인하는 문구입니다."
        newp3.innerHTML = "<input type='hidden' name = 'm_point' value='"+remainpoint+"'>";
        addhidden.appendChild(newp);
        addhidden.appendChild(newp2);
        addhidden.appendChild(newp3);

    }

}
const payhow = () =>{

}
