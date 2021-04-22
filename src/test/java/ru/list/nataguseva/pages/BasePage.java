package ru.list.nataguseva.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.list.nataguseva.ConciseAPI;


public class BasePage extends ConciseAPI {

    private int commonDuration = 5;

    public BasePage() {
    }


    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver driver;

    public void setCommonDuration(int commonDuration) {
        this.commonDuration = commonDuration;
    }

    public int getCommonDuration() {
        return commonDuration;
    }

    public void waitForVisibilityOfElement(WebElement element) {

        (new WebDriverWait(driver, getCommonDuration())).
                until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickabilityOfElement(WebElement element) {
        (new WebDriverWait(driver, getCommonDuration())).
                until(ExpectedConditions.elementToBeClickable(element));
    }

}
