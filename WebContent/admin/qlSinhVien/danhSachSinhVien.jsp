<%@page import="model.bean.TruongHoc"%>
<%@page import="java.util.Hashtable"%>
<%@page import="model.bean.SinhVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp" %>
      <!-- Main content -->
      <!-- Tạo form và table vào đây ===================================================================-->
    <%ArrayList<SinhVien> dsSVSinhVien=(ArrayList<SinhVien>)request.getAttribute("dsSVSinhVien");
    
    Hashtable<Integer,TruongHoc> dsSVTruongHoc=( Hashtable<Integer,TruongHoc> ) request.getAttribute("dsSVTruongHoc");
 
    %>
    
    <section class="content n10_content container-fluid">
      <div class="row">
        <div class="box col-sm-12">
          <div class="box-header">
            <h3 class="box-title">Danh sách sinh viên</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">

              <table id="dataTable" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Stt</th>
                  <th>Mã sinh viên</th>
                  <th>Họ tên</th>
                  <th>Trường</th>
                  <th>Số điện thoại</th>
                  <th class="pull-center">Tùy chọn</th>
                </tr>
                </thead>
                <tbody>
                <%
                for(int i=0;i<dsSVSinhVien.size();i++){
                	%>
                	 <tr>
                    <td><%=(i+1)%></td>
                    <td><%=dsSVSinhVien.get(i).getMaSinhVien() %></td>
                    <td><%=dsSVSinhVien.get(i).getHoTen()%></td>
                    <td><%=dsSVTruongHoc.get(dsSVSinhVien.get(i).getIdTruongHoc()).getTenTruong()%></td>
                    <td><%=dsSVSinhVien.get(i).getSdt() %></td>
                    <td class="pull-center">
                      <a href="SuaSinhVienServlet?idSinhVien=<%=dsSVSinhVien.get(i).getId()%>" class="n10_btn btn_edit"><i class="fa fa-pencil-square-o"></i></a>
                      <a href="XoaSinhVienServlet?idSinhVien=<%=dsSVSinhVien.get(i).getId()%>" class="n10_btn btn_del"><i class="fa fa-trash"></i></a>	
                    </td>
                  </tr>
                	
                	<%
                }
                %>
                </tbody>
                <tfoot>
                  <tr>
                    <th>Stt</th>
                    <th>Mã sinh viên</th>
                    <th>Họ tên</th>
                    <td>Trường</td>
                    <td>Số điện thoại</td>
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