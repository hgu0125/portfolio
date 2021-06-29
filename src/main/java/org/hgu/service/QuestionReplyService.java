package org.hgu.service;

import java.util.List;

import org.hgu.domain.Criteria;
import org.hgu.domain.QuestionReplyPageDTO;
import org.hgu.domain.QuestionReplyVO;

public interface QuestionReplyService {
	// 댓글 작성
	public int register(QuestionReplyVO vo);

	// 댓글 상세내용
	public QuestionReplyVO get(int rno);

	// 댓글 수정
	public int modify(QuestionReplyVO vo);

	// 댓글 삭제
	public int remove(int rno);

	// 댓글 목록
	public List<QuestionReplyVO> getList(Criteria cri, int bno);

	// 댓글 페이징
	public QuestionReplyPageDTO getListPage(Criteria cri, int bno);
	
}
