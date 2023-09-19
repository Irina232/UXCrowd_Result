package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {
    public MainPage(WebDriver dr) {
        super(dr);
    }

    public void clickChatIcon() {
        WebElement chatIcon = driver.findElement(By.xpath("//div[@class='d-flex align-items-center horizontal svg-icon-background-wrapper h-100 icon-wrapper']"));
        chatIcon.click();
    }

    public void clickSendBtn() {
        WebElement sendBtn = driver.findElement(By.xpath("//span[@class='text']"));
        sendBtn.click();
    }

    public void clickCloseErrMsgBtn() {
        WebElement closeErrMsgBtn = driver.findElement(By.xpath("//button[@class='inverse primary']"));
        closeErrMsgBtn.click();
    }

    public String getBorderColor() {
        WebElement borders = driver.findElement(By.xpath("//textarea"));
        return borders.getCssValue("border-color");  //св-ва элемента получить в девтул свойства выделенного элемента
    }
}
