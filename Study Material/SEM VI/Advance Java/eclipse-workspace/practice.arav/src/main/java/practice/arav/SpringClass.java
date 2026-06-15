package practice.arav;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClass {

	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext clp=new ClassPathXmlApplicationContext("config.xml");
		Vehicle vh=clp.getBean("myApp",Vehicle.class);
		System.out.println(vh.getName());
		// TODO Auto-generated method stub

	}

}
