package com.library.membercrud;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

public class MemberCrudFactory implements ServiceFactory {

	@Override
	public Object getService(Bundle arg0, ServiceRegistration arg1) {
		IMember member = new MemberImpl();
		return member;
	}

	@Override
	public void ungetService(Bundle arg0, ServiceRegistration arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

}
