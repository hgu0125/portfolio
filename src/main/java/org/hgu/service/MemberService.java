package org.hgu.service;

import org.hgu.domain.MemberVO;

public interface MemberService {
	// 회원가입
	public void register(MemberVO member);

	// 로그인
	public MemberVO login(MemberVO member);

	// 회원정보 상세내용
	public MemberVO get(String id);

	// 회원정보 수정
	public boolean modify(MemberVO mboard);

	// 회원탈퇴
	public boolean remove(String id);

	// 아이디 중복확인
	public int checkID(MemberVO member);
	
}
