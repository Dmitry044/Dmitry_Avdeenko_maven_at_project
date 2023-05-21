package homework.day15.objects;

import homework.day15.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

//import java.util.logging.Logger;
import org.apache.log4j.Logger;

public class SelectMenuItems {
    WebDriver driver = Driver.getWebDriver();

    public static final Logger LOGGER = Logger.getLogger(SelectMenuItems.class.getName());

    public void selectGroup1Option1OfSelectValue() {
        driver.findElement(By.id("react-select-2-option-0-0")).click();
        LOGGER.trace("Click on the Group1Option1O, locator(id) = 'react-select-2-option-0-0'");
    }

    public void selectDrOfSelectOne() {
        driver.findElement(By.id("react-select-3-option-0-0")).click();
        LOGGER.trace("Click on the Dr, locator(id) = 'react-select-3-option-0-0'");
    }

    public void selectBlueOfOldStyleSelectMenu() {
        new Select(driver.findElement(By.id("oldSelectMenu"))).selectByValue("1");
        LOGGER.trace("Click on the Blue, locator(id) = 'oldSelectMenu', value = '1'");
    }

    public void selectGreenOfMultiSelectDropdown() {
        driver.findElement(By.id("react-select-4-option-0")).click();
        LOGGER.trace("Click on the Green, locator(id) = 'react-select-4-option-0'");
    }

    public void selectAudiOfStandardMultiSelect() {
        new Select(driver.findElement(By.id("cars"))).selectByValue("audi");
        LOGGER.trace("Click on the Audi, locator(id) = 'cars', value ='audi'");
    }
}
