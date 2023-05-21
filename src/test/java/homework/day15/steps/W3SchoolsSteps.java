package homework.day15.steps;

import homework.day15.driver.Driver;
import homework.day15.pages.googlePages.MainPage;
import homework.day15.pages.w3schoolPages.Java;
import homework.day15.utils.ActionsUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class W3SchoolsSteps {
    Java w3schools = new Java();
    ActionsUtil actions = new ActionsUtil();
    MainPage google = new MainPage();

    public static final Logger LOGGER = Logger.getLogger(W3SchoolsSteps.class.getName());

    @Before(value = "@w3schools")
    public void beforeTests() {
        Driver.getWebDriver();
        LOGGER.info("The w3schools cucumber test is started");
    }

    @After(value = "@w3schools")
    public void afterTests() {
        Driver.closeDriver();
        LOGGER.info("The w3schools cucumber test is finished");
    }

    @Given("I open the \"w3schools.com\"")
    public void openW3Schools() {
        w3schools.getJavaUrl();
        LOGGER.debug("Step 'I open the \"w3schools.com\"' is executed");
    }

    @When("I copy \"Tutorial\" word")
    public void copyTutorial() {
        actions.selectingCopyElement(w3schools.findTutorial());
        LOGGER.debug("Step 'I copy \"Tutorial\" word' is executed");
    }

    @When("I open the \"google.com\"")
    public void openGoogle() {
        google.getUrl();
        LOGGER.debug("Step 'I open the \"google.com\"' is executed");
    }

    @When("I paste \"Tutorial\" to the search field and click the Enter")
    public void pasteTutorial() {
        actions.selectingPasteElement(google.findSearchField());
        LOGGER.debug("Step 'I paste \"Tutorial\" to the search field and click the Enter' is executed");
    }

    @Then("I check that all result links contain the word \"Tutorial\"")
    public void checkResults() {
        Assert.assertEquals("Some links don't contain the 'Tutorial' word", google.displayedResultsCount().size(),
                google.displayedResultsCountContainsTutorial());
        LOGGER.debug("Step 'I check that all result links contain the word \"Tutorial\"' is executed");
    }
}
