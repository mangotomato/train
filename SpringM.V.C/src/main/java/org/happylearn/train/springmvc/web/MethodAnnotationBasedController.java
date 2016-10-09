package org.happylearn.train.springmvc.web;

import java.util.List;
import java.util.Map;

import org.happylearn.train.springmvc.domain.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * tips:看控制太输出
 * <p>
 * 演示：<p>
 * <ul>
 * 	<li>@RequestMapping</li>
 * 	<li>@PathVariable</li>
 * 	<li>@CookieValue</li>
 * 	<li>@RequestHeader</li>
 * 	<li>@RequestParam</li>
 *  <li>@ModelAttribute</li>
 *  <li>@RequestBody</li>
 *  <li>@SessionAttributes</li>
 * <ul>
 * @author leejianhao
 *
 */
@Controller
@RequestMapping("/train")
@SessionAttributes("step1")
public class MethodAnnotationBasedController {
	
	// --------------------------------- Begin @RequestMapping --------------------------------- //
	
	@RequestMapping(value="/requestMapping", method={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}
					,params={"!var1", "var2=2"}
					, consumes={"application/json"},produces={"application/json"}, headers={"content-type=application/json","accept=application/json"})
	public Teacher testRequestMapping(Teacher t) {
		return t;
	}
	// --------------------------------- End @RequestMapping --------------------------------- //
	
	
	// --------------------------------- Begin @PathVariable --------------------------------- //
	/**
	 * 作用：演示带一个参数的@PathVariable<p>
	 * 
	 * 注意一定要显示设置@PathVariable的value，如@PathVariable String var 是错误的示范。<p>
	 * 上生产服务器时，使用的javac编译，使用的是release模式，会去掉调试信息。即这里的变量名可能不是var。
	 * @param var
	 * @return
	 */
	@RequestMapping("/pathVariable/{var}")
	public String testPathVariable(@PathVariable("var") String var) {
		System.out.println(var);
		return "helloworld";
	}
	
	/**
	 * 作用：演示接收两个参数的@PathVariable<p>
	 * 
	 * 注意一定要显示设置@PathVariable的value，如@PathVariable String var 是错误的示范。<p>
	 * 上生产服务器时，使用的javac编译，使用的是release模式，会去掉调试信息。即这里的变量名可能不是var。
	 * @param var
	 * @return
	 */
	@RequestMapping("/pathVariable/{var1}/{var2}")
	public String testPathVariable2(@PathVariable("var1") String var1, @PathVariable("var2") String var2) {
		System.out.println(var1);
		System.out.println(var2);
		return "helloworld";
	}
	
	// --------------------------------- Begin @CookieValue --------------------------------- //
	
	@RequestMapping("/cookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String cookie) {
		System.out.println(cookie);
		return "helloworld";
	}
	// --------------------------------- End @CookieValue --------------------------------- //
	
	// --------------------------------- Begin @RequestHeader --------------------------------- //
	@RequestMapping("/requestHeader")
	public String testRequestHeader(@RequestHeader("User-Agent") String userAgent,
			@RequestHeader(value="Accept") String[] accepts,
			@RequestHeader("Accept-Encoding") String encoding,
			@RequestHeader("Keep-Alive") long keepAlive) {
		System.out.println(userAgent);
		System.out.println(accepts.length>0?accepts[0]:"");
		System.out.println(encoding);
		System.out.println(keepAlive);
		return "helloworld";
	}
	// --------------------------------- End @RequestHeader --------------------------------- //
		
		
	// --------------------------------- Begin @RequestParam --------------------------------- //
	@RequestMapping("/requestParam1")
	public String testRequestParam1(@RequestParam(value="a", required=false, defaultValue="1") String a, @RequestParam("b") String b) {
		System.out.println(a);
		System.out.println(b);
		return "helloworld";
	}
	
	// /requestParam2?id=1&id=2
	@RequestMapping("/requestParam2")
	public String testRequestParam2(@RequestParam("id") Integer[] ids) {
		for(int id:ids) {
			System.out.println(id);
		}
		return "helloworld";
	}
	
	@RequestMapping("/requestParam3")
	public String testRequestParam3(Map<String, String> map) {
		System.out.println(map.toString());
		return "helloworld";
	}
	
	// --------------------------------- End @RequestParam --------------------------------- //
	
	// --------------------------------- Begin @ModelAttribute --------------------------------- //
	
	//执行testModel1方法前会被调用，将返回的模型数据放到模型对象中，如model.addAttribute("teacher", t);
	@ModelAttribute("teacher")
	public Teacher initTeacher() {
		return new Teacher("scott", 1);
	}
	
	// 已经存在teacher,不会覆盖
	@ModelAttribute("teacher")
	public Teacher initTeacher2() {
		return new Teacher("scott", 2);
	}
	
	@RequestMapping("/modelAttribute1")
	public String testModel1(@ModelAttribute("teacher") Teacher t) {
		System.out.println(t.getAge());
		System.out.println(t.getName());
		return "helloworld";
	}
	
	
	// 暴露模型对象t，视图中可以获取t
	@RequestMapping("/modelAttribute2")
	public @ModelAttribute("t") Teacher testModel2() {
		return initTeacher();
	}
	
	// 匿名模型绑定，没有指定@ModelAttribute，则以简单类名首字母小写作为模型名称，这里为teacher
	@RequestMapping("/modelAttribute3")
	public  Teacher testModel3(Teacher t) {
		return t;
	}
	
	@RequestMapping("/modelAttribute4")
	public  Teacher testModel4(@ModelAttribute Teacher t) {
		return t;
	}
	
	// 约定为teacherList
	@RequestMapping("/modelAttribute5")
	public  List<Teacher> testModel5(List<Teacher> list) {
		return list;
	}
	
	// 约定为map
	@RequestMapping("/modelAttribute6")
	public Map<?,?> testModel6(Map<Integer,Teacher> map) {
		return map;
	}
	
	// --------------------------------- End @ModelAttribute --------------------------------- //
	
	// --------------------------------- End @SessionAttributes --------------------------------- //
	/**
	 * 执行流程：
	 * <p>
	 * 1.先根据@SessionAttributes，从session去取得名称对应的值，然后放入模型容器中。<p>
	 * 2.执行@MOdelattribute方法，如果名称已在@SessionAttribute中存在，则不执行该方法。如有没有，则执行该方法，然后把返回数据放入模型容器中<p>
	 * 
	 * @param t
	 * @return
	 */
	
	/*@ModelAttribute("step1")
	public Teacher initTeacher3() {
		return new Teacher("scott", 1);
	}*/
	
	@RequestMapping("/sessionAttribute/new")
	public String testNewSessionAttributes(@ModelAttribute("step1") Teacher t) {
		System.out.println(t.getName());
		return "helloworld";
	}
	// 如果@ModelAttribute中不存在名为step1的模型对象，且sessionAttributes中存在名为step1的模型对象，抛出异常
	// 如果@ModelAttribute中不存在名为step1的模型对象，且sessionAttributes中不存在名为step1的模型对象，通过反射构建
	//清除session
	@RequestMapping("/sessionAttribute/evict")
	public String testEvictSession(@ModelAttribute("step1") Teacher t, SessionStatus status) {
		status.setComplete();
		return "helloworld";
	}
	// --------------------------------- End @SessionAttributes --------------------------------- //
	
	

	
}
