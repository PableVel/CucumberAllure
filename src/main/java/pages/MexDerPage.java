package pages;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitUtils;
import utils.WindowHandler;


public class MexDerPage extends BasePage {

	@FindBy(xpath = "//strong[text()='MEXDER']")
	private WebElement mexDerLink;

	@Override
	public boolean isAt() {
		WaitUtils.waitForPageLoaded();
		return mexDerLink.isDisplayed();
	}


}
