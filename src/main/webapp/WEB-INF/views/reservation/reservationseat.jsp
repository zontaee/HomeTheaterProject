<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html><html><head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<meta charset="UTF-8">
<title>메인페이지</title>

<style>
    .container{
        text-align: center;
        width: 1000px;
    }
    .btn{
        background-color: white;
        border-color: black;
        border: 1px solid black;
        border-radius: 10px;
        font-size: 12px;
    }
    a{
        color: black;
        border-radius: 5px;
        font-size: 15px;
    }
    h4{
        font-size: 18px;
    }
    .content{
        overflow-x: hidden;
        width: 1000px;
    }
    .movie_img{
        border: 1px solid black;
        width: 200px;
        height: 250px;
    }
    .seat{
        align-content: center;
        border: 3px black;
        border-color: black;
        width: 20px;
        height: 20px;
        color: red;
        background-color: dodgerblue;
        margin-bottom: 2px;
    }
    .reservationedseat{
        align-content: center;
        border: 3px black;
        border-color: black;
        width: 20px;
        height: 20px;
        color: red;
        background-color: black;
        margin-bottom: 2px;
    }
    .reservationingdseat{
        align-content: center;
        border: 3px black;
        border-color: black;
        width: 20px;
        height: 20px;
        color: red;
        background-color: greenyellow;
        margin-bottom: 2px;
    }
</style>
</head>
<body>
<div class="container">
    <div class="content">
        <%@ include file="../header.jsp"%>

        <%-- <c:forEach var="seat" items="${seatInfo}" begin="0" end="5" step="1">
                  <c:forEach var="seat" items="${seatInfo}" begin="0" end="5" step="1">
                  <input type="button" class="seat" name="${seat.se_number}" value="${seat.se_number}">
              </c:forEach>
                  <br>
              </c:forEach>    <-왜이상하게나오지 --%>

         <c:forEach var="seat" items="${seatInfo}" begin="0" end="5" step="1">
             <c:choose>
                     <c:when test="${seat.se_identify eq 'T'}">
                         <input type="button" class="reservationedseat" id="${seat.se_number}" name="${seat.se_number}" value="${seat.se_number}" onclick="reservationed('${seat.se_number}')">
                     </c:when>
                     <c:otherwise>
                         <input type="button" class="seat" id="${seat.se_number}" name="${seat.se_number}" value="${seat.se_number}" onclick="getSeat('${seat.se_number}')">
                     </c:otherwise>
             </c:choose>
         </c:forEach>
         <br>
         <c:forEach var="seat" items="${seatInfo}" begin="6" end="11" step="1">
             <c:choose>
                 <c:when test="${seat.se_identify eq 'T'}">
                     <input type="button" class="reservationedseat" id="${seat.se_number}" name="${seat.se_number}" value="${seat.se_number}" onclick="reservationed('${seat.se_number}')">
                 </c:when>
                 <c:otherwise>
                     <input type="button" class="seat" id="${seat.se_number}" name="${seat.se_number}" value="${seat.se_number}" onclick="getSeat('${seat.se_number}')">
                 </c:otherwise>
             </c:choose>
         </c:forEach>
         <br>
         <c:forEach var="seat" items="${seatInfo}" begin="12" end="17" step="1">
             <c:choose>
                 <c:when test="${seat.se_identify eq 'T'}">
                     <input type="button" class="reservationedseat" id="${seat.se_number}" name="${seat.se_number}" value="${seat.se_number}" onclick="reservationed('${seat.se_number}')">
                 </c:when>
                 <c:otherwise>
                     <input type="button" class="seat" id="${seat.se_number}" name="${seat.se_number}" value="${seat.se_number}" onclick="getSeat('${seat.se_number}')">
                 </c:otherwise>
             </c:choose>
         </c:forEach>
         <br>
         <c:forEach var="seat" items="${seatInfo}" begin="18" end="23" step="1">
             <c:choose>
                 <c:when test="${seat.se_identify eq 'T'}">
                     <input type="button" class="reservationedseat" id="${seat.se_number}" name="${seat.se_number}" value="${seat.se_number}" onclick="reservationed('${seat.se_number}')">
                 </c:when>
                 <c:otherwise>
                     <input type="button" class="seat" id="${seat.se_number}" name="${seat.se_number}" value="${seat.se_number}" onclick="getSeat('${seat.se_number}')">
                 </c:otherwise>
             </c:choose>
         </c:forEach>
         <br>
         <c:forEach var="seat" items="${seatInfo}" begin="24" end="29" step="1">
             <c:choose>
                 <c:when test="${seat.se_identify eq 'T'}">
                     <input type="button" class="reservationedseat" id="${seat.se_number}" name="${seat.se_number}" value="${seat.se_number}" onclick="reservationed('${seat.se_number}')">
                 </c:when>
                 <c:otherwise>
                     <input type="button" class="seat" id="${seat.se_number}" name="${seat.se_number}" value="${seat.se_number}" onclick="getSeat('${seat.se_number}')">
                 </c:otherwise>
             </c:choose>
         </c:forEach>
         <br>
        <form id="seatcontainer" action="reservationpayment" method="post" onsubmit="return check();">

            <input type="hidden" name="mo_number" value="${seatandTime.mo_number}">
            <input type="hidden" name="se_date" value="${seatandTime.se_date}">
            <input type="hidden" name="se_time" value="${seatandTime.se_time }">
            <input type="submit" value="결제하기">
        </form>
        <input type="button" value="초기화" onclick="reset()">



        <%@ include file="../footer.jsp"%>
    </div>
</div>
<script type="text/javascript" src="js/seat.js"></script>

</body>

</html>