package com.ddd.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * 自定义日期转换 CustomDateConverter
 * 
 * @author Dan
 *
 */
public class CustomDateConverter implements Converter<String, Date>, WebBindingInitializer {

	@Override
	public Date convert(String source) {

		// 实现 将日期串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			// 转成直接返回
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 如果参数绑定失败返回null
		return null;
	}

	@Override
	public void initBinder(WebDataBinder binder, WebRequest arg1) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
	}

}
