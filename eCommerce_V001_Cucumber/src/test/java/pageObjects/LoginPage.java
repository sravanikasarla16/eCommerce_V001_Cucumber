package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.BaseClass;
import utilities.WaitHelper;

public class LoginPage extends BaseClass {
	WebDriver driver;
	WebDriverWait wait;
	WaitHelper waithelper;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		waithelper= new WaitHelper(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}

// ************** Locators For Valid Login Credentials************
	
	@FindBy(xpath ="//a[@id='login2']")
	WebElement clickOnLogIn;

	@FindBy(css = "#loginusername")
	public
	WebElement enterUserName;

	@FindBy(css = "input#loginpassword")
	public WebElement enterSignPassword;

	@FindBy(css = "[onclick='logIn()']")
	WebElement clickOnButtonLogIn;

	@FindBy(xpath= "//a[@id='logout2' and text()='Log out']")
	WebElement clickOnLogOut;
	
	@FindBy(xpath= "(//button[@type='button' and @class='btn btn-secondary'])[3])")
	WebElement clickOnClose;


	public void clickOnLogIn() {
		waithelper.waitForVisibilityOf(clickOnLogIn);
		waithelper.highlightAndClickElement(clickOnLogIn,"red");
	}
	public void enterUserNameAndPassword(String uname, String pwd) {
		waithelper.waitForVisibilityOf(enterUserName);
		waithelper.highlightAndClickElement(enterUserName,"yellow");
		enterUserName.clear();
		enterUserName.sendKeys(uname);
		waithelper.highlightAndClickElement(enterSignPassword,"yellow");
		enterSignPassword.clear();
		enterSignPassword.sendKeys(pwd);
	}
	public void clickOnLogInButton() {
		waithelper.waitForVisibilityOf(clickOnButtonLogIn);
		waithelper.highlightAndClickElement(clickOnButtonLogIn,"orange");
	}
	public void clickOnLogOut() {
		waithelper.waitForVisibilityOf(clickOnLogOut);
		waithelper.highlightAndClickElement(clickOnLogOut,"pink");
	}
	
	public void enterBlankDetails() {
		waithelper.waitForVisibilityOf(enterUserName);
		waithelper.highlightAndClickElement(enterUserName,"yellow");
		enterUserName.clear();
		waithelper.waitForVisibilityOf(enterSignPassword);
		waithelper.highlightAndClickElement(enterSignPassword,"pink");
		enterSignPassword.clear();
	}
	public void acceptAlert() {
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	
	}
   	public void clickOnClose() {
   		waithelper.waitForVisibilityOf(clickOnClose);
   		waithelper.highlightAndClickElement(clickOnClose,"pink");
			
	}
}


