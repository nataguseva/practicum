package ru.list.nataguseva.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {

    @FindBy(id = "passp-field-login")
    WebElement loginField;

    @FindBy(id = "passp-field-passwd")
    WebElement passwordField;

    @FindBy(xpath = "//form/div[3]/button")
    WebElement submitLoginButton;

    @FindBy(xpath = "//form/div[3]/button")
    WebElement submitPasswordButton;

    @FindBy(xpath = "//button[@class='ContextMenuButton']")
    WebElement accountMenuButton;

    @FindBy(xpath = "//div[@data-t='popup:context-menu']")
    WebElement accountMenuPopUp;

    @FindBy(xpath = "//div[@class='ContextMenu']/button")
    WebElement logoutButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setLogin(String login) {
        waitForClickabilityOfElement(loginField, getDefaultDuration());
        loginField.sendKeys(login);

    }

    public void setPassword(String password) {
        waitForClickabilityOfElement(passwordField, getDefaultDuration());
        passwordField.sendKeys(password);
    }

    public void clickSubmitLoginButton() {
        waitForClickabilityOfElement(submitLoginButton, getDefaultDuration());
        submitLoginButton.click();
    }

    public void clickSubmitPasswordButton() {
        waitForClickabilityOfElement(submitPasswordButton, getDefaultDuration());
        submitPasswordButton.click();
    }

    public void clickAccountMenuButton() {
        waitForClickabilityOfElement(accountMenuButton, getDefaultDuration() * 2);
        accountMenuButton.click();
    }

    public void clickLogoutButton() {
        waitForVisibilityOfElement(accountMenuPopUp, getDefaultDuration());
        waitForClickabilityOfElement(logoutButton, getDefaultDuration());
        logoutButton.click();
    }

    public void login(String login, String password) {
        setLogin(login);
        clickSubmitLoginButton();
        setPassword(password);
        clickSubmitPasswordButton();
    }

    public void logout() {
        clickAccountMenuButton();
        clickLogoutButton();
    }

}

