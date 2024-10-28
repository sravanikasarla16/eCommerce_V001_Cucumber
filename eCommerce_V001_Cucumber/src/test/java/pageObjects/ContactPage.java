package pageObjects;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.BaseClass;
import utilities.WaitHelper;

public class ContactPage extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;
	WaitHelper waithelper;

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		waithelper=new WaitHelper(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		PageFactory.initElements(driver, this);
	}


	// *********** Locators **************************

	@FindBy(xpath = "//a[@data-toggle='modal' and @data-target='#exampleModal']")
	WebElement clickOnContact;
	@FindBy(xpath = "//input[@type=\"text\" and @id=\"recipient-email\"]")
	WebElement enterEmail;
	@FindBy(xpath = "//input[@type='text' and @id='recipient-name']")
	WebElement enterName;
	@FindBy(xpath = "//textarea[@id='message-text']")
	WebElement enterText;
	@FindBy(xpath = "//button[@type='button' and @onclick='send()']")
	WebElement sendMessage;
	@FindBy(xpath = "(//button[@type='button' and @data-dismiss='modal'])[2]")
	WebElement contactClose;

	// ******************* Action Methods ***************

	public void clickOnContact() {

		waithelper.highlightAndClickElement(clickOnContact, "cyan");
		waithelper.waitForVisibilityOf(clickOnContact);
	}

	public void enterContactDetails(String filepath) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook(filepath);
		XSSFSheet sheet = workbook.getSheet("contactdetails");
		int rows= sheet.getLastRowNum() +1;
		
		for(int i=1;i<rows;i++) {
			
			Row row = sheet.getRow(i);
		
			Cell emailCell =  row.getCell(0);
			Cell nameCell= row.getCell(1);
			Cell textCell =  row.getCell(2);
			waithelper.highlightAndClickElement(enterEmail, "cyan");
			waithelper.waitForVisibilityOf(enterEmail);
			enterEmail.sendKeys(emailCell.getStringCellValue());
			waithelper.highlightAndClickElement(enterName, "yellow");
			waithelper.waitForVisibilityOf(enterName);
			enterName.sendKeys(nameCell.getStringCellValue());
			waithelper.highlightAndClickElement(enterText, "pink");
			waithelper.waitForVisibilityOf(enterText);
			enterText.sendKeys(textCell.getStringCellValue());
			workbook.close();
			
			
		}
		
		}

	public void sendMessage() {
		waithelper.highlightAndClickElement(sendMessage, "yellow");
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}

	public void contactClose() {
		waithelper.highlightAndClickElement(contactClose, "pink");
		waithelper.waitForVisibilityOf(contactClose);

	}

	
	
	
	
}
