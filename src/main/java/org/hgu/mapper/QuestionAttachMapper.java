package org.hgu.mapper;

import java.util.List;

import org.hgu.domain.QuestionAttachVO;

public interface QuestionAttachMapper {

	public void insert(QuestionAttachVO vo);			// 파일 업로드

	public void delete(String uuid);					// 파일 삭제

	public List<QuestionAttachVO> findByBno(int bno);	// 파일 목록

	public void deleteAll(int bno);						// 파일 삭제

	public List<QuestionAttachVO> getOldFiles();		

}