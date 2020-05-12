package com.example.springcontext;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		//Must call configure method to eliminate log4j:WARN "No appenders could be found for logger" warning
		BasicConfigurator.configure();
		
//		Employee eRef = new Employee();
//		eRef.setEdit(101);
//		eRef.setEname("John Watson");
//		eRef.setEaddress("Redwood Shores");
		
//		System.out.println("Employee Details: " + eRef);
		
		//Spring Way | IOC (Inversion Of Control)
		//Resource resource = new ClassPathResource("employeebean.xml");
		//BeanFactory factory = new XmlBeanFactory(resource);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("employeebean.xml");
		
		//Employee e1 = (Employee)factory.getBean("emp1");
		//Employee e2 = factory.getBean("emp2",Employee.class);
		
		Employee e1 = (Employee)context.getBean("emp1");
		//Employee e2 = context.getBean("emp2",Employee.class);
		
		System.out.println("Employee1 Details: " + e1);
		//System.out.println("Employee2 Details: " + e2);
		
		ClassPathXmlApplicationContext cxt = (ClassPathXmlApplicationContext)context;
		cxt.close();
	}

}
