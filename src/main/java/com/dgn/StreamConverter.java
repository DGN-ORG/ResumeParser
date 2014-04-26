package com.dgn;

import java.io.*;  
import java.util.*;  
   
public class StreamConverter {  
   
   static void writeOutput(String str) {  
   
       try {  
           FileOutputStream fos = new FileOutputStream("/home/hduser/text1.txt");  
           Writer out = new OutputStreamWriter(fos, "ASCII");  
           out.write(str);  
           out.close();  
       } catch (IOException e) {  
           e.printStackTrace();  
       }  
   }  
   
   static String readInput() {  
   
      StringBuffer buffer = new StringBuffer();  
      try {  
          FileInputStream fis = new FileInputStream("/home/hduser/Downloads/Ruby_Chandravanshi.doc");  
          InputStreamReader isr = new InputStreamReader(fis, "ASCII");  
          Reader in = new BufferedReader(isr);  
          int ch;  
          while ((ch = in.read()) > -1) {  
             buffer.append((char)ch);  
          }  
          in.close();  
          return buffer.toString();  
      } catch (IOException e) {  
          e.printStackTrace();  
          return null;  
      }  
   }  
   
   public static void main(String[] args) {  
   
      String inputString = readInput();  
   writeOutput(inputString);  
       
   }  
   
}  
