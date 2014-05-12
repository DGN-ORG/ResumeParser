package com.dgn;

//package com.dgn;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.POITextExtractor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
 
public class PDFtoText {
 
	// Extract text from PDF Document
	public static void pdftoText(File file, String outDir) {
		PDFParser parser;
		String parsedText = null;;
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		boolean filefound=false;
		String outFileName = null;
		String result="";

		try {
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());
			if (file.getName().toLowerCase().endsWith(".pdf")) {
				filefound = true;

			}

			if (filefound) {

			outFileName  = file.getName() + ".txt";	System.out.println("Processing :" + file.getAbsolutePath());
			

				try {
					parser = new PDFParser(new FileInputStream(file));
				} catch (IOException e) {
					System.err.println("Unable to open PDF Parser. "
							+ e.getMessage());
				}
				try {
					parser = new PDFParser(new FileInputStream(file));
					parser.parse();
					cosDoc = parser.getDocument();
					pdfStripper = new PDFTextStripper();
					pdDoc = new PDDocument(cosDoc);
					pdfStripper.setStartPage(1);
					pdfStripper.setEndPage(5);
					parsedText = pdfStripper.getText(pdDoc);
				} catch (Exception e) {
					System.err
							.println("An exception occured in parsing the PDF Document."
									+ e.getMessage());
				} finally {
					try {
						if (cosDoc != null)
							cosDoc.close();
						if (pdDoc != null)
							pdDoc.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				result = parsedText;

				File outFile = new File(outDir + "/" + outFileName);
				Writer output = new BufferedWriter(new FileWriter(outFile));

				output.write(result);
				output.close();
			} else {
				System.out.println("Skipping  :" + file.getAbsolutePath()
						+ " Not A Pdf Document");
			}

		} catch (Exception exep) {
			exep.printStackTrace();
			System.out.println("Exception  :");
		}

	}

	public static void main(String args[]) {
		
		File inputDir = new File("/dev/tools/ResumeParser/sourceresumes");
		String outDir = "/dev/tools/ResumeParser/textresumes";

		for (File f : inputDir.listFiles()) {
			pdftoText(f, outDir);
		}
	}
}