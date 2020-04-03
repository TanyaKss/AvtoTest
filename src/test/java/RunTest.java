import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.EOFException;
import java.util.concurrent.TimeUnit;

public class RunTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void beforeMain() {
        driver = new ChromeDriver();
        driver.get("https://translate.yandex.ru/");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Test
    public void RunTest() throws EOFException {
        YandexPage ya = new YandexPage(driver);
        ya.intText("Apple");
        ya.getText();
    }

    @After
    public void exit() {
        driver.quit();
    }

}