<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"> -->

<title>공지사항페이지야~~~</title>

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
	#YM_noticeVisualBox{
		height: 170px;
		weight: 1200px;
		overflow: hidden;
		background-color: #f5fcab;
		
		display:flex;
		flex-direction: row;
		--align-content: flex-end;
		border-bottom: 1px solid;
	}
	
		#YM_siteLocationL{
			width: 130px; --background-color: red;
			
		}
			#YM_siteLocationL>h3{
				font-size: 30px;
			}
		
		#YM_siteLocationR{
			--background-color: green;
			font-size: 20px;
			text-decoration: underline;
		}
/*--------------------------------------------------------------  */
	#YM_mainContentFooter{
		display: flex;
		flex-direction: row;
		align-content: center;
		justify-content: space-around;
		
	}
		 #YM_mainContentFooter>div:nth-child(1){
			background: red;
			
		}
		#YM_mainContentFooter>div:nth-child(2){
			background: green;
			
		}
/* ------------------------------------------------------ */	

	
	
</style>


</head>
<body>

<!-- main header -->
<div class="container">
<div id="YM_noticeHeaderBox">
	<%@ include file="../header.jsp"%>
</div>

<!-- visual box -->
<div id="YM_noticeVisualBox" class="wrapper">
		<!-- bbs_category값을 이용하여 if문으로 제목 바꾸기 -->
		<div id="YM_siteLocationL">
			<h3 id="YM_textChangeL"></h3>	
			
				<script type="text/javascript">	
					if(${bbs.bbs_category}===2){
						document.getElementById("YM_textChangeL").innerHTML = "QnA";
					}else{
						document.getElementById("YM_textChangeL").innerHTML = "공지사항";
					}
				</script>			
		</div>
		<div id="YM_siteLocationR">
               <a href="../main"><img src="img/YM_Img/1.jpg" alt="home" /></a> > 게시판 ><strong id="YM_textChangeR"></strong>
               
               	<script type="text/javascript">	
					if(${bbs.bbs_category}==2){
						document.getElementById("YM_textChangeR").innerHTML = "QnA";
					}else{
						document.getElementById("YM_textChangeR").innerHTML = "공지사항";
					}
				</script>	
               
		</div>		
</div>
<div id="YM_noticeMainBox" class="wrapper">

	<!--본문 -->
	<main id="YM_mainContent">
		<h2 class="hidden">본문내용</h2>
		
		<!--공지사항 Qna 전환 selectBox -->
 		<form action="mainNotice">
			 <select name="bbs_category">	
				<option value=1>공지사항</option>	
				<option value=2>QNA</option>	
			</select> 
		    <input type="submit" value="확인"  >
		</form>
	
		
		<h3>Total : ${total}</h3>
		<!-- 전체 테이블 -->
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>조회</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>	
		
					<!-- DB 연결 js부분 -->
					<c:forEach var="bbs" items="${listBbs}" varStatus="status">
						<!-- 전체 레코드 수 - ( (현재 페이지 번호 - 1) * 한 페이지당 보여지는 레코드 수 + 현재 게시물 출력 순서 ) -->
						<tr><td> ${pg.total-((pg.currentPage-1)*pg.rowPage+ status.index)} </td>
						<td><a href="noticeContents?bbs_no=${bbs.bbs_no }&bbs_category=${bbs.bbs_category}">${bbs.bbs_title}</a></td>
							<td>${bbs.bbs_hit }</td><td>${bbs.bbs_date }</td></tr>
					
					</c:forEach> 
				</tbody>
		</table>
		<!-- paging -->
		<c:if test="${pg.startPage > pg.pageBlock }">
			<a href="mainNotice?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
			<a href="mainNotice?currentPage=${i}&bbs_category=${bbs.bbs_category}">[${i}]</a>
		</c:forEach>
		<c:if test="${pg.endPage < pg.totalPage }">
			<a href="mainNotice?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
		</c:if>		 
			
		<div id="YM_mainContentFooter" >
				<div class="hidden">
					<select>
						<option>제목</option>
						<option>이름</option>
						<option>내용</option>
					</select>
					
					<input type="text">
					<input type="submit" value="검색">
					
				</div>
				
				<div>
					<button onclick="location.href='noticeWriteForm?bbs_category=${bbs.bbs_category}'">글쓰기</button>
				</div>
				
				<div>
					<h2 class="hidden">페이지 이동버튼</h2>
				</div>
				
		</div>
		
	</main>
</div>
	
<!-- main footer-->
<div id="YM_noticeFooterBox">
	<%@ include file="../footer.jsp"%>
</div>
</div>
	


</body>
</html>