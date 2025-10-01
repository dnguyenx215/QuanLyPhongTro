<%@page import="common.KiemTra"%>
<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%
	User acc = (User) session.getAttribute("user");
	String thanhCong = (String) request.getAttribute("thanhCong");
	String thatBai = (String) request.getAttribute("thatBai");
%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Nhà khách sinh viên</title>

<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="css/font-awesome.css">
<!-- Ionicons -->
<link rel="stylesheet" href="css/ionicons.min.css">
<!-- Select 2 -->
<link rel="stylesheet" href="css/select2.min.css">

<!-- Morris -->
<link rel="stylesheet" href="css/morris.css">

<link rel="stylesheet" href="css/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">

<link rel="stylesheet" href="css/skin-blue-light.css">
</head>

<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<header class="main-header">

			<!-- Logo -->
			<a href="IndexServlet" class="logo"> <span class="logo-mini"><i
					class="fa fa-home"></i></span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg "><i class="fa fa-home logo-icon-mini"></i><b>Nhà
						khách</b>-SV</span>
			</a>

			<!-- Header Navbar -->
			<nav class="navbar navbar-static-top" role="navigation">

				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="push-menu"
					role="button"> </a>

				<!-- Navbar Right Menu -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<%
							if (acc != null) {
						%>
						<!-- Messages: style can be found in dropdown.less-->

						<li><a href="DanhSachLienHeServlet"><i
								class="fa fa-envelope"></i></a></li>
						<!-- /.messages-menu -->

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
										<a href="ThongTinAdminServlet"
											class="btn btn-default btn-flat">Thông tin</a>
									</div>
									<div class="pull-right">
										<a href="DangXuatServlet" class="btn btn-default btn-flat">Đăng
											xuất</a>
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


		<!-- SideBar -->
		<aside class="main-sidebar">

			<section class="sidebar">

				<div class="user-panel">
					<div class="pull-left image">
						<span class="avatar_log"><i class="fa fa-user-circle"></i></span>
					</div>
					<div class="pull-left info">

						<!-- UserName -->
						<p><%=acc.getUserName()%></p>
						<!-- Status -->
						<a href="#"><i class="fa fa-circle text-success"></i><%=KiemTra.layTrangThai(acc.getUserStatus())%></a>
					</div>
				</div>



				<!-- Sidebar Menu -->

				<ul class="sidebar-menu" data-widget="tree">
					<li><a href="DashboardServlet"><i class="fa fa-dashboard"></i>
							<span>Dashboard</span></a></li>
					<li class="treeview"><a href="#"><i class="fa fa-users"></i>
							<span>User</span> <span class="pull-right-container"> <i
								class="fa fa-angle-left pull-right "></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="ThemUserServlet"><i class="fa fa-circle-o"></i>Thêm
									mới</a></li>
							<li><a href="DanhSachUserServlet"><i
									class="fa fa-circle-o"></i>Danh sách</a></li>
						</ul></li>

					<li class="treeview "><a href="#"><i
							class="fa fa-graduation-cap"></i> <span>Sinh viên</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right "></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="ThemSinhVienServlet"><i
									class="fa fa-circle-o"></i>Thêm mới</a></li>
							<li><a href="DanhSachSinhVienServlet"><i
									class="fa fa-circle-o"></i>Danh sách</a></li>
						</ul></li>

					<li class="treeview "><a href="#"><i
							class="fa fa-university"></i> <span>Trường học</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right "></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="ThemTruongServlet"><i
									class="fa fa-circle-o"></i>Thêm mới</a></li>
							<li><a href="DanhSachTruongServlet"><i
									class="fa fa-circle-o"></i>Danh sách</a></li>
						</ul></li>

					<li class="treeview"><a href="#"><i class="fa fa-file"></i>
							<span>Hợp đồng</span> <span class="pull-right-container">
								<i class="fa fa-angle-left pull-right "></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="ThemHopDongServlet"><i
									class="fa fa-circle-o"></i>Thêm mới</a></li>
							<li><a href="DanhSachHopDongServlet"><i
									class="fa fa-circle-o"></i>Danh sách</a></li>
						</ul></li>

					<li class="treeview"><a href="#"><i class="fa fa-home"></i>
							<span>Phòng ở</span> <span class="pull-right-container"> <i
								class="fa fa-angle-left pull-right "></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="ThemPhongServlet"><i class="fa fa-circle-o"></i>Thêm
									mới</a></li>
							<li><a href="DanhSachPhongServlet"><i
									class="fa fa-circle-o"></i>Danh sách</a></li>
						</ul></li>

					<li class="treeview"><a href="#"><i class="fa fa-building"></i>
							<span>Khu nhà</span> <span class="pull-right-container"> <i
								class="fa fa-angle-left pull-right "></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="ThemKhuNhaServlet"><i
									class="fa fa-circle-o"></i>Thêm mới</a></li>
							<li><a href="DanhSachKhuNhaServlet"><i
									class="fa fa-circle-o"></i>Danh sách</a></li>
						</ul></li>

					<li class="treeview "><a href="#"><i class="fa fa-user-md"></i>
							<span>Nhân viên</span> <span class="pull-right-container">
								<i class="fa fa-angle-left pull-right "></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="ThemNhanVienServlet"><i
									class="fa fa-circle-o"></i>Thêm mới</a></li>
							<li><a href="DanhSachNhanVienServlet"><i
									class="fa fa-circle-o"></i>Danh sách</a></li>
						</ul></li>

					<li class="treeview"><a href="#"><i
							class="fa  fa-file-text"></i> <span>Hóa đơn</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right "></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="ThemHoaDonServlet"><i
									class="fa fa-circle-o"></i>Thêm mới</a></li>
							<li><a href="DanhSachHoaDonServlet"><i
									class="fa fa-circle-o"></i>Danh sách</a></li>
						</ul></li>
					<li class="treeview"><a href="#"><i class="fa fa-gavel"></i>
							<span>Kỷ luật</span> <span class="pull-right-container"> <i
								class="fa fa-angle-left pull-right "></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="ThemKyLuatServlet"><i
									class="fa fa-circle-o"></i>Thêm mới</a></li>
							<li><a href="DanhSachKyLuatServlet"><i
									class="fa fa-circle-o"></i>Danh sách</a></li>
						</ul></li>
					<li class=""><a href="DanhSachLienHeServlet"><i class="fa fa-phone"></i>
							<span>Liên hệ</span> <span class="pull-right-container">
						</span> </a> <!-- <ul class="treeview-menu">
							<li><a href="DanhSachLienHeServlet"><i
									class="fa fa-circle-o"></i>Danh sách</a></li>
						</ul></li> --></ul>

				<!-- /.sidebar-menu -->


			</section>
			<!-- /.sidebar -->
		</aside>


		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">

			<%
				if (thanhCong != null) {
			%>
			<div class="alert alert-success ">
				<center>
					<strong><%=thanhCong.toString()%></strong>
				</center>

			</div>
			<%
				}
				if (thatBai != null) {
			%>
			<div class="alert alert-warning">
				<center>
					<strong> <%=thatBai.toString()%>
					</strong>
				</center>
			</div>
			<%
				}
			%>