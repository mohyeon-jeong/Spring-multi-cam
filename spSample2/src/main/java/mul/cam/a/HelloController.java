package mul.cam.a;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mul.cam.a.DTO.HumanDTO;

@Controller
public class HelloController {
	
	private static Logger Logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String homeMethod() {
//		System.out.println("HelloController homeMethod() " + new Date());
		Logger.info("HelloController homeMethod() " + new Date());
		
		return "home";
	}
	
	@RequestMapping(value = "hello.do", method = RequestMethod.GET)
	public String hello(Model model) {
		String name = "hong";
		model.addAttribute("name", name);
		
		return "home";
	}
	
	@RequestMapping(value = "world.do", method = RequestMethod.POST)
	public String world(String name, int age) {
		Logger.info("HelloController world() " + new Date());
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		return "home";
	}
	
	@RequestMapping(value = "main.do", method = RequestMethod.POST)
	public String mainMethod(HumanDTO human) {
		Logger.info("HelloController mainMethod() " + new Date());
		
		System.out.println(human.toString());
		
		return "home";
	}
	
	@RequestMapping(value = "mylist.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String mylist(String message, Model model) {
		Logger.info("HelloController mylist() " + new Date());
		
		System.out.println("message : " + message);
		
		List<HumanDTO> list = new ArrayList<>();
		
		list.add(new HumanDTO("hong", 24));
		list.add(new HumanDTO("seong", 16));
		list.add(new HumanDTO("il", 22));
		
		model.addAttribute("list", list);
		
		return "home";
	}
	
}
