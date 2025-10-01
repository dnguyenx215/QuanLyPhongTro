<%@page import="model.bean.KhuNha"%>
<%@page import="java.util.Hashtable"%>
<%@page import="model.bean.Phong"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp" %>
 
 <!-- Main content -->
      <!-- Tạo form và table vào đây ===================================================================-->
    <%
    ArrayList<Phong> themHDPhong = (    ArrayList<Phong>) request.getAttribute("themHDPhong");
	Hashtable<Integer, KhuNha> themHDKhuNha =(	Hashtable<Integer, KhuNha>) request.getAttribute("themHDKhuNha");
	
	
    %>
    
      <section class="content container-fluid">
        <div class="row">
          <div class="box box-info col-sm-8 col-sm-offset-2">
            <div class="box-header with-border pull-center">
              <h3 class="box-title ">Thêm mới hóa đơn</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal">
              <div class="box-body">
                

                <div class="form-group">
                  <label for="idPhong" class="col-sm-3 control-label">Số phòng:</label>
                  <div class="col-sm-8">
                    <select class="form-control select2" name="idPhong" id="idPhong" required>
                     
                      <% for(Phong p:themHDPhong){
                    	  
           %>
            <option value="<%=p.getId()%>" ><%=themHDKhuNha.get(p.getIdKhuNha()).getKhuNha() %> : <%=p.getTenPhong() %></option>
           <%
                      } %>
                    </select>
                  </div>
                </div>

                <div class="form-group">
                  <label for="thangLap" class="col-sm-3 control-label">Tháng:</label>
                  <div class="col-sm-8">

                    <div class="input-group">
                      <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                      </div>
                      <input type="date" class="form-control"  name="thangLap" id="thangLap" required>
                    </div>
                  </div>
                </div>

                <div class="form-group">
                  <label for="ngayLap" class="col-sm-3 control-label">Ngày lập phiếu:</label>
                  <div class="col-sm-8">

                    <div class="input-group">
                      <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                      </div>
                      <input type="date" class="form-control" name="ngayLap" id="ngayLap" required>
                    </div>
                  </div>
                </div> 

                <div class="form-group">
                  <label for="chiSoCu" class="col-sm-3 control-label">Chỉ số cũ:</label>

                  <div class="col-sm-8">
                    <input type="number" name="chiSoCu" class="form-control" id="chiSoCu" placeholder="Chỉ số điện cũ" required>
                  </div>
                </div>

                <div class="form-group">
                  <label for="chiSoMoi" class="col-sm-3 control-label">Chỉ số mới:</label>

                  <div class="col-sm-8">
                    <input type="number" name="chiSoMoi" class="form-control" id="chiSoMoi" placeholder="Chỉ số điện mới" required>
                  </div>
                </div>

              </div>
              <!-- /.box-body -->
              <div class="box-footer n10_box_footer col-sm-8 col-sm-offset-3" >
                <button type="submit" class=" btn btn-info pull-left" value="themHoaDon" name="themHoaDon">Thêm</button>
                <button type="reset" class="btn btn-info pull-center btn-reset">Nhập lại</button>
                <a href="#" class="btn_back btn btn-default pull-right">Quay lại</a>
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
        </div>        
      </section>
      <!-- Thêm xong ================================================================================-->
 
	<%@include file="../footerAdmin.jsp" %>