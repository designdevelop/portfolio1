package com.adapter.sharewe.mapper;

import java.util.List;

import com.adapter.sharewe.dto.CommentVO;
import com.adapter.sharewe.dto.EvaluateVO;
import com.adapter.sharewe.dto.GraphBarVO;
import com.adapter.sharewe.dto.MemberInfoVO;
import com.adapter.sharewe.dto.MessageVO;
import com.adapter.sharewe.dto.TMHashtagVO;
import com.adapter.sharewe.dto.TMRequestVO;
import com.adapter.sharewe.dto.TMinfoVO;


public interface MemberMapper {
	public List<MemberInfoVO> getAllMembers();
	public MemberInfoVO getMember(String email);
	public void insertMember(MemberInfoVO member);
	public MemberInfoVO profileMembers(String email);	
	public String selectpicture(String email);
	
	
	public int sendMessage(MessageVO mVo);
	public List<MessageVO> selectreceiver(String receiver);
	public MessageVO selectView(String messageid);
	public void setMessageChecked(String messageid);
	public void deleteMessage(String messageid);
	public int selectChecked(String email);	
	
	
	
	
	
	
	public MemberInfoVO confirmId(MemberInfoVO member);
	public int loginCheck(MemberInfoVO member);
	public MemberInfoVO login(MemberInfoVO mInfo);
	
	
	public void insertHanjool1(EvaluateVO tVo);
	public void insertHanjool2(EvaluateVO tVo);
	public List<EvaluateVO> selectHanjool(String email);
	public void deleteHanjool(String evaluateid);
	public void updateHanjool(String content, String evaluateid);
	public List<EvaluateVO> getMyComment(String server);
	

	public void insertComment(String textid, String email,String commnet_text);	
	public List<CommentVO> selectComment(String textid);	
	public void deleteComment(String comseq);
	public void updateComment(String comment_text, String comseq);
	

	// 제안한 재능 삭제 - Comments 삭제
	public void deleteComments(String textid);

	// tminfo
	public TMinfoVO selectArticleByTextId(String textid);
	public TMinfoVO selectTminfoDate(String textid);
	public TMinfoVO selectUpdate(TMinfoVO vo);
	public void updateTMInfoVO(TMinfoVO tVo);
	public void deleteWriting(String textid);
	public void insertWriting(TMinfoVO tVo);
	public List<TMinfoVO> selectAllList();
	public TMinfoVO getNextSeq();
	public List<TMinfoVO> wishTalentSearch(String talent);
	public List<TMinfoVO> getMyScrap(String email);
	public List<TMinfoVO> getMyOffer(String email);
	public void deleteScrap(String email); 
	
		//tmshachtag
	public List<TMHashtagVO> selectTalentsMeByTextId(String textid);
	public List<TMHashtagVO> selectTalentsYouByTextId(String textid);
	public TMHashtagVO selectTalents(TMinfoVO vo);
	//public List<TMHashtagVO> selectIndexTalents();
	public void insertWritingHashtag(TMinfoVO tInfo);
	public void insertWritingHashtags(TMHashtagVO vo);

	
	public void deleteHashtags(String textid);
	public void insertWritingHashtag(TMHashtagVO hVo);

	//membercheck
	public void insertMemberCheck(MemberInfoVO miVO);
	public int validateMember(String email);

	//TMrequest
	public void scrapTMInfo(TMRequestVO rVo);
	public void scrapTMDel(String textid);
	public MemberInfoVO getMyInfo(MemberInfoVO mInfo);
	public int updateMyInfo(MemberInfoVO mInfo);
	public void deleteEachScrap(TMRequestVO trVo);
	
	
	
	//매칭
	public List<MemberInfoVO> selectTeacher(String email);
	public List<MemberInfoVO> selectStudent(String email);
	public List<MemberInfoVO> selectWinwin(String email);
	public GraphBarVO graphBar(String email);
	public List<TMinfoVO> getInfo(String email);
	
	
	
	
	
	
	//성혁
	public void scrap(TMRequestVO rVo);
	public void ask(MessageVO mVo);
	
}
