package homework.day15.pages.googlePages;

import homework.day15.driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    WebDriver driver = Driver.getWebDriver();

    public static final Logger LOGGER = Logger.getLogger(MainPage.class.getName());

    public void getUrl() {
        driver.get("https://google.com");
        LOGGER.trace("Open the https://google.com");
    }

    public WebElement findSearchField() {
        LOGGER.trace("Get the search field element, locator = '[name='q']'");
        return driver.findElement(By.cssSelector("[name='q']"));
    }

    public List<WebElement> displayedResultsCount() {
        List<WebElement> allResults = driver.findElements(By.xpath("//*[@id='rso']/div//descendant:: a[@href]/h3"));
        List<WebElement> displayedResults = new ArrayList<>();
        for (WebElement item : allResults) {
            if (item.isDisplayed()) {
                displayedResults.add(item);
            }
        }
        LOGGER.trace("Get results list, locator = '//*[@id='rso']/div//descendant:: a[@href]/h3'");
        return displayedResults;
    }

    public int displayedResultsCountContainsTutorial() {
        int counter = 0;
        for (WebElement item : displayedResultsCount()) {
            if (item.getText().toLowerCase().contains("tutorial")) {
                counter++;
            }
        }
        LOGGER.trace("Get the count of results, contains the 'Tutorial'");
        return counter;
    }

    public void getEmail() {
    }
}
