<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="update_form.do" method="post" class="sw_update_form" name="frm" id="frm">
	<fieldset>
		<legend class="sw_hidden_item">게시글 수정 폼</legend>
		<p class="sw_writing_name">
			<strong>재능매칭작성</strong> 재능매칭 폼 입니다 원하는 재능을 작성해주세요
		</p>
		<input type="hidden" value="${suinfo.textid}" name="textid">
		<div class="sw_writing_title_wrap">
			<input type="text"  class="sw_border_input" name="title" value="${suinfo.title}"/>
		</div>
		<div class="sw_float_wrap">
			<div class="sw_writing_sttalent_wrap">
				<input type="text" 
					class="sw_border_input" name="mytalent" value="${talent.mytalent }"/>
			</div>
			<div class="sw_writing_thtalent_wrap">
				<input type="text" 	class="sw_border_input" name="wishtalent"  value="${talent.wishtalent}"/>
			</div>
		</div>
		<div class="sw_writing_loc">
			<input type="text" class="sw_border_input" name="area" value="${suinfo.area}"/>
		</div>


		<div class="sw_writing_area">
			<textarea name="content">${suinfo.content}</textarea>
		</div>
		<div class="sw_writing_submit">
			<a href="javascript:submitForm();">DONE</a>
			<a href="javascript:resetForm();">다시작성</a>
		</div>
	</fieldset>
</form>
<%-- ${suinfo.textid} --%>