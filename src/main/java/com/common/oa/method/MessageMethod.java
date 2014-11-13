package com.common.oa.method;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.common.oa.utils.MessageUtils;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

/**
 * 获取国际化信息
 * @author jerry
 * 2014/08/02
 */

public class MessageMethod implements TemplateMethodModel{

	public Object exec(List arguments) throws TemplateModelException {
		if (arguments != null && !arguments.isEmpty() && arguments.get(0) != null && StringUtils.isNotEmpty(arguments.get(0).toString())) {
			String message = null;
			String code = arguments.get(0).toString();
			if (arguments.size() > 1) {
				Object[] args = arguments.subList(1, arguments.size()).toArray();
				message = MessageUtils.getMessage(code, args);
			}	 else {
				message = MessageUtils.getMessage(code);
			}
			return new SimpleScalar(message);
		}
		return "";
	}

}
