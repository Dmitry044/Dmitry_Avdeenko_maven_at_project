package homework.day15.tests.junit4;

import homework.day15.driver.Driver;
import homework.day15.objects.SelectMenuItems;
import homework.day15.pages.demoqaPages.SelectMenu;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DemoQATests {
    SelectMenu selectMenu = new SelectMenu();
    SelectMenuItems selectMenuItems = new SelectMenuItems();

    public static final Logger LOGGER = Logger.getLogger(DemoQATests.class.getName());

    @Before
    public void beforeTests() {
        Driver.getWebDriver();
        LOGGER.info("The demoQA junit test is started");
    }

    @After
    public void afterTests() {
        Driver.closeDriver();
        LOGGER.info("The demoQA junit test is finished");
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
