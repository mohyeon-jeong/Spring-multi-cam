package mul.cam.a.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mul.cam.a.dto.MemberDTO;
import mul.cam.a.service.MemberService;

@Controller
public class MemberController {

	// access to Service
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(Model model) {
		List<MemberDTO> list = service.allMember();
		model.addAttribute("list", list);
		
		return "home";
	}
	
	@ResponseBody // means ajax communication
	@RequestMapping(value = "idcheck.do", method = RequestMethod.GET, produces = "application/String; charset=UTF-8")
	public String idcheck(String id) {
		System.out.println("id : " + id);
		
		String message = "ㅇㅋ";
		
		return message;
	}
	
	@ResponseBody
	@RequestMapping(value = "account.do", method = RequestMethod.POST)
	public List<MemberDTO> account(MemberDTO dto) {
		System.out.println(dto.toString());
		
		List<MemberDTO> list = new ArrayList<>();
		list.add(new MemberDTO("asdf", "1234", "asdf", "email1", 0));
		list.add(new MemberDTO("qwer", "5678", "qwer", "email2", 0));
		list.add(new MemberDTO("zxcv", "2345", "zxcv", "email3", 0));
		
		return list;
	}
	
}




















