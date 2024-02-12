package TestCases;

import java.util.Map;

import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.travelInsurancePage;
import Utilities.ExcelUtility;
import testBase.BaseClass;

public class TC_001_Registration extends BaseClass {

	HomePage hp;

	@Test(priority = 1, groups = { "sanity", "regression" })
	public void test_travelInsurancebuttonClick() {

		try {
			hp = new HomePage(driver);
			logger.info("----Starting TestCase1----");
			logger.info("----Clicking on Travel Insurance button on home-page----");
			hp.ClickTravelInsurance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2, groups = "regression")
	public void test_TravelInsurance() {

		try {
			travelInsurancePage tp = new travelInsurancePage(driver);
			ExcelUtility eu = new ExcelUtility();
			logger.info("----entering the necessary details to get the travel insurance plan ----");
			Thread.sleep(3000);
			tp.EnterDestination();
			tp.SelectStartingDate();
			tp.SelectEndingDate();
			tp.travellersdetail();
			tp.medicalhistory();
			tp.contactdetails();
			tp.insurancedetails();
			logger.info("----collecting the first three lowest Insurance palns----");
			Map<String, String> maps = tp.printinsurancepaln();
			tp.travelinsurancess();
			eu.excelWrite(maps);
			tp.navigateback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
