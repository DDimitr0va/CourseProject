package com.yahoo.finance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(id = "yfin-usr-qry")
    private WebElement searchInput;

    @FindBy(id = "result-quotes-0")
    private WebElement selectResult;

    public void setSearchValue(String companyName) {
        searchInput.click();
        searchInput.sendKeys(companyName);
    }

    public SummaryPage selectSearchResult() {
        selectResult.click();
        return new SummaryPage(driver);
    }


    public SearchPage(WebDriver driver) {
        super(driver);
    }
}
