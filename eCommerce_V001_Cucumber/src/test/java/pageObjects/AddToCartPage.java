package pageObjects;
import java.awt.AWTException;
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

public class AddToCartPage extends BaseClass {
	
	public WebDriver driver;
	public WebDriverWait wait;
	WaitHelper waithelper;
	
	
	// Constructors
	
	public AddToCartPage(WebDriver driver) {
		this.driver=driver;
		waithelper= new WaitHelper(driver);
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
				
		
	}
	

	    @FindBy(xpath = "//a[text()='Phones']") private WebElement clickOnPhones;
	    @FindBy(xpath = "//a[text()='Samsung galaxy s6']") private WebElement clickOnSamsungS6;
	    @FindBy(xpath = "//a[text()='Cart']") private WebElement clickOnCart;
	    @FindBy(xpath = "//a[text()='Add to cart']") private WebElement clickOnAddToCart;
	    @FindBy(xpath = "//button[text()='Place Order']") private WebElement placeOrder;
	    @FindBy(xpath = "//label[@id='totalm']") private WebElement totalAmount;
	    @FindBy(xpath = "//input[@id='name']") private WebElement nameInput;
	    @FindBy(xpath = "//input[@id='country']") private WebElement countryInput;
	    @FindBy(xpath = "//input[@id='city']") private WebElement cityInput;
	    @FindBy(xpath = "//input[@id='card']") private WebElement cardInput;
	    @FindBy(xpath = "//input[@id='month']") private WebElement monthInput;
	    @FindBy(xpath = "//input[@id='year']") private WebElement yearInput;
	    @FindBy(xpath = "//button[text()='Purchase']") private WebElement clickOnPurchase;
	    @FindBy(xpath = "(//button[text()='Close'])[3]") private WebElement clickOnClose;
	    @FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']") private WebElement okForSuccessfullOrder;

	    
	   // Action Methods
	    
	   
	
		  public void clickOnPhones() throws InterruptedException, AWTException {
			  waithelper.waitForVisibilityOf(clickOnPhones);
			  waithelper.highlightAndClickElement(clickOnPhones, "yellow");
			  waithelper.waitForVisibilityOf(clickOnSamsungS6);
			  waithelper.highlightAndClickElement(clickOnSamsungS6, "green");
			  waithelper.waitForVisibilityOf(clickOnAddToCart);
			  waithelper.highlightAndClickElement(clickOnAddToCart, "yellow");
		    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
	 
		  }
		  
		
		public void clickOnCart() {
			waithelper.waitForVisibilityOf(clickOnCart);
			waithelper.highlightAndClickElement(clickOnCart, "red");
	    	  
		}
		
		public void placeOrder() {
			waithelper.waitForVisibilityOf(placeOrder);
			waithelper.highlightAndClickElement(placeOrder, "yellow");
				
		}
			
		public void fillOrderForm(String name, String country, String city, String card, String month, int year) {
			waithelper.waitForVisibilityOf(nameInput);
	        nameInput.sendKeys(name);
	        waithelper.waitForVisibilityOf(countryInput);
	        countryInput.sendKeys(country);
	        waithelper.waitForVisibilityOf(cityInput);
	        cityInput.sendKeys(city);
	        waithelper.waitForVisibilityOf(cardInput);
	        cardInput.sendKeys(card);
	        waithelper.waitForVisibilityOf(monthInput);
	        monthInput.sendKeys(month);
	        waithelper.waitForVisibilityOf(yearInput);
	        yearInput.sendKeys(String.valueOf(year));
	    }
		
		public void clickOnPurchase(){
			waithelper.waitForVisibilityOf(clickOnPurchase);
			waithelper.highlightAndClickElement(clickOnPurchase, "yellow");
			  
		}
		public void clickOnConfirmation()
		
		{
			waithelper.waitForVisibilityOf(okForSuccessfullOrder);
			waithelper.highlightAndClickElement(okForSuccessfullOrder, "red");
			waithelper.waitForVisibilityOf(okForSuccessfullOrder);
			
		}
	
		
				
		
}
	