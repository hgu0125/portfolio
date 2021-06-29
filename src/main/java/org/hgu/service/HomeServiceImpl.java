package org.hgu.service;

import java.util.List;

import org.hgu.domain.BoardVO;
import org.hgu.domain.QuestionVO;
import org.hgu.mapper.HomeMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class HomeServiceImpl implements HomeService {
	private HomeMapper mapper;

	// 커뮤니티 추천글
	@Override
	public List<BoardVO> getList1() {
		log.info("get List1");
		return mapper.getListWithPaging1();
	}

	// Q&A 추천글
	@Override
	public List<QuestionVO> getList2() {
		log.info("get List2");
		return mapper.getListWithPaging2();
	}
	
}
