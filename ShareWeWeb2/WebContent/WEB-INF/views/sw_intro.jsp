<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${contentTitle }</title>
<c:forEach var="css" items="${cssItems}">
	<link rel="stylesheet" type="text/css" href="${css}" />
</c:forEach>
</head>
<!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js"></script>
<![endif]-->
<body>
	
	<div class="sw_intro_text_wrap">
		<div class="sw_intro_text_inner_wrap">
			<div class="sw_intro_text_center text_center1">
				<img src="img/intro/sw_intro_text2.png"/>
			</div>
			<div class="sw_intro_text_center text_center2">
				<img src="img/intro/sw_intro_text.png"/>
			</div>
			<ul class="sw_intro_text_controller">
				<li>
					<a href="#">다음</a>
				</li>
				<li>
					<a href="#">이전</a>
				</li>
			</ul>
		</div>
	</div>
	
	<!-- header -->
	<header>
	<h2 class="sw_intro_top_logo">
		<a href="intro.do">쉐어위</a>
	</h2>
	<form action="index.do" method="get" class="sw_seach_bar">
		<div class="sw_seach_bar_wrap">
			<input type="text" name="talent" placeholder="찾고있는 재능을 검색하세요" width="475px" />
			<input type="image" alt="search_icon" src="img/intro/sw_search_icon2.png" >
		</div>
	</form>
	<div class="return_login_join">
		<a href="#">회원가입</a>
		<a href="#">로그인</a>
	</div>
	</header>

	<!-- section -->
	<section>
	<h1 class="sw_sharewe_logo">
		<a href="intro.do">쉐어위</a>
	</h1>
	<form:form modelAttribute="mInfo" action="join.do" method="post" name="join" id="sw_intro_join_form" >
		<fieldset>
			<legend class="sw_hidden_item">로그인폼</legend>
			<div>
				<a class="sw_intro_join">시작하기</a>
				<div class="sw_intro_join_sub">
					<div class="sw_intro_join1">
						<div class="form_wrap">
							<input type="text" name="email" placeholder="이메일" id="join_email" />
							<input type="hidden" name="reid" />
							<input type="button" id="sw_intro_id_check" value="중복체크" onclick="idCheckForm()"/>
						</div>
						<div class="form_wrap">
							<input type="password" name = "pwd" placeholder="비밀번호" />
						</div>
						<div class="form_wrap">
							<input type="password" name="pwd_check" placeholder="비밀번호를 다시한번 입력하세요.">
						</div>
					</div>
					
					<div class="sw_intro_join2">
						<div class="form_wrap">
							<input type="text" name="nickname" placeholder="닉네임" />
						</div>
						<div class="form_wrap sw_join_gender_female_wrap sw_join_gender_female_wrap_common">
							<label for="user_male">남성</label>
							<input type="radio" id="user_male" name="gender" value="남성">	
						</div>
						<div class="form_wrap sw_join_gender_male_wrap sw_join_gender_female_wrap_common">
							<label for="user_female">여성</label>
							<input type="radio" id="user_female" name="gender" value="여성" checked="checked">
						</div>
					</div>
					
					<div class="sw_intro_join3">
						<div class="form_wrap">
							<input type="text" name="address" placeholder="활동지역" />
						</div>
						<div class="form_wrap">
							<input name="phone" type="text" placeholder="연락처를 입력해주세요.(- 제외)"/>
						</div>
						<div class="form_wrap sw_join_career">
							<select name="job">
								<option value="0">귀하의 직업을 선택해주세요.</option>
								<option value="학생">학생</option>
								<option value="직장인">직장인</option>
								<option value="자영업">자영업</option>
								<option value="예술가">예술가</option>
								<option value="프리랜서">프리랜서</option>
								<option value="무직">무직</option>
							</select>
						</div>
					</div>
					
					
					
					<div class="sw_intro_submit_wrap">
						<div class="form_wrap_button1">
							<input type="button" value="다음" onclick="return false;"/>
						</div>
						<div class="form_wrap_button2">
							<input type="button" value="다음" onclick="return false;"/>
						</div>
						<div class="form_wrap_submit">
							<input type="button" value="가입" onclick="return joinCheck3()"/>
						</div>
					</div>
					
					
				</div>
			</div>
			</fieldset>
			</form:form>
	<form:form modelAttribute="mInfo" action="login.do" method="post" name="login"  id="sw_intro_login_form">
	<fieldset>
			<div>
				<a class="sw_intro_login">로그인</a>
				<div class="sw_intro_login_sub">
					<div class="form_wrap">
						<input type="text" placeholder="이메일"  name="email" />
					</div>
					<div class="form_wrap">
						<input type="password" placeholder="비밀번호" name="pwd" />
					</div>
					<div class="form_wrap_submit_login">
						<input type="submit" value="로그인" onclick="return loginCheck()"/>
					</div>
				</div>
			</div>
		</fieldset>
	</form:form>
	</section>
	<footer class="sw_intro_footer">
		<a href="#">
			Share We?
		</a>
		<a href="#">
			Return Intro
		</a>
	</footer>

</body>
<c:forEach var="js" items="${jsItems}">
	<script src="${js }"></script>
</c:forEach>
<c:if test="${loginNoUser == true }">
<script type="text/javascript">
	alert("존재하지 않는 회원입니다.");
</script>
<c:set scope="session" var="loginNoUser" value="${false }"/>
<c:set scope="session" var="loginWrongPwd" value="${false }"/>
</c:if>
<c:if test="${loginWrongPwd == true }">
<script type="text/javascript">
	alert("비밀번호가 맞지 않습니다.");
</script>
<c:set scope="session" var="loginWrongPwd" value="${false }"/>
</c:if>
<c:if test="${emailDuplicated == true }">
<script type="text/javascript">
	alert("이미 가입되어 있는 이메일입니다.");
</script>
<c:set scope="session" var="emailDuplicated" value="${false }"/>
</c:if>
</html>