<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글 수정 페이지야~</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<style type="text/css">
/* MainContent Box ------------------------------------------ */
	#Boardboard_write>div{
		width: 1000px;
		border:1px solid;
	}
	#BoardboardTitle{
		height: 30px;	
	}
	#BoardboardContent{
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
<div id="BoardnoticeHeaderBox">
	<%@ include file="../header.jsp"%>
</div>

<div id="BoardnoticeContentBody">
	<main>
		<div id="BoardsiteLocation">
			<h2>공지사항</h2>
		</div>
		<div id="BoardnoticeContentBox">
			<div id="Boardboard_write">
				<h3 class="hidden">글을 수정하는 공간입니다.</h3>
				<!-- <form action="mainNotice"> -->
				<form action="contentsUpdate" method="post">
				     <input type="hidden" name="board_no" value="${boardContents.board_no }">
			          <input type="hidden" name="board_category" value="${boardContents.board_category }">
				
					<div>
						작성일 : ${boardContents.board_date}
					</div>
					<div id="BoardboardTitle">
					<!-- name=""파라미터로 데이터를 넘겨주는역활      required-->
						<textarea  name="board_title"  placeholder="제목" maxlength="100">${boardContents.board_title}</textarea>
					</div>
					<div id="BoardboardContent">
						 <textarea name="board_content"  placeholder="내용" maxlength="250">${boardContents.board_content}</textarea>
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
<div id="BoardnoticeFooterBox">
	<%@ include file="../footer.jsp"%>
</div>

</body>
</html>