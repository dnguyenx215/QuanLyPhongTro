<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute("user");
	if (user == null) {
		response.sendRedirect("IndexServlet");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Team10 | Đăng nhập</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="css/style.css">


</head>
<body class="hold-transition register-page">

	<div class="register-box">
		<div class="register-logo">
			<a href="dangky.jsp"><b>TEAM10</b>TT</a>
		</div>

		<div class="register-box-body">
			<p class="login-box-msg">Đăng ký thành viên</p>

			<form action="DangKyUserServlet" method="post">
				<div class="form-group has-feedback">
					<input type="text" name="userName" class="form-control"
						placeholder="Tên tài khoản"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="email" name="email" class="form-control"
						placeholder="Email"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="passWord" class="form-control"
						placeholder="Mật khẩu"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="rePass" class="form-control"
						placeholder="Nhập lại mật khẩu"> <span
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
						<a href="dangNhap.jsp" class="text-center">Đã có tài khoản</a>
					</div>
				</div>
			</form>


		</div>
		<!-- /.form-box -->
	</div>
	<!-- /.register-box -->

	<!-- jQuery 3 -->
	<script src="js/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="js/bootstrap.min.js"></script>

	</script>
</body>
</html>
