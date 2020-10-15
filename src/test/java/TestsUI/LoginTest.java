package TestsUI;

import configuration.BaseSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.Assert;


public class LoginTest extends BaseSettings {

    @Test(dataProvider = "emailData")
    public void csiTestCase(String mailSubject, String mailAuthor, String mailBody) {

        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL);

        mainPage.signIn();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(assertLogInElement)));
        Assert.assertEquals(inboxPage.getUserEmail(), USER_EMAIL);

        inboxPage.openEmailSearchedByAuthor(mailAuthor);
        Assert.assertEquals(inboxPage.getEmailSubject(), mailSubject);
        Assert.assertEquals(inboxPage.getEmailAuthor(), mailAuthor);
        Assert.assertEquals(inboxPage.getEmailBody(), mailBody);

        inboxPage.signOut();
        Assert.assertEquals(driver.getCurrentUrl(), LOGOUT_URL);

    }



}
