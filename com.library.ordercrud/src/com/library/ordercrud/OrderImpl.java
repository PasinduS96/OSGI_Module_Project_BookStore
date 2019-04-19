package com.library.ordercrud;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderImpl implements IOrder {

	@Override
	public void createOrderS() {
		
		boolean terminate = true;
		String fileName;

		try 
	    {
				System.out.println("Enter Invoice ID: ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				fileName = br.readLine();
				
				
	              File fileToBeCreate = new File("/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Orders/"+fileName+".txt");

	              if (!fileToBeCreate.exists()) 
	              {
	            	  fileToBeCreate.createNewFile();
	              }
	              else {
	            	  
	            	  System.out.println("Order ID Already Exsits! Enter New Order ID");
	            	  
	            	System.out.println("Enter Invoice ID: ");
	  				BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
	  				fileName = breader.readLine();
	  				
	  				File fileToBeCreated = new File("/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Orders/"+fileName+".txt");

	  				fileToBeCreated.createNewFile();
	  				
	            	                	  
	              }

	              FileWriter fileWrite = new FileWriter(fileToBeCreate.getAbsoluteFile());
	              BufferedWriter bufferWrite = new BufferedWriter(fileWrite);
	              Date currentDate = new Date();
	              SimpleDateFormat dateformatter = new SimpleDateFormat("dd MMMMM yyyy");
	              SimpleDateFormat timeformatter = new SimpleDateFormat("h:mm a");
	              
	              bufferWrite.write("Book Order Invoice");
	              bufferWrite.newLine();
	              bufferWrite.newLine();
	              bufferWrite.newLine();
	              bufferWrite.newLine();
	              bufferWrite.write("Date: " + dateformatter.format(currentDate));
	              bufferWrite.newLine();
	              bufferWrite.write("Time: " + timeformatter.format(currentDate));
	            
	              bufferWrite.newLine();
	              bufferWrite.newLine();
	              bufferWrite.write("Book Name"+"				"+"Quantity");
	              bufferWrite.newLine();
	              bufferWrite.newLine();
	              
	              while(terminate) {
	            	  
	            	System.out.println("Enter Book Name: ");
	  				BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	  				String bookName = br1.readLine();
	  				
	  				System.out.println("Enter Quantity: ");
	  				BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
	  				String qty = br2.readLine();
	  				
	      		    bufferWrite.write(bookName+"				"+qty);
	      		    bufferWrite.newLine();
	      		    
	      		    System.out.println("Do you want to continue (YES/NO): ");
					BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
					String ans= br3.readLine();
					
					if(ans.equalsIgnoreCase("No")) {
						
						terminate = false;
					}
					
					bufferWrite.flush();
	      		    
	              }
	          
	              bufferWrite.newLine();
	              //bufferWrite.close();
	              bufferWrite.flush();
	            
	    } 
	    catch (IOException ex) 
	    {
	    	ex.printStackTrace();
	    }

	}

	@Override
	public void modifyOrderS() throws IOException {
		String oldFileContent = "";
	    
	    BufferedReader bufferreader = null;
	     
	    FileWriter filewriter = null;
		
		System.out.println("Enter Invoice ID: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String fileName = br.readLine();
		
		String oldString;
		String newString;
		
		System.out.println("Enter Old Value: ");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		oldString = br.readLine();
		
		System.out.println("Enter New Value: ");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		newString = br.readLine();
		
		
		
	    File modifiedfileName = new File("/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Orders/"+fileName+".txt");
	     
	    try
	    {
	    	bufferreader = new BufferedReader(new FileReader(modifiedfileName));
	         
	         
	        String lineread = bufferreader.readLine();
	         
	        while (lineread != null) 
	        {
	            oldFileContent = oldFileContent + lineread + System.lineSeparator();
	             
	            lineread = bufferreader.readLine();
	        }
	         
	         
	        String newFileContent = oldFileContent.replaceAll(oldString, newString);
	         
	         
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
	public void removeOrder() {
		String fileName = "";

		try
	    { 
			
			System.out.println("Enter Invoice ID: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			fileName = br.readLine();
			
			System.out.println("Do you need to delete "+fileName+" (YES/NO):");
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			String confirmDelete = br2.readLine();
			
			if(confirmDelete.equalsIgnoreCase("YES")) {
				
		        Files.deleteIfExists(Paths.get("/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Orders/"+fileName+".txt")); 
			}
			
	    } 
	    catch(Exception e) 
	    { 
	    	e.printStackTrace();
	      
	    } 
	 
	      
	    System.out.println(fileName+" Has Been Removed");
			
			

		

	}

	@Override
	public void removeOrderEntry() throws IOException {
		System.out.println("Enter Invoice ID: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String fileName = br.readLine();
		 
		System.out.println("Enter Book Name You Need To Remove From Invoice: ");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String record = br1.readLine();
		 
		System.out.println("Do you need to delete "+fileName+" (YES/NO):");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		 String confirmDelete = br2.readLine();
			
		 if(confirmDelete.equalsIgnoreCase("YES")) {
		
		 Path path = Paths.get("/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Orders/"+fileName+".txt");
		 byte[] bytes = Files.readAllBytes(path);
		 List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
		 
		 for(Iterator<String> iterator = allLines.iterator(); iterator.hasNext();) {
			 
			 String s = iterator.next();
			 
			 if(s.contains(record)) {
				 
				 iterator.remove();
			 }
		 }
		 
		 Files.deleteIfExists(Paths.get("/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Orders/"+fileName));
		 		 
	        try {
	        	

	              File fileToBeCreate = new File("/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Orders/"+fileName);

	              if (!fileToBeCreate.exists()) 
	              {
	            	  fileToBeCreate.createNewFile();
	              }
	              
	              FileWriter fileWrite = new FileWriter(fileToBeCreate.getAbsoluteFile());
	              BufferedWriter bufferWrite = new BufferedWriter(fileWrite);
	              
	              for(int i=0; i < allLines.size(); i++) {
	            	  
	            	  String s = allLines.get(i);
	            	  bufferWrite.write(s);
	            	  bufferWrite.newLine();
	            	  bufferWrite.flush();
	              }
	              
	              bufferWrite.close();
	              bufferWrite.flush();
	              
	              System.out.println("Record "+record+" Sucessfully Removed");
	        	
	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	            
	        }
	        
		 
		 }
		
	}

	@Override
	public void addrecord() throws IOException {
		boolean terminate = true;

		try {
			
			System.out.println("Enter Invoice ID: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String fileName = br.readLine();
		
			String destination = "/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Orders/"+fileName+".txt";
			
	        File file = new File(destination);
	    
	        Path path = Paths.get(destination);
			byte[] bytes = Files.readAllBytes(path);
			List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
			 
	        FileWriter fileWrite = new FileWriter(file.getAbsoluteFile());
	        BufferedWriter bufferWrite = new BufferedWriter(fileWrite);
	        
	        for(String str: allLines) {
	        	
	        	bufferWrite.write(str);
	        	bufferWrite.newLine();
	        	bufferWrite.flush();
	        }
	        
	        while(terminate) {
	      	  
	        	System.out.println("Enter Book Name: ");
				BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
				String bookName = br1.readLine();
					
				System.out.println("Enter Quantity: ");
				BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
				String qty = br2.readLine();
					
	  		    bufferWrite.write(bookName+"				"+qty);
	  		    bufferWrite.newLine();
	  		    
	  		    System.out.println("Do you want to continue (yes/no): ");
				BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
				String ans= br3.readLine();
				
				if(ans.equalsIgnoreCase("No")) {
					
					terminate = false;
				}
				
				bufferWrite.flush();
			    
	      }
	  
	      bufferWrite.close();
	      bufferWrite.flush();
	      
		}catch(Exception e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void searchRecordS() throws IOException {

		try {
			 System.out.println("Enter Invoice ID: ");
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 String fileName = br.readLine();
			 
			 System.out.println("Enter Search Value: ");
			 BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			 String searchValue = br.readLine();
			 
			 Path path = Paths.get("/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Orders/"+fileName+".txt");
			 byte[] bytes = Files.readAllBytes(path);
			 List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
			 
			 for(String str: allLines) {
				 
				 if(str.contains(searchValue)) {
					
					 System.out.println();
					 System.out.println("Book Name"+"				"+"Quantity");
					 System.out.println();
					 System.out.println(str);
				 }
			 }
			}catch(Exception e) {
				
				e.printStackTrace();
			}
			 


	}

	@Override
	public void printFileList() throws IOException {
		File filepath = new File("/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Orders/");

	    FilenameFilter filter = new FilenameFilter() {
	        public boolean accept(File dir, String name) {
	            return name.toLowerCase().endsWith(".txt");
	        }
	    };

	    File[] files = filepath.listFiles(filter);
	    
	    System.out.println("Order List");
	    System.out.println();
	    
	    for (File file : files) {
	    
	        System.out.print("Order Name => ");
	        
	        System.out.println(file.getName());
	    }

	}

	@Override
	public void viewOrderS() {
		try {
			 
			 System.out.println("Enter Invoice ID: ");
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 String fileName = br.readLine();
			
			 Path path = Paths.get("/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Orders/"+fileName+".txt");
			 byte[] bytes = Files.readAllBytes(path);
			 List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
			 
			 for(String el : allLines){
				 
					System.out.println(el);
				}
			 
			 }catch(Exception e) {
				 
				 e.printStackTrace();
			 }

		
	}

}
