<%@page import="model.bean.TruongHoc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp" %>
      <!-- Main content -->
      <!-- Tạo form và table vào đây ===================================================================-->
    <%ArrayList<TruongHoc> dsTHTruong=(ArrayList<TruongHoc>)request.getAttribute("dsTHTruong"); %>
    <section class="content n10_content container-fluid">
      <div class="row">
        <div class="box col-sm-12">
          <div class="box-header">
            <h3 class="box-title">Danh sách Trường học</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">

              <table id="dataTable" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Stt</th>
                  <th>Tên trường</th>
                  <th>Địa chỉ</th>
                  <th class="pull-center">Tùy chọn</th>
                </tr>
                </thead>
                <tbody>
                <%for(int i=0;i<dsTHTruong.size();i++) {
                	
                	%>
                	  <tr>
                    <td><%=(i+1) %></td>
                    <td><%=dsTHTruong.get(i).getTenTruong() %></td>
                    <td><%=dsTHTruong.get(i).getDiaChi() %></td>
                    <td class="pull-center">
                      <a href="SuaTruongServlet?idTruong=<%=dsTHTruong.get(i).getId()%>" class="n10_btn btn_edit"><i class="fa fa-pencil-square-o"></i></a>
                      <a href="XoaTruongServlet?idTruong=<%=dsTHTruong.get(i).getId()%>" class="n10_btn btn_del"><i class="fa fa-trash"></i></a>
                    </td>
                  </tr>
                	<%
                }%>
                  
                </tbody>
                <tfoot>
                  <tr>
                    <th>Stt</th>
                    <th>Tên trường</th>
                    <th>Địa chỉ</th>
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