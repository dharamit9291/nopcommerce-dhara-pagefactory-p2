package com.nopcommece.testsuite;


import com.nopcommece.pages.HomePage;
import com.nopcommece.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyPageNavigation() {

        String actClick = homePage.selectMenu("Computers");
        String expClick = "Computers";
        Assert.assertEquals(actClick, expClick, "Not matching");

    }
}
