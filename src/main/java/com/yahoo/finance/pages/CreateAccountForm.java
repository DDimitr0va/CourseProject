package com.yahoo.finance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountForm extends BasePage {

    @FindBy(id = "usernamereg-firstName")
    private WebElement firstNameInput;

    @FindBy(id = "usernamereg-lastName")
    private WebElement lastNameInput;

    @FindBy(id = "usernamereg-yid")
    private WebElement emailAddressInput;

    @FindBy(id = "usernamereg-password")
    private WebElement passwordInput;

    @FindBy(id = "usernamereg-phone")
    private WebElement phoneNumberInput;

    @FindBy(id = "usernamereg-month")
    private WebElement monthOfBirthDropDown;

    @FindBy(id = "usernamereg-day")
    private WebElement dayOfBirthInput;

    @FindBy(id = "usernamereg-year")
    private WebElement yearOfBirthInput;

    @FindBy(id = "usernamereg-freeformGender")
    private WebElement genderInput;


    public void setFirstName(String fistName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(fistName);
    }

    public void setLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void setEmailAddress(String emailAdress) {
        emailAddressInput.clear();
        emailAddressInput.sendKeys(emailAdress);
    }

    public void setPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phoneNumber);
    }

    public void setMonthOfBirth(String month) {
        monthOfBirthDropDown.sendKeys(month);
    }

    public void setDayOfBirth(String dayOfBirth) {
        dayOfBirthInput.clear();
        dayOfBirthInput.sendKeys(dayOfBirth);
    }

    public void setYearOfBirth(String yearOfBirth) {
        yearOfBirthInput.clear();
        yearOfBirthInput.sendKeys(yearOfBirth);
        genderInput.click();
    }

    public CreateAccountForm(WebDriver driver) {
        super(driver);
    }

}
