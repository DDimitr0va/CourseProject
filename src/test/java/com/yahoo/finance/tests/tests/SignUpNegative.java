package com.yahoo.finance.tests.tests;

import com.opencsv.exceptions.CsvException;
import com.yahoo.finance.pages.*;
import com.yahoo.finance.tests.base.TestUtils;
import com.yahoo.finance.utils.CsvReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class SignUpNegative extends TestUtils {

    @DataProvider(name = "login-data")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/createAccount-data.csv");
    }

    @Test(dataProvider = "login-data")
    public void executeSingInTest(String firstName, String lastName, String emailAddress, String password,
                                  String phoneNumber, String monthOfBirth, String dayOfBirth, String yearOfBirth) {
        AcceptCookies acceptCookies = new AcceptCookies(driver);
        SignInPage signInPage = new SignInPage(driver);
        CreateAccountPage createAccount = new CreateAccountPage(driver);
        CreateAccountForm populateCreateAccountData = new CreateAccountForm(driver);

        acceptCookies.clickAgreeCookiesBtn();
        signInPage.clickSignInBtn();
        createAccount.clickCreateAccountBtn();

        populateCreateAccountData.setFirstName(firstName);
        populateCreateAccountData.setLastName(lastName);
        populateCreateAccountData.setEmailAddress(emailAddress);
        populateCreateAccountData.setPassword(password);
        populateCreateAccountData.setPhoneNumber(phoneNumber);
        populateCreateAccountData.setMonthOfBirth(monthOfBirth);
        populateCreateAccountData.setDayOfBirth(dayOfBirth);
        populateCreateAccountData.setYearOfBirth(yearOfBirth);

        ValidationMessages validationMessages = new ValidationMessages(driver);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(validationMessages.getEmailErrorMessage(), "This email address is not available for sign up, try something else");
        softAssert.assertEquals(validationMessages.getPasswordErrorMessage(), "Your password isn’t strong enough, try making it longer.");
        softAssert.assertEquals(validationMessages.getPhoneErrorMessage(), "That doesn’t look right, please re-enter your phone number.");
        softAssert.assertEquals(validationMessages.getBirthDateErrorMessage(), "That doesn’t look right, please re-enter your birthday.");
        softAssert.assertAll();
    }
}
