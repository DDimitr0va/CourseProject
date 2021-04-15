package com.yahoo.finance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SummaryPage extends BasePage {

    @FindBy(xpath = "//td[@data-test='DIVIDEND_AND_YIELD-value']")
    private WebElement dividendAndYieldValue;

    public String getCompanyDividents() {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(dividendAndYieldValue), 4);
        return dividendAndYieldValue.getText();
    }

    public SummaryPage(WebDriver driver) {
        super(driver);
    }
}
