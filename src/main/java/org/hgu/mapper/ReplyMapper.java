package org.hgu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hgu.domain.Criteria;
import org.hgu.domain.ReplyVO;

public interface ReplyMapper {
	// 댓글 등록
	public int insert(ReplyVO vo);

	// 댓글 조회
	public ReplyVO read(int bno);

	// 댓글 삭제
	public int delete(int bno);

	// 댓글 수정
	public int update(ReplyVO reply);

	// 댓글 목록
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") int bno);

	// 댓글 수
	public int getCountByBno(int bno);
}
