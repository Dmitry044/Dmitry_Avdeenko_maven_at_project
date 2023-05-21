package homework.day15.pages.bookingPages;

import homework.day15.driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//import java.util.logging.Logger;

public class HomePage {
    WebDriver driver = Driver.getWebDriver();

    public static final Logger LOGGER = Logger.getLogger(HomePage.class.getName());

    public void getUrl() {
        driver.get("https://booking.com");
        LOGGER.trace("Open the https://booking.com");
    }

    public void skipSignInOffer() {
        driver.findElement(By.xpath("//div[@role='dialog'][@aria-modal='true']//button")).click();
        LOGGER.trace("Skip the SignIn offer popup, locator = '//div[@role='dialog'][@aria-modal='true']//button'");
    }

    public void selectingPlace(String placeName) {
        driver.findElement(By.cssSelector("[name='ss']")).sendKeys(placeName);
        LOGGER.trace("Enter the city name, locator = '[name='ss']'");
        driver.findElement(By.xpath("//*[@data-testid='autocomplete-results']/li[1]/descendant:: div[contains(text(),'" + placeName + "')]")).click();
        LOGGER.trace("Click on the city, locator = '//*[@data-testid='autocomplete-results']/li[1]/descendant:: div[contains(text(),'" + placeName + "')]'");
    }

    public void selectingDate(String date) {
        driver.findElement(By.cssSelector("[data-date='" + date + "']")).click();
        LOGGER.trace("Select date, locator = '[data-date='" + date + "']'");
    }

    public void clickOnOccupancyDropdown() {
        driver.findElement((By.cssSelector("[data-testid='occupancy-config']"))).click();
        LOGGER.trace("Click on the Occupancy Dropdown, locator = '[data-testid='occupancy-config']'");
    }

    public void clickOnTheAdults() {
        driver.findElement(By.xpath("//input[@id='group_adults']/following-sibling::div/button[2]")).click();
        LOGGER.trace("Click on the Adults +, locator = '//input[@id='group_adults']/following-sibling::div/button[2]'");
    }

    public void clickOnTheApartments() {
        driver.findElement(By.xpath("//input[@id='no_rooms']/following-sibling::div/button[2]")).click();
        LOGGER.trace("Click on the Apartments +, locator = '//input[@id='no_rooms']/following-sibling::div/button[2]'");
    }

    public void clickOnTheSubmit() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        LOGGER.trace("Click on the submit button, locator = '//button[@type='submit']'");
    }

    public WebElement findCurrency() {
        WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(10));
        element.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='header-currency-picker-trigger']"))
        );
        LOGGER.trace("Find the currency element, locator = '[data-testid='header-currency-picker-trigger']'");
        return driver.findElement(By.cssSelector("[data-testid='header-currency-picker-trigger']"));
    }

    public WebElement findLanguage() {
        WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(10));
        element.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='header-language-picker-trigger']"))
        );
        LOGGER.trace("Find the language element, locator = '[data-testid='header-language-picker-trigger']'");
        return driver.findElement(By.cssSelector("[data-testid='header-language-picker-trigger']"));
    }

    public String getCurrencyTooltip() {
        LOGGER.trace("Find the tooltip value of the currency element, locator = '//*[@id=':R2cl:']/div'");
        return driver.findElement(By.xpath("//*[@id=':R2cl:']/div")).getText();
    }

    public String getLanguageTooltip() {
        LOGGER.trace("Find the tooltip value of the language element, locator = '//*[@id=':R2kl:']/div'");
        return driver.findElement(By.xpath("//*[@id=':R2kl:']/div")).getText();
    }

    public void clickRegister() {
        driver.findElement(By.xpath("//*[@data-testid='header-sign-up-button']")).click();
        LOGGER.trace("Click on the Register button, locator = '//*[@data-testid='header-sign-up-button']'");
    }
}
