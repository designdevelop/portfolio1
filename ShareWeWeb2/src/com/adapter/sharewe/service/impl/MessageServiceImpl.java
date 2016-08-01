package com.adapter.sharewe.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adapter.sharewe.dto.MessageVO;
import com.adapter.sharewe.mapper.MemberMapper;
import com.adapter.sharewe.service.MessageService;

@Repository
public class MessageServiceImpl implements MessageService {
	
	
	@Autowired
	private SqlSession sqlSession;

	
	@Override
	public int sendMessage(MessageVO mVo) {
		int result = 0;
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.sendMessage(mVo);
		return result;
	}

	@Override
	public List<MessageVO> selectreceiver(String receiver) {
		List<MessageVO> result = new ArrayList<MessageVO>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.selectreceiver(receiver);
		return result;
	}

	@Override
	public MessageVO selectView(String messageid) {
		MessageVO result = new MessageVO();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.selectView(messageid);
		return result;
	}

	@Override
	public void setMessageChecked(String messageid) {
	
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.setMessageChecked(messageid);
		

	}

	@Override
	public void deleteMessage(String messageid) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.deleteMessage(messageid);
	}

	@Override
	public int selectChecked(String email) {
		int result = 0;
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.selectChecked(email);
		
		return result;
	}

}
