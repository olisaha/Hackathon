package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.carInsurancePage;
import testBase.BaseClass;

public class TC_003_CarInsurance1 extends BaseClass {
	HomePage hp;

	@Test(priority = 5, groups = "regression")

	public void test_carInsurancenegetive() {
		try {
			carInsurancePage cp = new carInsurancePage(driver);
		logger.info("----Starting TestCase 3----");
		logger.info("----Validating error messages with negetive inputs----");
	    	cp.carnoinput();
			cp.proceed();
			cp.selectcar();
			cp.filldetailsnegetivecase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 6, groups = "regression")
	public void test_carInsuranceerrormessagevalidation() {
		try {
			carInsurancePage cp = new carInsurancePage(driver);
			boolean errormsg = cp.mailerrormsgvalidation();
			Assert.assertEquals(errormsg, true, "Error message has not been displayed");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 7, groups = "regression")
	public void test_carInsurancenegetivetestcase() {
		try {
			carInsurancePage cp = new carInsurancePage(driver);
			cp.negetivetestcasess();
			// cp.navigateback2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
