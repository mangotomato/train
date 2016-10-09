package org.happylearn.train.springmvc.web;

import static org.happylearn.train.common.Constants.RequestTo.REDIRECT;

import javax.servlet.http.HttpServletRequest;

import org.happylearn.train.springmvc.domain.Student;
import org.happylearn.train.springmvc.domain.Teacher;
import org.happylearn.train.springmvc.domain.Worker;
import org.happylearn.train.springmvc.editor.CustomSexTypePropertyEditor;
import org.happylearn.train.springmvc.editor.SexType;
import org.happylearn.train.springmvc.web.annotation.CustomForm;
import org.happylearn.train.springmvc.web.annotation.CustomServletModelForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/binder")
public class DataBinderController {
	
	// 测试自定义编辑器，格式化
	@RequestMapping(value="/customEditor")
	public String testServletRequestDataBinder(HttpServletRequest req) {
		
		Worker worker = new Worker();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(worker);
		binder.registerCustomEditor(SexType.class, new CustomSexTypePropertyEditor());
		binder.bind(req);
		System.out.println(worker.getSex());
		return REDIRECT+"/hello";
	}
	
	// 控制器私有的Binder
	@InitBinder("student")
	public void setStudent(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("student_");
	}
	
	@InitBinder("teacher")
	public void setTeacher(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("teacher_");
	}
	
	@RequestMapping("/test1")
	public String test1(Teacher teacher, Student student) {
		System.out.println("老师姓名："+teacher.getName());
		System.out.println("学生姓名："+student.getName());
		return "helloworld";
	}
	
	@RequestMapping("/test2")
	public String test2(@CustomForm("t_") Teacher teacher, @CustomForm("s_")Student student) {
		System.out.println("老师姓名："+teacher.getName());
		System.out.println("学生姓名："+student.getName());
		return "helloworld";
	}
	
	@RequestMapping("/test3")
	public String test3(@CustomServletModelForm("t_") Teacher teacher, @CustomServletModelForm("s_")Student student) {
		System.out.println("老师姓名："+teacher.getName());
		System.out.println("学生姓名："+student.getName());
		return "helloworld";
	}
	
	
	
	
	
	
	
}
