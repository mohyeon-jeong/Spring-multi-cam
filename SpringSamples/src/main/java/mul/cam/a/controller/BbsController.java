package mul.cam.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mul.cam.a.dto.BbsComment;
import mul.cam.a.dto.BbsDTO;
import mul.cam.a.dto.BbsParam;
import mul.cam.a.service.BbsService;

@Controller
public class BbsController {

	@Autowired
	BbsService service;
	
	@GetMapping(value = "bbslist.do")
	public String bbslist(BbsParam param, Model model) {
		// 글의 시작과 끝
		int pn = param.getPageNumber();  // 0 1 2 3 4
		int start = 1 + (pn * 10);	// 1  11
		int end = (pn + 1) * 10;	// 10 20 
		
		param.setStart(start);
		param.setEnd(end);
		
		List<BbsDTO> list = service.bbsList(param);
		int len = service.getAllBbs(param);
		
		int pageBbs = len / 10;		// 25 / 10 -> 2
		if((len % 10) > 0) {
			pageBbs += 1;
		}
		
		if (param.getChoice() == null || param.getChoice().equals("")
				|| param.getSearch() == null || param.getSearch().equals("")) {
			param.setChoice("검색");
			param.setSearch("");
		}
		
		model.addAttribute("bbslist", list);	// 게시판 리스트
		model.addAttribute("pageBbs", pageBbs);	// 총 페이지수
		model.addAttribute("pageNumber", param.getPageNumber()); // 현재 페이지
		model.addAttribute("choice", param.getChoice());	// 검색 카테고리
		model.addAttribute("search", param.getSearch());	// 검색어
		
		return "bbslist";
	}
	
	@GetMapping(value = "bbswrite.do")
	public String bbsWrite() {
		return "bbswrite";
	}
	
	@PostMapping(value = "bbswriteAf.do")
	public String writeBbs(Model model, BbsDTO dto) {
		boolean isS = service.writeBbs(dto);
		String message = "";
		
		if (isS) {
			message = "BBS_ADD_OK";
		} else {
			message = "BBS_ADD_NO";
		}
		
		model.addAttribute("bbswrite", message);
		
		return "message";
//		return "redirect:/bbslist.do"; // Controller간 이동 시에 사용 가능 (그냥 return ~~.do 하면 ~~.do.jsp로 가짐) == sendRedirect
//		return "forward:/bbslist.do"; // 데이터도 가져갈 때는 forward 사용
	}
	
	@GetMapping(value = "bbsdetail.do")
	public String bbsDetail(int seq, Model model) {
		BbsDTO dto = service.getBbs(seq);
		model.addAttribute("bbsdto", dto);
		
		return "bbsdetail";
	}
	
	@GetMapping(value = "bbsupdate.do")
	public String bbsUpdate(Model model, int seq) {
		BbsDTO dto = service.getBbs(seq);
		model.addAttribute("updatebbs", dto);
		
		return "bbsupdate";
	}
	
	@PostMapping(value = "bbsUpdateAf.do")
	public String bbsUpdateAf(BbsDTO dto, Model model) {
		String bbsupdate = "";
		boolean isS = service.updateBbs(dto);
		if (isS) {
			bbsupdate = "BBS_UPDATE_OK";
		} else {
			bbsupdate = "BBS_UPDATE_FAILED";
			model.addAttribute("seq", dto.getSeq());
		}
		
		model.addAttribute("bbsupdate", bbsupdate);
		
		return "message";
	}
	
	@GetMapping(value = "bbsdelete.do")
	public String bbsDelete(int seq, Model model) {
		String bbsdelete = "";
		boolean isS	= service.deleteBbs(seq);
		if (isS) {
			bbsdelete = "BBS_DELETE_OK";
		}
		
		model.addAttribute("bbsdelete", bbsdelete);
		
		return "message";
	}
	
	@GetMapping(value = "answer.do")
	public String answer(int seq, Model model) {
		BbsDTO dto = service.getBbs(seq);
		
		model.addAttribute("dto", dto);
		
		return "answer";
	}
	
	@PostMapping(value = "answerAf.do")
	public String answerAf(BbsDTO dto, Model model) {
		String answer = "";
		boolean isS = service.writeAnswer(dto.getSeq(), dto);
		if (isS) {
			answer = "BBS_ANSWER_OK";
		} else {
			answer = "BBS_ANSWER_FAILED";
		}
		
		model.addAttribute("answer", answer);
		
		return "message";
	}
	
	// comment
	@PostMapping(value = "commentWriteAf.do")
	public String commentWrite(BbsComment bbs, Model model) {
		boolean isS = service.commentWrite(bbs);
		if (isS) {
			System.out.println("comment succeeded");
		} else {
			System.out.println("comment failed");
		}
		
		return "redirect:/bbsdetail.do?seq=" + bbs.getSeq();
	}
	
	@ResponseBody
	@GetMapping(value = "commentList.do")
	public List<BbsComment> commentList(int seq) {
		List<BbsComment> list = service.commentList(seq);
		
		return list;
	}
	
}







