package configuration;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import pages.InboxPage;
import pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;


public class BaseSettings {

    protected WebDriver driver;
    protected final String DRIVER_PATH = "C:\\Users\\Denis\\Desktop\\Automation\\ChromeDriver\\chromedriver.exe";
    protected final String LOGIN_PAGE_URL = "https://mail.ru/";
    protected final String LOGOUT_URL = "https://mail.ru/?from=logout";
    protected final String USER_EMAIL = "legarcon512@mail.ru";
    protected final String USER_LOGIN = "legarcon512";
    protected final String USER_PASSWORD = "Lesbonbon128";
    protected MainPage mainPage;
    protected InboxPage inboxPage;
    protected WebDriverWait wait;
    protected String assertLogInElement = "//i[@id='PH_user-email']";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        inboxPage = new InboxPage(driver);
        wait = new WebDriverWait(driver, 7);
        mainPage.openMainPage(LOGIN_PAGE_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @DataProvider(name = "emailData")
    public Object[][] getData() {
        Object[][] data = { {"Тестовое письмо", "Денис Марков", "Письмо для тестового задания"},
                            {"Whats up bro", "snegur93@yandex.ru", "Hey buddy how r u doing?"} };
        return data;
    }


}

