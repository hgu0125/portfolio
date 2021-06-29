package org.hgu.mapper;

import java.util.List;

import org.hgu.domain.BoardVO;
import org.hgu.domain.QuestionVO;

public interface HomeMapper {
	
	// 커뮤니티 추천글
	public List<BoardVO> getListWithPaging1();
	// Q&A 추천글
	public List<QuestionVO> getListWithPaging2();
	
}