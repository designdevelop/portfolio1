package com.adapter.sharewe.service;

import java.util.List;

import com.adapter.sharewe.dto.EvaluateVO;

public interface EvaluateService {
	public void insertHanjool1(EvaluateVO tVo);
	public void insertHanjool2(EvaluateVO tVo);
	public List<EvaluateVO> selectHanjool(String email);
	public void deleteHanjool(String evaluateid);
	public void updateHanjool(String content, String evaluateid);
	public List<EvaluateVO> getMyComment(String server);
	
	
}
