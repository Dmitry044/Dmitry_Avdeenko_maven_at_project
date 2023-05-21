package homework.day14;

import homework.day15.driver.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;

public class CheckColorTest {
    WebDriver driver = Driver.getWebDriver();

    @Before
    public void beforeTests() {
        Driver. setTimeOuts(10,10,10);
    }

    @After
    public void afterTests() {
        driver.quit();
    }

    @Test
    public void colorsTest() {
        driver.get("https://booking.com");
        driver.findElement(By.xpath("//div[@role='dialog'][@aria-modal='true']//button")).click();
        driver.findElement(By.cssSelector("[name='ss']")).sendKeys("Париж");
        driver.findElement(By.xpath("//*[@data-testid='autocomplete-result']/div/div[text()='Париж']")).click();
        driver.findElement(By.cssSelector("[data-date='2023-05-15']")).click();
        driver.findElement(By.cssSelector("[data-date='2023-05-21']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",
                driver.findElement(By.xpath("//*[@data-testid='property-card'][10]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='green'",
                driver.findElement(By.xpath("//*[@data-testid='property-card'][10]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color='red'",
                driver.findElement(By.xpath("//*[@data-testid='property-card'][10]//descendant:: div[@data-testid='title']")));
        Assert.assertEquals("The text color isn't red", "color: red;", driver.findElement(By.xpath("//*[@data-testid='property-card'][10]//descendant:: div[@data-testid='title']")).getAttribute("style"));
    }










    /*


    private WebDriver driver;
    private JavascriptExecutor js;

    @Before
    public void setUp() {
        // Инициализируем драйвер браузера
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testChangeTitleColor() {
        // Переходим на сайт booking.com
        driver.get("https://www.booking.com/");

        // Находим поле ввода города и вводим "Москва"
        WebElement cityInput = driver.findElement(By.name("ss"));
        cityInput.sendKeys("Москва");

        // Находим кнопку поиска и кликаем на нее
        WebElement searchButton = driver.findElement(By.cssSelector(".sb-searchbox__button"));
        searchButton.click();

        // Ожидаем, что заголовок страницы будет содержать "Москва"
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.titleContains("Москва"));

        // Скроллим страницу до 10-го отеля сверху
        WebElement hotel = driver.findElement(By.cssSelector(".sr_item:nth-child(10)"));
        js.executeScript("arguments[0].scrollIntoView();", hotel);

        WebDriver driver = new ChromeDriver();
        WebElement element = driver.findElement(By.id("id_of_element"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("document.getElementById('ts').scrollIntoView(true);");

       *//* // Ожидаем, что отель станет видимым на странице
        wait.until(ExpectedConditions.visibilityOf(hotel));

        // Находим название отеля и меняем цвет фона и цвет текста
        WebElement hotelTitle = hotel.findElement(By.cssSelector(".sr-hotel__name"));
        js.executeScript("arguments[0].style.backgroundColor='green'; arguments[0].style.color='red';", hotelTitle);

        // Проверяем, что название отеля стало красного цвета
        wait.until(ExpectedConditions.attributeToBe(hotelTitle, "color", "rgba(255, 0, 0, 1)"));
        String titleColor = hotelTitle.getCssValue("color");
        assertEquals("rgba(255, 0, 0, 1)", titleColor);*//*
    }

    @After
    public void tearDown() {
        // Закрываем браузер
        driver.quit();
    }*/
}
