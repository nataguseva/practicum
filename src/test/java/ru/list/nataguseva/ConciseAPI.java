package ru.list.nataguseva;

import org.openqa.selenium.WebDriver;


public abstract class ConciseAPI {

    public abstract WebDriver getWebDriver();

    protected void open(String url) {
        getWebDriver().get(url);
    }

}
