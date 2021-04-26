package com.yahoo.finance.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j

public class SummaryPage extends BasePage {

    @FindBy(xpath = "//td[@data-test='DIVIDEND_AND_YIELD-value']")
    private WebElement dividendAndYieldValue;

    public String getCompanyDividends(String companyName) {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(dividendAndYieldValue), 4);
        if (dividendAndYieldValue.getText().contains("N/A")) {
            log.info("{} is not giving Dividends", companyName);
        }
        return dividendAndYieldValue.getText();
    }

    public SummaryPage(WebDriver driver) {
        super(driver);
    }
}
