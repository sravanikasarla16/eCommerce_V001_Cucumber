package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.BaseClass;
import utilities.WaitHelper;

public class AboutPage extends BaseClass {
    	
	WebDriver driver;
	WebDriverWait wait;
	WaitHelper waithelper;
	
	   public AboutPage(WebDriver driver) {
	   this.driver = driver;
	   waithelper = new WaitHelper(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));	
		PageFactory.initElements(driver, this);

	}
//	   public void highlightAndClickElement(WebElement element, String color) {
//	        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
//	         wait.until(ExpectedConditions.elementToBeClickable(element)).click();
//	    }
//		
//		  public void waitForVisibilityOf(WebElement element) {
//			  wait.until(ExpectedConditions.visibilityOf(element));
//			  
//	      }
	// **** Locators ****

	@FindBy(xpath ="//a[text()='About us']")
	WebElement aboutUsLink;

	@FindBy(xpath ="//button[@class='vjs-big-play-button\']")
	WebElement playButton;

	@FindBy(xpath ="(//button[@class='btn btn-secondary'])[4]")
	WebElement closeButton;

	// **** Action Methods

	public void clickOnAbout() {
		waithelper.waitForVisibilityOf(aboutUsLink);
		waithelper.highlightAndClickElement(aboutUsLink, "pink");
	//	waithelper.waitForVisibilityOf(aboutUsLink);
	}

	public void clickOnButton()  {
		waithelper.	waitForVisibilityOf(playButton);
		waithelper.highlightAndClickElement(playButton, "red");
		
				}
   
	public void clickOnClose() {
		waithelper.waitForVisibilityOf(closeButton);
		waithelper.highlightAndClickElement(closeButton, "yellow");
		
		
	}

}
