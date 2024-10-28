package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.BaseClass;
import utilities.WaitHelper;

public class HomePage extends BaseClass{
	WebDriver driver;
	WebDriverWait wait;
	WaitHelper waithelper;
	
    public HomePage(WebDriver driver) {
    	this.driver=driver;
    	wait= new WebDriverWait(driver,Duration.ofSeconds(60));
    	PageFactory.initElements(driver,this);
    	
       	   	
    }
    public void highlightElement(WebElement element, String color) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
         
    }
    
    public void clickElement(WebElement element) {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
	
   public void waitForVisibilityOf(WebElement element) {
		  wait.until(ExpectedConditions.visibilityOf(element));
		  
}



    
   
    // ********** Locators To Highlight Different Products ***********
 	@FindBy(xpath = "(//a[@class='nav-link'])[1]")
	WebElement clickOnHome;

	@FindBy(xpath ="//a[@class='list-group-item' and @id='cat']")
	WebElement clickOnCatagories;

	@FindBy(xpath = "//a[text()='Phones']")
	WebElement clickOnPhones;

	@FindBy(xpath = "//a[text()='Laptops']")
	WebElement clickOnLaptops;

	@FindBy(xpath = "//a[text()='Monitors']")
	WebElement clickOnMonitors;

// Locators To Highlight All Kinds Of Phones

	@FindBy(xpath ="(//a[@class=\"hrefch\"])[1]")
	WebElement clickOnSamsung;

	@FindBy(xpath ="//a[text()='Nokia lumia 1520']")
	WebElement clickOnNokia;

	@FindBy(xpath ="//a[text()='Nexus 6']")
	WebElement clickOnNexus;

	@FindBy(xpath ="//a[text()='Samsung galaxy s7']")
	WebElement clickOnSamsungGalaxy;

	@FindBy(xpath ="//a[text()='Iphone 6 32gb']")
	WebElement clickOnIphone;

	@FindBy(xpath ="//a[text()= 'Sony xperia z5']")
	WebElement clickOnSony;

	@FindBy(xpath ="//a[text()='HTC One M9']")
	WebElement clickOnHtc;

// Locators For Highlighting  All Kinds Of Laptops

	@FindBy(xpath ="//a[text()='Sony vaio i5']")
	WebElement clickOnSonyi5;

	@FindBy(xpath ="//a[normalize-space(text())=\"Sony vaio i7\"]")
	WebElement clickOnSonyi7;

	@FindBy(xpath ="//a[text()='MacBook air']")
	WebElement clickOnMacbook;

	@FindBy(xpath ="//a[text()='Dell i7 8gb']")
	WebElement clickOnDelli;

	@FindBy(xpath ="//a[text()='2017 Dell 15.6 Inch']")
	WebElement clickOnDell2017;

	@FindBy(xpath ="//a[text()='MacBook Pro']")
	WebElement clickOnMacpro;

	@FindBy(xpath ="//a[text()='MacBook air']")
	WebElement clickOnMacAir;

	@FindBy(xpath ="(//a[@class='hrefch'])[2]")
	WebElement clickOnAsus;

	// Locators For Highlighting  All Kinds Of Monitors

	@FindBy(xpath ="(//a[@class='hrefch'])[1]")
	WebElement clickOnAppleMonitor;

	// Locators For Click On Next Button, Previous button

	@FindBy(xpath ="//button[text()='Next']")
	WebElement clickOnNext;

	@FindBy(xpath ="//button[text()='Previous']")
	WebElement clickOnPrevious;
	



// *************** Action Methods *****************


public void clickOnHomePage() {
	highlightElement(clickOnHome,"yellow");
	waitForVisibilityOf(clickOnHome);
}

public void clickOnCategories() {
	waitForVisibilityOf(clickOnCatagories);
	highlightElement(clickOnCatagories,"pink");
	clickElement(clickOnCatagories);
}

public void clickOnPhonesCategory() {
	waitForVisibilityOf(clickOnPhones);
	highlightElement(clickOnPhones,"yellow");
	waitForVisibilityOf(clickOnSamsung);
	highlightElement(clickOnSamsung,"pink");
	waitForVisibilityOf(clickOnNokia);
	highlightElement(clickOnNokia,"green");
	waitForVisibilityOf(clickOnNexus);
	highlightElement(clickOnNexus,"pink");
	waitForVisibilityOf(clickOnSamsungGalaxy);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickOnSamsungGalaxy);
	highlightElement(clickOnSamsungGalaxy,"yellow");
	waitForVisibilityOf(clickOnIphone);
	highlightElement(clickOnIphone,"pink");
	waitForVisibilityOf(clickOnSony);
	highlightElement(clickOnSony,"orange");
	waitForVisibilityOf(clickOnHtc);
	highlightElement(clickOnHtc,"yellow");
	
}

public void clickOnLaptopsCategory() {
	waitForVisibilityOf(clickOnLaptops);
	highlightElement(clickOnLaptops, "pink");
	clickElement(clickOnLaptops);
	waitForVisibilityOf(clickOnSonyi5);
	highlightElement(clickOnSonyi5,"red");
	waitForVisibilityOf(clickOnSonyi7);
	highlightElement(clickOnSonyi7,"pink");
	waitForVisibilityOf(clickOnMacbook);
	highlightElement(clickOnMacbook,"orange");
	waitForVisibilityOf(clickOnDelli);
	highlightElement(clickOnDelli,"pink");
	waitForVisibilityOf(clickOnDell2017);
	highlightElement(clickOnDell2017,"yellow");
	waitForVisibilityOf(clickOnMacpro);
	highlightElement(clickOnMacpro,"green");
	waitForVisibilityOf(clickOnNext);
	highlightElement(clickOnNext,"red");
	clickElement(clickOnNext);
	waitForVisibilityOf(clickOnMacAir);
	highlightElement(clickOnMacAir,"pink");
	waitForVisibilityOf(clickOnPrevious);
	highlightElement(clickOnPrevious,"yellow");
	clickElement(clickOnPrevious);
	
}
public void clickOnMonitorsCategory() {
	clickElement(clickOnMonitors);
	waitForVisibilityOf(clickOnMonitors);
	highlightElement(clickOnMonitors,"orange");
	waitForVisibilityOf(clickOnAppleMonitor);
	highlightElement(clickOnAppleMonitor,"grey");
	waitForVisibilityOf(clickOnAsus);
	highlightElement(clickOnAsus,"yellow");
	
}
	
	
}

