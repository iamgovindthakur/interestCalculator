package pageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import baseClasses.PageBaseClass;

public class LoanCalulatorPage extends PageBaseClass {

	public LoanCalulatorPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);

	}

	/* Navigate To Loan EMI Calculator */
	public void navigateToEmiCalculator() {
		getElement("emiCalculatorLink_Xpath").click();
	}

	/* Navigate To Loan Amount Calculator */
	public void navigateToLoanAmountCalculator() {
		getElement("loanAmountCalculator_Xpath").click();
	}

	/* Navigate To Loan Tenure Calculator */
	public void navigateToLoanTenureCalculator() {
		getElement("loanTennureCalculator_Xpath").click();
	}

	/* Adjusting Loan Amount Field value with Slider */
	public void setLoanAmountSlider(String sliderLocator, double value, double sliderMax, double sliderMin) {
		WebElement locator = getElement(sliderLocator);
		moveSlider(locator, value, sliderMax, sliderMin);
	}

	/* Adjusting Interest Rate Field value with Slider */
	public void setInterestRateSlider(String sliderLocator, double value, double sliderMax, double sliderMin) {
		WebElement locator = getElement(sliderLocator);
		moveSlider(locator, value, sliderMax, sliderMin);
	}

	/* Adjusting Loan Tenures Field value with Slider */
	public void setLoanTenureSlider(String sliderLocator, double value, double sliderMax, double sliderMin) {
		WebElement locator = getElement(sliderLocator);
		moveSlider(locator, value, sliderMax, sliderMin);
	}

	/* Adjusting Fees and Charges Field value with Slider */
	public void setLoanFeeChargesSlider(String sliderLocator, double value, double sliderMax, double sliderMin) {
		WebElement locator = getElement(sliderLocator);
		moveSlider(locator, value, sliderMax, sliderMin);
	}

	/* Clearing Text Box Pre Loaded Value And Give New Input Value */
	public void clearFieldandGiveInput(String locator, String input) {
		System.out.println("input" + input);
		getElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), input, Keys.TAB);
		takeScreenShot();
		logger.log(Status.PASS, "ScreenShot captured of locator" + locator);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(readText(locator));
	}

	/* Displaying EMI Summary */
	public void displayLoanEmi() {
		System.out.println("-------------------------------------------------------");
		System.out.println("Loan EMI: " + getElement("loanEmiAmount_CSS").getText());
		System.out.println("Loan APR: " + getElement("loanAPR_CSS").getText());
		System.out.println("Total Interest Payable: " + getElement("totalInterest_CSS").getText());
		System.out.println("Total Payment(Principal + Interest): " + getElement("totalAmount_CSS").getText());
		System.out.println("-------------------------------------------------------");

	}

}
