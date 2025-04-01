package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import pages.MarketEquityPage;
import utils.DriverManager;
import utils.WaitUtils;


public class CommonStepDefinitions {
	WebDriver driver = DriverManager.getDriver();

	@Given("User navigate to {string}")
	public void navigateTo(String url) {
		driver.get(url);

		WaitUtils.waitForPageLoaded();

		MarketEquityPage marketEquityPage = new MarketEquityPage();
		assertTrue(marketEquityPage.isAt());
	}
}
