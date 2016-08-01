
var isInited = false;
$(".popup_tab_control>li").eq(0).children().addClass("selected");

$("#popup_tab2, #popup_tab3").hide();

$(".popup_tab_control>li>a").on("click", function(){
    $(".mypage_popup_tab_wrap>div").hide();
    
    path1 = $(this).attr("href");
    
    $(path1).show();
    
    if(!isInited){
    	$("input[type=radio][name=rate]").change(function(){
    		$(this).parent("label").parent("div").find("label").find("div").hide();
    		$(this).parent("label").find("div").show();
    	});
    	
    	isInited = true;
    }
});
$(".popup_tab_control>li").eq(0).children("a").css("color","#006837");
$(".popup_tab_control>li>a").on("click", function(){
    $(this).css("color","#006837");
        
    $(this).parent("li").siblings("li").children("a").css("color","#fff");
});

$(function(){
	$("a[href=" + location.hash + "]").click();
	
	$("input[type=radio][name=rate]").change(function(){
		$(this).parent("label").parent("div").find("label").find("div").hide();
		$(this).parent("label").find("div").show();
	});
});



$(".hanjool_thumb_up").on("mouseover", function(){
	$(this).css("cursor","pointer");
});

$(".hanjool_thumb_down").on("mouseover", function(){
	$(this).css("cursor","pointer");
});


$(".hanjool_thumb_down").hide();

$(".hanjool_thumb_up").on("click", function(){
	$(".hanjool_thumb_up").hide();
	$(".hanjool_thumb_down>input").attr("checked","checked");
	$(".hanjool_thumb_up>input").attr("checked","");
	$(".hanjool_thumb_down").show();
})


$(".hanjool_thumb_down").on("click", function(){
	$(".hanjool_thumb_down").hide();
	$(".hanjool_thumb_up>input").attr("checked","checked");
	$(".hanjool_thumb_down>input").attr("checked","");
	$(".hanjool_thumb_up").show();
})



