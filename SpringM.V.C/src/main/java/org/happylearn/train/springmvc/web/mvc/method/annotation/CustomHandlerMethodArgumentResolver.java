package org.happylearn.train.springmvc.web.mvc.method.annotation;

import java.lang.reflect.Field;

import org.happylearn.train.springmvc.web.annotation.CustomForm;
import org.springframework.core.MethodParameter;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


public class CustomHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(CustomForm.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest request,
			WebDataBinderFactory binderFactory) throws Exception {
		CustomForm form = parameter.getParameterAnnotation(CustomForm.class);
		String parameterPrefix = getParameterPrefix(form, parameter.getParameterType());
		
		WebDataBinder binder = binderFactory.createBinder(request, null, parameterPrefix);
		
		Object convertedField;
		
		Object target = parameter.getParameterType().newInstance();
		for(Field field : parameter.getParameterType().getDeclaredFields()) {
			if(!field.isAccessible()) field.setAccessible(true);
			convertedField = binder.convertIfNecessary(request.getParameter(parameterPrefix+field.getName()), field.getType(), parameter);
			field.set(target, convertedField);
		}
		
		return target;
	}
	
	private String getParameterPrefix(CustomForm form,  Class<?> parameterType) {
		return form.value() != "" ? form.value() :  ClassUtils.getShortNameAsProperty(parameterType);
	}

}
