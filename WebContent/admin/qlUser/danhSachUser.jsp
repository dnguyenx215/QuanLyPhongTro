<%@page import="common.KiemTra"%>
<%@page import="model.bean.User"%>
<%@page import="model.bo.UserBO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp" %>

      <!-- Main content -->
      <!-- Tạo form và table vào đây ===================================================================-->
      <% ArrayList<User>  dsUSUser =(ArrayList<User>)  request.getAttribute("dsUSUser");
      %>      
      <section class="content n10_content container-fluid">
        <div class="row">
          <div class="box col-sm-12">
            <div class="box-header">
              <h3 class="box-title">Danh sách User</h3>
              </div>
              <!-- /.box-header -->
              <div class="box-body">
                <table id="dataTable" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>STT</th>
                    <th>Tên đăng nhập</th>
                    <th>Email</th>
                    <th>Trạng thái</th>
                    <th class="pull-center">Tùy chọn</th>
                  </tr>
                  </thead>
                  <tbody>
                  <% for(int i=0;i<dsUSUser.size();i++){
                	  %>
                	   <tr>
                     <td><%=(i+1)%></td>
                      <td><%=dsUSUser.get(i).getUserName() %></td>
                      <td><%=dsUSUser.get(i).getEmail() %></td>
                      <td><%=KiemTra.layTrangThai(dsUSUser.get(i).getUserStatus()) %></td>
                      <td class="pull-center">
                        <a href="SuaUserServlet?idUser=<%=dsUSUser.get(i).getId()%>" class="n10_btn btn_edit"><i class="fa fa-pencil-square-o"></i></a>
                        <a href="XoaUserServlet?idUser=<%=dsUSUser.get(i).getId()%>" class="n10_btn btn_del"><i class="fa fa-trash"></i></a>
                      </td>
                    </tr>
                	  
                	  
                	  <%}
                	  %>
                   
                  </tbody>
                  <tfoot>
                    <tr>
                      <th>STT</th>
                      <th>Tên đăng nhập</th>
                      <th>Email</th>
                      <th>Trạng thái</th>
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