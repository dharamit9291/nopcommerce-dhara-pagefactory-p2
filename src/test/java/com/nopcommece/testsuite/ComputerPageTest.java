package com.nopcommece.testsuite;

import com.nopcommece.pages.ComputerPage;
import com.nopcommece.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComputerPageTest extends BaseTest {
    ComputerPage computersPage;
    @BeforeMethod(alwaysRun = true)
    public void inIT(){
        computersPage = new ComputerPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphaBaticalOrder(){
        computersPage.clickOnComputerAndDesktop();
        computersPage.sortComputerDesktops("6");
        Assert.assertEquals(computersPage.gettingListOfProduct(), computersPage.gettingListBeforeSorting());
    }

}
