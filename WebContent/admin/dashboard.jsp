<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@page import="common.KiemTra"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="headerAdmin.jsp"%>

<!-- Main content -->
<!-- Tạo form và table vào đây ===================================================================-->
<%
	int soPhong = (int) request.getAttribute("soPhong");
	int soPhongDangThue = (int) request.getAttribute("soPhongDangThue");
	int soNam = (int) request.getAttribute("soNam");
	int soNu = (int) request.getAttribute("soNu");
	int soNhanVien = (int) request.getAttribute("soNhanVien");
	Hashtable<String, Integer> dsHopDongTheoThang = (Hashtable<String, Integer>) request
			.getAttribute("dsHopDongTheoThang");
%>

<section class="content container-fluid dashboard">
	<!-- Small boxes (Stat box) -->
	<div class="n10_statistic" style="margin-top: 70px;">
		<div class="row">
			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="info-box bg-aqua">
					<span class="info-box-icon"><i class="fa fa-home"></i></span>

					<div class="info-box-content">
						<span class="info-box-text">Phòng</span> <span
							class="info-box-number"><%=soPhongDangThue%>/<%=soPhong%></span>

						<div class="progress">
							<div class="progress-bar"
								style="width: <%=KiemTra.tinhPhanTram(soPhongDangThue, soPhong)%>%"></div>
						</div>
						<span class="progress-description"> <%=KiemTra.tinhPhanTram(soPhongDangThue, soPhong)%>%
							Đang thuê
						</span>
					</div>
					<!-- /.info-box-content -->
				</div>
				<!-- /.info-box -->
			</div>
			<!-- /.col -->
			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="info-box bg-green">
					<span class="info-box-icon"><i class="fa fa-male"></i></span>

					<div class="info-box-content">
						<span class="info-box-text">Nam</span> <span
							class="info-box-number"><%=soNam%>/<%=(soNu + soNam)%></span>

						<div class="progress">
							<div class="progress-bar"
								style="width: <%=KiemTra.tinhPhanTram(soNam, (soNam + soNu))%>%"></div>
						</div>
						<span class="progress-description"> <%=KiemTra.tinhPhanTram(soNam, (soNam + soNu))%>%
							Nam
						</span>
					</div>
					<!-- /.info-box-content -->
				</div>
				<!-- /.info-box -->
			</div>
			<!-- /.col -->
			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="info-box bg-yellow">
					<span class="info-box-icon"><i class="fa fa-female"></i></span>

					<div class="info-box-content">
						<span class="info-box-text">Nữ</span> <span
							class="info-box-number"><%=soNu%>/<%=(soNam + soNu)%></span>

						<div class="progress">
							<div class="progress-bar"
								style="width: <%=KiemTra.tinhPhanTram(soNu, (soNam + soNu))%>%"></div>
						</div>
						<span class="progress-description"> <%=KiemTra.tinhPhanTram(soNu, (soNam + soNu))%>%
							Nữ
						</span>
					</div>
					<!-- /.info-box-content -->
				</div>
				<!-- /.info-box -->
			</div>
			<!-- /.col -->
			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="info-box bg-red">
					<span class="info-box-icon"><i class="fa fa-users"></i></span>

					<div class="info-box-content">
						<span class="info-box-text">Nhân Viên</span> <span
							class="info-box-number"><%=soNhanVien%></span>

						<div class="progress">
							<div class="progress-bar" style="width: 100%"></div>
						</div>
						<span class="progress-description"> 100% Đi làm </span>
					</div>
					<!-- /.info-box-content -->
				</div>
				<!-- /.info-box -->
			</div>
			<!-- /.col -->
		</div>
	</div>

	<div class="n10_chart " style="width: 97%; margin: 70px auto 0;">
		<div class="row">
			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">Số lượng hợp đồng theo tháng</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button type="button" class="btn btn-box-tool"
							data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>
				<div class="box-body chart-responsive">
					<div class="chart" id="line-chart" style="height: 300px;"></div>
				</div>
				<!-- /.box-body -->
			</div>
		</div>
	</div>


</section>
<!-- Thêm xong ================================================================================-->
</div>

<!-- Main Footer -->
<footer class="main-footer">
	<div class="pull-center hidden-xs">
		<strong>Copyright &copy; 2019 <a href="#">Nhóm 15</a>.
		</strong> All rights reserved.
	</div>

</footer>

</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- Select2 -->
<script type="text/javascript" src="js/select2.full.min.js"></script>

<!-- Morris -->
<script type="text/javascript" src="js/morris.min.js"></script>
<!-- Raphael -->
<script type="text/javascript" src="js/raphael.min.js"></script>
<!-- Table -->
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<!-- Main -->
<script type="text/javascript" src="js/adminlte.min.js"></script>
<script type="text/javascript" src="js/main_update.js"></script>
<script type="text/javascript">
    $(function () {
    "use strict";
    // LINE CHART
    var line = new Morris.Line({
      element: 'line-chart',
      resize: true,
      data: [
    	<%Enumeration<String> e = dsHopDongTheoThang.keys();
			while (e.hasMoreElements()) {
				String key = e.nextElement();%>
		{y: '<%=key%>', HD: <%=dsHopDongTheoThang.get(key)%>},
		<%}%>
      ],
      xkey: 'y',
      ykeys: ['HD'],
      labels: ['HD'],
      lineColors: ['#3c8dbc'],
      hideHover: 'auto'
    });
  });
</script>
</body>
</html>