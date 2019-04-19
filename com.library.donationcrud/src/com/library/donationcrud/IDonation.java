package com.library.donationcrud;

import java.io.IOException;

public interface IDonation {

	public void addDonation();
	public void deleteDonation();
	public void readDonations();
	public void searchDonations() throws IOException ;
	public void updateDonations() throws IOException;
	
}
