<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${contentTitle }</title>
<c:forEach var="css" items="${cssItems}">
	<link rel="stylesheet" type="text/css" href="${css}" />
</c:forEach>
</head>
<body>
	<header id="sw_main_header">
	<h1 class="sw_main_logo">
		<a href="intro.do">쉐어위</a>
	</h1>
	</header>
	<section id="sw_content">
	<form action="join.do" method="post" class="sw_join_form" name="join">
		<fieldset>
			<legend class="sw_hidden_item">회원 정보 입력폼</legend>
			<p class="sw_join_name">
				<strong>회원가입</strong>
			</p>
			<div class="sw_join_account_wrap">
				<div class="sw_join_email line">
				<input type="text" name="email" value="${miVo.email }" id="join_email">
				</div>
				<div class="sw_join_password_wrap">
					<div class="sw_join_password1 line">
						<input type="password" name="pwd" value="${miVo.pwd }">
					</div>
					<div class="sw_join_password2 line">
						<input type="password" name="pwd_check" placeholder="비밀번호를 다시한번 입력하세요.">
					</div>
				</div>
				<div class="sw_join_hint_wrap">
					<div class="sw_join_hint_q line">
						<select name="pwdHintQue">
							<option value="0">비밀번호 분실시 되찾기 위한 힌트 질문을 선택해주세요.</option>
							<option value="1">애완동물 이름은?</option>
							<option value="2">1 + 1은?</option>
						</select>
					</div>
					<div class="sw_join_hint_a line">
						<input type="text" name="pwdHintAns" placeholder="비밀번호 힌트 질문의 정답을 적어주세요.">
					</div>
				</div>
			</div>
			<div class="sw_join_user_wrap">
				<div class="sw_join_nickname line">
					<input type="text" name="nickname" value="${miVo.nickname }">
				</div>
				<div class="sw_join_gender_wrap line">
					<div class="sw_join_gender_male_wrap inline">
						<label for="user_male">남성</label> <input type="radio"
							id="user_male" name="radio1" value="남성">
					</div>
					<div class="sw_join_gender_female_wrap inline">
						<label for="user_female">여성</label> <input type="radio"
							id="user_female" name="radio1" value="여성">
					</div>
				</div>
			</div>
			<div class="sw_join_address_wrap">
				<div class="line">
					<input type="text" name="area" placeholder="활동 지역을 입력하세요." />
				</div>
			
			</div>
			<div class="sw_join_contact_wrap">
				<div class="sw_join_cellular_wrap line">
					<select name="phone1" disabled class="inline">
						<option>010</option>
					</select> <input name="phone2" type="text" class="inline" placeholder="연락처를 입력해주세요.(- 제외)">
				</div>
				<div class="sw_join_kakao line">
					<input type="text" name="kakao" placeholder="카카오톡 아이디를 입력해주세요.">
				</div>
			</div>
			<div class="sw_join_career line">
				<select name="job">
					<option value="0">귀하의 직업과 가장 가까운 것을 선택해주세요.</option>
					<option value="학생">학생</option>
					<option value="직장인">직장인</option>
					<option value="자영업">자영업</option>
					<option value="예술가">예술가</option>
					<option value="프리랜서">프리랜서</option>
					<option value="무직">무직</option>
				</select>
				
			</div>
			<input type="submit" value="DONE" onclick="return joinFormCheck()" class="sW_join_submit_btn"  />
			
		</fieldset>
	</form>
		
	</section>
</body>
<c:forEach var="js" items="${jsItems}">
	<script src="${js }"></script>
</c:forEach>
</html>