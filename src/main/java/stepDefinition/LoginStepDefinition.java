package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {

	static WebDriver driver;

	@Given("^user is already on login page$")

	public void user_is_already_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chandu\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.stage.transloc.com/login/?next=https://architect.stage.transloc.com/");
	}

	@When("^title of login page is Login$")

	public void title_of_login_page_is_Login() {

		String title = driver.getTitle();
		System.out.println("Login page title " + title); //
		Assert.assertEquals("Log in", title);
	}

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@Then("^user is on Home page$")
	public void user_is_on_home_page() {
		String title = driver.getTitle();
		System.out.println("Home Page title ::" + title);
		Assert.assertEquals("Architect", title);

	}

	@Given("^user is already on Home page$")
	public void user_is_already_on_Home_page() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chandu\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.stage.transloc.com/login/?next=https://architect.stage.transloc.com/");

		String title = driver.getTitle();
		System.out.println("Login page title " + title); //
		Assert.assertEquals("Log in", title);

		driver.findElement(By.name("username")).sendKeys("qa_user_4");
		driver.findElement(By.name("password")).sendKeys("Ap2!vE3@d2wE");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		title = driver.getTitle();
		System.out.println("Home Page title ::" + title);
		Assert.assertEquals("Architect", title);
	}

	@When("^user clicks on \"(.*)\" feed$")
	public void user_clicks_on_feedlink_feed(String feedlink) {

		driver.findElement(By.xpath("//span[text()='" + feedlink + "']")).click();
	}

	@Then("^\"(.*)\" feed is loaded$")
	public void feedname_feed_is_loaded(String feedname) {
		String title = driver.findElement(By.xpath("//a[text()='" + feedname + "']")).getText();
		Assert.assertEquals(feedname, title);
	}

	@Then("^enter new version$")
	public void user_enters_new_version() {
		String oldValue = driver.findElement(By.name("version")).getAttribute("value");
		driver.findElement(By.name("version")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.name("version")).sendKeys(Keys.DELETE);
		String newValue;
		if (oldValue.equals("1.0"))
				newValue = "2.0";
		else
			newValue = "1.0";
		
		driver.findElement(By.name("version")).sendKeys(newValue);
		driver.findElement(By.xpath("//span[text()='Save']")).click();

	}

}
