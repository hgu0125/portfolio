package org.hgu.controller;

import javax.servlet.http.HttpSession;

import org.hgu.domain.Criteria;
import org.hgu.domain.MemberVO;
import org.hgu.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member/")
@AllArgsConstructor
public class MemberController {
	private MemberService service;

	// 회원가입 화면 보여주기
	@GetMapping("/member")
	public void register() {

	}

	// 회원가입
	@PostMapping("/register")
	public String register(MemberVO member) {
		log.info("member register");
		service.register(member);
		return "redirect:/member/login";
	}

	// 회원정보 수정 창 보여주기
	@PostMapping({ "/get" })
	public void get(@RequestParam("id") String id, Model model) {
		log.info("/get or modify");
		model.addAttribute("mboard", service.get(id));
	}

	// 회원정보 수정
	@PostMapping("/modify")
	public String modify(MemberVO member, RedirectAttributes rttr) {
		log.info("modify:" + member);

		if (service.modify(member)) {
			rttr.addFlashAttribute("result", "success");
		}

		return "redirect:/";
	}

	// 회원탈퇴
	@PostMapping("/remove")
	public String remove(@RequestParam("id") String id, RedirectAttributes rttr, HttpSession session) {
		log.info("remove: " + id);

		if (service.remove(id)) {
			rttr.addFlashAttribute("result", "success");
			session.removeAttribute("loginMember");
		}
		return "redirect:/";
	}

	// 로그인화면 보여주기
	@GetMapping("/login")
	public void loginGet() {

	}

	// 로그인
	@PostMapping("/login")
	public String loginPost(MemberVO member, HttpSession session, RedirectAttributes rttr) {
		log.info("login 시도");

		MemberVO vo = service.login(member);
		session.setAttribute("loginMember", vo);

		// select결과에 값이 있으면
		if (session.getAttribute("loginMember") != null) {
			return "redirect:/";
		} else {
			session.setAttribute("errorMessage", "fail");
			log.info(session.getAttribute("errorMessage"));
			return "redirect:/member/login";
		}
	}

	// 로그아웃
	@PostMapping("/logout")
	public String logoutPost(HttpSession session) {
		log.info("logout");

		// loginMember에 저장된 세션정보 삭제
		session.removeAttribute("loginMember");
		// 또는 session.invalidate();
		return "redirect:/";
	}

	// 아이디 중복확인
	@ResponseBody
	@RequestMapping(value = "/idChk", method = RequestMethod.POST)
	public int checkID(MemberVO member) {
		log.info("id check");
		int result = service.checkID(member);
		return result;
	}

}
