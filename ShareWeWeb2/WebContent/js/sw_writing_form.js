$(function(){
	$(".sw_border_input").add(".sw_writing_area>textarea").focusin(function(){
		$(this).parent("div").css("border","1px solid #85dac5");
	});
	
	$(".sw_border_input").add(".sw_writing_area>textarea").focusout(function(){
		$(this).parent("div").css("border","1px solid #ccc");
	});
});

function submitForm(){
	// 빈칸체크
	
	if(document.frm.title.value.length == 0){
		alert("제목을 입력해주세요");
		frm.title.focus();
		
	}else if(document.frm.mytalent.value.length == 0){
		alert("당신의 재능을 입력해주세요");
		frm.mytalent.focus();
	
	}else if(document.frm.wishtalent.value.length == 0){
		alert("원하는 재능을 입력해주세요");
		frm.wishtalent.focus();
	
	}else if(document.frm.area.value == 0){
		alert("활동지역을 입력해주세요");
		frm.area.focus();
	}else if(document.frm.content.value == 0){
		alert("내용을 입력해주세요");
		frm.content.focus();
	}else
	
	 document.frm.submit();
	
};

function resetForm(){
	document.frm.reset();
};
