package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverManager;


public abstract class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage() {
		this.driver = DriverManager.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public abstract boolean isAt() throws InterruptedException;
}
