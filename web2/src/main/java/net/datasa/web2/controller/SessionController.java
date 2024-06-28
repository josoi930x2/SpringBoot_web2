package net.datasa.web2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("ss")
@Slf4j
public class SessionController {
	
	//세션에 값 저장 (세션<->쿠키:간단한 정보, 클라이언트쪽에 저장)
	@GetMapping("session1")
	public String session1(HttpSession session) {
		//HttpSession? key와 value를 이용한 저장소
		session.setAttribute("name", "abced");
		// 삭제 removeAttribute
		return "redirect:/";
	}
	
	//세션에서 값 읽기
	@GetMapping("session2")
	public String session2(HttpSession session) {
		//getAttribute : 전부 오브젝트 형으로 저장됨 ->캐스팅 필요
		String s = (String)session.getAttribute("name");
		
		log.debug("세션의 값: {}", s);
		return "ssView/session1";
	}
	
	//세션 값 삭제
	@GetMapping("session3")
	public String session3(HttpSession session) {
		
		session.removeAttribute("name");
		return "redirect:/";
	}
	
	//로그인 페이지로 이동
	@GetMapping("login")
	public String login() {
		return "ssView/login";
	}
	
	//로그인 처리
	@PostMapping("login")
	public String loginProcess(
			HttpSession session,
			@RequestParam("id") String id,
			@RequestParam("password") String pw
			// 파라미터명과 html의 name값과 일치하는지 잘 확인할 것
			) 
	{
		log.debug("id = {}, pw = {}" , id, pw);
		//아이디가 "abc"이고 비밀번호가 "123"이면 로그인 처리
		if (id.equals("abc") && pw.equals("123")) {		
			session.setAttribute("loginId", id);
			//로그인에 성공한 경우 세션에 아이디를 저장
			return "redirect:/"; 
			//메인화면으로 이동
		}else {
			return "ssView/login";
			//로그인에 실패한 경우 다시 로그인 페이지로 이동
		}
	}
	
	//로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		return "redirect:/";
	}
	
	//로그인 확인 페이지
	@GetMapping("loginTest")
	public String loginTest(HttpSession session) {
		String id = (String)session.getAttribute("loginId");
		//로그인을 성공하면 값이 생기지만, 실패하면 null
		if(id == null) {
			return "redirect:/";
		}
		return "ssView/loginTest";
	}

}
