
<%@page import="model.bean.Phong"%>
<%@page import="model.bean.KhuNha"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../headerAdmin.jsp"%>
<%
	ArrayList<KhuNha> dsKhuNhaP = (ArrayList<KhuNha>) request.getAttribute("dsKhuNhaP");
	Phong p = (Phong) request.getAttribute("suaPhong");
%>
<section class="content container-fluid">
	<div class="row">
		<div class="box box-info col-sm-8 col-sm-offset-2">
			<div class="box-header with-border pull-center">
				<h3 class="box-title ">Cập nhật Phòng</h3>
			</div>
			<!-- /.box-header -->
			<!-- form start -->
			<form class="form-horizontal" action="SuaPhongServlet" method="post">
				<div class="box-body">

					<div class="form-group">
						<label for="phongID" class="col-sm-3 control-label">ID: </label>

						<div class="col-sm-8">
							<input type="text" name="phongID" class="form-control"
								id="phongID" value="<%=p.getId()%>" readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label for="soPhong" class="col-sm-3 control-label">Số
							Phòng: </label>

						<div class="col-sm-8">
							<input type="text" name="soPhong" class="form-control"
								id="soPhong" placeholder="Số phòng"
								value="<%=p.getTenPhong()%>" required>
						</div>
					</div>

					<div class="form-group">
						<label for="chonKhuNha" class="col-sm-3 control-label">Chọn
							khu</label>
						<div class="col-sm-8">
							<select class="form-control select2" name="chonKhuNha"
								id="chonKhuNha" required="required">
								<option value="">---------Chọn khu nhà-------</option>
								<%
									for (KhuNha kn : dsKhuNhaP) {
								%>
								<option value="<%=kn.getId()%>"
									<%=kn.getId() == p.getIdKhuNha() ? "selected" : ""%>><%=kn.getKhuNha()%></option>
								<%
									}
								%>
							</select>
						</div>
					</div>


					<div class="form-group">
						<label for="soNguoiHienTai" class="col-sm-3 control-label">Số
							người hiện tại</label>

						<div class="col-sm-8">
							<input type="text" name="soNguoiHienTai" class="form-control"
								id="soNguoiHienTai" placeholder="Số người hiện tại"
								value="<%=p.getSoNguoiHienTai()%>" readonly="readonly" required>
						</div>
					</div>

					<div class="form-group">
						<label for="soNguoiToiDa" class="col-sm-3 control-label">Số
							người tối đa</label>

						<div class="col-sm-8">
							<input type="text" name="soNguoiToiDa" class="form-control"
								id="soNguoiToiDa" placeholder="Số người tối đa"
								value="<%=p.getSoNguoiToiDa()%>" required>
						</div>
					</div>

				</div>
				<!-- /.box-body -->
				<div class="box-footer n10_box_footer col-sm-8 col-sm-offset-3">
					<button type="submit" name="suaPhong" value="suaPhong"
						class=" btn btn-info pull-left">Lưu</button>
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
<%@include file="../footerAdmin.jsp"%>