package com.yahoo.finance.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummaryPage extends BasePage {

    @FindBy(xpath = "//td[@data-test='DIVIDEND_AND_YIELD-value']")
    private WebElement dividendAndYieldValue;

    public String getCompanyDividents() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", dividendAndYieldValue);
        return dividendAndYieldValue.getText();
    }


    public SummaryPage(WebDriver driver) {
        super(driver);
    }
}
