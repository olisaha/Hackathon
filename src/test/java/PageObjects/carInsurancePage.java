package PageObjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

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

public class carInsurancePage extends BasePage {
	public Properties p;
	public carInsurancePage(WebDriver driver) {
		super(driver);
	}
	
//Elements

	@FindBy(xpath = "//button[@id='btnGetQuotes']")
	WebElement veiwprice;
	@FindBy(xpath = "//span[@class=\"mdl-textfield__error show\"]")
	WebElement errormessage;
	@FindBy(xpath = "//img[@alt=\"policybazaar\"]")
	WebElement homepageclick;
	@FindBy(xpath = "//*[@id=\"regNoTextBox\"]")
	WebElement carinputbox;
	@FindBy(xpath = "//*[@id=\"dvMake\"]/div/ul/div/li[7]/span")
	WebElement carname;
	@FindBy(xpath = "//*[@id=\"modelScroll\"]/li[2]/span")
	WebElement carmodel;
	@FindBy(xpath = "//*[@id=\"Petrol\"]")
	WebElement cartype;
	@FindBy(xpath = "//*[@id=\"variantScroll\"]/li[1]/span")
	WebElement petrolvar;
	@FindBy(xpath = "//*[@id=\"dvRegYear\"]/ul/div/li[1]/span")
	WebElement regyear;
	@FindBy(xpath = "//input[@id='name']")
	WebElement name;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailid;
	@FindBy(xpath = "//input[@id='mobileNo']")
	WebElement phnno;
	@FindBy(xpath = "//button[@name=\"next\"]")
	WebElement veiwpricebutton;
	@FindBy(xpath = "//*[@id=\"dvVariant\"]/div[2]/div[1]/div[2]/div[2]")
	WebElement wrongemailmsg;
	@FindBy(xpath = "//*[@id=\"dvVariant\"]/div[2]/div[1]/div[3]/div[2]")
	WebElement wrongmobilenomsg;

	// Actions
	public void proceed() throws InterruptedException, IOException {
		veiwprice.click();
		}

	public boolean errormessagevalidation() throws IOException {
		WebElement msgss = driver.findElement(By.xpath("//div[@class='registeration']"));
		File src1 = msgss.getScreenshotAs(OutputType.FILE);
		File trg1 = new File("C:\\Users\\2303442\\git\\Hackathon_CTS\\TravelInsurance\\screenshots\\errormessage1.png");
		FileUtils.copyFile(src1, trg1);
		String error = errormessage.getText();
		System.out.println(error);

		try {
			return (error.equals("Please enter a valid car number"));
		} catch (Exception e) {
			return false;
		}

	}

	public void carnoinput() throws InterruptedException, IOException {
		
		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		
         Thread.sleep(3000);
         carinputbox.sendKeys(p.getProperty("car_num"));
	}

	public void selectcar() throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", carname);
		carmodel.click();
		cartype.click();
		petrolvar.click();
		regyear.click();
	}

	public void filldetailspositivecase() throws InterruptedException, IOException {
		emailid.clear();
		
		String eml=RandomStringUtils.randomAlphanumeric(9);
		emailid.sendKeys(eml+"@gmail.com");//generating valid email-id input
		
		String generatedString=RandomStringUtils.randomNumeric(9);
		phnno.sendKeys("9"+generatedString);//generating phone number
		Thread.sleep(2000);
		File srcp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File trgp = new File("C:\\Users\\2303442\\git\\Hackathon_CTS\\TravelInsurance\\screenshots\\pstvcase.png");
		FileUtils.copyFile(srcp, trgp);
	}

	public void filldetailsnegetivecase() throws IOException, InterruptedException {
		  name.sendKeys(p.getProperty("name"));
		  String eml2=RandomStringUtils.randomAlphanumeric(9);
		  emailid.sendKeys(eml2+"gmail.com");// invalid email-id input
	}

	public boolean mailerrormsgvalidation() {
		String wrongemail = wrongemailmsg.getText();
		System.out.println(wrongemail);
		try {
			return (wrongemail.equals("Please enter a valid e-mail ID."));
		} catch (Exception e) {
			return false;
		}

	}

	public void negetivetestcasess() throws IOException {
		WebElement msgss = driver.findElement(By.xpath("//*[@id=\"innerregno\"]/div[2]/div"));
		File src1 = msgss.getScreenshotAs(OutputType.FILE);
		File trg1 = new File("C:\\Users\\2303442\\git\\Hackathon_CTS\\TravelInsurance\\screenshots\\errormessage2.png");
		FileUtils.copyFile(src1, trg1);

		File srcp1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File trgp1 = new File("C:\\Users\\2303442\\git\\Hackathon_CTS\\TravelInsurance\\screenshots\\ngtvcase.png");
		FileUtils.copyFile(srcp1, trgp1);

	}

	public void navigateback2() {

		Actions act1= new Actions(driver);
		act1.moveToElement(homepageclick).click().perform();
	}

	public void carInsuranceQuote() throws InterruptedException {

		driver.navigate().to(
				"https://ci.policybazaar.com/v2/quotes?id=S1orODVBcG41aHd4NkF6blcwYTcvcGYrZHVHU2dVNmx2Tm5PYXpwUTl5dz0%3d&leadId=MTI1NDA5Mjcy&id2=S3Zua09oS1hXaFI5dnNCZFlMTmJOdz09");
		Thread.sleep(6000);
		String InsuranceCount = driver
				.findElement(By.xpath("//*[@id=\"root\"]/section/div/div/div/div[2]/section/div/div/h2/span[1]"))
				.getText();
		System.out.println("There are:" + InsuranceCount);
		String value = InsuranceCount.substring(0, 1);
		int j = Integer.parseInt(value);
		List<WebElement> Carins = driver.findElements(By.xpath("//*[@class=\"headingV3 fontNormal\"]"));
		System.out.println("IDV cover" + "   " + "claims setteled");
		for (int i = 0; i < (2 * j); i += 2) {
			if (i + 1 < (2 * j)) {
				System.out.println(Carins.get(i).getText() + "   " + Carins.get(i + 1).getText());
			}
		}

	}

	public void carInsuranceQuotess() throws IOException {
		File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File trg1 = new File("C:\\Users\\2303442\\git\\Hackathon_CTS\\TravelInsurance\\screenshots\\carq.png");
		FileUtils.copyFile(src1, trg1);

	}

}
