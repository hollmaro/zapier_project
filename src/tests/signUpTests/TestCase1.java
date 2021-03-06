
package tests.signUpTests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import libs.ConfigData;
import libs.ExcelDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import pages.SignUpPage;
import tests.ParentTest;


public class TestCase1 extends ParentTest {
	/**
	 * CONSTRUCTOR for TC
	 * @param browser
	 * @throws MalformedURLException
	 */
	public TestCase1(String browser) throws MalformedURLException {
		super(browser);
	}

	SignUpPage signUpPage;
	
	@Test
	public void test1()throws IOException{
		Map mapDataTC = ExcelDriver.getData(ConfigData.getCfgValue("TestDataSignUp"), "TestCase1");
		ExcelDriver excelDriver = new ExcelDriver(mapDataTC);
		signUpPage = new SignUpPage(driver);
		signUpPage.openSignUpPage();
		
		Assert.assertTrue("Check opening page SignUP: ", 
				signUpPage.typeFirstNameIntoInputFirstName(excelDriver.getValueByKey("firstName"))&&
				signUpPage.typeLastNameIntoInputLastName(excelDriver.getValueByKey("lastName"))&&
				signUpPage.typeEmailIntoInputEmail(excelDriver.getValueByKey("email"))&&
				signUpPage.typePasswIntoInputPassword(excelDriver.getValueByKey("password"))&&
				signUpPage.unCheckUpdatesCheckBox()&&
				signUpPage.clickSignUPButton());
		Assert.assertTrue("Check result ", signUpPage.isErrorMessages());
	}			

	@After
	public void tearDown(){
		signUpPage.closeSignUpPage();
	}
		
		
}

