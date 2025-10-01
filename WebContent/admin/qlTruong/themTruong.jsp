<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp"%>
      <section class="content container-fluid">
        <div class="row">
          <div class="box box-info col-sm-8 col-sm-offset-2">
            <div class="box-header with-border pull-center">
              <h3 class="box-title ">Thêm mới trường học</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal" action="ThemTruongServlet" method="post">
              <div class="box-body">
                <div class="form-group">
                  <label for="schoolName" class="col-sm-3 control-label">Tên trường: </label>

                  <div class="col-sm-8">
                    <input type="text" name="schoolName" class="form-control" id="schoolName" placeholder="Tên trường" required>
                  </div>
                </div>
                <div class="form-group">
                  <label for="schoolAddress" class="col-sm-3 control-label">Địa chỉ:</label>

                  <div class="col-sm-8">
                    <input type="text" name="schoolAddress" class="form-control" id="schoolAddress" placeholder="Địa chỉ" required>
                  </div>
                </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer n10_box_footer col-sm-8 col-sm-offset-3" >
                <button type="submit" class=" btn btn-info pull-left" name="themTruong" value="themTruong">Thêm</button>
                <button type="reset" class="btn btn-info pull-center btn-reset">Nhập lại</button>
                <a href="#" class="btn_back btn btn-default pull-right">Quay lại</a>
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
        </div>        
      </section>
<%@include file="../footerAdmin.jsp"%>