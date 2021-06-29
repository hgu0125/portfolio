package org.hgu.service;

import org.hgu.domain.MemberVO;
import org.hgu.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	private MemberMapper mapper;

	// 회원가입
	@Override
	public void register(MemberVO member) {
		log.info("member register");
		mapper.insert(member);
	}

	// 로그인
	@Override
	public MemberVO login(MemberVO member) {
		log.info("login: " + member);
		return mapper.login(member);
	}

	// 회원정보 상세내용
	@Override
	public MemberVO get(String id) {
		log.info("get............." + id);
		return mapper.read(id);
	}

	// 회원정보 수정
	@Override
	public boolean modify(MemberVO mboard) {
		log.info("modify..........");
		return mapper.update(mboard) == 1;
	}

	// 회원탈퇴
	@Override
	public boolean remove(String id) {
		log.info("remove..........");
		return mapper.delete(id) == 1;
	}

	// 아이디 중복확인
	@Override
	public int checkID(MemberVO member) {
		log.info("id check...........");
		return mapper.emailChk(member);
	}

}
