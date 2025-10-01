<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
User acc=(User) session.getAttribute("user");

%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Ký túc xá DMC Đà Nẵng</title>

  <link rel="stylesheet" href="css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="css/font-awesome.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="css/ionicons.min.css">
  <!-- Slick style -->
  <link rel="stylesheet" type="text/css" href="css/slick.css">
  <link rel="stylesheet" type="text/css" href="css/slick-theme.css">

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
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
          <ul class="nav navbar-nav">

            <%
            	if(acc==null){
            %>
				<li class="dropdown messages-menu">
              		<!-- Menu toggle button -->
              		<a href="#" class="dropdown-toggle n10_btn_login" data-toggle="dropdown">Đăng nhập</a>
            	</li>
            <%
            	}else{ 
            		if(acc.getUserType()==0){
            
            %>
            	<!-- Messages: style can be found in dropdown.less-->
            		<li >
              		<!-- Menu toggle button -->
             			<a href="DashboardServlet" >Dashboard</a>
            		</li>
            <%} %>
            <!-- Messages: style can be found in dropdown.less-->
            <li class="dropdown messages-menu">
              <!-- Menu toggle button -->
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <i class="fa fa-envelope"></i>
                
              </a>
            </li>
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
                    <a href="<%if(acc.getUserType()==0){%>ThongTinAdminServlet<%}else{%>ThongTinUserServlet<%} %>" class="btn btn-default btn-flat">Thông tin</a>
                  </div>
                  <div class="pull-right">
                    <a href="DangXuatServlet" class="btn btn-default btn-flat">Đăng xuất</a>
                  </div>
                </li>
              </ul>
            </li>
          	<%} %>
          </ul>
        </div>
      </nav>
    </header>


    <div class="n10-header_slide">
      <div class="n10-slide-item">
        <div class="n10-slider_content">
          <h3 class="n10-slide-title">Chào mừng đến với DMC Đà Nẵng</h3>
          <p class="n10-slide-descreption">The background images for the slider are set directly in the HTML using inline CSS. The rest of the styles for this template are contained within the</p>
        </div>
      </div>
      <div class="n10-slide-item">
        <div class="n10-slider_content">
          <h3 class="n10-slide-title">Chào mừng đến với DMC Đà Nẵng</h3>
          <p class="n10-slide-descreption">The background images for the slider are set directly in the HTML using inline CSS. The rest of the styles for this template are contained within the</p>
        </div>
      </div>
      <div class="n10-slide-item">
        <div class="n10-slider_content">
          <h3 class="n10-slide-title">Chào mừng đến với DMC Đà Nẵng</h3>
          <p class="n10-slide-descreption">The background images for the slider are set directly in the HTML using inline CSS. The rest of the styles for this template are contained within the</p>
        </div>
      </div>
      <div class="n10-slide-item">
        <div class="n10-slider_content">
          <h3 class="n10-slide-title">Chào mừng đến với DMC Đà Nẵng</h3>
          <p class="n10-slide-descreption">The background images for the slider are set directly in the HTML using inline CSS. The rest of the styles for this template are contained within the</p>
        </div>
      </div>
      <div class="n10-slide-item">
        <div class="n10-slider_content">
          <h3 class="n10-slide-title">Chào mừng đến với DMC Đà Nẵng</h3>
          <p class="n10-slide-descreption">The background images for the slider are set directly in the HTML using inline CSS. The rest of the styles for this template are contained within the</p>
        </div>
      </div>
    </div>


    <!-- Page Content -->
    <section class="py-5">
      <div class="container">
      <h3><%
      if(request.getAttribute("err")!=null){
    	 
    	%>  <script type='text/javascript'>alert('<%=request.getAttribute("err")%>');</script>
     <% }
      %> </h3>
        <h1>Half Slider by Start Bootstrap</h1>
        <p>The background images for the slider are set directly in the HTML using inline CSS. The rest of the styles for this template are contained within the
          <code>half-slider.css</code>
          file.</p>
      </div>
    </section>





    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Form login -->
    <div class="login-page">
      <div class="login-box">
        <div class="login-logo">
          <p><b>DMC</b>_Login</p>
        </div>
        <!-- /.login-logo -->
        <div class="login-box-body">
          <p class="login-box-msg"><i class="n10_icon_login fa fa-user-circle"></i></p>

          <form action="DangNhapServlet" method="post">
            <div class="form-group has-feedback">
              <input type="text" name="userName" class="form-control" placeholder="Tên đăng nhập">
              <span class="glyphicon glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
              <input type="password" name="passWord" class="form-control" placeholder="Mật Khẩu">
              <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
              <!-- /.col -->
              <div class="col-xs-4 col-xs-offset-4">
                <button type="submit" class="btn btn-primary btn-block btn-flat">Đăng nhập</button>
              </div>
              <!-- /.col -->
              <div class="col-xs-12 pull-center " style="margin: 10px 0 0 0;">
                <a href="#" class="text-center register_acc" >Đăng ký tài khoản mới</a>
              </div>
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
         <p><b>DMC</b>_Register</p>
        </div>

        <div class="register-box-body">

          <form action="DangKyUserServlet" method="post">
            <div class="form-group has-feedback">
              <input type="text" name="userName" class="form-control" placeholder="Tên tài khoản">
              <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
              <input type="email" name="email" class="form-control" placeholder="Email">
              <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
              <input type="password" name="passWord" class="form-control" placeholder="Mật khẩu">
              <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
              <input type="password" name="rePass" class="form-control" placeholder="Nhập lại mật khẩu">
              <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            </div>
            <div class="row">
              <!-- /.col -->
              <div class="col-xs-4 col-xs-offset-4">
                <button type="submit" class="btn btn-primary btn-block btn-flat">Đăng ký</button>
              </div>
              <!-- /.col -->
              <div class="col-xs-12 pull-center " style="margin: 10px 0 0 0;">
                <a href="#" class="text-center have_acc" >Đã có tài khoản</a>
              </div>
            </div>
          </form>

          
        </div>
        <!-- /.form43-box -->
      </div>
  </div>
  </div>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript"  src="js/jquery.min.js"></script>
    <!-- Bootstrap 3.3.7 -->
    <script type="text/javascript"  src="js/bootstrap.min.js"></script>
    <!-- Slick -->
    <script src="js/slick.min.js" type="text/javascript" charset="utf-8"></script>
    <!-- Main -->
    <script type="text/javascript" src="js/main_update.js"></script>
    <script type="text/javascript">
      $(".n10-header_slide").slick({
        autoplay: true, 
        autoplaySpeed: 1000
      });
    </script>


  </body>

</html>
