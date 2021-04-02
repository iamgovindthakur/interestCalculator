package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExtentReportManager;

public class BaseTestClass {

	public WebDriver driver;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	public static Properties prop;

	/****************** Invoke Browser ***********************/
	public void invokeBrowser(String browserName) {

		try {

			if (browserName.equalsIgnoreCase("Chrome")) {

				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addExtensions(new File("./src/test/resources/AdBlock.crx"));
				driver = new ChromeDriver(options);

			} else if (browserName.equalsIgnoreCase("Mozila")) {

				WebDriverManager.firefoxdriver().setup();
				FirefoxBinary firefoxBinary = new FirefoxBinary();
				firefoxBinary.addCommandLineOptions("--headless");
				FirefoxProfile profile = new FirefoxProfile();
				profile.addExtension(new File(("./src/test/resources/AdBlock.xpi")));
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setBinary(firefoxBinary);
				firefoxOptions.setProfile(profile);
				driver = new FirefoxDriver(firefoxOptions);
			} else if (browserName.equalsIgnoreCase("Opera")) {

				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {

				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			} else {

				driver = new SafariDriver();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		if (prop == null) {
			prop = new Properties();

			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")
						+ "//src/test//resources//ObjectRepository//projectConfig.properties");
				prop.load(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@AfterMethod(alwaysRun = true)
	public void flushReports() {
		report.flush();
		driver.quit();
	}

}
