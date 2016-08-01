package com.adapter.sharewe.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adapter.sharewe.dto.GraphBarVO;
import com.adapter.sharewe.mapper.MemberMapper;
import com.adapter.sharewe.service.GraphBarService;

@Repository
public class GraphBarServiceImpl implements GraphBarService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public GraphBarVO graphBar(String email) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		return memberMapper.graphBar(email);
	}

}
