<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="css/movieDetail.css">	
<title>상세정보</title>

</head>

<script>
function movieDelete(){
	if (confirm("이 영화를 삭제하겠습니까?")) {
	    // 확인 버튼 클릭 시 동작
	    alert("영화를 삭제했습니다.");
	    location.href='adminMovieDelete?mo_number=${movie.mo_number}'
	} else {
	    // 취소 버튼 클릭 시 동작
	    alert("삭제를 취소했습니다.");
	}
	
}
</script>
<body>
	<div class="container">

		<%@ include file="../header.jsp"%>
		<h1>______</h1>
		<h2 class="main_title">영화 상세</h2>
		<br>
		<div class="wrap-movie-detail">
			<div class="box-image">
				<img class="detail-image" src="/${movie.mo_fileName }" alt="">
			</div>
			<div class="box-content">
				<div class="movie-title" >
					${movie.mo_title }
				</div>
				<div class="ect_detail">추천 수: ${movie.mo_recommendation }</div>
				<hr>
				<div class="spec">
					감독&nbsp :&nbsp ${movie.mo_director }<br> 배우 &nbsp: &nbsp${movie.mo_actor }<br>
					장르 &nbsp:&nbsp ${movie.mo_genre }<br> 기본 &nbsp: &nbsp${movie.mo_age },${movie.mo_playTime }<br>
				</div>
			</div>
	<div class= "btn_box">
			<c:choose>
				<c:when test="${sessionScope.sessionId == 'admin'}">
					<div class="admin_btn_box">
						<button type="button" class="admin_btn" id="movieUpdate"
							onclick="location.href='adminMovieUpdateForm?mo_number=${movie.mo_number}'">수정</button>
						<button type="button" class="admin_btn" id="movieDelete"
							onclick="movieDelete()">삭제</button>
					</div>
				</c:when>
				<c:otherwise>
					<div class="ect_box">
						<button type="button" class = "ect-btn" id="choiceMovie" style="font-size: 15px;">관심</button>
						<button type="button" class = "ect-btn" id="reservation">예매하기</button>
						<button type="button" class = "ect-btn" id="recommendationLike">추천</button>
					</div>

				</c:otherwise>

			</c:choose>

		</div>
		</div>
		<%@include file="../footer.jsp"%>
		</div>
</body>

<script>
		$(document).ready(function () {
			var likecheck = ${check};
			var choicecheck = ${choiceCheck};
			 if(likecheck>0) {
				 $('#recommendationLike').attr("style", "background: black; color : white;");
		        }
			 if(choicecheck>0) {
				 $('#choiceMovie').attr("style", "background: black; color : white;");
		        }
			 $("#recommendationLike").on("click", function () {
				 <c:choose>
					<c:when test="${empty sessionScope.sessionId }">
					alert("로그인해주시길 바랍니다.");
					</c:when>
					<c:otherwise>
					var mo_num = ${movie.mo_number};
					var m_num = "${member.m_id}";
					
					     $.ajax({
					            type : "POST",  
					            url : "/updateLike",       
					            data : {'mo_number':mo_num, 'm_id':m_num },
				                error:function(request, status, error){
					        		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					        	},
					            success : function(data) {
					            	
					                    if(data == 0){
					                    	alert("추천완료.");
					                    	location.reload();
					                    	
					                    }
					                    else if (data == 1){
					                     alert("추천취소");
					                    	location.reload();
					                }
					            }
					        });
					     </c:otherwise>
					     </c:choose>
				 
			 })
			
			 $("#reservation").on("click", function () {
				 <c:choose>
					<c:when test="${empty sessionScope.sessionId }">
					alert("로그인해주시길 바랍니다.");
					</c:when>
					<c:otherwise>
					location.href="reservation?mo_number=${movie.mo_number }";
					
					     </c:otherwise>
					     </c:choose>
				 
			})
			
			 $("#choiceMovie").on("click", function () {
				 <c:choose>
					<c:when test="${empty sessionScope.sessionId }">
						alert("로그인해주시길 바랍니다.");
					</c:when>
					<c:otherwise>
						var mo_num = ${movie.mo_number};
						var m_num = "${member.m_id}";
				
					   	 	 $.ajax({
					  	     	     type : "POST",  
					      	 	     url : "/choiceMovie",       
					      	 	     data : {'mo_number':mo_num, 'm_id':m_num},
				          	 	     error:function(request, status, error){
					      	  			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	
					       	 	},
					            success : function(data) {
					            	
					                    if(data == 0){
					                    	alert("관심영화로 등록하셨습니다.");
					                    	location.reload();
					                    	
					                    }
					                  	  else if (data == 1){
					                   	  alert("관심영화 등록을 취소하셨습니다.");
					                    	location.reload();
					                }
					            }
					        }); 
					     </c:otherwise>
					     </c:choose>
				 
			 })
			
				 
		
				
		})
/* function recommendationUpdate(){ 
		
		var mo_num = ${movie.mo_number};
		var m_num = "${member.m_id}";
		
		     $.ajax({
		            type : "POST",  
		            url : "/updateLike",       
		            data : {'mo_number':mo_num, 'm_id':m_num },
	                error:function(request, status, error){
		        		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		        	},
		            success : function(data) {
		            	
		                    if(data == 0){
		                    	alert("추천완료.");
		                    	location.reload();
		                    	$('#recommendationLike').attr("style", "background: red;");
		                    }
		                    else if (data == 1){
		                     alert("추천취소");
		                    	location.reload();
		                }
		            }
		        });
} */
		
	
	
	
	
</script>



</html>