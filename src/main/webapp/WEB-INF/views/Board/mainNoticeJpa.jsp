<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"> -->

    <title>공지사항 목록 페이지야~~~</title>

    <style type="text/css">
        /* 공통부분 ------------------------------------------------*/
        .wrapper {
            display: flex;
            align-items: center;
            justify-content: space-around;
            flex-direction: column;
        }

        .hidden {
            display: none;
        }

        /* visualbox부분 --------------------------------------------------- */
        #boardnoticeVisualBox {
            height: 170px;
            weight: 1200px;
            overflow: hidden;
            background-color: #f5fcab;

            display: flex;
            flex-direction: row;
            --align-content: flex-end;
            border-bottom: 1px solid;
        }

        #boardsiteLocationL {
            width: 130px;
            --background-color: red;

        }

        #boardsiteLocationL > h3 {
            font-size: 30px;
        }

        #boardsiteLocationR {
            --background-color: green;
            font-size: 20px;
            text-decoration: underline;
        }

        /*--------------------------------------------------------------  */
        #boardmainContentFooter {
            display: flex;
            flex-direction: row;
            align-content: center;
            justify-content: space-around;

        }

        #boardmainContentFooter > div:nth-child(1) {
            background: white;

        }

        #boardmainContentFooter > div:nth-child(2) {
            background: green;

        }

        /* ------------------------------------------------------ */


    </style>
</head>
<body>

<!-- main header -->
<div id="boardnoticeHeaderBox">
    <%@ include file="../header.jsp" %>
</div>

<!-- visual box -->
<div id="boardnoticeVisualBox" class="wrapper">
    <!-- board_category값을 이용하여 if문으로 제목 바꾸기 -->
    <div id="boardsiteLocationL">
        <h3 id="boardtextChangeL"></h3>

        <script type="text/javascript">
            if (${board.board_category}== 2
            )
            {
                document.getElementById("boardtextChangeL").innerHTML = "QnA";
            }
            else
            {
                document.getElementById("boardtextChangeL").innerHTML = "공지사항";
            }
        </script>
    </div>
    <div id="boardsiteLocationR">
        <a href="../main"><img src="<%=context%>/img/boardImg/b_home.png" alt="home"
                               style="width: 20px; height: 20px;"/></a> > 게시판 ><strong id="boardtextChangeR"></strong>

        <script type="text/javascript">
            if (${board.board_category}==2
            )
            {
                document.getElementById("boardtextChangeR").innerHTML = "QnA";
            }
            else
            {
                document.getElementById("boardtextChangeR").innerHTML = "공지사항";
            }
        </script>

    </div>
</div>
<div id="boardnoticeMainBox" class="wrapper">

    <!--본문 -->
    <main id="boardmainContent">
        <h2 class="hidden">본문내용</h2>

        <!--공지사항 Qna 전환 selectBox -->
        <form action="mainNotice">
            <select name="board_category">
                <option value=1>공지사항</option>
                <option value=2>QNA</option>
            </select>
            <input type="submit" value="확인">
        </form>


        <c:if test="${fn:length(listboard)==0}">
        <h3>Total : ${total}</h3>
        <h2>검색한 결과가 없습니다.</h2>
        </c:if>
        <!-- 전체 테이블 -->
        <c:if test="${fn:length(listboard)!=0}">
        <h3>Total : ${total}</h3>
        <div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th class="text-center">번호</th>
                    <th class="text-center">제목</th>
                    <th class="text-center">작성일</th>
                    <th class="text-center">작성자</th>
                    <th class="text-center">조회수</th>
                </tr>
                </thead>
                <tbody>
                <tr th:each="board : ${board}">
                    <td class="col-1 text-center" th:text="${board.board_no}"></td>
                    <td class="col-5 text-center"><a th:text="${board.board_title}"
                                                     th:href="@{/content/{boardNo}(boardNo=${board.board_no})}"></a></td>
                    <td class="col-2 text-center" th:text="${board.board_date}"></td>
                    <td class="col-2 text-center" th:text="${board.m_id}"></td>
                    <td class="col-2 text-center" th:text="${board.board_hit}"></td>
                </tr>
                </tbody>
            </table>
        </div>


        <nav style="text-align: center;">
            <ul class="pagination"
                th:with="start=${T(Math).floor(board.number/10)*10 + 1},
                    last=(${start + 9 < board.totalPages ? start + 9 : board.totalPages})">
                <li>
                    <a th:href="@{/boardLists(page=1)}" aria-label="First">
                        <span aria-hidden="true">First</span>
                    </a>
                </li>

                <li th:class="${board.first} ? 'disabled'">
                    <a th:href="${board.first} ? '#' :@{/boardLists(page=${board.number})}" aria-label="Previous">
                        <span aria-hidden="true">&lt;</span>
                    </a>
                </li>

                <li th:each="page: ${#numbers.sequence(start, last)}" th:class="${page == board.number + 1} ? 'active'">
                    <a th:text="${page}" th:href="@{/boardLists(page=${page})}"></a>
                </li>

                <li th:class="${board.last} ? 'disabled'">
                    <a th:href="${board.last} ? '#' : @{/boardLists(page=${board.number + 2})}" aria-label="Next">
                        <span aria-hidden="true">&gt;</span>
                    </a>
                </li>

                <li>
                    <a th:href="@{/boardLists(page=${board.totalPages})}" aria-label="Last">
                        <span aria-hidden="true">Last</span>
                    </a>
                </li>
            </ul>
        </nav>
        <c:if test="${sessionScope.sessionId == 'admin'}">    <!-- 관리자로 로그인 했을때만 새글 쓰기 버튼 보여줌. -->
        <div>
            <button onclick="location.href='noticeWriteForm?board_category=${board.board_category}'">글쓰기</button>
        </div>
        </c:if>
</div>

</main>
</div>

<!-- main footer-->
<div id="boardnoticeFooterBox">
    <%@ include file="../footer.jsp" %>
</div>


</body>
</html>