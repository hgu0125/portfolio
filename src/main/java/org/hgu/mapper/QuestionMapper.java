package org.hgu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hgu.domain.QuestionVO;
import org.hgu.domain.Criteria;

public interface QuestionMapper {
	// 게시글 리스트
	public List<QuestionVO> getList();

	// 게시글 페이징
	public List<QuestionVO> getListWithPaging(Criteria cri);

	// 게시글 등록
	public void insert(QuestionVO qboard);
	public void insertSelectKey(QuestionVO qboard);

	// 게시글 상세내용
	public QuestionVO read(int bno);

	// 게시글 삭제
	public int delete(int bno); // bno가 있으면1 없으면 0리턴하는듯

	// 게시글 수정
	public int update(QuestionVO qboard);

	// 게시글 조회수
	public void hit(int bno);
	
	// 총 게시글 수
	public int getTotalCount(Criteria cri);
	
	// 추천 수
	public void recommend(int bno);

	// 댓글 수
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}
