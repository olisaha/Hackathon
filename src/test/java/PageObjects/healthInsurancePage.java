package PageObjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExcelUtility;

public class healthInsurancePage extends BasePage {
	WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public healthInsurancePage(WebDriver driver) {
		super(driver);

	}

	String HLTH;
	ExcelUtility et = new ExcelUtility();
	// Elements

	@FindBy(xpath = "/html/body/div[5]/div[2]/div/ul/li[2]/div/div/div[3]/ul//a/span")
	List<WebElement> healthInsuranceLIST;

	// Actions
	public void healthitemss() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(
				"C:\\Users\\2303442\\git\\Hackathon_CTS\\TravelInsurance\\screenshots\\healthInsuranceItems.png");
		FileUtils.copyFile(src, trg);
	}

	public void HealthInsurance() throws InterruptedException, IOException {
		System.out.println("The healthInsurance menu items are:");
		for (WebElement i : healthInsuranceLIST) {
			HLTH = i.getText();
			System.out.println(HLTH);
		}
		et.excelwrite2(healthInsuranceLIST);

	}

}
