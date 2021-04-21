package ru.list.nataguseva.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailBoxPage extends BasePage{

    @FindBy(css="body>div.popup2.popup2_view_default.popup2_theme_normal.popup2_direction_bottom-left.popup2_visible_yes.popup2_target_anchor>div>div>div:nth-child(1)")
    WebElement inboxFolderButton;

    @FindBy(xpath="//div[@class=\"popup2 popup2_view_default popup2_theme_normal popup2_direction_bottom-left popup2_visible_yes popup2_target_anchor\"]")
    WebElement foldersPopUp;

    @FindBy(xpath="//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[2]/div/div/div[1]/div/div/div/div/div[1]/form")
    WebElement collapsedSearchField;

    @FindBy(xpath="//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[3]/div[1]/div/div/button[3]")
    WebElement foldersButton;

    @FindBy(xpath ="//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[2]/div/div/div[1]/div/div/div/div/div[1]/form/div/span/input")
    WebElement expandedSearchField;

    @FindBy(xpath="//form/button[@type=\"submit\"]")
    WebElement searchButton;

    @FindBy(xpath="//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div[1]/div/span/span")
    WebElement searchSummaryField;


    public MailBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void clickFoldersButton() {
        (new WebDriverWait(driver,5)).
                until(ExpectedConditions.elementToBeClickable(foldersButton));
        foldersButton.click();
    }

    public void fillExpandedSearchField(String keyWord) {
        (new WebDriverWait(driver,5)).
                until(ExpectedConditions.elementToBeClickable(expandedSearchField));
        expandedSearchField.sendKeys(keyWord);
    }
    public void clickCollapsedSearchField() {
        (new WebDriverWait(driver,5)).
                until(ExpectedConditions.elementToBeClickable(collapsedSearchField));
        collapsedSearchField.click();
    }

    public void clickSearchButton() {
        (new WebDriverWait(driver,5)).
                until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public void clickInboxFolderButton() {
        (new WebDriverWait(driver,5)).
                until(ExpectedConditions.visibilityOf(foldersPopUp));
        (new WebDriverWait(driver, 5)).
                until(ExpectedConditions.elementToBeClickable(inboxFolderButton));
        inboxFolderButton.click();
    }

    public void getSearchSummaryField() {
        (new WebDriverWait(driver,5)).
                until(ExpectedConditions.visibilityOf(searchSummaryField));
        System.out.println(searchSummaryField.getText());
    }
    }



