package com.yahoo.finance.tests.tests;

import com.opencsv.exceptions.CsvException;
import com.yahoo.finance.pages.AcceptCookies;
import com.yahoo.finance.pages.SearchPage;
import com.yahoo.finance.pages.StatisticsPage;
import com.yahoo.finance.pages.SummaryPage;
import com.yahoo.finance.tests.base.TestUtils;
import com.yahoo.finance.utils.CsvReader;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

@Slf4j

public class CheckStatisticsForACompanyStock extends TestUtils{

    @DataProvider(name = "company-data")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/company-data.csv");
    }

    @Test(dataProvider = "company-data")
    public void executeCheckStatisticsTest(String companyName, String companyDividend, String priceBookCurrentValue){
        AcceptCookies acceptCookies=new AcceptCookies(driver);
        SearchPage searchPage=new SearchPage(driver);
        SummaryPage summaryPage=new SummaryPage(driver);
        StatisticsPage statisticsPage=new StatisticsPage(driver);

        acceptCookies.clickAgreeCookiesBtn();
        searchPage.setSearchValue(companyName);
        searchPage.selectSearchResult();
       statisticsPage.openStatisticsPage();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(summaryPage.getCompanyDividents(), companyDividend);
        if(companyDividend.contains("N/A")) {
            log.info(companyName + " is not giving Dividends");
        }
        softAssert.assertEquals(statisticsPage.getPriceBookValue(), priceBookCurrentValue);
        softAssert.assertAll();




       /* WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();*/
    }

}
