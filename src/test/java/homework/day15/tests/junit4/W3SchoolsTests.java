package homework.day15.tests.junit4;

import homework.day15.driver.Driver;
import homework.day15.pages.googlePages.MainPage;
import homework.day15.pages.w3schoolPages.Java;
import homework.day15.utils.ActionsUtil;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class W3SchoolsTests {
    Java w3schools = new Java();
    ActionsUtil actions = new ActionsUtil();
    MainPage google = new MainPage();

    public static final Logger LOGGER = Logger.getLogger(W3SchoolsTests.class.getName());


    @Before
    public void beforeTests() {
        Driver.getWebDriver();
        LOGGER.info("The w3schools junit test is started");
    }

    @After
    public void afterTests() {
        Driver.closeDriver();
        LOGGER.info("The w3schools junit test is finished");
    }

    @Test
    public void tutorialTest() {
        w3schools.getJavaUrl();
        actions.selectingCopyElement(w3schools.findTutorial());
        google.getUrl();
        actions.selectingPasteElement(google.findSearchField());
        Assert.assertEquals("Some links don't contain the 'Tutorial' word", google.displayedResultsCount().size(),
                google.displayedResultsCountContainsTutorial());
        LOGGER.debug("Test 'tutorialTest' is executed");
    }
}
