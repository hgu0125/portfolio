package org.hgu.mapper;

import java.util.List;

import org.hgu.domain.BoardAttachVO;

public interface BoardAttachMapper {

	public void insert(BoardAttachVO vo);			// 파일 업로드

	public void delete(String uuid);				// 파일 삭제

	public List<BoardAttachVO> findByBno(int bno);	// 파일 목록

	public void deleteAll(int bno);					// 파일 삭제

	public List<BoardAttachVO> getOldFiles();		

}