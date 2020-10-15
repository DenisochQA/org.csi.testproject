package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class InboxPage {

    private WebDriver driver;

    public InboxPage(WebDriver driver) {
        this.driver = driver;
    }

    private By logoutButton = xpath("//a[@id='PH_logoutLink']");
    private By userCredentials = xpath("//i[@id='PH_user-email']");
    private String mailTitle = "//span[contains(@title, '%s')]";
    private By emailSubject = xpath("//div[@class='thread__subject-line']/h2");
    private By emailAuthor = xpath("//div[@class='letter__author']/span");
    private By emailBody = xpath("//div[@class='letter-body']");

    public void signOut() {
        driver.findElement(logoutButton).click();
    }

    public String getUserEmail() {
        String userEmail = driver.findElement(userCredentials).getText();
        return userEmail;
    }

    public InboxPage openEmailSearchedByAuthor(String author) {
        try {
            driver.findElement(xpath(format(mailTitle, author))).click();
        } catch (Exception e) {
            System.out.println("Письмо с таким автором не найдено");
        } finally {
            return this;
        }

    }

    public String getEmailSubject() {
        String subject = driver.findElement(emailSubject).getText();
        return subject;
    }

    public String getEmailAuthor() {
        String author = driver.findElement(emailAuthor).getText();
        return author;
    }

    public String getEmailBody() {
        String body = driver.findElement(emailBody).getText();
        return body;
    }

}
