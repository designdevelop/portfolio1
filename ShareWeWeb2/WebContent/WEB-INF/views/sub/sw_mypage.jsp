<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%-- 
<%@ page import="com.adaptor.sharewe.dto.*"  %>
 --%>
<div class="tab_pro_wrap">
	<ul class="tab_control">
		<li><a href="#tab_profile">프로필</a></li>
		<li><a href="#tab_scrap_sw">담아둔 재능</a></li>
		<li><a href="#tab_offer_sw">제안한 재능</a></li>
		<li><a href="#tab_massage">쪽지</a></li>
		<li><a href="#tab_comment">한줄평</a></li>
	</ul>
	<div class="tab_contents">
		<div id="tab_profile">
			<form:form modelAttribute="mInfo" action="mypage_update.do" method="post" enctype="multipart/form-data">
				<div>
					<div class="profile_top_wrap">
					<div class="profile_top">
						<div class="profile_img">
							<c:choose>
								<c:when test="${myInfo.picture eq null}">
									<img style="width: 100%; height: 100%;" src="img/No Image.jpg">
								</c:when>
								<c:otherwise>
									<input type="hidden" name="noimage" value="${myInfo.picture}">
									<img style="width: 100%; height: 100%;"
										src="img/member/${myInfo.picture}">
								</c:otherwise>
							</c:choose>
						</div>
						<div class="profile_evaluation">
							<input class="profile_nickname" type="text" disabled="disabled" name="nickname" value="${myInfo.nickname}" />
							<p>
								유저 평가
							</p>
							<p>
								<span>좋아요 : ${Gbar.up}</span>
								<span>싫어요 : ${Gbar.down}</span>
							</p>
						</div>
					</div>
					</div>
					<div class="profile_bottom">
						<div class="profile_img_update">
							<c:choose>
								<c:when test="${myInfo.picture eq null}">
								<img style="width: 100%; height: 100%;" src="img/No Image.jpg">
								</c:when>
								<c:otherwise>
							    <input type="hidden" name="noimage" value="${myInfo.picture}">
								<img style="width: 100%; height: 100%;" src="img/member/${myInfo.picture}">
								</c:otherwise>
							</c:choose>
							<div class="filebox">
								<label for="ex_file">업로드</label>
								<input type="file" name="picture" id="ex_file">
							</div>
							
						</div>
						<div class="profile_substance">
							<p>
								<span class="profile_title pro_email">이메일 : </span>
								<input class="profile" type="hidden" name="email" value="${loginUser.email}">${loginUser.email}
							</p>
							<p>
								<span class="profile_title pro_loc">활동지역 : </span>
								<input class="profile" type="text" name="address" value="${myInfo.address}" />
							</p>
							<p>
								<span class="profile_title pro_kakao">닉네임 : </span>
								<input class="profile" type="text" name="nickname" value="${myInfo.nickname}" />
							</p>
							<p>
								<span class="profile_title pro_job">직업 : </span>
								<input class="profile" type="text" name="job" value="${myInfo.job}" />
							</p>
						</div>
					</div>
				</div>
				<div class="btn">
					<input type="submit" class="button" name="modifybtn" value="수정">&nbsp;
					<input type="button" class="button" value="탈퇴"
						onclick="confirmWithdraw('${loginUser.email}');">
				</div>
			</form:form>
		</div>
		<div id="tab_scrap_sw">
			<form:form modelAttribute="deleteScrap" action="deleteScrap.do" name="scrapFrm" method="post">
				<table class="mypage_table">
					<thead>
						<tr>
							<th><input type="checkbox" class="scrap_allchk"
								title="전체 선택/해제"></th>
							<th>번호</th>
							<th>제목</th>
							<th>글쓴이</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="scrap" items="${scrapProfile}" varStatus="status">
							<tr>
								<td><input type="checkbox" name="del" class="scrap_chk"
									value="${scrap.textid }"></td>
								<td>${status.count}</td>
								<td><a class="a_link"
									href="writeView.do?textid=${scrap.textid}">${scrap.title}</a></td>
								<td><a class="a_link"
									href="javascript:popupProfileOpen('${scrap.email}');">${scrap.email}</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
				<div class="btn">
					<input type="button" class="button" value="삭제하기"
						onclick="dealertScrap();" />
				</div>
			</form:form>
		</div>
		<div id="tab_offer_sw">
			<form:form modelAttribute="deleteOffer" action="deleteOffer.do" name="offerFrm" method="post">
				<table class="mypage_table">
					<thead>
						<tr>
							<th><input type="checkbox" class="offer_allchk"
								title="전체 선택/해제"></th>
							<th>번호</th>
							<th>제목</th>
							<th>글쓴이</th>
						</tr>
					<thead>
					<tbody>
						<c:forEach var="offer" items="${offerProfile}" varStatus="status">
							<tr>
								<td><input type="checkbox" class="offer_chk"
									value="${offer.textid }" name="del"></td>
								<td>${status.count}</td>
								<td><a class="a_link"
									href="writeView.do?textid=${offer.textid}">${offer.title}</a>
								</td>
								<td>${userProfile.nickname}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
				<div class="btn">
					<input type="button" class="button" value="삭제하기"
						onclick="dealertOffer();">
				</div>
			</form:form>
		</div>
		<div id="tab_massage">
			<form:form modelAttribute="deleteMessage"  action="deletemessage.do" method="post" name="messageFrm">
				<table class="mypage_table">
					<thead>
						<tr>
							<th><input type="checkbox" class="msg_allchk"
								title="전체 선택/해제"></th>
							<th>보낸사람</th>
							<th>제목</th>
							<th>날짜</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="msg" items="${messages}" varStatus="status">
							<c:choose>
								<c:when test="${msg.checked=='Y' }">
									<tr>
										<td><input type="checkbox" class="msg_chk" name="del"
											value="${msg.messageid}"></td>
										<td><a onclick="sendMessageOpen('${msg.messageid}')">${msg.sender}</a></td>
										<!-- 보낸사람 -->
										<td><a onclick="openMessagePopup('${msg.messageid}')">${msg.title}</a></td>
										<!--내용  -->
										<td>${msg.tfdate}</td>
										<!--날짜  -->
									</tr>
								</c:when>
								<c:otherwise>
									<tr>
										<td><input type="checkbox" class="msg_chk" name="del"
											value="${msg.messageid}"></td>
										<td><b><a
												onclick="sendMessageOpen('${msg.messageid}')">${msg.sender}</a></b></td>
										<!-- 보낸사람 -->
										<td><b><a
												onclick="openMessagePopup('${msg.messageid}')">${msg.title}</a></b></td>
										<!--내용  -->
										<td><b>${msg.tfdate}</b></td>
										<!--날짜  -->
									</tr>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tbody>
				</table>
				<br>
				<div class="btn">
					<input type="button" class="button" value="쪽지보내기"
						onclick="popupMessageOpen()">&nbsp; <input type="submit"
						class="button" value="삭제하기" onclick="return dealertMessage()">
				</div>
			</form:form>
		</div>
		<div id="tab_comment">
			<table class="mypage_table">
				<thead>
					<tr>
						<th>글쓴이</th>
						<th>한줄평</th>
						<th>추천</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="comment" items="${comment}"
						varStatus="status">
						<c:choose>
							<c:when test="${comment.flag=='U'}">
								<tr>
									<td width="30%">${comment.voteremail}</td>
									<td>${comment.content}</td>
									<td><img src="img/up.png" width="20px" height="20px"
										title="추천"></td>
								</tr>
							</c:when>
							<c:when test="${comment.flag=='D'}">
								<tr style="background: ff5b5b">
									<td width="30%">${comment.voteremail}</td>
									<td>${comment.content}</td>
									<td><img src="img/down.png" width="20px" height="20px"
										title="비추천"></td>
								</tr>
							</c:when>
						</c:choose>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>