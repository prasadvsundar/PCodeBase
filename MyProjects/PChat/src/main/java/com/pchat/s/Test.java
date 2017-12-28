package com.pchat.s;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	//@Test(priority = 0)
		public List<Map<String,String>> getUsersFromFile() throws InterruptedException, FileNotFoundException {
			
			 List<Map<String,String>> userList = new ArrayList<Map<String,String>>();
			//signInPage = new SignInPage(driver);	
		   //  Excel=new ExcelLibrary(driver);

			
		String Xlsx="/home/dev/Documents/sowmya/Automation_Test_Document/SignInAutomation_Test_Data.xlsx";
		String sheet="FilePath";
		int rowcount=Excel.getRowcount(Xlsx,sheet);
		//String Username = null;
		//String Password = null;
		for(int i=1;i<=rowcount;i++){
			Map<String,String> userMap = new HashMap<String,String>();
			String Username=Excel.getCellValue(Xlsx, sheet, i, 0);
			String Password= Excel.getCellValue(Xlsx, sheet, i, 1);
	        userMap.put("username", Username);
	        userMap.put("password", Password);
	        userList.add(userMap);
	    }
			
		    return userList;
	   
		}
		
		
		@Test
	public void VerfiySignInwithCorrectData(String Username,String Password) throws FileNotFoundException, InterruptedException {
					
			
			 List<Map<String,String>> userList  = getUsersFromFile();
			for(Map<String,String> map : userList){
				
				String uname = map.get("username");
				String pass = map.get("password");
				if(!uname.equalsIgnoreCase("")&&pass.equalsIgnoreCase("")){
					
				}else{
					
				}
				//System.out.println(key);
				//System.out.println(userMap.get(key));
			}	
			verifySignInFunction();
	    homePage=signInPage.ClickOn_SignInButton(Username, Password);	
	    signInPage.HomePageVerify();
		 signInPage= homePage.Clickon_SignOut_link();
		 		
		}
}
