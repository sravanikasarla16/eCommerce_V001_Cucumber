package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import pageObjects.AboutPage;
import pageObjects.AddToCartPage;
import pageObjects.CarouselPage;
import pageObjects.ContactPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SignUpPage;

public class BaseClass {
	
	public WebDriver driver;

    public AddToCartPage addtocart;
	public AboutPage ap;
	public CarouselPage cp;
	public ContactPage ctp;
	public HomePage hp;
	public LoginPage lp;
	public SignUpPage sp;
	public static Logger logger;
	public Properties configPro;
	

	public void takeScreenshot(String screenshotName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String filename = "screenshots/" + screenshotName + "_" + timestamp + ".png";

        FileUtils.copyFile(screenshot, new File(filename));

        System.out.println("Screenshot saved: " + filename);
 	}

	public static String randomUserName() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);

	}
	
	public static String randomPassword() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);

	}
	



}


