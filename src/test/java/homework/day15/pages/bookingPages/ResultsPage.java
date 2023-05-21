package homework.day15.pages.bookingPages;

import homework.day15.driver.Driver;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ResultsPage {
    WebDriver driver = Driver.getWebDriver();

    public static final Logger LOGGER = Logger.getLogger(ResultsPage.class.getName());
    public static final String MAX_PRICE_PER_NIGHT_XPATH_FLAG = "//*[@id='filter_group_pri_:Rcq:']/div/div[@data-filters-item='pri:pri=5']//descendant::%s";
    public static final String MAX_PRICE_PER_NIGHT_XPATH_SCROLL = "//*[@id='filter_group_price_:Rcq:']//descendant::div[@data-testid='filters-group-histogram']//following-sibling::div/div/%s";

    public void clickOnTheMaxPricePerNight() {
        try {
            driver.findElement(By.xpath(String.format(MAX_PRICE_PER_NIGHT_XPATH_FLAG, "span[2]"))).click();
            LOGGER.trace("Click on the max price per night in the filters, locator = '" + String.format(MAX_PRICE_PER_NIGHT_XPATH_FLAG, "span[2]") + "'");
        } catch (NoSuchElementException e) {
            Actions make = new Actions(driver);
            make
                    .clickAndHold(driver.findElement(By.xpath(String.format(MAX_PRICE_PER_NIGHT_XPATH_SCROLL, "div[1]"))))
                    .moveByOffset(200, -25)
                    .release()
                    .build()
                    .perform();
            LOGGER.trace("Set the max price per night in the filters, locator = '" + String.format(MAX_PRICE_PER_NIGHT_XPATH_SCROLL, "div[1]") + "'");
        }
    }

    public void waitForSpinner() {
        WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(10));
        element.until(
                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[data-testid='overlay-spinner']"))
        );
        LOGGER.trace("Wait for spinner disappears, locator = '[data-testid='overlay-spinner']'");
    }

    public void clickOnTheSortDropdown() {
        driver.findElement(By.cssSelector("[data-testid='sorters-dropdown-trigger']")).click();
        LOGGER.trace("Click on the Sorting dropdown, locator = '[data-testid='sorters-dropdown-trigger']'");
    }

    public void clickOnThePriceSorting() {
        driver.findElement(By.cssSelector("[data-id='price']")).click();
        LOGGER.trace("Click on the price sorting, locator = '[data-id='price']'");
    }

    public void assertPricePerNight() {
        int hotelPricePerNight = Integer.parseInt(driver.findElement(By.xpath("//*[@data-block-id='hotel_list']//descendant::div[@data-testid='property-card'][1]//descendant::span[@data-testid='price-and-discounted-price']")).getText().replaceAll("[^0-9]", "")) / 7;
        int filterPricePerNight;
        try {
            filterPricePerNight = Integer.parseInt(driver.findElement(By.xpath(String.format(MAX_PRICE_PER_NIGHT_XPATH_FLAG, "div[@data-testid='filters-group-label-content']"))).getText().replaceAll("[^0-9]", ""));
        } catch (NoSuchElementException e) {
            filterPricePerNight = Integer.parseInt(driver.findElement(By.xpath(String.format(MAX_PRICE_PER_NIGHT_XPATH_SCROLL, "input[1]"))).getAttribute("value"));
        }
        Assert.assertTrue("The price per night is more than filter price", hotelPricePerNight >= filterPricePerNight);
        LOGGER.trace("Check the hotel price per night and the filters price per night,\n" +
                " locator (hotel price per night) = '//*[@data-block-id='hotel_list']//descendant::div[@data-testid='property-card'][1]//descendant::span[@data-testid='price-and-discounted-price']'\n" +
                " locator (filters price per night) = '" + String.format(MAX_PRICE_PER_NIGHT_XPATH_FLAG, "div[@data-testid='filters-group-label-content']") + "' \n" +
                " or '" + String.format(MAX_PRICE_PER_NIGHT_XPATH_SCROLL, "input[1]") + "'");
    }

    public void assertPricePerNightTestNG() {
        int hotelPricePerNight = Integer.parseInt(driver.findElement(By.xpath("//*[@data-block-id='hotel_list']//descendant::div[@data-testid='property-card'][1]//descendant::span[@data-testid='price-and-discounted-price']")).getText().replaceAll("[^0-9]", "")) / 7;
        int filterPricePerNight;
        try {
            filterPricePerNight = Integer.parseInt(driver.findElement(By.xpath(String.format(MAX_PRICE_PER_NIGHT_XPATH_FLAG, "div[@data-testid='filters-group-label-content']"))).getText().replaceAll("[^0-9]", ""));
        } catch (NoSuchElementException e) {
            filterPricePerNight = Integer.parseInt(driver.findElement(By.xpath(String.format(MAX_PRICE_PER_NIGHT_XPATH_SCROLL, "input[1]"))).getAttribute("value"));
        }
        org.testng.Assert.assertTrue(hotelPricePerNight >= filterPricePerNight, "The price per night is more than filter price");
        LOGGER.trace("Check the hotel price per night and the filters price per night,\n" +
                " locator (hotel price per night) = '//*[@data-block-id='hotel_list']//descendant::div[@data-testid='property-card'][1]//descendant::span[@data-testid='price-and-discounted-price']'\n" +
                " locator (filters price per night) = '" + String.format(MAX_PRICE_PER_NIGHT_XPATH_FLAG, "div[@data-testid='filters-group-label-content']") + "' \n" +
                " or '" + String.format(MAX_PRICE_PER_NIGHT_XPATH_SCROLL, "input[1]") + "'");
    }

    public List<WebElement> findHotels() {
        LOGGER.trace("Find the hotels list, locator = '//*[@data-testid='property-card']'");
        return driver.findElements(By.xpath("//*[@data-testid='property-card']"));
    }

    public WebElement findHotel(int numberOfHotel) {
        LOGGER.trace("Find the " + numberOfHotel + "hotel, locator = '//*[@data-testid='property-card'][" + numberOfHotel + "]'");
        return driver.findElement(By.xpath("//*[@data-testid='property-card'][" + numberOfHotel + "]"));
    }

    public WebElement findHotelTitle(int numberOfHotel) {
        LOGGER.trace("Find the " + numberOfHotel + "hotel title, locator = '//*[@data-testid='property-card'][" + numberOfHotel + "]//descendant:: div[@data-testid='title']'");
        return driver.findElement(By.xpath("//*[@data-testid='property-card'][" + numberOfHotel + "]//descendant:: div[@data-testid='title']"));
    }

    public void clickOnTheMaxRating() {
        driver.findElement(By.xpath("//div[@id='left']//div[@data-filters-group='review_score']/div[@data-filters-item='review_score:review_score=90']/label/span[2]")).click();
        LOGGER.trace("Click on the max rating in the filters, locator = '//div[@id='left']//div[@data-filters-group='review_score']/div[@data-filters-item='review_score:review_score=90']/label/span[2]'");
    }

    public int getNumberOfMaxRating() {
        LOGGER.trace("Get value of the max rating in the filters, locator = '//div[@id='left']//div[@data-filters-group='review_score']/div[@data-filters-item='review_score:review_score=90']/label//div[@data-testid='filters-group-label-content']'");
        return Integer.parseInt(driver.findElement(By.xpath("//div[@id='left']//div[@data-filters-group='review_score']/div[@data-filters-item='review_score:review_score=90']/label//div[@data-testid='filters-group-label-content']")).getText().replaceAll("[^0-9]", ""));
    }

    public void openFirstHotelUrl() {
        driver.get(driver.findElement(By.xpath("//*[@id='search_results_table']//div[@data-testid='property-card'][1]//div[@data-testid='title']/..")).getAttribute("href"));
        LOGGER.trace("Open the first hotetl url, locator = '//*[@id='search_results_table']//div[@data-testid='property-card'][1]//div[@data-testid='title']/..'");
    }
}
