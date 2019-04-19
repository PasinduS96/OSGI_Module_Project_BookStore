package com.library.donationcrud;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class DonationActivator implements BundleActivator {

	ServiceRegistration<?> donationCrudRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {
		DonationCrudFactory donateCrudFactory = new DonationCrudFactory();
		donationCrudRegistration = bundleContext.registerService(IDonation.class.getName(), donateCrudFactory, null);
	}


	public void stop(BundleContext bundleContext) throws Exception {
		donationCrudRegistration.unregister();
	}

}
