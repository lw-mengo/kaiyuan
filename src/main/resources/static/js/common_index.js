$(function(){

   if($(window).width() < 768){
     $('#menuwap').mmenu();
  }
  //微信部分
  $(".wx").hover(function(){
    $(".wx_img_big").toggle();
  })
//导航部分
    var cur_index=$(".nav_menu .active").index();
  $('.pullCtrl').hover(function (){
    var navIndex=$(this).index();
    $(this).addClass('active').siblings().removeClass('active');
    $('.pullDown').hide().eq(navIndex).stop(true,false).show().slideDown();
  },function (){
   $('.pullCtrl').eq(cur_index).addClass('active').siblings().removeClass('active');
    $('.pull_header').find('.pullDown').hide();

  });

  $('.pullDown').hover(function (){
     var navIndex2=$(this).index();
    $('.pullCtrl').eq(cur_index).removeClass('active');
     $('.pullCtrl').eq(navIndex2).addClass('active');
    $(this).show().siblings('.pullDown').hide();
  },function (){
 $('.pull_header').find('.pullDown').hide();
 $('.pullCtrl').eq(cur_index).addClass('active').siblings().removeClass('active');
  });
  //头部弹框下拉部分
  $(".hidebtn").click(function(){

      $(".dialog_hide").addClass("active").stop(false,true).animate({
          "top":"0px",
          "opacity":"1"
        },500);
  });

  $("#listCloseBtn").click(function(){
    $(".dialog_hide").stop(false,true).animate({
      "top":"-800px",
      "opacity":"0"
    },500).removeClass('active');
  });
  // 下拉表单提交部分

$("#go_submit").click(function(){
var hz_uname_top=$("#hz_uname_top").val();
 if(hz_uname_top == ""){
  layer.tips('请填写姓名', '#hz_uname_top',{tips:[1,'#005fd3']});
  $("#hz_uname").focus();
  return false;
 }


 var hz_dw_top=$("#hz_dw_top").val();
   if(hz_dw_top == ""){
  layer.tips('请填写您的公司名称', '#hz_dw_top',{tips:[1,'#005fd3']});
  $("#hz_dw_top").focus();
  return false;
 }


 var reg3 = /^1[3,4,5,8]\d{9}$/;
 var hz_tel_top=$("#hz_tel_top").val();
    if (!reg3.test(hz_tel_top)){
         layer.tips('电话格式不正确', '#hz_tel_top',{tips:[1,'#005fd3']});
       $("#hz_tel_top").focus();
        return false;
    }

  var hz_email_top=$("#hz_email_top").val();
   if( hz_email_top == ""){
  layer.tips('请填写您的邮箱', '#hz_email_top',{tips:[1,'#005fd3']});
  $("#hz_email_top").focus();
  return false;
 }
  var hz_xq_top=$("#hz_xq_top").val();
    if(hz_xq_top == ""){
  layer.tips('请填写您的需求', '#hz_xq_top',{tips:[1,'#005fd3']});
  $("#hz_xq_top").focus();
  return false;
 }

 $.ajax({
            'url':'?m=formguide&c=index&a=public_doajax',
            type : "POST",  
            data : {'hz_uname':hz_uname_top,'hz_tel':hz_tel_top,'hz_dw':hz_dw_top,'hz_email':hz_email_top,'hz_xq':hz_xq_top,'dosubmit':'1'}, 
            dataType: "json",   
            success : function(datasear){ 
               layer.msg('请稍候。。');
               if(datasear.flag !=  false){
 $('#hz_uname_top,#hz_tel_top,#hz_dw_top,#hz_email_top,#hz_xq_top').val('');
                    layer.msg(datasear.msg);
   $(".dialog_hide").stop(false,true).animate({
      "top":"-800px",
      "opacity":"0"
    },500).removeClass('active');

                }else{
                   layer.msg('提交失败');
                }
            }, 
            beforeSend: function () { 
                layer.msg('请稍候。。');
            },  
            error: function () {  
                 layer.msg('抱歉，出错啦！');
            }    

           })

})



})