function loginCheck(){
	if(document.login.email.value.length==0){
		alert("등록하신 이메일을 입력해주세요.");
		login.email.focus();
		return false;
	}
	if(document.login.pwd.value == ""){
		alert("암호는 반드시 입력해야 합니다.");
		login.pwd.focus();
		return false;
	}
	return true;
}