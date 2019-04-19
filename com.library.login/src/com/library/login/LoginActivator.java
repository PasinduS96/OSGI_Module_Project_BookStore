package com.library.login;

import com.library.employee.EmployeeActivator;
import com.library.main.MainActivator;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class LoginActivator implements BundleActivator {

	Scanner myObj = new Scanner(System.in); 
	ServiceReference mainReference;
	ServiceReference employeeReference;

	public void start(BundleContext bundleContext) throws Exception {
		
		mainReference = bundleContext.getServiceReference(MainActivator.class.getName());
		MainActivator mainService = (MainActivator)bundleContext.getService(mainReference);
		
		employeeReference = bundleContext.getServiceReference(EmployeeActivator.class.getName());
		EmployeeActivator empService = (EmployeeActivator)bundleContext.getService(employeeReference);
		
		String username;
		String password;
		
		System.out.println("---------- Welcome Book Store Management System ---------- \n\n");
		System.out.println("Login in As : \n");
		System.out.println("1. Manager : \n");
		System.out.println("2. Employee : \n");
		System.out.print("");
		System.out.print("Select Your Option :");
		int opt = myObj.nextInt();
		
		if (opt == 1) {
			
			boolean x = true;
			
			while(true) {
				System.out.print("Enter Username : ");
				username = myObj.next();
				
				System.out.print("Enter Password : ");
				password = myObj.next();
				
				if((username.equalsIgnoreCase("admin")) && (password.equalsIgnoreCase("pass"))) {
					
					//mainService.start(bundleContext);
				}else {
					System.out.print("Invalid Username or Password");
					x = true;
				}
			}
			
	
			
		}else if(opt == 2) {
			
			boolean x = true;
			
			while(true) {
				System.out.print("Enter Username : ");
				username = myObj.next();
				
				System.out.print("Enter Password : ");
				password = myObj.next();
				
				if((username.equalsIgnoreCase("admin")) && (password.equalsIgnoreCase("pass"))) {
					
					empService.start(bundleContext);
				}else {
					System.out.print("Invalid Username or Password");
					x = true;
				}
			}
			
			
			
			
			
		}

	}

	public void stop(BundleContext bundleContext) throws Exception {
		
	}

}
