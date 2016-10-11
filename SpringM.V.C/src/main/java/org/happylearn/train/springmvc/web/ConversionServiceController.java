package org.happylearn.train.springmvc.web;

import java.util.Date;

import org.happylearn.train.spring.converter.TrueAndFalse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/conversionService")
public class ConversionServiceController {
	
	@RequestMapping("/converter")
	public String testConverter(@RequestParam("answer")TrueAndFalse answer) {
		System.out.println(answer.toString());
		return "helloworld";
	}
	
	@RequestMapping("/formatter")
	public String testFormatter(Date date) {
		System.out.println(date);
		return "helloworld";
	}
}
