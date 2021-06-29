package org.hgu.service;

import java.util.List;

import org.hgu.domain.Criteria;
import org.hgu.domain.ReplyPageDTO;
import org.hgu.domain.ReplyVO;

public interface ReplyService {
	// 댓글 작성
	public int register(ReplyVO vo);

	// 댓글 상세내용
	public ReplyVO get(int rno);

	// 댓글 수정
	public int modify(ReplyVO vo);

	// 댓글 삭제
	public int remove(int rno);

	// 댓글 목록
	public List<ReplyVO> getList(Criteria cri, int bno);

	// 댓글 페이징
	public ReplyPageDTO getListPage(Criteria cri, int bno);

}
