package com.yahoo.finance.tests.tests;

import com.opencsv.exceptions.CsvException;
import com.yahoo.finance.tests.base.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test2Test extends TestUtils {


    @Test
    public void fillInForm() {

        WebElement clickBtn = driver.findElement(By.name("agree"));
        clickBtn.click();
        WebElement signInButton = driver.findElement(By.cssSelector("#header-signin-link"));
        signInButton.click();
        WebElement createAccButton = driver.findElement(By.cssSelector("#createacc"));
        createAccButton.click();

        setMonthOfBirth("March");

    }

    private void setMonthOfBirth(String month) {
        Select drpMonth = new Select(driver.findElement(By.id("usernamereg-month")));

        switch (month) {
            case "January":
                drpMonth.selectByValue("1");
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
                System.out.println("not January");
                break;
        }
    }

}

