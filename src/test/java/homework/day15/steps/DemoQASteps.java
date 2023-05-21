package homework.day15.steps;

import homework.day15.driver.Driver;
import homework.day15.objects.SelectMenuItems;
import homework.day15.pages.demoqaPages.SelectMenu;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class DemoQASteps {
    SelectMenu selectMenu = new SelectMenu();
    SelectMenuItems selectMenuItems = new SelectMenuItems();

    public static final Logger LOGGER = Logger.getLogger(DemoQASteps.class.getName());

    @Before(value = "@demoQA")
    public void beforeTests() {
        Driver.getWebDriver();
        LOGGER.info("The demoQA cucumber test is started");
    }

    @After(value = "@demoQA")
    public void afterTests() {
        Driver.closeDriver();
        LOGGER.info("The demoQA cucumber test is finished");
    }

    @Given("I open \"demoQA.com\"")
    public void openDemoQA() {
        selectMenu.getUrlToSelectMenu();
        LOGGER.debug("Step 'I open \"demoQA.com\"' is executed");
    }

    @When("I click on the Select Value Dropdown")
    public void clickSelectValueDropdown() {
        selectMenu.clickSelectValueDropdown();
        LOGGER.debug("Step 'I click on the Select Value Dropdown' is executed");
    }

    @When("I select Group1 Option1")
    public void selectGroup1Option1OfSelectValue() {
        selectMenuItems.selectGroup1Option1OfSelectValue();
        LOGGER.debug("Step 'I select Group1 Option1' is executed");
    }

    @When("I click on the Select One Dropdown")
    public void clickSelectOneDropdown() {
        selectMenu.clickSelectOneDropdown();
        LOGGER.debug("Step 'I click on the Select One Dropdown' is executed");
    }

    @When("I select Dr")
    public void selectDrOfSelectOne() {
        selectMenuItems.selectDrOfSelectOne();
        LOGGER.debug("Step 'I select Dr' is executed");
    }

    @When("I select Blue Of Old Style Select Menu")
    public void selectBlueOfOldStyleSelectMenu() {
        selectMenuItems.selectBlueOfOldStyleSelectMenu();
        LOGGER.debug("Step 'I select Blue Of Old Style Select Menu' is executed");
    }

    @When("I click on the Multi Select Dropdown")
    public void clickMultiSelectDropdown() {
        selectMenu.clickMultiSelectDropdown();
        LOGGER.debug("Step 'I click on the Multi Select Dropdown' is executed");
    }

    @When("I select Green")
    public void selectGreenOfMultiSelectDropdown() {
        selectMenuItems.selectGreenOfMultiSelectDropdown();
        LOGGER.debug("Step 'I select Green' is executed");
    }

    @When("I select Audi in the Standard Multi Select")
    public void selectAudiOfStandardMultiSelect() {
        selectMenuItems.selectAudiOfStandardMultiSelect();
        LOGGER.debug("Step 'I select Audi in the Standard Multi Select' is executed");
    }

    @Then("I check that all fields are selected")
    public void checkAllFields() {
        LOGGER.debug("Step 'I check that all fields are selected' is executed");
    }

}
