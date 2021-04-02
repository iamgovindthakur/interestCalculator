package testCase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import pageClasses.CarLoanPage;
import pageClasses.LandingPage;

public class CarLoanTest extends BaseTestClass {

	LandingPage landingPage;
	CarLoanPage carLoan;



	@Test(groups = "Main_TestCase")
	public void testCarLoan() throws InterruptedException {
		logger = report.createTest("Car Loan TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		carLoan = landingPage.navigateToCarLoan();
		carLoan.setHomeAmountSlider("carLoanamountSlider_Xpath", 15, 20, 0);
		carLoan.assertequals("15,00,000", carLoan.readText("carLoanamountTextBox_Xpath"));
		carLoan.setInterestRateSlider("carInterestRateSlider_Xpath", 9.5, 20, 5);
		carLoan.assertequals("9.5", carLoan.readText("carInterestRateTextBox_Xpath"));
		carLoan.setLoanTenureSlider("carLoanTennureSlider_Xpath", 1, 7, 0);
		carLoan.takeScreenShot();
		carLoan.assertequals("1", carLoan.readText("carLoanTennureTextBox_Xpath"));
		carLoan.displayEmiDetails();
		carLoan.softAssert.assertAll();
	}

	@Test
	public void verifyCarLoanPageNavigation() {
		logger = report.createTest("Car Loan TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		carLoan = landingPage.navigateToCarLoan();
		carLoan.assertequals("Car Loan Amount", pageBase.getElement("carLoanAmountText_CSS").getText());
		carLoan.softAssert.assertAll();
		
	}

	@Test
	public void verifyCarLoanAmountFieldForNumbericInputValue() {
		logger = report
				.createTest("To check that the application should accept  numeric values in Car Loan Amount field.");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		carLoan = landingPage.navigateToCarLoan();
		carLoan.clearFieldandGiveInput("carLoanamountTextBox_Xpath", "1500000");
		carLoan.assertequals("15,00,000", carLoan.readText("carLoanamountTextBox_Xpath"));
		carLoan.softAssert.assertAll();
		
	}

	@Test
	public void verifyInterestRateFieldForNumbericInputValue() {
		logger = report
				.createTest("To check that the application should not accept  alphabets in Car Loan Amount field.");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		carLoan = landingPage.navigateToCarLoan();
		carLoan.clearFieldandGiveInput("carInterestRateTextBox_Xpath", "9.5");
		carLoan.assertequals("9.5", carLoan.readText("carInterestRateTextBox_Xpath"));
		carLoan.softAssert.assertAll();
		
	}

	@Test
	public void verifyLoantennureFieldForNumbericInputValue() {
		logger = report.createTest("To check that the application should accept  numeric values in Loan Tenure field.");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		carLoan = landingPage.navigateToCarLoan();
		carLoan.clearFieldandGiveInput("carLoanTennureTextBox_Xpath", "1");
		carLoan.assertequals("1", carLoan.readText("carLoanTennureTextBox_Xpath"));
		carLoan.softAssert.assertAll();
		
	}

	@Test
	public void verifyCarLoanAmountFieldForAlphabeticInputValue() {
		logger = report
				.createTest("To check that the application should accept  alphabetic values in Car Loan Amount field.");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		carLoan = landingPage.navigateToCarLoan();
		carLoan.clearFieldandGiveInput("carLoanamountTextBox_Xpath", "qwerty");
		carLoan.assertequals("qwerty", carLoan.readText("carLoanamountTextBox_Xpath"));
		carLoan.softAssert.assertAll();
		
	}

	@Test
	public void verifyInterestRateFieldForAlphabeticInputValue() {
		logger = report.createTest(
				"To check that the application should not accept  alphabetics value in Car Loan Amount field.");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		carLoan = landingPage.navigateToCarLoan();
		carLoan.clearFieldandGiveInput("carInterestRateTextBox_Xpath", "qwerty");
		carLoan.assertequals("qwerty", carLoan.readText("carInterestRateTextBox_Xpath"));
		carLoan.softAssert.assertAll();
		
	}

	@Test
	public void verifyLoantennureFieldForAlphabeticInputValue() {
		logger = report
				.createTest("To check that the application should accept  alphabetics values in Loan Tenure field.");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		carLoan = landingPage.navigateToCarLoan();
		carLoan.clearFieldandGiveInput("carLoanTennureTextBox_Xpath", "qwerty");
		carLoan.assertequals("qwerty", carLoan.readText("carLoanTennureTextBox_Xpath"));
		carLoan.softAssert.assertAll();
		
	}

	@Test
	public void verifyCarLoanAmountFieldForSpecialCharactersInputValue() {
		logger = report.createTest(
				"To check that the application should accept  special characters values in Car Loan Amount field.");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		carLoan = landingPage.navigateToCarLoan();
		carLoan.clearFieldandGiveInput("carLoanamountTextBox_Xpath", "!@#$%");
		carLoan.assertequals("!@#$%", carLoan.readText("carLoanamountTextBox_Xpath"));
		carLoan.softAssert.assertAll();
		
	}

	@Test
	public void verifyInterestRateFieldForSpecialCharactersInputValue() {
		logger = report.createTest(
				"To check that the application should not accept  special characters value in Car Loan Amount field.");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		carLoan = landingPage.navigateToCarLoan();
		carLoan.clearFieldandGiveInput("carInterestRateTextBox_Xpath", "!@#$%");
		carLoan.assertequals("!@#$%", carLoan.readText("carInterestRateTextBox_Xpath"));
		carLoan.softAssert.assertAll();
		
	}

	@Test
	public void verifyLoantennureFieldForSpecialCharactersInputValue() {
		logger = report.createTest(
				"To check that the application should accept  special characters values in Loan Tenure field.");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		carLoan = landingPage.navigateToCarLoan();
		carLoan.clearFieldandGiveInput("carLoanTennureTextBox_Xpath", "!@#$%");
		carLoan.assertequals("!@#$%", carLoan.readText("carLoanTennureTextBox_Xpath"));
		carLoan.softAssert.assertAll();
		
	}

}
