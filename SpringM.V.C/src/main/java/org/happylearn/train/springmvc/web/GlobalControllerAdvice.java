package org.happylearn.train.springmvc.web;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalControllerAdvice {
	
	/*@InitBinder("student")
	public void setStudent(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("student_");
	}
	
	@InitBinder("teacher")
	public void setTeacher(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("teacher_");
	}*/

}
