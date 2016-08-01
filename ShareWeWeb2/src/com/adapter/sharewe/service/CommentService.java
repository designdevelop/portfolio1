package com.adapter.sharewe.service;

import java.util.List;

import com.adapter.sharewe.dto.CommentVO;
import com.adapter.sharewe.dto.MessageVO;

public interface CommentService {


	public void insertComment(String textid, String email,String commnet_text);	
	public List<CommentVO> selectComment(String textid);	
	public void deleteComment(String comseq);
	public void updateComment(String comment_text, String comseq);
	

	// 제안한 재능 삭제 - Comments 삭제
	public void deleteComments(String textid);
	
	
}
