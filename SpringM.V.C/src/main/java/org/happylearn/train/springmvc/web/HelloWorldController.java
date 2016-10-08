package org.happylearn.train.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller //@Component
public class HelloWorldController{
	
	@RequestMapping({"/helloworld","/hello"})
	public String helloWorld(Model model) {
		model.addAttribute("message", "Hello World!");
		return "helloworld";
	}

}
