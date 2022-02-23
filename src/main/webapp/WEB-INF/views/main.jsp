<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
timer();
var current=0;
var $interval;

function timer(){
  var $interval=setInterval(function(){slide()},4000);                        
}

function slide(){
  $(".bannerbox").animate(1000,function(){
    $(this).css({"left":0});
    $(".bannerbox").append( $("#slid").children("li").eq(0) );
  });    
  current++;
  if(current==5)current=0;
}    
</script>
<title>메인페이지</title>
<style>
.container{
	text-align: center;
	width: 1000px;
}
.moreBtn{
	background-color: white;
	border-color: black;
    width: 100px;
    height: 40px;
    font-size: 12px;
}
.moreBtn:hover{
	background: black;
	color:white;
}
a{
	color: black;
	border-radius: 5px;
	font-size: 15px;
	margin-left: 5px;
}
h4{
	font-size: 18px;
}
.content{
	overflow-x: hidden;
	width: 1000px;
}
.content2{
	margin-left: -50px;
}
.movie_img{
	border: 1px solid black;
	width: 200px;
	height: 250px;
}
.noticeDate{
	width: 50px;
	height: 50px;
	border: black;
	background-color: black;
	color: white;
	font-size: 15px;
	text-align: center;
}
.slidebanner{
	position:relative;
	height:330px;
	width:1200px;
	overflow:hidden;
}
.slidebanner .bannerbox{
	position:absolute;
	margin-top: 50px;
	margin-left: 112px;
	padding:0;
}
.slidebanner li{
	float:left;
	list-style:none;
	margin-left:10px
}
.slidebanner li:first-child{
	margin:0
}
</style>
</head>
<body>
<div class="container">
	<div class="content">
	<%@ include file="header.jsp"%>
	<div class="content2">
	<div class="slidebanner">
  		<ul class="bannerbox" id="slid">    
		    <li><img src="<%=context%>/img/slide1.png" alt="error" /></li>
  			<li><img src="<%=context%>/img/slide2.png" alt="error" /></li>
  			<li><img src="<%=context%>/img/slide3.png" alt="error" /></li>
  			<li><img src="<%=context%>/img/slide4.png" alt="error" /></li>
  			<li><img src="<%=context%>/img/slide5.png" alt="error" /></li>
  		</ul>                
	</div>
	
	<h1>______</h1>
	<h2 class="main_title">영화</h2>
	<h4 class="sub_title">현재 상영작</h4><br>
	
	<ul>
		<li><img class="movie_img" src="<%=context%>/img/baseball.jpg" alt=""></li>
		<li><img class="movie_img" src="<%=context%>/img/belgium.jpg" alt=""></li>
		<li><img class="movie_img" src="<%=context%>/img/chosun.jpg" alt=""></li>
		<li><img class="movie_img" src="<%=context%>/img/GunPeople.jpg" alt=""></li>
	</ul>
	<ul>
		<li><a href="#"> 영화정보 </a>|<a href="#"> 상영시간 </a>|<a href="<%=context%>/reservation?mo_number=1"> 예매하기 </a></li>
		<li><a href="#"> 영화정보 </a>|<a href="#"> 상영시간 </a>|<a href="#"> 예매하기 </a></li>
		<li><a href="#"> 영화정보 </a>|<a href="#"> 상영시간 </a>|<a href="#"> 예매하기 </a></li>
		<li><a href="#"> 영화정보 </a>|<a href="#"> 상영시간 </a>|<a href="#"> 예매하기 </a></li>
	</ul>
	
	<h1>______</h1>
	<h2 class="main_title">영화</h2>
	<h4 class="sub_title">상영 예정작</h4><br>

	<ul>
		<li><img class="movie_img" src="<%=context%>/img/pregnantTree.jpg" alt=""></li>
		<li><img class="movie_img" src="<%=context%>/img/sewingSister.jpg" alt=""></li>
		<li><img class="movie_img" src="<%=context%>/img/TheShamanSorceress.jpg" alt=""></li>
		<li><img class="movie_img" src="<%=context%>/img/vacation.jpg" alt=""></li>
	</ul>
	
	<h1>______</h1>
	<h2 class="main_title">공지</h2>
	<h4 class="sub_title">Notice & News</h4><br>
	
	<!-- 최신 공지사항 순으로 나열 -->
	<ul>	
		<li>
			<table class="newNotic" style="table-layout:fixed">
				<tr>
				<c:forEach var="bbs" items="${mainBbsList}" begin="0" end="2">	
					<td width="10px">
						<label class="noticeDate">${fn:replace(bbs.bbs_date,'-',' ')}</label>
					</td>	
					<td width="240px">	
						<a href="YM_views/noticeContents?bbs_no=${bbs.bbs_no }&bbs_category=${bbs.bbs_category}">${bbs.bbs_title}</a>
					</td>
				</c:forEach>
				</tr>
			</table>			
		</li>
	</ul>
	
	<br><br><br>
	<button type="button" class="moreBtn" onclick="location.href='YM_views/mainNotice'">더보기+</button>
	<br><br><br>
	</div>
	<%@ include file="footer.jsp"%>
	</div>

</div>
</body>
</html>