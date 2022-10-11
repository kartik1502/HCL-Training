package com.javaproject.javafilehandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			FileOutputStream out = new FileOutputStream("D:\\file.txt",true);
			out.write(104);
			out.write(110);
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

}
