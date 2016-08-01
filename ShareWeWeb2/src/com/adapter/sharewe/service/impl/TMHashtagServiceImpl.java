package com.adapter.sharewe.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adapter.sharewe.dto.TMHashtagVO;
import com.adapter.sharewe.dto.TMinfoVO;
import com.adapter.sharewe.mapper.MemberMapper;
import com.adapter.sharewe.service.TMHashtagService;


@Repository
public class TMHashtagServiceImpl implements TMHashtagService {

	@Autowired
	private SqlSession sqlSession;
	
	
	// ME �ؽ��±� �ҷ�����
	@Override
	public List<TMHashtagVO> selectTalentsMeByTextId(String textid) {
		List<TMHashtagVO> result = new ArrayList<TMHashtagVO>();
		MemberMapper viewmapper = sqlSession.getMapper(MemberMapper.class);
		result = viewmapper.selectTalentsMeByTextId(textid);
				return result;
	}

	//YOU �ؽ��±� �ҷ�����
	@Override
	public List<TMHashtagVO> selectTalentsYouByTextId(String textid) {
		List<TMHashtagVO> result = new ArrayList<>();
		MemberMapper viewmapper = sqlSession.getMapper(MemberMapper.class);
		result = viewmapper.selectTalentsYouByTextId(textid);
		return result;
	}

	// �ؽ��±� ����
	@Override
	public void deleteHashtags(String textid) {
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		membermapper.deleteHashtags(textid);
		
	}



	//������ �ؽ��±� �ҷ�����
	@Override
	public TMHashtagVO selectTalents(TMinfoVO vo) {
		TMHashtagVO result = null;
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		result = membermapper.selectTalents(vo);
		return result;
	}

	//�ؽ��±� ����
	@Override
	public void insertWritingHashtag(TMinfoVO tInfo) {
		StringTokenizer mytalent = new StringTokenizer(tInfo.getMytalent(), ",");
		StringTokenizer wishtalent = new StringTokenizer(tInfo.getWishtalent(),",");
		
		while(mytalent.hasMoreTokens()){
			TMHashtagVO vo = new TMHashtagVO();
			vo.setTextid(tInfo.getTextid());
			vo.setHelper("me");
			vo.setTalent(mytalent.nextToken().replaceAll("#", "").trim());
			
			insertWritingHashtags(vo);
			
		}
		
		while(wishtalent.hasMoreTokens()){
			TMHashtagVO vo = new TMHashtagVO();
			vo.setTextid(tInfo.getTextid());
			vo.setHelper("you");
			vo.setTalent(wishtalent.nextToken().replaceAll("#", "").trim());
			
			insertWritingHashtags(vo);
	 } 		
		
	}

	@Override
	public void insertWritingHashtags(TMHashtagVO vo) {
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		membermapper.insertWritingHashtags(vo);
	}


/*	@Override
	public List<TMHashtagVO> selectIndexTalents() {
		List<TMHashtagVO> result = new ArrayList<>();
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		result = membermapper.selectIndexTalents();
		return result;
	}*/

}
