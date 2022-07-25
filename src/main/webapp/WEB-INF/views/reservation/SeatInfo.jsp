<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html><html><head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/IT_css/bootstrap-select.css">

<meta charset="UTF-8">
<title>메인페이지</title>

<style>
    .container {
        text-align: center;
        width: 1000px;
    }
    .btn {
        background-color: white;
        border-color: black;
        border: 1px solid black;
        border-radius: 3px;
        font-size: 12px;
        cursor: pointer;
    }
    a {
        color: black;
        border-radius: 5px;
        font-size: 15px;
    }
    h4 {
        font-size: 18px;
    }
    /*.content {
        overflow-x: hidden;
        width: 1000px;
    }*/
    .movie_img {
        border: 1px solid black;
        width: 200px;
        height: 250px;
    }
    .seat {
        align-content: center;
        border: 3px black;
        border-color: black;
        width: 20px;
        height: 20px;
        color: white;
        background-color: #A6A6A6;
        margin-bottom: 2px;
    }
    .reservationedseat {
        align-content: center;
        border: 3px black;
        border-color: black;
        width: 20px;
        height: 20px;
        color: white;
        background-color: #5D5D5D;
        margin-bottom: 2px;
    }
    .reservationingdseat {
        align-content: center;
        border: 3px black;
        border-color: black;
        width: 20px;
        height: 20px;
        color: white;
        background-color: #A566FF;
        margin-bottom: 2px;
    }
    .seatinfo {
        align-content: center;
        border: 3px black;
        border-color: black;
        width: 20px;
        height: 20px;
        color: white;
        background-color: #A6A6A6;
        margin-bottom: 2px;
        margin-left: 10px;
        margin-right: 5px;
    }
    .reservationedseatinfo {
        align-content: center;
        border: 3px black;
        border-color: black;
        width: 20px;
        height: 20px;
        color: white;
        background-color: #5D5D5D;
        margin-bottom: 2px;
        margin-left: 10px;
        margin-right: 5px;
    }
    .reservationingseatinfo {
        align-content: center;
        border: 3px black;
        border-color: black;
        width: 20px;
        height: 20px;
        color: white;
        background-color: #A566FF;
        margin-bottom: 2px;
        margin-right: 5px;
    }
    .color {
        margin-left: 300px;
        margin-right: 300px;
        background-color: #212121;
    }
    .margin {
        margin-top: 15px;
    }
    label{
        color: white;
    }
    .btnPay{
        margin-top: 20px;
        width: 100px;
        height: 25px;
        background-color: white;
        border-color: white;
        border-radius: 10px;
        cursor: pointer;
    }
    .btnPay:hover{
        background: black;
        color: white;
        border-color: white;
    }
    #reset{
        background: #212121;
        color: white;
        border: #212121;
        margin-left: -4px;
        cursor: pointer;
        margin-bottom: 5px;
    }
    #resetIcon{
        margin-left: 340px;
        cursor: pointer;
    }
</style>
</head>
<body>
<div class="container">
    <div class="content">

        <%@ include file="../header.jsp" %>

        <div class="color">

            <div class="margin"><img src="img/SCREEN.JPG" width="400" height="17"></div>
            <br><br>
            <c:forEach var="seat" items="${seatInfo}" begin="0" end="5" step="1">
                <c:choose>
                    <c:when test="${seat.se_identify eq 'T'}">
                        <input type="button" class="reservationedseat" id="${seat.se_number}" name="${seat.se_number}"
                               value="${seat.se_number}" onclick="reservationed('${seat.se_number}')">
                    </c:when>
                    <c:otherwise>
                        <input type="button" class="seat" id="${seat.se_number}" name="${seat.se_number}"
                               value="${seat.se_number}" onclick="getSeat('${seat.se_number}')">
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <br>
            <c:forEach var="seat" items="${seatInfo}" begin="6" end="11" step="1">
                <c:choose>
                    <c:when test="${seat.se_identify eq 'T'}">
                        <input type="button" class="reservationedseat" id="${seat.se_number}" name="${seat.se_number}"
                               value="${seat.se_number}" onclick="reservationed('${seat.se_number}')">
                    </c:when>
                    <c:otherwise>
                        <input type="button" class="seat" id="${seat.se_number}" name="${seat.se_number}"
                               value="${seat.se_number}" onclick="getSeat('${seat.se_number}')">
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <br>
            <c:forEach var="seat" items="${seatInfo}" begin="12" end="17" step="1">
                <c:choose>
                    <c:when test="${seat.se_identify eq 'T'}">
                        <input type="button" class="reservationedseat" id="${seat.se_number}" name="${seat.se_number}"
                               value="${seat.se_number}" onclick="reservationed('${seat.se_number}')">
                    </c:when>
                    <c:otherwise>
                        <input type="button" class="seat" id="${seat.se_number}" name="${seat.se_number}"
                               value="${seat.se_number}" onclick="getSeat('${seat.se_number}')">
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <br>
            <c:forEach var="seat" items="${seatInfo}" begin="18" end="23" step="1">
                <c:choose>
                    <c:when test="${seat.se_identify eq 'T'}">
                        <input type="button" class="reservationedseat" id="${seat.se_number}" name="${seat.se_number}"
                               value="${seat.se_number}" onclick="reservationed('${seat.se_number}')">
                    </c:when>
                    <c:otherwise>
                        <input type="button" class="seat" id="${seat.se_number}" name="${seat.se_number}"
                               value="${seat.se_number}" onclick="getSeat('${seat.se_number}')">
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <br>
            <c:forEach var="seat" items="${seatInfo}" begin="24" end="29" step="1">
                <c:choose>
                    <c:when test="${seat.se_identify eq 'T'}">
                        <input type="button" class="reservationedseat" id="${seat.se_number}" name="${seat.se_number}"
                               value="${seat.se_number}" onclick="reservationed('${seat.se_number}')">
                    </c:when>
                    <c:otherwise>
                        <input type="button" class="seat" id="${seat.se_number}" name="${seat.se_number}"
                               value="${seat.se_number}" onclick="getSeat('${seat.se_number}')">
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <br><br>
            <input type="button" class="reservationingseatinfo" value=" "><label>선택좌석</label>
            <input type="button" class="reservationedseatinfo" value=" "><label>예매불가</label>
            <input type="button" class="seatinfo" value=" "><label>예매가능</label>
            <br>
            <div>
                <form id="seatcontainer" action="reservationpayment" method="post" onsubmit="return check();">

                    <input type="hidden" name="mo_number" value="${seatandTime.mo_number}">
                    <input type="hidden" name="se_date" value="${seatandTime.se_date}">
                    <input type="hidden" name="se_time" value="${seatandTime.se_time }">
                    <input type="submit" value="결제하기" class="btnPay">
                </form>
                <i class="fas fa-solid fa-retweet" id="resetIcon" onclick="reset()" style="font-size: 12px; color: white;"></i>
                <input type="button" id="reset" value="초기화  " onclick="reset()">
            </div>
        </div>


        <%@ include file="../footer.jsp" %>

    </div>
</div>
<script type="text/javascript" src="js/reservation/seat.js"></script>

</body>

</html>