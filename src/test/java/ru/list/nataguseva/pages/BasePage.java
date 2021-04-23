package ru.list.nataguseva.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    public BasePage() {
    }
    public int defaultDuration =7;

    public int getDefaultDuration() {
        return defaultDuration;
    }


    public WebDriver getWebDriver() {
        return driver;
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver driver;

    public void waitForVisibilityOfElement(WebElement element, int duration) {
        (new WebDriverWait(driver, getDefaultDuration())).
                until(ExpectedConditions.visibilityOf(element));
    }


    public void waitForClickabilityOfElement(WebElement element, int duration) {
        (new WebDriverWait(driver, getDefaultDuration())).
                until(ExpectedConditions.elementToBeClickable(element));
    }


}
