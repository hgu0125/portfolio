package org.hgu.service;

import java.util.List;

import org.hgu.domain.BoardVO;
import org.hgu.domain.QuestionVO;

public interface HomeService {
	
	// 커뮤니티 추천글
	public List<BoardVO> getList1();
	// Q&A 추천글
	public List<QuestionVO> getList2();
	
}