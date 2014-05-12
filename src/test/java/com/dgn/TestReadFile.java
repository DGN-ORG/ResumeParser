
package com.dgn;

public class TestReadFile {
	
	public static void main(String[] args)
	{
		Readfile testReadFileObj = new Readfile();
		testReadFileObj.openFile();
		String rtfText = testReadFileObj.readFile();
		System.out.println("Contents of file: " + rtfText);
		testReadFileObj.closeFile();
		
		String textFormat = RTFtoTextConverter.coverttoText(rtfText);
		System.out.println("Text extracted from RTF converter: " + textFormat);
		
		Writefile.writeToFile(textFormat);
	}

}

