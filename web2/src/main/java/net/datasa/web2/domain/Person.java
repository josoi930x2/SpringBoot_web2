package net.datasa.web2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// ctrl + space 롬복 단축키
//@Data : Setter + Getter + ToString 
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	String name;
	int age;
	String phone;
	
	//기본생성자
	
	//기타 오버로딩 생성자
	
	//getter, setter 
	
	//toString 
}
