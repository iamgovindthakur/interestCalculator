package pageClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class HomeLoanEMIPAGE extends PageBaseClass {

	public HomeLoanEMIPAGE(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	/* Clearing Text Box Pre Loaded Value And Give New Input Value */
	public void clearFieldandGiveInput(String locator, String input) {
		getElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), input, Keys.TAB);
		takeScreenShot();
		logger.log(Status.PASS, "ScreenShot captured of locator" + locator);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	/* Generating Home Loan Payment Schedule Excel Report */
	public void prepareExcelReport() {

		int rowNum = driver.findElements(By.xpath("//*[@id='paymentschedule']/table/tbody/tr")).size();
		int colNum = driver.findElements(By.xpath("//*[@id='paymentschedule']/table/tbody/tr[1]/th")).size();

		int Excelrownum = 1;
		File src = new File("Home Loan Payment Schedule.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("payment schedule");
		XSSFRow headerRow = sheet.createRow(0);
		for (int x = 1; x <= colNum; x++) {
			WebElement colHeader1 = driver
					.findElement(By.xpath("//*[@id='paymentschedule']/table/tbody/tr[1]/th[" + x + "]"));

			headerRow.createCell(x - 1).setCellValue((colHeader1.getText().replaceAll("\\r\\n|\\r|\\n", " ")));
			sheet.autoSizeColumn(x - 1);
		}

		for (int i = 2; i < rowNum; i += 2) {
			XSSFRow row = sheet.createRow(Excelrownum++);

			for (int j = 1; j <= colNum; j++) {
				WebElement item = driver
						.findElement(By.xpath("//*[@id=\"paymentschedule\"]/table/tbody/tr[" + i + "]/td[" + j + "]"));
				row.createCell(j - 1).setCellValue((item.getText()));
			}
		}

		FileOutputStream fout;

		try {
			fout = new FileOutputStream(src);
			wb.write(fout);
			fout.close();
			wb.close();
			logger.log(Status.PASS, "Table data succesfully exported to file name Home Loan Payment Schedule.xlsx");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
