<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>영화 등록</title>
    <style>
        label {
            margin-right: 30px;
            float: left;
        }
        .movieInfo {
            float: right;
        }
    </style>
</head>
<body>
<div class="container">

    <%@ include file="../header.jsp"%>
    <h1>______</h1>
    <h2 class="main_title">영화 등록</h2>
    <br>
    <form action="adminMovieAdd" name="addMovie" method="post"  enctype="multipart/form-data">
        <ul>
            <li><label>영화 제목</label><input type="text" class="movieInfo"
                                           id="movieTitle" name="mo_title"></li>
            <br>
            <li><label>영화 감독</label><input type="text" class="movieInfo"
                                           id="movieDiretor" name="mo_director"></li>
            <br>
            <li><label>배우</label><input type="text" class="movieInfo"
                                        id="movieActor" name="mo_actor"></li>
            <br>
            <li><label>장르</label><input type="text" class="movieInfo"
                                        id="movieGenre" name="mo_genre"></li>
            <br>
            <li><label>등급</label><input type="text" class="movieInfo"
                                        id="movieAge" name="mo_age"></li>
            <br>
            <li><label>상영시간</label><input type="text" class="movieInfo"
                                          id="moviePlayTime" name="mo_playTime"></li>
            <br>
            <li><label>개봉일</label><input type="text" class="movieInfo"
                                         id="movieOpenDate" name="mo_openDate"></li>
            <br>
            <li><label>추천수</label><input type="text" class="movieInfo"
                                         id="movieRecommendation" name="mo_recommendation"></li>
            <br>
            <li><label>포스터</label><input type="file" class="movieInfo"
                                         id="movieFileName" name="file"></li>
            <br>
            <input type="hidden" name="path" value="${pageContext.request.contextPath}/resources/static/Img/">
        </ul>

        <div class="btn">
            <button type="submit" value="등록" id="movieAdd" onclick="movieAddClick()">등록</button>
            <button type="button" id="movieAddCancle" onclick="history.back()">취소</button>
        </div>
    </form>
</div>
</body>
<script>
    function movieAddClick(){
        <c:choose>
        <c:when test="${msg != null }">
        alert(${msg});
        </c:when>
        <c:otherwise>
        alert("등록 되었습니다.");
        </c:otherwise>
        </c:choose>
    }
    /* $("#movieAdd").on("click", function () {
<c:choose>
		<c:when test="${msg != null }">
		alert("${msg}");
		</c:when>
		<c:otherwise>
		alert("등록 되었습니다.");
		     </c:otherwise>
		     </c:choose>

})
 */
</script>
<%@include file="../footer.jsp"%>
</html>