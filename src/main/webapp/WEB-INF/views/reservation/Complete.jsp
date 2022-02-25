<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html><html><head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
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
        border-radius: 10px;
        font-size: 12px;
    }

    a {
        color: black;
        border-radius: 5px;
        font-size: 15px;
    }

    h4 {
        font-size: 18px;
    }

    .content {
        overflow-x: hidden;
        width: 1000px;
    }

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
        color: red;
        background-color: dodgerblue;
        margin-bottom: 2px;
    }

    .reservationedseat {
        align-content: center;
        border: 3px black;
        border-color: black;
        width: 20px;
        height: 20px;
        color: red;
        background-color: black;
        margin-bottom: 2px;
    }

    .reservationingdseat {
        align-content: center;
        border: 3px black;
        border-color: black;
        width: 20px;
        height: 20px;
        color: red;
        background-color: greenyellow;
        margin-bottom: 2px;
    }

    #con {
        float: left;
    }

    .color {
        margin-top: 30px;
        margin-left: 100px;
        margin-right: 100px;
        background-color: #BDBDBD;
    }

    .in {
        display: inline-block;
        margin: 50px;
    }
    .fontsize{
        font-size : 20px;
    }

</style>
</head>
<body>
<div class="container">
    <div class="content">
        <%@ include file="../header.jsp" %>
        <div class="color">
            <div class="in">
                <img class="movie_img w-80" src="${movieInfo.mo_fileName }" alt=""><br>
                <a class="fontsize"> 예매번호:${seatandTime.re_number }</a>
            </div>
            <div class="in">
                <a class="fontsize"> ${movieInfo.mo_title }</a><br>
                <a> 감독:${movieInfo.mo_director }</a><br>
                <a> 배우:${movieInfo.mo_actor }</a><br>
                <a> 관람등급:${movieInfo.mo_age }</a><br>
                <a> 장르:${movieInfo.mo_genre }</a><br>
                <a> 좌석:${seatandTime.se_number }</a><br>
                <a> 날짜:${seatandTime.se_date}</a><br>
                <a> 시간:${seatandTime.se_time }</a><br>
                <a> 남은포인트 :${memberInfo.m_point}</a><br>
                <input type="button" value="예매취소" class="btn btn-outline-secondary"
                       onclick="cancel('${seatandTime.re_number}','${seatandTime.se_date}','${seatandTime.se_number }','${seatandTime.se_time }','${seatandTime.mo_number}') ">

            </div>


        </div>


    </div>
    <%@ include file="../footer.jsp" %>

</div>

<script type="text/javascript" src="js/reservation/cancel.js"></script>
</body>

</html>