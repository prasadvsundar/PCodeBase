package com.nanobi.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import base.BasePage;
import generics.CompareCSV;

public class VerifyAPIPage extends BasePage
{
    
    private static final int BUFFER_SIZE = 4096;
    
    public VerifyAPIPage(WebDriver driver, ExtentTest testReport) 
    {
        super(driver, testReport);
        PageFactory.initElements(driver,this);
    }

    
    
    
    /**
     * Downloads a file from a URL
     * @param fileURL HTTP URL of the file to be downloaded
     * @param saveDir path of the directory to save the file
     * @throws IOException
     */
    public static void downloadFile(String CSURL,String analyticid, String token,String saveDir)
            throws IOException {
        
       String csurl = CSURL+analyticid+"/data?&t="+ token;
       System.out.println("Contentserver URL:" +csurl );
        
       URL url = new URL(csurl);
       HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
       int responseCode = httpConn.getResponseCode();
       System.out.println("Response code :" +responseCode);
        
 
        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();

           if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
                // extracts file name from URL
                fileName = csurl.substring(csurl.lastIndexOf("/") + 1,
                        csurl.length());
            }

           System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName); 

           // opens input stream from the HTTP connection
            
           InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;
            //d:temo/file.json
      //      String saveFilePath = saveDir;
                    
           // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);

           int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                
           }

           outputStream.close();
            inputStream.close();

           System.out.println("File downloaded");
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }
