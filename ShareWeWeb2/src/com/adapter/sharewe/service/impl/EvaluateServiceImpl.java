package com.adapter.sharewe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adapter.sharewe.dto.EvaluateVO;
import com.adapter.sharewe.mapper.MemberMapper;
import com.adapter.sharewe.service.EvaluateService;


@Repository
public class EvaluateServiceImpl implements EvaluateService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertHanjool1(EvaluateVO tVo) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.insertHanjool1(tVo);
	}

	@Override
	public void insertHanjool2(EvaluateVO tVo) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.insertHanjool2(tVo);
	}

	@Override
	public List<EvaluateVO> selectHanjool(String email) {
		List<EvaluateVO> result = new ArrayList<EvaluateVO>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.selectHanjool(email);
		return result;
	}

	@Override
	public void deleteHanjool(String evaluateid) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.deleteHanjool(evaluateid);
	}

	@Override
	public void updateHanjool(String content, String evaluateid) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.updateHanjool(content, evaluateid);
	}

	@Override
	public List<EvaluateVO> getMyComment(String server) {
		List<EvaluateVO> result = new ArrayList<EvaluateVO>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.getMyComment(server);
		return result;
	}

}
