package com.yahoo.finance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {

    @FindBy(id = "createacc")
    private WebElement createAccountBtn;


    public CreateAccountForm clickCreateAccountBtn() {
        createAccountBtn.click();
        return new CreateAccountForm(driver);
    }

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

}