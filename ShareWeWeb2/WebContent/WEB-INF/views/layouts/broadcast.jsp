<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/sw_common.css" />
<div class="chatting_wrap">
	<div class="close_tab">
		메신저
	</div>
	<div id="messageWindow"></div>
	<div id="inputMessageWindow">
		<input class="send_input" id="inputMessage" type="text" size="28"
			placeholder="메세지를 입력하세요" /> <input class="send_btn" type="submit"
			value="send" onclick="send()" /> <input id="inputId" type="hidden"
			value="${loginUser.nickname }" />
	</div>
</div>
<script type="text/javascript">
	var chattingBox = document.getElementById("messageWindow");
	var webSocket = new WebSocket('ws://vii-84:8888/ShareWeWeb/broadcasting');
	//var webSocket = new WebSocket('ws://localhost:8888/ShareWeWeb/broadcasting');
	var inputMessage = document.getElementById('inputMessage');
	webSocket.onerror = function(event) {
		onError(event)
	};
	webSocket.onopen = function(event) {
		onOpen(event)
	};
	webSocket.onmessage = function(event) {
		onMessage(event)
	};
	var dddfd;
	function onMessage(event) {
		dddfd = event;

		$("#messageWindow").append(event.data);
		$("#messageWindow").scrollTop(99999999);
	}
	function onOpen(event) {
		$("#messageWindow").append("연결 성공" + "<br/>");
		$("#messageWindow").scrollTop(99999999);
	}
	function onError(event) {
		alert(event.data);
	}
	function send() {
		if($("#inputMessage").val().length==0){
			return false;
		}
		
		webSocket.send("<div class='receive_message_box'>" + "<div>"
				+ inputId.value + "</div>"
				+ "<span class='receive_message_innerbox'>"
				+ inputMessage.value + "</span>" + "</div>");
		/*  webSocket.send(inputMessage.value);  */
		$("#messageWindow").append(
				"<div class='send_message_box'>" + "<div>" + inputId.value
						+ "</div>" + "<span class='send_message_innerbox'>"
						+ inputMessage.value + "</span>" + "<div/>");
		$("#messageWindow").scrollTop(99999999);

		/* webSocket.send(inputMessage.value); */
		inputMessage.value = "";
	}
</script>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/sw_common.js"></script>
