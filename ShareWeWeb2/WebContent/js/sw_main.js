var n=0;

var posLeft

var btnRight = $(".btn_next>a")

var btnLeft = $(".btn_prev>a")

var timer1 = setInterval("autoLeft()", 3000);


function autoLeft(){
    n++;
    if(n<2){
        posLeft = -290*n;
        $(".sw_main_quick1_slider").stop().animate({"left":posLeft},500);
    }else{
        n = 0;
        posLeft = -290*n;
        $(".sw_main_quick1_slider").stop().animate({"left":posLeft},500);
    }
};


function autoRight(){
    n--;
    if(n<0){
        n = 1;
        posLeft = -290*n;
        $(".sw_main_quick1_slider").stop().animate({"left":posLeft},500);
    }else{
        posLeft = -290*n;
        $(".sw_main_quick1_slider").stop().animate({"left":posLeft},500);
    }
};


btnLeft.on("click",function(){
    autoRight();
    return false;
});

btnRight.on("click",function(){
    autoLeft();
    return false;
});

$(".btn_play>a").hide();
// stop 버튼 클릭하면    
$(".btn_stop").children().on("click",function(){
    clearInterval(timer1);
    $(this).hide();
    $(".btn_play>a").show();
    return false;
});    

// play 버튼 클릭하면    
$(".btn_play").children().on("click",function(){
    timer1 = setInterval("autoLeft()",3000);
    $(".btn_stop>a").show();
    $(this).hide();
    return false;
});     




/* tab_wrap */

$(".tab_control>li").eq(0).children().addClass("selected");

$("#tab_newsletter, #tab_survey").hide();

$(".tab_control>li>a").on("click", function(){
    $(".tab_contents>ul").hide();
    
    path1 = $(this).attr("href");
    
    $(path1).show();
    
    
    
});
$(".tab_control>li").eq(0).children("a").css("color","#85dac5");
$(".tab_control>li>a").on("click", function(){
    $(this).css("color","#85dac5");
        
    $(this).parent("li").siblings("li").children("a").css("color","#454545");
});







// 퀵메뉴 숨기기

$(".dan3").on("click", function(){
	$(".sw_quick_content").delay(300).stop().fadeOut(300);
	$(".sw_content_area").delay(300).css("width","915px");
	$(".sw_main_articles").delay(300).css("width","915px");
	
});


$(".dan2").on("mouseover", function(){
	$(this).children("img").attr("src","img/main/2dan_over.png");
});
$(".dan2").on("mouseleave", function(){
	$(this).children("img").attr("src","img/main/2dan.png");
});





$(".dan2").on("click", function(){
	$(".sw_quick_content").stop().fadeIn(300).delay(300);
	$(".sw_content_area").delay(300).css("width","610px");
	$(".sw_main_articles").delay(300).css("width","610px");
});

$(".dan3").on("mouseover", function(){
	$(this).children("img").attr("src","img/main/3dan_over.png");
});
$(".dan3").on("mouseleave", function(){
	$(this).children("img").attr("src","img/main/3dan.png");
});























