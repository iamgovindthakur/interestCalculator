package testCase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import pageClasses.LandingPage;
import pageClasses.LoanCalulatorPage;

public class LoanEmiCalculator extends BaseTestClass {

	LandingPage lp;
	LoanCalulatorPage loanCalculator;
	
	
	@Test(groups="Main_TestCase")
	public void testEMICalculator() {
		logger = report.createTest("Loan EMI Calculator TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToEmiCalculator();
		loanCalculator.setLoanAmountSlider("loanamountslider_Xpath", 15, 200, 0);
		loanCalculator.assertequals("15,00,000", loanCalculator.readText("loanAmountTextBox_Xpath"));
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
	public void testEMICalculatorAmountFieldForNumbericInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToEmiCalculator();
		loanCalculator.clearFieldandGiveInput("loanAmountTextBox_Xpath", "2500000");
		loanCalculator.assertequals("25,00,000", loanCalculator.readText("loanAmountTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testEMICalculatorAmountFieldForAlphabeticInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToEmiCalculator();
		loanCalculator.clearFieldandGiveInput("loanAmountTextBox_Xpath", "qwerty");
		loanCalculator.assertequals("qwerty", loanCalculator.readText("loanAmountTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testEMICalculatorAmountFieldForSpecialCharactersInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToEmiCalculator();
		loanCalculator.clearFieldandGiveInput("loanAmountTextBox_Xpath", "!@#$%");
		loanCalculator.assertequals("!@#$%", loanCalculator.readText("loanAmountTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testEMICalculatorInterestRateFieldForNumbericInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToEmiCalculator();
		loanCalculator.clearFieldandGiveInput("loanInterestRateTextBox_Xpath", "9.5");
		loanCalculator.assertequals("9.5", loanCalculator.readText("loanInterestRateTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testEMICalculatorInterestRateFieldForAlphabeticInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToEmiCalculator();
		loanCalculator.clearFieldandGiveInput("loanInterestRateTextBox_Xpath", "qwerty");
		loanCalculator.assertequals("qwerty", loanCalculator.readText("loanInterestRateTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testEMICalculatorInterestRateFieldForSpecialCharactersInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToEmiCalculator();
		loanCalculator.clearFieldandGiveInput("loanInterestRateTextBox_Xpath", "!@#$%");
		loanCalculator.assertequals("!@#$%", loanCalculator.readText("loanInterestRateTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testEMICalculatorLoanTenureFieldForNumbericInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToEmiCalculator();
		loanCalculator.clearFieldandGiveInput("loanTennureTextBox_Xpath", "1");
		loanCalculator.assertequals("1", loanCalculator.readText("loanTennureTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testEMICalculatorLoanTenureFieldForAlphabeticInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToEmiCalculator();
		loanCalculator.clearFieldandGiveInput("loanTennureTextBox_Xpath", "qwerty");
		loanCalculator.assertequals("qwerty", loanCalculator.readText("loanTennureTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testEMICalculatorLoanTenureFieldForSpecialCharactersInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToEmiCalculator();
		loanCalculator.clearFieldandGiveInput("loanTennureTextBox_Xpath", "!@#$%");
		loanCalculator.assertequals("!@#$%", loanCalculator.readText("loanTennureTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testEMICalculatorFeesNChargesFieldForNumbericInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToEmiCalculator();
		loanCalculator.clearFieldandGiveInput("loanFeesNChargesTextBox_Xpath", "25000");
		loanCalculator.assertequals("25,000", loanCalculator.readText("loanFeesNChargesTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testEMICalculatorFeesNChargesForAlphabeticInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToEmiCalculator();
		loanCalculator.clearFieldandGiveInput("loanFeesNChargesTextBox_Xpath", "qwerty");
		loanCalculator.assertequals("qwerty", loanCalculator.readText("loanFeesNChargesTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}

	@Test
	public void testEMICalculatorFeesNChargesFieldForSpecialCharactersInputValue() {
		logger = report.createTest("Loan Calculator EMI TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		loanCalculator = lp.navigateToloanCalculator();
		loanCalculator.navigateToEmiCalculator();
		loanCalculator.clearFieldandGiveInput("loanFeesNChargesTextBox_Xpath", "!@#$%");
		loanCalculator.assertequals("!@#$%", loanCalculator.readText("loanFeesNChargesTextBox_Xpath"));
		loanCalculator.softAssert.assertAll();
		
	}
}
