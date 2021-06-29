package org.hgu.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hgu.domain.QuestionAttachVO;
import org.hgu.domain.QuestionVO;
import org.hgu.domain.Criteria;
import org.hgu.domain.PageDTO;
import org.hgu.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/question/*")
@AllArgsConstructor
public class QuestionController {
	private QuestionService service;

	// 글 목록
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list");
		
		// 카테고리별 select해서 model에 저장
		model.addAttribute("list", service.getList(cri));

		// 총 게시글 수 구하기
		int total = service.getTotal(cri);
		log.info("total: " + total);
		// 페이징하기
		model.addAttribute("pageMaker", new PageDTO(cri, total));

	}

	// 글 작성 페이지로 이동
	@GetMapping("/register")
	public void register() {
	}

	// 글 작성
	@PostMapping("/register")
	public String register(QuestionVO qboard, RedirectAttributes rttr) {

		if(qboard.getAttachList() != null) {
			qboard.getAttachList().forEach(attach -> log.info(attach));
		}
		log.info("register: " + qboard);
		service.register(qboard);
		rttr.addFlashAttribute("result", qboard.getBno());

		return "redirect:/question/list"; // /question/list만 하면 그냥 jsp파일로 이동됨
										  // redirect는 새로운 URL요청 -> Controller 실행
	}

	// 글 상세내용
	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) {

		log.info("/get or modify");
		model.addAttribute("qboard", service.get(bno));
	}

	// 글 수정
	@PostMapping("/modify")
	public String modify(QuestionVO qboard, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify:" + qboard);

		if (service.modify(qboard)) {
			rttr.addFlashAttribute("result", "succescc");
		}

		return "redirect:/question/list" + cri.getListLink();
	}

	// 글 삭제
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr) {

		log.info("remove..." + bno);

		List<QuestionAttachVO> attachList = service.getAttachList(bno);

		if (service.remove(bno)) {

			// delete Attach Files
			deleteFiles(attachList);

			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/question/list" + cri.getListLink();
	}

	private void deleteFiles(List<QuestionAttachVO> attachList) {

		if (attachList == null || attachList.size() == 0) {
			return;
		}

		log.info("delete attach files...................");
		log.info(attachList);

		attachList.forEach(attach -> {
			try {
				Path file = Paths.get(
						"C:\\upload\\" 
								+ attach.getUploadPath() 
								+ "\\" 
								+ attach.getUuid() 
								+ "_" 
								+ attach.getFileName());

				Files.deleteIfExists(file);

				if (Files.probeContentType(file).startsWith("image")) {

					Path thumbNail = Paths.get("C:\\upload\\" 
							+ attach.getUploadPath() 
							+ "\\s_" 
							+ attach.getUuid() 
							+ "_"
							+ attach.getFileName());

					Files.delete(thumbNail);
				}

			} catch (Exception e) {
				log.error("delete file error" + e.getMessage());
			} // end catch
		});// end foreachd
	}

	// 파일첨부
	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<QuestionAttachVO>> getAttachList(int bno) {

		log.info("getAttachList " + bno);

		return new ResponseEntity<>(service.getAttachList(bno), HttpStatus.OK);

	}
	
	// 게시글 추천
	@RequestMapping("/recommend")
	public String recommend(@RequestParam("bno") int bno) {
		service.recommend(bno);
		return "forward:/question/get";
	}
}