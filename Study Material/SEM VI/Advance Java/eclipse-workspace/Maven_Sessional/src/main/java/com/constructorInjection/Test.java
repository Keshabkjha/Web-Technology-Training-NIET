package com.constructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
public static void main(String[] arg) {
	
	ApplicationContext context=new ClassPathXmlApplicationContext("com/constructorinjection/CIconfig.xml");
	person oPerson=(person)context.getBean("objPerson");
	System.out.println(oPerson);
	
}
}