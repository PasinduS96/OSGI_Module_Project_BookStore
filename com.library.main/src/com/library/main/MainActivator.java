package com.library.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import com.library.bookcrud.BookCrud;
import com.library.donationcrud.IDonation;
import com.library.membercrud.IMember;
import com.library.ordercrud.IOrder;


public class MainActivator implements BundleActivator {


	ServiceReference bookStoreReference;
	ServiceReference addBookReference;
	ServiceReference memberReference;
	ServiceReference orderReference;
	ServiceReference donateReference;
	
	ServiceRegistration<?> mainRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		
		
		IMain mainActivator = new MainImpl();
		mainRegistration = bundleContext.registerService(IMain.class.getName(), mainActivator, null);
		
		
		
		
		
		
		}
		

	
	public void stop(BundleContext bundleContext) throws Exception {
		mainRegistration.unregister();
	}

}
