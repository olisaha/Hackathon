package PageObjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class travelInsurancePage extends BasePage {

	WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public travelInsurancePage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//*[@srcset='https://static.pbcdn.in/travel-cdn/images/country/Germany.webp']")
	WebElement Germany;

	@FindBy(xpath = "//button[@class=\"travel_main_cta\"]")
	WebElement Proceedbutton;

	@FindBy(xpath = "//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div/div[1]/div/div/input")
	WebElement CalenderclickStrt;

	@FindBy(xpath = "//button[@aria-label=\"Mar 20, 2024\"]")
	WebElement Strtdate;

	@FindBy(xpath = "//button[@aria-label=\"May 22, 2024\"]")
	WebElement EndDate;

	@FindBy(xpath = "//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div/div[2]/div/div/input")
	WebElement CalenderclickEnd;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div//div[1]/h6")
	WebElement month;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[2]/div[1]/button[2]")
	WebElement clickbutton;

	@FindBy(xpath = "//button[@class=\"travel_main_cta\"]")
	WebElement nxtbutton;

	@FindBy(xpath = "//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div[1]/div[2]/label")
	WebElement travellers;

	@FindBy(xpath = "//div[text()='Select age of traveller 1']")
	WebElement traveller1ageselect;

	@FindBy(xpath = "//div[text()='Select age of traveller 2']")
	WebElement traveller2ageselect;

	@FindBy(xpath = "//*[@id=\"optionBox_1_wrapper\"]/div[23]/label")
	WebElement age21;

	@FindBy(xpath = "//*[@id=\"optionBox_0_wrapper\"]/div[24]/label")
	WebElement age22;

	@FindBy(xpath = "//input[@value='no']")
	WebElement nomedicalhistory;

	@FindBy(xpath = "//*[@id=\"central-login-input-block-div-id\"]/div")
	WebElement mobileno;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/aside/section[1]/details/summary/p")
	WebElement sortbutton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/aside/section[1]/details/ul/li[2]/label")
	WebElement lowtohigh;

	@FindBy(xpath = "//*[@id=\"root\"]/div/header/article/h1/a")
	WebElement homepageclick;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/aside/section[3]/p")
	WebElement scroll;
	
	@FindBy(xpath="//*[@id=\"modal-root\"]/div/div")
	WebElement popup;
	
	// Actions
	public void EnterDestination() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Germany);
		Proceedbutton.click();
	}

	public void SelectStartingDate() throws InterruptedException {

		Thread.sleep(2000);
		CalenderclickStrt.click();
		Thread.sleep(3000);

		String MnthYr1 = "March 2024";
		while (true) {
			String mon1 = month.getText();
			if (mon1.equals(MnthYr1)) {
				break;
			} else {
				clickbutton.click();
				Thread.sleep(2000);
			}

		}
		Strtdate.click();
	}

	public void SelectEndingDate() throws InterruptedException {

		Actions act1= new Actions(driver);
		act1.moveToElement(CalenderclickEnd).click().perform();
		Thread.sleep(2000);
		String MnthYr2 = "May 2024";
		while (true) {
			String mon2 = month.getText();
			if (mon2.equals(MnthYr2)) {
				break;
			} else {
				clickbutton.click();
				Thread.sleep(2000);
			}

		}
		EndDate.click();
		nxtbutton.click();
	}

	public void travellersdetail() throws InterruptedException {

		travellers.click();
		Thread.sleep(2000);
		traveller1ageselect.click();
		Thread.sleep(2000);
		age22.click();
		Thread.sleep(2000);
		traveller2ageselect.click();
		Thread.sleep(2000);
		age21.click();
		nxtbutton.click();
	}

	public void medicalhistory() throws InterruptedException {

		nomedicalhistory.click();
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"travel_main_cta\"]")));
		

	}

	public void contactdetails() throws InterruptedException {
		mywait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"central-login-input-block-div-id\"]/div")));
		mobileno.click();
		WebElement contact = driver.findElement(By.xpath("//input[@id='mobileNumber']"));
		String generatedString=RandomStringUtils.randomNumeric(9);
		contact.sendKeys("9"+generatedString);
		WebElement viewPlans = driver.findElement(By.xpath("//button[contains(text(),'View plans')]"));
		viewPlans.click();

	}
	public void insurancedetails() throws InterruptedException {
		Thread.sleep(7000);
		sortbutton.click();

		lowtohigh.click();
	}

	public Map<String, String> printinsurancepaln() {
		Map<String, String> insuranceMap = new HashMap<String, String>();
		List<WebElement> providername = driver.findElements(By.xpath("//*[@class=\"quotesCard--insurerName\"]"));
		List<WebElement> policyprice = driver.findElements(By.xpath("//*[@class=\"premiumPlanPrice\"]"));
		for (int i = 0; i < 3; i++) {

			String pname = providername.get(i).getText();
			String pprice = policyprice.get(i).getText();

			insuranceMap.put(pname, pprice);
		}
		for (Map.Entry<String, String> entry : insuranceMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());

		}
		return insuranceMap;

	}

	public void travelinsurancess() throws IOException, InterruptedException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(
				"C:\\Users\\2303442\\git\\Hackathon_CTS\\TravelInsurance\\screenshots\\travelinsurance1.png");
		FileUtils.copyFile(src, trg);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		Thread.sleep(2000);
		TakesScreenshot ts1 = (TakesScreenshot) driver;
		File src1 = ts1.getScreenshotAs(OutputType.FILE);
		File trg1 = new File(
				"C:\\Users\\2303442\\git\\Hackathon_CTS\\TravelInsurance\\screenshots\\travelinsurance2.png");
		FileUtils.copyFile(src1, trg1);
	}

	public void navigateback() {
		homepageclick.click();
	}

}
