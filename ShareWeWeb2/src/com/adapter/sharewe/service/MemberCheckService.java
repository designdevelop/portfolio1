package com.adapter.sharewe.service;

import com.adapter.sharewe.dto.MemberInfoVO;

public interface MemberCheckService {
	public void insertMemberCheck(MemberInfoVO miVO);
	public int validateMember(String email);
}
