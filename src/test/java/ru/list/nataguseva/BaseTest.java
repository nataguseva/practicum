package ru.list.nataguseva;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    WebDriver driver;
    public static void open(WebDriver driver, String url) {
        driver.get(url);
        (new WebDriverWait(driver, 7)).until(ExpectedConditions.urlContains(url));
    }

}
