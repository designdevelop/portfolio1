$(".sw_user_home").on("mouseover", function(){
    $(".sw_user_home>a>img").attr("src","img/main/mypage_icon_over.png");
});

$(".sw_user_home").on("mouseleave", function(){
    $(".sw_user_home>a>img").attr("src","img/main/mypage_icon.png");
});


$(".sw_user_notice").on("mouseover", function(){
    $(".sw_user_notice>a>img").attr("src","img/main/notice_over.png");
});

$(".sw_user_notice").on("mouseleave", function(){
    $(".sw_user_notice>a>img").attr("src","img/main/notice.png");
});


$(".sw_user_hone_btn_menu").hide();
$(".sw_user_home").on("mouseover", function(){
	$(".sw_user_hone_btn_menu").stop().slideDown(300);
});
$(".sw_user_home").on("mouseleave", function(){
	$(".sw_user_hone_btn_menu").stop().slideUp(300);
});


function logoutCheck(){
	if(confirm("정말로 로그아웃 하시겠습니까?")){
		location.href="logout.do"
	}
}



/* sw_quick_btn_wrap      */
/* .sw_quick_btn에 클릭이벤트 바인딩
 * status 속성 off -> on || on -> off
 * stop으로 와리가리 가능하게 하고,
 * 클릭이벤트 당시 좌표 기준으로 증감대입시 멀리 떠내려갈 수 있으므로
 * 위치를 절대값(?)으로 지정
 *  */
$(".sw_quick_btn").bind("click", function(){
	if($(this).attr("status")=="on"){
		$(this).attr("status", "off");
        $(".sw_group_btn").stop().animate({top:"10px"},300);
		$(".sw_write_btn").stop().animate({top:"10px"},300);
		$(".sw_chat_btn").stop().animate({top:"10px"},300);
        $("sw_quick_btn>img").attr("src","img/main/btn_quick.png");
        
	}else{
		$(this).attr("status", "on");
		$(".sw_group_btn").stop().animate({top:"-70px"},300);
		$(".sw_write_btn").stop().animate({top:"-150px"},300);
		$(".sw_chat_btn").stop().animate({top:"-230px"},300);
        $("sw_quick_btn>img").attr("src","img/main/btn_quick_over.png");
	}
});

$(function(){
	  var lastScroll = 0;
	  $(window).scroll(function(){
	    var st = $(this).scrollTop();
	    if (st > lastScroll){
	    	$(".sw_quick_btn_wrap").stop().animate({bottom:"-50px"},500);
	    	$(".sw_group_btn").stop().animate({top:"10px"},300);
			$(".sw_write_btn").stop().animate({top:"10px"},300);
			$(".sw_chat_btn").stop().animate({top:"10px"},300);
	    	
	    } else {
	    	$(".sw_quick_btn_wrap").stop().animate({bottom:"130px"},500);
	    	
	    }
	    lastScroll = st;
	  });
	});




$(".sw_quick_btn").on("mouseover", function(){
        $(this).children("img").attr("src","img/main/btn_quick_over.png");
});

$(".sw_quick_btn").on("mouseleave", function(){
    $(this).children("img").attr("src","img/main/btn_quick.png");
});

function chattingmodal(){
	var popUrl = "chat.do";	
	var popOption = "width=302, height=254, resizable=no, scrollbars=no, status=no;";
		window.open(popUrl,"",popOption);
//	$(".sw_chatting_wrap").load("chat.do", function(){
//		$(".chatting_wrap").draggable({handle: ".close_tab"});
//		
//		$(".close_tab>a").click(function(){
//			$(this).parent().parent().remove();
//			if($(".chatting_wrap").size()==0){
//				$("div.sw_chatting_wrap").empty();
//			}
//		});
//	});
}

$("#inputMessage").keypress(function(e){
	if(e.keyCode==13){
		send();
	}
});

function talentMatching(){
	$(".sw_modal_wrap").load("talent_modal.do", function(){
		$(".sw_modal_pane").draggable({handle: ".sw_modal_pane_navigate_bar"});
		
		$("div.sw_modal_bg").click(function(){
			$("div.sw_modal_wrap").empty();
		});
		
		$("div.sw_modal_pane_close_btn>a").click(function(){
			$(this).parent().parent().remove();
			if($(".sw_modal_pane").size()==0){
				$("div.sw_modal_wrap").empty();
			}
		});
	});
}

function appendProfile(email){
	if($("div.sw_modal_pane").size()==1){	
		var temp = document.createElement("div");
		$(temp).load("semiProfile_modal.do?email=" + email, function(){
			$(".sw_modal_wrap").append($(temp).html());
			$(".sw_modal_pane").draggable({handle: ".sw_modal_pane_navigate_bar"});
			
			$("div.sw_modal_pane_close_btn>a").click(function(){
				$(this).parent().parent().remove();
				if($(".sw_modal_pane").size()==0){
					$("div.sw_modal_wrap").empty();
				}
			});
		});
	}
	
	if($("div.sw_modal_pane").size()==2){	
		var temp = document.createElement("div");
		$(temp).load("semiProfile_modal.do?email=" + email, function(){
			$("div.sw_modal_pane").last().remove();
			$(".sw_modal_wrap").append($(temp).html());
			$(".sw_modal_pane").draggable({handle: ".sw_modal_pane_navigate_bar"});
			
			$("div.sw_modal_pane_close_btn>a").click(function(){
				$(this).parent().parent().remove();
				if($(".sw_modal_pane").size()==0){
					$("div.sw_modal_wrap").empty();
				}
			});
		});
	}
}


var mod_beforeX;
var mod_beforeY;
var mod_beforeMod;
var mod_move = false;

$(function(){
	$(document).on("mousedown", ".sw_modal_pane_navigate_bar", function(e){
		$(".sw_modal_pane").css("z-index", "110000");
		$(this).parent().css("z-index", "200000");
	});
});


/* footer legal btn */

$(".legal_link_btn_over").hide();

$(".sw_common_footer_list").on("mouseover", function(){
	$(".sw_common_footer").stop().animate({bottom:"0px"},300)
	$(".legal_link_btn_over").show();
})

$(".sw_common_footer_list").on("mouseleave", function(){
	$(".sw_common_footer").stop().animate({bottom:"-40px"},300)
	$(".legal_link_btn_over").hide();
});











