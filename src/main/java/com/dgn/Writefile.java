package com.dgn;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writefile 
{

	public static void writeToFile(String text)
	{
		BufferedWriter fileWriter;
		try {
			fileWriter = new BufferedWriter(new FileWriter("/home/dgn/ResumeParser/textresumes/RashmiGautamResume.txt"));
			fileWriter.write(text);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
