package ru.list.nataguseva.pages;

import org.openqa.selenium.WebDriver;
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
}
