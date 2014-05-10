package com.dgn;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

public class RTFtoTextConverter {

	public static String coverttoText(String rtfText) {
		byte[] rtfBytes = rtfText.getBytes();
		RTFEditorKit rtfParser = new RTFEditorKit();
		Document document = rtfParser.createDefaultDocument();
		try {
			rtfParser.read(new ByteArrayInputStream(rtfBytes), document, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String text = "";
		try {
			text = document.getText(0, document.getLength());
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return text;
	}
}
