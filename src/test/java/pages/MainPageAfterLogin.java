package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageAfterLogin {
    protected WebDriver driver;

    private By newMailBy = By.cssSelector(".compose-button__txt");
    private By mailToBy = By.cssSelector(".container--H9L5q");
    private By subjectBy = By.name("Subject");
    private By bodyMailBy = By.cssSelector("[role=textbox]");
    private By sendButtonBy = By.cssSelector("[title=Отправить]");
    private By mailSuccessfulSendBy = By.cssSelector(".layer__link");

    public MainPageAfterLogin(WebDriver driver) {
        this.driver = driver;
    }

    public String writeMessageTo(String email, String subject, String body) {
        driver.findElement(newMailBy).click();
        driver.findElement(mailToBy).sendKeys(email);
        driver.findElement(subjectBy).sendKeys(subject);
        driver.findElement(bodyMailBy).sendKeys(body);
        driver.findElement(sendButtonBy).click();
        return driver.findElement(mailSuccessfulSendBy).getText();
    }
}
