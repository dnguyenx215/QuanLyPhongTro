<%@page import="model.bo.UserBO"%>
<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@include file="../headerAdmin.jsp" %>
      <!-- Main content -->
      <!-- Tạo form và table vào đây ===================================================================-->
      <%
User userSua = (User)request.getAttribute("suaUser");
%>
      <section class="content container-fluid">
        <div class="row">
          <div class="box box-info col-sm-8 col-sm-offset-2">
            <div class="box-header with-border pull-center">
              <h3 class="box-title ">Sửa User</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal">
              <div class="box-body">

                <div class="form-group">
                  <label for="userID" class="col-sm-3 control-label">ID: </label>

                  <div class="col-sm-8">
                    <input type="text" name="userID" class="form-control" id="userID"  value="<%=userSua.getId() %>" readonly="readonly" >
                  </div>
                </div>

                <div class="form-group">
                  <label for="userName" class="col-sm-3 control-label">Tên đăng nhập: </label>

                  <div class="col-sm-8">
                    <input type="text" name="userName" class="form-control" id="userName" readonly="readonly" value="<%=userSua.getUserName() %>" required>
                  </div>
                </div>
                <div class="form-group">
                  <label for="passWord" class="col-sm-3 control-label">Mật khẩu:</label>

                  <div class="col-sm-8">
                    <input type="passWord" name="passWord" class="form-control" id="passWord" placeholder="Mật khẩu" value="<%=userSua.getPassword() %>" required>
                  </div>
                </div>

                   <div class="form-group">
                  <label for="email" class="col-sm-3 control-label">Email:</label>

                  <div class="col-sm-8">
                    <input type="email" name="email" class="form-control" id="email" placeholder="Email" value="<%=userSua.getEmail() %>" required>
                  </div>
                </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer n10_box_footer col-sm-8 col-sm-offset-3" >
                <button type="submit" class="  btn btn-info pull-left" value="luuUser" name="luuUser">Lưu</button>
                <button type="reset" class="  btn btn-info pull-center btn-reset">Nhập lại</button>
                <a href="#" class="btn_back btn btn-default pull-right">Quay lại</a>
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
        </div>        
      </section>
      <!-- Thêm xong ================================================================================-->
<%@include file="../footerAdmin.jsp"%>