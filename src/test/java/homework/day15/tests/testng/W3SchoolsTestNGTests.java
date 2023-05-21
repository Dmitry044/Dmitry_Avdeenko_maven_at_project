package homework.day15.tests.testng;

import homework.day15.driver.Driver;
import homework.day15.pages.googlePages.MainPage;
import homework.day15.pages.w3schoolPages.Java;
import homework.day15.utils.ActionsUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class W3SchoolsTestNGTests {
    Java w3schools = new Java();
    ActionsUtil actions = new ActionsUtil();
    MainPage google = new MainPage();

    public static final Logger LOGGER = Logger.getLogger(W3SchoolsTestNGTests.class.getName());


    @BeforeTest
    public void beforeTests() {
        Driver.getWebDriver();
        LOGGER.info("The w3schools testNG test is started");
    }

    @AfterTest
    public void afterTests() {
        Driver.closeDriver();
        LOGGER.info("The w3schools testNG test is finished");
    }

    @Test
    public void tutorialTest() {
        w3schools.getJavaUrl();
        actions.selectingCopyElement(w3schools.findTutorial());
        google.getUrl();
        actions.selectingPasteElement(google.findSearchField());
        Assert.assertEquals(google.displayedResultsCountContainsTutorial(), google.displayedResultsCount().size(), "Some links don't contain the 'Tutorial' word");
        LOGGER.debug("Test 'tutorialTest' is executed");
    }
}
