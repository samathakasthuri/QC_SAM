package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import tests.QCStore;

public class ILP_Refinance_StepSame extends QCStore{

	public static String cardType;
	public static String cardNumber;
	public static String  cardEx_month;
	public static String cardEx_Year;
	public static String cvv;
	public static String CardHolderName;

	public static String paymentAmount;

	public static void StepSame(String SSN,String AppURL) throws Exception{

		String sheetName="ReFinance";	
		int lastrow=TestData.getLastRow(sheetName);

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))

			{		

				String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				String ESign_Preference = TestData.getCellData(sheetName,"Esign_Preference",row);

				//String ESign_Password = TestData.getCellData(sheetName,"PIN",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);		
				String last4cheknum= ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
				

				cardType=TestData.getCellData(sheetName,"Card Type ",row);
				cardNumber=TestData.getCellData(sheetName,"Debit Card No",row);
				cardEx_month=TestData.getCellData(sheetName,"Expiry Month",row);
				cardEx_Year=TestData.getCellData(sheetName,"Expiry Year",row);
				cvv=TestData.getCellData(sheetName,"CVV",row);
				CardHolderName=TestData.getCellData(sheetName,"CardHolderName",row);

				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"**************RefinanceStepUp  started**************");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Aprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Aprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Aprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Aprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(Aprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(2000);					  

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys("Refinance");
				test.log(LogStatus.PASS, "Transaction Type is selected as Refinance");
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(1000);
				try{							
					driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
					test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
					
				}
				catch(Exception e){
					//normal flow
				}
				Thread.sleep(500);	
				/*driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Clicked on qualify button ");*/
				String paymentamount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
				test.log(LogStatus.PASS, "Getting payment amount "+paymentamount);
				driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
				test.log(LogStatus.PASS, "Select tender type as "+TenderType);
				WebElement e1=driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst"));
				e1.clear();
				e1.sendKeys(paymentamount);
				test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentamount);
				Thread.sleep(3000);

				String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
				test.log(LogStatus.PASS, "getting stepup message  :"+stepupmsg);

			/*	String[] disbamtmsg=stepupmsg.split(":");
				String disbamt=disbamtmsg[1].trim();
				test.log(LogStatus.PASS, "Getting disb amount "+disbamt);*/
				
				if(stepupmsg.contains("Step Same")){

					if(ESign_CollateralType.equalsIgnoreCase("Ach")){
						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
						
						/*String disbamt=driver.findElement(By.id("refinanceLoanAmt")).getText();
						test.log(LogStatus.PASS, "Getting disb amount "+disbamt);*/
						
						/*driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(TenderType);
						test.log(LogStatus.PASS, "Disb type selected as "+TenderType);*/
						/*driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disbamt);
						test.log(LogStatus.PASS, "Disb amount entered as "+disbamt);*/

					}
					
					if(ESign_CollateralType.equalsIgnoreCase("Check")){

						driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
						test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

						
						/*String disbamt=driver.findElement(By.id("refinanceLoanAmt")).getText();
						test.log(LogStatus.PASS, "Getting disb amount "+disbamt);*/
						
						/*driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(TenderType);
						test.log(LogStatus.PASS, "Disb type selected as "+TenderType);*/
						/*driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disbamt);
						test.log(LogStatus.PASS, "Disb amount entered as "+disbamt);*/

						driver.findElement(By.name("requestBean.siilBean.checkNbr")).sendKeys(last4cheknum);
						test.log(LogStatus.PASS, "Check number enterd  as "+last4cheknum);
						

/*						test.log(LogStatus.INFO, "Performing  check transactions");
						int chkno=987654;

						String instamnts=driver.findElement(By.name("requestBean.siilBean.nbrOfInst")).getAttribute("value");
						int instamntsno=Integer.parseInt(instamnts)+1;
						for(int j=2;j<=instamntsno;j++){
							chkno=chkno+1;
							String str1 = Integer.toString(chkno); 
							driver.findElement(By.xpath("//*[@id='checkNbrs"+(j-2)+"']")).sendKeys(str1);

							test.log(LogStatus.PASS, "Check number enterd as "+chkno);

						}*/

					}

					

					/*driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
					{
						if(ESign_Preference.equalsIgnoreCase("Call"))
						{
							driver.findElement(By.id("preferenceCall")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equalsIgnoreCase("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equalsIgnoreCase("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}*/

				


					driver.findElement(By.name("requestBean.password")).sendKeys(Password);
					test.log(LogStatus.PASS, "ESign_Checks is selected as "+Password);

					driver.findElement(By.name("finishLoan")).click();
					test.log(LogStatus.PASS, "click on Finish Loan button ");
					Thread.sleep(2000);									
					driver.findElement(By.name("OKBut")).click();				
					test.log(LogStatus.PASS, "click on Yes button ");
					Thread.sleep(4000);	
					if(driver.findElement(By.name("ok")).isDisplayed())
					{
						test.log(LogStatus.PASS, " Refinance Stepup is pass ");
						test.log(LogStatus.INFO, "**********************************************************************************");

					}
					else
					{
						test.log(LogStatus.FAIL, "Refinance Stepup is pass ");
						test.log(LogStatus.INFO, "**********************************************************************************");
					}
				}
				else{
					test.log(LogStatus.FAIL, " Refinance Stepup message is not displayed ");
				}
				break;}
			break;}
	}
}