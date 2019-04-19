package com.library.main;

import java.io.IOException;

import com.library.bookcrud.BookCrud;
import com.library.donationcrud.IDonation;
import com.library.membercrud.IMember;
import com.library.ordercrud.IOrder;

public interface IMain {
	
	public void runner(IOrder order, BookCrud book,IDonation donate,IMember member) throws IOException;

}
