package ru.list.nataguseva;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.list.nataguseva.pages.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class MailBoxTest extends BaseTest {
    static WebDriver driver;
    static String searchSummary;
    static int oldCountOfMails;
    static int newCountOfMails;

    LoginPage loginPage;
    ProfilePage profilePage;
    MailboxPage mailBoxPage;


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @Test
    public void mailBoxTest() {

        open(driver, ConfProperties.getProperty("authorizationYandexURL"));

        loginPage = new LoginPage(driver);
        loginPage.login(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        profilePage = new ProfilePage(driver);
        profilePage.clickAccountButton();
        profilePage.clickMailboxButton();

        //open(driver, ConfProperties.getProperty("mailYandexURL"));
        mailBoxPage = new MailboxPage(driver);
        mailBoxPage.filterIncomingMailsByTheme(ConfProperties.getProperty("theme"));

        searchSummary = mailBoxPage.getSearchSummaryField();
        oldCountOfMails = Helper.getCount(searchSummary);
        mailBoxPage.writeMail(ConfProperties.getProperty("theme"), searchSummary);
        driver.navigate().refresh();

        newCountOfMails = Helper.getCount(mailBoxPage.getSearchSummaryField());
        System.out.println("old " + oldCountOfMails);
        System.out.println("new " + newCountOfMails);


        Assert.assertTrue(newCountOfMails > oldCountOfMails);
    }

    @After
    public void tearDown() {
        open(driver, ConfProperties.getProperty("authorizationYandexURL"));
        loginPage.logout();
        driver.quit();
    }

}
