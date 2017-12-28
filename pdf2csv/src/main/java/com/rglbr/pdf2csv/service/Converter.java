package com.rglbr.pdf2csv.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.pdfbox.PDFBox;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFText2HTML;
import org.apache.pdfbox.util.PDFTextStripper;

public class Converter {
	
	public static void main(String[] args) {
		String s="/home/nanobi/Prasad/Develop/Bank Stm Formats/HDFC_CA1.pdf";
	//	if(s.length == 1){
			File inputFile = new File(s);
			if(inputFile.exists()){
				System.out.println("Input File:"+inputFile.getAbsolutePath());
				Converter converter = new Converter();
				
				File txtFile = converter.convertPDFtoText(inputFile,s);
				/*
				File txtFile = converter.convertPDFtoText(inputFile);
				assert(txtFile.exists());
				System.out.println("Text File:"+txtFile.getAbsolutePath());								
				
				File csvFile = converter.convertTextToCSV(txtFile);
				assert(csvFile.exists());
				System.out.println("CSV File:"+csvFile.getAbsolutePath());*/
								
			}else{
				System.out.println("File does not exist:"+inputFile.getAbsolutePath());
			}
		/*}else{
			System.out.println("Invalid arguments");
		}*/
	}
	
	public File convertPDFtoText(File inputFile) {
		try {
			String newFileName = replaceSuffix(inputFile.getName(), ".txt");
			String newPath = inputFile.getAbsoluteFile().getParent()+File.separator+newFileName;
			File outFile = new File(newPath);
			PDDocument document = PDDocument.load(inputFile);
			
			PDFTextStripper stripper = new PDFTextStripper();
			stripper.writeText(document, new FileWriter(outFile));
			return outFile;
		} catch (IOException e) {
			throw new TextConversionFailedException(e);
		}
	}
	public File convertPDFtoText(File inputFile, String s) {
		try {
			String newFileName = replaceSuffix(inputFile.getName(), ".html");
			String newPath = inputFile.getAbsoluteFile().getParent()+File.separator+newFileName;
			File outFile = new File(newPath);
			PDDocument document = PDDocument.load(inputFile);
			
			System.out.println(document.getPageMap());
			System.out.println(document.getPrintable(0));
			
			PDFText2HTML html = new PDFText2HTML(s);
			html.writeText(document, new FileWriter(outFile));
			/*PDFTextStripper stripper = new PDFTextStripper();
			stripper.writeText(document, new FileWriter(outFile));*/
			return outFile;
		} catch (IOException e) {
			throw new TextConversionFailedException(e);
		}
	}

	private class TextConversionFailedException extends RuntimeException {
		private static final long serialVersionUID = 2407350986747774183L;

		public TextConversionFailedException(Exception e) {
			super(e);
		}
	}

	public File convertTextToCSV(File inputFile) {
		try {
			String newFileName = replaceSuffix(inputFile.getName(), ".csv");
			String newPath = inputFile.getAbsoluteFile().getParent()+File.separator+newFileName;
			Scanner scanner = new Scanner(inputFile);
			File outFile = new File(newPath);
			PrintWriter writer = new PrintWriter(outFile);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String result = convertLineToCSV(line);
				if (result != null)
					writer.println(result);
			}
			writer.close();			
			return outFile;
		} catch (FileNotFoundException e) {
			throw new TextConversionFailedException(e);
		} catch (IOException e) {
			throw new TextConversionFailedException(e);
		}
	}

	public String convertLineToCSV(String line) {
		String[] fields = line.split("\\s+");		
		if (fields.length < 10)
			return null;
		// Name Symbol Bid Ask Open High Low Close Volume Value Net Foreign
		StringBuilder builder = new StringBuilder();
		for (int i = 10; i >= 1; i--) {
			if (i < 10)
				builder.append("|");
			builder.append(fields[fields.length - i].replace(",", ""));
		}
		String result = builder.toString();
		if (isQuoteLine(result))
			return result;
		return null;
	}

	public static boolean isQuoteLine(String line) {
		String pattern = "[A-Z0-9]+" + "\\|(\\-)?(\\d+(\\.\\d+)?)?"
				+ "\\|(\\-)?(\\d+(\\.\\d+)?)?" + "\\|(\\-)?(\\d+(\\.\\d+)?)?"
				+ "\\|(\\-)?(\\d+(\\.\\d+)?)?" + "\\|(\\-)?(\\d+(\\.\\d+)?)?"
				+ "\\|(\\-)?(\\d+(\\.\\d+)?)?" + "\\|(\\-)?(\\d+(\\.\\d+)?)?"
				+ "\\|(\\-)?(\\d+(\\.\\d+)?)?" + "\\|(\\-)?(\\(?\\d+(\\.\\d+)?\\)?)?";
		return Pattern.matches(pattern, line);
	}

	public static String replaceSuffix(String fileName, String suffix) {
		int index = fileName.indexOf('.', 0);
		// check if fileName contains a '.'
		if (index != -1) {
			// find index of last '.'
			int lastIndex = index;
			while (index != -1) {
				index = fileName.indexOf('.', lastIndex + 1);
				if (index != -1)
					lastIndex = index;
			}
			return fileName.substring(0, lastIndex) + suffix;
		} else {// fileName has no '.'
			return fileName + "suffix";
		}
	}
}