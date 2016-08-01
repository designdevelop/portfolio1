package com.adapter.sharewe.service;

import java.util.List;

import com.adapter.sharewe.dto.MessageVO;

public interface MessageService {
	public int sendMessage(MessageVO mVo);
	public List<MessageVO> selectreceiver(String receiver);
	public MessageVO selectView(String messageid);
	public void setMessageChecked(String messageid);
	public void deleteMessage(String messageid);
	public int selectChecked(String email);
}
