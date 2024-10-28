package pageObjects;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.BaseClass;
import utilities.WaitHelper;

public class CarouselPage extends BaseClass{
	
	WebDriver driver;
	WebDriverWait wait;
	WaitHelper waithelper;
	public CarouselPage(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		waithelper=new WaitHelper(driver);
		PageFactory.initElements(driver, this);
			
	}
	
	       //********** locators***************
	
	@FindBy(xpath ="//span[@class='carousel-control-next-icon' and @aria-hidden='true']")
		WebElement clickOnNext;
		
		@FindBy(xpath= "//span[@class='carousel-control-prev-icon' and @aria-hidden='true']")
		WebElement clickOnPrev;
			
		
		   // ******************* Action Methods ****************
		
	 public void clickOnNextButton() {
		 waithelper.highlightAndClickElement(clickOnNext, "pink");
		 waithelper.waitForVisibilityOf(clickOnNext);
			
	}
	
	public void clickOnPrevButton() {
		waithelper.highlightAndClickElement(clickOnPrev, "yellow");
		waithelper.waitForVisibilityOf(clickOnPrev);
		
  }


}
