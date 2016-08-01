<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="sw_modal_bg"></div>
<div class="sw_modal_pane">
	<div class="sw_modal_pane_navigate_bar"></div><div class="sw_modal_pane_close_btn"><a>X</a></div>
	<div class="sw_talent you">
		<h1>나에게 도움을 줄 수 있는 사람</h1>
		<ul class="sw_talent_scroll">
			<c:forEach items="${teacher }" var="my">
				<li>
					<div>
						<a onclick="appendProfile('${my.email }')">
							<c:choose>
								<c:when test="${my.picture eq null}">
									<img alt="썸네일" src="img/he.png" width="50" height="50"> 
								</c:when>
								<c:otherwise>
									<img src="img/member/${my.picture }" width="50" height="50">
								</c:otherwise>
							</c:choose> 
						</a>
					</div>
					<div>
						<a onclick="appendProfile('${my.email }')">
							<span>${my.nickname }</span>
							<span>${my.email }</span>
						</a>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div class="sw_talent me">
		<h1>내가 도움을 줄 수 있는 사람</h1>
		<ul class="sw_talent_scroll">
			<c:forEach items="${student }" var="my">
				<li>
					<div>
						<a onclick="appendProfile('${my.email }')">
							<c:choose>
								<c:when test="${my.picture eq null }">
									<img alt="썸네일" src="img/he.png" width="50" height="50"> 
								</c:when>
								<c:otherwise>
									<img src="img/member/${my.picture }" width="50" height="50">
								</c:otherwise>
							</c:choose> 
						</a>
					</div>
					<div>
						<a onclick="appendProfile('${my.email }')">
							<span>${my.nickname }</span>
							<span>${my.email }</span>
						</a>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div class="sw_talent ww">
		<h1>나와 WIN-WIN 관계인 사람</h1>
		<ul class="sw_talent_scroll">
			<c:forEach items="${winwin }" var="ww">
				<li>
					<div>
						<a onclick="appendProfile('${ww.email }')">
							<c:choose>
								<c:when test="${ww.picture eq null}">
									<img alt="썸네일" src="img/he.png" width="50" height="50"> 
								</c:when>
								<c:otherwise>
									<img src="img/member/${ww.picture }" width="50" height="50">
								</c:otherwise>
							</c:choose> 
						</a>
					</div>
					<div>
						<a onclick="appendProfile('${ww.email }')">
							<span>${ww.nickname }</span>
							<span>${ww.email }</span>
						</a>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>