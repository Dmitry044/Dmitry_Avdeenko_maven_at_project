package homework.day15.tests.testng;

import homework.day15.driver.Driver;
import homework.day15.objects.SelectMenuItems;
import homework.day15.pages.demoqaPages.SelectMenu;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoQATestNGTests {
    SelectMenu selectMenu = new SelectMenu();
    SelectMenuItems selectMenuItems = new SelectMenuItems();

    public static final Logger LOGGER = Logger.getLogger(DemoQATestNGTests.class.getName());

    @BeforeTest
    public void beforeTests() {
        Driver.getWebDriver();
        LOGGER.info("The demoQA testNG test is started");
    }

    @AfterTest
    public void afterTests() {
        Driver.closeDriver();
        LOGGER.info("The demoQA testNG test is finished");
    }

    @Test
    public void selectTest() {
        selectMenu.getUrlToSelectMenu();
        selectMenu.clickSelectValueDropdown();
        selectMenuItems.selectGroup1Option1OfSelectValue();
        selectMenu.clickSelectOneDropdown();
        selectMenuItems.selectDrOfSelectOne();
        selectMenuItems.selectBlueOfOldStyleSelectMenu();
        selectMenu.clickMultiSelectDropdown();
        selectMenuItems.selectGreenOfMultiSelectDropdown();
        selectMenuItems.selectAudiOfStandardMultiSelect();
        LOGGER.debug("Test 'selectTest' is executed");
    }
}
