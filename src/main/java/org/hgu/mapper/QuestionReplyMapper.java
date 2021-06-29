package org.hgu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hgu.domain.Criteria;
import org.hgu.domain.QuestionReplyVO;

public interface QuestionReplyMapper {
	// 댓글 등록
	public int insert(QuestionReplyVO vo);
	
	// 댓글 조회
	public QuestionReplyVO read(int bno);

	// 댓글 삭제
	public int delete(int bno);

	// 댓글 수정
	public int update(QuestionReplyVO vo);

	// 댓글 목록
	public List<QuestionReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") int bno);

	// 댓글 수
	public int getCountByBno(int bno);
}
