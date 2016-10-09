package org.happylearn.train.springmvc.web;

import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.happylearn.train.springmvc.domain.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/valid")
public class ValidationController {
	
	@Resource
	private Validator validator;
	
	@RequestMapping("/test1")
	public String valid1(@Valid Teacher t, Errors errors) {
		if(errors.hasErrors()) {
			System.out.println(errors);
		}
		return "helloworld";
	}
	
	// api调用
	@RequestMapping("/test2")
	public String valid2(Teacher t) {
		Set<ConstraintViolation<Teacher>> erros = validator.validate(t, null);
		System.out.println(erros);
		return "helloworld";
	}
	
}
