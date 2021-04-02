package baseClasses;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageClasses.LandingPage;
import utilities.DateUtil;

public class PageBaseClass extends BaseTestClass {

	public PageBaseClass(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public SoftAssert softAssert = new SoftAssert();

	/****************** OpenApplication ***********************/
	public LandingPage OpenApplication() {
		logger.log(Status.INFO, "Opening the WebSite");
		driver.switchTo().window(driver.getWindowHandle());
		driver.get("https://emicalculator.net/");
		driver.switchTo().window(driver.getWindowHandle());
		logger.log(Status.PASS, "Successfully Opened the https://emicalculator.net/");
		LandingPage landingPage = new LandingPage(driver, logger);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}

	/****************** Enter Text ***********************/
	public void enterText(String xpathKey, String data) {
		try {
			getElement(xpathKey).sendKeys(data);
			reportPass(data + " - Entered successfully in locator Element : " + xpathKey);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/****************** Get Page Title ***********************/
	public void getTitle(String expectedTitle) {
		try {
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			reportPass("Actual Title : " + driver.getTitle() + " - equals to Expected Title : " + expectedTitle);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	/****************** Identify Element ***********************/
	public WebElement getElement(String locatorKey) {
		WebElement element = null;

		try {
			if (locatorKey.endsWith("_Id")) {
				element = driver.findElement(By.id(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_Xpath")) {
				element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_ClassName")) {
				element = driver.findElement(By.className(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_LinkText")) {
				element = driver.findElement(By.linkText(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_PartialLinkText")) {
				element = driver.findElement(By.partialLinkText(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_Name")) {
				element = driver.findElement(By.name(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else {
				reportFail("Failing the Testcase, Invalid Locator " + locatorKey);
			}
		} catch (Exception e) {

			// Fail the TestCase and Report the error
			reportFail(e.getMessage());
			reportFail(e.getMessage());
		}

		return element;
	}

	/****************** Click Element ***********************/
	public void elementClick(String xpathKey) {
		try {
			getElement(xpathKey).click();
			reportPass(xpathKey + " : Element Clicked Successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/****************** Get Pixels To Move Slider ***********************/

	public int getPixelsToMove(WebElement slider, double value, double sliderMax, double sliderMin) {
		int pixels = 0;
		double tempPixels = slider.getSize().getWidth();
		tempPixels = (tempPixels / (sliderMax - sliderMin));
		tempPixels = (tempPixels * (value - sliderMin));
		pixels = (int) tempPixels;
		return pixels;
	}

	/****************** Move Slider ***********************/
	public void moveSlider(WebElement slider, double value, double sliderMax, double sliderMin) {
		int PixelsToMove = getPixelsToMove(slider, value, sliderMax, sliderMin);
		Actions SliderAction = new Actions(driver);
		try {
			SliderAction.clickAndHold(slider).moveByOffset((-(int) slider.getSize().getWidth() / 2), 0)
					.moveByOffset(PixelsToMove, 0).release().perform();
			takeScreenShot();
			reportPass("Slider moved to: " + value);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	/****************** Read Text Input Value ***********************/
	public String readText(String locatorKey) {
		String value = getElement(locatorKey).getAttribute("value");
		logger.log(Status.INFO, locatorKey + " Identified");
		return value;
	}

	/****************** Assertion Functions ***********************/
	public void assertTrue(boolean flag) {
		softAssert.assertTrue(flag);
	}

	public void assertfalse(boolean flag) {
		softAssert.assertFalse(flag);
	}

	public void assertequals(String actual, String expected) {
		try {
			logger.log(Status.INFO, "Assertion : Actual is -" + actual + " And Expacted is - " + expected);
			softAssert.assertEquals(actual, expected);
			if (!(actual.equals(expected))) {
				reportFail("Assertion : Actual is -" + actual + " And Expacted is - " + expected);
			} else {
				logger.log(Status.PASS, "Assertion : Actual is -" + actual + " And Expacted is - " + expected);
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	/****************** Reporting Functions ***********************/
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShot();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

	@AfterMethod
	public void afterTest() {
		softAssert.assertAll();
		driver.quit();
	}

	@AfterTest
	public void endReport() {
		report.flush();

	}

	/****************** Capture Screen Shot ***********************/
	public void takeScreenShot() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");

		} catch (IOException e) {
			reportFail(e.getMessage());
		}

	}

	/****************** Capture Screen Shot ***********************/
	public void takeScreenShotOfWebelement(String locator) {

		WebElement element = getElement(locator);
		File sourceFile = element.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");
			reportPass("Screenshot captured of" + locator);

		} catch (IOException e) {
			reportFail(e.getMessage());
		}

	}

}
