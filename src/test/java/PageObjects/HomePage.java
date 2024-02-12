package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath = "/html/body/main/div[2]/section/div[7]/a")
	WebElement travelInsuranceButton;

	@FindBy(xpath = "/html/body/main/div[2]/section/div[4]/a")
	WebElement caInsuranceButton;

	@FindBy(xpath = "/html/body/div[5]/div[2]/div/ul/li[2]/a")
	WebElement InsuranceMENU;

	// Actions
	public void ClickTravelInsurance() {
		// mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[2]/section/div[7]/a")));
		travelInsuranceButton.click();
	}

	public void ClickCarInsurance() {
		caInsuranceButton.click();
	}

	public void healthInsuranceMENU() {
		InsuranceMENU.click();
	}
}
