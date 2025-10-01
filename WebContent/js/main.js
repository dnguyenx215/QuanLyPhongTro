//
// This is The Scripts used for Simply Theme
// 


function main() {

(function () {
   'use strict'
	//Script
	//-----------------------------------
	

  	jQuery(document).ready(function($){

  		// Delete
  		jQuery('.btn_del').click(function(event){
  		 	var confirm_val = confirm("Bạn có muốn xóa mục này không ??");
  		 	if( confirm_val==false){
  		 		event.preventDefault();
  		 	}else{

  		 	}
  		});


		

  		
  		// Change value khu nhà
  		$('#chonSV').change(function(){

  			var sex = $(this).find(":selected").attr('gioitinh');
  			
  			if(sex ==0){
  				$('#chonKhuNha option[value=1]').hide();
  				$('#chonKhuNha option[value=2]').show();
  			}else if(sex == 1){
  				$('#chonKhuNha option[value=2]').hide();
  				$('#chonKhuNha option[value=1]').show();
  				
  			}else{
  				$('#chonKhuNha option').show();
  			}

  		});



		// pagination
		

		function pagination($table,count_row,itemsPerPage){
			$table.each(function () {
				var currentPage = 0;
				var pages = Math.ceil(count_row / itemsPerPage);
				$table.bind('repaginate', function () {
	                if (pages > 1) {
	                	$('.pager').show();
	                	var pager;
		                if ($table.next().hasClass("pager"))
							pager = $table.next().empty();  
						else
							pager = $('<ul class="pager" style="padding-top: 20px; direction:ltr; border-radius:none; " align="center"></ul>');

		                $('<li class="pg-back"><a href="#" class=" btn btn-defaul"'+(currentPage==0 ?'style="cursor:not-allowed"' : '')+'> Trước </a></li>').bind('click', function () {
							if (currentPage > 0)
								currentPage--;
							$table.trigger('repaginate');
		                }).appendTo(pager);

			            var startPager = currentPage > 2 ? currentPage - 2 : 0;
			            var endPager = startPager > 0 ? currentPage + 3 : 5;
			            if (endPager > pages) {
							endPager = pages;
							startPager = pages - 5;    if (startPager < 0)
							startPager = 0;
			            }

			            for (var page = startPager; page < endPager; page++) {
			            	var link_page = $('<li id="pg' + page + '" class="' + (page == currentPage ? 'pg-selected' : 'pg-normal') + '"></li>');

							$('<a href="#" class="btn '+(page == currentPage ? 'btn-primary' : 'btn-defaul')+'"></a>').text(page + 1).bind('click', {
							newLink: page
							}, function (event) {
								currentPage = event.data['newLink'];
								$table.trigger('repaginate');
							}).appendTo(link_page);

							$(link_page).bind('click',{ newPage : page}, function(event){
								currentPage = event.data['newPage'];
								$table.trigger('repaginate');
							}).appendTo(pager);
			            }

			            $('<li class="pg-next"><a href="#" class="btn btn-defaul"'+(currentPage==pages-1 ?'style="cursor:not-allowed"' : '')+'> Sau </a></li>').bind('click', function () {
							if (currentPage < pages - 1)
								currentPage++;
							$table.trigger('repaginate');
			            }).appendTo(pager);


			            if (!$table.next().hasClass("pager"))
			              pager.insertAfter($table);
			              //pager.insertBefore($table);
	          		}// end $table.bind('repaginate', function () { ...
	          		else{
	          			$('.pager').hide();
	          		}
	          	$table.find(
	          	'tbody tr:not(:has(th))').hide().slice(currentPage * itemsPerPage, (currentPage + 1) * itemsPerPage).show();
	         	});

	          	$table.trigger('repaginate');
	        });
		}




		// find("tr:not(:has(th))")
		//Change Sinh viên

		
		// Phòng change cout
		function removeTable($table){
			$table.find('tr:not(:has(th))').each(function(i, v){
				$(this).remove();
			});
		}

		// get Data
		var data = Array();
		function getData(data,$table){
			$table.each(function(i, v){
			    data[i] = Array();
			    $(this).children('td').each(function(ii, vv){
			        data[i][ii] = $(this).text();
			    }); 
			});
		}
		getData(data,$("table#showphong tr:not(:has(th))"));

		// get val of table to array
  		function getCount(data_coutn){
  			$("table#showphong tr:not(:has(th))").each(function(i, v){
  				data_coutn[i] = Array();
			    $(this).children('td').each(function(ii,vv){
			        data_coutn[i][ii]  = $(this).text();
			    }); 
			});
  		}




		// Show in all table
		function getTable(data,$table,servlet1,servlet2){
			for( var i = 0; i<data.length;i++){
				$table.append('<tr></tr>');
			}
			$table.find('tr').each(function(i, v){
				for(var j=0;j<data[i].length;j++){
					if(j==(data[i].length-1)){
						$(this).append('<td class="pull-center"><a href="'+servlet1+'" style="margin:0 2px;" class="n10_btn btn_edit"><i class="fa fa-pencil-square-o"></i></a><a href="'+servlet2+'" class="btn btn-danger" style="margin:0 2px;">Xóa</a></td>');
					}
					else{
						$(this).append('<td>'+data[i][j]+'</td>');
					}
				}
			});
		}


		// show in table by sex
		function getTableBySex(sex,data){
			var x = 0;
			var textSearch = $('#searchPhong').val();
			if(textSearch==""){
				if(sex==""){
					for( var i = 0; i<data.length;i++){
						$("table#showphong tbody").append('<tr></tr>');
					}
					$("table#showphong tr:not(:has(th))").each(function(i, v){
				    	$(this).append('<td>'+data[i][0]+'</td>');
				    	$(this).append('<td>'+data[i][1]+'</td>');
				    	$(this).append('<td>'+data[i][2]+'</td>');
				    	$(this).append('<td>'+data[i][3]+'</td>');
				    	$(this).append('<td class="pull-center"><a href="ThemHopDongServlet" class="btn btn-info n10_list_link">'+data[i][4]+'</a></td>');
					});
					x=i;
				}else{
					for( var i = 0; i<data.length;i++){
						if(data[i][2]==sex || data[i][2]=="-"){
							$("table#showphong tbody").append('<tr></tr>');
							x++;
						}

					}
					var k=0;
					$("table#showphong tbody tr").each(function(i, v){
				    	for(var j=k; j<data.length;j++){
				    		if(data[j][2]==sex|| data[j][2]=="-"){
					    		$(this).append('<td>'+data[j][0]+'</td>');
						    	$(this).append('<td>'+data[j][1]+'</td>');
						    	$(this).append('<td>'+data[j][2]+'</td>');
						    	$(this).append('<td>'+data[j][3]+'</td>');
						    	$(this).append('<td class="pull-center"><a href="ThemHopDongServlet" class="btn btn-info n10_list_link">'+data[i][4]+'</a></td>');
						    	k=j+1;
						    	break;
					    	}
				    	}
					});
				}
			}
			else{
				if(sex==""){
					var t =0;
					for( var i = 0; i<data.length;i++){
						if(data[i][3].indexOf(textSearch)>=0){
							$("table#showphong tbody").append('<tr></tr>');
							t++;
						}
					}
					var k=0;
					$("table#showphong tr:not(:has(th))").each(function(i, v){

				    	for(var j=k; j<data.length;j++){
				    		if(data[j][3].indexOf(textSearch)>=0){
					    		$(this).append('<td>'+data[j][0]+'</td>');
						    	$(this).append('<td>'+data[j][1]+'</td>');
						    	$(this).append('<td>'+data[j][2]+'</td>');
						    	$(this).append('<td>'+data[j][3]+'</td>');
						    	$(this).append('<td class="pull-center"><a href="ThemHopDongServlet" class="btn btn-info n10_list_link">'+data[i][4]+'</a></td>');
						    	k=j+1;
						    	break;
					    	}
				    	}
					});
					x=t;
				}else{
					for( var i = 0; i<data.length;i++){
						if((data[i][2]==sex || data[i][2]=="-")&&data[i][3].indexOf(textSearch)>=0){
							$("table#showphong tbody").append('<tr></tr>');
							x++;
						}

					}
					var k=0;
					$("table#showphong tbody tr").each(function(i, v){
				    	for(var j=k; j<data.length;j++){
				    		if((data[j][2]==sex || data[j][2]=="-")&&data[j][3].indexOf(textSearch)>=0){
					    		$(this).append('<td>'+data[j][0]+'</td>');
						    	$(this).append('<td>'+data[j][1]+'</td>');
						    	$(this).append('<td>'+data[j][2]+'</td>');
						    	$(this).append('<td>'+data[j][3]+'</td>');
						    	$(this).append('<td class="pull-center"><a href="ThemHopDongServlet" class="btn btn-info n10_list_link">'+data[i][4]+'</a></td>');
						    	k=j+1;
						    	break;
					    	}
				    	}
					});
				}
			}
			return x;			
		}

		// Search in all td in table



		// Get val by text in array
  		function getTableSearch($table,dataSearch,textSearch,columSearchIndex,servlet1,servlet2){
  			console.log($table+" "+dataSearch+" "+textSearch+" "+columSearchIndex+" "+servlet1+" "+servlet2);
			if(textSearch==""){
				for( var i = 0; i<dataSearch.length;i++){
					$table.append('<tr></tr>');
				}
				$table.find('tr').each(function(i, v){
					for(var j=0;j<dataSearch[i].length;j++){
						if(j==(dataSearch[i].length-1)){
							$(this).append('<td class="pull-center"><a href="'+servlet1+'" style="margin:0 2px;" class="n10_btn btn_edit n10_list_link"><i class="fa fa-pencil-square-o"></i></a><a href="'+servlet2+'" class="n10_btn btn_del" style="margin:0 2px;"><i class="fa fa-trash"></i></a></td>');
						}
						else{
							$(this).append('<td>'+dataSearch[i][j]+'</td>');
						}
					}
				});
			}else{
				for( var i = 0; i<dataSearch.length;i++){
					console.log('a');
					if(dataSearch[i][columSearchIndex].indexOf(textSearch)>=0){
						$table.append('<tr></tr>');
					}

				}
				var k=0;
				$table.find('tr').each(function(i, v){
					for(var n=k;n<dataSearch.length;n++){
						if(dataSearch[n][columSearchIndex].indexOf(textSearch)>=0){
							for(var j=0;j<dataSearch[n].length;j++){
								if(j==(dataSearch[n].length-1)){
									$(this).append('<td class="pull-center"><a href="'+servlet1+'" style="margin:0 2px;" class="n10_btn btn_edit n10_list_link"><i class="fa fa-pencil-square-o"></i></a><a href="'+servlet2+'" class="n10_btn btn_del" style="margin:0 2px;"><i class="fa fa-trash"></i></a></td>');
								}
								else{
									$(this).append('<td>'+dataSearch[n][j]+'</td>');
								}
							}
							k=j+1;
					    	break;
						}
					}
				});
			}
  		}


		
		// Show search result
		// function showSearch(data_table,data_coutn){
  // 			var sex_val = $('#sinhVien').find(":selected").val();
  // 			var k=0;
  // 			if( sex_val!=""){
  // 				removeTable();
	 //  			k = getTableSearch(data_table,$('#searchBox').val());
  // 			}
  // 			else{
  // 				removeTable();
	 //  			k = getTableSearch(data_coutn,$('#searchBox').val());
  // 			}
  // 			// if(typeof($(this).val())==="undefined"&& sex_val!=""){
  // 			// 	removeTable();
	 //  		// 	k = getTableSearch(data_table,$('#searchBox').val());
  // 			// }
  // 			pagination($('table#showphong'),k,10);
		// }

		// function pagination(entity){
		// 	$('table#showphong').each(function () {
		// 		var $table = $(this);
		// 		var itemsPerPage =10;
		// 		var currentPage = 0;
		// 		var pages = Math.ceil(entity / itemsPerPage);
				
		// 		$table.bind('repaginate', function () {
	 //                if (pages > 1) {
	 //                	$('.pager').css('display','block');
	 //                	var pager;
		//                 if ($table.next().hasClass("pager"))
		// 					pager = $table.next().empty();  
		// 				else
		// 					pager = $('<ul class="pager" style="padding-top: 20px; direction:ltr; border-radius:none; " align="center"></ul>');

		//                 $('<li class="pg-back"><a href="#" class=" btn btn-defaul"'+(currentPage==0 ?'style="cursor:not-allowed"' : '')+'> Trước </a></li>').bind('click', function () {
		// 					if (currentPage > 0)
		// 						currentPage--;
		// 					$table.trigger('repaginate');
		// 					// $('#sinhVien').trigger('change');
		//                 }).appendTo(pager);

		// 	            var startPager = currentPage > 2 ? currentPage - 2 : 0;
		// 	            var endPager = startPager > 0 ? currentPage + 3 : 5;
		// 	            if (endPager > pages) {
		// 					endPager = pages;
		// 					startPager = pages - 5;    if (startPager < 0)
		// 					startPager = 0;
		// 	            }

		// 	            for (var page = startPager; page < endPager; page++) {
		// 	            	var link_page = $('<li id="pg' + page + '" class="' + (page == currentPage ? 'pg-selected' : 'pg-normal') + '"></li>');

		// 					$('<a href="#" class="btn '+(page == currentPage ? 'btn-primary' : 'btn-defaul')+'"></a>').text(page + 1).bind('click', {
		// 					newLink: page
		// 					}, function (event) {
		// 						currentPage = event.data['newLink'];
		// 						$table.trigger('repaginate');
		// 						// $('#sinhVien').trigger('change');
		// 					}).appendTo(link_page);

		// 					$(link_page).bind('click',{ newPage : page}, function(event){
		// 						currentPage = event.data['newPage'];
		// 						$table.trigger('repaginate');
		// 						// $('#sinhVien').trigger('change');
		// 					}).appendTo(pager);
		// 	            }

		// 	            $('<li class="pg-next"><a href="#" class="btn btn-defaul"'+(currentPage==pages-1 ?'style="cursor:not-allowed"' : '')+'> Sau </a></li>').bind('click', function () {
		// 					if (currentPage < pages - 1)
		// 						currentPage++;
		// 					$table.trigger('repaginate');
		// 					// $('#sinhVien').trigger('change');
		// 	            }).appendTo(pager);


		// 	            if (!$table.next().hasClass("pager"))
		// 	              pager.insertAfter($table);
		// 	              //pager.insertBefore($table);
			        
		//           	}// end $table.bind('repaginate', function () { ...
		//           	else{
		// 		        	$('.pager').css('display','none');
		// 		        }
		//           	$table.find('tbody tr:not(:has(th))').hide().slice(currentPage * itemsPerPage, (currentPage + 1) * itemsPerPage).show();
	 //          	});

	 //         	 $table.trigger('repaginate');
	 //        });
		// }

		// table index

		getTableBySex("",data);
		pagination($('table#showphong'),$('table#showphong').find("tr:not(:has(th))").length,10);



		var data_table = Array();
		$('#sinhVien').change(function(){
			var k=0;
			var sex = $(this).find(":selected").attr('gioitinh');
			if(sex==1){
				removeTable($('table#showphong'));
				k = getTableBySex('Nam',data);

			}
			else if(sex==0){
				removeTable($('table#showphong'));
				k = getTableBySex('Nữ',data);
			}else{
				removeTable($('table#showphong'));
				k = getTableBySex("",data);
				
			}
			pagination($('table#showphong'),k,10);
			getCount(data_table);
			
		});



  		var data_coutn = Array();
  		getCount(data_coutn);

  		var n=0;
  		$('#searchPhong').keyup(function(){
			var sex = $(this).find(":selected").attr('gioitinh');
			if(sex==1){
				removeTable($('table#showphong'));
				n = getTableBySex('Nam',data_table);

			}
			else if(sex==0){
				removeTable($('table#showphong'));
				n = getTableBySex('Nữ',data_table);
			}else{
				removeTable($('table#showphong'));
				n = getTableBySex("",data_table);
				
			}
			pagination($('table#showphong'),n,10);
  		});



  		//table Hoa don
		// Pagination table
		var itemsPerPage = $('#my_vl').val();
		pagination($('table#hoaDon'),$('table#hoaDon').find("tr:not(:has(th))").length,itemsPerPage);

		// Change value of count entries
		$('#my_vl').change(function(){
			itemsPerPage = $('#my_vl').val();
			pagination($('table#hoaDon'),$('table#hoaDon').find("tr:not(:has(th))").length,itemsPerPage);
		});

  		var datatb= Array();
  		getData(datatb,$('table#hoaDon  tr:not(:has(th))'));


	  	$('#searchBox').keyup(function(){
			console.log(datatb);
  			var value = $('#searchBox').val();
  			console.log(value);
  			if(value==""){
  				removeTable($('table#hoaDon  tbody'));
  				getTableSearch($('table#hoaDon  tbody'),datatb,"",1,"SuaHoaDonServlet","XoaHoaDonServlet");
  			}
		    else{
		    	removeTable($('table#hoaDon  tbody'));
		    	getTableSearch($('table#hoaDon  tbody'),datatb,value,1,"SuaHoaDonServlet","XoaHoaDonServlet");
		    }
		    pagination($('table#hoaDon'),$('table#hoaDon').find("tr:not(:has(th))").length,itemsPerPage);
  		});


  		// Table Hợp Đồng
  // 		var itemsPerPage = $('#my_vl').val();
		// pagination($('table#hopDong'),$('table#hopDong').find("tr:not(:has(th))").length,itemsPerPage);

		// // Change value of count entries
		// $('#my_vl').change(function(){
		// 	itemsPerPage = $('#my_vl').val();
		// 	pagination($('table#hopDong'),$('table#hopDong').find("tr:not(:has(th))").length,itemsPerPage);
		// });
  // 		var datatb= Array();
  // 		getData(datatb,$('table#hopDong  tr:not(:has(th))'));
		// getTable(datatb,$('table#hopDong  tbody'),"SuaHopDongServlet","XoaHopDongServlet");
  // 		$('#searchBox').keyup(function(){
  			
  // 		});





	});

	jQuery(window).scroll(function(){
		
	});
	
	jQuery(window).load(function(){
		
		
		
	});
	
}());

}
main();