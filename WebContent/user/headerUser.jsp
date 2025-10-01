<%@page import="common.KiemTra"%>
<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US">
<%
User acc=(User) session.getAttribute("user");
%>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>DMC-579 Đà Nẵng</title>

  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="css/font-awesome.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="css/ionicons.min.css">
  <!-- Theme style -->
  <!-- Date picker -->


  <link rel="stylesheet" href="css/dataTables.bootstrap.min.css">
  <link rel="stylesheet" href="css/style.css">

  <link rel="stylesheet" href="css/skin-blue-light.css">
</head>

<body class="hold-transition skin-blue-light sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="IndexServlet" class="logo">
      <span class="logo-mini"><i class="fa fa-home"></i></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg "><i class="fa fa-home logo-icon-mini"></i><b> DMC</b>-579</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">

          <!-- Messages: style can be found in dropdown.less-->
        
          <!-- /.messages-menu -->

          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Tài khoản</a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <span class="avatar_toggle"><i class="fa fa-user-circle"></i></span>

               	<p>
                    <%=acc.getUserName() %>
                    <small><%=acc.getEmail() %></small>
                  </p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="ThongTinUserServlet" class="btn btn-default btn-flat">Thông tin</a>
                </div>
                <div class="pull-right">
                  <a href="DangXuatServlet" class="btn btn-default btn-flat">Đăng xuất</a>
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
          <p><%=acc.getUserName() %></p>
          <!-- Status -->
          <a href="#"><i class="fa fa-circle text-success"></i><%=KiemTra.layTrangThai(acc.getUserStatus()) %></a>
        </div>
      </div>



      <!-- Sidebar Menu -->
      <ul class="sidebar-menu" data-widget="tree">

        <li class="n10_home">
          <a href="IndexServlet"><i class="fa fa-home"></i> <span>Trang chủ</span>
          </a>
        </li>
        <li class="n10_user_contact">
          <a href="LienHeServlet"><i class="fa fa-phone"></i> <span>Liên hệ</span>
          </a>
        </li>
        <li class="treeview ">
          <a href="#"><i class="fa fa-users"></i> <span>Tên tài khoản</span>
            <span class="pull-right-container">
             <i class="fa fa-angle-left pull-right "></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="ThongTinUserServlet"><i class="fa fa-circle-o"></i>Thông tin</a></li>
            <li><a href="DoiMatKhauUserServlet"><i class="fa fa-circle-o"></i>Đổi mật khẩu</a></li>
          </ul>
        </li>
        
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>


  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
