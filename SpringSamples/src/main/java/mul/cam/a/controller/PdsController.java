package mul.cam.a.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import mul.cam.a.dto.PdsDTO;
import mul.cam.a.service.PdsService;
import mul.cam.a.util.PdsUtil;

@Controller
public class PdsController {
	
	@Autowired
	PdsService service;
	
	@GetMapping(value = "pdsList.do")
	public String pdsList(Model model) {
		List<PdsDTO> list = service.pdsList();
		model.addAttribute("pdsList", list);
		
		return "pdsList";
	}
	
	@GetMapping(value = "pdsWrite.do")
	public String pdsWrite() {
		return "pdsWrite";
	}
	
	@PostMapping(value = "pdsUpload.do")
	public String pdsUpload(PdsDTO dto, @RequestParam(value = "fileload", required = false) MultipartFile fileLoad,
			HttpServletRequest req) {
		// get file name
		String fileName = fileLoad.getOriginalFilename();
		
		dto.setFileName(fileName);
		
		// upload 경로 설정
		// server
		String fupload = req.getServletContext().getRealPath("/upload");
		
		// 파일명을 충돌되지 않는 명칭(Date)으로 변경
		String newFileName = PdsUtil.getNewFileName(fileName);
		
		dto.setNewFileName(newFileName); // 변경된 파일명
		
		File file = new File(fupload + "/" + newFileName);
		
		try {
			// 실제 파일 생성 + 기입 = 업로드
			FileUtils.writeByteArrayToFile(file, fileLoad.getBytes());
			
			// db에 저장
			service.uploadPds(dto);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/pdsList.do";
	}
	
	@PostMapping(value = "fileDownload.do")
	public String fileDownload(int seq, String fileName, String newFileName, Model model, HttpServletRequest req) {
		
		// 경로
		// server
		String fupload = req.getServletContext().getRealPath("/upload");
		
		// 폴더
		// String fupload = "c:\\temp";
		
		// 받을 파일
		File downloadFile = new File(fupload + "/" + newFileName);
		
		model.addAttribute("downloadFile", downloadFile); // 업로드되어있는 파일명. 123124153.txt
		model.addAttribute("fileName", fileName); // 원래 파일명. asdf.txt
		model.addAttribute("seq", seq); // downloadCount 증가
		
		return "downloadView"; // file-context.xml
	}
	
}














