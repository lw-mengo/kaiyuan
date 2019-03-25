var runPage;
runPage = new FullPage({
	id: 'pageContain',
	slideTime: 800,
	effect: {
		transform: {
			translate: 'Y',
			scale: [1, 1],
			rotate: [0, 0]
		},
		opacity: [0, 1]
	},
	mode: 'wheel,touch,nav:navBar',
	easing: 'ease-out',
	callback: function(index, thisPage){
		if(index == 0){ 
			$("#navBar").animate({'opacity':'0'}).hide();
		}else{
            $("#navBar").animate({'opacity':'1'}).show();
		}
		    $("#navBar i").animate({
			    	'left':'-49px',
		             'opacity':'0'
			    },'500').hide();
		        $("#navBar li:eq("+index+")").find('i').animate({
		                 	'left':'-60px',
		                 	'opacity':'1'
		             },500).show();
		if(index == 1){ 
                $(".page2 .w_title_com h1").addClass('animated fadeInDown').animate({'opacity':'1'},'1000',function(){
            	$('.page2 .w_title_com h2').delay(100).addClass('animated fadeInDown').animate({'opacity':'1'}).show();
            	$('.page2 .feature_left').delay(100).addClass('animated fadeInLeft').animate({'opacity':'1'}).show();
            	$('.page2 .feature_right').delay(100).addClass('animated fadeInRight').animate({'opacity':'1'},function(){
                    $('.page2 .feature_right h1').delay(100).animate({'opacity':'1'}).show();
                    $('.page2 .feature_right p').delay(400).animate({'opacity':'1'}).show();
                    $('.page2 .feature_right .feature_item').delay(700).animate({'opacity':'1'}).show();
                    $('.page2 .feature_right .detail').delay(1000).animate({'opacity':'1'}).show();

              }).show();
            	
            }).show();
		}
		if(index == 2){
			 $(".page3 .w_title_com h1").addClass('animated fadeInDown').animate({'opacity':'1'},'1000',function(){
            	$('.page3 .w_title_com h2').delay(100).addClass('animated fadeInDown').animate({'opacity':'1'}).show();
            	$('.page3 .feature_left').delay(100).addClass('animated fadeInRight').animate({'opacity':'1'}).show();
            	$('.page3 .feature_right').delay(100).addClass('animated fadeInLeft').animate({'opacity':'1'},function(){
                   $('.page3 .feature_right h1').delay(100).animate({'opacity':'1'}).show();
                    $('.page3 .feature_right p').delay(400).animate({'opacity':'1'}).show();
                    $('.page3 .feature_right .feature_item').delay(700).animate({'opacity':'1'}).show();
                    $('.page3 .feature_right .detail').delay(1000).animate({'opacity':'1'}).show();

              }).show();
            	
            }).show();
		}
		if(index == 3){
			   $(".page4 .w_title_com h1").addClass('animated fadeInDown').animate({'opacity':'1'},'1000',function(){
            	$('.page4 .w_title_com h2').delay(100).addClass('animated fadeInDown').animate({'opacity':'1'}).show();
            	$('.page4 .feature_left').delay(100).addClass('animated fadeInLeft').animate({'opacity':'1'}).show();
            	$('.page4 .feature_right').delay(100).addClass('animated fadeInRight').animate({'opacity':'1'},function(){
                    $('.page4 .feature_right h1').delay(100).animate({'opacity':'1'}).show();
                    $('.page4 .feature_right p').delay(400).animate({'opacity':'1'}).show();
                    $('.page4 .feature_right .feature_item').delay(700).animate({'opacity':'1'}).show();
                    $('.page4 .feature_right .detail').delay(1000).animate({'opacity':'1'}).show();
               }).show();
            	
            }).show();
		}
		if(index == 4){
			     $(".page5 .w_title_com h1").addClass('animated fadeInDown').animate({'opacity':'1'},'1000',function(){
            	$('.page5 .w_title_com h2').delay(100).addClass('animated fadeInDown').animate({'opacity':'1'}).show();
            	$('.page5 .feature_left').delay(100).addClass('animated fadeInRight').animate({'opacity':'1'}).show();
            	$('.page5 .feature_right').delay(100).addClass('animated fadeInLeft').animate({'opacity':'1'},function(){
                    $('.page5 .feature_right h1').delay(100).animate({'opacity':'1'}).show();
                    $('.page5 .feature_right p').delay(400).animate({'opacity':'1'}).show();
                    $('.page5 .feature_right .feature_item').delay(700).animate({'opacity':'1'}).show();
                    $('.page5 .feature_right .detail').delay(1000).animate({'opacity':'1'}).show();

              }).show();
            	
            }).show();

		}
		if(index == 5){
			 $(".page6 .w_title_com h1").addClass('animated fadeInDown').animate({'opacity':'1'},'1000',function(){
            	$('.page6 .w_title_com h2').delay(100).addClass('animated fadeInDown').animate({'opacity':'1'}).show();
            	$('.page6 .feature_left').delay(100).addClass('animated fadeInLeft').animate({'opacity':'1'}).show();
            	$('.page6 .feature_right').delay(100).addClass('animated fadeInRight').animate({'opacity':'1'},function(){
                    $('.page6 .feature_right h1').delay(100).animate({'opacity':'1'}).show();
                    $('.page6 .feature_right p').delay(400).animate({'opacity':'1'}).show();
                    $('.page6 .feature_right .detail').delay(700).animate({'opacity':'1'}).show();
              }).show();
            	
            }).show();

		}
		if(index == 6){
            	
            	$('.page7 .form_right').delay(100).addClass('animated fadeInRight').animate({'opacity':'1'}).show();
              $('.page7 .detail_left').delay(100).addClass('animated fadeInLeft').animate({'opacity':'1'},function(){
                    $('.detail_left .t1').delay(100).animate({'opacity':'1'}).show();
                    $('.detail_left .t2').delay(300).animate({'opacity':'1'}).show();
                    $('.detail_left .d_info').delay(500).animate({'opacity':'1'}).show();
                     $('.detail_left .er').delay(700).animate({'opacity':'1'}).show();
                     $('.detail_left .d_des').delay(900).animate({'opacity':'1'}).show();
              }).show();
            
		}
		
	}

});




//导航
$(function(){

	//粒子跟随

 $('.particles').css({'width':$(window).width(),'height':$(window).height()});
  $('.particles').particleground({
    dotColor: '#e0ecfa',
    lineColor: '#e0ecfa',
  });

//数字滚动
var window_h = $(window).height(); 

$(".banner_sj").addClass('banner_sjdh');
$(".banner_sj").hover(function(){
$(".banner_sj").removeClass('banner_sjdh');
},function(){
  $(".banner_sj").addClass('banner_sjdh');
})
$(".banner_sj").click(function(){
 runPage.next();
})
//bannerS
var mySwiper = new Swiper ('.swiper-container', {
    pagination: '.pagination',
    paginationClickable :true,
    autoplay : 10000,
      speed:1, 
  onFirstInit: function(swiper){ 
    swiperAnimateCache(swiper); 
    swiperAnimate(swiper); 
  }, 
  onSlideChangeEnd: function(swiper){ 
    swiperAnimate(swiper);
   $('.counter').lemCounter();
  } 
  })  
  $('.bprev').click(function(){
mySwiper.swipePrev(); 
})
$('.bnext').click(function(){
mySwiper.swipeNext(); 
})  
//bannerE




})
