
<%@page import="model.bean.KhuNha"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp"%>
<%
	ArrayList<KhuNha> dsKhuNhaP = (ArrayList<KhuNha>) request.getAttribute("dsKhuNhaP");
%>
<section class="content container-fluid">
	<div class="row">
		<div class="box box-info col-sm-8 col-sm-offset-2">
			<div class="box-header with-border pull-center">
				<h3 class="box-title ">Thêm mới Phòng</h3>
			</div>
			<!-- /.box-header -->
			<!-- form start -->
			<form class="form-horizontal" action="ThemPhongServlet" method="post">
				<div class="box-body">
					<div class="form-group">
						<label for="soPhong" class="col-sm-3 control-label">Tên
							Phòng: </label>

						<div class="col-sm-8">
							<input type="text" name="soPhong" class="form-control"
								id="soPhong" placeholder="Tên phòng" required>
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
								<option value="<%=kn.getId()%>"><%=kn.getKhuNha()%></option>
								<%
									}
								%>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="soNguoiToiDa" class="col-sm-3 control-label">Số
							người tối đa</label>

						<div class="col-sm-8">
							<input type="number" name="soNguoiToiDa" class="form-control"
								id="soNguoiToiDa" placeholder="Số người tối đa" value="8"
								required>
						</div>
					</div>
				</div>
				<!-- /.box-body -->
				<div class="box-footer n10_box_footer col-sm-8 col-sm-offset-3">
					<button type="submit" name="themPhong" value="themPhong"
						class=" btn btn-info pull-left">Thêm</button>
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