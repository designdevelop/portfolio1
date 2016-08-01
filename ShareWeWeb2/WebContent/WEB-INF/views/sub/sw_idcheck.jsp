<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이메일 중복확인</title>
</head>
<body>
<form action="idCheckForm.do" method="get" name="frm">
	아이디
	<input type="text" name="email" value="${email}"/>
	<input type="submit" value="중복체크"/>
		<c:if test="${member != null }">
			<script type="test/javascript">
				opener.document.join.email.value="";
			</script>
			${email}는 이미 사용중입니다.
		</c:if>
		<c:if test="${member == null}">
			${email}는 사용 가능한 아이디입니다.
			<input type="button" value="사용" class="cancel" onclick="idok('${email}')">
		</c:if>
</form>
<c:forEach var="js" items="${jsItems}">
<script src="${js }"></script>
</c:forEach>
</body>
</html>