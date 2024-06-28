package net.datasa.web2.domain;

import lombok.Data;
// 가입할 때 id, 비번, 이름, 전화, 통신사를 모두 저장할 DTO클래스

@Data
public class Member {
	//FORM의 name과 일치하게 변수 선언	
	String id;
	String pw;
	String name;
	String phone;
	String com;
	
}
