//
// This is The Scripts used for Team10
// 


function main() {

(function () {
   'use strict'
	//Script
	//-----------------------------------
	
    // $(document).ready(function() {$('.select2').select2();
    // });
  	jQuery(document).ready(function($){
      //Index slider

      //Select
      // CKEDITOR.replace('contentContact');
      
  	  $('.btn_back').click(function (){
  		 window.history.back();
	  });
      //Show login Form
      $('.n10_btn_login').click(function(){
        $('.login-page').css('display','block');
      });

      $('.register_acc').click(function(){
        $('.register-page').css('display','block');
        $('.login-page').css('display','none');
      });
      
      $('.n10_btn_register').click(function(){
          $('.register-page').css('display','block');
      });
      
      $('.have_acc').click(function(){
        $('.register-page').css('display','none');
        $('.login-page').css('display','block');
      });

      $(window).click(function(event){
        if ($(event.target).hasClass('login-page')||$(event.target).hasClass('register-page')) {
          $('.login-page').css('display','none');
          $('.register-page').css('display','none');
        }
      });

  		// Delete
  		jQuery('.btn_del').click(function(event){
  		 	var confirm_val = confirm("Bạn có muốn xóa mục này không ??");
  		 	if( confirm_val==false){
  		 		event.preventDefault();
  		 	}else{

  		 	}
  		});


      //Them Hop Dong
      //Hide select
    //   $('#chonPhong').prop('disabled',true);
    //   $('#chonKhuNha').prop('disabled',true);

  		// $('#chonSV').change(function(){
  		// 	var sex = $(this).find(":selected").attr('gioitinh');

  		// 	if(typeof(sex)=="undefined"){
    //       $('#chonPhong li[value=""]').prop('selected',true);
    //       $('#chonKhuNha li[value=""]').prop('selected',true);
    //       $('#chonPhong').prop('disabled',true);
    //       $('#chonKhuNha').prop('disabled',true);
    //     }
    //     else{
    //       $('#chonPhong').prop('disabled',false);
    //       $('#chonKhuNha').prop('disabled',false);
    //       if(sex ==0){
    //         $('#chonPhong li[gioitinh=1]').hide();
    //         $('#chonPhong li[gioitinh=0]').show();
    //       }else if(sex == 1){
    //         $('#chonPhong li[gioitinh=0]').hide();
    //         $('#chonPhong li[gioitinh=1]').show();
            
    //       }else{
    //         $('#chonPhong option').show();
    //       }
    //     }

  		// });
    //   $('#chonKhuNha').change(function(){
    //     var khu = $("#chonKhuNha").find(":selected").val();        
    //     var sex = $('#chonSV').find(":selected").attr('gioitinh');
    //     $('#chonPhong option').each(function(){
    //       var idk = $(this).attr('idk');
    //       var gtp = $(this).attr('gioitinh');
    //       if(idk==khu&&(gtp==sex||gtp=="")){
    //         $(this).show();
    //       }else{
    //         $(this).hide();
    //       }
    //     });
    //   });


    //   //Thêm Hóa Đơn
    //   $('#suaKhuNha').change(function(){
    //     var editKhu = $('#suaKhuNha').find(":selected").val();
    //     $('#suaPhong option').each(function(){
    //       var editIDk = $(this).attr('idk');
    //       console.log('khu '+editKhu+" phong "+editIDk);
    //       if(1==2){
    //         console.log('khu '+editKhu+" phong "+editIDk);
    //         $(this).show();
    //       }else{
    //         $(this).hide();
    //       }
    //     });
    //   });

      

	});

	jQuery(window).scroll(function(){
		
	});
	
	jQuery(window).load(function(){
		
		
		
	});
	
}());

}
main();