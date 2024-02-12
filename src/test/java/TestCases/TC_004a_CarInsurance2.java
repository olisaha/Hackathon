package TestCases;

import org.testng.annotations.Test;

import PageObjects.carInsurancePage;
import testBase.BaseClass;

public class TC_004a_CarInsurance2 extends BaseClass {

	@Test(priority = 9, groups = "regression")

	public void test_carInsuranceQuote() {
		try {
			carInsurancePage cp = new carInsurancePage(driver);
			logger.info("----Starting TestCase 5----");
			logger.info("----Collecting the car Insurance quote ----");
			cp.carInsuranceQuote();
			cp.carInsuranceQuotess();
			cp.navigateback2();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
