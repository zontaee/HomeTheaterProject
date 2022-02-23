//예매취소 js
function cancel(re_number, se_date, se_number, se_time, mo_number) {
    let URL = "http://localhost:8500/Cancel";
    let options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            re_number: re_number,
            se_date: se_date,
            se_number: se_number,
            se_time: se_time,
            mo_number: mo_number
        })
    }
    if (!confirm("확인 또는 취소를 눌러주세요.")) {
        alert("취소 되었습니다.");
    } else
        fetch(URL, options)
            .then((response) => response.json())
            .then((json) => {
                if (json === 1) {
                    alert("예매취소 성공")
                } else {
                    alert("예매취소 실패")
                }
            })


}
