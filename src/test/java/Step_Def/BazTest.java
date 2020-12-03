package Step_Def;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class BazTest {
	
WebDriver driver;
	
	@Given("^user is on homepage$")
	public void user_is_on_homepage() throws Throwable {
	   
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://dojo.github.io/examples/widget-showcase/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@When("^user  clicks the select tab$")
	public void userClicksTheSelectTab()
	{
		driver.findElement(By.xpath("//div/div[3]/div/div[1]/div[4]")).click();
	}

	@Then("^user validate page header as \"([^\"]*)\"$")
	public void userValidatePageHeaderAs(String expectedHeaderText) throws Throwable {
		String actualHeaderText=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/div[4]/div/div/h2")).getText();
			System.out.println(actualHeaderText);
		Assert.assertEquals(expectedHeaderText,actualHeaderText);
	}

	@When("^user change the value in the simple string array to baz$")
	public void userChangeTheValueInTheSimpleStringArrayToBaz() {

		String simpleTextXPath = "(//div[@class='select-m__inputWrapper__2BMKU']/button)[1]";
		driver.findElement(By.xpath(simpleTextXPath)).click();
		List<WebElement> options = driver.findElements(By.xpath("(//div[@class='listbox-m__root__HcZvV listbox-m__focused__2CirT']//div//div)"));
		options.stream().filter(ele -> ele.getText().equalsIgnoreCase("baz")).findFirst().get().click();
		Assert.assertEquals("baz", driver.findElement(By.xpath(simpleTextXPath)).getText());
		driver.quit();

	}
}
