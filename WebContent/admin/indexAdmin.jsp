<%@page import="model.bean.User"%>
<%@page import="model.bean.KhuNha"%>
<%@page import="java.util.Hashtable"%>
<%@page import="model.bean.Phong"%>
<%@page import="model.bean.SinhVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Trang chủ</title>

<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="css/font-awesome.css">
<!-- Ionicons -->
<link rel="stylesheet" href="css/ionicons.min.css">
<!-- Theme style -->
<!-- Date picker -->
<link rel="stylesheet" href="css/bootstrap-datepicker.min.css">

<link rel="stylesheet" href="css/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">

<link rel="stylesheet" href="css/skin-blue-light.css">
</head>

<body class="hold-transition skin-blue-light sidebar-mini">
<%
User user=(User) session.getAttribute("user");
if(user==null){
	response.sendRedirect("../dangNhap.jsp");
	return;
}
else if(user.getUserType()==1){
	response.sendRedirect("../404.jsp");
	return;
}
%>
	<div class="wrapper">

		<!-- Main Header -->
		<header class="main-header">

			<!-- Logo -->
			<a href="IndexServlet" class="logo"> <span class="logo-mini"><i
					class="fa fa-home"></i></span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg "><i class="fa fa-home logo-icon-mini"></i><b>
						Team</b>10</span>
			</a>

			<!-- Header Navbar -->
			<nav class="navbar navbar-static-top" role="navigation">

				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="push-menu"
					role="button"> </a>

				<!-- Navbar Right Menu -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">

						<!-- Messages: style can be found in dropdown.less-->
						<li class="dropdown messages-menu">
							<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="fa fa-envelope"></i>

						</a>
						</li>
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
										Alexander Pierce <small>ahihi@gmai.com</small>
									</p></li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Thông tin</a>
									</div>
									<div class="pull-right">
										<a href="DangXuatServlet" class="btn btn-default btn-flat">Đăng
											xuất</a>
									</div>
								</li>
							</ul>
						</li>
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
						<p>Alexander Pierce</p>
						<!-- Status -->
						<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
					</div>
				</div>



				<!-- Sidebar Menu -->
				<ul class="sidebar-menu" data-widget="tree">
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

					<li class="treeview"><a href="#"><i
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

					<li class="treeview active menu-open"><a href="#"><i
							class="fa fa-file"></i> <span>Hợp đồng</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right "></i>
						</span> </a>
						<ul class="treeview-menu" style="display: block;">
							<li><a href="ThemHopDongServlet"
								class="n10_menu_child_active"><i class="fa fa-dot-circle-o"></i>Thêm
									mới</a></li>
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
					<li class="treeview"><a href="#"><i class="fa fa-user-md"></i>
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
					<li class="treeview"><a href="#"><i class="fa fa-phone"></i>
							<span>Liên hệ</span> <span class="pull-right-container"> <i
								class="fa fa-angle-left pull-right "></i>
						</span> </a>
						<ul class="treeview-menu">
							<li><a href="DanhSachLienHeServlet"><i
									class="fa fa-circle-o"></i>Danh sách</a></li>
						</ul></li>
				</ul>
				<!-- /.sidebar-menu -->
			</section>
			<!-- /.sidebar -->
		</aside>


		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">

			<!-- Main content -->
			<!-- Tạo form và table vào đây ===================================================================-->
			<section class="content n10_content container-fluid">
				<div class="row">
					<div class="box col-sm-12">
						<div class="box-header pull-center">
							<h3 class="box-title">Danh sách phòng</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
						
							<table id="dataTable" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>Phòng</th>
										<th>Khu nhà</th>
										<th>Nam/ Nữ</th>
										<th>Trạng thái</th>
										<th class="pull-center">Tùy chọn</th>
									</tr>
								</thead>
								<tbody>
									<%
										ArrayList<Phong> dsPhongTrong = (ArrayList<Phong>) request.getAttribute("dsPhongTrong");
										ArrayList<Phong> dsPhongNu = (ArrayList<Phong>) request.getAttribute("dsPhongNu");
										ArrayList<Phong> dsPhongNam = (ArrayList<Phong>) request.getAttribute("dsPhongNam");
										Hashtable<Integer, KhuNha> dsKhu = (Hashtable<Integer, KhuNha>) request.getAttribute("dsKhu");
									%>
									
									<%
										for (Phong p : dsPhongNam) {
									%>
									<tr>
										<td><%=p.getTenPhong()%></td>
										<td><%=dsKhu.get(p.getIdKhuNha()).getKhuNha()%></td>
										<td>Nam</td>
										<td><%=p.getSoNguoiHienTai()%>/<%=p.getSoNguoiToiDa()%></td>
										<td class="pull-center"><a href="themHopDong.html"
											class="btn btn-info n10_list_link">Đăng ký</a></td>
									</tr>
									<%
										}
									%>
									<%
										for (Phong p : dsPhongNu) {
									%>
									<tr>
										<td><%=p.getTenPhong()%></td>
										<td><%=dsKhu.get(p.getIdKhuNha()).getKhuNha()%></td>
										<td>Nữ</td>
										<td><%=p.getSoNguoiHienTai()%>/<%=p.getSoNguoiToiDa()%></td>
										<td class="pull-center"><a href="themHopDong.html"
											class="btn btn-info n10_list_link">Đăng ký</a></td>
									</tr>
									<%
										}
									%>
									<%
										for (Phong p : dsPhongTrong) {
									%>
									<tr>
										<td><%=p.getTenPhong()%></td>
										<td><%=dsKhu.get(p.getIdKhuNha()).getKhuNha()%></td>
										<td>-</td>
										<td><%=p.getSoNguoiHienTai()%>/<%=p.getSoNguoiToiDa()%></td>
										<td class="pull-center"><a href="themHopDong.html"
											class="btn btn-info n10_list_link">Đăng ký</a></td>
									</tr>
									<%
										}
									%>
								</tbody>
								<tfoot>
									<tr>
										<th>Phòng</th>
										<th>Khu nhà</th>
										<th>Nam/ Nữ</th>
										<th>Trạng thái</th>
										<th class="pull-center">Tùy chọn</th>
									</tr>
								</tfoot>
							</table>
						</div>
						<!-- /.box-body -->
					</div>
				</div>
			</section>
			<!-- Thêm xong ================================================================================-->
		</div>

		<!-- Main Footer -->
		<footer class="main-footer">
			<div class="pull-center hidden-xs">
				<strong>Copyright &copy; 2018 <a href="#">N10</a>.
				</strong> All rights reserved.
			</div>

		</footer>

	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED JS SCRIPTS -->

	<!-- jQuery 3 -->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<!-- Select2 -->
	<script type="text/javascript" src="js/select2.full.min.js"></script>
	<script>
	  $(function () {
	    $('#dataTable').DataTable()
	    $('#dataTable2').DataTable({
	      'paging'      : true,
	      'lengthChange': false,
	      'searching'   : false,
	      'ordering'    : true,
	      'info'        : true,
	      'autoWidth'   : false
	    })
	  })
	</script>
	<!-- AdminLTE App -->
	<!-- Table -->
	<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
	<!-- Main -->
	<script type="text/javascript" src="js/adminlte.min.js"></script>
	<script type="text/javascript" src="js/main_update.js"></script>

</body>
</html>