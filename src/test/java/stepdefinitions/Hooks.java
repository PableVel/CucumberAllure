package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.*;
import utils.DriverManager;


public class Hooks {
	protected static WebDriver driver;

	@BeforeAll
	public static void beforeTest() {
		driver =	DriverManager.getDriver();
		driver.manage().window().maximize();
	}

	@AfterAll
	public static void afterTest() {
		DriverManager.quitDriver();
	}
}
