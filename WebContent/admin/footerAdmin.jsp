
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

<!-- AdminLTE App -->
<!-- Table -->
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script>
	$(function() {
		$('#dataTable').DataTable()
		$('#dataTable2').DataTable({
			'paging' : true,
			'lengthChange' : false,
			'searching' : false,
			'ordering' : true,
			'info' : true,
			'autoWidth' : false
		});
		$('.select2').select2();
	})
</script>
<!-- Main -->
<script type="text/javascript" src="js/adminlte.min.js"></script>
<script type="text/javascript" src="js/main_update.js"></script>

</body>
</html>