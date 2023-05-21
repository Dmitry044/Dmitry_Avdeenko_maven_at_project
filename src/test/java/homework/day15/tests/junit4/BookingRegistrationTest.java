package homework.day15.tests.junit4;

import homework.day15.driver.Driver;
import homework.day15.pages.bookingPages.HomePage;
import homework.day15.pages.bookingPages.SignInPage;
//import homework.day15.pages.googlePages.MainPage;
import homework.day15.pages.mailPages.MainPage;
import homework.day15.utils.ActionsUtil;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


import java.util.ArrayList;

public class BookingRegistrationTest {
    HomePage bookingHomePage = new HomePage();
    MainPage tempmail = new MainPage();
    SignInPage bookingSignInPage = new SignInPage();
    ActionsUtil actions = new ActionsUtil();

    public static final Logger LOGGER = Logger.getLogger(BookingRegistrationTest.class.getName());
    WebDriver driver = Driver.getWebDriver();

    @Before
    public void beforeTest() {
        tempmail.getUrl();
        tempmail.getEmail();
        LOGGER.info("The booking registration junit test is started");
    }

    @After
    public void afterTest() {
        LOGGER.info("The booking registration junit test is finished");
    }

    @Test
    public void registerTest() {
        actions.openNewTab();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        bookingHomePage.getUrl();
        bookingHomePage.skipSignInOffer();
        bookingHomePage.clickRegister();
        actions.selectingPaste();
        bookingSignInPage.clickSubmit();
        bookingSignInPage.enterPassword("Test123456!");
        actions.clickAndHold(bookingSignInPage.getCaptcha());
        LOGGER.debug("Test 'registerTest' is executed");
    }
}
