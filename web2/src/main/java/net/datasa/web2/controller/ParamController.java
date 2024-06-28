package net.datasa.web2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import net.datasa.web2.domain.Member;
import net.datasa.web2.domain.Person;

@Controller
@RequestMapping("param")
// requestMapping은 get/post 구분x
@Slf4j
public class ParamController {
	// http://localhost:8888/param/view1 요청 처리 메소드
	@GetMapping("view1")
	public String view1() {
		return "paramView/view1";
	}
	
	// templates/paramView/view1.html로 포워딩
	
	@GetMapping("input1")
	public String input1(
			@RequestParam(name="id", defaultValue="") String id,
			// 입력된 값 중 name이 "id"인 것을 찾아서 id객체에 넣어라
			// defaultValue -> id가 빈값인 경우 처리할 방법
			@RequestParam(name="pw") String pw,
			@RequestParam(name="name") String name,
			@RequestParam(name="phone") String phone,
			@RequestParam(name="com") String com
			) 
	{
		log.debug("ID:{}, PW:{}, 이름:{}, 전화:{}, 통신사:{}"
				, id, pw, name, phone, com);
		// html의 name값이 맞지않는 경우 null값이 전송
		// http://localhost:8888/param/input1?id=abc&pw=123&name=aaa&phone=4123&com=kt
		return "redirect:/";
		// 생략하면 무조건 get
	}
	
	@GetMapping("view2") 
	public String view2() {
		return "paramView/view2";
	}
	
	// error = 404 : 경로문제 , 405는 방식문제
	@PostMapping("input2")
	public String input2(@ModelAttribute Member m) 
	{
		log.debug("객체값:{}", m);
		return "redirect:/";
		// 생략하면 무조건 get
	}
	
	@GetMapping("model") 
	public String model(Model model) {
		String str = "abced";
		int num = 11233;
		Person p = new Person("김", 20, "010");
		
		// model은 map구조(key + value)
		// DB에서 가져온 값이라고 가정
		model.addAttribute("str", str);
		model.addAttribute("n", num);
		model.addAttribute("person", p);
		
		// 한번 출력하고 끝나는 경우 model을 사용 ex)게시판의 게시물 읽기
		// 계속 정보가 필요한 경우 session ex)로그인 
	
		return "paramView/model";
	}
	
	

}
