package com.adapter.sharewe.service;

import java.util.List;

import com.adapter.sharewe.dto.TMinfoVO;

public interface TMinfoService {
	public TMinfoVO selectArticleByTextId(String textid);
	public TMinfoVO selectTminfoDate(String textid);
	public TMinfoVO selectUpdate(TMinfoVO tminfoVo);
	public void updateTMInfoVO(TMinfoVO tVo);
	public void deleteWriting(String textid);
	public void insertWriting(TMinfoVO tVo);
	public List<TMinfoVO> selectAllList();
	public TMinfoVO getNextSeq();
	public List<TMinfoVO> wishTalentSearch(String talent);
	public List<TMinfoVO> getMyScrap(String email);
	public List<TMinfoVO> getMyOffer(String email);
	public void deleteScrap(String email);
	public List<TMinfoVO> getInfo(String textid);	
}
