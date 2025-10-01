<%@page import="model.bean.NhanVien"%>
<%@page import="model.bean.SinhVien"%>
<%@page import="java.util.Hashtable"%>
<%@page import="model.bean.KhuNha"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp"%>
			<!-- Main content -->
			<!-- Tạo form và table vào đây ===================================================================-->
			<%
			ArrayList<KhuNha> dsKNKhuNha=(ArrayList<KhuNha>) request.getAttribute("dsKNKhuNha");
			Hashtable<Integer,NhanVien> dsKNNhanVien=(Hashtable<Integer,NhanVien>) request.getAttribute("dsKNNhanVien");
			%>
			<section class="content n10_content container-fluid">
				<div class="row">
					<div class="box col-sm-12">
						<div class="box-header">
							<h3 class="box-title">Danh sách khu nhà</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">

							<table id="dataTable" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>Stt</th>
										<th>Khu nhà</th>
										<th>Người quản lý</th>
										<th class="pull-center">Tùy chọn</th>
									</tr>
								</thead>
								<tbody>
								<%
								for(int i=0;i<dsKNKhuNha.size();i++){
									%>
									<tr>
										<td><%=(i+1)%></td>
										<td><%=dsKNKhuNha.get(i).getKhuNha() %></td>
										<td><%=dsKNNhanVien.get(dsKNKhuNha.get(i).getIdNhanVien()).getHoTen() %></td>
										<td class="pull-center">
                      <a href="SuaKhuNhaServlet?idKhuNha=<%=dsKNKhuNha.get(i).getId()%>" class="n10_btn btn_edit"><i class="fa fa-pencil-square-o"></i></a>
                      <a href="XoaKhuNhaServlet?idKhuNha=<%=dsKNKhuNha.get(i).getId()%>" class="n10_btn btn_del"><i class="fa fa-trash"></i></a>										
										</td>
									</tr>
									<%
								}
								%>
									
								</tbody>
								<tfoot>
									<tr>
										<th>Stt</th>
										<th>Khu nhà</th>
										<th>Người quản lý</th>
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
	<%@include file="../footerAdmin.jsp"%>