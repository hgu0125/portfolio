package org.hgu.service;

import java.util.List;

import org.hgu.domain.QuestionAttachVO;
import org.hgu.domain.QuestionVO;
import org.hgu.domain.Criteria;

public interface QuestionService {
	// 글쓰기
	public void register(QuestionVO qboard);
	
	// 글 상세내용
	public QuestionVO get(int bno);

	// 글 수정
	public boolean modify(QuestionVO qboard);

	// 글 삭제
	public boolean remove(int bno);

	// 글 목록
	public List<QuestionVO> getList();

	// 페이징
	public List<QuestionVO> getList(Criteria cri);

	// 총 게시글 수
	public int getTotal(Criteria cri);
	
	// 추천 수
	public void recommend(int bno);

	// 파일첨부
	public List<QuestionAttachVO> getAttachList(int bno);

}
