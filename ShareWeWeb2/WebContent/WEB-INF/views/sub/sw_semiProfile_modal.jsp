<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%-- 
<%@ page import="com.adaptor.sharewe.dto.*"  %>
 --%>
<div class="sw_modal_pane">
	<div class="sw_modal_pane_navigate_bar"></div>
	<div class="sw_modal_pane_close_btn">
		<a>X</a>
	</div>
	<div class="sw_talent_user_info userinfo">
		<div class="sw_talent_info_head">
			<span class="name">${member.nickname }</span>님의 프로필
		</div>
		<ul class="sw_talent_info_body">
			<!-- <li class="career">
				<h1>경력</h1>
				<div>
					<ul>
						<li>껌팔이</li>
						<li>날치기</li>
					</ul>
				</div>
			</li> -->
			<li class="rate">
				<h1>평가</h1>
				<c:choose>
					<c:when test="${Gbar.cnt!=0 }">
						<div class="graph_bar" onclick="popupProfileOpen('${member.email}#popup_tab3')" style="cursor: pointer;">
							<c:if test="${Gbar.up!=0 }">
								<div>
									<span class="good"><fmt:formatNumber value="${(Gbar.up/Gbar.cnt)*100}" pattern="0.0#"/></span>
									<span>%</span>
								</div>
							</c:if>
							<c:if test="${Gbar.down!=0 }">
								<div>
									<span style="float: right;">%</span>
									<span style="float: right;" class="bad"><fmt:formatNumber value="${(Gbar.down/Gbar.cnt)*100}" pattern="0.0#"/></span>
								</div>
							</c:if>
						</div>
					</c:when>
					<c:otherwise>
						아직 평가받지 않은 회원입니다.
					</c:otherwise>
				</c:choose>
			</li>
			<li class="region">
				<h1>지역</h1>
				<div>
					<span>${member.address }</span>
				</div>
			</li>
			<li class="content">
				<h1>작성한 글 목록</h1>
				<div>
					<ul>
						<li>
							<div class="he">
								<c:forEach items="${infoList}" var="my">
									<a href='viewProposal.do?textid=${my.textId }'> <span>${my.title }</span>
									</a>
								</c:forEach>
							</div>
						</li>
					</ul>
				</div>
			<li class="message">
			
			
				<div class="he">
					<c:forEach items="${infoList}" var="my">
						<a href="javascript:seMailPopup('${member.email }')"><span>쪽지보내기</span> </a>
					</c:forEach>
				</div>
			</li>

		</ul>
	</div>

</div>

<script type="text/javascript" src="js/sw_mypage.js"></script>