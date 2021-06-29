package org.hgu.service;

import java.util.List;

import org.hgu.domain.QuestionAttachVO;
import org.hgu.domain.QuestionVO;
import org.hgu.domain.Criteria;
import org.hgu.mapper.QuestionAttachMapper;
import org.hgu.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service // 비즈니스 영역을 담당하는 객체임을 표시
@AllArgsConstructor // 모든 필드를 파라미터로 하는 생성자 생성
public class QuestionServiceImpl implements QuestionService {

	// spring 4.3 이상에서는 자동 처리
	@Setter(onMethod_ = @Autowired)
	private QuestionMapper mapper;

	@Setter(onMethod_ = @Autowired)
	private QuestionAttachMapper attachMapper;

	// 글 작성
	@Transactional
	@Override
	public void register(QuestionVO qboard) {
		log.info("register......" + qboard);
		mapper.insertSelectKey(qboard);
		if (qboard.getAttachList() == null || qboard.getAttachList().size() <= 0) {
			return;
		}

		qboard.getAttachList().forEach(attach -> {
			attach.setBno(qboard.getBno());
			attachMapper.insert(attach);
		});
	}

	// 글 상세내용
	@Override
	public QuestionVO get(int bno) {
		log.info("get......" + bno);
		mapper.hit(bno);
		return mapper.read(bno);
	}

	// 글 수정
	@Override
	public boolean modify(QuestionVO qboard) {
		log.info("modify......" + qboard);
		return mapper.update(qboard) == 1;
	}

	// 글 삭제
	@Override
	public boolean remove(int bno) {
		log.info("remove...." + bno);
		;
		return mapper.delete(bno) == 1;
	}

	// 글 목록
	@Override
	public List<QuestionVO> getList() {
		log.info("getList..........");
		return mapper.getList();
	}

	// 페이징
	@Override
	public List<QuestionVO> getList(Criteria cri) {
		log.info("getList with criteria:" + cri);
		return mapper.getListWithPaging(cri);
	}

	// 총 게시글 수
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		;
		return mapper.getTotalCount(cri);
	}
	
	// 추천 수
	@Override
	public void recommend(int bno) {
		mapper.recommend(bno);
	}

	// 파일첨부
	@Override
	public List<QuestionAttachVO> getAttachList(int bno) {
		log.info("get Attach list by bno" + bno);
		return attachMapper.findByBno(bno);
	}
}
