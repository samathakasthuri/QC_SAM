package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

//public class QCCSRDueDate extends QCStore {

//}
public class QCInternalTransfer extends QCStore{

	public static String SSN1;
	public static String SSN2;
	public static String SSN3;
	




public static void internalTransfer(String SSN,String AppURL) throws Exception
	{
	int i;
	for(i=0;i<3;i++)
	{
		 
		try{
			
				int lastrow=TestData.getLastRow("InternalTransfer");
				String sheetName="InternalTransfer";

				for(int row=2;row<=lastrow;row++)
				{	
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				
					if(SSN.equals(RegSSN))
					{		
						
						String Action = TestData.getCellData(sheetName,"Action",row);
						String CountofDollarCoins = TestData.getCellData(sheetName,"CountofDollarCoins",row);
						String PIN = TestData.getCellData(sheetName,"PIN",row);
					
		
						 SSN1 = SSN.substring(0, 3);
						 SSN2 = SSN.substring(3,5);
						 SSN3 = SSN.substring(5,9);
						
						 
						Thread.sleep(3000);
						test.log(LogStatus.INFO, "Internal Transfer Process has started ");
					  
						 for( String winHandle1 : driver.getWindowHandles())
							{
							    driver.switchTo().window(winHandle1);
							}			
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("topFrame");
							 
			//Using try/catch for clicking elements 2nd time if it is not able to click in 1st attempt
							 
						 try
						 {
								 driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
								 test.log(LogStatus.PASS, "Clicked on Cash Management");
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");							
								 driver.findElement(By.xpath("//*[@id='932000']/a")).click();		
								 test.log(LogStatus.PASS, "Clicked on Safe");
								 Thread.sleep(500);
								 driver.findElement(By.xpath("//*[@id='932040']/a")).click();
								 test.log(LogStatus.PASS, "Clicked on Internal Transfer");
						 }
						 catch(Exception e)
						 {
							     driver.get(prop.getProperty("login_page")); 
							     driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
							
							    driver.switchTo().defaultContent();
							    driver.switchTo().frame("mainFrame");							
							    driver.findElement(By.xpath("//*[@id='932000']/a")).click();		
							    test.log(LogStatus.PASS, "Clicked on Safe");
							    Thread.sleep(500);
							    driver.findElement(By.xpath("//*[@id='932040']/a")).click();
							    test.log(LogStatus.PASS, "Clicked on Internal Transfer");
						 }
						Thread.sleep(500);
						for( String winHandle1 : driver.getWindowHandles())
						{
						    driver.switchTo().window(winHandle1);
						}			
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						driver.findElement(By.name("D1")).sendKeys(Action);
						test.log(LogStatus.PASS, "Action Type selected as :"+Action);
						driver.findElement(By.name("requestBean.noOfDollars")).sendKeys(CountofDollarCoins);
						test.log(LogStatus.PASS, "Coin Entered is :"+CountofDollarCoins);
						driver.findElement(By.name("drawerToSafeRequestBean.slipNbrs")).click();
						test.log(LogStatus.PASS, "Clicked on WebCheckbox");
						driver.findElement(By.name("safeToDrawerRequestBean.password")).sendKeys(PIN);
						test.log(LogStatus.PASS, "Banker Pin Entered is :"+PIN);
						driver.findElement(By.name("internaltransfer")).click();
						test.log(LogStatus.PASS, "Clicked on Finish Internal Transfer");
						try { 
						    Alert alert = driver.switchTo().alert();
						
						    alert.accept();
						    //if alert present, accept and move on.														
							
						}
						catch (Exception e) {
						    //do what you normally would if you didn't have the alert.
						}
						Thread.sleep(5000);	
						try { 
						    Alert alert = driver.switchTo().alert();
						
						    alert.accept();
						    //if alert present, accept and move on.														
							
						}
						catch (Exception e) {
						    //do what you normally would if you didn't have the alert.
						}
						
						driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input")).click();						 
						test.log(LogStatus.PASS,"Click on Yes Button");						 
						test.log(LogStatus.PASS,"Drawer to safe Transfer Completed Successfully");
						test.log(LogStatus.PASS,"**********************************************");
						Thread.sleep(5000);
						driver.close();
						break;
						}
					}
			
		break;
		}
		                  
						
						

			catch (Exception e) {
				e.printStackTrace();
				//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Borrower Registration is failed", ExtentColor.RED));
				test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
				String screenshotPath = getScreenhot(driver, "Exception");
								test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.INFO, "Internal transfer process is initiated again due to Application sync issue");
				driver.get(prop.getProperty("login_page")); 
				continue;
			}
	
}
	if(i==3)
	{
		test.log(LogStatus.FAIL, "Internal transfer  is failed");
		Assert.assertTrue(false);

	}
}
}
