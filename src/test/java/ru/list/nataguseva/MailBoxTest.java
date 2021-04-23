package ru.list.nataguseva;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.list.nataguseva.pages.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class MailBoxTest {
    static WebDriver driver;
    static String searchSummary;
    static int oldCountOfMails;
    static int newCountOfMails;

    LoginPage loginPage;
    ProfilePage profilePage;
    MailBoxPage mailBoxPage;
    MailBoxPage newMailboxPage;


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void checkMailboxBeforeLetter() {

        driver.get(ConfProperties.getProperty("authorizationYandexURL"));

        loginPage = new LoginPage(driver);
        loginPage.setLogin(ConfProperties.getProperty("login"));
        loginPage.clickSubmitLoginButton();
        loginPage.setPassword(ConfProperties.getProperty("password"));
        loginPage.clickSubmitPasswordButton();

        profilePage = new ProfilePage(driver);
        profilePage.clickAccountButton();
        profilePage.clickMailboxButton();

        mailBoxPage = new MailBoxPage(driver);
        mailBoxPage.clickCollapsedSearchField();
        mailBoxPage.fillExpandedSearchField(ConfProperties.getProperty("theme"));
        mailBoxPage.clickSearchButton();
        mailBoxPage.clickFoldersButton();
        mailBoxPage.clickInboxFolderButton();
        searchSummary = mailBoxPage.getSearchSummaryField();
        oldCountOfMails = Helper.getCount(mailBoxPage.getSearchSummaryField());
        mailBoxPage.clickWriteMailButton();
        mailBoxPage.clickToWhomButton();
        mailBoxPage.clickToSelfButton();
        mailBoxPage.fillThemeField(ConfProperties.getProperty("theme"));
        mailBoxPage.fillMailTextField("Найдено " + searchSummary);
        mailBoxPage.clickSendMailButton();

        mailBoxPage.clickSearchInAllFoldersButton();
        mailBoxPage.clickFoldersButton();
        mailBoxPage.clickInboxFolderButton();
        newCountOfMails = Helper.getCount(mailBoxPage.getSearchSummaryField());

        System.out.println("old " + oldCountOfMails);
        System.out.println("new " + newCountOfMails);

 Assert.assertTrue(newCountOfMails > oldCountOfMails);
 }

 @After public void tearDown() {
 driver.get(ConfProperties.getProperty("authorizationYandexURL"));
 loginPage.logout();
 driver.quit();
 }

    }

