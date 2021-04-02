package testCase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import pageClasses.HomeLoanEMIPAGE;
import pageClasses.LandingPage;

public class HomeLoanEMICalculator extends BaseTestClass {

	LandingPage lp;
	HomeLoanEMIPAGE homeLoanEmi;
	String[][] data;
	
	

	@Test(groups = "Main_TestCase")
	public void testHomeLoanEMICalculator() throws InterruptedException, IOException {
		logger = report.createTest("Home Loan EMI calculator TestCase Report");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanTenureTextBox_Xpath", "25");
		homeLoanEmi.clearFieldandGiveInput("homeValueTextBox_Xpath", "2500000");
		homeLoanEmi.clearFieldandGiveInput("marginTextBox_Xpath", "25");
		homeLoanEmi.clearFieldandGiveInput("homeLoanInsuranceTextBox_Xpath", "2500");
		homeLoanEmi.clearFieldandGiveInput("homeInterestRateTextBox_Xpath", "9.5");
		homeLoanEmi.clearFieldandGiveInput("homeLoanTenureTextBox_Xpath", "15");
		homeLoanEmi.takeScreenShotOfWebelement("homeLoanPaymentScheduleDiv_Xpath");
		homeLoanEmi.prepareExcelReport();
		
	}

	@Test
	public void testhomeLoanEMICalculatorHomeValueFieldForNumbericInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should accept numeric values in Home Value field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeValueTextBox_Xpath", "2500000");
		homeLoanEmi.assertequals("25,00,000", homeLoanEmi.readText("homeValueTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorHomeValueFieldForAlphabeticInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept alphabetic values in Home Value field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeValueTextBox_Xpath", "qwerty");
		homeLoanEmi.assertequals("qwerty", homeLoanEmi.readText("homeValueTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorHomeValueFieldForSpecialCharactersInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept special characters values in Home Value field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeValueTextBox_Xpath", "!@#$%");
		homeLoanEmi.assertequals("!@#$%", homeLoanEmi.readText("homeValueTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorMarginFieldForNumbericInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should accept numeric values in Margin OR Down Payment field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("marginTextBox_Xpath", "25");
		homeLoanEmi.assertequals("25", homeLoanEmi.readText("marginTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorMarginFieldForAlphabeticInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept alphabetic values in Margin OR Down Payment field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("marginTextBox_Xpath", "qwerty");
		homeLoanEmi.assertequals("qwerty", homeLoanEmi.readText("marginTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorMarginFieldForSpecialCharactersInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept special characters values in Margin OR Down Payment field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("marginTextBox_Xpath", "!@#$%");
		homeLoanEmi.assertequals("!@#$%", homeLoanEmi.readText("marginTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorLoanInsuranceFieldForNumbericInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should accept numeric values in Loan Insurance field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanInsuranceTextBox_Xpath", "2500");
		homeLoanEmi.assertequals("2,500", homeLoanEmi.readText("homeLoanInsuranceTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorLoanInsuranceFieldForAlphabeticInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept alphabetic values in Loan Insurance field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanInsuranceTextBox_Xpath", "qwerty");
		homeLoanEmi.assertequals("qwerty", homeLoanEmi.readText("homeLoanInsuranceTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorLoanInsuranceFieldForSpecialCharactersInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept special characters values in Loan Insurance field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanInsuranceTextBox_Xpath", "!@#$%");
		homeLoanEmi.assertequals("!@#$%", homeLoanEmi.readText("homeLoanInsuranceTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorInterestRateFieldForNumbericInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should accept numeric values in Interest Rate field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeInterestRateTextBox_Xpath", "9.5");
		homeLoanEmi.assertequals("9.5", homeLoanEmi.readText("homeInterestRateTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorInterestRateFieldForAlphabeticInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept alphabetic values in Interest Rate field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeInterestRateTextBox_Xpath", "qwerty");
		homeLoanEmi.assertequals("qwerty", homeLoanEmi.readText("homeInterestRateTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorInterestRateFieldForSpecialCharactersInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept special characters values in Interest Rate field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeInterestRateTextBox_Xpath", "!@#$%");
		homeLoanEmi.assertequals("!@#$%", homeLoanEmi.readText("homeInterestRateTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorLoanTenureFieldForNumbericInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should accept numeric values in Loan Tenure field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanTenureTextBox_Xpath", "15");
		homeLoanEmi.assertequals("15", homeLoanEmi.readText("homeLoanTenureTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorLoanTenureFieldForAlphabeticInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept alphabetic values in Loan Tenure field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanTenureTextBox_Xpath", "qwerty");
		homeLoanEmi.assertequals("qwerty", homeLoanEmi.readText("homeLoanTenureTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorLoanTenureFieldForSpecialCharactersInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept special characters values in Loan Tenure field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanTenureTextBox_Xpath", "!@#$%");
		homeLoanEmi.assertequals("!@#$%", homeLoanEmi.readText("homeLoanTenureTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorFeesNChargesFieldForNumbericInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should accept numeric values in Loan Fees & Charges field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanFeeTextBox_Xpath", "2.25");
		homeLoanEmi.assertequals("2.25", homeLoanEmi.readText("homeLoanFeeTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorFeesNChargesFieldForAlphabeticInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept alphabetic values in Loan Fees & Charges field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanFeeTextBox_Xpath", "qwerty");
		homeLoanEmi.assertequals("qwerty", homeLoanEmi.readText("homeLoanFeeTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorFeesNChargesFieldForSpecialCharactersInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept special characters values in Loan Fees & Charges field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanFeeTextBox_Xpath", "!@#$%");
		homeLoanEmi.assertequals("!@#$%", homeLoanEmi.readText("homeLoanFeeTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorOneTimeExpensesFieldForNumbericInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should accept numeric values in One-time Expenses field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanOneTimeExpensesTextBox_Xpath", "15");
		homeLoanEmi.assertequals("15", homeLoanEmi.readText("homeLoanOneTimeExpensesTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorOneTimeExpensesFieldForAlphabeticInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept alphabetic values in One-time Expenses field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanOneTimeExpensesTextBox_Xpath", "qwerty");
		homeLoanEmi.assertequals("qwerty", homeLoanEmi.readText("homeLoanOneTimeExpensesTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorOneTimeExpensesFieldForSpecialCharactersInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept special characters values in One-time Expenses field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanOneTimeExpensesTextBox_Xpath", "!@#$%");
		homeLoanEmi.assertequals("!@#$%", homeLoanEmi.readText("homeLoanOneTimeExpensesTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorPropertyTaxFieldForNumbericInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should accept numeric values in Home Value field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanPropertyTaxTextBox_Xpath", "0.35");
		homeLoanEmi.assertequals("0.35", homeLoanEmi.readText("homeLoanPropertyTaxTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorPropertyTaxFieldForAlphabeticInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept alphabetic values in Property Taxes / year field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanPropertyTaxTextBox_Xpath", "qwerty");
		homeLoanEmi.assertequals("qwerty", homeLoanEmi.readText("homeLoanPropertyTaxTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorPropertyTaxFieldForSpecialCharactersInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept special characters values in Property Taxes / year field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanPropertyTaxTextBox_Xpath", "!@#$%");
		homeLoanEmi.assertequals("!@#$%", homeLoanEmi.readText("homeLoanPropertyTaxTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorHomeInsuranceFieldForNumbericInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should accept numeric values in Home Insurance / year field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanHomeInsuranceTextBox_Xpath", "0.25");
		homeLoanEmi.assertequals("0.25", homeLoanEmi.readText("homeLoanHomeInsuranceTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorHomeInsuranceFieldForAlphabeticInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept alphabetic values in Home Insurance / year field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanHomeInsuranceTextBox_Xpath", "qwerty");
		homeLoanEmi.assertequals("qwerty", homeLoanEmi.readText("homeLoanHomeInsuranceTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorHomeInsuranceFieldForSpecialCharactersInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept special characters values in Home Insurance / year field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanHomeInsuranceTextBox_Xpath", "!@#$%");
		homeLoanEmi.assertequals("!@#$%", homeLoanEmi.readText("homeLoanHomeInsuranceTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorMaintenanceExpensesFieldForNumbericInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should accept numeric values in Maintenance Expenses / month field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanMaintenanceExpensesTextBox_Xpath", "2700");
		homeLoanEmi.assertequals("2,700", homeLoanEmi.readText("homeLoanMaintenanceExpensesTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorMaintenanceExpensesFieldForAlphabeticInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept alphabetic values in Maintenance Expenses / month field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanMaintenanceExpensesTextBox_Xpath", "qwerty");
		homeLoanEmi.assertequals("qwerty", homeLoanEmi.readText("homeLoanMaintenanceExpensesTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}

	@Test
	public void testHomeLoanEMICalculatorMaintenanceExpensesFieldForSpecialCharactersInputValue() {
		logger = report.createTest(
				"TestCase Report: To check that application should not accept special characters values in Maintenance Expenses / month field");
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		lp = pageBase.OpenApplication();
		homeLoanEmi = lp.navigateToHomeLoanEMICalculator();
		homeLoanEmi.clearFieldandGiveInput("homeLoanMaintenanceExpensesTextBox_Xpath", "!@#$%");
		homeLoanEmi.assertequals("!@#$%", homeLoanEmi.readText("homeLoanMaintenanceExpensesTextBox_Xpath"));
		homeLoanEmi.softAssert.assertAll();
		
	}
}
