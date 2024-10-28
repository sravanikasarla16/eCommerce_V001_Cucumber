package stepDefinitions;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.AboutPage;
import pageObjects.AddToCartPage;
import pageObjects.CarouselPage;
import pageObjects.ContactPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SignUpPage;

public class Steps extends BaseClass {

	@Before
	public void setup() throws IOException {
		logger = Logger.getLogger("eCommerce_v001"); // Added logger
		PropertyConfigurator.configure("Log4j.properties"); // Added logger

		// Reading Properties
		configPro = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configPro.load(configPropfile);
		String br = configPro.getProperty("browser");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configPro.getProperty("chromepath"));
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", configPro.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}
	}

	// **************** Steps To Add Products to Cart *****************

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		logger.info("******* Launching browser *********");
		addtocart = new AddToCartPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String string) {
		logger.info("******* DemoBlaze Home Page *********");
		driver.get(string);
		driver.manage().window().maximize();
	}

	@When("I add a product to cart")
	public void i_add_a_product_to_cart() throws InterruptedException, AWTException {
		logger.info("******* Adding Product To Cart *********");
		addtocart.clickOnPhones();

	}

	@Then("I should see the product in my cart")
	public void i_should_see_the_product_in_my_cart() {
		logger.info("******* Product Added To Cart *********");
		addtocart.clickOnCart();
	}

	@And("I place the order")
	public void i_place_the_order() throws IOException {
		logger.info("******* Click On Place Order*********");
		addtocart.placeOrder();
		
	}

	@And("I fill the order form with:")
	public void i_fill_the_order_form_with(io.cucumber.datatable.DataTable dataTable) {

		logger.info("******* Providing Details To Place Order **********");

		List<List<String>> data = dataTable.asLists(String.class).subList(1, dataTable.asLists(String.class).size());

		String name = data.get(0).get(0);
		String country = data.get(0).get(1);
		String city = data.get(0).get(2);
		String card = data.get(0).get(3);
		String month = data.get(0).get(4);
		int year = Integer.parseInt(data.get(0).get(5));
		addtocart.fillOrderForm(name, country, city, card, month, year);

	}

	@When("I click on purchase")
	public void i_click_on_purchase() {
		logger.info("******* Click On Purchase **********");
		addtocart.clickOnPurchase();

	}

	@Then("I should see the order confirmation")
	public void i_should_see_the_order_confirmation() throws IOException {
		logger.info("******* Finally Order Got Confirmed And Captured Screenshot **********");
		addtocart.clickOnConfirmation();
		takeScreenshot("clickOnConfirmation");
		driver.quit();

	}

	// ************** Steps For About Page********************

	@Then("Click on About Us Link")
	public void click_on_about_us_link() {
		ap = new AboutPage(driver);
		driver.manage().window().maximize();
		logger.info("******* Click On About US  **********");
		ap.clickOnAbout();

	}

	@Then("Click on playbutton")
	public void click_on_playbutton() {
		logger.info("******* Click On Play Button **********");
		ap.clickOnButton();
	}

	@Then("Click on about close button")
	public void click_on_about_close_button() throws IOException {
		logger.info("******* Click On Close Button **********");
		ap.clickOnClose();
		
		driver.quit();
	}

	// ************ Steps For CarouselPage

	@Then("Click on next button")
	public void click_on_next_button() throws IOException {
		cp = new CarouselPage(driver);
		driver.manage().window().maximize();

		logger.info("******* Click On Carousel Next Button *********");
		cp.clickOnNextButton();
		

	}

	@Then("Click on previous button")
	public void click_on_previous_button() throws IOException {

		logger.info("******* Click On Carousel Previous Button *********");
		cp.clickOnPrevButton();
		
	}

	@Then("Quit the browser")
	public void quit_the_browser() {
		logger.info("******* Closing Browser *********");
		driver.quit();

	}

