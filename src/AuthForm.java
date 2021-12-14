import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthForm {

	@Test
	public void validcredentials() // Test validation when valid credentials are provided
	{

		String user = "tomsmith";
		String pswd = "SuperSecretPassword!";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Form Authentication")).click();
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pswd);
		driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
		driver.findElement(By.xpath("//div[@id='flash']")).getText();
		AssertJUnit.assertTrue((driver.findElement(By.xpath("//div[@id='flash']")).getText())
				.contains("You logged into a secure area!"));
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i")).click();
		driver.findElement(By.xpath("//*[@id=\'flash\']")).getText();
		AssertJUnit.assertTrue((driver.findElement(By.xpath("//*[@id=\'flash\']")).getText())
				.contains("You logged out of the secure area!"));
		driver.quit();

	}

	@Test
	public void invalidUsername() // Test validation when invalid Username is provided
	{
		String user = "tomsmithh";
		String pswd = "SuperSecretPassword!";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Form Authentication")).click();
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pswd);
		driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
		driver.findElement(By.xpath("//div[@id='flash']")).getText();
		AssertJUnit.assertFalse(
				(driver.findElement(By.xpath("//div[@id='flash']")).getText()).contains("Your password is invalid!"));
		driver.quit();
	}

	@Test
	public void invalidPassword() // Test validation when invalid Password is provided
	{
		String user = "tomsmithh";
		String pswd = "SuperSecretPassword";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Form Authentication")).click();
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pswd);
		driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
		driver.findElement(By.xpath("//div[@id='flash']")).getText();
		AssertJUnit.assertFalse(
				(driver.findElement(By.xpath("//div[@id='flash']")).getText()).contains("Your password is invalid!"));
		driver.quit();
	}

}
