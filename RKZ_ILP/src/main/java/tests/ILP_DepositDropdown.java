package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

import tests.QCStore;

public class ILP_DepositDropdown extends QCStore{

	public static void depositDropDown(String SSN,String AppURL) throws InterruptedException
	{
		 
	
				int lastrow=TestData.getLastRow("Deposit");
				String sheetName="Deposit";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{
					
					//String PIN = TestData.getCellData(sheetName,"PIN",row);
					String Deposit_Type = TestData.getCellData(sheetName,"Deposit_Type",row);
			        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);

					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);		       
					
			       Thread.sleep(4000);

					test.log(LogStatus.INFO, "Deposit through from CSR has initiated");

					driver.switchTo().frame("bottom");
					String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					test.log(LogStatus.PASS, ""+Str_date);
					
					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();		
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
				
					driver.findElement(By.cssSelector("li[id='911101']")).click();			
					test.log(LogStatus.PASS, "Clicked on Transactions");		
					driver.switchTo().frame("main");		
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(By.name("ssn2")).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(By.name("ssn3")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(By.name("submit1")).click();
					test.log(LogStatus.PASS, "Click on submit Button");		
					Thread.sleep(3000);
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
				    
				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
				
					    
					  if(ProductID.equals("PDL"))
						 {									
					    driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					    }
					    if(ProductID.equals("ILP"))
						 {								
					    	driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
					    	 test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
						 }
					    
					    Thread.sleep(5000);
					    if(ProductID.equals("LOC"))
						 {
					    	 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						 }
							   							
							if(ESign_CollateralType.equalsIgnoreCase("ACH"))
							{
								
								driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 driver.findElement(By.name("transactionList")).sendKeys(ESign_CollateralType+" Deposit");
								 test.log(LogStatus.PASS, "Transaction type is selected "+ESign_CollateralType+" Deposit");
								 driver.findElement(By.id("go_Button")).click();
								 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
								//*[@id="AchDepScreen"]/table/tbody/tr[4]/td/table/tbody/tr[2]/td[3]
								 String loannbr=driver.findElement(By.xpath("//*[@id='AchDepScreen']/table/tbody/tr[4]/td/table/tbody/tr[2]/td[3]")).getText();
								 test.log(LogStatus.PASS, " Getting loan number drom deposit table"+loannbr);
								 
								 if(loannbr.equalsIgnoreCase(loan_nbr)){
									 test.log(LogStatus.PASS, " Loan number checking condition passed"+loannbr);
									 driver.findElement(By.name("finish")).click();
									 test.log(LogStatus.PASS, "Click on Finish ach deposit button");
									 
								 }
								 
								/* driver.findElement(By.name("CmdReturnPosting")).click();
								 test.log(LogStatus.PASS, " Cliked on next button");
								 
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(Password);
								 test.log(LogStatus.PASS, " Entered password");
								 
								 driver.findElement(By.name("Submit22")).click();
								 test.log(LogStatus.PASS, " cliked on finish ACH deposit button");
								 
								 if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
								 {

								test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
								test.log(LogStatus.PASS, "********************************************** ");

							}*/
							}
							
							else if(ESign_CollateralType.equalsIgnoreCase("CHECK"))
							{
											
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 driver.findElement(By.name("transactionList")).sendKeys(ESign_CollateralType+" Deposit");
								 test.log(LogStatus.PASS, "Transaction type is selected"+ESign_CollateralType+" Deposit");
								 driver.findElement(By.id("go_Button")).click();
								 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
								 
								 driver.findElement(By.name("requestBean.siilBean.chk21ReDepType")).sendKeys(Deposit_Type);
								 test.log(LogStatus.PASS, " Select the Deposit_Type as"+Deposit_Type);
								
								/* driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								 test.log(LogStatus.PASS, " Entered password "+PIN);*/
								 
								 driver.findElement(By.name("finish")).click();
								 test.log(LogStatus.PASS, " click on finish deposit button");
								 
								 if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
								 {

								test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
								test.log(LogStatus.PASS, "********************************************** ");
								 }
								 else{
										test.log(LogStatus.INFO, ESign_CollateralType+" Deposit from CSR is successfull");
										test.log(LogStatus.PASS, "********************************************** ");
								 }

							}
							else if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
							{
										
								 driver.switchTo().defaultContent();
								 driver.switchTo().frame("mainFrame");
								 driver.switchTo().frame("main");
								 driver.findElement(By.name("transactionList")).sendKeys("DebitCard Deposit");
								 test.log(LogStatus.PASS, "Transaction type is selected"+ESign_CollateralType+" Deposit");
								 driver.findElement(By.id("go_Button")).click();
								 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
								 driver.findElement(locator(Aprop.getProperty("ACH_process_now"))).click();
								 
								 test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
								 test.log(LogStatus.PASS, "********************************************** ");
								/* driver.findElement(By.name("requestBean.chkName")).click();
								 test.log(LogStatus.PASS, " Selected checkbox under checks to be ACHD option");
								 
								 
								 driver.findElement(By.name("CmdReturnPosting")).click();
								 test.log(LogStatus.PASS, " clik on next button");
								 
								 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
								 test.log(LogStatus.PASS, " Entered password");
								 
								 driver.findElement(By.name("Submit22")).click();
								 test.log(LogStatus.PASS, " clik on finsish ACH deposit button");
								 
								 if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
								 {
								// test.log(LogStatus.PASS, ESign_CollateralType+" Deposit completed sucessfully");
						
								//test.log(LogStatus.PASS, MarkupHelper.createLabel(ESign_CollateralType+" Deposit from CSR is successfull", ExtentColor.GREEN));
								test.log(LogStatus.PASS, ESign_CollateralType+" Deposit from CSR is successfull");
								test.log(LogStatus.PASS, "********************************************** ");

							}*/
							}
						 
						 break;
						 
					}
				
					}
				
		
				
		
		




}
}






