<%@page import="model.bean.SinhVien"%>
<%@page import="java.util.Hashtable"%>
<%@page import="model.bean.KyLuatKhenThuong"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp"%>
<!-- Main content -->
<!-- Tạo form và table vào đây ===================================================================-->
<%
	ArrayList<KyLuatKhenThuong> dsKLKyLuat = (ArrayList<KyLuatKhenThuong>) request.getAttribute("dsKLKyLuat");
	Hashtable<Integer, SinhVien> dsKLSinhVien = (Hashtable<Integer, SinhVien>) request
			.getAttribute("dsKLSinhVien");
%>

<section class="content n10_content container-fluid">
	<div class="row">
		<div class="box col-sm-12">
			<div class="box-header">
				<h3 class="box-title">Danh sách kỷ luật</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body">

				<table id="dataTable" class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Stt</th>
							<th>Sinh viên</th>
							<th>Nguyên nhân</th>
							<th>Ngày</th>
							<th>Hình thức</th>
							<th class="pull-center">Tùy chọn</th>
						</tr>
					</thead>
					<tbody>

						<%
							for (int i = 0; i < dsKLKyLuat.size(); i++) {
						%>
						<tr>
							<td><%=(i + 1)%></td>
							<td><%=dsKLSinhVien.get(dsKLKyLuat.get(i).getIdSinhVien()).getHoTen()%></td>
							<td><%=dsKLKyLuat.get(i).getNguyenNhan()%></td>
							<td><%=dsKLKyLuat.get(i).getNgayThang()%></td>
							<td><%=dsKLKyLuat.get(i).getHinhPhat()%></td>
							<td class="pull-center">
                      <a href="SuaKyLuatServlet?idKyLuat=<%=dsKLKyLuat.get(i).getId()%>" class="n10_btn btn_edit"><i class="fa fa-pencil-square-o"></i></a>
                      <a href="XoaKyLuatServlet?idKyLuat=<%=dsKLKyLuat.get(i).getId()%>" class="n10_btn btn_del"><i class="fa fa-trash"></i></a>
							</td>
						</tr>

						<%
							}
						%>


					</tbody>
					<tfoot>
						<tr>
							<th>Stt</th>
							<th>Sinh viên</th>
							<th>Nguyên nhân</th>
							<th>Ngày</th>
							<th>Hình thức</th>
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