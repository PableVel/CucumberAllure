package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;


public class WaitUtils {

	private static WebDriver driver;
	private static WebDriverWait wait;

	static {
		driver = DriverManager.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}



	public WebElement waitForElementToBeVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}


	public WebElement waitForElementToBeClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}


	public boolean waitForElementToDisappear(By locator) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}


	public boolean waitForTextToBePresentInElement(By locator, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	public boolean waitForAttributeToBe(By locator, String attribute, String value) {
		return wait.until(ExpectedConditions.attributeToBe(locator, attribute, value));
	}

	public boolean waitForUrlToContain(String urlFragment) {
		return wait.until(ExpectedConditions.urlContains(urlFragment));
	}

	public static void waitForPageLoaded() {
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(200))
				.ignoring(Exception.class);
		//Buscar exception de windows handler
		fluentWait.until(driver -> ((JavascriptExecutor) driver)
				.executeScript("return document.readyState").equals("complete"));
	}
}