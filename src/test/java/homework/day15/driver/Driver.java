package homework.day15.driver;

import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;


public class Driver {

    private static WebDriver webDriver;

    public static final Logger LOGGER = Logger.getLogger(Driver.class.getName());
    protected static Config config =
            Optional.ofNullable(System.getProperty("CONFIG")).isEmpty()? Config.valueOf(System.getProperty("CONFIG")):
    Config.CHROME;

    public static WebDriver getWebDriver() {
        if (null == webDriver) {
            webDriver = DriverManager.getDriver(config);
            //setTimeOuts(5);
            setTimeOuts(6,6,6);
        }
        return webDriver;
    }

    public static void closeDriver(){
        webDriver.quit();
        webDriver.close();
        LOGGER.trace("Kill ChromeDriver");
    }

    /*private static void setTimeOuts(int i) {
        if(webDriver != null){
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }*/

    public static void setTimeOuts(int scriptTimeout, int pageLoadTimeout, int implicitlyWait) {
        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(scriptTimeout));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
        LOGGER.trace("Set timeouts " + scriptTimeout + ", " + pageLoadTimeout + ", " + implicitlyWait + "");
    }

}
