import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.EOFException;
import java.util.concurrent.TimeUnit;

public class YandexPage {

    private WebDriver driver;
/* Окно ввода исходного текста */
    @FindBy(xpath = ".//div[@id='fakeArea']")
    WebElement intWin;
/* Окно вывода перевода */
    @FindBy(xpath = ".//pre[@id='translation']//span[1]//span")
    WebElement outWin;

    String textString = "Яблоко";

    YandexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /* Метод ввода слова для проверки перевода*/
    public void intText(String t) {
        final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        intWin.isDisplayed();
        intWin.click();
        intWin.sendKeys(t);

    }
    /* Метод проверки перевода*/
    public void getText() throws EOFException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        outWin.isDisplayed();

        String textOut = outWin.getText();
        if (!textOut.equals(textString)) {
            throw new EOFException();
        }

    }

}