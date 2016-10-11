package org.happylearn.train.spring.propertyeditor;

import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * 注意：<p>
 * 1.使用PropertyEditorRegistrar不需要同步Editor，每次都会构建新的Editor<p>
 * 2.使用该方式注册Editor可以方便的在DataBinder和Spring MVC 控制器中共享<p>
 * More: BeanWrapper和DataBinder实现了PropertyEditorRegistry接口<p>
 * Advantage: 可定义一组Editors,然后在指定Controllers之间共享。
 *
 */
public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
	
	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Date.class, new DateEditor());
	}

}
