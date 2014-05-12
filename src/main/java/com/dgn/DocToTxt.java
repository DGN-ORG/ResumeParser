
/* This Program extracts text from .DOC and .DOCX files and save them in a text file.
 * So you need to call the extract function with following arguments :-
 * 		1.Input File (java.io.File Object)
 * 		2.Directory where text output files will be saved.
 * Name of Output File will be original file name + .txt.
 */
package com.dgn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.POITextExtractor;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.Word6Extractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xslf.extractor.XSLFPowerPointExtractor;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;
import org.xml.sax.SAXException;

import java.io.*;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.*;
public class DocToTxt {
	
	public static void extract(File file, String outDir)
	{
		String result="";
		String outFileName = null;
		POITextExtractor extractor = null;
		boolean filefound=false;
		
		try {

		
		FileInputStream fis = new FileInputStream(file.getAbsolutePath());
		

		if (file.getName().toLowerCase().endsWith(".docx")) 
		{
		    XWPFDocument doc = new XWPFDocument(fis);
		    extractor = new XWPFWordExtractor(doc);
		    filefound=true;
		    
		} 
		 
		if (file.getName().toLowerCase().endsWith(".doc")) 
		{
			HWPFDocument doc = new HWPFDocument(fis);
		    extractor=new WordExtractor(doc);
		    filefound=true;
		}
		
		if(filefound)
		{
			System.out.println("Processing :"+file.getAbsolutePath());
		    outFileName = file.getName() + ".txt";
			
			result = extractor.getText();
			File outFile = new File(outDir+"/"+outFileName);
			Writer output = new BufferedWriter(new FileWriter(outFile));
	
			
				output.write(result);
				output.close();
		}
		else
		{
			System.out.println("Skipping  :"+file.getAbsolutePath()+" Not A Word Document");
		}
		
		} catch (Exception exep)
		{
			exep.printStackTrace();
			System.out.println("Exception  :");
		}
		
	}
public static void main(String[] args) throws IOException {

	File inputDir = new File("/home/dgn/ResumeParser/sourceresumes");
	String outDir = "/home/dgn/ResumeParser/textresumes";

	for(File f:inputDir.listFiles())
	{
		extract(f,outDir);
	}
  }
}
 

