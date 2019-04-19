package com.library.donationcrud;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class DonationImpl implements IDonation {
	
	private static Scanner x;

	@Override
	public void addDonation() {
		String filepath = "/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Donation.txt";
		
		try {
			
			int did = 0 ; String name ="" ;String bname;
			
			
			
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the Donation ID    :");
			did=s.nextInt();
			System.out.println("Enter the Donator's Name    :");
			name=s.next();
			System.out.println("Enter Book Title    :");
			bname = s.next();
			
			
			FileWriter fw = new FileWriter(filepath,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(did+","+name+","+bname);
			
			
			pw.flush();
			pw.close();
			
			
			
			System.out.println();
			System.out.println("Record Saved!");
			

			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void deleteDonation() {
		int removeTerm;
		String filepath = "/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Donation.txt";
		String tempFile =  "/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/temp.txt";
		
		
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		
		int did = 0 ; String name ="" ;String bname;
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the remover Term :");
		removeTerm=s.nextInt();
		boolean found = true;
		
		try {
			
			FileWriter fw = new FileWriter(tempFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			
			Scanner x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				did = x.nextInt();
				name = x.next();
				bname = x.next();
				
				
				
				if(did != removeTerm) {
					pw.println(did+","+name+","+bname);
				}else {
					System.out.println("***** "+ name + " " +  bname + " "+ "is Succesfully Deleted"+" *****");
					found = false;
					
				}
				
				
				
				
			}
			
			if(found == true) {
				System.out.println("No Entry Found");
			}
			
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump = new File(filepath);
			newFile.renameTo(dump);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		


	}

	@Override
	public void readDonations() {
String filepath = "/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Donation.txt";
		
		File oldFile = new File(filepath);
		
		int did = 0 ; String name ="" ;String bname;
		

		boolean found = true;
		
		try {
			
			System.out.println ("\n-----------------------------");
			System.out.println ("Book Store - View All Members");
			System.out.println ("-----------------------------");
			System.out.format("%10s%15s%15s", "did", "Donators Name", "Book","");
			System.out.println("");

			
			Scanner x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
			
				did = x.nextInt();
				name = x.next();
				bname = x.next();
				
				
				if(did > 0) {
					System.out.format ("%10s%15s%15s", ""+did, name,bname+"");	
					System.out.println("");
				}else {
					
					found = false;
					
				}
				
				
				
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

		
	}

	@Override
	public void searchDonations() throws IOException {
		try {
			 System.out.println("Enter Donation ID: ");
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 String memberID = br.readLine();
			 
			 Path path = Paths.get("/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Donation.txt");
			 byte[] bytes = Files.readAllBytes(path);
			 List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);

			 for(String str: allLines) {
				 if(str.contains(memberID)) {
					 System.out.println ("\n-----------------------------");
						System.out.println ("Book Store - Search Donations");
						System.out.println ("-----------------------------");
						System.out.format("mid"+"	"+"Name"+"	"+"Book");
						System.out.println("");
							
					 System.out.println(str);
				 }
			 }
			}catch(Exception e) {
				e.printStackTrace();
			}
		

	}

	@Override
	public void updateDonations() throws IOException {
		// TODO Auto-generated method stub

	}

}
