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
  		jQuery('.btn-danger').click(function(event){
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
			console.log(count_row);
			$table.each(function () {
				var currentPage = 0;
				var pages = Math.ceil(count_row / itemsPerPage);
				$table.bind('repaginate', function () {
	                if (pages > 1) {
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

	          $table.find(
	          'tbody tr:not(:has(th))').hide().slice(currentPage * itemsPerPage, (currentPage + 1) * itemsPerPage).show();
	          });

	          $table.trigger('repaginate');
	        });
		}


		// Pagination table
		var itemsPerPage = $('#my_vl').val();
		pagination($('table#paginated'),$('table#paginated').find("tr:not(:has(th))").length,itemsPerPage);

		// Change value of count entries
		$('#my_vl').change(function(){
			itemsPerPage = $('#my_vl').val();
			pagination($('table#paginated'),$('table#paginated').find("tr:not(:has(th))").length,itemsPerPage);
		});

		// find("tr:not(:has(th))")
		//Change Sinh viên

		
		// Phòng change cout
		function removeTable(){
			$("table#showphong tr:not(:has(th))").each(function(i, v){
				$(this).remove();
			});
		}

		// get Data
		var data = Array();
		function getData(){
			$("table#showphong tr:not(:has(th))").each(function(i, v){
			    data[i] = Array();
			    $(this).children('td').each(function(ii, vv){
			        data[i][ii] = $(this).text();
			    }); 
				$(this).remove();
			});
		}
		getData();

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
		function getTable( data){
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
		}


		// show in table by sex
		function getTableBySex(sex,data){
			var x = 0;
			var textSearch = $('#searchBox').val();
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

		// Get val by text in array
  	// 	function getTableSearch(dataCount,textSearch){
  	// 		var x = 0;
			// if(textSearch==""){
			// 	for( var i = 0; i<dataCount.length;i++){
			// 		$("table#showphong tbody").append('<tr></tr>');
			// 	}
			// 	$("table#showphong tr:not(:has(th))").each(function(i, v){
			//     	$(this).append('<td>'+dataCount[i][0]+'</td>');
			//     	$(this).append('<td>'+dataCount[i][1]+'</td>');
			//     	$(this).append('<td>'+dataCount[i][2]+'</td>');
			//     	$(this).append('<td>'+dataCount[i][3]+'</td>');
			//     	$(this).append('<td class="pull-center"><a href="ThemHopDongServlet" class="btn btn-info n10_list_link">'+dataCount[i][4]+'</a></td>');
			// 	});
			// 	x=i;
			// }else{
			// 	for( var i = 0; i<dataCount.length;i++){
			// 		if(dataCount[i][3].indexOf(textSearch)>=0){
			// 			$("table#showphong tbody").append('<tr></tr>');
			// 			x++;
			// 		}

			// 	}
			// 	var k=0;
			// 	$("table#showphong tbody tr").each(function(i, v){
			//     	for(var j=k; j<dataCount.length;j++){
			//     		if(dataCount[j][3].indexOf(textSearch)>=0){
			// 	    		$(this).append('<td>'+dataCount[j][0]+'</td>');
			// 		    	$(this).append('<td>'+dataCount[j][1]+'</td>');
			// 		    	$(this).append('<td>'+dataCount[j][2]+'</td>');
			// 		    	$(this).append('<td>'+dataCount[j][3]+'</td>');
			// 		    	$(this).append('<td class="pull-center"><a href="ThemHopDongServlet" class="btn btn-info n10_list_link">'+dataCount[i][4]+'</a></td>');
			// 		    	k=j+1;
			// 		    	break;
			// 	    	}
			//     	}
			// 	});
			// }
			// return x;
  	// 	}


		
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

		getTableBySex("",data);
		pagination($('table#showphong'),$('table#showphong').find("tr:not(:has(th))").length,10);



		var data_table = Array();
		$('#sinhVien').change(function(){
			var k=0;
			var sex = $(this).find(":selected").attr('gioitinh');
			if(sex==1){
				removeTable();
				k = getTableBySex('Nam',data);

			}
			else if(sex==0){
				removeTable();
				k = getTableBySex('Nữ',data);
			}else{
				removeTable();
				k = getTableBySex("",data);
				
			}
			pagination($('table#showphong'),k,10);
			getCount(data_table);
			
		});



  		var data_coutn = Array();
  		getCount(data_coutn);

  		$('#searchBox').keyup(function(){
			var k=0;
			var sex = $(this).find(":selected").attr('gioitinh');
			if((data_table.length>0 && $('#searchBox').val()!="")){
				if(sex==1){
					removeTable();
					k = getTableBySex('Nam',data_table);

				}
				else if(sex==0){
					removeTable();
					k = getTableBySex('Nữ',data_table);
				}else{
					removeTable();
					k = getTableBySex("",data_table);
					
				}
			}
			else{
				if(sex==1){
					removeTable();
					k = getTableBySex('Nam',data);

				}
				else if(sex==0){
					removeTable();
					k = getTableBySex('Nữ',data);
				}else{
					removeTable();
					k = getTableBySex("",data);
					
				}
			}
			pagination($('table#showphong'),k,10);
  		});


  		// $('#searchBox').keyup(function(){
  		// 	removeTable();
  		// 	var k = getTableSearch(data_coutn,$('#searchBox').val());
  		// 	pagination($('table#showphong'),k,10);
  		// });



	});

	jQuery(window).scroll(function(){
		
	});
	
	jQuery(window).load(function(){
		
		
		
	});
	
}());

}
main();