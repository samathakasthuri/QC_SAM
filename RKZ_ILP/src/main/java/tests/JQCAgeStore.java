package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class JQCAgeStore extends QCStore{
	private static String NextDueDate;

	public static void ageStore(String SSN,String AppURL){
		
		 
		try{
			//String FileName= prop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("New_Loan");
				String sheetName="New_Loan";

					for(int row=2;row<=lastrow;row++)
							{		
								String RegSSN = TestData.getCellData(sheetName,"SSN",row);
								if(SSN.equals(RegSSN))
								{
								String UserName = TestData.getCellData(sheetName,"UserName",row);
								String Password = TestData.getCellData(sheetName,"Password",row);
								String PIN = TestData.getCellData(sheetName,"PIN",row);
						       // System.out.println(Password);
						        String StoreId = TestData.getCellData(sheetName,"StoreID",row);
						        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
						        String StateID = TestData.getCellData(sheetName,"StateID",row);
						        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
						        String Header = StateID+ "_" + ProductID;	      
						        String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
						        System.out.println(columnname);
						       String LastName = TestData.getCellData(sheetName,"LastName",row);
						       String FirstName = TestData.getCellData(sheetName,"FirstName",row);
						       String customer_name=LastName+FileName;
						       String AddressLine = TestData.getCellData(sheetName,"AddressLine",row);
						       String City = TestData.getCellData(sheetName,"City",row);
						       String State = TestData.getCellData(sheetName,"State",row);	      
						       String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);
						       String MonthsAtAddress = TestData.getCellData(sheetName,"MonthsAtAddress",row);	     
						       String Bank_ABARoutingNbr = TestData.getCellData(sheetName,"Bank_ABARoutingNbr",row);
						       String Bank_ChkgAcctNbr = TestData.getCellData(sheetName,"Bank_ChkgAcctNbr",row);	       
						       String Ctc_PrimaryPhone = TestData.getCellData(sheetName,"Ctc_PrimaryPhone",row);
						       String Ctc_PhoneType = TestData.getCellData(sheetName,"Ctc_PhoneType",row);
						       String Misc_PhotoIDNbr = TestData.getCellData(sheetName,"Misc_PhotoIDNbr",row);
						     //  String Misc_IDExpDate = TestData.getCellData(sheetName,"Misc_IDExpDate",row);	   
						       String Misc_PhotoIDType = TestData.getCellData(sheetName,"Misc_PhotoIDType",row);
						       String BorrDOB = TestData.getCellData(sheetName,"Misc_DOB",row);
						       String Income_IncomeType = TestData.getCellData(sheetName,"Income_IncomeType",row);
						       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
						       String Income_HireDt = TestData.getCellData(sheetName,"Income_HireDt",row);
						       String Income_DirectDeposit=TestData.getCellData(sheetName,"Income_DirectDeposit",row);	       
						       String PrimaryRef_LastName = TestData.getCellData(sheetName,"PrimaryRef_LastName",row);
						       String PrimaryRef_FirstName = TestData.getCellData(sheetName,"PrimaryRef_FirstName",row);
						       String PrimaryRef_Relationship = TestData.getCellData(sheetName,"PrimaryRef_Relationship",row);
						       String PrimaryRef_PhoneNbr=TestData.getCellData(sheetName,"PrimaryRef_PhoneNbr",row);
						       String Ref_LastName = TestData.getCellData(sheetName,"Ref_LastName",row);
						       String Ref_FirstName = TestData.getCellData(sheetName,"Ref_FirstName",row);
						       String Ref_Relationship = TestData.getCellData(sheetName,"Ref_Relationship",row);
						       String Ref_PhoneNbr=TestData.getCellData(sheetName,"Ref_PhoneNbr",row);	       
						       String Bankruptcy=TestData.getCellData(sheetName,"Bankruptcy",row);	     
						       String Income_Employer = TestData.getCellData(sheetName,"Income_Employer",row);
						       String Income_WorkPhone = TestData.getCellData(sheetName,"Income_WorkPhone",row);
						       String TenderType = TestData.getCellData(sheetName,"TenderType",row);
						       String AgeStore = TestData.getCellData(sheetName,"AgeStore",row);
						       String AgeStore_DueDate = TestData.getCellData(sheetName,"AgeStore_DueDate",row);
									   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
								        String SSN1 = SSN.substring(0, 3);
								        String SSN2 = SSN.substring(3,5);
								        String SSN3 = SSN.substring(5,9);
								        String PP1 = Ctc_PrimaryPhone.substring(0, 3);
								        String PP2 = Ctc_PrimaryPhone.substring(3, 6);
								        String PP3 = Ctc_PrimaryPhone.substring(6, 10);
								        String IncomeP1 = Income_WorkPhone.substring(0, 3);
								        String IncomeP2 = Income_WorkPhone.substring(3, 6);
								        String IncomeP3 = Income_WorkPhone.substring(6, 10);
								        String PrimaryRef_PhoneNbr1 = PrimaryRef_PhoneNbr.substring(0, 3);
								        String PrimaryRef_PhoneNbr2 = PrimaryRef_PhoneNbr.substring(3, 6);
								        String PrimaryRef_PhoneNbr3 = PrimaryRef_PhoneNbr.substring(6, 10);
								        String Ref_PhoneNbr1 = Ref_PhoneNbr.substring(0, 3);
								        String Ref_PhoneNbr2 = Ref_PhoneNbr.substring(3, 6);
								        String Ref_PhoneNbr3 = Ref_PhoneNbr.substring(6, 10);			       
								      //  System.out.println(Misc_IDExpDate);
								      //  Date Misc_IDExpDt = df.parse(Misc_IDExpDate);
								       // String IDExpDate0 =df.format(Misc_IDExpDt);	
								      //  System.out.println(IDExpDate0);
								      //  String IDExpDate[] =IDExpDate0.split("/");
								      //  String IDExpD1 = IDExpDate[0];
								      //  String IDExpD2 = IDExpDate[1];
								      //  String IDExpD3 = IDExpDate[2];
								      //  String DOB[] =BorrDOB.split("/");
								      //  String DOB1 = DOB[0];
								      //  String DOB2 = DOB[1];
								      //  String DOB3 = DOB[2];	
								        
						       Thread.sleep(4000);
								//test.log(LogStatus.INFO, MarkupHelper.createLabel("Age Store process is initiated", ExtentColor.BLUE));
								test.log(LogStatus.INFO, "Age Store process is initiated");

								driver.switchTo().defaultContent();	
								
						        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
								driver.switchTo().frame("topFrame");
								wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
						        driver.findElement(By.cssSelector("li[id='910000']")).click();	
								/*driver.switchTo().defaultContent();				
								driver.switchTo().frame("topFrame");
								driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();	*/		
								test.log(LogStatus.PASS, "Clicked on Loan Transactions");
								Thread.sleep(1000);
								driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
								driver.switchTo().defaultContent();
								driver.switchTo().frame("mainFrame");
								driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
								for(String winHandle : driver.getWindowHandles()){
							    driver.switchTo().window(winHandle);
								}
							    driver.switchTo().defaultContent();
							    driver.switchTo().frame("mainFrame");
							    driver.switchTo().frame("main");
							    
							    
							  // String loan_nbr= driver.findElement(locator(prop.getProperty("csr_loan_nbr"))).getText();
							  // test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
							    driver.findElement(By.name("button")).click();
								test.log(LogStatus.PASS, "Clicked on GO Button under Search results");
								// driver.findElement(By.name("button")).click();
								
							for(String winHandle : driver.getWindowHandles()){
								    driver.switchTo().window(winHandle);
									}				    
								 driver.switchTo().defaultContent();
								    driver.switchTo().frame("mainFrame");
								    driver.switchTo().frame("main");
								   // driver.findElement(By.name("button")).click();
								    
								  if(ProductID.equals("PDL"))
									 {
									  driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
									  test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
								    }
								    if(ProductID.equals("TLP"))
									 {
								    	driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
									 }
								    
								    Thread.sleep(5000);
								    if(ProductID.equals("LOC"))
									 {
								    	///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
								    	 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
									 }
								   
								    Thread.sleep(5000);
								    //if(AgeStore.equals(""))
								    {
										 NextDueDate = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form[1]/table[2]/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[2]/td[4]")).getText();
  	
								    }
								    //else
								    {
								    //	NextDueDate=AgeStore;
								    }
									 System.out.println(NextDueDate);
									 test.log(LogStatus.PASS, "Age Store Date is :"+NextDueDate);
									 Thread.sleep(5000);
									 
										
										for(String winHandle1 : driver.getWindowHandles()){
											    driver.switchTo().window(winHandle1);
												}				    
										driver.switchTo().defaultContent();
										 driver.switchTo().frame("topFrame");
									 driver.findElement(By.xpath("//*[@id='930000']/a")).click();			
												 test.log(LogStatus.PASS, "Clicked on Cash Management");
												 driver.switchTo().defaultContent();
												driver.switchTo().frame("mainFrame");							
												driver.findElement(By.xpath("//*[@id='988190657']/a")).click();		
												test.log(LogStatus.PASS, "Clicked on Start Scheduler");
												Thread.sleep(5000);
												for( String winHandle1 : driver.getWindowHandles())
												{
												    driver.switchTo().window(winHandle1);
												}			
												 driver.switchTo().defaultContent();
												 driver.switchTo().frame("mainFrame");
												 driver.switchTo().frame("main");
												String Due_Date[] =NextDueDate.split("/");
										        String Due_Date1 = Due_Date[0];
										        String Due_Date2 = Due_Date[1];
										        String Due_Date3 = Due_Date[2];
										        driver.findElement(By.name("endMonth")).sendKeys(Due_Date1);
										        test.log(LogStatus.PASS, "Month is entered: "+Due_Date1);
												driver.findElement(By.name("endDay")).sendKeys(Due_Date2);
												test.log(LogStatus.PASS, "Date is entered: "+Due_Date2);
												driver.findElement(By.name("endYear")).sendKeys(Due_Date3);
												test.log(LogStatus.PASS, "Year is entered: "+Due_Date3);
												driver.findElement(By.name("runSchedulerBtn")).click();
												test.log(LogStatus.PASS, "Clicked on Run Scheduler");
												Thread.sleep(500);
												 //String alert1=   driver.switchTo().alert().getText();
												 //test.log(LogStatus.PASS, "Clicked on Finish Loan: "+alert1);
												 
												 try { 
													    Alert alert = driver.switchTo().alert();
													
													    alert.accept();
													    //if alert present, accept and move on.														
														
													}
													catch (Exception e) {
													    //do what you normally would if you didn't have the alert.
													}
												 Thread.sleep(30000);
												
												 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ok")));
												 Thread.sleep(5000);
												 driver.findElement(By.name("ok")).click();
												 //test.log(LogStatus.PASS, "Clicked on Scheduler Ok");
												// test.log(LogStatus.PASS, MarkupHelper.createLabel("Clicked on Scheduler Ok Successfully",ExtentColor.GREEN));
												 test.log(LogStatus.PASS,"Clicked on Scheduler Ok Successfully");
												 test.log(LogStatus.PASS,"************************************************");

												 Thread.sleep(5000);
												 driver.close();
							
							
						 
					}
				}
			



					
				
		}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Borrower Registration is failed", ExtentColor.RED));
					test.log(LogStatus.FAIL, "Borrower Registration is failed");


				}

	}
}