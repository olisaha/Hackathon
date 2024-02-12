package TestCases;

import org.testng.annotations.Test;

import PageObjects.carInsurancePage;
import testBase.BaseClass;

public class TC_004_CarInsurance2 extends BaseClass {
	@Test(priority = 8, groups = "regression")

	public void test_carInsurancepositive() {
		try {
			carInsurancePage cp = new carInsurancePage(driver);
			logger.info("----Starting TestCase 4----");
			logger.info("----Validating positive cases----");
			cp.filldetailspositivecase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
