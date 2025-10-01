<%@page import="common.KiemTra"%>
<%@page import="model.bean.KhuNha"%>
<%@page import="model.bean.Phong"%>
<%@page import="java.util.Hashtable"%>
<%@page import="model.bean.SinhVien"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.HopDong"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp"%>

<!-- Main content -->
<!-- Tạo form và table vào đây ===================================================================-->
<%
	HopDong suaHDHopDong = (HopDong) request.getAttribute("suaHDHopDong");
	ArrayList<SinhVien> suaHDSinhVien = (ArrayList<SinhVien>) request.getAttribute("suaHDSinhVien");
	Hashtable<Integer, KhuNha> suaHDKhuNha = (Hashtable<Integer, KhuNha>) request.getAttribute("suaHDKhuNha");

	ArrayList<Phong> suaHDPhongNam = (ArrayList<Phong>) request.getAttribute("suaHDPhongNam");
	ArrayList<Phong> suaHDPhongNu = (ArrayList<Phong>) request.getAttribute("suaHDPhongNu");
	ArrayList<Phong> suaHDPhongTrong = (ArrayList<Phong>) request.getAttribute("suaHDPhongTrong");
%>

<section class="content container-fluid">
	<div class="row">
		<div class="box box-info col-sm-8 col-sm-offset-2">
			<div class="box-header with-border pull-center">
				<h3 class="box-title ">Chỉnh Sửa hợp đồng</h3>
			</div>
			<!-- /.box-header -->
			<!-- form start -->
			<form class="form-horizontal" action="SuaHopDongServlet"
				method="post">
				<div class="box-body">
					<div class="form-group">
						<label for="idHopDong" class="col-sm-3 control-label">ID
							hợp đồng:</label>

						<div class="col-sm-8">
							<input type="text" name="idHopDong" class="form-control"
								id="idHopDong" value="<%=suaHDHopDong.getId()%>"
								readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="idSinhVien" class="col-sm-3 control-label">Họ
							và tên:</label>
						<div class="col-sm-8">
							<select class="form-control select2" name="idSinhVien"
								id="idSinhVien" required>
								<%
									for (SinhVien sv : suaHDSinhVien) {
										if (suaHDHopDong.getIdSinhVien() == sv.getId()) {
								%>
								<option value="<%=sv.getId()%>" selected="selected"><%=sv.getHoTen()%>
									-
									<%=KiemTra.layGioiTinh(sv.getGioiTinh())%></option>
								<%
									} else {
								%>
								<option value="<%=sv.getId()%>"><%=sv.getHoTen()%> -
									<%=KiemTra.layGioiTinh(sv.getGioiTinh())%></option>
								<%
									}
									}
								%>
							</select>
						</div>
					</div>

					<!--                 <div class="form-group">
                  <label for="chonKhuNha" class="col-sm-3 control-label" >Khu nhà:</label>
                  <div class="col-sm-8">
                    <select class="form-control select2" name="chonKhuNha" id="chonKhuNha" required>
                      <option value="">Chọn khu nhà</option>
                      <option selected="selected" value="1">Khu A</option>
                      <option value="2">Khu B</option>
                      <option value="3">Khu C</option>
                      <option value="4">Khu D</option>
                      <option value="5">Khu E</option>
                    </select>
                  </div>
                </div> -->

					<div class="form-group">
						<label for="idPhong" class="col-sm-3 control-label">Số
							phòng:</label>
						<div class="col-sm-8">
							<select class="form-control select2" name="idPhong" id="idPhong"
								required>



								<%
									for (Phong p : suaHDPhongTrong) {

										if (suaHDHopDong.getIdPhong() == p.getId()) {
								%>
								<option selected="selected" value="<%=p.getId()%>"><%=suaHDKhuNha.get(p.getIdKhuNha()).getKhuNha()%>
									:
									<%=p.getTenPhong()%> trống
									<%=p.getSoNguoiToiDa() - p.getSoNguoiHienTai()%> chỗ
								</option>
									<%
										} else {
									%>
								
								<option value="<%=p.getId()%>"><%=suaHDKhuNha.get(p.getIdKhuNha()).getKhuNha()%>
									:
									<%=p.getTenPhong()%> trống
									<%=p.getSoNguoiToiDa() - p.getSoNguoiHienTai()%> chỗ
								</option>
								<%
									}

									}
								%>

								<%
									for (Phong p : suaHDPhongNam) {

										if (suaHDHopDong.getIdPhong() == p.getId()) {
								%>
								<option selected="selected" value="<%=p.getId()%>"><%=suaHDKhuNha.get(p.getIdKhuNha()).getKhuNha()%>
									:
									<%=p.getTenPhong()%> trống
									<%=p.getSoNguoiToiDa() - p.getSoNguoiHienTai()%> chỗ cho Nam [Phòng cũ]
								</option>
									<%
										} else {
									%>
								
								<option value="<%=p.getId()%>"><%=suaHDKhuNha.get(p.getIdKhuNha()).getKhuNha()%>
									:
									<%=p.getTenPhong()%> trống
									<%=p.getSoNguoiToiDa() - p.getSoNguoiHienTai()%> chỗ cho Nam
								</option>
								<%
									}

									}
								%>
								<%
									for (Phong p : suaHDPhongNu) {

										if (suaHDHopDong.getIdPhong() == p.getId()) {
								%>
								<option selected="selected" value="<%=p.getId()%>"><%=suaHDKhuNha.get(p.getIdKhuNha()).getKhuNha()%>
									:
									<%=p.getTenPhong()%> trống
									<%=p.getSoNguoiToiDa() - p.getSoNguoiHienTai()%> chỗ cho Nữ [Phòng cũ]
								</option>
									<%
										} else {
									%>
								
								<option value="<%=p.getId()%>"><%=suaHDKhuNha.get(p.getIdKhuNha()).getKhuNha()%>
									:
									<%=p.getTenPhong()%> trống
									<%=p.getSoNguoiToiDa() - p.getSoNguoiHienTai()%> chỗ cho Nữ
								</option>
								<%
									}

									}
								%>



							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="ngayBatDau" class="col-sm-3 control-label">Ngày
							bắt đầu:</label>
						<div class="col-sm-8">

							<div class="input-group">
								<div class="input-group-addon">
									<i class="fa fa-calendar"></i>
								</div>
								<input type="date" class="form-control" name="ngayBatDau"
									id="ngayBatDau" value="<%=suaHDHopDong.getNgayBatDau()%>"
									required>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="ngayKetThuc" class="col-sm-3 control-label">Ngày
							kết thúc:</label>
						<div class="col-sm-8">

							<div class="input-group">
								<div class="input-group-addon">
									<i class="fa fa-calendar"></i>
								</div>
								<input type="date" class="form-control" name="ngayKetThuc"
									id="ngayKetThuc" value="<%=suaHDHopDong.getNgayKetThuc()%>"
									required>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="ngayTao" class="col-sm-3 control-label">Ngày
							tạo:</label>
						<div class="col-sm-8">

							<div class="input-group">
								<div class="input-group-addon">
									<i class="fa fa-calendar"></i>
								</div>
								<input type="date" class="form-control" name="ngayTao"
									id="ngayTao" value="<%=suaHDHopDong.getNgayTao()%>" required>
							</div>
						</div>
					</div>

				</div>
				<!-- /.box-body -->
				<div class="box-footer n10_box_footer col-sm-8 col-sm-offset-3">
					<button type="submit" class="btn btn-info pull-left"
						value="suaHopDong" name="suaHopDong">Lưu</button>
					<button type="reset" class="btn btn-info pull-center btn-reset">Nhập
						lại</button>
					<a href="#" class="btn_back btn btn-default pull-right">Quay
						lại</a>
				</div>
				<!-- /.box-footer -->
			</form>
		</div>
	</div>
</section>
<!-- Thêm xong ================================================================================-->
<%@include file="../footerAdmin.jsp"%>
