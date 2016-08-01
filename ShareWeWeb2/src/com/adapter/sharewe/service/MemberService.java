package com.adapter.sharewe.service;

import java.util.List;

import com.adapter.sharewe.dto.MemberInfoVO;
import com.adapter.sharewe.dto.MessageVO;
import com.adapter.sharewe.dto.TMRequestVO;
import com.adapter.sharewe.dto.TMinfoVO;


public interface MemberService {
	public List<MemberInfoVO> getAllMembers();	
	public MemberInfoVO profileMembers(String email);	
	public MemberInfoVO getMember(String email);
	public void insertMember(MemberInfoVO member);
	public MemberInfoVO confirmId(MemberInfoVO member);
	public void loginCheck(MemberInfoVO member);
	public MemberInfoVO login(MemberInfoVO mInfo);
	public MemberInfoVO getMyInfo(MemberInfoVO mInfo);
	public int updateMyInfo(MemberInfoVO mInfo);
	public String selectpicture(String email);
	
	//¸ÅÄª
	public List<MemberInfoVO> selectTeacher(String email);
	public List<MemberInfoVO> selectStudent(String email);
	public List<MemberInfoVO> selectWinwin(String talent);
	public void scrapTMInfo(TMRequestVO rVo);
	public void sendMessage(MessageVO mVo);
}
