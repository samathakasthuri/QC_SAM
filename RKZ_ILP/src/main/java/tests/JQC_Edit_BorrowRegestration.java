
package tests;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;
public class JQC_Edit_BorrowRegestration extends QCStore{
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;
	public static String ESign_Password;
	public static String ESign_Checks;
	public static String CouponNbr;
	
	public static String AllowPromotion;
	public static String ESign_Preference;
	public static String ESign_CourtesyCallConsent;
	public static String ESign_DisbType;
	public static String ESign_LoanAmt;
	public static Object stateProductType;
	public static Object stateProduct;
	public static String StoreID;
	public static String NewVIN;
	public static String VehicleType;
	public static String NewLoan_Term;
	public static String NewLoan_ProductName;
	public static String ProductType;
	public static String Password;
	public static String UserName;
	public static String ProductID;
	public static CharSequence last4cheknum;
	public static String InsuranceExpiryDate0[]=null;
	public static String InsuranceExpiryDate3;
	public static String InsuranceExpiryDate2;
	public static String InsuranceExpiryDate1;
	public static String PolicyNumber;
	public static String InsuranceCompany;
	public static String PhoneNbr3;
	public static String PhoneNbr2;
	public static String PhoneNbr1;
	public static String PhoneNbr;
	public static String InsuranceCoverage;
	public static String LicensePlateExp;
	public static String LicensePlateNumber;
	public static String ExteriorColor;
	public static String AppraisalValue;
	public static String InsuranceExpiryDate;
	public static String TitleNumber;
	public static int rnum;
	public static int cnum;
	public static Object product_name;
	public static int count;
	public static List<WebElement> rows;
	public static String No_of_checks;
	public static String cardType;
	public static String cardNumber;
	public static String  cardEx_month;
	public static String cardEx_Year;
	public static String cvv;
	public static String CardHolderName;


