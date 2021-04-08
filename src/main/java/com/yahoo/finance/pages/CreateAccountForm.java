package com.yahoo.finance.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Slf4j

public class CreateAccountForm extends BasePage {

    public CreateAccountForm(WebDriver driver) {
        super(driver);
    }


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

    @FindBy(id = "usernamereg-da")
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
        genderInput.click();
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

        Select drpMonth = new Select(monthOfBirthDropDown);

        switch (month) {
            case "January":
                drpMonth.selectByVisibleText("January");
                //drpMonth.selectByValue("1");
                break;
            case "February":
                drpMonth.selectByVisibleText("February");
                break;
            case "March":
                drpMonth.selectByVisibleText("March");
                break;
            case "April":
                drpMonth.selectByVisibleText("April");
                break;
            case "May":
                drpMonth.selectByVisibleText("May");
                break;
            case "June":
                drpMonth.selectByVisibleText("June");
                break;
            case "July":
                drpMonth.selectByVisibleText("July");
                break;
            case "August":
                drpMonth.selectByVisibleText("August");
                break;
            case "September":
                drpMonth.selectByVisibleText("September");
                break;
            case "October":
                drpMonth.selectByVisibleText("October");
                break;
            case "November":
                drpMonth.selectByVisibleText("November");
                break;
            case "December":
                drpMonth.selectByVisibleText("December");
                break;
            default:
                log.info("Month of birth is not selected");
                break;
        }
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


}
