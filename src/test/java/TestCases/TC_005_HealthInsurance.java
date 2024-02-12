package TestCases;

import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.healthInsurancePage;
import testBase.BaseClass;

public class TC_005_HealthInsurance extends BaseClass {
	HomePage hp;

	@Test(priority = 10, groups = { "sanity", "regression" })
	public void test_healthInsurance() {
		try {
			hp = new HomePage(driver);
			logger.info("----Starting TestCase 6----");
			logger.info("----clicking on the health insurance drop-down menu----");
			hp.healthInsuranceMENU();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 11, groups = "regression")
	public void test_healthInsurancemotor() {
		try {
			healthInsurancePage hip = new healthInsurancePage(driver);
			logger.info("----collecting the menu list available for health insurance----");
			hip.healthitemss();
			hip.HealthInsurance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
