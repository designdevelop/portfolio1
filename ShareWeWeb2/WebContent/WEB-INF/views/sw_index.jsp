<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<ul class="sw_dan">
		<li><a href="#" class="dan2"><img src="img/main/2dan.png"></a></li>
		<li><a href="#" class="dan3"><img src="img/main/3dan.png"></a></li>
</ul>
<div class="sw_content_area">
	<ul class="sw_main_articles">
		<c:forEach var="article" items="${articleList}">
		<li>
			<h1 class="article_title"><a href="writeView.do?textid=${article.textid}&email=${article.email}">${article.title}</a></h1>
			<p>
				<span class="user_me">ME</span>
				<span class="user_talent">
					<a href="#">${article.mytalent}</a>
				</span>
				<span class="user_you">YOU</span>
				<span class="user_talent">
					<a href="#">${article.wishtalent}</a>
				</span>
			</p> 
			<span class="user_title">
				<a href="writeView.do?textid=${article.textid}">${article.content}</a>
			</span>
			<span class="user_location">
				${article.area}
			</span>
			<span></span>
		</li>
		</c:forEach>
		<c:if test="${fn:length(articleList)==0}">
			<div class="no_search_item">
				<span>검색 결과가 없습니다</span>.<br>
				<span>다른 검색어로 시도해보세요</span> <br>
				<span><a href="index.do">전체 검색 결과 보기</a></span>
			</div>
		</c:if>
	</ul>
</div>
<div class="sw_quick_content">
	<c:if test="${empty loginUser }">
	<div class="sw_quick_join">
		<p>
			<img src="img/main/quick1_join.png">
		</p>
		<p>지금 가입하여 당신의</p>
		<p>재능을 공유하세요</p>
		<a href="intro.do">JOIN</a>
	</div>
	</c:if>
	<div class="sw_main_quick1">
		<div class="sw_main_quick1_slider">
			<a href="#"> <img src="img/main/slidebanner1.gif" alt="bannerimg" />
			</a> <a href="#"> <img src="img/main/slidebanner2.gif"
				alt="bannerimg" />
			</a>
		</div>
		<div class="sw_main_quick1_control">
			<span class="btn_prev"><a href="#">left</a></span> <span
				class="btn_next"><a href="#">right</a></span>
		</div>
		<div class="sw_main_quick1_control2">
			<span class="btn_stop"><a href="#">stop</a></span> <span
				class="btn_play"><a href="#">play</a></span>
		</div>
	</div>
	<div class="tab_wrap">
		<ul class="tab_control">
			<li><a href="#tab_notice">공지사항</a></li>
			<li><a href="#tab_newsletter">뉴스레터</a></li>
			<li><a href="#tab_survey">설문조사</a></li>
		</ul>
		<div class="tab_contents">
			<ul id="tab_notice">
				<li><a href="#">[알림] 쉐어위가 오픈되..<span>16.04.10</span></a></li>
				<li><a href="#">[알림] 쉐어위의 시스템..<span>16.04.10</span></a></li>
				<li><a href="#">[알림] 헤헷 공지임 ㅎ..<span>16.04.10</span></a></li>
				<li><a href="#">[알림] 쓸게 없당 ㅎㅎ..<span>16.04.10</span></a></li>
			</ul>
			<ul id="tab_newsletter">
				<li><a href="#">쉐어위 뉴스레터 4호</a><span>16.04.10</span></li>
				<li><a href="#">쉐어위 뉴스레터 3호</a><span>16.04.10</span></li>
				<li><a href="#">쉐어위 뉴스레터 2호</a><span>16.04.10</span></li>
				<li><a href="#">쉐어위 뉴스레터 1호</a><span>16.04.10</span></li>
			</ul>
			<ul id="tab_survey">
				<li>등록된 설문조사가 없습니당 데헷!</li>
			</ul>
		</div>
	</div>
</div>