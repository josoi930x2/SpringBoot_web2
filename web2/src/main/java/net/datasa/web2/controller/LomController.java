package net.datasa.web2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.datasa.web2.domain.Person;

@Controller
@RequestMapping("lom")
@Slf4j
public class LomController {
	
	// http://aaa.com/lombok
	@GetMapping("lombok")
	public String lombokTest() {
		// Redirect	정보값 없이 초기화, 어디서 요청이 들어왔는지x return "redirect:~"
		// forwarding 입력한 정보값을 기억하고 이동 return "aaaa";
		
		Person p = new Person();
		p.setName("홍길동");
		p.setAge(10);
		p.setPhone("010-1111-1111");
		// System.out.println(p);
		
		/*
		 * 컴파일 에러 -> 롬복 사용
		 * @NoArgsConstructor : 파라미터가 없는 디폴트 생성자를 생성
		 * @AllArgsConstructor : 모든 필드 값을 파라미터로 받는 생성자를 생성
		 */
		Person p2 = new Person("김", 20, "010-1111-2222");
		
		
		return "redirect:/";
	}
	
	/*
	 * @Slf4j -> Simple Logging Facade 4 Java(간단한 자바를 위한 로깅 파사드)
	 * System.out.println()과 같은 출력문 대신에 로그확인 application.properties -> 로깅레벨
	 * error>warn>info>debug>trace
	 */
	@GetMapping("logger")
	public String loggerTest() {
		log.error("error 메소드로 출력함");
		log.warn("warn 메소드로 출력함");
		log.info("info 메소드로 출력함");
		log.debug("debug 메소드로 출력함");
		log.trace("trace 메소드로 출력함");
		
		String a = "abc";
		int b = 12;
		log.debug("a={}", "b={}", a, b);
		
		return "redirect:/";
	}

}
