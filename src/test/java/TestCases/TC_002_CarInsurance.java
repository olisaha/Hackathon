package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.carInsurancePage;
import testBase.BaseClass;

public class TC_002_CarInsurance extends BaseClass {
	HomePage hp;

	@Test(priority = 3, groups = { "sanity", "regression" })

	public void test_carInsurance() {
		try {
			hp = new HomePage(driver);
			logger.info("----Clicking on car insurance button on home-page");
			logger.info("----Starting TestCase 2----");
			hp.ClickCarInsurance();
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4, groups = "regression")

	public void test_carInsurance1() {
		try {
			carInsurancePage cp = new carInsurancePage(driver);
			logger.info("----proceeding without car number and validating the error message----");
			cp.proceed();
			boolean errormsg = cp.errormessagevalidation();
			Assert.assertEquals(errormsg, true, "Error message has not been displayed");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
