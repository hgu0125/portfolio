package org.hgu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.hgu.domain.Criteria;
import org.hgu.domain.QuestionReplyPageDTO;
import org.hgu.domain.QuestionReplyVO;
import org.hgu.mapper.QuestionMapper;
import org.hgu.mapper.QuestionReplyMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class QuestionReplyServiceImpl implements QuestionReplyService {

	@Setter(onMethod_ = @Autowired)
	private QuestionReplyMapper mapper;

	@Setter(onMethod_ = @Autowired)
	private QuestionMapper questionMapper;

	// 댓글 작성
	@Transactional
	@Override
	public int register(QuestionReplyVO vo) {
		log.info("register......" + vo);
		questionMapper.updateReplyCnt(vo.getBno(), 1);
		return mapper.insert(vo);
	}

	// 댓글 상세내용
	@Override
	public QuestionReplyVO get(int rno) {
		log.info("get......" + rno);
		return mapper.read(rno);
	}

	// 댓글 수정
	@Override
	public int modify(QuestionReplyVO vo) {
		log.info("modify......" + vo);
		return mapper.update(vo);
	}

	// 댓글 삭제
	@Transactional
	@Override
	public int remove(int rno) {
		log.info("remove...." + rno);
		QuestionReplyVO vo = mapper.read(rno);
		questionMapper.updateReplyCnt(vo.getBno(), -1);
		return mapper.delete(rno);
	}

	// 댓글 목록
	@Override
	public List<QuestionReplyVO> getList(Criteria cri, int bno) {
		log.info("get Reply List of a Board " + bno);
		return mapper.getListWithPaging(cri, bno);
	}

	// 댓글 페이징
	@Override
	public QuestionReplyPageDTO getListPage(Criteria cri, int bno) {
		return new QuestionReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
	}
}
