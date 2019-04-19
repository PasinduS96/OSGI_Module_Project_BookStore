package com.library.ordercrud;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class OrderActivator implements BundleActivator {

	ServiceRegistration<?> orderCrudRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		OrderCrudFactory orderCrudFactory = new OrderCrudFactory();
		orderCrudRegistration = bundleContext.registerService(IOrder.class.getName(), orderCrudFactory, null);

	}

	public void stop(BundleContext bundleContext) throws Exception {
		orderCrudRegistration.unregister();
	}

}
