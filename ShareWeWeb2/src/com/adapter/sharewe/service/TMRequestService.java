package com.adapter.sharewe.service;

import com.adapter.sharewe.dto.TMRequestVO;

public interface TMRequestService {
	public void scrapTMInfo(TMRequestVO rVo);
	public void scrapTMDel(String textid);
	public void deleteEachScrap(TMRequestVO trVo);
	

		

}
