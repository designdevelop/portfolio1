function commentForm(){
	if(document.frm.title.value.length == 0){
		alert("제목을 입력해주세요");
		frm.title.focus();
		return false;
	}else if(document.frm.content.value.length == 0){		
			alert("제목을 입력해주세요");
			frm.content.focus();
			return false;
	}
	return true;
	
}