	public static void editborrower_saveexit(String SSN,String AppURL) throws Exception
	{

		test.log(LogStatus.INFO, "*****Performing  Edit Borrower Regestration *****");
		int lastrow=TestData.getLastRow("Borrower_Registration");
		String sheetName="Borrower_Registration";

		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			String ProductType=TestData.getCellData(sheetName,"ProductType",row);
			String Edit_Nextpay_Date=TestData.getCellData(sheetName,"Edit_Nextpay_Date",row);
			test.log(LogStatus.PASS, "Edit Next Pay Date is "+Edit_Nextpay_Date);
			String Edit_Date[] = Edit_Nextpay_Date.split("/");
			String Edit_Date1 = Edit_Date[0];
			String Edit_Date2 = Edit_Date[1];
			String Edit_Date3 = Edit_Date[2];

			if(SSN.equals(RegSSN))
			{		
				

				SSN1 = SSN.substring(0, 3);
				SSN2 = SSN.substring(3,5);
				SSN3 = SSN.substring(5,9);

				test.log(LogStatus.PASS, "Values loaded from excel");
				Thread.sleep(3000);
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));
				Thread.sleep(3000);
				driver.findElement(By.cssSelector("li[id='900000']")).click();		
				test.log(LogStatus.PASS, "Clicked on Borrower");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");			 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='902000']")));
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("li[id='902000']")).click();			
				test.log(LogStatus.PASS, "Edit Borrower");
				Thread.sleep(1000);	
				driver.switchTo().frame("main");	
				Thread.sleep(1000);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				Thread.sleep(1000);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");	
				Thread.sleep(5000);
				
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[8]/input")).click();
					                             
					test.log(LogStatus.PASS, "Click on GO Button");
					/*Thread.sleep(5000);
					if(ProductType.equalsIgnoreCase("PayDay Loan")){
						test.log(LogStatus.INFO, "Product type selected as :"+ProductType);
					}
					else if(ProductType.equalsIgnoreCase("Installment Loan")){
						//driver.switchTo().frame("main");
						driver.findElement(By.name("customerBean.custProdType")).sendKeys(ProductType);
						test.log(LogStatus.INFO, "Product type selected as :"+ProductType);
					}
					else if(ProductType.equalsIgnoreCase("Title Loan")){
						//driver.switchTo().frame("main");
						driver.findElement(By.name("customerBean.custProdType")).sendKeys(ProductType);
						test.log(LogStatus.INFO, "Product type selected as :"+ProductType);
					}
					else if(ProductType.equalsIgnoreCase("Line of Credit")){
						//driver.switchTo().frame("main");
						driver.findElement(By.name("customerBean.custProdType")).sendKeys(ProductType);
						test.log(LogStatus.INFO, "Product type selected as :"+ProductType);
					}*/
					
					/*Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='valReferenceTable']/tbody/tr[2]/td[5]/div[3]/input")).click();
					test.log(LogStatus.PASS, "Clicked on Go");*/
					Thread.sleep(2000);
					driver.findElement(By.name("NPMM")).clear();
					driver.findElement(By.name("NPMM")).sendKeys(Edit_Date1);
					test.log(LogStatus.PASS, "Nexy pay date1 is entered: "+Edit_Date1);
					Thread.sleep(500);
					driver.findElement(By.name("NPDD")).clear();
					driver.findElement(By.name("NPDD")).sendKeys(Edit_Date2);
					test.log(LogStatus.PASS, "Nexy pay date2 is entered: "+Edit_Date2);
					Thread.sleep(500);
					driver.findElement(By.name("NPYYYY")).clear();
					driver.findElement(By.name("NPYYYY")).sendKeys(Edit_Date3);
					test.log(LogStatus.PASS, "Nexy pay date3 is entered: "+Edit_Date3);
					Thread.sleep(500);
					
					driver.findElement(By.xpath("//*[@id='btnShowModalExit']")).sendKeys(Keys.ENTER);
					test.log(LogStatus.PASS, "Clicked on Save & Exit");
					Thread.sleep(4000);
					
					try { 
						Alert alert = driver.switchTo().alert();
						alert.accept();
						// if alert present, accept and move on.												

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}

					for(String winHandle : driver.getWindowHandles()){

						driver.switchTo().window(winHandle);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						Thread.sleep(3000);
						
						String elementname= driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/b/font")).getText();
						test.log(LogStatus.INFO, "Registration Success Screen::"+elementname);
						test.log(LogStatus.PASS, "<FONT color=green> Borrower is Updated Successfully with SSN as " +SSN);	
						
						test.log(LogStatus.PASS,"****************************************");
					
					
					//====================================================================================================
					
					
					
					
					
					
								break;
		}
	}
	
	
	
	}

}

	public static void editborrower_savenext(String SSN,String AppURL) throws Exception
	{

		test.log(LogStatus.INFO, "*****Performing  Edit Borrower Regestration *****");
		int lastrow=TestData.getLastRow("Borrower_Registration");
		String sheetName="Borrower_Registration";

		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			String ProductType=TestData.getCellData(sheetName,"ProductType",row);
			String EditRef_PhoneNbr=TestData.getCellData(sheetName,"EditRef_PhoneNbr",row);	
			String EditRef_PhoneNbr1 = EditRef_PhoneNbr.substring(0, 3);
			String EditRef_PhoneNbr2 = EditRef_PhoneNbr.substring(3, 6);
			String EditRef_PhoneNbr3 = EditRef_PhoneNbr.substring(6, 10);

			if(SSN.equals(RegSSN))
			{		
				

				SSN1 = SSN.substring(0, 3);
				SSN2 = SSN.substring(3,5);
				SSN3 = SSN.substring(5,9);

				test.log(LogStatus.PASS, "Values loaded from excel");
				Thread.sleep(3000);
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));
				Thread.sleep(3000);
				driver.findElement(By.cssSelector("li[id='900000']")).click();		
				test.log(LogStatus.PASS, "Clicked on Borrower");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");			 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='902000']")));
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("li[id='902000']")).click();			
				test.log(LogStatus.PASS, "Edit Borrower");
				Thread.sleep(1000);	
				driver.switchTo().frame("main");	
				Thread.sleep(1000);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				Thread.sleep(1000);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");	
				Thread.sleep(5000);
				
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[8]/input")).click();
					                             
					test.log(LogStatus.PASS, "Click on GO Button");
					Thread.sleep(5000);
					if(ProductType.equalsIgnoreCase("PayDay Loan")){
						test.log(LogStatus.INFO, "Product trpe selected as :"+ProductType);
					}
					else if(ProductType.equalsIgnoreCase("Installment Loan")){
						//driver.switchTo().frame("main");
						driver.findElement(By.name("customerBean.custProdType")).sendKeys(ProductType);
						test.log(LogStatus.INFO, "Product trpe selected as :"+ProductType);
					}
					else if(ProductType.equalsIgnoreCase("Title Loan")){
						//driver.switchTo().frame("main");
						driver.findElement(By.name("customerBean.custProdType")).sendKeys(ProductType);
						test.log(LogStatus.INFO, "Product trpe selected as :"+ProductType);
					}
					else if(ProductType.equalsIgnoreCase("Line of Credit")){
						//driver.switchTo().frame("main");
						driver.findElement(By.name("customerBean.custProdType")).sendKeys(ProductType);
						test.log(LogStatus.INFO, "Product trpe selected as :"+ProductType);
					}
					
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='valReferenceTable']/tbody/tr[2]/td[5]/div[3]/input")).click();
					test.log(LogStatus.PASS, "Clicked on Go");
					Thread.sleep(1000);
					driver.findElement(By.name("refPhoneNbr1")).clear();
					driver.findElement(By.name("refPhoneNbr1")).sendKeys(EditRef_PhoneNbr1);
					test.log(LogStatus.PASS, "Reference Phone Nbr1 is entered: "+EditRef_PhoneNbr1);
					Thread.sleep(500);
					driver.findElement(By.name("refPhoneNbr2")).clear();
					driver.findElement(By.name("refPhoneNbr2")).sendKeys(EditRef_PhoneNbr2);
					test.log(LogStatus.PASS, "Reference Phone Nbr1 is entered: "+EditRef_PhoneNbr2);
					Thread.sleep(500);
					driver.findElement(By.name("refPhoneNbr3")).clear();
					driver.findElement(By.name("refPhoneNbr3")).sendKeys(EditRef_PhoneNbr3);
					test.log(LogStatus.PASS, "Reference Phone Nbr1 is entered: "+EditRef_PhoneNbr3);
					Thread.sleep(500);
					driver.findElement(By.name("bt_Reference")).click();
					test.log(LogStatus.PASS, "Clicked on Update");
					Thread.sleep(1000);
					
					driver.findElement(By.xpath("//*[@id='btnShowModal']")).sendKeys(Keys.ENTER);
					test.log(LogStatus.PASS, "Clicked on Save & Next");
					Thread.sleep(4000);
					//----------------------------------------------------------------------------------------------------------
					                Thread.sleep(4000);
					                driver.findElement(By.name("Save")).click();
									test.log(LogStatus.PASS, "Clicked on Next in Personal Tab");
									Thread.sleep(5000);
									//driver.findElement(By.xpath("//*[@id='valReferenceTable']/tbody/tr[2]/td[5]/div[3]/input")).click();
									 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
									 
									test.log(LogStatus.PASS, "Clicked on Go");
									Thread.sleep(1000);
									driver.findElement(By.name("bt_Income")).click();
									test.log(LogStatus.PASS, "Clicked on Update");
									Thread.sleep(1000);
									driver.findElement(By.name("Save")).click();
									test.log(LogStatus.PASS, "Clicked on Next in Incom Tab");
									Thread.sleep(1000);
									driver.findElement(By.name("Save")).click();
									test.log(LogStatus.PASS, "Clicked on Next in Banking Tab");
									Thread.sleep(1000);
									driver.findElement(By.name("Save")).click();
									test.log(LogStatus.PASS, "Clicked on Next in Referrences Tab");
									Thread.sleep(1000);
									driver.findElement(By.name("Save")).click();
									test.log(LogStatus.PASS, "Clicked on Save in Other tab");
									Thread.sleep(3000);
									
					//---------------------------------------------------------------------------------------------------------
									try { 
										Alert alert = driver.switchTo().alert();
										alert.accept();
										// if alert present, accept and move on.												

									}
									catch (NoAlertPresentException e) {
										//do what you normally would if you didn't have the alert.
									}

									for(String winHandle : driver.getWindowHandles()){

										driver.switchTo().window(winHandle);
										driver.switchTo().defaultContent();
										driver.switchTo().frame("mainFrame");
										driver.switchTo().frame("main");

										Thread.sleep(3000);
										
										if(driver.findElement(By.name("custok")).isDisplayed())
										{
											//driver.findElement(By.name("custok")).click();
											
											test.log(LogStatus.PASS, "<FONT color=green> Clicked on Custumer updated Successfully ");
										}
										//Thread.sleep(10000);
										//if(driver.findElement(By.name("button2")).isDisplayed())
										{
										//test.log(LogStatus.PASS, "<FONT color=green> New Loan Page is Displayed ");
										//test.log(LogStatus.PASS, "New Loan Page is Displayed");
										}
										test.log(LogStatus.PASS,"****************************************");
										
										
										
											

									}

								break;}

							}	
							}	
					/*Thread.sleep(4000);
					try { 
						Alert alert = driver.switchTo().alert();
						alert.accept();
						// if alert present, accept and move on.												

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}

					for(String winHandle : driver.getWindowHandles()){

						driver.switchTo().window(winHandle);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						Thread.sleep(3000);
						
						if(driver.findElement(By.name("deny")).isDisplayed())
						{
							test.log(LogStatus.PASS, "<FONT color=green> Deny Page is Displayed ");
						}
						test.log(LogStatus.PASS,"****************************************");
						
						
					
					//====================================================================================================
					
					
					
					
					
					
								break;
		}
	}
	
	
	
	}

}	*/

	public static void editborrower_saveloan(String SSN,String AppURL) throws Exception
	{

		test.log(LogStatus.INFO, "*****Performing  Edit Borrower Regestration *****");
		int lastrow=TestData.getLastRow("Borrower_Registration");
		String sheetName="Borrower_Registration";

		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			String ProductType=TestData.getCellData(sheetName,"ProductType",row);
			String EditRef_PhoneNbr=TestData.getCellData(sheetName,"EditRef_PhoneNbr",row);	
			String EditRef_PhoneNbr1 = EditRef_PhoneNbr.substring(0, 3);
			String EditRef_PhoneNbr2 = EditRef_PhoneNbr.substring(3, 6);
			String EditRef_PhoneNbr3 = EditRef_PhoneNbr.substring(6, 10);

			if(SSN.equals(RegSSN))
			{		
				

				SSN1 = SSN.substring(0, 3);
				SSN2 = SSN.substring(3,5);
				SSN3 = SSN.substring(5,9);

				test.log(LogStatus.PASS, "Values loaded from excel");
				Thread.sleep(3000);
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));
				Thread.sleep(3000);
				driver.findElement(By.cssSelector("li[id='900000']")).click();		
				test.log(LogStatus.PASS, "Clicked on Borrower");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");			 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='902000']")));
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("li[id='902000']")).click();			
				test.log(LogStatus.PASS, "Edit Borrower");
				Thread.sleep(1000);	
				driver.switchTo().frame("main");	
				Thread.sleep(1000);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				Thread.sleep(1000);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");	
				Thread.sleep(5000);
				
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[8]/input")).click();
					                             
					test.log(LogStatus.PASS, "Click on GO Button");
					Thread.sleep(5000);
					if(ProductType.equalsIgnoreCase("PayDay Loan")){
						test.log(LogStatus.INFO, "Product trpe selected as :"+ProductType);
					}
					else if(ProductType.equalsIgnoreCase("Installment Loan")){
						//driver.switchTo().frame("main");
						driver.findElement(By.name("customerBean.custProdType")).sendKeys(ProductType);
						test.log(LogStatus.INFO, "Product trpe selected as :"+ProductType);
					}
					else if(ProductType.equalsIgnoreCase("Title Loan")){
						//driver.switchTo().frame("main");
						driver.findElement(By.name("customerBean.custProdType")).sendKeys(ProductType);
						test.log(LogStatus.INFO, "Product trpe selected as :"+ProductType);
					}
					else if(ProductType.equalsIgnoreCase("Line of Credit")){
						//driver.switchTo().frame("main");
						driver.findElement(By.name("customerBean.custProdType")).sendKeys(ProductType);
						test.log(LogStatus.INFO, "Product trpe selected as :"+ProductType);
					}
					
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='valReferenceTable']/tbody/tr[2]/td[5]/div[3]/input")).click();
					test.log(LogStatus.PASS, "Clicked on Go");
					Thread.sleep(1000);
					driver.findElement(By.name("refPhoneNbr1")).clear();
					driver.findElement(By.name("refPhoneNbr1")).sendKeys(EditRef_PhoneNbr1);
					test.log(LogStatus.PASS, "Reference Phone Nbr1 is entered: "+EditRef_PhoneNbr1);
					Thread.sleep(500);
					driver.findElement(By.name("refPhoneNbr2")).clear();
					driver.findElement(By.name("refPhoneNbr2")).sendKeys(EditRef_PhoneNbr2);
					test.log(LogStatus.PASS, "Reference Phone Nbr1 is entered: "+EditRef_PhoneNbr2);
					Thread.sleep(500);
					driver.findElement(By.name("refPhoneNbr3")).clear();
					driver.findElement(By.name("refPhoneNbr3")).sendKeys(EditRef_PhoneNbr3);
					test.log(LogStatus.PASS, "Reference Phone Nbr1 is entered: "+EditRef_PhoneNbr3);
					Thread.sleep(500);
					driver.findElement(By.name("bt_Reference")).click();
					test.log(LogStatus.PASS, "Clicked on Update");
					Thread.sleep(1000);
					
					driver.findElement(By.xpath("//*[@id='btnShowModalLoan']")).sendKeys(Keys.ENTER);
					test.log(LogStatus.PASS, "Clicked on Save & Loan");
					Thread.sleep(4000);
					try { 
						Alert alert = driver.switchTo().alert();
						alert.accept();
						// if alert present, accept and move on.												

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}

					for(String winHandle : driver.getWindowHandles()){

						driver.switchTo().window(winHandle);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						Thread.sleep(3000);
						
						if(driver.findElement(By.name("button2")).isDisplayed())
						{
						test.log(LogStatus.PASS, "<FONT color=green> New Loan Page is Displayed ");
						//test.log(LogStatus.PASS, "New Loan Page is Displayed");
						}
						test.log(LogStatus.PASS,"****************************************");
						
						
					
					//====================================================================================================
					
					
					
					
					
					
								break;
		}
	}
	
	
	
	}

}	

	public static void editborrower_savedeny(String SSN,String AppURL) throws Exception
	{

		test.log(LogStatus.INFO, "*****Performing  Edit Borrower Regestration *****");
		int lastrow=TestData.getLastRow("Borrower_Registration");
		String sheetName="Borrower_Registration";

		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			String ProductType=TestData.getCellData(sheetName,"ProductType",row);
			String EditRef_PhoneNbr=TestData.getCellData(sheetName,"EditRef_PhoneNbr",row);	
			String EditRef_PhoneNbr1 = EditRef_PhoneNbr.substring(0, 3);
			String EditRef_PhoneNbr2 = EditRef_PhoneNbr.substring(3, 6);
			String EditRef_PhoneNbr3 = EditRef_PhoneNbr.substring(6, 10);

			if(SSN.equals(RegSSN))
			{		
				

				SSN1 = SSN.substring(0, 3);
				SSN2 = SSN.substring(3,5);
				SSN3 = SSN.substring(5,9);

				test.log(LogStatus.PASS, "Values loaded from excel");
				Thread.sleep(3000);
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));
				Thread.sleep(3000);
				driver.findElement(By.cssSelector("li[id='900000']")).click();		
				test.log(LogStatus.PASS, "Clicked on Borrower");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");			 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='902000']")));
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("li[id='902000']")).click();			
				test.log(LogStatus.PASS, "Edit Borrower");
				Thread.sleep(1000);	
				driver.switchTo().frame("main");	
				Thread.sleep(1000);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				Thread.sleep(1000);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");	
				Thread.sleep(5000);
				
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[8]/input")).click();
					                             
					test.log(LogStatus.PASS, "Click on GO Button");
					Thread.sleep(5000);
					if(ProductType.equalsIgnoreCase("PayDay Loan")){
						test.log(LogStatus.INFO, "Product trpe selected as :"+ProductType);
					}
					else if(ProductType.equalsIgnoreCase("Installment Loan")){
						//driver.switchTo().frame("main");
						driver.findElement(By.name("customerBean.custProdType")).sendKeys(ProductType);
						test.log(LogStatus.INFO, "Product trpe selected as :"+ProductType);
					}
					else if(ProductType.equalsIgnoreCase("Title Loan")){
						//driver.switchTo().frame("main");
						driver.findElement(By.name("customerBean.custProdType")).sendKeys(ProductType);
						test.log(LogStatus.INFO, "Product trpe selected as :"+ProductType);
					}
					else if(ProductType.equalsIgnoreCase("Line of Credit")){
						//driver.switchTo().frame("main");
						driver.findElement(By.name("customerBean.custProdType")).sendKeys(ProductType);
						test.log(LogStatus.INFO, "Product trpe selected as :"+ProductType);
					}
					
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='valReferenceTable']/tbody/tr[2]/td[5]/div[3]/input")).click();
					test.log(LogStatus.PASS, "Clicked on Go");
					Thread.sleep(1000);
					driver.findElement(By.name("refPhoneNbr1")).clear();
					driver.findElement(By.name("refPhoneNbr1")).sendKeys(EditRef_PhoneNbr1);
					test.log(LogStatus.PASS, "Reference Phone Nbr1 is entered: "+EditRef_PhoneNbr1);
					Thread.sleep(500);
					driver.findElement(By.name("refPhoneNbr2")).clear();
					driver.findElement(By.name("refPhoneNbr2")).sendKeys(EditRef_PhoneNbr2);
					test.log(LogStatus.PASS, "Reference Phone Nbr1 is entered: "+EditRef_PhoneNbr2);
					Thread.sleep(500);
					driver.findElement(By.name("refPhoneNbr3")).clear();
					driver.findElement(By.name("refPhoneNbr3")).sendKeys(EditRef_PhoneNbr3);
					test.log(LogStatus.PASS, "Reference Phone Nbr1 is entered: "+EditRef_PhoneNbr3);
					Thread.sleep(500);
					driver.findElement(By.name("bt_Reference")).click();
					test.log(LogStatus.PASS, "Clicked on Update");
					Thread.sleep(1000);
					
					/*driver.findElement(By.xpath("//*[@id='showDenial']")).sendKeys(Keys.ENTER);
					test.log(LogStatus.PASS, "Clicked on Deny");
					Thread.sleep(4000);
					try { 
						Alert alert = driver.switchTo().alert();
						alert.accept();
						Thread.sleep(1000);
						test.log(LogStatus.PASS, "<FONT color=green> Clicked on Denied Yes PopUp ");
						// if alert present, accept and move on.												

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}

					for(String winHandle : driver.getWindowHandles()){

						driver.switchTo().window(winHandle);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						Thread.sleep(3000);
						//String elementname= driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/b/font")).getText();
						//test.log(LogStatus.INFO, "Registration Success Screen::"+elementname);
						//test.log(LogStatus.PASS, "<FONT color=green> Borrower is Registered Successfully with SSN as " +SSN);	
						if(driver.findElement(By.name("customerBean.custProdType")).isDisplayed())
						{
							test.log(LogStatus.PASS, "<FONT color=green> Borrow Regestration Page Displayed after Deny ");
						}*/
						test.log(LogStatus.PASS,"****************************************");
						
						
						
					
					//====================================================================================================
					
					
					
					
					
					
								break;
		}
	}
	
	
	
	}

}	
	
	
	
	


//}


