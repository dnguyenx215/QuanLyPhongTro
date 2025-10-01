<%@page import="model.bean.TruongHoc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp"%>
<%
	TruongHoc truongHoc = (TruongHoc) request.getAttribute("truongHoc");
%>
<section class="content container-fluid">
	<div class="row">
		<div class="box box-info col-sm-8 col-sm-offset-2">
			<div class="box-header with-border pull-center">
				<h3 class="box-title ">Chỉnh Sửa trường học</h3>
			</div>
			<!-- /.box-header -->
			<!-- form start -->
			<form class="form-horizontal" action="SuaTruongServlet" method="post">
				<div class="box-body">
					<div class="form-group">
						<label for="idTruong" class="col-sm-3 control-label">ID
							trường học:</label>

						<div class="col-sm-8">
							<input type="text" name="idTruong" class="form-control"
								id="idTruong" value="<%=truongHoc.getId()%>" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="schoolName" class="col-sm-3 control-label">Tên
							trường:</label>

						<div class="col-sm-8">
							<input type="text" name="schoolName" class="form-control"
								id="schoolName" placeholder="Tên trường" value="<%=truongHoc.getTenTruong()%>"
								required>
						</div>
					</div>
					<div class="form-group">
						<label for="schoolAddress" class="col-sm-3 control-label">Địa
							chỉ:</label>

						<div class="col-sm-8">
							<input type="text" name="schoolAddress" class="form-control"
								id="schoolAddress" placeholder="Địa chỉ" value="<%=truongHoc.getDiaChi()%>"
								required>
						</div>
					</div>
				</div>
				<!-- /.box-body -->
				<div class="box-footer n10_box_footer col-sm-8 col-sm-offset-3">
					<button type="submit" name="suaTruong" value="suaTruong"
						class="btn btn-info pull-left">Lưu</button>
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