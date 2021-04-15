package com.yahoo.finance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StatisticsPage extends BasePage {

    @FindBy(xpath = "//li[@data-test='STATISTICS']")
    private WebElement statisticsButton;

    @FindBy(xpath = "//span[(text()='Price/Book')]/../following-sibling::td")
    private WebElement priceBookValue;


    public void openStatisticsPage() {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(statisticsButton), 4);
        statisticsButton.click();
    }

    public String getPriceBookValue() {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(priceBookValue), 4);
        return priceBookValue.getText();
    }

    public StatisticsPage(WebDriver driver) {
        super(driver);
    }
}
