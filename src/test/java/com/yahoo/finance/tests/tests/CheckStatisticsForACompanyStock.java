package com.yahoo.finance.tests.tests;

import com.opencsv.exceptions.CsvException;
import com.yahoo.finance.pages.AcceptCookies;
import com.yahoo.finance.pages.SearchPage;
import com.yahoo.finance.pages.StatisticsPage;
import com.yahoo.finance.pages.SummaryPage;
import com.yahoo.finance.tests.base.TestUtils;
import com.yahoo.finance.utils.CsvReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;


public class CheckStatisticsForACompanyStock extends TestUtils {

    @DataProvider(name = "company-data")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/company-data.csv");
    }

    @Test(dataProvider = "company-data")
    public void executeCheckStatisticsTest(String companyName, String companyDividend, String priceBookCurrentValue) {

        AcceptCookies acceptCookies = new AcceptCookies(driver);
        SearchPage searchPage = new SearchPage(driver);
        SummaryPage summaryPage = new SummaryPage(driver);
        StatisticsPage statisticsPage = new StatisticsPage(driver);
        SoftAssert softAssert = new SoftAssert();

        acceptCookies.clickAgreeCookiesBtn();
        searchPage.setSearchData(companyName);
        searchPage.selectSearchResult();
        softAssert.assertEquals(summaryPage.getCompanyDividends(companyName), companyDividend);
        statisticsPage.openStatisticsPage();
        softAssert.assertEquals(statisticsPage.getPriceBookValue(), priceBookCurrentValue);
        softAssert.assertAll();
    }

}
