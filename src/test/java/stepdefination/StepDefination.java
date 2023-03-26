package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.nopCommerce.PageObject.AddCustomerPage;
import com.nopCommerce.PageObject.AdminPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefination extends Base {
	@Given(": User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
	  // System.setProperty("webdriver.chrome.driver","E:\\QE Software\\chromedriver_win32\\chromedriver.exe" );
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		ad=new AdminPage(driver);
	
	}

	@When(":  User Open url {string}")
	public void user_open_url(String url) {
	   driver.get(url);
	}

	@When(":  User Enter UserName as {string} and Password {string}")
	public void user_enter_user_name_as_and_password(String email, String password) {
	   ad.setUsername(email);
	   ad.setPassword(password);
	   
	}

	@When(":  User Click on login")
	public void user_click_on_login() {
		ad.clickLogin();
	}

	@Then(": 	Page Title Should be {string}")
	public void page_title_should_be(String title) {
		Assert.assertEquals(title, driver.getTitle());
	}

	
	//Add New customer
	
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	   addCust = new AddCustomerPage(driver);
	   Assert.assertEquals("Dashboard / nopCommerce administration", driver.getTitle());
	}

	@When("user click on customers menu")
	public void user_click_on_customers_menu() {
		addCust.clickOnCustomesMenu();
	}

	@When("User click on customers menu item")
	public void user_click_on_customers_menu_item() {
		addCust.clickOnCustomesMenuItem();
	}

	@When("User click on new add button")
	public void user_click_on_new_add_button() {
		addCust.clickOnAddNew();
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", driver.getTitle());
	
	}

	@When("user enter customer info as {string} and {string} and {string} and {string} and {string} and {string} and {string}")
	public void user_enter_customer_info_as_and_and_and_and_and_and(String newEmail, String newPass, String fname, String lname, String gender, String comName, String adminCommenet) {
		addCust.SetEmail(newEmail);
		addCust.SetPassword(newPass);
		addCust.SetFirstName(fname);
		addCust.SetLastName(lname);
		addCust.SetGender(gender);
		addCust.SetCompanyName(comName);
		addCust.SetAdminContent(adminCommenet);
		
	
	}

	@When("user click on save button")
	public void user_click_on_save_button() {
		addCust.clickOnSave();
	}

	@Then("User can view confirmation msg {string}")
	public void user_can_view_confirmation_msg(String string) {
	Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));

	}
	
	@Then(": Close Browser")
	public void close_browser() {
	 driver.close();
	 
	}
	
}
