package com.adapter.sharewe.service;

import java.util.List;

import com.adapter.sharewe.dto.TMHashtagVO;
import com.adapter.sharewe.dto.TMinfoVO;

public interface TMHashtagService {
	public List<TMHashtagVO> selectTalentsMeByTextId(String textid);

	public List<TMHashtagVO> selectTalentsYouByTextId(String textid);

	public TMHashtagVO selectTalents(TMinfoVO tmiVo);

	public void deleteHashtags(String textid);
	
	public void insertWritingHashtag(TMinfoVO tInfo);
	
	public void insertWritingHashtags(TMHashtagVO vo);
	


	
//	public List<TMHashtagVO> selectIndexTalents();
}
