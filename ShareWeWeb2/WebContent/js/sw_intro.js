$(".sw_intro_text_center").hide();
$(".sw_intro_text_controller>li:last-child").hide();
$(".sw_intro_footer>a:last-child").hide();
$(".return_login_join").hide();

$(".return_login_join>a:first-child").on("click", function(){
	$(".return_login_join").hide();
	$(".sw_intro_join_sub").css({"display":"block"});
	$(".sw_intro_login_sub").css({"display":"none"});
	$(".sw_intro_text_wrap").stop().animate({top:"100%"},500);
	$(".sw_sharewe_logo").stop().fadeIn(1000);
	$("#sw_intro_join_form").stop().fadeIn(1000);
	$("#sw_intro_login_form").stop().fadeIn(1000);
	$(".text_center2").stop().fadeOut(1500);
	
	$(".sw_intro_footer>a:last-child").hide();
	$(".sw_intro_footer>a:first-child").show();
});

$(".return_login_join>a:last-child").on("click", function(){
	$(".return_login_join").hide();
	$(".sw_intro_login_sub").css({"display":"block"});
	$(".sw_intro_join_sub").css({"display":"none"});
	$(".sw_intro_text_wrap").stop().animate({top:"100%"},500);
	$(".sw_sharewe_logo").stop().fadeIn(1000);
	$("#sw_intro_join_form").stop().fadeIn(1000);
	$("#sw_intro_login_form").stop().fadeIn(1000);
	$(".text_center2").stop().fadeOut(1500);

	$(".sw_intro_footer>a:last-child").hide();
	$(".sw_intro_footer>a:first-child").show();
});



$(".sw_intro_footer>a:first-child").on("click", function(){
	$(".sw_intro_text_center").hide();
	$(".return_login_join").show();
	$(".sw_intro_footer>a:last-child").show();
	$(".sw_intro_footer>a:first-child").hide();
	
	$(".sw_intro_text_wrap").stop().animate({top:"0px"},500);
	$(".sw_sharewe_logo").stop().fadeOut(1000);
	$("#sw_intro_join_form").stop().fadeOut(1000);
	$("#sw_intro_login_form").stop().fadeOut(1000);
	$(".text_center2").stop().fadeIn(1500);
});

$(".sw_intro_footer>a:last-child").on("click", function(){
	$(".sw_intro_text_controller>li:last-child").hide();
	$(".sw_intro_text_controller>li:first-child").show();
	$(".sw_intro_text_center").hide();
	$(".return_login_join").hide();
	$(".sw_intro_footer>a:last-child").hide();
	$(".sw_intro_footer>a:first-child").show();
	
	$(".sw_intro_text_wrap").stop().animate({top:"100%"},500);
	$(".sw_sharewe_logo").stop().fadeIn(1000);
	$("#sw_intro_join_form").stop().fadeIn(1000);
	$("#sw_intro_login_form").stop().fadeIn(1000);
	$(".text_center2").stop().fadeOut(1500);
});


$(".sw_intro_text_controller>li:first-child>a").on("click", function(){
	$(".text_center2").stop().fadeOut(500);
	$(".text_center1").stop().fadeIn(500);
	$(".sw_intro_text_controller>li:first-child").hide();
	$(".sw_intro_text_controller>li:last-child").show();
	
});
$(".sw_intro_text_controller>li:last-child>a").on("click", function(){
	$(".text_center1").stop().fadeOut(500);
	$(".text_center2").stop().fadeIn(500);
	$(".sw_intro_text_controller>li:first-child").show();
	$(".sw_intro_text_controller>li:last-child").hide();
	
});



$(".sw_intro_join_sub, .sw_intro_login_sub, .sw_intro_join2, .sw_intro_join3, .form_wrap_submit, .form_wrap_button2").hide();


$(".sw_intro_join").on("click", function(){
    $(".sw_intro_join_sub").stop().slideDown(300);
    $(".sw_intro_login_sub").hide();
});

$(".sw_intro_login").on("click", function(){
    
    $(".sw_intro_join_sub").stop().slideUp(300);
    $(".sw_intro_login_sub").stop().delay(300).slideDown(300);
});

function idCheckForm(){
	if(document.join.email.value == ""){
		alert("아이디를 입력하여 주십시오");
		document.join.email.focus();
		return;
	}
	var url = "idCheckForm.do?email=" + document.join.email.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no," +
			" scrollbars=yes, resizable=no, width=450, height=200");
}



$(function(){
		$(".sw_join_gender_female_wrap_common>input").change(function() {
			$(".sw_join_gender_female_wrap_common>input").parent().find("label").css({"background-color":"#fff","color":"#777"});
			$(".sw_join_gender_female_wrap_common>input:checked").parent().find("label").css({"background-color":"#85dac5","color":"#fff"});
		});
        $("#user_female").click();
        $("#user_female").change();
        
});

function idok(){
	opener.document.join.email.value=document.frm.email.value;
	opener.document.join.reid.value=document.frm.email.value;
	self.close();
}



function joinCheck(){
	if(document.join.email.value.length==0){
		alert("이메일을 적어주세요.");
		join.email.focus();
		return false;
	}
	var email = $("#join_email").val(); 
	var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
	if(re.test(email)== false){
		alert("이메일 형식이 아닙니다.");
		join.email.focus();
		return false;
	}
	if(document.join.pwd.value.length==0){
		alert("비밀번호를 적어주세요.");
		join.pwd.focus();
		return false;
	}
	if(document.join.pwd.value.length<7){
		alert("암호는 10글자 이상이어야 합니다.");
		join.email.focus();
		return false;
	}
	if(document.join.pwd.value != document.join.pwd_check.value){
		alert("암호가 일치하지 않습니다.");
		join.pwd_check.focus();
		return false;
	}
	if(document.join.reid.value.length == 0){
		alert("중복체크되지 않았습니다.");
		join.email.focus();
		return false;
	}
	
	return true;
		
}



function joinCheck2(){
	if(document.join.nickname.value.length==0){
		alert("사용할 닉네임을 적어주세요.");
		join.nickname.focus();
		return false;
	}
	
	return true;
}	



function joinCheck3(obj){
	if(document.join.address.value.length==0){
		alert("활동 지역을 적으십시요.");
		join.address.focus();
		return false;
	}
	if(document.join.phone.value.length<11 || document.join.phone.value.length>11){
		alert("전화번호를 제대로 입력해주세요.");
		join.phone.focus();
		return false;
	}
	if(isNaN(document.join.phone.value)){
		alert("숫자를 입력해야 합니다.");
		join.phone.focus();
		return false;
	}
	
	if($(document.join.job.selectedOptions).val()=="0"){
		alert("직업을 선택해 주세요.");
		join.job.focus();
		return false;
	}
	
	alert("이메일주소인증을 위해 전송된 이메일을 7일 이내에 확인하여 주십시오.\n(인증 생략시 7일 후 계정 삭제)");
	join.submit();
	
}

$(".form_wrap_button1").on("click", function(){
	if(joinCheck()){
		$(".form_wrap_button1").hide();
		$(".form_wrap_button2").show();
		$(".sw_intro_join1").stop().slideUp(300);
		$(".sw_intro_join2").stop().slideDown(300);
	}
})

$(".form_wrap_button2").on("click", function(){
	if(joinCheck2()){
		$(".form_wrap_button2").hide();
		$(".form_wrap_submit").show();
		$(".sw_intro_join2").stop().slideUp(300);;
		$(".sw_intro_join3").stop().slideDown(300);
	}
})


