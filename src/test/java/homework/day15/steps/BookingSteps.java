package homework.day15.steps;

import homework.day15.driver.Driver;
import homework.day15.pages.bookingPages.HomePage;
import homework.day15.pages.bookingPages.HotelPage;
import homework.day15.pages.bookingPages.ResultsPage;
import homework.day15.utils.ActionsUtil;
import homework.day15.utils.DateUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class BookingSteps {
    HomePage bookingHomePage = new HomePage();
    ResultsPage bookingResultsPage = new ResultsPage();
    HotelPage bookingHotelPage = new HotelPage();

    DateUtil date = new DateUtil();
    ActionsUtil actions = new ActionsUtil();

    public static final Logger LOGGER = Logger.getLogger(BookingSteps.class.getName());
    int rating;
    private String tooltip;

    @Before(value = "@booking")
    public void beforeTests() {
        Driver.getWebDriver();
        LOGGER.info("The booking cucumber test is started");
    }

    @After(value = "@booking")
    public void afterTests() {
        Driver.closeDriver();
        LOGGER.info("The booking cucumber test is finished");
    }

    @Given("I open the \"booking.com\"")
    public void openBooking() {
        bookingHomePage.getUrl();
        LOGGER.debug("Step 'I open the \"booking.com\"' is executed");
    }

    @When("I skip \"Sign In\" offer")
    public void skipSignInOffer() {
        bookingHomePage.skipSignInOffer();
        LOGGER.debug("Step 'I skip \"Sign In\" offer' is executed");
    }

    @When("I select the {string} city")
    public void selectingPlace(String city) {
        bookingHomePage.selectingPlace(city);
        LOGGER.debug("Step 'I select the {string} city' is executed");
    }

    @When("I set dates from {int} to {int}")
    public void selectingDates(int dateFrom, int dateTo) {
        bookingHomePage.selectingDate(date.setDay(dateFrom));
        bookingHomePage.selectingDate(date.setDay(dateTo));
        LOGGER.debug("Step 'I set dates from {int} to {int}' is executed");
    }

    @When("I click on the Occupancy dropdown")
    public void clickOnOccupancyDropdown() {
        bookingHomePage.clickOnOccupancyDropdown();
        LOGGER.debug("Step 'I click on the Occupancy dropdown' is executed");
    }

    @When("I click on the Adults +")
    public void clickOnTheAdults() {
        bookingHomePage.clickOnTheAdults();
        LOGGER.debug("Step 'I click on the Adults +' is executed");
    }

    @When("I click on the Apartments +")
    public void clickOnTheApartments() {
        bookingHomePage.clickOnTheApartments();
        LOGGER.debug("I click on the Apartments +' is executed");
    }

    @When("I click on the Submit")
    public void clickOnTheSubmit() {
        bookingHomePage.clickOnTheSubmit();
        LOGGER.debug("Step 'I click on the Submit' is executed");
    }

    @When("I click on the max price per night in the filters")
    public void clickOnTheMaxPricePerNight() {
        bookingResultsPage.clickOnTheMaxPricePerNight();
        LOGGER.debug("Step 'I click on the max price per night in the filters' is executed");
    }

    @When("I wait when spinner disappears")
    public void waitForSpinner() {
        bookingResultsPage.waitForSpinner();
        LOGGER.debug("Step 'I wait when spinner disappears' is executed");
    }

    @When("I click on the Sorting dropdown")
    public void clickOnTheSortDropdown() {
        bookingResultsPage.clickOnTheSortDropdown();
        LOGGER.debug("Step 'I click on the Sorting dropdown' is executed");
    }

    @When("I select the Price Sorting")
    public void clickOnThePriceSorting() {
        bookingResultsPage.clickOnThePriceSorting();
        LOGGER.debug("Step 'I select the Price Sorting' is executed");
    }

    @Then("I check the price per night")
    public void checkPricePerNight() {
        bookingResultsPage.assertPricePerNight();
        LOGGER.debug("Step 'I check the price per night' is executed");
    }

    @When("I scroll to the {int}th hotel")
    public void scrollToHotel(int hotel) {
        actions.scrollToElement(bookingResultsPage.findHotel(hotel));
        LOGGER.debug("Step 'I scroll to the {int}th hotel' is executed");
    }

    @When("I change the {int}th hotel's background")
    public void changeHotelBackground(int hotel) {
        actions.changeElementBackground(bookingResultsPage.findHotel(hotel));
        LOGGER.debug("Step 'I change the {int}th hotel's background' is executed");
    }

    @When("I change the {int}th hotel's title color")
    public void changeHotelTextColor(int hotel) {
        actions.changeElementTextColor(bookingResultsPage.findHotelTitle(hotel));
        LOGGER.debug("Step 'I change the {int}th hotel's title color' is executed");
    }

    @Then("I check that colors of the {int}th hotel are changed")
    public void checkColorChanging(int hotel) {
        Assert.assertEquals("The text color isn't red", "color: red;", bookingResultsPage.findHotelTitle(hotel).getAttribute("style"));
        LOGGER.debug("Step 'I check that colors of the {int}th hotel are changed' is executed");
    }

    @Then("I check appearance at least one hotel")
    public void checkHotels() {
        Assert.assertTrue("There are no hotels", bookingResultsPage.findHotels().size() > 0);
        LOGGER.debug("Step 'I check appearance at least one hotel' is executed");
    }

    @When("I click on the max rating in the filters")
    public void clickOnTheMaxRating() {
        bookingResultsPage.clickOnTheMaxRating();
        rating = bookingResultsPage.getNumberOfMaxRating();
        LOGGER.debug("Step 'I click on the max rating in the filters' is executed");
    }

    @When("I open the first hotel")
    public void openFirstHotelUrl() {
        bookingResultsPage.openFirstHotelUrl();
        LOGGER.debug("Step 'I open the first hotel' is executed");
    }

    @Then("I check the hotel rating")
    public void checkHotelRating() {
        Assert.assertTrue("The hotel rating is less than 9",
                bookingHotelPage.getNumberOfHotelRating() >= rating);
        LOGGER.debug("Step 'I check the hotel rating' is executed");
    }

    @When("I hover on the currency")
    public void hoverOnTheCurrency() {
        actions.hoverElement(bookingHomePage.findCurrency());
        tooltip = bookingHomePage.getCurrencyTooltip();
        LOGGER.debug("Step 'I hover on the currency' is executed");
    }

    @Then("I check the currency tooltip value")
    public void checkTheCurrencyValue() {
        Assert.assertEquals("There is an incorrect tooltip", "Выберите валюту", tooltip);
        LOGGER.debug("Step 'I check the currency tooltip value' is executed");
    }

    @When("I hover on the language")
    public void hoverOnTheLanguage() {
        actions.hoverElement(bookingHomePage.findLanguage());
        tooltip = bookingHomePage.getLanguageTooltip();
        LOGGER.debug("Step 'I hover on the language' is executed");
    }

    @Then("I check the language tooltip value")
    public void checkTheLanguageValue() {
        Assert.assertEquals("There is an incorrect tooltip", "Выберите язык", tooltip);
        LOGGER.debug("Step 'I check the language tooltip value' is executed");
    }
}
