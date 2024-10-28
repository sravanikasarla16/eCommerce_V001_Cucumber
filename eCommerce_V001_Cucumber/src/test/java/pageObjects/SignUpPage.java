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

public class SignUpPage extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;
	WaitHelper waithelper;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	// ****************** Locators **********************

	@FindBy(xpath = "//a[@id='signin2']")
	WebElement clickOnSignUp;

	@FindBy(css = "input#sign-username.form-control")
	WebElement inputUserName;

	@FindBy(css = "input#sign-password.form-control")
	WebElement inputPassword;

	@FindBy(xpath = "//button[@type='button' and @onclick='register()']") // Finally to click on signnup
	WebElement clickOnSignupToRegister;

	@FindBy(xpath = "//a[@id='login2']")
	WebElement clickOnLogIn;

	@FindBy(xpath = "//input[@id='loginusername']")
	WebElement enterLoginUserName;

	@FindBy(xpath = "//input[@id='loginpassword']")
    WebElement enterLoginPassword;
	
	@FindBy(xpath = "//button[@onclick='logIn()' and text()='Log in']")
	WebElement clickOnLogInButton;

	@FindBy(xpath = "//a[@id='logout2' and text()='Log out']")
	WebElement clickOnLogOut;


	public void clickOnSignUp() {
		waithelper.waitForVisibilityOf(clickOnSignUp);
		waithelper.highlightAndClickElement(clickOnSignUp, "pink");

	}

	public void enterSignUpUserName(String uname) {
		waithelper.waitForVisibilityOf(inputUserName);
		waithelper.highlightAndClickElement(inputUserName, "yellow");
		inputUserName.sendKeys(uname);
	}

	public void enterSignUpPassword(String pwd) {
		waithelper.waitForVisibilityOf(inputPassword);
		waithelper.highlightAndClickElement(inputPassword, "pink");
	    inputPassword.sendKeys(pwd);
	}

	public void clickOnSignUpButton() {
		waithelper.waitForVisibilityOf(clickOnSignupToRegister);
		waithelper.highlightAndClickElement(clickOnSignupToRegister, "orange");
	}

	public void acceptAlert() {
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}

	public void blankDetails() {
		waithelper.waitForVisibilityOf(inputUserName);
		waithelper.highlightAndClickElement(inputUserName,"yellow");
		inputUserName.clear();
		waithelper.waitForVisibilityOf(inputPassword);
		waithelper.highlightAndClickElement(inputPassword,"pink");
		inputPassword.clear();
}
	
	public void clickOnLogin() {
		waithelper.waitForVisibilityOf(clickOnLogIn);
		waithelper.highlightAndClickElement(clickOnLogIn, "green");
	}

	public void enterLoginUserName(String luname) {
		waithelper.waitForVisibilityOf(enterLoginUserName);
		waithelper.highlightAndClickElement(enterLoginUserName, "orange");
		enterLoginUserName.sendKeys(luname);
	}

	public void enterLoginPassword(String lpwd) {
		waithelper.waitForVisibilityOf(enterLoginPassword);
		waithelper.highlightAndClickElement(enterLoginPassword, "pink");
		enterLoginPassword.sendKeys(lpwd);
	}
	public void clickOnLogInButton() {
		
		waithelper.waitForVisibilityOf(clickOnLogInButton);
		waithelper.highlightAndClickElement(clickOnLogInButton, "grey");
	}

	public void clickOnLogout() {
		waithelper.waitForVisibilityOf(clickOnLogOut);
		waithelper.highlightAndClickElement(clickOnLogOut, "yellow");
	}
}
