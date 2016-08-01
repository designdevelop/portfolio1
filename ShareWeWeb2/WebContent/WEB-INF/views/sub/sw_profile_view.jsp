<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/sw_common.css" />
<c:forEach var="css" items="${cssItems}">
<link rel="stylesheet" type="text/css" href="${css}" />
</c:forEach>
<title>${contentTitle }</title>
<!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>										
    <script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js"></script>						
<![endif]-->
</head>
<script type="text/javascript">
function hanjoolForm(){
	if(document.frm.content.value.length == 0){
		alert("한줄평을 입력해주세요");
		frm.content.focus();
		return false;
	}	
	
	if(!frm.rate[0].checked && !frm.rate[1].checked){
		alert("엄지를 올리거나 내려주세요.");
		frm.rate[0].focus();
		return false;
	}
	
	document.frm.submit();
}

function delConfirm(cmtseq){
	if(!isModifying){
		if(confirm("해당 댓글을 삭제하시겠습니까?")){
			location.href = "hanjooldel.do?evaluateid=" + cmtseq + "&email=${profile.email}";
		}
	}
}

var eee;
var fff;
var ggg;
var before;
var isModifying = false;

function goModify(btn){
	if(!isModifying){
		
		
		isModifying = true;
		
		before = $(btn).parent().prev(".textArea").html();
		alert(before);
		$(btn).parent().prev(".textArea").html("<input type='text' name='content' value='" + before + "'>");
		
		$(btn).html("제출하기").attr("onclick", "submitModify(this)");
		$(btn).next("[name=delBtn]").html("취소하기").attr("onclick", "cancelModify(this)");
	}
}

function submitModify(btn){
	
	
	location.href = "hanjoolUpdate.do?email=${profile.email}&evaluateid=" + $(btn).attr("num") + "&content=" + $(btn).parent().prev(".textArea").find("input").val();
	
	isModifying = false;
}

function cancelModify(btn){
	
	$(btn).parent().prev("input").remove();
	$(btn).parent().prev(".textArea").html(before);
	$(btn).parent().find("[name=modBtn]").html("수정하기").attr("onclick", "goModify(this)");
	$(btn).html("삭제하기").attr("onclick", "delConfirm(" + $(btn).parent().find("[name=delBtn]").attr("num") + ")");
	
	isModifying = false;
}


function sendMessage(){
	document.frmm.submit();
	alert("메시지를 전송했습니다");
	
}

</script>
<body>
<div class="popup_wrap">
	<div class="popup_top">
		<!-- <p class="popup_image"><img src="img/hehe.jpg"></p> -->
		<p class="popup_image">		
		<c:choose>
			<c:when test="${profile.picture eq null}">
				<img style="width: 100%; height: inherit;" src="img/No Image.jpg">
			</c:when>
			<c:otherwise>
 				<img src="img/member/${profile.picture }" style="width: 100%;    height: inherit;">
			</c:otherwise>
		</c:choose>
		 </p>
		<p class="mypage_popup_title"><span class="mypage_popup_user">${profile.nickname }</span></p>
		<ul class="popup_tab_control">
			<li><a href="#popup_tab1">프로필</a></li>
			<li><a href="#popup_tab2">쪽지</a></li>
			<li><a href="#popup_tab3">한줄평</a></li>
		</ul>
	</div>
	<div class="mypage_popup_tab_wrap">
		<div id="popup_tab1">
			<span class="mypage_Stitle">email</span><p>${profile.email }</p>
			<span class="mypage_Stitle">활동지역</span><p>${profile.address }</p>
			<span class="mypage_Stitle">카카오톡</span><p>${profile.kakao }</p>
			<span class="mypage_Stitle">직업</span><p>${profile.job }</p>
		</div>
		<div id="popup_tab2">
			<form:form modelAttribute="semiMessage" action="semiMessage.do" method="post" name="frmm">
			<input type="hidden" name="sender" value="${loginUser.email }">
			<input type="hidden" name="receiver" value="${profile.email }">
			<div class="popup_tab2_title">
				<input type="text" name="title" placeholder="제목을 적어 주세요."></input>
			</div>
					
		<textarea name="content" placeholder="내용을 적어 주세요."></textarea>
				<a onclick="javascript:sendMessage()">보내기</a>
			</form:form>
		</div>
		<div id="popup_tab3">
			<form:form modelAttribute="han" action ="hanjool.do" method ="post" class="sw_hanjool_form" name="frm" onsubmit="return false;">
				<input type ="hidden" name="targetemail" value="${profile.email }">
				<div class="popup_tab3_comment">
					<input type ="text" name="content" placeholder="한줄평을 입력해 주세요">
					<div class="hanjool_thumb_wrap">
						<label class="hanjool_thumb_up"><input type ="radio" name="rate" value = "N" style = "display: none;" checked=""></label>
						<label class="hanjool_thumb_down"><input type ="radio" name="rate" value = "Y" style = "display: none;" checked="checked"></label>
					</div>
					<a onclick="javascript:hanjoolForm();">한줄평달기</a>
				</div>
				<div class="popup_tab3_cmt_view">
					<c:forEach var="cv" items="${han}">
						<div class="hanjool_output">
							<div class="hanjool_output_img">
								<img src="img/${cv.thumbimg }">
							</div>
							<div class="hanjool_output_content">
								<span class="comment_output_writer">${cv.voteremail}</span>
								<span class="textArea">${cv.content}</span>
								<p class="comment_adjust_delete_btn">
									<c:choose>
										<c:when test="${loginUser.email == cv.voteremail }">
											<a name="modBtn" num="${cv.evaluateid}" onclick="goModify(this)">수정하기</a>
											<a name="delBtn" num="${cv.evaluateid}" onclick="delConfirm(${cv.evaluateid})">삭제하기</a>
										</c:when>
									</c:choose>
								</p>
							</div>
						</div>
					</c:forEach>			
				</div>
			</form:form>
		</div>
	</div>
</div>
<c:forEach var="js" items="${jsItems}">
<script src="${js }"></script>
</c:forEach>
</body>
</html>