<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
		<title>Home</title>
		<link href="css/homestyle.css" rel="stylesheet" type="text/css" media="all" />
		<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
		<!-- <link href='http://fonts.useso.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
		<link href='http://fonts.useso.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700italic,700,900,900italic' rel='stylesheet' type='text/css'> -->
		<!-- js -->
		<script src="js/homejquery.min.js"></script>
		<!-- //js -->
		<!-- for-mobile-apps -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Galaxy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
				function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!-- //for-mobile-apps -->
		<!-- start-smoth-scrolling -->
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript">
			/* jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			}); */
		</script>
<!-- start-smoth-scrolling -->
</head>
	
<body>
<!-- header -->
	<div class="header">
	<div class="container">
		<div class="header-part">
			<div class="head-logo">
				<a href="index.jsp"><img src="images/001.png" alt=" "></a>
			</div>
			<div class="top-nav">
				<span class="menu"><img src="images/002.png" alt="" /></span>
					<ul class="nav1">
						<li><a href="#" class="scroll">Home</a></li>
						<li><a href="${pageContext.request.contextPath}/subject_list.do" class="scroll">Week</a></li>
						<li><a href="${pageContext.request.contextPath}/subjectList.do" class="scroll">Stage</a></li>
						<li><a href="${pageContext.request.contextPath}/choose_practice.do" class="scroll">Practice</a></li>
						<li><a href="${pageContext.request.contextPath }/user_centre.jsp" class="scroll">personal</a></li>
					</ul>
					<script> 
							   $( "span.menu" ).click(function() {
								 $( "ul.nav1" ).slideToggle( 300, function() {
								 // Animation complete.
								  });
								 });
							
					</script>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	</div>
<!-- //header -->
<!-- banner -->
	<div class="banner">
	<div class="container">
		<div class="banner-info">
			<h2>学海无涯</h2>
			<p>boundless sea of learning</p>
			<div class="more">
				<a href="#">登录/注册</a>
			</div>
		</div>
	</div>
	</div>
<!-- //banner -->
<!-- banner-bottom -->
	<div class="banner-bottom">
	<div class="container">
		<div class="banner-bottom-left">
			<div class="fig">
				
			</div>
			<h3>Profession</h3>
			<p>Lorem ipsum dolor sit amet<span> est oben dis</span></p>
		</div>
		<div class="banner-bottom-left banner-bottom-mid">
			<div class="fig1">
				
			</div>
			<h3>Flexible Design</h3>
			<p>Lorem ipsum dolor sit amet<span> est oben dis</span></p>
		</div>
		<div class="banner-bottom-left">
			<div class="fig2">
				
			</div>
			<h3>Reliable</h3>
			<p>Lorem ipsum dolor sit amet<span> est oben dis</span></p>
		</div>
		
		<div class="clearfix"> </div>
		<!-- pricing -->
	<div id="price" class="pricing">
	<div class="container">
		<div class="price">
			<h2>测评模式</h2>
			<p>根据不同的学习者配套针对的测评模式
				<span>总有一种适合你</span></p>
		</div>
		<div class="basic">
			<div class="business">
				<h2>周测评</h2>
				<p>Week Exam</p>
			</div>
			<div class="value">
				<p>19,99$</p>
			</div>
			<ul>
				<li><span>50</span> Projects</li>
				<li><span>20</span> Files</li>
				<li><span>Full</span> Support</li>
				<li class="gd"><span>24h</span> Ready</li>
			</ul>
			<div class="buy-me">
				<a href="${pageContext.request.contextPath}/subject_list.do">Click Me</a>
			</div>
		</div>
		<div class="basic basic-mid">
			<div class="business">
				<h2>阶段测评</h2>
				<p>Stage Exam</p>
			</div>
			<div class="value">
				<p>49,99$</p>
			</div>
			<ul>
				<li><span>50</span> Projects</li>
				<li><span>20</span> Files</li>
				<li><span>Full</span> Support</li>
				<li class="gd"><span>24h</span> Ready</li>
			</ul>
			<div class="buy-me">
				<a href="${pageContext.request.contextPath}/subjectList.do">Click Me</a>
			</div>
		</div>
		<div class="basic">
			<div class="business">
				<h2>刷题</h2>
				<p>Practice Question</p>
			</div>
			<div class="value">
				<p>99,99$</p>
			</div>
			<ul>
				<li><span>50</span> Projects</li>
				<li><span>20</span> Files</li>
				<li><span>Full</span> Support</li>
				<li class="gd"><span>24h</span> Ready</li>
			</ul>
			<div class="buy-me">
				<a href="${pageContext.request.contextPath}/choose_practice.do">Click Me</a>
			</div>
		</div>
		<div class="clearfix"> </div>
	</div>
	</div>
<!-- //pricing -->
		
		<div class="banner-bottom-text">
			<p>"I Want to make beautiful things,even if nobody cares,
				<span>as opposed to ugly things.That's my intent."</span></p>
		</div>
	
	</div>
	</div>
<!-- //banner-bottom -->

<!-- about -->
	
<!-- //about -->


<!-- footer -->
	<div class="footer">
	<div class="container">
		<div class="footer-left">
			<div class="footer-left-text">
				
			</div>
			<div class="clearfix"> </div>
		</div>
		<div class="footer-right">
			<ul>
				<li><a href="#" class="facebook"> </a></li>
				<li><a href="#" class="twitter"> </a></li>
				<li><a href="#" class="dribble"> </a></li>
			</ul>
		</div>
		<div class="clearfix"> </div>
	</div>
	</div>
<!-- //footer -->
<!-- here stars scrolling icon -->
	<script type="text/javascript">
									$(document).ready(function() {
										/*
										var defaults = {
								  			containerID: 'toTop', // fading element id
											containerHoverID: 'toTopHover', // fading element hover id
											scrollSpeed: 1200,
											easingType: 'linear' 
								 		};
										*/
										
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
	</script>
<!-- //here ends scrolling icon -->
</body>
</html>
