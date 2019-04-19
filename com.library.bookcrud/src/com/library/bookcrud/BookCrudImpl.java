package com.library.bookcrud;

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
import java.util.List;
import java.util.Scanner;

public class BookCrudImpl implements BookCrud {
	
	private static Scanner x;

	@Override
	public void addBooks() {
		
		String filepath = "/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Book.txt";
		
		int isbn;
		String name;
		String author;
		
		Scanner sc = new Scanner(System.in); 
		System.out.println("------ Enter a Book ------\n\n");
		System.out.println("Enter ISBN : ");
		isbn = sc.nextInt();
		
		sc.nextLine(); 
		
		System.out.println("Enter Name : ");
		name = sc.nextLine();
		
		System.out.println("Enter Author : ");
		author = sc.nextLine();
		
		try {
			
			
			
			FileWriter fw = new FileWriter(filepath,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(isbn+","+name+","+author);
			pw.flush();
			pw.close();
			
			System.out.println("Record Saved!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteBooks() {
		
		
		int removeTerm;
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter ISBN to delete : ");
		removeTerm = sc.nextInt();
		
		String filepath = "/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Book.txt";
		String tempFile =  "/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/temp.txt";
		
		
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		
		int isbn = 0 ; String name =""; String author = "";
		

		boolean found = true;
		
		try {
			
			FileWriter fw = new FileWriter(tempFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				isbn = x.nextInt();
				name = x.next();
				author = x.next();
				
				
				
				if(isbn != removeTerm) {
					pw.println(isbn+","+name+","+author);
				}else {
					System.out.println("***** "+name + " book by "+ author + " is Succesfully Deleted"+" *****");
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
	public void readBook() {
		String filepath = "/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Book.txt";		
		
		File oldFile = new File(filepath);
		
		int isbn = 0 ; String name =""; String author = "";
		

		boolean found = true;
		
		try {
			
			System.out.println ("\n-----------------------------");
			System.out.println ("Book Store - View All Books");
			System.out.println ("-----------------------------");
			System.out.format("%10s%15s%15s", "ISBN", "Book Name", "Author");
			System.out.println("");

			
			x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				isbn = x.nextInt();
				name = x.next();
				author = x.next();
				
				
				
				if(isbn > 0) {
					System.out.format ("%10s%15s%15s", ""+isbn, name, author, "");	
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
	public void searchBook() throws IOException {
		try {
			 System.out.println("Enter Book ISBN: ");
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 String BookID = br.readLine();
			 
			 Path path = Paths.get("/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Book.txt");
			 byte[] bytes = Files.readAllBytes(path);
			 List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);

			 for(String str: allLines) {
				 if(str.contains(BookID)) {
					 System.out.println ("\n-----------------------------");
						System.out.println ("Book Store - Search Books");
						System.out.println ("-----------------------------");
						System.out.format("ISBN"+"	"+"Name"+"	"+"Author");
						System.out.println("");
							
					 System.out.println(str);
				 }
			 }
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		
	}

	@Override
	public void updateBook() throws IOException {
		String oldFileContent = "";
	    BufferedReader bufferreader = null;
	    FileWriter filewriter = null;
	    
		System.out.println("Enter Book ID: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bookID = br.readLine();

		String oldString;
		String newString;

		System.out.println("Enter Old Value: ");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		oldString = br.readLine();
		
		System.out.println("Enter New Value: ");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		newString = br.readLine();
		

	    File modifiedfileName = new File("/Users/dulajkavinda/Desktop/SLIIT Y3/SA/Project 01/DataFiles/Book.txt");
	   
	    
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

}
