package homework.day15.pages.w3schoolPages;

import homework.day15.driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Java {
    WebDriver driver = Driver.getWebDriver();

    public static final Logger LOGGER = Logger.getLogger(Java.class.getName());

    public void getJavaUrl() {
        driver.get("https://www.w3schools.com/java/");
        LOGGER.trace("Open the https://www.w3schools.com/java/");
    }

    public WebElement findTutorial() {
        LOGGER.trace("Find the 'Tutorial' word, locator = '//h1/span[contains(text(),'Tutorial')]'");
        return driver.findElement(By.xpath("//h1/span[contains(text(),'Tutorial')]"));
    }
}
