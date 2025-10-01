<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="headerUser.jsp" %>
<section class="content container-fluid">
      <div class="row">
        <div class="box box-info col-sm-8 col-sm-offset-2">
          <div class="box-header with-border pull-center">
            <h3 class="box-title ">Đổi mật khẩu</h3>
          </div>
          <!-- /.box-header -->
          <!-- form start -->
          <form class="form-horizontal">
            <div class="box-body">
             <div class="form-group">
                <label for="ID" class="col-sm-3 control-label">ID:</label>

                <div class="col-sm-8">
                  <input type="text" name="ID" class="form-control" id="ID"  value="<%=acc.getId() %>" readonly="readonly" required>
                </div>
              </div>
              <div class="form-group">
                <label for="userName" class="col-sm-3 control-label">Tên đăng nhập:</label>

                <div class="col-sm-8">
                  <input type="text" name="userName" class="form-control" id="userName" value="<%=acc.getUserName() %>" readonly="readonly" required>
                </div>
              </div>
              <div class="form-group">
                <label for="oldPass" class="col-sm-3 control-label">Mật khẩu cũ:</label>

                <div class="col-sm-8">
                  <input type="password" name="oldPass" class="form-control" id="oldPass" placeholder="Mật khẩu cũ"  required>
                </div>
              </div>
              <div class="form-group">
                <label for="newPass" class="col-sm-3 control-label">Mật khẩu mới:</label>

                <div class="col-sm-8">
                  <input type="password" name="newPass" class="form-control" id="newPass" placeholder="Mật khẩu mới"  required>
                </div>
              </div>
              <div class="form-group">
                <label for="reNewPass" class="col-sm-3 control-label">Nhập lại mật khẩu:</label>

                <div class="col-sm-8">
                  <input type="password" name="reNewPass" class="form-control" id="reNewPass" placeholder="Nhập lại mật khẩu mới"  required>
                </div>
              </div>
            </div>
            <!-- /.box-body -->
            <div class="box-footer n10_box_footer col-sm-8 col-sm-offset-3" >
              <button type="submit" class="btn btn-info pull-left" name="doimkUser" value="doimkUser">Đổi mật khẩu</button>
              <button type="reset" class="btn btn-info pull-center btn-reset">Nhập lại</button>
              <a href="#" class="btn_back btn btn-default pull-right">Quay lại</a>
            </div>
            <!-- /.box-footer -->
          </form>
        </div>
      </div>        
    </section>
 <%@include file="footerUser.jsp"%>