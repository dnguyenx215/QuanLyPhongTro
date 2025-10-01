
<%@page import="model.bean.KhuNha"%>
<%@page import="model.bean.Phong"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp" %>
      <!-- Main content -->
      <!-- Tạo form và table vào đây ===================================================================-->
      <%
      	ArrayList<Phong> dsPPhong=(ArrayList<Phong>) request.getAttribute("dsPPhong");
      	Hashtable<Integer, KhuNha> dsPKhuNha = (Hashtable<Integer, KhuNha>) request.getAttribute("dsPKhuNha");
      %>
      
      <section class="content n10_content container-fluid">
        <div class="row">
          <div class="box col-sm-12">
            <div class="box-header">
              <h3 class="box-title">Danh sách Phòng</h3>
              </div>
              <!-- /.box-header -->
              <div class="box-body">

                <table id="dataTable" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>STT</th>
                    <th>Phòng</th>
                    <th>Khu nhà</th>
                    <th>Số người hiện tại</th>
                    <th>Số người tối đa</th>
                    <th class="pull-center">Tùy chọn</th>
                  </tr>
                  </thead>
                  <tbody>
                  <%for(int i=0;i<dsPPhong.size();i++){
                	  %>
                	  <tr>
                        <td><%=(i/+1) %></td>
                      <td><%=dsPPhong.get(i).getTenPhong() %></td>
                      <td><%=dsPKhuNha.get(dsPPhong.get(i).getIdKhuNha()).getKhuNha() %></td>
                      <td><%=dsPPhong.get(i).getSoNguoiHienTai() %></td>
                      <td><%=dsPPhong.get(i).getSoNguoiToiDa() %></td>
                      <td class="pull-center">
                        <a href="SuaPhongServlet?idPhong=<%=dsPPhong.get(i).getId()%>" class="n10_btn btn_edit"><i class="fa fa-pencil-square-o"></i></a>
                        <a href="XoaPhongServlet?idPhong=<%=dsPPhong.get(i).getId()%>" class="n10_btn btn_del"><i class="fa fa-trash"></i></a>
                      </td>
                    </tr>
                	  <%
                  }
                	  
                	  %>
                    
                  </tbody>
                  <tfoot>
                    <tr>
                      <th>STT</th>
                      <th>Phòng</th>
                      <th>Khu nhà</th>
                      <th>Số người hiện tại</th>
                      <th>Số người tối đa</th>
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