// ******************* Steps For Contact Page **********************

	@Then("Click on contact")
	public void click_on_contact() {
		ctp = new ContactPage(driver);
		driver.manage().window().maximize();
		logger.info("******* Click On Contact *********");
		ctp.clickOnContact();
	}

	@Then("Enter Contact Email, Name, Message from {string}")
	public void enter_contact_email_name_message_from(String filepath) throws IOException {
		logger.info("******* Enter Email,Name,Message through excel  *********");
		ctp.enterContactDetails(filepath);

	}

	@Then("Click on Send message")
	public void click_on_send_message() throws IOException {
		logger.info("******* Click On SendMessage And Capture Screenshot  *********");
		ctp.sendMessage();
		driver.quit();
	}

	// ********************** Steps For Home Page

	@Given("the user launches the Chrome browser")
	public void the_user_launches_the_chrome_browser() {
		logger.info("******* Launching Browser   *********");
		hp = new HomePage(driver);
		driver.manage().window().maximize();
	}

	@When("the user opens the Demoblaze home page {string}")
	public void the_user_opens_the_demoblaze_home_page(String string) {
		logger.info("******* Navigating To DemoBlaze Website *********");
		driver.get(string);

	}

	@Then("the user clicks on the Home Page")
	public void the_user_clicks_on_the_home_page() {
		logger.info("******* Click On HomePage *********");
		hp.clickOnHomePage();
	}

	@When("the user clicks on the Categories dropdown")
	public void the_user_clicks_on_the_categories_dropdown() {
		logger.info("******* User Click On Categories *********");
		hp.clickOnCategories();
	}

	@Then("the user selects the Phones category")
	public void the_user_selects_the_phones_category() {
		logger.info("******* User Click On Phones *********");
		hp.clickOnPhonesCategory();
	}

	@Then("the user selects the Laptops category")
	public void the_user_selects_the_laptops_category() {
		logger.info("******* User Click On Laptops *********");
		hp.clickOnLaptopsCategory();
	}

	@Then("the user selects the Monitors category")
	public void the_user_selects_the_monitors_category() {
		logger.info("******* User Click On Monitors *********");
		hp.clickOnMonitorsCategory();
		driver.quit();
	}

