package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.LogStatus;
public class AQCAdminLoginLogout extends QCStore {


	public static void login(String SSN, String AppURL) throws InterruptedException, MalformedURLException
	{
		
			
			int lastrow=TestData.getLastRow("adminCred");
			String sheetName="adminCred";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				String admin_url = TestData.getCellData(sheetName,"AdminURL",row);

				//String uname = TestData.getCellData(sheetName,"AdminUserName",row);
				//String pwd = TestData.getCellData(sheetName,"AdminPassword",row);
				String uname="hanuman";
				String pwd ="C0ns0l3";
				if(SSN.equals(RegSSN))
				{	

					
					test.log(LogStatus.INFO, "Opened the CSR URL " +admin_url);
					test.log(LogStatus.INFO, "admin Application is launched " );
					if(Aprop.getProperty("login_method").equalsIgnoreCase("local"))
					{
						driver = new InternetExplorerDriver();
					}
					else
					{
						String Node = "http://192.168.2.48:5555/wd/hub";
						 //String Node2 = "http://192.168.0.238:5566/wd/hub";
						 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
						 driver = new RemoteWebDriver(new URL(Node), cap);	
					}

					Thread.sleep(1500);
					driver.get(Aprop.getProperty("adminURL"));
					test.log(LogStatus.PASS, "Application Launched with URL"+Aprop.getProperty("adminURL"));
					/*try{
						driver.findElement(By.id("overridelink")).click();
						Thread.sleep(3000);
					}
					catch(Exception e){
						
					}*/
					
					driver.findElement(By.name("loginRequestBean.userId")).sendKeys(uname);
					test.log(LogStatus.PASS, "Username is entered: "+uname);

					driver.findElement(By.name("loginRequestBean.password")).sendKeys(pwd);
					test.log(LogStatus.PASS, "Password is entered: "+pwd);

					driver.findElement(By.name("login")).click();
					test.log(LogStatus.PASS, "Clicked on login button"); 
					Thread.sleep(4000);
					
					break;
				}
			}
		
	}
	public static void logout(String SSN, String AppURL)
	{

	

			driver.switchTo().defaultContent();
			driver.switchTo().frame("topFrame");

			driver.findElement(locator(Aprop.getProperty(("admin_logout_link")))).click();
			test.log(LogStatus.PASS, "Clicked On logout Button");
			System.out.println("clicked on logout"); 
			driver.quit();

			/*if(driver.getTitle().contains("Login")){
				test.log(LogStatus.PASS, "Logout is Successfully"); 
				test.log(LogStatus.INFO, "************************************************************");
				driver.close();
			}
			else{
				test.log(LogStatus.PASS, "Logout was unsuccessfull"); 
			}*/

			}
}
