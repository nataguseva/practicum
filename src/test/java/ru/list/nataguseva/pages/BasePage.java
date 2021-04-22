package ru.list.nataguseva.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.list.nataguseva.ConciseAPI;

/**
 * Created by yashaka on 7/18/15.
 */
public class BasePage extends ConciseAPI {

    public BasePage() {
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected WebDriver driver;

    public void wait5SecondsForVisibilityOfElement(WebElement element) {
        (new WebDriverWait(driver,5)).
                until(ExpectedConditions.visibilityOf(element));
    }
    public void wait5SecondsForClickabilityOfElement(WebElement element) {
        (new WebDriverWait(driver,5)).
                until(ExpectedConditions.elementToBeClickable(element));
    }

}
