package com.adapter.sharewe.service.impl;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adapter.sharewe.dto.TMinfoVO;
import com.adapter.sharewe.mapper.MemberMapper;
import com.adapter.sharewe.service.TMinfoService;

@Repository
public class TMinfoServiceImpl implements TMinfoService {
	
	
	@Autowired
	private SqlSession sqlSession;

	
	// 글 내용 불러오기
	@Override
	public TMinfoVO selectArticleByTextId(String textid) {
		TMinfoVO result = new TMinfoVO();
		MemberMapper membermapper =  sqlSession.getMapper(MemberMapper.class);
		result = membermapper.selectArticleByTextId(textid);
		
		return result;
	}

//시간
	@Override
	public TMinfoVO selectTminfoDate(String textid) {
		TMinfoVO result = new TMinfoVO();
		MemberMapper dateMepper = sqlSession.getMapper(MemberMapper.class);
		result = dateMepper.selectTminfoDate(textid);
		return result;
	}

	// 저장된 정보 불러오기
	@Override
	public TMinfoVO selectUpdate(TMinfoVO vo) {
		TMinfoVO result = new TMinfoVO();
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		result = membermapper.selectUpdate(vo);
		return result;
	}



// 글 지우기
	@Override
	public void deleteWriting(String textid) {
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		membermapper.deleteWriting(textid);
		
	}


	// 글저장
	@Override
	public void insertWriting(TMinfoVO tVo) {
		
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		membermapper.insertWriting(tVo);
		
	}
	
	@Override
	public TMinfoVO getNextSeq() {
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		TMinfoVO tiVO = membermapper.getNextSeq();
		return tiVO;
	}


	

	// 업데이트 저장
	@Override
	public void updateTMInfoVO(TMinfoVO tVo) {
		MemberMapper memnermapper = sqlSession.getMapper(MemberMapper.class);
		memnermapper.updateTMInfoVO(tVo);
		
	}

	//index화면 content
	@Override
	public List<TMinfoVO> selectAllList() {
		List<TMinfoVO> result = new ArrayList<>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.selectAllList();
		
		return result;
	}

	@Override
	public List<TMinfoVO> wishTalentSearch(String talent) {
		List<TMinfoVO> result = new ArrayList<>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.wishTalentSearch(talent);
		
		
		return result;
	}

	// 담아둔 재능 뿌리기
	@Override
	public List<TMinfoVO> getMyScrap(String email) {
		List<TMinfoVO> result = new ArrayList<>();
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		result = membermapper.getMyScrap(email);
		return result;
	}

	@Override
	public List<TMinfoVO> getMyOffer(String email) {
		List<TMinfoVO> result = new ArrayList<>();
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		result = membermapper.getMyOffer(email);
		return result;
	}

	@Override
	public void deleteScrap(String email) {
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		membermapper.deleteScrap(email);
	}

	@Override
	public List<TMinfoVO> getInfo(String email) {
		List<TMinfoVO> result = new ArrayList<>();
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		result = membermapper.getInfo(email);
		return result;
	}


}
