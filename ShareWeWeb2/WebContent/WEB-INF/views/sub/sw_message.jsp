<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<script type="text/javascript" src="js/sw_messagecheck.js"></script>

<body>
<form:form modelAttribute="messageForm" action="message.do" method="post" class="message_form" name="frm" >
		
	<div class="top_wrap">
		<h2 class="message_title">Message</h2>
		<p class="message_subtitle">재능 나눔을 하고싶은 상대에게 쪽지를 보내보세요</p>
	</div>
	<p class="message_text">보낸사람</p>
	<div class="message_wrap">
		<input type="hidden" name="sender" value="${loginUser.email }">${loginUser.email }
	</div>
	<p class="message_text">받는사람</p>
		<c:choose>
			<c:when test="${empty answer.sender}">
				<div class="message_wrap"><input type="text" name="receiver"></div>
			</c:when>
			<c:otherwise>
				<div class="message_wrap"><input type="hidden" name="receiver" value="${answer.sender }">${answer.sender }</div>
			</c:otherwise>
		</c:choose>
	<p class="message_text">제목</p>
	<div class="message_wrap">
		<input type="text" name="title">
	</div>
	<p class="message_text">내용</p>
	<div class="message_textarea">
		<textarea name="content"></textarea>
	</div>
	<div class="message_btn_wrap">
		<input class="message_btn" type="button" value="닫기" onclick="window.close();">
		<input class="message_btn" type="submit" value="전송" onclick="return commentForm();">
	</div>
</form:form>
</body>
</html>