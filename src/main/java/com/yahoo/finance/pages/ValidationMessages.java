package com.yahoo.finance.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ValidationMessages extends BasePage {
    public ValidationMessages(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "reg-error-yid")
    private WebElement errorEmail;

    @FindBy(id = "reg-error-password")
    private WebElement errorPassword;

    @FindBy(id = "reg-error-phone")
    private WebElement errorPhone;

    @FindBy(id = "reg-error-birthDate")
    private WebElement errorBirthDate;

    public String getEmailErrorMessage() {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(errorEmail), 4);
        return errorEmail.getText();
    }

    public String getPasswordErrorMessage() {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(errorPassword), 4);
        return errorPassword.getText();
    }

    public String getPhoneErrorMessage() {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(errorPhone), 4);
        return errorPhone.getText();
    }

    public String getBirthDateErrorMessage() {
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(errorBirthDate), 4);
        return errorBirthDate.getText();
    }
}
