package ru.list.nataguseva.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath="//a[@title=\"Написать (w, c)\"]")
    WebElement writeMailButton;

    @FindBy(xpath="//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div/div/div/div/div")
    WebElement toWhomButton;

    @FindBy(xpath="//div[@class=\"ComposeContactsList ComposeContactsSuggestDesktop-List\"]")
    WebElement toSelfButton;

    @FindBy(xpath="//input[@class=\"composeTextField ComposeSubject-TextField\"]")
    WebElement themeField;

    @FindBy(xpath="//div[@id=\"cke_1_contents\"]/div/div")
    WebElement mailTextField;

    @FindBy(xpath ="//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/button")
    WebElement sendMailButton;



    public MailBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void clickFoldersButton() {
        waitForClickabilityOfElement(foldersButton);
        foldersButton.click();
    }

    public void fillExpandedSearchField(String keyWord) {
        waitForClickabilityOfElement(expandedSearchField);
        expandedSearchField.sendKeys(keyWord);
    }
    public void clickCollapsedSearchField() {
        waitForClickabilityOfElement(collapsedSearchField);
        collapsedSearchField.click();
    }

    public void clickSearchButton() {
        waitForClickabilityOfElement(searchButton);
        searchButton.click();
    }

    public void clickInboxFolderButton() {
        waitForVisibilityOfElement(foldersPopUp);
        waitForClickabilityOfElement(inboxFolderButton);
        inboxFolderButton.click();
    }

    public String getSearchSummaryField() {
        waitForVisibilityOfElement(searchSummaryField);
        return searchSummaryField.getText();
    }

    public void clickWriteMailButton() {
        waitForClickabilityOfElement(writeMailButton);
        writeMailButton.click();
    }
    public void clickToWhomButton() {
        waitForClickabilityOfElement(toWhomButton);
        toWhomButton.click();
    }
    public void clickToSelfButton() {
        waitForVisibilityOfElement(toSelfButton);
        waitForClickabilityOfElement(toSelfButton);
        toSelfButton.click();
    }
    public void fillThemeField(String theme) {
        waitForClickabilityOfElement(themeField);
        themeField.click();
        waitForClickabilityOfElement(themeField);
        themeField.sendKeys(theme, Keys.ENTER);
    }

    public void fillMailTextField(String text){
        waitForClickabilityOfElement(mailTextField);
        mailTextField.sendKeys(text);
    }
    public void clickSendMailButton() {
        waitForClickabilityOfElement(sendMailButton);
        sendMailButton.click();
    }


    public void writeMail(String theme, String text) {
        clickWriteMailButton();
        clickToWhomButton();
        clickToSelfButton();
        fillThemeField(theme);
        fillMailTextField(text);
        clickSendMailButton();
    }

}



