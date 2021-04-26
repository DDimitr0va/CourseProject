package com.yahoo.finance.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AcceptCookies extends BasePage {

    @FindBy(name = "agree")
    private WebElement agreeCookiesBtn;

    public SignInPage clickAgreeCookiesBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", agreeCookiesBtn);
        executeOperationWithExplicitWait(15, ExpectedConditions.visibilityOf(agreeCookiesBtn), 4);
        agreeCookiesBtn.click();
        return new SignInPage(driver);
    }


    public AcceptCookies(WebDriver driver) {
        super(driver);
    }


}
