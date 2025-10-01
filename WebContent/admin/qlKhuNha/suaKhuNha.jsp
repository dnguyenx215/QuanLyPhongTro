<%@page import="model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.KhuNha"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp"%>
<!-- Main content -->
<!-- Tạo form và table vào đây ===================================================================-->
<%
KhuNha suaKNkhuNha = (KhuNha) request.getAttribute("suaKNkhuNha");
ArrayList<NhanVien> suaKNNhanVien=(ArrayList<NhanVien>)request.getAttribute("suaKNNhanVien");
%>


<section class="content container-fluid">
	<div class="row">
		<div class="box box-info col-sm-8 col-sm-offset-2">
			<div class="box-header with-border pull-center">
				<h3 class="box-title ">Chỉnh sửa khu nhà</h3>
			</div>
			<!-- /.box-header -->
			<!-- form start -->
			<form class="form-horizontal" action="SuaKhuNhaServlet">
				<div class="box-body">
					<div class="form-group">
						<label for="idKhuNha" class="col-sm-3 control-label">ID khu
							nhà:</label>

						<div class="col-sm-8">
							<input type="text" name="idKhuNha" class="form-control" id="idKhuNha"
								value="<%=suaKNkhuNha.getId()%>" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="khuNha" class="col-sm-3 control-label">Tên
							khu nhà:</label>

						<div class="col-sm-8">
							<input type="text" name="khuNha" class="form-control"
								id="khuNha" placeholder="Tên khu nhà" value="<%=suaKNkhuNha.getKhuNha()%>"" required>
						</div>
					</div>

					<div class="form-group">
						<label for="idNhanVien" class="col-sm-3 control-label">Người
							quản lý:</label>
						<div class="col-sm-8">
							<select class="form-control select2" name="idNhanVien" id="idNhanVien"
								required>
								<% for(NhanVien nv:suaKNNhanVien){
									if(nv.getId()==suaKNkhuNha.getIdNhanVien()){
										%>
										<option value="<%=nv.getId()%>" selected=""><%=nv.getHoTen()%></option>
										<%
									}else
										%>
										<option value="<%=nv.getId()%>" ><%=nv.getHoTen()%></option>
										<%
					
								} %>
								
								
				
							</select>
						</div>
					</div>
				</div>
				<!-- /.box-body -->
				<div class="box-footer n10_box_footer col-sm-8 col-sm-offset-3">
					<button type="submit" class="btn btn-info pull-left" value="suaKhuNha"  name="suaKhuNha">Lưu</button>
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