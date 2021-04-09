package com.yahoo.finance.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatisticsPage extends BasePage{

    @FindBy(xpath = "//span[contains(text(),'Statistics')]")
    private WebElement statisticsButton;

    @FindBy(xpath = "//span[(text()='Price/Book')]/../following-sibling::td")
    private WebElement priceBookValue;

    public void openStatisticsPage(){
        statisticsButton.click();
    }

    public String getPriceBookValue(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", priceBookValue);
        return priceBookValue.getText();
    }

    public StatisticsPage(WebDriver driver) {
        super(driver);
    }
}
