<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="headerUser.jsp"%>
<section class="content container-fluid">
      <div class="row">
        <div class="box box-info col-sm-8 col-sm-offset-2">
          <div class="box-header with-border pull-center">
            <h3 class="box-title ">Liên hệ</h3>
          </div>
          <!-- /.box-header -->
          <!-- form start -->
          <form class="form-horizontal" action="LienHeServlet" method="post">
            <div class="box-body">
              <div class="form-group">
                <label for="hoTen" class="col-sm-3 control-label">Họ và tên:</label>

                <div class="col-sm-8">
                  <input type="text" name="hoTen" class="form-control" id="hoTen" placeholder="Họ và tên"  required>
                </div>
              </div>
              
              <div class="form-group">
                <label for="chuDe" class="col-sm-3 control-label">Chủ đề:</label>

                <div class="col-sm-8">
                  <input type="text" name="chuDe" class="form-control" id="chuDe" placeholder="Chủ đề"  required>
                </div>
              </div>
              <div class="form-group">
                  <label class="col-sm-3 control-label" for="noiDung">Nội dung:</label>
                  <div class="col-sm-8">
                    <textarea class="form-control" rows="5" id="noiDung" name="noiDung" required></textarea>
                  </div>
                </div>
            </div>
            <!-- /.box-body -->
            <div class="box-footer n10_box_footer col-sm-8 col-sm-offset-3" >
              <button type="submit" value="guiLienHe" name="guiLienHe" id="guiLienHe" class="btn btn-info pull-left">Gửi</button>
              <button type="reset" class="btn btn-info pull-center btn-reset">Nhập lại</button>
              <a href="#" class="btn_back btn btn-default pull-right">Quay lại</a>
            </div>
            <!-- /.box-footer -->
          </form>
        </div>
      </div>        
      </section>
      
<%@include file="footerUser.jsp"%>