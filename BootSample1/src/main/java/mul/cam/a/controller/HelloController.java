package mul.cam.a.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.dto.HumanDto;

@RestController // == @Controller + @Responsebody
public class HelloController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello() {
		System.out.println("HelloController hello() " + new Date());
		
		return "hello";
	}
	
	@GetMapping(value = "/test")
	public String test() {
		System.out.println("HelloController test() " + new Date());
		
		return "ㅎㅇ";
	}
	
	@GetMapping(value = "/human")
	public HumanDto getDto() {
		System.out.println("HelloController getDto() " + new Date());
		
		HumanDto human = new HumanDto(1001, "hong", "Seoul");
		
		return human;
	}
	
	@GetMapping(value = "/conn_param")
	public String conn_param(String title) {
		System.out.println("HelloController conn_param() " + new Date());
		System.out.println("title : " + title);
		
		return "conn success";
	}
	
	@GetMapping(value = "param_obj")
	public String param_obj(HumanDto human) {
		System.out.println("HelloController param_obj() " + new Date());
		System.out.println(human.toString());
		
		return "o";
	}
	
	@GetMapping("/get_list")
	public List<HumanDto> get_list() {
		System.out.println("HelloController get_list() " + new Date());
		List<HumanDto> list = new ArrayList<>();
		list.add(new HumanDto(101, "hong", "Icheon"));
		list.add(new HumanDto(102, "mo", "Incheon"));
		list.add(new HumanDto(103, "hyeon", "Seoul"));
		
		return list;
	}
	
}
