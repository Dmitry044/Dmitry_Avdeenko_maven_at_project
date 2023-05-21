package homework.day15.pages.bookingPages;

import homework.day15.driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    WebDriver driver = Driver.getWebDriver();

    public static final Logger LOGGER = Logger.getLogger(SignInPage.class.getName());

    public void enterEmail(String myEmail) {
        driver.findElement(By.id("username")).sendKeys(myEmail);
        LOGGER.trace("Enter the '" + myEmail + "' to the eamil field, locator(id) = 'username'");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        LOGGER.trace("Click on the submit button, locator = '//button[@type='submit']'");
    }

    public void clickSubmit() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        LOGGER.trace("Click on the submit button, locator = '//button[@type='submit']'");
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("new_password")).sendKeys(password);
        LOGGER.trace("Enter the '" + password + "' to the new password field, locator(id) = 'new_password'");
        driver.findElement(By.id("confirmed_password")).sendKeys(password);
        LOGGER.trace("Enter the '" + password + "' to the confirm password field, locator(id) = 'confirmed_password'");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        LOGGER.trace("Click on the submit button, locator = '//button[@type='submit']'");
    }

    public WebElement getCaptcha() {
        LOGGER.trace("Trying to get the captcha, locator = '//div[@aria-label='Нажать и удерживать']'");
        return driver.findElement(By.xpath("//div[@aria-label='Нажать и удерживать']"));
    }
}
