package com.yahoo.finance.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        return errorEmail.getText();
    }

    public String getPasswordErrorMessage() {
        return errorPassword.getText();
    }

    public String getPhoneErrorMessage() {
        return errorPhone.getText();
    }

    public String getBDateErrorMessage() {
        return errorBirthDate.getText();
    }
}
