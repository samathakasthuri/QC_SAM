package tests;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class QCAdminEncryption extends QCStore
{

	public static void getEncryption(WebDriver driver,String SSN,String AppURL) throws Exception
	{
		int i;
		for(i=0;i<3;i++)
		{
		
	try{
		//String FileName= Jprop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("Login");
			String sheetName="Login";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
				String UserName = TestData.getCellData(sheetName,"AdminUserName",row);
				String Password = TestData.getCellData(sheetName,"AdminPassword",row);
				String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
			
				String Tran_cd = TestData.getCellData(sheetName,"Tran_cd",row);


				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Admin Application is launched", ExtentColor.BLUE));
				test.log(LogStatus.INFO, "********Admin Application is launched********");
				
				if(prop.getProperty("login_method").equalsIgnoreCase("local"))
				{
					driver = new InternetExplorerDriver();
				}
				else
				{
					String Node = "http://192.168.2.164:5555/wd/hub";
					 //String Node2 = "http://192.168.0.238:5566/wd/hub";
					 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
					 driver = new RemoteWebDriver(new URL(Node), cap);	
				}
				wait = new WebDriverWait(driver, 40000);

			
				driver.get(AdminURL);
				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Opened the Admin URL"+ AdminURL, ExtentColor.BLUE));
				test.log(LogStatus.INFO, "Opened the Admin URL" + AdminURL);

				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Reading encryption details from Admin has initiated"+ AdminURL, ExtentColor.BLUE));
				test.log(LogStatus.INFO, "Reading encryption details from Admin has initiated"+ AdminURL);


				String mainwindow2=driver.getWindowHandle();
			
				System.out.println("In Admin"+ mainwindow2);
	
	DateFormat df=new SimpleDateFormat("MM/dd/yyyy"); 

	driver.findElement(By.name("loginRequestBean.userId")).sendKeys(UserName);

	test.log(LogStatus.PASS, "Username is entered: "+UserName); 

	driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

	test.log(LogStatus.PASS, "Password is entered: "+Password); 

	//Click Login Button

	driver.findElement(By.name("login")).click();

	test.log(LogStatus.PASS, "Clicked on Submit button");

	Thread.sleep(8000);


	driver.switchTo().defaultContent();

	driver.switchTo().frame("topFrame");

	driver.findElement(By.xpath("//*[contains(text(),'Employee')]")).click(); 

	test.log(LogStatus.PASS, "Clicked on Employee tab");

	

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 

	driver.findElement(By.linkText("Encryption Key")).click();

	test.log(LogStatus.PASS, "Clicked on Encryption Key link");



	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.findElement(By.linkText("Encryption")).click();

	test.log(LogStatus.PASS, "Clicked on Encryption");

	Thread.sleep(5000);


	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.switchTo().frame("main");

	driver.findElement(By.name("requestBean.locationNbr")).sendKeys("26");

	test.log(LogStatus.PASS, "Store number Entered"+encryption_store_no); 


	driver.findElement(By.name("requestBean.tranNbr")).sendKeys(encryption_transaction_nbr);

	test.log(LogStatus.PASS, "Tran number Entered"+encryption_transaction_nbr); 


	driver.findElement(By.name("trancd")).sendKeys(Tran_cd);

	test.log(LogStatus.PASS, "Trancd selected as: "+Tran_cd);


	driver.findElement(By.name("GetKey")).click();

	test.log(LogStatus.PASS, "GetKey clicked");
	


	Eankey = driver.findElement(By.name("EanKey")).getAttribute("value");

	//test.log(LogStatus.PASS, MarkupHelper.createLabel("GetKey captured as:" +Eankey, ExtentColor.GREEN));
	test.log(LogStatus.PASS, "GetKey captured as:" +Eankey);
	test.log(LogStatus.PASS, "***********************************************");
	driver.close();

break;
}
			}	
	
	break;
}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Getting Encryption from Admin is failed", ExtentColor.RED));
					//test.log(LogStatus.FAIL,"Getting Encryption from Admin is failed");
					test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
					String screenshotPath = getScreenhot(driver, "Exception");
									test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					test.log(LogStatus.INFO,"Getting Encryption from Admin process is initiated again due to Application sync issue");
					driver.get(Jprop.getProperty("login_page")); 
					continue;

				}

	}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "Getting Encryption from Admin is failed");
			
	
		}
}
}
