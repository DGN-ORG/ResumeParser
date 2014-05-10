package com.dgn;

import java.util.*;
import java.io.*;

public class Readfile {

private BufferedReader x;
	public void openFile()
	{
		try
		{
			x=new BufferedReader(new FileReader(new File("/home/dgn/ResumeParser/sourceresumes/RashmiGautamResume.rtf")));
		}
		catch(Exception err)
		{
			System.out.println("This file couldn't find" );
		}
	}	
	
	public String readFile()
	{
		StringBuffer sb = new StringBuffer();
		try
		{
			String str;
			while((str = x.readLine())!= null)
			{
				sb.append(str);
				sb.append("\n");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error reading the file");
		}
		return sb.toString();
	}

	public void closeFile()
	{
		try
		{
			x.close();
		}
		catch(Exception e)
		{
			System.out.println("Error closing the file");
		}
	}
}
