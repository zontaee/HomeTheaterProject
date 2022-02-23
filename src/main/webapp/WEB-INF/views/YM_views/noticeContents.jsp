<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글 내용 페이지야~</title>
<style type="text/css">
/* MainContent Box ------------------------------------------ */
	#YM_MainContentsBox>div{
		width: 1000px;
		border:1px solid;
	}
	#boardTitle{
		height: 30px;	
	}
	#boardContent{
		height: 500px;	
	}
	#boardDate{
		text-align: left;
	}
	
</style>
</head>
<body>


<!-- main header -->
<div id="YM_NoticeContentsHeaderBox">
	<%@ include file="../header.jsp"%>
</div>

<div id="YM_NoticeContentsBody">

	<main id="YM_NoticeContentsMainBox">
		<div class="YM_siteLocation">
			<h2>공지사항 or Qna</h2>
		</div>
		
		<div id="YM_MainContentsBox">	
			<div id="boardDate">
				작성일 : ${bbsContents.bbs_date}
			</div>
			<div id="boardTitle">
				${bbsContents.bbs_title}
			</div>
			<div id="boardContent">
				${bbsContents.bbs_content}
			</div>	
		</div>

		<div id="YM_Mainfooter">
			<div>
				<button onclick="location.href='mainNotice'" >목록</button>
				<c:if test="${sessionScope.sessionId == 'admin'}">			<!-- 관리자로 로그인 했을때만 수정, 삭제 버튼 보여줌. -->
					<button value="수정" onclick="location.href='contentsUpdateForm?bbs_no=${bbsContents.bbs_no}&bbs_category=${bbsContents.bbs_category}'">수정</button>
					<button value="삭제" onclick="location.href='contentsDelete?bbs_no=${bbsContents.bbs_no}&bbs_category=${bbsContents.bbs_category}'">삭제</button>
				</c:if>
			</div>
		</div>
	</main>
	
</div>




<!-- main footer -->
<div id="YM_NoticeContentsFooterBox">
	<%@ include file="../footer.jsp"%>
</div>

</body>
</html>