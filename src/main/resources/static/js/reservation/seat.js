let count = 0;
const addhidden = document.getElementById("seatcontainer");
const newp1 = document.createElement("p");
const newp2 = document.createElement("p");


function getSeat(se_number) {
    //하나의 좌석만 선택 가능하도록 하는 로직
    if (count > 0) {
        alert("좌석은 하나만 선택 가능합니다.");
        return;
    }
    alert("당신이 선택한 좌석은 ->" + se_number + "입니다.");
    count = count + 1;

    //예매할 좌석을 클릭했을때 색상변화를 주기위한 코드
    let senumber = document.getElementById(se_number);
    senumber.setAttribute("class", "reservationingdseat");
    //결제페이지로 넘어갈때 좌석정보를 히든태그로 보내기위한 히든테그 생성자바스크립트
    newp1.innerHTML = "<input type='hidden' name = 'se_identify' value='T'>";
    newp2.innerHTML = "<input type='hidden' name = 'se_number' value='" + se_number + "'>";
    addhidden.appendChild(newp1);
    addhidden.appendChild(newp2);

}

//예약된 좌석을클릭했을때 사용되는 메서드
function reservationed(se_number) {
    alert("이미 예약된 좌석입니다. 다른 좌석을 선택해주세요!")
}

//초기화 매서드
function reset() {
    let resetclass = [];
    resetclass = document.getElementsByClassName("reservationingdseat");
    let p = [];
    p = document.getElementsByTagName("P")
    count = 0;
    for (let i = 0; i < resetclass.length; i++) {
        resetclass[i].setAttribute("class", "seat");
    }
    for (let i = p.length - 1; i >= 0; i--) {
        p[i].remove();
    }

}

//좌석 선택확인 매서드
function check() {
    if (count === 0) {
        alert("좌석을 선택해 주세요");
        return false;
    } else
        return true;
}
