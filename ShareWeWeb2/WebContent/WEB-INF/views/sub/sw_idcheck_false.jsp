<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원관리</title>
</head>
<body>
<h2>이메일 중복확인</h2>
${email}
이미 사용중입니다.
<%-- <form action="idCheck.do" method="get" name="frm">
	이메일<input type="text" name="email">
		<input type="submit" value="중복체크">
		<br>
		<c:if test="${result == 1 }">
			<script type="test/javascript">
				opener.document.frm.email.value="";
			</script>
			${email}는 이미 사용중입니다.
		</c:if>
		<c:if test="${result == -1}">
			${email}는 사용 가능한 아이디입니다.
			<input type="button" value="사용" class="cancel" onclick="">
		</c:if>
</form> --%>
</body>
</html>