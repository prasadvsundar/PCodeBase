package com.nanobi.embed;

import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class MyClass {

    public static void main(String[] args) throws Exception {
       // URL url = MyClass.class.getResource("http://shubhf.cloudapp.net:81/contentserver/services/embedUtil/dashboard/87299eaf-3eb3-424c-9c90-d12f428cd659?token=5abcebe1-1558-434f-ba11-457400fa476c");
    	MyClass m = new MyClass();
    	
    	m.genFin();
    }
    
    public void genFin() throws Exception{
    	WebDriver driver;
    	System.setProperty("webdriver.gecko.driver", "/home/nanobi/Re/geckodriver");
    	driver =new FirefoxDriver();
    	
    	
    	
        driver.get("http://shubhf.cloudapp.net:81/contentserver/services/embedUtil/dashboard/87299eaf-3eb3-424c-9c90-d12f428cd659?token=5abcebe1-1558-434f-ba11-457400fa476c");
       
        try {
        	synchronized (this) {
        		wait(10000);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
       /* File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileWriter fw = new FileWriter(scrFile);
        BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);
        System.out.println(scrFile);
        
	    File bfile =new File("/home/nanobi/Prasad/Develop/Bank Stm Formats/Res/p.jpeg");
	    
        InputStream inStream = null;
        OutputStream outStream = null;
        
        inStream = new FileInputStream(scrFile);
        outStream = new FileOutputStream(bfile);

	    byte[] buffer = new byte[1024];

	    int length;
	    //copy the file content in bytes
	    while ((length = inStream.read(buffer)) > 0){

	    	outStream.write(buffer, 0, length);

	    }

	    inStream.close();
	    outStream.close();

	    System.out.println("File is copied successful!");*/
	    
	    
	    
	    
	    
	    
	    
	    Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000)).takeScreenshot(driver);
	    ImageIO.write(screenshot.getImage(), "PNG", new File("/home/nanobi/Prasad/Develop/Bank Stm Formats/Res/p.PNG"));
    }
}