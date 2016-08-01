<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/sw_common.css" />
<c:forEach var="css" items="${cssItems}">
<link rel="stylesheet" type="text/css" href="${css}" />
</c:forEach>
<title>${contentTitle }</title>
<!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>										
    <script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js"></script>						
<![endif]-->
</head>
<body>
<div class="sw_modal_wrap"></div>
<div class="sw_chatting_wrap"></div>
<tiles:insertAttribute name="header" />
<section id="sw_content">
<tiles:insertAttribute name="main" />
</section>
<tiles:insertAttribute name="footer" />
<c:if test="${!empty loginUser}">
<tiles:insertAttribute name="quick" />
</c:if>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/sw_common.js"></script>
<c:forEach var="js" items="${jsItems}">
<script src="${js }"></script>
</c:forEach>
</body>
</html>