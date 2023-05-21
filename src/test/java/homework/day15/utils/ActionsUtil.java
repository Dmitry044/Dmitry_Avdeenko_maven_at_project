package homework.day15.utils;

import homework.day15.driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtil {
    WebDriver driver = Driver.getWebDriver();
    Actions make = new Actions(driver);

    public static final Logger LOGGER = Logger.getLogger(ActionsUtil.class.getName());

    public void selectingCopyElement(WebElement webElement) {

        make
                .doubleClick(webElement)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
        LOGGER.trace("Ctrl+C on the selected element");
    }

    public void selectingPasteElement(WebElement webElement) {
        make
                .click(webElement)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .keyDown(Keys.ENTER)
                .build()
                .perform();
        LOGGER.trace("Ctrl+V and Enter on the selected element");
    }

    public void selectingPaste() {
        make
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
        LOGGER.trace("Ctrl+V on the selected element");
    }

    public void hoverElement(WebElement webElement) {
        make.moveToElement(webElement);
        make.perform();
        LOGGER.trace("Hover on the selected element");
    }

    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open();");
        LOGGER.trace("Open new tab");
    }

    public void clickAndHold(WebElement webElement) {
        make
                .moveByOffset(674, -525)
                .clickAndHold(webElement)
                .build()
                .perform();
        LOGGER.trace("Click and hold on the selected element");
    }

    public void scrollToElement(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",
                webElement);
        LOGGER.trace("Scroll to the selected element");
    }

    public void changeElementBackground(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='green'",
                webElement);
        LOGGER.trace("Change the background color of the selected element");
    }

    public void changeElementTextColor(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color='red'",
                webElement);
        LOGGER.trace("Change the text color of the selected element");
    }
}
