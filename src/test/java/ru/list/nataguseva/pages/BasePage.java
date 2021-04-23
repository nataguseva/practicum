package ru.list.nataguseva.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public BasePage() {
    }
    private int defaultDuration = 15;

    public int getDefaultDuration() {
        return defaultDuration;
    }

    protected WebDriver driver;

    public void waitForVisibilityOfElement(WebElement element, int defaultDuration) {
        (new WebDriverWait(driver,getDefaultDuration())).
                until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForClickabilityOfElement(WebElement element, int defaultDuration) {
        (new WebDriverWait(driver,getDefaultDuration())).
                until(ExpectedConditions.elementToBeClickable(element));
    }

}
