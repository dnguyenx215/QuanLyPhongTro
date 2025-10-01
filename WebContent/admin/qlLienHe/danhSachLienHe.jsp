<%@page import="model.bean.LienHe"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../headerAdmin.jsp" %>
 <!-- Main content -->
      <!-- Tạo form và table vào đây ===================================================================-->
      <%
      ArrayList<LienHe> dsLHLienHe=(ArrayList<LienHe>) request.getAttribute("dsLHLienHe");
      %>
    <section class="content n10_content container-fluid">
      <div class="row">
        <div class="box col-sm-12">
          <div class="box-header">
            <h3 class="box-title">Danh sách liên hệ</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">

              <table id="dataTable" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Stt</th>
                  <th>Tên</th>
                  <th>Email</th>
                  <th>Chủ đề</th>
                  <th>Ngày gửi</th>
                  <th class="pull-center">Tùy chọn</th>
                </tr>
                </thead>
                <tbody>
                <%
                for(int i=0;i<dsLHLienHe.size();i++){
                	%>
                	 <tr>
                    <td><%=(i+1) %></td>
                    <td><%=dsLHLienHe.get(i).getHoTen() %></td>
                    <td><%=dsLHLienHe.get(i).getEmail() %></td>
                    <td><%=dsLHLienHe.get(i).getHoTen() %></td>
                    <td><%=dsLHLienHe.get(i).getNgayGui() %></td>
                    <td class="pull-center">
                      <a href="XemLienHeServlet?idLienHe=<%=dsLHLienHe.get(i).getId()%>" class="n10_btn btn_edit"><i class="fa fa-search"></i></a>
                      <a href="XoaLienHeServlet?idLienHe=<%=dsLHLienHe.get(i).getId()%>" class="n10_btn btn_del"><i class="fa fa-trash"></i></a>
                    </td>
                  </tr>
                	<%
                }
                %>
                 
                
                </tbody>
                <tfoot>
                  <tr>
                    <th>Stt</th>
                    <th>Tên</th>
                    <th>Email</th>
                    <th>Chủ đề</th>
                    <th>Ngày gửi</th>
                    <th class="pull-center">Tùy chọn</th>
                  </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
      </div>        
    </section>
      <!-- Thêm xong ==================================================-->
      	<%@include file="../footerAdmin.jsp" %>