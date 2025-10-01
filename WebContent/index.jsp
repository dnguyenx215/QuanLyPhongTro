<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User acc = (User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="zxx">
<head>
<title>Nhà khách SV</title>
<!--/metadata -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<meta name="keywords"
	content="Interior Show Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/font-awesome.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- header and footer stylesheet -->
<link href="css/landing_style.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- //header and footer stylesheet -->
<!-- lightbox css file -->
<link href="css/lightcase.css" rel="stylesheet" type="text/css" />
<!-- css file -->
<link rel="stylesheet" href="css/skin-blue-light.css">
<!-- Testimonials-slider-css-files -->
<link rel="stylesheet" href="css/owl.carousel.css" type="text/css"
	media="all">
<link href="css/owl.theme.css" rel="stylesheet">
<!-- //Testimonials-slider-css-files -->
<!-- online fonts -->
<!-- <link href="//fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet"> -->
<!-- //online fonts -->
<%
	if (request.getAttribute("mess") != null) {
%>
<script type='text/javascript'>alert('<%=request.getAttribute("mess")%>
	');
</script>
<%
	}
%>
</head>

<body>
	<!-- banner -->
	<div class="banner jarallax">
		<header class="main-header">
			<!-- Header Navbar -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Navbar Right Menu -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<%
							if (acc == null) {
						%>
						<!--  <li class="dropdown messages-menu">
								Menu toggle button
								<a href="#" class="dropdown-toggle n10_btn_register" data-toggle="dropdown">Đăng Ký</a>
							</li> -->
						<li class="dropdown messages-menu">
							<!-- Menu toggle button --> <a href="#"
							class="dropdown-toggle n10_btn_login" data-toggle="dropdown">Đăng
								nhập</a>
						</li>

						<%
							} else {
								if (acc.getUserType() == 0) {
						%>
						<li><a href="DashboardServlet">Dashboard</a></li>
						<%
							}
						%>
						<!-- User Account Menu -->
						<li class="dropdown user user-menu">
							<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Tài khoản</a>
							<ul class="dropdown-menu">
								<!-- The user image in the menu -->
								<li class="user-header"><span class="avatar_toggle"><i
										class="fa fa-user-circle"></i></span>

									<p>
										<%=acc.getUserName()%>
										<small><%=acc.getEmail()%></small>
									</p></li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a
											href="<%if (acc.getUserType() == 0) {%>ThongTinAdminServlet<%} else {%>ThongTinUserServlet<%}%>"
											class="n10_btn_header btn btn-default btn-flat">Thông tin</a>
									</div>
									<div class="pull-right">
										<a href="DangXuatServlet"
											class="n10_btn_header btn btn-default btn-flat">Đăng xuất</a>
									</div>
								</li>
							</ul>
						</li>
						<%
							}
						%>
					</ul>
				</div>
			</nav>
		</header>
		<div class="head">
			<div class="container">
				<div class="navbar-top">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<div class="navbar-brand logo ">
							<h1>
								<a href="IndexServlet">Nhà khách</a>
							</h1>
						</div>

					</div>

				</div>
			</div>
		</div>
		<div class="w3layouts-banner-slider">
			<div class="container">
				<div class="slider">
					<div class="callbacks_container">
						<ul class="rslides callbacks callbacks1" id="slider4">
							<li>
								<div class="agileits-banner-info">
									<h3>Welcome to Nhà khách-SV</h3>
									<!-- <p>Sed tempus efficitur ex et elementum. Nulla at diam blandit, posuere dui vel, tempor arcu. Nulla varius.</p> -->
								</div>
							</li>
							<li>
								<div class="agileits-banner-info">
									<h3>Nhà khách sang trọng</h3>
									<p>Hệ thống hiện đại, xây dựng theo công nghệ quốc tế.</p>
								</div>
							</li>

							<li>
								<div class="agileits-banner-info">
									<h3>Giao thông thuận lợi</h3>
									<p>Nằm ở trung tâm thành phố Vinh, tiếp giáp với nhiều con
										đường chính.</p>
								</div>
							</li>
							<li>
								<div class="agileits-banner-info">
									<h3>Hệ thống an ninh tiên tiến</h3>
									<p>Có camera giám sát toàn khu ký túc, bảo vệ túc trực
										24/7.</p>
								</div>
							</li>
						</ul>
					</div>
					<div class="clearfix"></div>
					<script>
						// You can also use "$(window).load(function() {"
						$(function() {
							// Slideshow 4
							$("#slider4")
									.responsiveSlides(
											{
												auto : true,
												pager : true,
												nav : false,
												speed : 500,
												namespace : "callbacks",
												before : function() {
													$('.events')
															.append(
																	"<li>before event fired.</li>");
												},
												after : function() {
													$('.events')
															.append(
																	"<li>after event fired.</li>");
												}
											});

						});
					</script>
					<!--banner Slider starts Here-->
				</div>
			</div>
		</div>
	</div>
	<!-- //banner -->

	<!-- banner-bottom -->
	<div id="about" class="banner-bottom">
		<div class="container">
			<div class="wls_head_all">
				<h3>Nhà khách - SV</h3>
			</div>
			<div class="w3ls_banner_bottom_grid1">
				<div class="col-md-6 w3l_banner_bottom_left">
					<img src="images/ab1.jpg" alt=" " class="img-responsive" />
				</div>
				<div class="col-md-6 w3l_banner_bottom_right">
					<h3>
						Welcome to <span><i>Nhà khách - SV</i></span>
					</h3>
					<p>Nhà khách bao gồm 6 khu nhà 5 tầng được xây dựng trên diện
						tích 25358m2 với 2000 phòng, phục vụ chỗ ở cho 6000 sinh viên.
						Ngoài nhà ở, Nhà khách còn có các công trình phụ trợ hiện đại như:
						khu nhà điều hành, khu sinh hoạt cộng đồng, trạm y tế, nhà ăn,
						siêu thị mini, khu vui chơi giải trí, luyện tập thể thao, thư
						viện,...</p>
					<ul>
						<li><i class="fa fa-table" aria-hidden="true"></i>Khánh thành
							9-2012</li>
						<li><i class="fa fa-map" aria-hidden="true"></i>Trường Thi -
							Vinh - Nghệ An</li>
						<li><i class="fa fa-usd" aria-hidden="true"></i>110.000 vnd/
							người/ tháng</li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //banner-bottom -->
	<!-- services -->
	<div class="services" id="services">
		<div class="container">
			<div class="wls_head_all">
				<h3>Dịch vụ</h3>
			</div>

			<div class="agile_wthree_inner_grids">
				<div class="col-md-8 w3-agileits-services-right">
					<div class="services-right-grids">
						<div class="col-sm-6 services-right-grid">
							<div class="services-icon hvr-radial-in">
								<i class="fa fa-book" aria-hidden="true"></i>
							</div>
							<div class="services-icon-info">
								<h5>Thư viện</h5>
								<p>Chứ nhiều thể loại sách đáp ứng nhu cầu của học sinh sinh
									viên</p>
							</div>
						</div>
						<div class="col-sm-6 services-right-grid">
							<div class="services-icon hvr-radial-in">
								<i class="fa fa-spoon" aria-hidden="true"></i>
							</div>
							<div class="services-icon-info">
								<h5>Nhà ăn</h5>
								<p>Thức ăn đa dạng, mở cử từ 5:30 Sáng đến 23:45</p>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="services-right-grids">
						<div class="col-sm-6 services-right-grid">
							<div class="services-icon hvr-radial-in">
								<i class="fa fa-soccer-ball-o"></i>
							</div>
							<div class="services-icon-info">
								<h5>Thể thao</h5>
								<p>Có nhiều sân bóng phục vụ các môn thể thao như: bóng đá,
									bóng chuyền, cầu lông, bóng bàn, phòng gym, ...</p>
							</div>
						</div>
						<div class="col-sm-6 services-right-grid">
							<div class="services-icon hvr-radial-in">
								<i class="fa fa-medkit" aria-hidden="true"></i>
							</div>
							<div class="services-icon-info">
								<h5>Trạm y tế</h5>
								<p>Có bác sỹ túc trực 24/7 hỗ trợ cho sinh viên có nhu cầu
									khám bệnh với các trang thiết bị hiện đại.</p>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="services-right-grids">
						<div class="col-sm-6 services-right-grid">
							<div class="services-icon hvr-radial-in">
								<i class="fa fa-shopping-cart" aria-hidden="true"></i>
							</div>
							<div class="services-icon-info">
								<h5>Siêu thị mini</h5>
								<p>Có đầy đủ nhu yếu phẩm cho cuộc sống hàng ngày của sinh
									viên, mở cửa 24/7.</p>
							</div>
						</div>
						<div class="col-sm-6 services-right-grid">
							<div class="services-icon hvr-radial-in">
								<i class="fa fa-gamepad" aria-hidden="true"></i>
							</div>
							<div class="services-icon-info">
								<h5>Khu vui chơi</h5>
								<p>Mở của vào buổi tối và các ngày cuối tuần giúp sinh viên
									thư giãn và giải trí.</p>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="col-md-4 w3-agileits-services-left">
					<div class="services-info"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //services -->


	<!-- portfolio -->
	<div class="portfolio" id="gallery">
		<div class="wls_head_all">
			<h3>portfolio</h3>
		</div>

		<div class="container">
			<div class="w3ls_portfolio_grids">
				<div class="col-xs-4 agileinfo_portfolio_grid">
					<div class="w3_agile_portfolio_grid1">
						<a href="images/g1.jpg" class="showcase"
							data-rel="lightcase:myCollection:slideshow" title="SV Room">
							<div
								class="agileits_portfolio_sub_grid agileits_w3layouts_team_grid">
								<div class="w3layouts_port_head">
									<h3>SV Room</h3>
								</div>
								<img src="images/g1.jpg" alt=" " class="img-responsive" />
							</div>
						</a>
					</div>
					<div class="w3_agile_portfolio_grid1">
						<a href="images/g2.jpg" class="showcase"
							data-rel="lightcase:myCollection:slideshow" title="SV Room">
							<div
								class="agileits_portfolio_sub_grid agileits_w3layouts_team_grid">
								<div class="w3layouts_port_head">
									<h3>SV Room</h3>
								</div>
								<img src="images/g2.jpg" alt=" " class="img-responsive" />
							</div>
						</a>
					</div>
					<div class="w3_agile_portfolio_grid1">
						<a href="images/g3.jpg" class="showcase"
							data-rel="lightcase:myCollection:slideshow" title="SV Room">
							<div
								class="agileits_portfolio_sub_grid agileits_w3layouts_team_grid">
								<div class="w3layouts_port_head">
									<h3>SV Room</h3>
								</div>
								<img src="images/g3.jpg" alt=" " class="img-responsive" />
							</div>
						</a>
					</div>
				</div>
				<div class="col-xs-4 agileinfo_portfolio_grid">
					<div class="w3_agile_portfolio_grid1">
						<a href="images/g4.jpg" class="showcase"
							data-rel="lightcase:myCollection:slideshow" title="SV Room">
							<div
								class="agileits_portfolio_sub_grid agileits_w3layouts_team_grid">
								<div class="w3layouts_port_head">
									<h3>SV Room</h3>
								</div>
								<img src="images/g4.jpg" alt=" " class="img-responsive" />
							</div>
						</a>
					</div>
					<div class="w3_agile_portfolio_grid1">
						<a href="images/g5.jpg" class="showcase"
							data-rel="lightcase:myCollection:slideshow" title="SV Room">
							<div
								class="agileits_portfolio_sub_grid agileits_w3layouts_team_grid">
								<div class="w3layouts_port_head">
									<h3>SV Room</h3>
								</div>
								<img src="images/g5.jpg" alt=" " class="img-responsive" />
							</div>
						</a>
					</div>
					<div class="w3_agile_portfolio_grid1">
						<a href="images/g6.jpg" class="showcase"
							data-rel="lightcase:myCollection:slideshow" title="SV Room">
							<div
								class="agileits_portfolio_sub_grid agileits_w3layouts_team_grid">
								<div class="w3layouts_port_head">
									<h3>SV Room</h3>
								</div>
								<img src="images/g6.jpg" alt=" " class="img-responsive" />
							</div>
						</a>
					</div>
				</div>
				<div class="col-xs-4 agileinfo_portfolio_grid">
					<div class="w3_agile_portfolio_grid1">
						<a href="images/g7.jpg" class="showcase"
							data-rel="lightcase:myCollection:slideshow" title="SV Room">
							<div
								class="agileits_portfolio_sub_grid agileits_w3layouts_team_grid">
								<div class="w3layouts_port_head">
									<h3>SV Room</h3>
								</div>
								<img src="images/g7.jpg" alt=" " class="img-responsive" />
							</div>
						</a>
					</div>
					<div class="w3_agile_portfolio_grid1">
						<a href="images/g8.jpg" class="showcase"
							data-rel="lightcase:myCollection:slideshow" title="SV Room">
							<div
								class="agileits_portfolio_sub_grid agileits_w3layouts_team_grid">
								<div class="w3layouts_port_head">
									<h3>SV Room</h3>
								</div>
								<img src="images/g8.jpg" alt=" " class="img-responsive" />
							</div>
						</a>
					</div>
					<div class="w3_agile_portfolio_grid1">
						<a href="images/g9.jpg" class="showcase"
							data-rel="lightcase:myCollection:slideshow" title="Interior">
							<div
								class="agileits_portfolio_sub_grid agileits_w3layouts_team_grid">
								<div class="w3layouts_port_head">
									<h3>Interior</h3>
								</div>
								<img src="images/g9.jpg" alt=" " class="img-responsive" />
							</div>
						</a>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //portfolio -->

	<!-- footer -->
	<footer>
		<div class="agileits-w3layouts-footer">
			<div class="container">
				<div class="col-md-4 w3-agile-grid">
					<h5>About Us</h5>
					<p>Nhà khách - SV là khu ký túc xá dành cho sinh viên có sức
						chứa lên đến 6000 sinh viên.</p>
					<div class="footer-agileinfo-social">
						<ul>
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-rss"></i></a></li>
							<li><a href="#"><i class="fa fa-vk"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-4 w3-agile-grid">
					<h5>Liên hệ nhà khách</h5>
					<form action="LienHeServlet">
						<div class="form-group">
							<label for="pwd"><p>Họ và tên</p></label> <input type="text"
								class="form-control" id="pwd" name="hoTen" required="required">
						</div>
						<div class="form-group">
							<label for="pwd"><p>Email</p></label> <input type="email"
								class="form-control" id="pwd" name="email" required="required">
						</div>
						<div class="form-group">
							<label for="pwd"><p>Tiêu đề</p></label> <input type="text"
								class="form-control" id="pwd" name="chuDe" required="required">
						</div>

						<div class="form-group">
							<label for="comment">Nội dung</label>
							<textarea class="form-control" rows="7" id="comment"
								required="required" name="noiDung"></textarea>
						</div>
						<button type="submit" class="btn btn-success">Gửi ngay</button>
					</form>
				</div>
				<div class="col-md-4 w3-agile-grid">
					<h5>Address</h5>
					<div class="w3-address">
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-phone" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Phone Number</h6>
								<p>0987654321</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-envelope" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Email Address</h6>
								<p>
									Email :<a href="mailto:nhakhachsv@gmail.com.vn">
										nhakhachsv@gmail.com.vn</a>
								</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-map-marker" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Location</h6>
								<p>
									Vinh - Nghệ AN <span>Telephone : +00 111 222 3333</span>
								</p>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="copyright">
			<div class="container">
				<p>© 2019 Nhà khách - SV. All rights reserved | Design by
					Team_15</p>
			</div>
		</div>
	</footer>
	<div class="login-page">
		<div class="login-box">
			<div class="login-logo">
				<p>
					<b>SV</b>_Đăng nhập
				</p>
			</div>
			<!-- /.login-logo -->
			<div class="login-box-body">
				<p class="login-box-msg">
					<i class="n10_icon_login fa fa-user-circle"></i>
				</p>

				<form action="DangNhapServlet" method="post">
					<div class="form-group has-feedback">
						<input type="text" name="userName" class="form-control"
							placeholder="Tên đăng nhập" required> <span
							class="glyphicon glyphicon glyphicon-user form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="password" name="passWord" class="form-control"
							placeholder="Mật Khẩu" required> <span
							class="glyphicon glyphicon-lock form-control-feedback"></span>
					</div>
					<div class="row">
						<!-- /.col -->
						<div class="col-xs-4 col-xs-offset-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat">Đăng
								nhập</button>
						</div>
						<!-- /.col -->
						<!-- <div class="col-xs-12 pull-center " style="margin: 10px 0 0 0;">
							<a href="#" class="text-center register_acc" >Đăng ký tài khoản mới</a>
						</div> -->
					</div>

				</form>
			</div>
			<!-- /.login-box-body -->
		</div>
	</div>


	<!-- Form register -->
	<div class="register-page">
		<div class="register-box">
			<div class="register-logo">
				<p>
					<b>SV</b>_Đăng ký
				</p>
			</div>

			<div class="register-box-body">

				<form action="DangKyUserServlet" method="post">
					<div class="form-group has-feedback">
						<insput type="text" name="userName" class="form-control"
							placeholder="Tên tài khoản" required> <span
							class="glyphicon glyphicon-user form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="email" name="email" class="form-control"
							placeholder="Email" required> <span
							class="glyphicon glyphicon-envelope form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="password" name="passWord" class="form-control"
							placeholder="Mật khẩu" required> <span
							class="glyphicon glyphicon-lock form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="password" name="rePass" class="form-control"
							placeholder="Nhập lại mật khẩu" required> <span
							class="glyphicon glyphicon-log-in form-control-feedback"></span>
					</div>
					<div class="row">
						<!-- /.col -->
						<div class="col-xs-4 col-xs-offset-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat">Đăng
								ký</button>
						</div>
						<!-- /.col -->
						<div class="col-xs-12 pull-center " style="margin: 10px 0 0 0;">
							<a href="#" class="text-center have_acc">Đã có tài khoản</a>
						</div>
					</div>
				</form>
			</div>
			<!-- /.form43-box -->
		</div>
	</div>
	<!-- //footer -->

	<!-- //bootstrap-modal-pop-up -->

	<!-- js -->
	<script src="js/jquery-2.2.3.min.js"></script>
	<!-- //js-->

	<!-- banner-responsive-slider -->
	<script src="js/responsiveslides.min.js"></script>
	<script>
		// You can also use "$(window).load(function() {"
		$(function() {
			// Slideshow 4
			$("#slider4").responsiveSlides({
				auto : true,
				pager : true,
				nav : false,
				speed : 500,
				namespace : "callbacks",
				before : function() {
					$('.events').append("<li>before event fired.</li>");
				},
				after : function() {
					$('.events').append("<li>after event fired.</li>");
				}
			});

		});
	</script>
	<!-- //banner-responsive-slider -->

	<!-- light-case -->
	<script src="js/lightcase.js"></script>
	<script>
		$('.showcase').lightcase();
	</script>
	<!-- //light-case -->

	<!-- for testimonials slider-js-file-->
	<script src="js/owl.carousel.js"></script>
	<!-- //for testimonials slider-js-file-->
	<script>
		$(document).ready(function() {
			$("#owl-demo").owlCarousel({

				autoPlay : 3000, //Set AutoPlay to 3 seconds
				autoPlay : true,
				items : 3,
				itemsDesktop : [ 640, 5 ],
				itemsDesktopSmall : [ 414, 4 ]
			});
		});
	</script>
	<!-- for testimonials slider-js-script-->

	<!-- smooth-scrolling -->
	<script src="js/move-top.js"></script>
	<script src="js/easing.js"></script>
	<script>
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event) {
				event.preventDefault();

				$('html,body').animate({
					scrollTop : $(this.hash).offset().top
				}, 1000);
			});
		});
	</script>
	<script src="js/SmoothScroll.min.js"></script>
	<!-- //smooth-scrolling -->
	<script>
		$(document).ready(function() {
			/*
			var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			};
			 */

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<!-- smooth-scrolling-of-move-up -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main_update.js"></script>

</body>

</html>