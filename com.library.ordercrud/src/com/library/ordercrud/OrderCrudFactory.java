package com.library.ordercrud;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

public class OrderCrudFactory implements ServiceFactory {

	@Override
	public Object getService(Bundle arg0, ServiceRegistration arg1) {
		IOrder order = new OrderImpl();
		return order;
	}

	@Override
	public void ungetService(Bundle arg0, ServiceRegistration arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

}
