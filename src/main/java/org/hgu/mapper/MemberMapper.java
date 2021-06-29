package org.hgu.mapper;

import org.hgu.domain.MemberVO;

public interface MemberMapper {
	// 회원가입
	public void insert(MemberVO member);
	
	// 로그인
	public MemberVO login(MemberVO member);
	
	// 회원정보 상세내용
	public MemberVO read(String id);
	
	// 회원정보 수정
	public int update(MemberVO mboard);
	
	// 회원탈퇴
	public int delete(String id);
	
	// 아이디 중복확인
	public int emailChk(MemberVO member);
}
