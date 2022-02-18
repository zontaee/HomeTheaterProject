<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR&display=swap" rel="stylesheet"><meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function search() {
		var search = document.getElementById("search").value;
		console.log("ddddd", search);

		var form = document.getElementById("search").value;

	}
	//input에 받은 text값을 bbs_title에도 넘겨주기위한 기능
	function getInputValue(){
		var valueByName = $('input[name=mo_title]').val();
		$("#bbs_title").val(valueByName);
	}
</script>
<title>header</title>
<style>
	*{
		font-family: 'Noto Serif KR', serif;
	}
	.container{
		text-align: center;
		width: 1000px;
	}
	.btn{
		background-color: white;
		border-color: black;
		border: 1px solid black;
		border-radius: 10px;
		font-size: 12px;
	}
	.content{
		overflow-x: hidden;
		width: 1000px;
	}
	.logo{
		text-align: left;
		margin-bottom: -20px;
	}
	.top_menu{
		text-align: center;
		border-bottom: 1px solid black;
		border-top: 1px solid black;
		margin-top: 10px;
		padding-top: 10px;
	}
	li{
		list-style: none;
		display: inline-block;
		margin: auto 10px;
	}
	a{
		color: black;
		border-radius: 5px;
		font-size: 15px;
	}
	a:hover{
		color: black;
		background-color: #D5D5D5;
	}
	.menuLink{
		width: 100px;
		display: block;
	}
	.menuLink:hover{
		color: black;
		background-color: #D5D5D5;
	}
	.loginJoin{
		text-align: right;
	}
	.myPaygeLogout{
		text-align: right;
	}
	.submitBtn{
		background-color: white;
		border-color: black;
		border: 1px solid black;
		border-radius: 5px;
		font-size: 10px;
	}
</style>
</head>
<body>
<!-- 외장 톰켓 고유주소 -->
<%
	String context = request.getContextPath();
%>
<div class="logo">
	<a href="<%=context%>/main">
		<img src="<%=context%>/img/logo1.png" style="" width="250px" height="100">
	</a>
</div>

<c:choose>
	<c:when test="${empty userName}">
		<div class="loginJoin">
			<a href="<%=context%>/loginForm">Login </a>&nbsp;|&nbsp;
			<a href="<%=context%>/terms">Join</a>
		</div>
	</c:when>
	<c:otherwise>
		<div class="myPaygeLogout">
			<i class="fas fa-user" style="font-size: 15px;"></i>
			<a href="<%=context%>/myPage">[${userName}님]</a>
			<a href="<%=context%>/logout">Logout</a>
		</div>
	</c:otherwise>
</c:choose>


<nav class="top_menu">
	<form name="searchInfo" action="SearchTotalList" method="get">
		<ul>
			<li><a class="menuLink" href="<%=context%>/movieList">영화</a></li>
			<li><a class="menuLink" href="<%=context%>/movieRecommendList">추천영화</a></li>
			<li><a class="menuLink" href="<%=context%>/YM_views/mainNotice">공지사항</a></li>
			<li><a class="menuLink" href="#">고객센터</a></li>
			<li><i class="fas fa-search" style="font-size: 15px;"></i>&nbsp;
				<input type="text" name="mo_title" id="mo_title" style="width: 100px;" placeholder="통합 검색"
					   required oninvalid="this.setCustomValidity('검색어를 입력해주세요.')"
					   oninput = "setCustomValidity('')"/>
				<input type="hidden" name="bbs_title" id="bbs_title">
				<input type="submit" class="submitBtn" value="검색" onclick="getInputValue();"></li>
		</ul>
	</form>
</nav>
</body>
</html>