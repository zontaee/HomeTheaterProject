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

</style>
</head>
<body>
<div class="container">
    <div class="content">

        <%@ include file="../header.jsp" %>


        <img class="movie_img" src="${findMovie.mo_fileName }" alt=""><br>

        <a class="fontsize"> ${findMovie.mo_title }</a><br>
        <a class="fontsize"> 감독:${findMovie.mo_director }</a><br>
        <a class="fontsize"> 배우:${findMovie.mo_actor }</a><br>
        <a class="fontsize"> 관람등급:${findMovie.mo_age }</a><br>
        <a class="fontsize"> 장르:${findMovie.mo_genre }</a><br>

        <form action="reservationtimedata" method="post" onsubmit="return check();">
            <input type="hidden" name="mo_number" value="${findMovie.mo_number}">
            <input type="hidden" name="mo_fileName" value="${findMovie.mo_fileName }">
            <input type="hidden" name="mo_title" value="${findMovie.mo_title }">
            <div>
                <select name="se_date" id="se_date"
                        onchange="changetime(this.value,${findMovie.mo_number})">
                    <option value="">날짜선택</option>
                    <c:forEach var="list" items="${findDate}">
                        <option value="${list.se_date}">${list.se_date }일</option>
                    </c:forEach>
                </select>
                <select name="se_time" id="se_time">
                    <a>상영시간</a>
                    <option value="">시간선택</option>
                    <%--  <c:forEach var="list" items="${findTime}">
                          <option value="${list.se_time}">${list.se_time}</option>
                      </c:forEach>--%>
                </select>
                <input type="submit" value="좌석선택">
            </div>
        </form>
        <%@ include file="../footer.jsp" %>
    </div>

</div>
</body>
<script type="text/javascript" src="js/timeInfo.js"></script>
</html>