<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@include file="../headerAdmin.jsp" %>
      <!-- Main content -->
      <!-- Táº¡o form vÃ  table vÃ o ÄÃ¢y ===================================================================-->
      <section class="content container-fluid">
        <div class="row">
          <div class="box box-info col-sm-8 col-sm-offset-2">
            <div class="box-header with-border pull-center">
              <h3 class="box-title ">Thêm User</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal" action="ThemUserServlet" method="post">
              <div class="box-body">
                <div class="form-group">
                  <label for="userName" class="col-sm-3 control-label">Tên đăng nhập: </label>

                  <div class="col-sm-8">
                    <input type="text" name="userName" class="form-control" id="userName" placeholder="Tên đăng nhập" required>
                  </div>
                </div>
                <div class="form-group">
                  <label for="passWord" class="col-sm-3 control-label">Mật khẩu:</label>

                  <div class="col-sm-8">
                    <input type="text" name="passWord" class="form-control" id="passWord" placeholder="Mật khẩu" required>
                  </div>
                </div>

                   <div class="form-group">
                  <label for="email" class="col-sm-3 control-label">Email:</label>

                  <div class="col-sm-8">
                    <input type="email" name="email" class="form-control" id="email" placeholder="Email" required>
                  </div>
                </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer n10_box_footer col-sm-8 col-sm-offset-3" >
                <button type="submit" class="  btn btn-info pull-left" value="themUser" name="themUser">Thêm</button>
                <button type="reset" class="  btn btn-info pull-center btn-reset">Nhập lại</button>
                <a href="#" class="btn_back btn btn-default pull-right">Quay lại</a>
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
        </div>        
      </section>
      <!-- ThÃªm xong ================================================================================-->
<%@include file="../footerAdmin.jsp" %>