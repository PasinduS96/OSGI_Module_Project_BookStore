package com.library.bookcrud;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class CrudActivator implements BundleActivator {

	ServiceRegistration<?> bookCrudRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		BookCrudFactory bookCrudFactory = new BookCrudFactory();
		bookCrudRegistration = bundleContext.registerService(BookCrud.class.getName(), bookCrudFactory, null);
	}

	
	public void stop(BundleContext bundleContext) throws Exception {
		bookCrudRegistration.unregister();
	}

}
