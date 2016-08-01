<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<script type="text/javascript">
function popupProfileOpen(){
	var popUrl = "profile_view.do?email=${article.email}";	
	var popOption = "width=400, height=540, resizable=no, scrollbars=no, status=no;";
		window.open(popUrl,"",popOption);
}
	
function popupHelpOpen(){
	var popUrl = "help.do";	
	var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;";
		window.open(popUrl,"",popOption);
}
	
function commentForm(){
	if(document.frm.sw_comment_text.value.length == 0){
		alert("댓글을 입력해주세요");
		frm.sw_comment_text.focus();
	}else{
		 document.frm.submit();
	}
}	

function delConfirm(cmtseq){
	if(!isModifying){
		if(confirm("해당 댓글을 삭제하시겠습니까?")){
			location.href = "hanjooldel.do?comseq=" + cmtseq + "&textid=${article.textid}";
		}
	}
}

function askCheck(){
	if(confirm("신청하시겠습니까?")){
		location.href="ask.do?receiver=${article.email}"
	}
}

function scrapCheck(){
	if(confirm("스크랩하시겠습니까?")){
		location.href="scrap.do?textid=${article.textid}"
	}
}

</script>
<div class="sw_content_page_wrap">
	<div class="sw_content_date">
		<span>${tmdate.tmdate}<a href = "javascript:popupProfileOpen();">${profileView.email} ${profileView.nickname}</a> </span>
	</div>
	<div class="sw_content_loca">
		<span></span>
	</div>
	<div class="sw_content_page_title">
		<span>${article.title}</span>
	</div>
	<div class="sw_content_pf_helf">
		<a href="javascript:popupProfileOpen();">프로필 보기</a> 
		<a href="javascript:popupHelpOpen()">도움말</a>
	</div>
	<div class="sw_content_post">
		<p>${article.content}</p><br>
		<p>
			<bold>갖고 있는 재능</bold>
		</p>
		<c:forEach var="me" items="${talentMe }">
			\#${me.talent }
		</c:forEach>
		<p>
			<bold>원하는 재능</bold>
		</p>
		<c:forEach var="you" items="${talentYou }">
			\#${you.talent }
		</c:forEach>
	</div>
	<p class="more_icon">
		<a href="#"> <img src="img/sub/icon_more.png"></a>
	</p>
	<div class="sw_content_scrapBtn">
	<c:if test="${!empty loginUser}">
		<c:choose>
			<c:when test="${loginUser.email == article.email}">
				<a href="update_form.do?textid=${article.textid}">수정하기</a> 
				<a href="delete.do?textid=${article.textid}" class="delet_btn">삭제하기</a>
		 	</c:when>
		 
			<c:otherwise>
					<a href="javascript:return false;" onclick="return scrapCheck()">담아두기</a> 
					<a href="javascript:return false;" onclick="return askCheck()">신청하기</a>	
			</c:otherwise>
		</c:choose>
	</c:if>
	</div>
	<div class="back_list">
		<a href="index.do">리스트로 이동</a>
	</div>
	<c:if test="${empty loginUser}">
		<div class="join_btn">
			<a href="intro.do">처음 오셨나요?</a>
		</div>
	</c:if>
</div>





<div class="sw_comment_wrap">
<%-- 	<c:if test="${!empty loginUser}"> --%>
		<form action ="commentWrite.do" method ="post" class="sw_comment_form" name="frm">
			<input type ="hidden" name="textid" value="${article.textid}">
			<div class="comment_text">
				<input type ="text" name="sw_comment_text" placeholder="댓글을 입력해 주세요">
			</div>
			<div class="comment_submit">
				<input type="button" onclick="javascript:commentForm();" value="send"/>
			</div>
		</form>
<%-- 	</c:if> --%>
	<c:forEach var="cv" items="${commentView}">
		
		<div class="comment_output">
			<div class="comment_output_img">
				<div></div>
			</div>
			<div class="comment_output_content">
				<span class="comment_output_writer">${cv.nickname}</span>
				<span class="textArea">${cv.comment_text}</span>
				<p class="comment_adjust_delete_btn">
					<c:choose>
						<c:when test="${loginUser.email == cv.email }">
							<a name="modBtn" num="${cv.comseq}" onclick="goModify(this)">수정하기</a>
							<a name="delBtn" num="${cv.comseq}" onclick="delConfirm(${cv.comseq})">삭제하기</a>
						</c:when>
					</c:choose>
				</p>
				<span class="comment_date">${cv.cmtdate}</span>
			</div>
		</div>
	</c:forEach>
</div>




<script type="text/javascript">
var before;
var isModifying = false;

function goModify(btn){
	if(!isModifying){
		isModifying = true;
		
		before = $(btn).parent().prev(".textArea").html();
		$(btn).parent().prev(".textArea").html("<input type='text' name='comment' value='" + before + "'>");
		$(btn).html("제출하기").attr("onclick", "submitModify(this)");
		$(btn).next("[name=delBtn]").html("취소하기").attr("onclick", "cancelModify(this)");
	}
}

function submitModify(btn){
	location.href = "commentUpdate.do?textid=${article.textid}&comseq=" + $(btn).attr("num") + "&comment=" + $(btn).parent().prev(".textArea").find("input").val();
	
	isModifying = false;
}

function cancelModify(btn){
	$(btn).parent().prev(".textArea").find("input").remove();
	$(btn).parent().prev(".textArea").html(before);
	$(btn).parent().find("[name=modBtn]").html("수정하기").attr("onclick", "goModify(this)");
	$(btn).html("삭제하기").attr("onclick", "delConfirm(" + $(btn).attr("num") + ")");
	
	isModifying = false;
}

$(".delet_btn").click(function(){
	if (confirm("삭제하시겠습니까?") == true) {
		document.scrapFrm.submit();
	}else{
		return false;
		
	}
});
</script>