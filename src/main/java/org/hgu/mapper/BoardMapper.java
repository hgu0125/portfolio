package org.hgu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hgu.domain.BoardVO;
import org.hgu.domain.Criteria;

public interface BoardMapper {
	// 게시글 리스트
	public List<BoardVO> getList();
	
	// 게시글 페이징
	public List<BoardVO> getListWithPaging(Criteria cri);

	// 게시글 등록
	public void insert(BoardVO board);
	public void insertSelectKey(BoardVO board);

	// 게시글 상세내용
	public BoardVO read(int bno);

	// 게시글 삭제
	public int delete(int bno);

	// 게시글 수정
	public int update(BoardVO board);
	
	// 게시글 조회수
	public void hit(int bno);

	// 총 게시글 수
	public int getTotalCount(Criteria cri);
	
	// 추천 수
	public void recommend(int bno);

	// 댓글 수
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}
