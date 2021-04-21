package ru.list.nataguseva.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage{

    @FindBy(id="passp-field-login")
    WebElement loginField;

    @FindBy(id="passp-field-passwd")
    WebElement passwordField;

    @FindBy(xpath = "//form/div[3]/button")
    WebElement submitLoginButton;

    @FindBy(xpath = "//form/div[3]/button")
    WebElement submitPasswordButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setLogin(String login) {
        (new WebDriverWait(driver, 6)).
                until(ExpectedConditions.elementToBeClickable(loginField));
        loginField.sendKeys(login);

    }

    public void setPassword(String password) {
        (new WebDriverWait(driver, 6)).
                until(ExpectedConditions.
                        elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
    }

    public void clickSubmitLoginButton() {
        (new WebDriverWait(driver, 6)).
                until(ExpectedConditions.
                        elementToBeClickable(submitLoginButton));
        submitLoginButton.click();
    }
    public void clickSubmitPasswordButton() {
        (new WebDriverWait(driver, 6)).
                until(ExpectedConditions.
                        elementToBeClickable(submitPasswordButton));
        submitPasswordButton.click();
    }
}
