package org.happylearn.train.springmvc.web;

import java.util.Date;

import javax.servlet.ServletRequest;

import org.happylearn.train.common.DateUtils;
import org.happylearn.train.spring.propertyeditor.DateEditor;
import org.happylearn.train.springmvc.domain.Order;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping("/propertyEditor")
public class PropertyEditorController {
	
	// api调用，使用BeanWrapper手动注册自定义Editor
	@RequestMapping("/beanWrapper")
	public String test1(@RequestParam("date") String date) {
		
		BeanWrapper order = new BeanWrapperImpl(new Order());
		order.registerCustomEditor(Date.class, new DateEditor());
		order.setPropertyValue("date", date);
		Object dateObj = order.getPropertyType("date");
		System.out.println(dateObj);
		return "helloworld";
	}
	
	@RequestMapping("/ioc")
	public String test2(NativeWebRequest request) {
		ApplicationContext webContext = RequestContextUtils.getWebApplicationContext((ServletRequest)request.getNativeRequest());
		Order order = webContext.getBean("order", Order.class);
		System.out.println(DateUtils.getDateString(order.getDate()));
		return "helloworld";
	}
	@Autowired
	@Qualifier("customPropertyEditorRegistrar")
	private PropertyEditorRegistrar customPropertyEditorRegistrar;
	
	@InitBinder
	public void testPropertyEditorRegistrar(ServletRequestDataBinder binder) {
		customPropertyEditorRegistrar.registerCustomEditors(binder);
	}
	
	@RequestMapping("/testPropertyEditorRegistrar")
	public String test3(@RequestParam("date") Date date) {
		System.out.println(DateUtils.getDateString(date));
		return "helloworld";
	}
}
