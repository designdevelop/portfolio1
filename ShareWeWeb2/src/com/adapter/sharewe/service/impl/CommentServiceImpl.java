package com.adapter.sharewe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adapter.sharewe.dto.CommentVO;
import com.adapter.sharewe.mapper.MemberMapper;
import com.adapter.sharewe.service.CommentService;

@Repository
public class CommentServiceImpl implements CommentService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertComment(String textid, String email, String comment_text) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.insertComment(textid, email, comment_text);
	}

	@Override
	public List<CommentVO> selectComment(String textid) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		List<CommentVO> result = new ArrayList<CommentVO>();
		result = memberMapper.selectComment(textid);
		return result;
	}
	
	
	@Override
	public void deleteComment(String comseq) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.deleteComment(comseq);
	}

	@Override
	public void updateComment(String comment_text, String comseq) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.updateComment(comment_text, comseq);
	}
	
	// 제안한 재능 삭제 - Comments 삭제
	@Override
	public void deleteComments(String textid) {
		MemberMapper membermapper = sqlSession.getMapper(MemberMapper.class);
		membermapper.deleteComments(textid);
	}

}
