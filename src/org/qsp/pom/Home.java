package org.qsp.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Home {
	@FindBy(xpath = "//td/label[contains(.,'One Way')]")
	private WebElement oneWay;

	@FindBy(id = "ctl00_mainContent_ddl_originStation1_CTXT")
	private WebElement departureCity;

	@FindBy(id = "ctl00_mainContent_ddl_destinationStation1_CTXT")
	private WebElement arrivalCity;

	@FindBy(xpath = "//input[contains(@id,'ctl00_mainContent_view_date1')]")
	private WebElement departDate;

	@FindBy(xpath = "//input[contains(@id,'date2')]")
	private WebElement arrivalDate;

	@FindBy(xpath = "//label[contains(.,'Round Trip')]")
	private WebElement roundTrip;

	@FindBy(xpath = "//*[@id='flightSearchContainer']/div[6]/div")
	private WebElement passenger;

	@FindBy(name = "ctl00$mainContent$ddl_Adult")
	private WebElement adult;

	@FindBy(name = "ctl00$mainContent$ddl_Child")
	private WebElement child;

	@FindBy(xpath = "//input[@value='Search']")
	private WebElement search;

	@FindBy(xpath = "//a[contains(.,'25')]")
	private WebElement dDate;

	@FindBy(xpath = "//td[@data-year='2020']/a[contains(.,'31')]")
	private WebElement aDate;

	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOneWay() {
		oneWay.click();
	}

	public void clicDCity() {
		departureCity.click();
	}

	public void enterDepartureCity(String city) {
		departureCity.sendKeys(city);
	}

	public void arrivalCity(String city) {
		arrivalCity.sendKeys(city);
	}

	public void clickDdate() {
		departDate.click();
	}

	public void selectDdate() {
		dDate.click();
	}

	public boolean checkRData() {
		return arrivalDate.isEnabled();
	}

	public void clickRTrip() {
		roundTrip.click();
	}

	public void clickRdate() {
		arrivalDate.click();
	}

	public void selectRDate() {
		aDate.click();
	}

	public void clickPassenger() {
		passenger.click();
	}

	public void selectA(int aCount) {
		Select s = new Select(adult);
		adult.click();
		s.selectByIndex(aCount);
	}

	public void selectC(int cCount) {
		Select s = new Select(child);
		child.click();
		s.selectByIndex(cCount);
	}

	public void clickSearch() {
		search.click();
	}

}
