package com.library.membercrud;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class MemberImpl implements IMember {

	public void addMember() {
		// TODO Auto-generated method stub
		String filepath = "/Projects/Java/BookManagementService/Members/Member.txt";
		boolean term = true;
		
		while(term) {
		
		try {
			
			int mid = 0 ; String name =""; String nic = "";String type="";
			
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the Member ID    :");
			mid=s.nextInt();
			System.out.println("Enter the Member Name    :");
			name=s.next();
			System.out.println("Enter the Member type    :");
			type=s.next();
			System.out.println("Enter the Member nic    :");
			nic=s.next();
			
			
			FileWriter fw = new FileWriter(filepath,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(mid+","+name+","+type+","+nic);
			pw.flush();
			pw.close();
			
			
			
			System.out.println();
			System.out.println("Record Saved!");
			

			System.out.println();
			System.out.println("Do you want to continue (yes/no): ");
			BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
			String ans= br3.readLine();
			
			if(ans.equalsIgnoreCase("No")) {
				
				term = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		}

}

	@Override
	public void deleteMember() {
		int removeTerm;
		String filepath = "/Projects/Java/BookManagementService/Members/Member.txt";
		String tempFile =  "/Projects/Java/BookManagementService/Members/temp.txt";
		
		
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		
		int mid = 0 ; String name =""; String nic = "";String type="";
		
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
				mid = x.nextInt();
				name = x.next();
				type = x.next();
				nic=x.next();
				
				
				
				if(mid != removeTerm) {
					pw.println(mid+","+name+","+type+","+nic);
				}else {
					System.out.println("***** "+ name + " " +  type +"  "+ nic + ""+ "is Succesfully Deleted"+" *****");
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
	public void readMember() {
		String filepath = "/Projects/Java/BookManagementService/Members/Member.txt";
		
		File oldFile = new File(filepath);
		
		int mid = 0 ; String name =""; String type = ""; String nic="";
		

		boolean found = true;
		
		try {
			
			System.out.println ("\n-----------------------------");
			System.out.println ("Book Store - View All Members");
			System.out.println ("-----------------------------");
			System.out.format("%10s%15s%15s%15s", "mid", "Member Name", "Member type","  Member nic","");
			System.out.println("");

			
			Scanner x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
			
				mid = x.nextInt();
				name = x.next();
				type = x.next();
				nic = x.next();
				
				
				if(mid > 0) {
					System.out.format ("%10s%15s%15s%15s", ""+mid, name, type,nic,"");	
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
	public void searchMember() throws IOException {
		try {
			 System.out.println("Enter Member ID: ");
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 String memberID = br.readLine();
			 
			 Path path = Paths.get("/Projects/Java/BookManagementService/Members/Member.txt");
			 byte[] bytes = Files.readAllBytes(path);
			 List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);

			 for(String str: allLines) {
				 if(str.contains(memberID)) {
					 System.out.println ("\n-----------------------------");
						System.out.println ("Book Store - Search Members");
						System.out.println ("-----------------------------");
						System.out.format("mid"+"	"+"Name"+"	"+"type"+"	"+" nic");
						System.out.println("");
							
					 System.out.println(str);
				 }
			 }
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void updateMember() throws IOException {
		String oldFileContent = "";
	    BufferedReader bufferreader = null;
	    FileWriter filewriter = null;
	    
		System.out.println("Enter Member ID: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String memberID = br.readLine();

		String oldString;
		String newString;

		System.out.println("Enter Old Value: ");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		oldString = br.readLine();
		
		System.out.println("Enter New Value: ");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		newString = br.readLine();
		

	    File modifiedfileName = new File("/Projects/Java/BookManagementService/Members/Member.txt");
	   
	    
	    try
	    {
	    	bufferreader = new BufferedReader(new FileReader(modifiedfileName));
            String lineread = bufferreader.readLine();
          
             
	        	while (lineread != null) 
	        	{
	        			oldFileContent = oldFileContent + lineread + System.lineSeparator();
	        			lineread = bufferreader.readLine();
	        	}
	         

	        String newFileContent = oldFileContent.replace(oldString, newString);
	        filewriter = new FileWriter(modifiedfileName);
	        
	        filewriter.write(newFileContent);
	        
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    finally
	    {
	        try
	        {
                bufferreader.close();
	             filewriter.close();
	        } 
	        catch (IOException e) 
	        {
	            e.printStackTrace();
	        }

	    }
	}

	@Override
	public void calculation() throws IOException {
		Calendar cal=Calendar.getInstance();
		
		int cyear = cal.get(Calendar.YEAR);
		int cmonth = cal.get(Calendar.MONTH) + 1;
		int cday = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println("Year		:   "+cyear);
		System.out.println("Month		:   "+cmonth);
		System.out.println("Date		:   "+cday);
		
		
		System.out.println(" Issued Date " );
		BufferedReader b1=new BufferedReader(new InputStreamReader(System.in));
		
		String issueDate=b1.readLine();
		
		String iyear=issueDate.substring(0, 4);
		int years=(cyear - Integer.parseInt(iyear));
		System.out.println("year		:"+years);
		
		
	
		
		String imonth=issueDate.substring(5, 7);
		int month=(cmonth - Integer.parseInt(imonth));
		System.out.println("month		:"+month);
		
		String idate=issueDate.substring(8, 10);
		int day=(cday - Integer.parseInt(idate));
		System.out.println("day		:"+ day);
		
	
		int totalDays = day + (month * 30 ) + (years * 365);
		
		System.out.println("Total Days       : " +totalDays);
		int totalFee = 0;
		
		if(totalDays > 7) {
			totalFee = (totalDays - 7 ) * 50;
			System.out.println("points calculated");
			System.out.println("total cost  " + totalFee);
		}
		
		else {
			System.out.println("no points calculated");
		}
		
		
	
	}
		
	}

	
	


