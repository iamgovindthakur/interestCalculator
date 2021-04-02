package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class LandingPage extends PageBaseClass {

	public LandingPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	/* Navigate to car loan page from landing page */
	public CarLoanPage navigateToCarLoan() {
		logger.log(Status.INFO, "Identifying the Car Loan Link");
		elementClick("carLoanLink_Xpath");
		logger.log(Status.PASS, "Car Loan Link identified and Clicked");
		CarLoanPage carLoanPage = new CarLoanPage(driver, logger);
		PageFactory.initElements(driver, carLoanPage);
		return carLoanPage;

	}

	/* Navigate to loan calculator page from landing page */
	public LoanCalulatorPage navigateToloanCalculator() {

		elementClick("menuDropDown_Id");
		elementClick("loanCalculator_Xpath");
		LoanCalulatorPage loanCalulatorPage = new LoanCalulatorPage(driver, logger);
		PageFactory.initElements(driver, loanCalulatorPage);
		return loanCalulatorPage;
	}

	/* Navigate to home loan EMI page from landing page */
	public HomeLoanEMIPAGE navigateToHomeLoanEMICalculator() {

		elementClick("menuDropDown_Id");
		elementClick("homeLoanEMICalculator_Xpath");
		HomeLoanEMIPAGE homeLoanEMIPAGE = new HomeLoanEMIPAGE(driver, logger);
		PageFactory.initElements(driver, homeLoanEMIPAGE);
		return homeLoanEMIPAGE;

	}

}
