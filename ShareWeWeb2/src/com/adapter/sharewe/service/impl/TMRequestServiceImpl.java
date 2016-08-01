package com.adapter.sharewe.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adapter.sharewe.dto.TMRequestVO;
import com.adapter.sharewe.mapper.MemberMapper;
import com.adapter.sharewe.service.TMRequestService;

@Repository
public class TMRequestServiceImpl implements TMRequestService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void scrapTMInfo(TMRequestVO rVo) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.scrapTMInfo(rVo);
	}

	@Override
	public void scrapTMDel(String textid) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.scrapTMDel(textid);
	}

	@Override
	public void deleteEachScrap(TMRequestVO trVo) {
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		membermapper.deleteEachScrap(trVo);
		
	}



}	
