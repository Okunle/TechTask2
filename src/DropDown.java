import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	@Test
	public void dropDowns() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[11]/a")).click();
		WebElement Dropdown = driver.findElement(By.id("dropdown"));
		Select select = new Select(Dropdown);
		select.selectByVisibleText("Option 2");
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		System.out.println("selected element =" + firstSelectedOption.getText());
		Assert.assertEquals("Option 2", firstSelectedOption.getText());
		

		driver.quit();

		// Assert.assertEquals("Option 2", select.getFirstSelectedOption().getText());

	}
}
