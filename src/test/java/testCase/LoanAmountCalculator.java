package testCase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import pageClasses.LandingPage;
import pageClasses.LoanCalulatorPage;

public class LoanAmountCalculator extends BaseTestClass {

	LandingPage lp;
	LoanCalulatorPage loanCalculator;
	
	

	@Test(groups="Main_TestCase")
	public void testLoanAmountCalculator() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanAmountCalculator();
		loanCalculator.setLoanAmountSlider("loanEmislider_Xpath", 0.25, 1, 0);
		loanCalculator.assertequals("25,000.00", loanCalculator.readText("loanEmiTextBox_Xpath"));
		loanCalculator.setInterestRateSlider("loanInterestRateSlider_Xpath", 9.5, 20, 0);
		loanCalculator.assertequals("9.5", loanCalculator.readText("loanInterestRateTextBox_Xpath"));
		loanCalculator.setLoanTenureSlider("loanTermslider_Xpath", 1, 30, 0);
		loanCalculator.assertequals("1", loanCalculator.readText("loanTennureTextBox_Xpath"));
		loanCalculator.setLoanFeeChargesSlider("loanFeesslider_Xpath", .45, 1, 0);
		loanCalculator.assertequals("45,000", loanCalculator.readText("loanFeesNChargesTextBox_Xpath"));
		loanCalculator.displayLoanEmi();
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanAmountCalculatorEmiFieldForNumbericInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanAmountCalculator();
		loanCalculator.clearFieldandGiveInput("loanEmiTextBox_Xpath", "40000");
		loanCalculator.assertequals("40,000.00", loanCalculator.readText("loanEmiTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanAmountCalculatorEmiFieldForAlphabeticInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanAmountCalculator();
		loanCalculator.clearFieldandGiveInput("loanEmiTextBox_Xpath", "qwerty");
		loanCalculator.assertequals("qwerty", loanCalculator.readText("loanEmiTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanAmountCalculatorEmiFieldForSpecialCharactersInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanAmountCalculator();
		loanCalculator.clearFieldandGiveInput("loanEmiTextBox_Xpath", "!@#$");
		loanCalculator.assertequals("!@#$", loanCalculator.readText("loanEmiTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanAmountCalculatorInterestRateForNumbericInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanAmountCalculator();
		loanCalculator.clearFieldandGiveInput("loanInterestRateTextBox_Xpath", "9.5");
		loanCalculator.assertequals("9.5", loanCalculator.readText("loanInterestRateTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanAmountCalculatorInterestRateForAlphabeticInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanAmountCalculator();
		loanCalculator.clearFieldandGiveInput("loanInterestRateTextBox_Xpath", "qwerty");
		loanCalculator.assertequals("qwerty", loanCalculator.readText("loanInterestRateTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanAmountCalculatorInterestRateForSpecialCharactersInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanAmountCalculator();
		loanCalculator.clearFieldandGiveInput("loanInterestRateTextBox_Xpath", "!@#$%");
		loanCalculator.assertequals("!@#$%", loanCalculator.readText("loanInterestRateTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanAmountCalculatorLoanTenureForNumbericInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanAmountCalculator();
		loanCalculator.clearFieldandGiveInput("loanTennureTextBox_Xpath", "1");
		loanCalculator.assertequals("1", loanCalculator.readText("loanTennureTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanAmountCalculatorLoanTenureForAlphabeticInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanAmountCalculator();
		loanCalculator.clearFieldandGiveInput("loanTennureTextBox_Xpath", "qwerty");
		loanCalculator.assertequals("qwerty", loanCalculator.readText("loanTennureTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanAmountCalculatorLoanTenureForSpecialCharctersInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanAmountCalculator();
		loanCalculator.clearFieldandGiveInput("loanTennureTextBox_Xpath", "!@#$%");
		loanCalculator.assertequals("!@#$%", loanCalculator.readText("loanTennureTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanAmountCalculatorFeesNChargesForNumbericInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanAmountCalculator();
		loanCalculator.clearFieldandGiveInput("loanFeesNChargesTextBox_Xpath", "45000");
		loanCalculator.assertequals("45,000", loanCalculator.readText("loanFeesNChargesTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanAmountCalculatorFeesNChargesForAlphabeticInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanAmountCalculator();
		loanCalculator.clearFieldandGiveInput("loanFeesNChargesTextBox_Xpath", "qwerty");
		loanCalculator.assertequals("qwerty", loanCalculator.readText("loanFeesNChargesTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testLoanAmountCalculatorFeesNChargesForSpecilaCharactersInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToLoanAmountCalculator();
		loanCalculator.clearFieldandGiveInput("loanFeesNChargesTextBox_Xpath", "!@#$%");
		loanCalculator.assertequals("!@#$%", loanCalculator.readText("loanFeesNChargesTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

}
