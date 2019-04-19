package com.library.membercrud;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class MemberActivator implements BundleActivator {

	ServiceRegistration<?> memberCrudRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		MemberCrudFactory memberCrudFactory = new MemberCrudFactory();
		memberCrudRegistration = bundleContext.registerService(IMember.class.getName(), memberCrudFactory, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		memberCrudRegistration.unregister();
	}

}
