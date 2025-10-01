<%@page import="model.bean.KyLuatKhenThuong"%>
<%@page import="model.bean.SinhVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../headerAdmin.jsp"%>
<!-- Main content -->
<!-- Tạo form và table vào đây ===================================================================-->
<%
KyLuatKhenThuong kyLuatKhenThuong=(KyLuatKhenThuong) request.getAttribute("kyLuatKhenThuong");
	ArrayList<SinhVien> suaKLKTSinhVien = (ArrayList<SinhVien>) request.getAttribute("suaKLKTSinhVien");
%>
<section class="content container-fluid">
	<div class="row">
		<div class="box box-info col-sm-8 col-sm-offset-2">
			<div class="box-header with-border pull-center">
				<h3 class="box-title ">Cập nhật kỷ luật khen thưởng</h3>
			</div>
			<!-- /.box-header -->
			<!-- form start -->
			<form class="form-horizontal" action="SuaKyLuatServlet" method="post">
				<div class="box-body">

					<div class="form-group">
						<label for="idKyLuat" class="col-sm-3 control-label">ID Kỷ
							luật:</label>

						<div class="col-sm-8">
							<input type="text" name="idKyLuat" class="form-control"
								id="idKyLuat" value="1" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="chonPhong" class="col-sm-3 control-label">Sinh viên:</label>
						<div class="col-sm-8">
							<select class="form-control select2" name="idSinhVien" id="idSinhVien"
								required>
								<%
									for (SinhVien sv : suaKLKTSinhVien) {
										if(sv.getId()==kyLuatKhenThuong.getIdSinhVien())
										{
											%><option  value="<%=sv.getId()%>"  selected="selected"><%=sv.getHoTen()%></option>
											<%
										} else%>
										<option value="<%=sv.getId()%>"><%=sv.getHoTen()%></option>
										<% 
									}
								%>
								
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="nguyenNhan" class="col-sm-3 control-label">Nguyên
							nhân:</label>

						<div class="col-sm-8">
							<input type="text" name="nguyenNhan" class="form-control"
								id="nguyenNhan" placeholder="Nguyên nhân" value="<%=kyLuatKhenThuong.getNguyenNhan()%>"
								required>
						</div>
					</div>

					<div class="form-group">
						<label for="ngayThang" class="col-sm-3 control-label">Ngày
							tháng:</label>
						<div class="col-sm-8">

							<div class="input-group">
								<div class="input-group-addon">
									<i class="fa fa-calendar"></i>
								</div>
								<input type="date" class="form-control" name="ngayThang"
									id="ngayThang" value="<%=kyLuatKhenThuong.getNgayThang()%>" required>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="hinhPhat" class="col-sm-3 control-label">Hình
							thức:</label>

						<div class="col-sm-8">
							<input type="text" name="hinhPhat" class="form-control"
								id="hinhPhat" placeholder="Hình phạt/ Khen thưởng"
								value="<%=kyLuatKhenThuong.getHinhPhat()%>" required>
						</div>
					</div>

				</div>
				<!-- /.box-body -->
				<div class="box-footer n10_box_footer col-sm-8 col-sm-offset-3">
					<button type="submit" class=" btn btn-info pull-left"
						value="suaKyLuat" name="suaKyLuat">Sửa</button>
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