/**
 * 
 */


/* 파일업로드 */

$(".filebox").hide();
$(".profile_img_update").on("mouseover", function(){
	$(".filebox").stop().fadeIn(200);
	$(".profile_img_update img").stop().animate({"opacity":0.5},200);
});
$(".profile_img_update").on("mouseleave", function(){
	$(".filebox").stop().fadeOut(200);
	$(".profile_img_update img").stop().animate({"opacity":1},200);
});









/* ----------------------------------------------------- */


var firstAlerted = false;

/* tab_wrap */
$(function() {
	$(".tab_control>li").eq(0).children().addClass("selected");

	$("#tab_scrap_sw, #tab_offer_sw, #tab_massage, #tab_comment").hide();

	$(".tab_control>li>a").on("click", function() {
		$(".tab_contents>div").hide();

		path1 = $(this).attr("href");

		$(path1).show();
	});
	$(".tab_control>li").eq(0).children("a").css("color", "#85dac5");
	$(".tab_control>li>a").on(
			"click",
			function() {
				$(this).css("color", "#85dac5");

				$(this).parent("li").siblings("li").children("a").css("color",
						"#454545");
			});

	if(location.hash!=""){
		$("a[href=" + location.hash + "]").click();
	}
	
	$(".scrap_allchk").click(function() {
		if ($(".scrap_allchk").prop("checked")) {
			$(".scrap_chk").prop("checked", true);
		} else {
			$(".scrap_chk").prop("checked", false);
		}
	});
	
	$(".offer_allchk").click(function() {
		if ($(".offer_allchk").prop("checked")) {
			$(".offer_chk").prop("checked", true);
		} else {
			$(".offer_chk").prop("checked", false);
		}
	});
	
	$(".msg_allchk").click(function() {
		if ($(".msg_allchk").prop("checked")) {
			$(".msg_chk").prop("checked", true);
		} else {
			$(".msg_chk").prop("checked", false);
		}
	});
});
/* sw_mypage 체크박스 전체선택 */
$(function() {
	$(".button[name='modifybtn']").click(function() {
		alert("수정 되었습니다.");			
	});
});

/* sw_mypage 포커스했을때 한번만 창띄우기 */

$(".profile_substance input").focusin(function() {
	if (!firstAlerted) {
		alert("수정할 내용을 입력 후 [수정]버튼을 눌러주세요.");
		firstAlerted = true;
	}
});

/* sw_mypage 담아둔 재능 글쓴이 프로필 */

function popupProfileOpen(email) {
	var popUrl = "profile_view.do?email=" + email;
	var popOption = "width=400, height=540, resizable=no, scrollbars=no, status=no;";
	window.open(popUrl, "", popOption);
}

/* sw_myapge 회원탈퇴 */
function confirmWithdraw(email) {
	if (prompt("탈퇴 후에는 돌이킬 수 없습니다.?\n탈퇴를 원하시면 아래 텍스트를 따라서 써 주세요.\n(햇빛이 선명하게 나뭇잎을 핥고 있었다.)") == "햇빛이 선명하게 나뭇잎을 핥고 있었다.") {
		alert("또 찾아주세요.");
		location.href = 'memberdelete.do?email=' + email;
	} else {
		alert("회원 탈퇴 과정을 중단합니다.");
	}
}

function dealertScrap() {
	if ($("input[name='del']").is(":checked")) {
		if (confirm("삭제하시겠습니까?") == true) {
			document.scrapFrm.submit();
		}
	} else {
		alert("선택된 항목이 없습니다.");
	}
}

function dealertOffer() {
	if ($("input[name='del']").is(":checked")) {
		if (confirm("삭제하시겠습니까?") == true) {
			document.offerFrm.submit();
		}
	} else {
		alert("선택된 항목이 없습니다.");
	}
}

function dealertMessage() {
	if ($("input[name='del']").is(":checked")) {
		if (confirm("삭제하시겠습니까?") == true) {
			document.messageFrm.submit();
			return true;
		}
	} else {
		alert("선택된 항목이 없습니다.");
		return false;
	}
}

function popupMessageOpen() {
	var popUrl = "message.do";

	var popOption = "width=510, height=630, resizable=no, scrollbars=no, status=no;";
	window.open(popUrl, "쪽지보내기", popOption);

}

function openMessagePopup(mid) {
	var popUrl = "messageview.do?messageid=" + mid;

	var popOption = "width=510, height=595, resizable=no, scrollbars=no, status=no;";
	window.open(popUrl, "쪽지보기", popOption);
	location.reload(true);
}

function sendMessageOpen(mid) {
	var popUrl = "message.do?messageid=" + mid;

	var popOption = "width=510, height=630, resizable=no, scrollbars=no, status=no;";
	window.open(popUrl, "쪽지보내기", popOption);
	
}


function seMailPopup(email) {
	var popUrl = "semiMessage.do?email="+email;

	var popOption = "width=510, height=630, resizable=no, scrollbars=no, status=no;";
	window.open(popUrl, "쪽지보기", popOption);
	
}






var good = $(".good").html()+"%";

var bad = $(".bad").html()+"%";


$(function(){
	$(".good").parent("div").css({"width":good,"height":"16px","background-color":"#0F0"});
});


$(function(){
	$(".bad").parent("div").css({"width":bad,"height":"16px","background-color":"#f00"});
});











