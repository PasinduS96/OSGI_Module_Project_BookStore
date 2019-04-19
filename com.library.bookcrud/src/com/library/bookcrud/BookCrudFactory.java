package com.library.bookcrud;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

public class BookCrudFactory implements ServiceFactory{

	@Override
	public Object getService(Bundle arg0, ServiceRegistration arg1) {
		BookCrud bookCrud = new BookCrudImpl();
		return bookCrud;
	}

	@Override
	public void ungetService(Bundle arg0, ServiceRegistration arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

}
