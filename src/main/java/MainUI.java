// 1. Открываем сайт https://dev-t.uxcrowd.ru
// 2. Кликаем на иконку чата
// 3. Не заполняя поля ввода, кликаем на кнопку "Отправить"
// 4. Кликаем по кнопке "Закрыть" окна предупреждения об обязательных полях
// 5. Проверяем цвет границы подсветки незаполненных обязательных полей

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class MainUI {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://dev-t.uxcrowd.ru");


        WebElement icon = driver.findElement(By.xpath("//div[@class='d-flex align-items-center horizontal svg-icon-background-wrapper h-100 icon-wrapper']"));
            icon.click();

        WebElement button = driver.findElement(By.xpath("//span[@class='text']"));
            button.click();

        WebElement element = driver.findElement(By.xpath("//button[@class='inverse primary']"));
            element.click();


            //System.out.println("кнопка Оправить нажата");

        WebElement borders = driver.findElement(By.xpath("//textarea[@placeholder='Введите Ваш вопрос']"));

        String par = borders.getCssValue("border-color");  //св-ва элемента получить в девтул свойства выделенного элемента

        System.out.println(par);
            //element.sendKeys();

        if (par.equals("rgb(255, 53, 128)")) {
                System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();

    }
}

