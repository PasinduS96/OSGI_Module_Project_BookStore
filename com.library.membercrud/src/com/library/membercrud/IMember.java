package com.library.membercrud;

import java.io.IOException;

public interface IMember {

	public void addMember();
	public void deleteMember();
	public void readMember();
	public void searchMember() throws IOException ;
	public void updateMember() throws IOException;
	public void calculation() throws IOException;
	
}
