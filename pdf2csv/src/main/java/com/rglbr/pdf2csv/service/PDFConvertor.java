package com.rglbr.pdf2csv.service;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFConvertor {
	private static PDDocument doc = null;

	public static void main(String[] args) throws IOException {
		if(args.length!=1)
		{
			System.out.println("Usage java -jar pdf2csv-x.y.z.jar <PDFFileLocation>");
		}
		//String file =args[0];
		String file ="/home/nanobi/Prasad/Develop/Bank Stm Formats/Axis_Bank_CA.pdf";
		doc = PDDocument.load(new File(file));
		//if (null != doc.getDocumentCatalog() && null != doc.getDocumentCatalog().getDocumentOutline()) {
			PDDocumentOutline documentOutline = doc.getDocumentCatalog().getDocumentOutline();

			if (null != documentOutline.getFirstChild()) {
				parseOutlineItem(documentOutline.getFirstChild());
			}
		//}
	}

	private static void parseOutlineItem(PDOutlineItem outlineItem) throws IOException {

		PDOutlineItem nextSibling = outlineItem.getNextSibling();
		System.out.println("******" + outlineItem.getTitle() + "******");
		//Parse the children , then Self , then Sibling recursively 
		if (outlineItem.hasChildren()) {
			parseOutlineItem(outlineItem.getFirstChild());
		} else {
			PDFTextStripper textStripper = new PDFTextStripper();
			textStripper.setStartPage(findPageNo(outlineItem));
			if (null != nextSibling) {
				textStripper.setEndPage(findPageNo(nextSibling) - 1);
			}
			System.out.println(textStripper.getText(doc));

		}
		if (null != nextSibling) {
			parseOutlineItem(nextSibling);
		}

	}

	private static int findPageNo(PDOutlineItem outlineItem) throws IOException {
		PDPage page = outlineItem.findDestinationPage(doc);
		// Page numbers start from 0
		return doc.getPages().indexOf(page) + 1;
	}
}
