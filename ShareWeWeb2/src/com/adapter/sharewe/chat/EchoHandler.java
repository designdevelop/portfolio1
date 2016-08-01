package com.adapter.sharewe.chat;

import java.util.ArrayList;
import java.util.List;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
 
import com.adapter.sharewe.chat.ChattingVO;
public class EchoHandler extends TextWebSocketHandler {
     
    private Logger logger = LoggerFactory.getLogger(EchoHandler.class);
 
    /**
     * ������ ������ ����ڵ��� �����ϴ� ����Ʈ.
     */
    private List<WebSocketSession> connectedUsers;
     
    public EchoHandler() {
        connectedUsers = new ArrayList<WebSocketSession> ();
    }
 
    /**
     * ���Ӱ� ���õǾ� �ִ� Event Method
     * 
     * @param WebSocketSession ������ �����
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
         
        // ������ ������ ����ڸ� ������
        if ( connectedUsers.size() > 4) {
            session.close();
            return;
        }
         
        logger.info(session.getId() + "���� �����߽��ϴ�.");
        logger.info("���� IP : " + session.getRemoteAddress().getHostName() );
        connectedUsers.add(session);
    }
 
    /**
     * �� ���� �̺�Ʈ�� ó����.
     * 1. Send : client -> server�� �޽����� ����
     * 2. Emit : server -> all client�� �޽����� ����
     * 
     * @param WebSocketSession �޽����� ���� Ŭ���̾�Ʈ
     * @param TextMessage �޽����� ����
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // convertMessage�� MessageVO�� �޼ҵ�
        // �Ķ���ͷ� �Ѿ�� JSON Ÿ���� �����͸� �ڹ� ��ü�� �־��ִ� ��Ȱ�� �Ѵ�.
    	ChattingVO messageVO = ChattingVO.convertMessage(message.getPayload());
        String hostName = "";
         
        for (WebSocketSession webSocketSession : connectedUsers) {
            if ( messageVO.getType().equals("all")) {
                if ( !session.getId().equals(webSocketSession.getId()) ) {
                    webSocketSession.sendMessage( new TextMessage(session.getRemoteAddress().getHostName()  
                        + " -> " + messageVO.getMessage()) );
                }
            }
            // �ӼӸ� ����
            else {
                hostName = webSocketSession.getRemoteAddress().getHostName();
                if ( messageVO.getTo().equals(hostName) ) {
                    webSocketSession.sendMessage( new TextMessage(
                        "<span style='color:red;'>"
                        + session.getRemoteAddress().getHostName()  
                        + " -> " + messageVO.getMessage()
                        + "</span>") );
                    break;
                }
            }
        }
    }
     
    /**
     * Ŭ���̾�Ʈ�� ������ ������ ����.
     * 
     * @param WebSocketSession ������ ���� Ŭ���̾�Ʈ
     * @param CloseStatus ���� ���� (Ȯ�� �ʿ���..)
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        connectedUsers.remove(session);
        for (WebSocketSession webSocketSession : connectedUsers) {
            if ( !session.getId().equals(webSocketSession.getId()) ) {
                webSocketSession.sendMessage( 
                    new TextMessage(webSocketSession.getRemoteAddress().getHostName()
                     + "�����߽��ϴ�.") );
            }
        }
        logger.info(session.getId() + "���� �����߽��ϴ�.");
    }
}