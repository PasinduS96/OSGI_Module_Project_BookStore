package com.library.ordercrud;

import java.io.IOException;

public interface IOrder {
	
	public void createOrderS();
	public void modifyOrderS() throws IOException;
	public void removeOrder();
	public void viewOrderS();
	public void removeOrderEntry() throws IOException;
	public void addrecord() throws IOException;
	public void searchRecordS() throws IOException;
	public  void printFileList() throws IOException;

}
