package org.happylearn.train.springmvc.web;

import static org.happylearn.train.springmvc.web.Constants.RequestTo.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * tips:看控制太输出
 * @author leejianhao
 *
 */
@Controller
@RequestMapping("/train")
public class TrainController {
	
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
		return REDIRECT+"/hello";
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
		return REDIRECT+"/hello";
	}
	
	// --------------------------------- End @PathVariable --------------------------------- //
	
	
	
}
