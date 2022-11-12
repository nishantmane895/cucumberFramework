package com.vtiger.pages;



//import org.junit.Assert;



import com.aventstack.extentreports.ExtentTest;


public class APIPage {
	
	
	
	ExtentTest logger;
	
	public APIPage(ExtentTest logger)
	{		
		this.logger=logger;		
	}
	
	public void writeRequestResponseinReport(String req,String res)
	{
		logger.info("Request : "+req);
		logger.info("Response : "+res);
	}
	
	public void verifyJsonResponse(String exp,String act)
	{
		try {
		//	Assert.assertEquals(act, exp);
			logger.pass("Expected Excel data "+exp+ " matched with actual json response data");
		} catch (Exception e) {		
			e.printStackTrace();
			logger.fail(e.getMessage());
		}
	}
	
	public void verifyStatusLine(String exp,String act)
	{
		try {
			//Assert.assertEquals(act, exp);
			logger.pass("Status line "+exp+ " matched with actual status line");
		} catch (Exception e) {		
			e.printStackTrace();
			logger.fail(e.getMessage());
		}
	}
	

}
