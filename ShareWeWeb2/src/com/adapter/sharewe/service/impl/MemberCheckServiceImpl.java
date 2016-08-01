package com.adapter.sharewe.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adapter.sharewe.dto.MemberInfoVO;
import com.adapter.sharewe.mapper.MemberMapper;
import com.adapter.sharewe.service.MemberCheckService;

@Repository
public class MemberCheckServiceImpl implements MemberCheckService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertMemberCheck(MemberInfoVO miVO) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.insertMember(miVO);
	}

	@Override
	public int validateMember(String email) {
		int result = 0;
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.validateMember(email);
		return result;
	}

}
