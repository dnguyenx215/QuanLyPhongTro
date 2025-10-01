<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.KhuNha"%>
<%@page import="model.bean.Phong"%>
<%@page import="java.util.Hashtable"%>
<%@page import="model.bean.HoaDon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp" %>
<% HoaDon suaHDHoaDon=(HoaDon)  request.getAttribute("suaHDHoaDon");
ArrayList<Phong> suaHDPhong=(ArrayList<Phong>) request.getAttribute("suaHDPhong");
Hashtable<Integer,KhuNha> suaHDKhuNha=(Hashtable<Integer,KhuNha>) request.getAttribute("suaHDKhuNha");
%>
 <!-- Main content -->
      <!-- Tạo form và table vào đây ===================================================================-->
      <section class="content container-fluid">
        <div class="row">
          <div class="box box-info col-sm-8 col-sm-offset-2">
            <div class="box-header with-border pull-center">
              <h3 class="box-title ">Cập nhật hóa đơn</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal" method="post">
              <div class="box-body">
                
                <div class="form-group">
                  <label for="idHoaDon" class="col-sm-3 control-label">ID:</label>

                  <div class="col-sm-8">
                    <input type="text" name="idHoaDon" class="form-control" id="idHoaDon"  value="<%=suaHDHoaDon.getId()%>" readonly="readonly" >
                  </div>
                </div>

             

     
                  <div class="form-group">
                  <label for="chonPhong" class="col-sm-3 control-label">Số phòng:</label>
                  <div class="col-sm-8">
                    <select class="form-control select2" name="idPhong" id="idPhong" required>
                      <% for(Phong p: suaHDPhong) {
                    	  if(p.getId()==suaHDHoaDon.getIdPhong()){%>
                    		  <option value="<%=p.getId()%>"   selected="selected" ><%= suaHDKhuNha.get(p.getIdKhuNha()).getKhuNha()%>: <%=p.getTenPhong() %></option>
                    <% }else{
                    		  %>
                        	  <option value="<%=p.getId()%>" ><%= suaHDKhuNha.get(p.getIdKhuNha()).getKhuNha()%>: <%=p.getTenPhong() %></option>
                        	  
                        	  <%
                    	  }
                    	 
                    	  
                      }
                      
                      %>
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
                      <input type="date" class="form-control"  name="thangLap" id="thangLap" value="<%=suaHDHoaDon.getThangLap()%>" required>
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
                      <input type="date" class="form-control" name="ngayLap" id="ngayLap" value="<%=suaHDHoaDon.getNgayLap()%>" required>
                    </div>
                  </div>
                </div> 

                <div class="form-group">
                  <label for="chiSoCu" class="col-sm-3 control-label">Chỉ số cũ:</label>

                  <div class="col-sm-8">
                    <input type="number" name="chiSoCu" class="form-control" id="chiSoCu" placeholder="Chỉ số điện cũ" value="<%=suaHDHoaDon.getChiSoCu()%>" required>
                  </div>
                </div>

                <div class="form-group">
                  <label for="chiSoMoi" class="col-sm-3 control-label">Chỉ số mới:</label>

                  <div class="col-sm-8">
                    <input type="number" name="chiSoMoi" class="form-control" id="chiSoMoi" placeholder="Chỉ số điện mới" value="<%=suaHDHoaDon.getChiSoMoi()%>" required>
                  </div>
                </div>

              </div>
              <!-- /.box-body -->
              <div class="box-footer n10_box_footer col-sm-8 col-sm-offset-3" >
                <button type="submit" class=" btn btn-info pull-left" value="suaHoaDon" name="suaHoaDon">Cập nhật</button>
                <button type="reset" class="btn btn-info pull-center btn-reset">Nhập lại</button>
                <a href="#" class="btn_back btn btn-default pull-right">Quay lại</a>
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
        </div>        
      </section>
      <!-- Thêm xong ================================================================================-->
    </div>

<%@include file="../footerAdmin.jsp"%>