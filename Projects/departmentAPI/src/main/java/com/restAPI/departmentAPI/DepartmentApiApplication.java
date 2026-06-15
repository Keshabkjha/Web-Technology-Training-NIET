package com.restAPI.departmentAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.restAPI.departmentAPI")
public class DepartmentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentApiApplication.class, args);
	}
	
	/*
	 The static run method performs
	  a number of important setup 
	  tasks:

	1. Sets the default configuration

	2. Starts Spring application context

	3. Performs classpath scan

	4. Starts Embeded Tomcat server

If we run the project as a Java application (Right click project
-> Run As
-> Spring Boot Application), 
we see a bunch of output in the console 
*/

}

/*
The static run method performs a number of important setup tasks:

1. Sets the default configuration

2. Starts Spring application context

3. Performs classpath scan

4. Starts Tomcat server
*/
