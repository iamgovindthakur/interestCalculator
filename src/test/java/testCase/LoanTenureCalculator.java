package testCase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import pageClasses.LandingPage;
import pageClasses.LoanCalulatorPage;

public class LoanTenureCalculator extends BaseTestClass {

	LandingPage lp;
	LoanCalulatorPage loanCalculator;
	

	@Test(groups="Main_TestCase")
	public void testLoanTenureCalculator() {
		logger = report.createTest("Loan Tenure Calculator TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanTenureCalculator();
		loanCalculator.setLoanAmountSlider("loanamountslider_Xpath", 15, 200, 0);
		loanCalculator.assertequals("15,00,000", loanCalculator.readText("loanAmountTextBox_Xpath"));
		loanCalculator.setLoanAmountSlider("loanEmislider_Xpath", 0.25, 1, 0);
		loanCalculator.assertequals("25,000.00", loanCalculator.readText("loanEmiTextBox_Xpath"));
		loanCalculator.setInterestRateSlider("loanInterestRateSlider_Xpath", 9.5, 20, 0);
		loanCalculator.assertequals("9.5", loanCalculator.readText("loanInterestRateTextBox_Xpath"));
		loanCalculator.setLoanFeeChargesSlider("loanFeesslider_Xpath", .45, 1, 0);
		loanCalculator.assertequals("45,000", loanCalculator.readText("loanFeesNChargesTextBox_Xpath"));
		loanCalculator.displayLoanEmi();
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanTenureCalculatorAmountFieldForNumbericInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should accept numeric values in Loan Amount field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		System.out.println(driver.getWindowHandle());
		loanCalculator.navigateToLoanTenureCalculator();
		loanCalculator.clearFieldandGiveInput("loanAmountTextBox_Xpath", "2500000");
		loanCalculator.assertequals("25,00,000", loanCalculator.readText("loanAmountTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanTenureCalculatorAmountFieldForAlphabeticInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept alphabets in Loan Amount field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanTenureCalculator();
		loanCalculator.clearFieldandGiveInput("loanAmountTextBox_Xpath", "qwerty");
		loanCalculator.assertequals("qwerty", loanCalculator.readText("loanAmountTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanTenureCalculatorAmountFieldForSpecialCharactersInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept special characters in Loan Amount field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanTenureCalculator();
		loanCalculator.clearFieldandGiveInput("loanAmountTextBox_Xpath", "!@#$%");
		loanCalculator.assertequals("!@#$%", loanCalculator.readText("loanAmountTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanTenureCalculatorEmiFieldForNumbericInputValue() {
		logger = report
				.createTest("TestCase Report: To check that application should accept numeric values in EMI field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanTenureCalculator();
		loanCalculator.clearFieldandGiveInput("loanEmiTextBox_Xpath", "40000");
		loanCalculator.assertequals("40,000.00", loanCalculator.readText("loanEmiTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanTenureCalculatorEmiFieldForAlphabeticInputValue() {
		logger = report
				.createTest("TestCase Report: To check that application should not accept alphabets in EMI field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanTenureCalculator();
		loanCalculator.clearFieldandGiveInput("loanEmiTextBox_Xpath", "qwerty");
		loanCalculator.assertequals("qwerty", loanCalculator.readText("loanEmiTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanTenureCalculatorEmiFieldForSpecialCharactersInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept special characters in EMI field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanTenureCalculator();
		loanCalculator.clearFieldandGiveInput("loanEmiTextBox_Xpath", "!@#$");
		loanCalculator.assertequals("!@#$", loanCalculator.readText("loanEmiTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanTenureCalculatorInterestRateForNumbericInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should accept numeric values in Interest Rate field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanTenureCalculator();
		loanCalculator.clearFieldandGiveInput("loanInterestRateTextBox_Xpath", "9.5");
		loanCalculator.assertequals("9.5", loanCalculator.readText("loanInterestRateTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanTenureCalculatorInterestRateForAlphabeticInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept alphabets in Interest Rate field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanTenureCalculator();
		loanCalculator.clearFieldandGiveInput("loanInterestRateTextBox_Xpath", "qwerty");
		loanCalculator.assertequals("qwerty", loanCalculator.readText("loanInterestRateTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanTenureCalculatorInterestRateForSpecialCharactersInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept special characters in Interest Rate field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanTenureCalculator();
		loanCalculator.clearFieldandGiveInput("loanInterestRateTextBox_Xpath", "!@#$%");
		loanCalculator.assertequals("!@#$%", loanCalculator.readText("loanInterestRateTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanTenureFeesNChargesFieldForNumbericInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should accept numeric values in Fees & Charges field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanTenureCalculator();
		loanCalculator.clearFieldandGiveInput("loanFeesNChargesTextBox_Xpath", "25000");
		loanCalculator.assertequals("25,000", loanCalculator.readText("loanFeesNChargesTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanTenureFeesNChargesForAlphabeticInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept alphabets in Fees & Charges field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanTenureCalculator();
		loanCalculator.clearFieldandGiveInput("loanFeesNChargesTextBox_Xpath", "qwerty");
		loanCalculator.assertequals("qwerty", loanCalculator.readText("loanFeesNChargesTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanTenureFeesNChargesFieldForSpecialCharactersInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept special characters in Fees & Charges field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanTenureCalculator();
		loanCalculator.clearFieldandGiveInput("loanFeesNChargesTextBox_Xpath", "!@#$%");
		loanCalculator.assertequals("!@#$%", loanCalculator.readText("loanFeesNChargesTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

}
