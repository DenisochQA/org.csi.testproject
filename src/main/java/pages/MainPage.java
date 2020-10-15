package pages;

import configuration.BaseSettings;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;


import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class MainPage extends BaseSettings {

    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = xpath("//input[@id='mailbox:login-input']");
    private By typePasswordButton = xpath("//input[@value='Ввести пароль']");
    private By passwordField = xpath("//input[@id='mailbox:password-input']");
    private By signInButton = xpath("//button[@id='mailbox:submit-button']");


    public MainPage openMainPage(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            System.out.println("Страница не найдена");
        } finally {
            return this;
        }
    }

    public void signIn() {
        try {
            driver.findElement(loginField).sendKeys(USER_LOGIN);
            driver.findElement(typePasswordButton).click();
            driver.findElement(passwordField).sendKeys(USER_PASSWORD);
            driver.findElement(signInButton).click();
        } catch (Exception e) {
            System.out.println("Неверный логин или пароль");
        }
    }

}
