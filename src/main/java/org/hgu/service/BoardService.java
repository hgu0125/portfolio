package org.hgu.service;

import java.util.List;

import org.hgu.domain.BoardAttachVO;
import org.hgu.domain.BoardVO;
import org.hgu.domain.Criteria;

public interface BoardService {
	// 글쓰기
	public void register(BoardVO board);

	// 글 상세내용
	public BoardVO get(int bno);

	// 글 수정
	public boolean modify(BoardVO board);

	// 글 삭제
	public boolean remove(int bno);

	// 글 목록
	public List<BoardVO> getList();

	// 페이징
	public List<BoardVO> getList(Criteria cri);

	// 총 게시글 수
	public int getTotal(Criteria cri);
	
	// 추천 수
	public void recommend(int bno);

	// 파일첨부
	public List<BoardAttachVO> getAttachList(int bno);

}
