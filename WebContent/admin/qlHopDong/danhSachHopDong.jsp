<%@page import="model.bean.KhuNha"%>
<%@page import="model.bean.Phong"%>
<%@page import="model.bean.SinhVien"%>
<%@page import="java.util.Hashtable"%>
<%@page import="model.bean.HopDong"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp" %>

      <!-- Main content -->
      <!-- Tạo form và table vào đây ===================================================================-->
   <%ArrayList<HopDong> dsHDHopDong=(ArrayList<HopDong>)request.getAttribute("dsHDHopDong");
   Hashtable<Integer,SinhVien> dsHDSinhVien=(Hashtable<Integer,SinhVien>)request.getAttribute("dsHDSinhVien");
   Hashtable<Integer,Phong> dsHDPhong=(Hashtable<Integer,Phong>) request.getAttribute("dsHDPhong");
   Hashtable<Integer,KhuNha> dsHDKhuNha=(Hashtable<Integer,KhuNha>) request.getAttribute("dsHDKhuNha");
   %>
   
    <section class="content n10_content container-fluid">
      <div class="row">
        <div class="box col-sm-12">
          <div class="box-header">
            <h3 class="box-title">Danh sách hợp đồng</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="dataTable" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Stt</th>
                  <th>Sinh Viên</th>
                  <th>Phòng</th>
                  <th>Khu nhà</th>
                  <th>Ngày bắt đầu</th>
                  <th>Ngày kết thúc</th>
                  <th class="pull-center">Tùy chọn</th>
                </tr>
                </thead>
                <tbody>
                <%for(int i=0;i<dsHDHopDong.size();i++){
                	%>
                	 <tr>

                    <td><%=(i+1) %></td>
                    <td><%=dsHDSinhVien.get(dsHDHopDong.get(i).getIdSinhVien()).getHoTen() %></td>
                    <td><%=dsHDPhong.get(dsHDHopDong.get(i).getIdPhong()).getTenPhong() %></td>
                    <td><%=dsHDKhuNha.get(dsHDPhong.get(dsHDHopDong.get(i).getIdPhong()).getIdKhuNha()).getKhuNha() %></td>
                    <td><%=dsHDHopDong.get(i).getNgayBatDau2()%></td>
                    <td><%=dsHDHopDong.get(i).getNgayKetThuc2() %></td>
                    <td class="pull-center">
                      <a href="SuaHopDongServlet?idHopDong=<%=dsHDHopDong.get(i).getId()%>" class="n10_btn btn_edit"><i class="fa fa-pencil-square-o"></i></a>
                      <a href="XoaHopDongServlet?idHopDong=<%=dsHDHopDong.get(i).getId()%>" class="n10_btn btn_del"><i class="fa fa-trash"></i></a>	
                    </td>
                  </tr>
                	
                	<%
                	
                } %>
                
                </tbody>
                <tfoot>
                  <tr>
                    <th>Stt</th>
                    <th>Sinh Viên</th>
                    <th>Phòng</th>
                    <td>Khu nhà</td>
                    <td>Ngày bắt đầu</td>
                    <th>Ngày kết thúc</th>
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