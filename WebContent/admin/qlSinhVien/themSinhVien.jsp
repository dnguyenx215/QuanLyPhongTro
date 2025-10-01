<%@page import="model.bean.TruongHoc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<TruongHoc> dsTruongSV = (ArrayList<TruongHoc>)request.getAttribute("themSVTruong"); %>
<%@include file="../headerAdmin.jsp"%>
      <section class="content container-fluid">
        <div class="row">
          <div class="box box-info col-sm-8 col-sm-offset-2">
            <div class="box-header with-border pull-center">
              <h3 class="box-title ">Thêm mới Sinh viên</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal" action="ThemSinhVienServlet" method="post">
              <div class="box-body">
                <div class="form-group">
                  <label for="maSV" class="col-sm-3 control-label">Mã sinh viên: </label>

                  <div class="col-sm-8">
                    <input type="text" name="maSV" class="form-control" id="maSV" placeholder="Mã sinh viên" required>
                  </div>
                </div>
                <div class="form-group">
                  <label for="hoTenSV" class="col-sm-3 control-label">Họ và tên:</label>

                  <div class="col-sm-8">
                    <input type="text" name="hoTenSV" class="form-control" id="hoTenSV" placeholder="Họ và tên" required>
                  </div>
                </div>

                <div class="form-group">
                  <label for="chonTruong" class="col-sm-3 control-label">Trường:</label>
                  <div class="col-sm-8">
                    <select class="form-control select2" name="chonTruong" id="chonTruong" required>
                      <%
                      	for(TruongHoc th : dsTruongSV){
                      %>
                      	<option value="<%=th.getId() %>"><%=th.getTenTruong() %></option>
                      <%} %>
                    </select>
                  </div>
                </div>

                <div class="form-group">
                  <label for="lop" class="col-sm-3 control-label">Lớp:</label>

                  <div class="col-sm-8">
                    <input type="text" name="lop" class="form-control" id="lop" placeholder="Lớp" required>
                  </div>
                </div>

                <div class="form-group">
                  <div class="form-check">
                    <label for="lop" class="col-sm-3 control-label">Giới tính:</label>

                    <div class="col-sm-8">
                      <label class="radio-inline"><input type="radio" name="gioiTinh" checked value="1">Nam</label>
                      <label class="radio-inline"><input type="radio" name="gioiTinh" value="0">Nữ</label>
                    </div>
                  </div>
                </div>

                <div class="form-group">
                  <label for="ngaySinh" class="col-sm-3 control-label">Ngày sinh:</label>
                  <div class="col-sm-8">

                    <div class="input-group">
                      <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                      </div>
                      <input type="date" class="form-control" name="ngaySinh" id="ngaySinh" required>
                    </div>
                  </div>
                </div> 

                <div class="form-group">
                  <label for="soCMND" class="col-sm-3 control-label">Số CMND:</label>

                  <div class="col-sm-8">
                    <input type="number" name="soCMND" class="form-control" id="soCMND" placeholder="Số CMND" required>
                  </div>
                </div>

                <div class="form-group">
                  <label for="soDT" class="col-sm-3 control-label">Số điện thoại:</label>

                  <div class="col-sm-8">
                    <input type="text" name="soDT" class="form-control" id="soDT" placeholder="Số điện thoại" required>
                  </div>
                </div>

              </div>
              <!-- /.box-body -->
              <div class="box-footer n10_box_footer col-sm-8 col-sm-offset-3" >
                <button type="submit" name="themSV" value="themSV" class=" btn btn-info pull-left">Thêm</button>
                <button type="reset" class="btn btn-info pull-center btn-reset">Nhập lại</button>
                <a href="#" class="btn_back btn btn-default pull-right">Quay lại</a>
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
        </div>        
      </section>
<%@include file="../footerAdmin.jsp"%>