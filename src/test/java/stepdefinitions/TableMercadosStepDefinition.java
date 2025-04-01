package stepdefinitions;





import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.*;
import pages.MarketEquityPage;
import pages.MexDerPage;


public class TableMercadosStepDefinition {
	MarketEquityPage marketEquityPage = new MarketEquityPage();
	@When("User click {string} in 'Search by alphabetical order' section")
	public void searchByLetter(String letterToSearch){
		marketEquityPage.searchByLetter(letterToSearch);
	}

	@When("User clicks on the {string} column header twice")
	public void applyFilterByHeader(String headerText){
		marketEquityPage.filterTableByHeader(headerText);
	}

	@When("User clicks on MexDer link")
	public void clickOnMexDer(){
		marketEquityPage.clickOnMexDerLink();
	}

	@Then("User is at MexDer page")
	public void validateIsAtMexDer() {
		MexDerPage mexDerPage = new MexDerPage();
		assertTrue(mexDerPage.isAt());
	}
	@Then("User should see that the table only contains 'Issuers' that start with {string}")
	public void validateIssuersResults(String letterToSearch) {
		assertTrue(marketEquityPage.validateIssuersStartsByLetter(letterToSearch));
	}

	@Then("User should see the Maximum values ordered from highest to lowest")
	public void validateMaximumFilter(){
		assertTrue(marketEquityPage.validateMaximumColumnIsSorted(), "Write a error message");
	}

}