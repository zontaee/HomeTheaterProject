const addSelect = document.getElementById("se_time");
//const newp = document.createElement("p");

//날짜에 따른 동적 시간변화 함수(Fetch API사용)
async function changetime(se_date, mo_number) {

    let URL = "http://localhost:8500/findTime";
    let options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            se_date: se_date,
            mo_number: mo_number
        })
    }
    let response = await fetch(URL, options)

    let seatandTime = await response.json();

    //기존 셀렉트 박스에 있는 옵션 제거(시간 선택 옵션제외)  --> 제거하지않으면 날짜를 변경할때마다 누적되서 표현된다.
    let select = addSelect;
    let elementsByTagName = select.getElementsByTagName("option");
    console.log(elementsByTagName.length);
    for (let i = elementsByTagName.length - 1; i >= 1; i--) {
        elementsByTagName[i].remove();
    }
    //날짜에 따른 시간 추가 로직
    for (let i = 0; i < seatandTime.length; i++) {

        /*  newp.innerText ="<option value='" + seatandTime[i].se_time + "'>'" + seatandTime[i].se_time + "'</option>"*/
        let option = document.createElement("option");
        option.value = seatandTime[i].se_time;
        option.innerText = seatandTime[i].se_time;
        addSelect.appendChild(option);
    }


}

const check = () => {
    let seDateCheck = document.getElementById("se_date").value;
    let seTimeCheck = document.getElementById("se_time").value;
    console.log(seDateCheck);
    console.log(seTimeCheck);
   if(seTimeCheck ==="" || seDateCheck===""){
       alert("날짜 혹은 시간을 선택 해주세요.")
       return false;
   }else {
       return true;
   }


}
