package org.happylearn.train.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/intercepted")
public class InterceptedController {
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("...");
		return "helloworld";
	}
	
}
