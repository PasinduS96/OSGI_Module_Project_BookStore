package com.library.donationcrud;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

public class DonationCrudFactory implements ServiceFactory{

	@Override
	public Object getService(Bundle arg0, ServiceRegistration arg1) {
		IDonation donateCrud = new DonationImpl();
		return donateCrud;
	}

	@Override
	public void ungetService(Bundle arg0, ServiceRegistration arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

}
