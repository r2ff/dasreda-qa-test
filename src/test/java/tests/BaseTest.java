package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPageBeforeLogin;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    protected MainPageBeforeLogin mainPageBeforeLogin;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPageBeforeLogin = new MainPageBeforeLogin(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
