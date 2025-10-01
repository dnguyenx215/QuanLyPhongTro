<%@page import="model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp" %>
      <!-- Main content -->
      <!-- Tạo form và table vào đây ===================================================================-->
      
      <% ArrayList<NhanVien> dsNVNhanVien=( ArrayList<NhanVien> ) request.getAttribute("dsNVNhanVien"); %>
    <section class="content n10_content container-fluid">
      <div class="row">
        <div class="box col-sm-12">
          <div class="box-header">
            <h3 class="box-title">Danh sách nhân viên</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">

              <table id="dataTable" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Stt</th>
                  <th>Họ tên</th>
                  <th>Địa chỉ</th>
                  <th>Chức vụ</th>
                  <th>Liên hệ</th>
                  <th class="pull-center">Tùy chọn</th>
                </tr>
                </thead>
                <tbody>
                <%for(int i=0;i<dsNVNhanVien.size();i++){
                	%>
                	 <tr>
                    <td><%=(i+1) %></td>
                    <td><%=dsNVNhanVien.get(i).getHoTen() %></td>
                    <td><%=dsNVNhanVien.get(i).getDiaChi() %></td>
                    <td><%=dsNVNhanVien.get(i).getChucVu()%></td>
                    <td><%=dsNVNhanVien.get(i).getSdt()%></td>
                    <td class="pull-center">
                      <a href="SuaNhanVienServlet?idNhanVien=<%=dsNVNhanVien.get(i).getId()%>" class="n10_btn btn_edit"><i class="fa fa-pencil-square-o"></i></a>
                      <a href="XoaNhanVienServlet?idNhanVien=<%=dsNVNhanVien.get(i).getId()%>" class="n10_btn btn_del"><i class="fa fa-trash"></i></a>
                    </td>
                  </tr>
                	<%
                } %>
                 
            
                </tbody>
                <tfoot>
                  <tr>
                    <th>Stt</th>
                    <th>Họ tên</th>
                    <th>Địa chỉ</th>
                    <th>Chức vụ</th>
                    <th>Liên hệ</th>
                    <th class="pull-center">Tùy chọn</th>
                  </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
      </div>        
    </section>
      <!-- Thêm xong ================================================================================-->
	<%@include file="../footerAdmin.jsp" %>