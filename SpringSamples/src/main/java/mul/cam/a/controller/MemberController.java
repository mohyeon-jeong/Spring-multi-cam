package mul.cam.a.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		System.out.println("MemberController login " + new Date());
		
		return "login";
	}
	
	@RequestMapping(value = "regi.do", method = RequestMethod.GET)
	public String regi() {
		System.out.println("MemberController regi " + new Date());
		
		return "regi";
	}
	
	@ResponseBody
	@RequestMapping(value = "idcheck.do", method = RequestMethod.POST)
	public String idcheck(String id) {
		System.out.println("MemberController idcheck " + new Date());
		
		String checkedId = service.idCheck(id);
		
		if (checkedId == null) {
			return "YES";
		} else {
			return "NO";
		}
	}
	
	@RequestMapping(value = "regiAf.do", method = RequestMethod.POST)
	public String regiAf(MemberDTO dto, Model model) {
		System.out.println("MemberController regiAf " + new Date());
		
		boolean isS = service.addMember(dto);
		String message = "";
		if (isS) {
			message = "MEMBER_ADD_YES";
		} else {
			message = "MEMBER_ADD_NO";
		}
		model.addAttribute("message", message);
		
		return "message";
	}
	
	@RequestMapping(value = "loginAf.do", method = RequestMethod.POST)
	public String login(HttpServletRequest req, Model model, MemberDTO dto) { // req도 model처럼 아무때나 써야할 때 parameter로 추가 가능
		System.out.println("MemberController login " + new Date());
		
		MemberDTO mem = service.login(dto);
		String msg = "";
		if (mem != null) {
			req.getSession().setAttribute("login", mem); // session에 저장
			req.getSession().setMaxInactiveInterval(60 * 60 * 2); // 2시간동안 유지됨
			msg = "LOGIN_OK";
		} else {
			msg = "LOGIN_NO";
		}
		model.addAttribute("login", msg);
		
		return "message";
	}
	
}




















