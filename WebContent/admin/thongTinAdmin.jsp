<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="headerAdmin.jsp"%>
    <section class="content container-fluid">
      <div class="row">
        <div class="box box-info col-sm-8 col-sm-offset-2">
          <div class="box-header with-border pull-center">
            <h3 class="box-title ">Thông tin tài khoản</h3>
          </div>
          <div class="col-sm-8 col-sm-offset-2">
            <p><STRONG>Tên tài khoản: </STRONG><%=acc.getUserName() %></p>
            <p><STRONG>Email: </STRONG><%=acc.getEmail() %></p>
            <a href="DoiMatKhauAdminServlet" class="btn btn-info pull-left">Đổi mật khẩu</a>
            <a href="DangXuatServlet" class="btn btn-default pull-right">Đăng xuất</a>
          </div>
        </div>
      </div>        
    </section>
<%@include file="footerAdmin.jsp"%>