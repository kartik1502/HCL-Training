package com.javaproject.javaserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.javaproject.javaoopsconcept.Book;

public class SerializableDriver {
	public static void main(String[] args) {
		try{
			FileOutputStream fp = new FileOutputStream("D:\\book.txt");
			ObjectOutputStream out = new ObjectOutputStream(fp);
			out.writeObject(new Book("You are the password to my life",1,250,"Sudeep Nagarkar"));
			fp.close();
			out.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try{
			FileInputStream fp = new FileInputStream("D:\\book.txt");
			ObjectInputStream out = new ObjectInputStream(fp);
			Book b = (Book)out.readObject();
			System.out.println("Book Name: "+b.bookName+"\nBook Id: "+b.bookId+"\nBook Price: "+b.price+"\nAuthor Name: "+b.authorName);
			out.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
