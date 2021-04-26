package com.yahoo.finance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(id = "header-signin-link")
    private WebElement signInBtn;


    public CreateAccountPage clickSignInBtn() {
        signInBtn.click();
        return new CreateAccountPage(driver);
    }

    public SignInPage(WebDriver driver) {
        super(driver);
    }

}
