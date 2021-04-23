package ru.list.nataguseva.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailboxPage extends BasePage {

    @FindBy(css = "body>div.popup2.popup2_view_default.popup2_theme_normal.popup2_direction_bottom-left.popup2_visible_yes.popup2_target_anchor>div>div>div:nth-child(1)")
    WebElement inboxFolderButton;

    @FindBy(xpath = "//div[@class=\"popup2 popup2_view_default popup2_theme_normal popup2_direction_bottom-left popup2_visible_yes popup2_target_anchor\"]")
    WebElement foldersPopUp;

    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[2]/div/div/div[1]/div/div/div/div/div[1]/form")
    WebElement collapsedSearchField;

    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[3]/div[1]/div/div/button[3]")
    WebElement foldersButton;

    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[2]/div/div/div[1]/div/div/div/div/div[1]/form/div/span/input")
    WebElement expandedSearchField;

    @FindBy(xpath = "//form/button[@type=\"submit\"]")
    WebElement searchButton;

    @FindBy(xpath = "//span[@class='mail-MessagesSearchInfo-Title']/span")
    WebElement searchSummaryField;

    @FindBy(xpath = "//a[@title=\"Написать (w, c)\"]")
    WebElement writeMailButton;

    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div/div/div/div/div")
    WebElement toWhomButton;

    @FindBy(xpath = "//div[@class=\"ComposeContactsList ComposeContactsSuggestDesktop-List\"]")
    WebElement toSelfButton;

    @FindBy(xpath = "//input[@class=\"composeTextField ComposeSubject-TextField\"]")
    WebElement themeField;

    @FindBy(xpath = "//div[@id=\"cke_1_contents\"]/div/div")
    WebElement mailTextField;

    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/button")
    WebElement sendMailButton;


    public MailboxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickFoldersButton() {

        waitForClickabilityOfElement(foldersButton, getDefaultDuration());
        foldersButton.click();
    }

    public void fillExpandedSearchField(String keyWord) {
        waitForClickabilityOfElement(expandedSearchField, getDefaultDuration());
        expandedSearchField.sendKeys(keyWord);
    }

    public void clickCollapsedSearchField() {
        waitForClickabilityOfElement(collapsedSearchField, getDefaultDuration() * 3);
        collapsedSearchField.click();
    }

    public void clickSearchButton() {
        waitForClickabilityOfElement(searchButton, getDefaultDuration());
        searchButton.click();
    }

    public void clickInboxFolderButton() {
        waitForVisibilityOfElement(foldersPopUp, getDefaultDuration());
        waitForClickabilityOfElement(inboxFolderButton, getDefaultDuration() * 2);
        inboxFolderButton.click();
    }

    public String getSearchSummaryField() {
        waitForVisibilityOfElement(searchSummaryField, getDefaultDuration() *3);
        return searchSummaryField.getText();
    }

    public void clickWriteMailButton() {
        waitForClickabilityOfElement(writeMailButton, getDefaultDuration() * 2);
        writeMailButton.click();
    }

    public void clickToWhomButton() {
        waitForClickabilityOfElement(toWhomButton, getDefaultDuration());
        toWhomButton.click();
    }

    public void clickToSelfButton() {
        waitForVisibilityOfElement(toSelfButton, getDefaultDuration());
        waitForClickabilityOfElement(toSelfButton, getDefaultDuration());
        toSelfButton.click();
    }

    public void fillThemeField(String theme) {
        waitForClickabilityOfElement(themeField, getDefaultDuration());
        themeField.click();
        waitForClickabilityOfElement(themeField, getDefaultDuration());
        themeField.sendKeys(theme, Keys.ENTER);
    }

    public void fillMailTextField(String text) {
        waitForClickabilityOfElement(mailTextField, getDefaultDuration());
        mailTextField.sendKeys(text);
    }

    public void clickSendMailButton() {
        waitForClickabilityOfElement(sendMailButton, getDefaultDuration());
        sendMailButton.click();
    }

    public void filterIncomingMailsByTheme(String theme) {
        clickCollapsedSearchField();
        fillExpandedSearchField(theme);
        clickSearchButton();
        clickFoldersButton();
        clickInboxFolderButton();
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



