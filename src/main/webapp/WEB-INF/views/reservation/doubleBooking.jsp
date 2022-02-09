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

        <h6>이미 예약된 좌석입니다. 다른 좌석을 선택해 주세요</h6>


        <%@ include file="../footer.jsp"%>

</body>

</html>