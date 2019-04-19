package com.library.employee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.library.bookcrud.BookCrud;
import com.library.bookcrud.BookCrudFactory;
import com.library.donationcrud.IDonation;
import com.library.membercrud.IMember;
import com.library.membercrud.MemberCrudFactory;
import com.library.ordercrud.IOrder;


public class EmployeeActivator implements BundleActivator {

	
	ServiceRegistration<?> empRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		
		EmployeeImpl empActivator = new EmployeeImpl();
		empRegistration = bundleContext.registerService(EmployeeImpl.class.getName(), empActivator, null);
		
		
		
		
		}

		

	
	public void stop(BundleContext bundleContext) throws Exception {
		empRegistration.unregister();
	}

}
