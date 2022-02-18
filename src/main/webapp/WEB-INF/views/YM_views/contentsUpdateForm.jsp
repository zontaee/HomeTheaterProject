<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글작성 페이지야~</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<style type="text/css">
/* MainContent Box ------------------------------------------ */
	#YM_board_write>div{
		width: 1000px;
		border:1px solid;
	}

	#YM_boardTitle{
		height: 30px;	
	}
	#YM_boardContent{
		height: 430px;	
	}
	
/* MainContent textarea Box ------------------------------------------ */
	textarea {
        width: 100%;
        height: 100%;
      }
	
</style>
</head>
<body>

<!-- main header -->
<div class="container">
<div id="YM_noticeHeaderBox">
	<%@ include file="../header.jsp"%>
</div>

<div id="YM_noticeContentBody">
	<main>
		<div id="YM_siteLocation">
			<h2>공지사항</h2>
		</div>
		<div id="YM_noticeContentBox">
			<div id="YM_board_write">
				<h3 class="hidden">글을 수정하는 공간입니다.</h3>
				<!-- <form action="mainNotice"> -->
				<form action="contentsUpdate" method="post">
				     <input type="hidden" name="bbs_no" value="${bbsContents.bbs_no }">
			          <input type="hidden" name="bbs_category" value="${bbsContents.bbs_category }">
				
					<div>
						작성일 : ${bbsContents.bbs_date}
					</div>
					<div id="YM_boardTitle">
					<!-- name=""파라미터로 데이터를 넘겨주는역활      required-->
						<textarea  name="bbs_title"  placeholder="제목" maxlength="100">${bbsContents.bbs_title}</textarea>					
					</div>
					<div id="YM_boardContent">
						 <textarea name="bbs_content"  placeholder="내용" maxlength="250">${bbsContents.bbs_content}</textarea>
					</div>
					<div>
						<button type="submit"  onclick="location.href='mainNotice'">글 수정</button>
					</div>
					
				</form>
				
					
			</div>
		</div>

	</main>
</div>




<!-- main footer -->
<div id="YM_noticeFooterBox">
	<%@ include file="../footer.jsp"%>
</div>
</div>
</body>
</html>