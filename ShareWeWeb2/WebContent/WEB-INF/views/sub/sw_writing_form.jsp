<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="write.do" method="post" class="sw_writing_form" name="frm">
	<fieldset>
		<legend class="sw_hidden_item">게시글 작성 폼</legend>
		<p class="sw_writing_name">
			<strong>재능매칭작성</strong> 재능매칭 폼 입니다 원하는 재능을 작성해주세요
		</p>
		<div class ="sw_writing_title_wrap">
			<input type="text" placeholder="게시글 제목" class="sw_border_input" name="title" maxlength="20"/>
		</div>
		<div class="sw_float_wrap">
			<div class="sw_writing_sttalent_wrap">
				<input type="text" placeholder="당신의 재능을 #태그로 입력하세요" 
					class="sw_border_input" name="mytalent" maxlength="20"/>
			</div>
			<div class="sw_writing_thtalent_wrap">
				<input type="text" placeholder="원하는 재능을 #태그로 입력하세요"  
					class="sw_border_input" name="wishtalent"  maxlength="20"/>
			</div>
		</div>
		<div class="sw_writing_loc">
			<input type="text" placeholder="활동 지역" class="sw_border_input" name="area"  maxlength="20"/>
		</div>

		<div class="sw_writing_area">
			<textarea
				placeholder="내용(어느정도 레벨을 가르쳐 줄 수 있는지 그리고 배우고 싶은 이유도 작성해보세요.)"
				name="content" ></textarea>
		</div>
		<div class="sw_writing_submit">
			<a href="javascript:submitForm();">DONE</a>
		</div>
	</fieldset>
</form>
