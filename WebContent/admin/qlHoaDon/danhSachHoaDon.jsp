<%@page import="model.bean.KhuNha"%>
<%@page import="model.bean.Phong"%>
<%@page import="java.util.Hashtable"%>
<%@page import="model.bean.HoaDon"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp"%>
<!-- Main content -->
<!-- Tạo form và table vào đây ===================================================================-->
<%
	ArrayList<HoaDon> dsHDHoaDon = (ArrayList<HoaDon>) request.getAttribute("dsHDHoaDon");
	Hashtable<Integer, Phong> dsHDPhong = (Hashtable<Integer, Phong>) request.getAttribute("dsHDPhong");
	Hashtable<Integer, KhuNha> dsHDKhuNha = (Hashtable<Integer, KhuNha>) request.getAttribute("dsHDKhuNha");
%>

<section class="content n10_content container-fluid">
	<div class="row">
		<div class="box col-sm-12">
			<div class="box-header">
				<h3 class="box-title">Danh sách hóa đơn</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body">

				<table id="dataTable" class="table table-bordered table-striped ">
					<thead>
						<tr>
							<th>Stt</th>
							<th>Phòng</th>
							<th>Khu nhà</th>
							<th>Tháng</th>
							<th>Tiền điện</th>
							<th>Tiền nước</th>
							<th>Tổng tiền</th>
							<th class="pull-center">Tùy chọn</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (int i = 0; i < dsHDHoaDon.size(); i++) {
						%>
						<tr>
							<td><%=(i + 1)%></td>
							<td><%=dsHDPhong.get(dsHDHoaDon.get(i).getIdPhong()).getTenPhong()%></td>
							<td><%=dsHDKhuNha.get(dsHDPhong.get(dsHDHoaDon.get(i).getIdPhong()).getIdKhuNha()).getKhuNha()%></td>
							<td><%=dsHDHoaDon.get(i).getThangLap2()%></td>
							<td><%=dsHDHoaDon.get(i).getTienDien()%></td>
							<td><%=dsHDHoaDon.get(i).getTienNuoc()%></td>
							<td><%=dsHDHoaDon.get(i).getTongTien()%></td>
							<td class="pull-center"><a
								href="SuaHoaDonServlet?idHoaDon=<%=dsHDHoaDon.get(i).getId()%>"
								class="n10_btn btn_edit"><i class="fa fa-pencil-square-o"></i></a>
								<a
								href="XoaHoaDonServlet?idHoaDon=<%=dsHDHoaDon.get(i).getId()%>"
								class="n10_btn btn_del"><i class="fa fa-trash"></i></a></td>
						</tr>
						<%
							}
						%>


					</tbody>
					<tfoot>
						<tr>
							<th>Stt</th>
							<th>Phòng</th>
							<th>Khu nhà</th>
							<th>Tháng</th>
							<th>Tiền điện</th>
							<th>Tiền nước</th>
							<th>Tổng tiền</th>
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