//************** Steps For Login *********************

	@When("Click on the Login")
	public void click_on_the_login() {
		lp = new LoginPage(driver);
		driver.manage().window().maximize();
		lp.clickOnLogIn();

		logger.info("******* User Clicks On Login *********");
	}

	@When("User enter valid username and password")
	public void user_enter_valid_username_and_password_as(io.cucumber.datatable.DataTable dataTable) {
		logger.info("******* User Enters Valid Credentials  **************");
		List<List<String>> data = dataTable.asLists(String.class).subList(1, dataTable.asLists(String.class).size());
		String username = data.get(0).get(0);
		String password = data.get(0).get(1);
		lp.enterUserNameAndPassword(username, password);
	
	}

	@When("User click on the Log in button")
	public void user_click_on_the_log_in_button() {

		logger.info("******* User Clicks On LogInButton  **************");
		lp.clickOnLogInButton();
	}

	@Then("User verify the page title is {string}")
	public void user_verify_the_page_title_is(String title) {
		if (driver.getPageSource().contains("Wrong password.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@Then("User click on the Logout button")
	public void user_click_on_the_logout_button() {
		logger.info("******* User Clicks On Logout  **************");
		lp.clickOnLogOut();
		driver.quit();
		
	}

	
	// ************** Login With Invalid Credentials ************************

	@When("User enter invalid username and password")
	public void user_enter_invalid_username_and_password(io.cucumber.datatable.DataTable dataTable) {
		logger.info("******* User Enters Invalid Credentials  **************");
		List<List<String>> data = dataTable.asLists(String.class).subList(1, dataTable.asLists(String.class).size());
		String username = data.get(0).get(0);
		String password = data.get(0).get(1);
		lp.enterUserNameAndPassword(username, password);
	}

	@Then("User verify an error message is displayed")
	public void user_verify_an_error_message_is_displayed() throws IOException {
		
		lp.acceptAlert();
		driver.quit();
}

	// ***************** Login With Blank Credentials***************************

	@When("User enter blank username and password")
	public void user_enter_blank_username_and_password() throws IOException {
		logger.info("******* User Leaves Blank And Clicks On Enter  **************");
		lp.enterBlankDetails();
		lp.clickOnLogInButton();
		lp.acceptAlert();
		
	}

	@And("Click on close button and quit the browser")
	public void click_on_close_button_and_quit_the_browser() {

		driver.quit();
	}

	// ************************* Steps For SignUp ********************************

	@When("Click on Sign up")
	public void click_on_sign_up() {
		sp = new SignUpPage(driver);
		driver.manage().window().maximize();
		logger.info("******* User Clicks On Singup  **************");
		sp.clickOnSignUp();
	}

	@And("User enters username and password")
	public void user_enters_username_and_password() {
		logger.info("******* User Enter UserName and Password  **************");
		String uname=randomUserName();
		String pwd=randomPassword();
		sp.enterSignUpUserName(uname);
		sp.enterSignUpPassword(pwd);
		
	}

	@And("Click on Sign up to register")
	public void click_on_sign_up_to_register() {
		logger.info("******* User Clicks On Singup  **************");
		sp.clickOnSignUpButton();
	}

	@Then("User should see a successful signup message")
	public void user_should_see_a_successful_signup_message() throws InterruptedException, IOException {
		sp.acceptAlert();
	}
	
	@And("Click on login after successful signup")
	public void click_on_login_after_successful_signup(){
		logger.info("******* User Clicks On Login After Successful Login  **************");
		sp.clickOnLogin();
		}

	@And("User should be able to login with new credentials username as {string} and password as {string}")
	public void user_should_be_able_to_login_with_new_credentials_username_as_and_password_as(String email,
			String password) {
		logger.info("******* User Enters The Credentials  **************");
		sp.enterLoginUserName(email);
		sp.enterLoginPassword(password);
		
	}
	@Then("Click on login button with new credentials")
	public void click_on_login_button_with_new_credentials(){
		logger.info("******* User Clicks On LogIn Button  **************");
		sp.clickOnLogInButton();
	
	}
	
	@Then("Click on logout")
	public void click_on_logout() {
		logger.info("******* User Clicks On Logout And Quit The Browser  **************");
		sp.clickOnLogout();
		driver.quit();
	
	}
	
	
	// ******************** User Enter With Duplicate Credentials ******************

	@And("User enters existing username as {string} and password as {string}")
	public void user_enters_existing_username_as__and_password_as(String uname, String pwd) {
		logger.info("******* User Clicks On Signup And Enters The Credentials  **************");
		sp.enterSignUpUserName(uname);
		sp.enterSignUpPassword(pwd);
	}
	@And("Click on Sign up with duplicate credentials")
	public void click_on_sign_up_with_duplicate_credentials() throws IOException {
		logger.info("******* User Clicks On Singup With Duplicate Credentials  **************");
		sp.clickOnSignUpButton();
	}

	@Then("User should see a duplicate account error message")
	public void user_should_see_a_duplicate_account_error_message() {
		sp.acceptAlert();
		
		driver.quit();
	}

// ******************** User Enter With Blank Credentials ******************
	
	@When("User leaves blank in username and password fields")
	public void user_leaves_blank_in_username_and_password_fields() {
      sp.blankDetails();
    
	}
	
	@And("Click on Sign up with blank credentials")
	public void click_on_sign_up_with_blank_credentials(){
		logger.info("******* User Clicks On Singup With Blank Credentials  **************");
		sp.clickOnSignUpButton();
		}
	
	@Then("User should see a error message")
	public void user_should_see_a_error_message() throws IOException  {
		logger.info("******* And User Gets Error Message  **************");
		sp.acceptAlert();
	   driver.quit();

	}

}
