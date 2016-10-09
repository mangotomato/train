package org.happylearn.train.springmvc.web;

import org.happylearn.train.springmvc.domain.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/content-negotiation")
public class ContentNegotiationController {
	
	@RequestMapping("/teacher")
	public Teacher printTeacher() {
		
		return new Teacher("scott", 1);
	}
}	
