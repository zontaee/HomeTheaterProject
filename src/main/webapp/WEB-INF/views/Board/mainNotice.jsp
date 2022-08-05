<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"> -->

<title>공지사항 목록 페이지야~~~</title>

<style type="text/css">
/* 공통부분 ------------------------------------------------*/
	.wrapper{
			display: flex;
	  		align-items: center;
	 		justify-content: space-around;
	 		flex-direction: column;
		}

	.hidden{
		 display: none;
	}
/* visualbox부분 --------------------------------------------------- */
	#BoardnoticeVisualBox{
		height: 170px;
		weight: 1200px;
		overflow: hidden;
		background-color: #f5fcab;

		display:flex;
		flex-direction: row;
		--align-content: flex-end;
		border-bottom: 1px solid;
	}

		#BoardsiteLocationL{
			width: 130px; --background-color: red;

		}
			#BoardsiteLocationL>h3{
				font-size: 30px;
			}

		#BoardsiteLocationR{
			--background-color: green;
			font-size: 20px;
			text-decoration: underline;
		}
/*--------------------------------------------------------------  */
	#BoardmainContentFooter{
		display: flex;
		flex-direction: row;
		align-content: center;
		justify-content: space-around;

	}
		 #BoardmainContentFooter>div:nth-child(1){
			background: white;

		}
		#BoardmainContentFooter>div:nth-child(2){
			background: green;

		}
/* ------------------------------------------------------ */


</style>
<script>
function searchboard(){
	var board_category = $("#board_category").val();
	var selectValue = $("#selectBox option:selected").text();
	var board_title = $("#searchValue").val();
	alert("카테고리="+board_category);

	if(selectValue==="전체"){
		alert("전체이다.");
		$.ajax({
			url: "boardTotal",
			type: "GET",
			data: {
				"board_title": board_title,
				"board_category": board_category
			},
			success: function(){
				alert("전체찾기성공");
			}
		})
	}else if(selectValue==="제목"){
		alert("제목이다.");
	}else if(selectValue==="내용"){
		alert("내용이다");
	}else if(selectValue==="작성자"){
		alert("작성자이다");
	}
}
</script>

</head>
<body>

<!-- main header -->
<div id="BoardnoticeHeaderBox">
	<%@ include file="../header.jsp"%>
</div>

<!-- visual box -->
<div id="BoardnoticeVisualBox" class="wrapper">
		<!-- board_category값을 이용하여 if문으로 제목 바꾸기 -->
		<div id="BoardsiteLocationL">
			<h3 id="BoardtextChangeL"></h3>

				<script type="text/javascript">
					if(${board.board_category}== 2 ){
						document.getElementById("BoardtextChangeL").innerHTML = "QnA";
					}else{
						document.getElementById("BoardtextChangeL").innerHTML = "공지사항";
					}
				</script>
		</div>
		<div id="BoardsiteLocationR">
               <a href="../main"><img src="<%=context%>/img/BoardImg/b_home.png" alt="home" style="width: 20px; height: 20px;" /></a> > 게시판 ><strong id="BoardtextChangeR"></strong>

               	<script type="text/javascript">
					if(${board.board_category}==2){
						document.getElementById("BoardtextChangeR").innerHTML = "QnA";
					}else{
						document.getElementById("BoardtextChangeR").innerHTML = "공지사항";
					}
				</script>

		</div>
</div>
<div id="BoardnoticeMainBox" class="wrapper">

	<!--본문 -->
	<main id="BoardmainContent">
		<h2 class="hidden">본문내용</h2>

		<!--공지사항 Qna 전환 selectBox -->
 		<form action="mainNotice">
			 <select name="board_category">
				<option value=1>공지사항</option>
				<option value=2>QNA</option>
			</select>
		    <input type="submit" value="확인"  >
		</form>



		<c:if test="${fn:length(listboard)==0}">
			<h3>Total : ${total}</h3>
			<h2>검색한 결과가 없습니다.</h2>
		</c:if>
		<!-- 전체 테이블 -->
		<c:if test="${fn:length(listboard)!=0}">
			<h3>Total : ${total}</h3>
			<table border="1">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>조회</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<!-- DB 연결 js부분 -->
					<c:forEach var="board" items="${listboard}" varStatus="status">
						<!-- 전체 레코드 수 - ( (현재 페이지 번호 - 1) * 한 페이지당 보여지는 레코드 수 + 현재 게시물 출력 순서 ) -->
						<tr><td> ${pg.total-((pg.currentPage-1)*pg.rowPage+ status.index)} </td>
							<td><a href="noticeContents?board_no=${board.board_no }&board_category=${board.board_category}">${board.board_title}</a></td>
							<td>${board.board_hit}</td>
							<td>${board.m_id}</td>
							<td colspan="2">${board.board_date}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<!-- paging -->
		<c:if test="${pg.startPage > pg.pageBlock }">
			<a href="mainNotice?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
			<a href="mainNotice?currentPage=${i}&board_category=${board.board_category}">[${i}]</a>
		</c:forEach>
		<c:if test="${pg.endPage < pg.totalPage }">
			<a href="mainNotice?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
		</c:if>

		<nav style="text-align: center;">
			<ul class="pagination"
				th:with="start=${T(Math).floor(bbsDTO.number/10)*10 + 1},
                    last=(${start + 9 < bbsDTO.totalPages ? start + 9 : bbsDTO.totalPages})">
				<li>
					<a th:href="@{/bbsLists(page=1)}" aria-label="First">
						<span aria-hidden="true">First</span>
					</a>
				</li>

				<li th:class="${bbsDTO.first} ? 'disabled'">
					<a th:href="${bbsDTO.first} ? '#' :@{/bbsLists(page=${bbsDTO.number})}" aria-label="Previous">
						<span aria-hidden="true">&lt;</span>
					</a>
				</li>

				<li th:each="page: ${#numbers.sequence(start, last)}" th:class="${page == bbsDTO.number + 1} ? 'active'">
					<a th:text="${page}" th:href="@{/bbsLists(page=${page})}"></a>
				</li>

				<li th:class="${bbsDTO.last} ? 'disabled'">
					<a th:href="${bbsDTO.last} ? '#' : @{/bbsLists(page=${bbsDTO.number + 2})}" aria-label="Next">
						<span aria-hidden="true">&gt;</span>
					</a>
				</li>

				<li>
					<a th:href="@{/bbsLists(page=${bbsDTO.totalPages})}" aria-label="Last">
						<span aria-hidden="true">Last</span>
					</a>
				</li>
			</ul>
		</nav>

		<div id="BoardmainContentFooter" >
			<form action="<%=context%>/Boardviews/mainNotice" method="GET">
			<div>
				<select name="selectBox">
					<option>전체</option>
					<option>제목</option>
					<option>내용</option>
					<option>작성자</option>
				</select>
				<input type="hidden" name="board_category" value="${board.board_category}">
				<input type="text" name="searchValue">
				<input type="submit" id="searchValue" value="검색">
			</div>
			</form>
			<c:if test="${sessionScope.sessionId == 'admin'}">	<!-- 관리자로 로그인 했을때만 새글 쓰기 버튼 보여줌. -->
				<div>
					<button onclick="location.href='noticeWriteForm?board_category=${board.board_category}'">글쓰기</button>
				</div>
			</c:if>
		</div>

	</main>
</div>

<!-- main footer-->
<div id="BoardnoticeFooterBox">
	<%@ include file="../footer.jsp"%>
</div>




</body>
</html>