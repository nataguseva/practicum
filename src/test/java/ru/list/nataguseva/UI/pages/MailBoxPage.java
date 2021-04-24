package ru.list.nataguseva.UI.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailBoxPage extends BasePage {

    @FindBy(css = "body>div.popup2.popup2_view_default.popup2_theme_normal.popup2_direction_bottom-left.popup2_visible_yes.popup2_target_anchor>div>div>div:nth-child(1)")
    WebElement inboxFolderButton;

    @FindBy(xpath = "//div[@class=\"popup2 popup2_view_default popup2_theme_normal popup2_direction_bottom-left popup2_visible_yes popup2_target_anchor\"]")
    WebElement foldersPopUp;

    @FindBy(xpath = "//form[@class='search-input__form search-input__form_folded']")
    WebElement collapsedSearchField;

    @FindBy(xpath = "//div[@class='mail-AdvancedSearch']/button[3]")
    WebElement foldersButton;

    @FindBy(xpath = "//input[@class='textinput__control']")
    WebElement expandedSearchField;

    @FindBy(xpath = "//form/button[@type=\"submit\"]")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='mail-MessagesSearchInfo_Summary']")
    WebElement searchInfoSummary;

    @FindBy(xpath = "//span[@class='mail-MessagesSearchInfo-Title']/span")
    WebElement searchSummaryField;

    @FindBy(xpath = "//a[@title=\"Написать (w, c)\"]")
    WebElement writeMailButton;

    @FindBy(xpath = "//div[@class='compose-LabelRow-Content']/div/div[@class='composeYabbles']")
    WebElement toWhomButton;

    @FindBy(xpath = "//div[@class=\"ComposeContactsList ComposeContactsSuggestDesktop-List\"]")
    WebElement toSelfButton;

    @FindBy(xpath = "//input[@class=\"composeTextField ComposeSubject-TextField\"]")
    WebElement themeField;

    @FindBy(xpath = "//div[@id=\"cke_1_contents\"]/div/div")
    WebElement mailTextField;

    @FindBy(xpath = "//div[@class='ComposeControlPanel-Part']/div[1]/button")
    WebElement sendMailButton;

    @FindBy(xpath = "//span[@data-click-action=\"mailbox.check\"]")
    WebElement checkMailBoxButton;

    @FindBy(xpath = "//div[@class=\"mail-MessagesSearchInfo_Summary\"]/span")
    WebElement searchInAllFoldersButton;


    public MailBoxPage(WebDriver driver) {
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
        waitForClickabilityOfElement(collapsedSearchField, getDefaultDuration());
        collapsedSearchField.click();
    }

    public void clickSearchButton() {
        waitForClickabilityOfElement(searchButton, getDefaultDuration());
        searchButton.click();
    }

    public void clickInboxFolderButton() {
        waitForVisibilityOfElement(foldersPopUp, getDefaultDuration());
        waitForClickabilityOfElement(inboxFolderButton, getDefaultDuration());
        inboxFolderButton.click();
    }

    public void waitForSearchInfoSummary() {
        waitForVisibilityOfElement(searchInfoSummary, getDefaultDuration());
    }

    public void waitForChangeOfValue(String oldValue) {
        (new WebDriverWait(driver, getDefaultDuration())).
                until(ExpectedConditions.not(ExpectedConditions.titleContains(oldValue)));
    }

    public String getSearchSummaryField() {
        waitForVisibilityOfElement(searchInfoSummary, getDefaultDuration());
        waitForVisibilityOfElement(searchSummaryField, getDefaultDuration());
        return searchSummaryField.getText();
    }

    public void clickWriteMailButton() {
        waitForClickabilityOfElement(writeMailButton, getDefaultDuration());
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

    public void fillMailTextField(String searchSummary) {
        waitForClickabilityOfElement(mailTextField, getDefaultDuration());
        mailTextField.sendKeys(searchSummary);
    }

    public void clickSendMailButton() {
        waitForClickabilityOfElement(sendMailButton, getDefaultDuration());
        sendMailButton.click();
    }

    public void clickCheckMailboxButton() {
        waitForClickabilityOfElement(checkMailBoxButton, getDefaultDuration());
        checkMailBoxButton.click();
    }

    public void clickSearchInAllFoldersButton() {
        waitForClickabilityOfElement(searchInAllFoldersButton, getDefaultDuration());
        searchInAllFoldersButton.click();
    }
}



