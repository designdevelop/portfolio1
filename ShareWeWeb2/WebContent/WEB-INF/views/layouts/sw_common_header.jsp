<%@page import="com.adapter.sharewe.service.impl.MessageServiceImpl"%>
<%@page import="com.adapter.sharewe.dto.MemberInfoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${!empty loginUser}">
<header id="sw_main_header">
    <h1 class="sw_main_logo"><a href="index.do">쉐어위</a></h1>
    <form action="index.do" method="get" class="sw_main_seach_bar">
        <div class="sw_main_seach_bar_wrap">
            <input type="text" name="talent" placeholder="쉐어위 검색" width="475px"/>
            <input type="image" alt="search_icon" src="img/intro/sw_search_icon2.png">
        </div>
    </form>
    <ul class="sw_user_info">
    	 <li class="sw_user_notice">
            <a href="mypage.do#tab_massage"><img src="img/main/notice.png"/></a>
   	 		<c:if test="${notice_blink }">
	            <p><img src="img/main/notice_icon.png"></p>
   	 		</c:if>
        </li>
        <li class="sw_user_home">
            <a href="mypage.do"><img src="img/main/mypage_icon.png"/></a>
            <ul class="sw_user_hone_btn_menu">
        		<li><a href="javascript:return false;" onclick="return logoutCheck()">logout</a></li>
        		<li><a href="mypage.do">mypage</a></li>
        	</ul>
        </li>   
       	<li class="sw_user_name_info">
            <a href="mypage.do">${loginUser.nickname }<span> 님</span></a>
        </li>
    </ul>
</header>
</c:if>

<c:if test="${empty loginUser}">
<header id="sw_main_header">
    <h1 class="sw_main_logo"><a href="intro.do">쉐어위</a></h1>
    <form action="index.do" method="get" class="sw_main_seach_bar">
        <div class="sw_main_seach_bar_wrap">
            <input type="text" name="talent" placeholder="쉐어위 검색" width="475px"/>
            <input type="image" alt="search_icon" src="img/intro/sw_search_icon2.png">
        </div>
    </form>
</header>
</c:if>