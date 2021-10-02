package tests;

import config.Credential;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPageBeforeLogin;

import java.time.Duration;

public class MailWebTest extends BaseTest{

    @Test
    void openMailRuTest() {
        driver.get("https://mail.ru/");
        Assertions.assertEquals("Mail.ru: почта, поиск в интернете, новости, игры", driver.getTitle());
    }

    @Test
    void loginMailTest() {
        driver.get("https://mail.ru/");
        String mailSendMessage = mainPageBeforeLogin.loginAs(Credential.config.email(), Credential.config.password())
                .writeMessageTo(Credential.config.email(), "text sub", "textbody");
        Assertions.assertEquals("Письмо отправлено", mailSendMessage);
    }
}
