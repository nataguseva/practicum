package ru.list.nataguseva;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.list.nataguseva.pages.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class MailBoxTest {
    static WebDriver driver;
    LoginPage loginPage;
    MailBoxPage mailBoxPage;


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));        //System.setProperty("webdriver.gecko.driver", ConfProperties.getProperty("geckodriver"))
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void mailBoxTest() throws InterruptedException {

        driver.get(ConfProperties.getProperty("authorizationYandexURL"));

        loginPage = new LoginPage(driver);
        loginPage.setLogin(ConfProperties.getProperty("login"));
        loginPage.clickSubmitLoginButton();
        loginPage.setPassword(ConfProperties.getProperty("password"));
        loginPage.clickSubmitPasswordButton();

        Thread.sleep(2000);

        driver.get(ConfProperties.getProperty("mailYandexURL"));

        mailBoxPage = new MailBoxPage(driver);
        mailBoxPage.clickCollapsedSearchField();
        mailBoxPage.fillExpandedSearchField(ConfProperties.getProperty("theme"));
        mailBoxPage.clickSearchButton();
        mailBoxPage.clickFoldersButton();
        Thread.sleep(5000);

        mailBoxPage.clickInboxFolderButton();
        Thread.sleep(2000);
        mailBoxPage.getSearchSummaryField();
       // mailBoxPage.hoverInboxFolderButton();


    /*@AfterClass
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userLogout();
        driver.quit();
    }
    */
    }
}
