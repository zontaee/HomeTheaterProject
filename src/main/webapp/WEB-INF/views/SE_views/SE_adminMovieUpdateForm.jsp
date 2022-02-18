<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>수정 페이지</title>
</head>
<body>
<div class="container">

    <%@ include file="../header.jsp"%>
    <h1>______</h1>
    <h2 class="main_title">영화 수정</h2>
    <br>
    <form action="adminMovieUpdate" name="updateMovie" method="post">
        <input type="hidden" name="mo_number" value="${movie.mo_number }">
        <ul>
            <li><label>영화 제목</label><input type="text" class="movieInfo"
                                           id="movieTitle" name="mo_title"  value="${movie.mo_title }"></li>
            <br>
            <li><label>영화 감독</label><input type="text" class="movieInfo"
                                           id="movieDiretor" name="mo_director" value="${movie.mo_director }"></li>
            <br>
            <li><label>배우</label><input type="text" class="movieInfo"
                                        id="movieActor" name="mo_actor" value="${movie.mo_actor }"></li>
            <br>
            <li><label>장르</label><input type="text" class="movieInfo"
                                        id="movieGenre" name="mo_genre" value="${movie.mo_genre }"></li>
            <br>
            <li><label>등급</label><input type="text" class="movieInfo"
                                        id="movieAge" name="mo_age" value="${movie.mo_age }"></li>
            <br>
            <li><label>상영시간</label><input type="text" class="movieInfo"
                                          id="moviePlayTime" name="mo_playTime" value="${movie.mo_playTime }"></li>
            <br>
            <li><label>개봉일</label><input type="text" class="movieInfo"
                                         id="movieOpenDate" name="mo_openDate" value="${movie.mo_openDate }"></li>
            <br>
            <li><label>추천수</label><input type="text" class="movieInfo"
                                         id="movieRecommendation" name="mo_recommendation" value="${movie.mo_recommendation }"></li>
            <br>
            <li><label>파일경로</label><input type="text" class="movieInfo"
                                          id="movieFileName" name="mo_fileName" value="${movie.mo_fileName }"></li>
            <br>

        </ul>

        <div class="btn">
            <button type="submit" value="수정" id="movieUpdate" onclick="movieUpdateClick()">수정</button>
            <button type="button" id="movieUpdateCancle" onclick="history.back()">취소</button>
        </div>
    </form>
</div>
</body>

<script>
    function movieUpdateClick(){
        alert("수정되었습니다.");

    }
</script>
</html>