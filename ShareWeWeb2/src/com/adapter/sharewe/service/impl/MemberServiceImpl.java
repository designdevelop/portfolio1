package com.adapter.sharewe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adapter.sharewe.dto.CommentVO;
import com.adapter.sharewe.dto.MemberInfoVO;
import com.adapter.sharewe.dto.MessageVO;
import com.adapter.sharewe.dto.TMRequestVO;
import com.adapter.sharewe.dto.TMinfoVO;
import com.adapter.sharewe.mapper.MemberMapper;
import com.adapter.sharewe.service.MemberService;

@Repository
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<MemberInfoVO> getAllMembers() {
		List<MemberInfoVO> result = new ArrayList<MemberInfoVO>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.getAllMembers();
		return result;
	}

	@Override
	public MemberInfoVO profileMembers(String email) {
		MemberInfoVO profile = new MemberInfoVO();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		profile = memberMapper.profileMembers(email);
		return profile;
	}

	
	@Override
	public MemberInfoVO getMember(String email) {
		
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		return memberMapper.getMember(email);

	}
	
	
	@Override
	public void insertMember(MemberInfoVO member) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.insertMember(member);
		memberMapper.insertMemberCheck(member);
	}
	
	@Override
	public MemberInfoVO confirmId(MemberInfoVO member) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		return memberMapper.confirmId(member);
		
	}

	@Override
	public void loginCheck(MemberInfoVO member) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.loginCheck(member);
		
	}

	@Override
	public MemberInfoVO login(MemberInfoVO mInfo) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		return memberMapper.login(mInfo);
	}

	@Override
	public MemberInfoVO getMyInfo(MemberInfoVO mInfo) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		return memberMapper.getMyInfo(mInfo);
	}

	@Override
	public int updateMyInfo(MemberInfoVO mInfo) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		return memberMapper.updateMyInfo(mInfo);
	}
	
	//��Ī
	@Override
	public List<MemberInfoVO> selectTeacher(String email) {
		List<MemberInfoVO> result = new ArrayList<MemberInfoVO>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.selectTeacher(email);
		return result;
	}

	@Override
	public List<MemberInfoVO> selectStudent(String email) {
		List<MemberInfoVO> result = new ArrayList<MemberInfoVO>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.selectStudent(email);
		return result;
	}

	@Override
	public List<MemberInfoVO> selectWinwin(String talent) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		return memberMapper.selectWinwin(talent);
	}
	
	@Override
	public void scrapTMInfo(TMRequestVO rVo) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.scrap(rVo);
		
	}

	@Override
	public void sendMessage(MessageVO mVo) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.ask(mVo);
		
	}

	@Override
	public String selectpicture(String email) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		System.out.println("selectpicture���� ��µǴ� picture" + memberMapper.selectpicture(email));
		String picture = memberMapper.selectpicture(email); 
		return picture;
	}
}
