<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
${msgFromSubmit }
<%-- 
	<table border="1">
			<tr>
			<th colspan="2">받은 쪽지</th>
		</tr>
		<tr>
			<th>보낸사람</th>
			<td>${viewmessage.sender }</td>
		</tr>
		<tr>
			<th>받은사람</th>
			<td>${viewmessage.receiver }</td>
		</tr>
		<tr>
		<td>제목</td>
		<td>${viewmessage.title }</td>
		<tr>
			<td colspan="2">내용</td>
		</tr>
		<tr>
			<td colspan="2"><div style="width: 470px; height: 100px;">${viewmessage.content }</div></td>
		</tr>
		<tr align="center" >
		 <td colspan="2"><input type="button" value="닫기" onclick="window.close();">
		</tr>
	</table> --%>

	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/sw_common.css" />
<link rel="stylesheet" type="text/css" href="css/sw_message_form.css" />

<title>${contentTitle }</title>
<!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>										
    <script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js"></script>						
<![endif]-->
</head>
<body>
<form:form modelAttribute="messageView" action="message.do" method="post" class="message_form">
		
	<div class="top_wrap">
		<h2 class="message_title">Message</h2>
		<p class="message_subtitle">재능 나눔을 하고싶은 상대에게 쪽지를 보내보세요</p>
	</div>
	<p class="message_text">보낸사람</p>
	<div class="message_wrap">
		<input type="hidden" name="sender" value="${loginUser.email }" readonly="readonly">${viewmessage.sender }
	</div>
	<p class="message_text">받는사람</p>
		
				<div class="message_wrap"><input type="text" value="${viewmessage.receiver }" readonly="readonly"></div>
			
	<p class="message_text">제목</p>
	<div class="message_wrap">
		<input type="text" name="title" value="${viewmessage.title }" readonly="readonly">
	</div>
	<p class="message_text">내용</p>
	<div class="message_textarea">
		<textarea name="content" readonly="readonly">${viewmessage.content }</textarea>
	</div>
	
</form:form>

</body>
</html>