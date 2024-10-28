package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
WebDriver driver;
WebDriverWait wait;


public WaitHelper(WebDriver driver) {
	
	this.driver= driver;
	wait = new WebDriverWait(driver, Duration.ofSeconds(30));

   }

public void highlightAndClickElement(WebElement element, String color) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
     wait.until(ExpectedConditions.elementToBeClickable(element)).click();
   
}

  public void waitForVisibilityOf(WebElement element) {
	  wait.until(ExpectedConditions.visibilityOf(element));
	  
  }


}