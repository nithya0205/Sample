package cucumberSample.Smple;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import CucumberHelper.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Loginstep extends TestContext{
	
static WebDriver driver;
	@Given("User go to Facebook Page")
	public void user_go_to_Facebook_Page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ns43\\GitTest-workspace\\Cucumber\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}

	@When("Enter Username and passwrd")
	public void enter_Username_and_passwrd() {
WebElement username_txt = driver.findElement(By.id("email"));
WebElement passwrd_txt = driver.findElement(By.id("pass"));
username_txt.sendKeys("Java");
passwrd_txt.sendKeys("hello");
String attribute_username = username_txt.getAttribute("value");
String attribute_passwrd = passwrd_txt.getAttribute("value");
setUsername(attribute_username);
setPasswrd(attribute_passwrd);
	}

	@When("Click submit button")
	public void click_submit_button() {
	  driver.findElement(By.xpath("//input[@value='Log In']")).click();
	}

	@Then("Validate the username")
	public void validate_the_username() {
	    String passwrd2 = getPasswrd();
	    String username2 = getUsername();
	    Assert.assertEquals("Java", username2);
	    Assert.assertEquals("hello", passwrd2);
	}
}
