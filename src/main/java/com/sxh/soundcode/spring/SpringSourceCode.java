package com.sxh.soundcode.spring;/**
 * Created by SXH on 2020/1/9 21:06.
 */

import org.apache.catalina.core.ApplicationContext;
import org.apache.naming.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author SXH
 * @description
 * @date 2020/1/9 21:06.
 */
public class SpringSourceCode {
	public static void main(String[] args) {
		BeanFactory beanFactory = new BeanFactory();

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("");
	}
}
