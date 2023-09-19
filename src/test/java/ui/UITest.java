package ui;
// 1. Открываем сайт https://dev-t.uxcrowd.ru
// 2. Кликаем на иконку чата
// 3. Не заполняя поля ввода, кликаем на кнопку "Отправить"
// 4. Кликаем по кнопке "Закрыть" окна предупреждения об обязательных полях
// 5. Проверяем цвет границы подсветки незаполненных обязательных полей

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UITest {
    private static final String URL = "https://dev-t.uxcrowd.ru";
    //private static final String etalonColor = "rgb(231, 76, 60)"; // Для проверки прохождения теста (некоррекный цвет)
    private static final String etalonColor = "rgb(255, 53, 128)"; // Такой цвет должен быть (такая подсветка используется во многих окнах сайта)

    @Test
    public void testGo() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickChatIcon();
        mainPage.clickSendBtn();
        mainPage.clickCloseErrMsgBtn();
        String borderColor = mainPage.getBorderColor();
        Assertions.assertEquals(borderColor, etalonColor);

        driver.quit();
    }
}
