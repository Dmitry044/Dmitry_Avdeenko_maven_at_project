package classwork.day19;

import homework.day15.tests.junit4.BookingTests;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.LogManager;
import java.util.logging.Logger;


public class JUnitTestClass {

    public static final Logger LOGGER = Logger.getLogger(JUnitTestClass.class.getName());

    @Test
    @TestCaseId(id = "156397")
    public void firstTest() {
        LOGGER.info("Executing firstTest");
        Assert.assertTrue(true);
    }

    @Test
    @TestCaseId(id = "156398")
    public void firstHalfTest() {
        LOGGER.info("Executing firstHalfTest");
        Assert.assertTrue(true);
    }

    @Test
    @TestCaseId(id = "156399")
    public void secondTest() {
        LOGGER.info("Executing secondTest");
        Assert.assertTrue(false);

    }
}
