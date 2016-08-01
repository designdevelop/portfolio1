<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인증 결과</title>
</head>
<body>
	<c:choose>
		<c:when test="${mailValidateSuccess==true}">
			성공적으로 인증되었습니다.
		</c:when>
		<c:otherwise>
			인증 실패하였습니다. 다시 시도하여 주십시오.
		</c:otherwise>
	</c:choose>
</body>
</html>