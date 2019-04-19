package com.library.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.library.bookcrud.BookCrud;
import com.library.donationcrud.IDonation;
import com.library.membercrud.IMember;
import com.library.ordercrud.IOrder;

public class MainImpl implements IMain {

	@Override
	public void runner(IOrder order, BookCrud book, IDonation donate, IMember member) throws IOException {
		boolean term = true;
		
		while(term) {
		System.out.println ("*********************WELCOME*********************");
		System.out.println ("************LIBRARY MANAGEMENT SYSTEM************");
		System.out.println("Select Your Option : \n");
		System.out.println("1. Manage Books : \n");
		System.out.println("2. Manage Members : \n");
		System.out.println("3. Manage Orders : \n");
		System.out.println("4. Manage Donations : \n");
		System.out.println("5. Exit : \n");
		System.out.print("Select Your Option : ");
		Scanner myObj = new Scanner(System.in); 
		int opt = myObj.nextInt();
		
		if(opt == 1) {
			
			boolean terminator = true;
			
			while(terminator) {
				
					System.out.println ("----------------------------------------");
					System.out.println ("****************Library****************");
					System.out.println ("************Book Management************");
					System.out.println ("----------------------------------------");
					
					System.out.println();
					System.out.println();
					
					System.out.println("1. Add Book ");
					System.out.println("2. Delete Book ");
					System.out.println("3. Read Member Book");
					System.out.println("4. Search Book");
					System.out.println("5. Update Book");
					
					System.out.println("Enter Service KeyWord: ");
					
					Scanner in = new Scanner(System.in);
					int service = in.nextInt();
					
					 
					 
						if(service == 1) {
							
							book.addBooks();
							
							System.out.println();
							System.out.println("Do you want to continue (yes/no): ");
							BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
							String ans= br3.readLine();
							
							if(ans.equalsIgnoreCase("No")) {
								
								terminator = false;
							}
						}
						if(service == 2) {
							
							book.deleteBooks();
							

							System.out.println();
							System.out.println("Do you want to continue (yes/no): ");
							BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
							String ans= br3.readLine();
							
							if(ans.equalsIgnoreCase("No")) {
								
								terminator = false;
							}
						}
						if(service == 3) {
							
							book.readBook();
							

							System.out.println();
							System.out.println("Do you want to continue (yes/no): ");
							BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
							String ans= br3.readLine();
							
							if(ans.equalsIgnoreCase("No")) {
								
								terminator = false;
							}
						}
						if(service == 4) {
							
							book.searchBook();
							
							System.out.println();
							System.out.println("Do you want to continue (yes/no): ");
							BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
							String ans= br3.readLine();
							
							if(ans.equalsIgnoreCase("No")) {
								
								terminator = false;
							}
						}
						if(service == 5) {
							
							book.updateBook();
							

							System.out.println();
							System.out.println("Do you want to continue (yes/no): ");
							BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
							String ans= br3.readLine();
							
							if(ans.equalsIgnoreCase("No")) {
								
								terminator = false;
							}
						}
						

			}}else if(opt == 2) {

			boolean terminator = true;
					
			while(terminator) {
				
					System.out.println ("----------------------------------------");
					System.out.println ("*****************Library*****************");
					System.out.println ("************Member Management************");
					System.out.println ("----------------------------------------");
					
					System.out.println();
					System.out.println();
					
					System.out.println("1. Add Member KeyWord  ");
					System.out.println("2. Delete Member KeyWord ");
					System.out.println("3. Read Member KeyWord ");
					System.out.println("4. Search Member KeyWord ");
					System.out.println("5. Update Member KeyWord");
					System.out.println("6. Calculate Fee KeyWord");
					
					System.out.println("Enter Service KeyWord: ");
					
					Scanner in = new Scanner(System.in);
					int service = in.nextInt();
					
					 
					 
						if(service == 1) {
							
							member.addMember();
							
							System.out.println();
							System.out.println("Do you want to continue (yes/no): ");
							BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
							String ans= br3.readLine();
							
							if(ans.equalsIgnoreCase("No")) {
								
								terminator = false;
							}
						}
						if(service == 2) {
							
							member.deleteMember();
							

							System.out.println();
							System.out.println("Do you want to continue (yes/no): ");
							BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
							String ans= br3.readLine();
							
							if(ans.equalsIgnoreCase("No")) {
								
								terminator = false;
							}
						}
						if(service == 3) {
							
							member.readMember();
							

							System.out.println();
							System.out.println("Do you want to continue (yes/no): ");
							BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
							String ans= br3.readLine();
							
							if(ans.equalsIgnoreCase("No")) {
								
								terminator = false;
							}
						}
						if(service == 4) {
							
							member.searchMember();
							
							System.out.println();
							System.out.println("Do you want to continue (yes/no): ");
							BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
							String ans= br3.readLine();
							
							if(ans.equalsIgnoreCase("No")) {
								
								terminator = false;
							}
						}
						if(service == 5) {
							
							member.updateMember();
							

							System.out.println();
							System.out.println("Do you want to continue (yes/no): ");
							BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
							String ans= br3.readLine();
							
							if(ans.equalsIgnoreCase("No")) {
								
								terminator = false;
							}
						}
						if(service == 6) {
							
							member.calculation();
							

							System.out.println();
							System.out.println("Do you want to continue (yes/no): ");
							BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
							String ans= br3.readLine();
							
							if(ans.equalsIgnoreCase("No")) {
								
								terminator = false;
							}
						}
				
		}
		}else if(opt == 3) {
			boolean terminate = true;
			
			System.out.println ("----------------------------------------");
			System.out.println ("****************Library*****************");
			System.out.println ("************Order Management************");
			System.out.println ("----------------------------------------");
			
			System.out.println();
			
			while(terminate) {
				
				System.out.println("1.Create Order:");
				System.out.println("2.View Order: ");
				System.out.println("3.Delete Order:");
				System.out.println("4.Update Oder: ");
				System.out.println("5.Update Exsisting Record Order: ");
				System.out.println("6.Add New Record: ");
				System.out.println("7.Search Record: ");
				System.out.println("8.Print File List: ");
				System.out.println();
			
			System.out.println();
			System.out.println("Enter Service KeyWord: ");
			
			Scanner in = new Scanner(System.in);
			int servicetype = in.nextInt();
			
			System.out.println();
			
			
			if(servicetype == 1) {
				
				order.createOrderS();
				
				System.out.println();
				System.out.println("Do you want to continue (yes/no): ");
				BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
				String ans= br3.readLine();
				
				if(ans.equalsIgnoreCase("No")) {
					
					terminate = false;
				}
			}
			if(servicetype == 2) {
				
				order.viewOrderS();
				
				System.out.println();
				System.out.println("Do you want to continue (yes/no): ");
				BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
				String ans= br3.readLine();
				
				if(ans.equalsIgnoreCase("No")) {
					
					terminate = false;
				}
			}
			if(servicetype == 3) {
				
				order.removeOrder();
				
				System.out.println();
				System.out.println("Do you want to continue (yes/no): ");
				BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
				String ans= br3.readLine();
				
				if(ans.equalsIgnoreCase("No")) {
					
					terminate = false;
				}
			}
			if(servicetype == 4) {
				
				order.modifyOrderS();
				
				System.out.println();
				System.out.println("Do you want to continue (yes/no): ");
				BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
				String ans= br3.readLine();
				
				if(ans.equalsIgnoreCase("No")) {
					
					terminate = false;
				}
			}
			if(servicetype == 5) {
				
				order.removeOrderEntry();
				
				System.out.println("Do you want to continue (yes/no): ");
				BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
				String ans= br3.readLine();
				
				if(ans.equalsIgnoreCase("No")) {
					
					terminate = false;
				}
			}
			if(servicetype == 6) {
				
				order.addrecord();
				
				System.out.println();
				System.out.println("Do you want to continue (yes/no): ");
				BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
				String ans= br3.readLine();
				
				if(ans.equalsIgnoreCase("No")) {
					
					terminate = false;
				}
			}
			if(servicetype == 7) {
				
				order.searchRecordS();
				
				System.out.println("Do you want to continue (yes/no): ");
				BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
				String ans= br3.readLine();
				
				if(ans.equalsIgnoreCase("No")) {
					
					terminate = false;
				}
			}
			if(servicetype == 8) {
				
				order.printFileList();;
				
				System.out.println("Do you want to continue (yes/no): ");
				BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
				String ans= br3.readLine();
				
				if(ans.equalsIgnoreCase("No")) {
					
					terminate = false;
				}
			}
			
			}
		}else if(opt == 4) {
boolean terminate = true;
			
			System.out.println ("----------------------------------------");
			System.out.println ("****************Library*****************");
			System.out.println ("***********Donation Management**********");
			System.out.println ("----------------------------------------");
			
			System.out.println();
			
			while(terminate) {
				
				System.out.println("1.Add Donation:");
				System.out.println("2.View Donation: ");
				System.out.println("3.Delete Donation:");
				System.out.println();
			
			System.out.println();
			System.out.println("Enter Service KeyWord: ");
			
			Scanner in = new Scanner(System.in);
			int servicetype = in.nextInt();
			
			System.out.println();
			
			
			if(servicetype == 1) {
				
				donate.addDonation();
				
				System.out.println();
				System.out.println("Do you want to continue (yes/no): ");
				BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
				String ans= br3.readLine();
				
				if(ans.equalsIgnoreCase("No")) {
					
					terminate = false;
				}
			}
			if(servicetype == 2) {
				
				donate.readDonations();
				
				System.out.println();
				System.out.println("Do you want to continue (yes/no): ");
				BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
				String ans= br3.readLine();
				
				if(ans.equalsIgnoreCase("No")) {
					
					terminate = false;
				}
			}
			if(servicetype == 3) {
				
				donate.deleteDonation();
				
				System.out.println();
				System.out.println("Do you want to continue (yes/no): ");
				BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
				String ans= br3.readLine();
				
				if(ans.equalsIgnoreCase("No")) {
					
					terminate = false;
				}
			}
			
			}
		}else if(opt == 5) {
			System.exit(0);	
		}
		
		System.out.println();
		System.out.println("Do you want to go to the MAIN MENU (yes/no): ");
		BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
		String ans= br3.readLine();
		
		if(ans.equalsIgnoreCase("No")) {
			System.exit(0);	
		}else if(ans.equalsIgnoreCase("Yes")) {
			term = false;
		}
		}


	}

}
