package pages;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitUtils;
import utils.WindowHandler;


public class MarketEquityPage extends BasePage {
	@FindBy(xpath = "//h1[text() = 'Equity']")
	private WebElement title;

	@FindBy(xpath = "//ul[@id='alphCapital']//a")
	private List<WebElement> listOfLettersToSearch;

	@FindBy(xpath = "//table[@id= 'tableMercados']//td[@class = 'sorting_1']")
	private List<WebElement> listOfSortingItems;

	@FindBy(xpath = "//table[@id= 'tableMercados']//th")
	private List<WebElement> listOfTableHeaders;

	@FindBy(xpath = "//a[contains(text(), 'MexDer')]")
	private WebElement mexDerLink;

	@Override
	public boolean isAt() {
		return title.isDisplayed();
	}

	public void searchByLetter(String letterToSearch){
		if(letterToSearch.isEmpty() || letterToSearch.isBlank()){
			throw new RuntimeException("The letter to search is empty!");
		}
		listOfLettersToSearch.stream().
				filter(letter -> letter.getText().equals(letterToSearch))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No link found for letter: " + letterToSearch))
				.click();
	}

	public boolean validateIssuersStartsByLetter(String letterToStart){
		if(listOfSortingItems.isEmpty()){
			throw new RuntimeException("The list of issuers is empty!");
		}
		return listOfSortingItems.stream()
				.map(WebElement::getText)
				.map(String::trim)
				.allMatch(text -> text.startsWith(letterToStart));
	}

	public void filterTableByHeader(String headerText){
		if(headerText.isEmpty() || headerText.isBlank()){
			throw new RuntimeException("The column name is empty!");
		}
		WebElement tableHeader = listOfTableHeaders.stream().
						filter(header -> header.getText().equals(headerText))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No link found for letter: " + headerText));

		tableHeader.click();
		tableHeader.click();
	}

	public void clickOnMexDerLink(){
		mexDerLink.click();
		WindowHandler windowHandler = new WindowHandler(driver);
		windowHandler.switchToNewWindow();
	}

	public boolean validateMaximumColumnIsSorted(){
		if(listOfSortingItems.isEmpty()){
			throw new RuntimeException("The list of maximum column is empty!");
		}

		List<Float> values = listOfSortingItems.stream()
				.map(WebElement::getText)
				.map(text -> {
					return Float.parseFloat(text.trim());

				})
				.collect(Collectors.toList());
		return IntStream.range(0, values.size() - 1)
				.allMatch(i -> values.get(i) >= values.get(i + 1));
	}



}
