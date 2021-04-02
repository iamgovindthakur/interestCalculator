package pageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

public class CarLoanPage extends PageBaseClass {

	public CarLoanPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	/* Adjusting Car Loan Amount Field value with Slider */
	public void setHomeAmountSlider(String sliderLocator, double value, double sliderMax, double sliderMin) {
		WebElement locator = getElement(sliderLocator);
		moveSlider(locator, value, sliderMax, sliderMin);
	}

	/* Adjusting Interest Rate Field value with Slider */
	public void setInterestRateSlider(String sliderLocator, double value, double sliderMax, double sliderMin) {
		WebElement locator = getElement(sliderLocator);
		moveSlider(locator, value, sliderMax, sliderMin);
	}

	/* Adjusting Loan Tenure Field value with Slider */
	public void setLoanTenureSlider(String sliderLocator, double value, double sliderMax, double sliderMin) {
		WebElement locator = getElement(sliderLocator);
		moveSlider(locator, value, sliderMax, sliderMin);
	}


	/* Clearing Text Box Pre Loaded Value And Give New Input Value*/
	public void clearFieldandGiveInput(String locator, String input) {
		getElement(locator).clear();
		getElement(locator).sendKeys(Keys.BACK_SPACE + input + Keys.TAB);
	}

	/* Displaying EMI Summary */
	public void displayEmiDetails() {
		System.out.println("-------------------------------------------------------");
		System.out.println("Loan EMI: " + getElement("carLoanEmiAmount_CSS").getText());
		System.out.println("Total Interest Payable: " + getElement("carInterestPayable_CSS").getText());
		System.out.println("Total Payment(Principal + Interest): " + getElement("carTotalAmount_CSS").getText());
		System.out.println("-------------------------------------------------------");
		takeScreenShotOfWebelement("carLoanResult_Xpath");

	}

}
