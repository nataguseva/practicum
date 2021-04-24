package ru.list.nataguseva.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/a[1]")
    WebElement accountButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div")
    WebElement accountMenuPopUp;
    @FindBy(xpath = "//ul[@class='menu__group']/li")
    WebElement mailboxButton;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAccountButton() {
        waitForClickabilityOfElement(accountButton, getDefaultDuration());
        accountButton.click();
    }

    public void clickMailboxButton() {
        waitForClickabilityOfElement(mailboxButton, getDefaultDuration() * 3);
        mailboxButton.click();
    }

}
