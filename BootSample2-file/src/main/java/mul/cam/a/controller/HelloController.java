package mul.cam.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import mul.cam.a.MediaTypeUtils;
import mul.cam.a.dto.HumanDto;

@RestController
public class HelloController {

	// upload
	@PostMapping("/fileUpload")
	public String fileUpload(HumanDto human,
							 @RequestParam("uploadFile")
							 MultipartFile uploadFile,
							 HttpServletRequest req) {
		System.out.println("HelloController fileUpload() " + new Date());
		System.out.println(human.toString());
		
		// 경로
		String path = req.getServletContext().getRealPath("/upload");
		// String path = "c:\temp";
		
		String filename = uploadFile.getOriginalFilename();
		String filepath = path + "/" + filename;
		
		System.out.println(filepath);
		
		File file = new File(filepath);
		
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(uploadFile.getBytes());
			bos.close();
		} catch (Exception e) {
			return "file uploading failed";
		}
		
		return "file uploading succeded";
	}
	
	// download
	@Autowired
	ServletContext servletContext;
	
	@GetMapping("/fileDownload")
	public ResponseEntity<InputStreamResource> download(String filename, HttpServletRequest req) throws Exception {
		System.out.println("HelloController download() " + new Date());
		
		// 경로
		String path = req.getServletContext().getRealPath("/upload");
		
		MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, filename);
		System.out.println("filename : " + filename);
		System.out.println("mediatype : " + mediaType);
		
		File file = new File(path + File.separator + filename); // newfilename
		
		InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
		
		// 여기에 db 다운로드 카운트
		
		return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
					.contentType(mediaType)
					.contentLength(file.length())
					.body(isr);
	}
	
}























