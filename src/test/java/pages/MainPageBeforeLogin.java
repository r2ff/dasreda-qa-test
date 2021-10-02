package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageBeforeLogin {
    protected WebDriver driver;

    private By loginInputBy = By.cssSelector("[data-testid=login-input]");
    private By enterPasswordButtonBy = By.cssSelector("[data-testid=enter-password]");
    private By passwordInput = By.cssSelector("[data-testid=password-input]");
    private By loginToMailButton = By.cssSelector("[data-testid=login-to-mail]");

    public MainPageBeforeLogin(WebDriver driver){
        this.driver = driver;
    }

    public MainPageAfterLogin loginAs(String email, String password) {
        driver.findElement(loginInputBy).sendKeys(email);
        driver.findElement(enterPasswordButtonBy).click();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginToMailButton).click();
        return new MainPageAfterLogin(driver);
    }



}
