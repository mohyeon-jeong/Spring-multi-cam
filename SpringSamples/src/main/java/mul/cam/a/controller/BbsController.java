package mul.cam.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	}
	
	@GetMapping(value = "bbsdetail.do")
	public String bbsDetail(int seq, Model model) {
		BbsDTO dto = service.getBbs(seq);
		model.addAttribute("bbsdto", dto);
		
		return "bbsdetail";
	}
	
}







