package com.nopcommece.testsuite;

import com.nopcommece.pages.ShoppingCartPage;
import com.nopcommece.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCartPageTest extends BaseTest {

    ShoppingCartPage shoppingCartPage;
    @BeforeMethod(alwaysRun = true)
    public void inIT(){
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

// 2.1 Click on Computer Menu.
// 2.2 Click on Desktop
        shoppingCartPage.clickOnComputerAndDesktop();
// 2.3 Select Sort By position "Name: A to Z"
        shoppingCartPage.sortComputerDesktopsToAtoZ("5");
// 2.4 Click on "Add To Cart"
        shoppingCartPage.clickOnShoppingCart();
// 2.5 Verify the Text "Build your own computer"
        assertAssert("Not Matching", shoppingCartPage.exptectedTextMessage("Build your own computer"),
                shoppingCartPage.actualTextToVerify(By.xpath("//h1[contains(text(),'Build your own computer')]")));
// 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        shoppingCartPage.selectByDropDown("Selecting 2.2 GHz Intel Pentium Dual-Core E2200", By.name("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200" );
// 2.7.Select "8GB [+$60.00]" using Select class.
        shoppingCartPage.selectByDropDown("Selecting 2.2 8GB [+$60.00] ", By.name("product_attribute_2"), "8GB [+$60.00]" );
// 2.8 Select HDD radio "400 GB [+$100.00]"
        shoppingCartPage.selectRadioButton("Selecting 400 GB [+$100.00]",By.id("product_attribute_3_7"));
// 2.9 Select OS radio "Vista Premium [+$60.00]"
        shoppingCartPage.selectRadioButton("Selecting Vista Premium [+$60.00]",By.id("product_attribute_4_9"));
// 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        shoppingCartPage.selectCheckBox("Selecting Microsoft Office [+$50.00]\" and \"Total Commander [+$5.00]", By.id("product_attribute_5_12"));
//        2.11 Verify the price "$1,475.00"
        Thread.sleep(3000);
        assertAssert("Not Matching",shoppingCartPage.exptectedTextMessage("$1,475.00"),
                shoppingCartPage.actualTextToVerify(By.xpath("//span[@id='price-value-1']")));
// 2.12 Click on "ADD TO CARD" Button.
        shoppingCartPage.selectPressButton("ADD TO CARD", By.xpath("//button[@id='add-to-cart-button-1']"));
// 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        assertAssert("Not Matching", shoppingCartPage.exptectedTextMessage("The product has been added to your shopping cart"),
                shoppingCartPage.actualTextToVerify(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]")));
        shoppingCartPage.selectPressButton("Clicking Cross button and closing bar", By.xpath("//span[@class='close']"));
// 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        shoppingCartPage.mouseHoveronShoppingCartAndClickOnGoToCart();
// 2.15 Verify the message "Shopping cart"
        assertAssert("Not Matching", shoppingCartPage.exptectedTextMessage("Shopping cart"),
                shoppingCartPage.actualTextToVerify(By.xpath("//h1[contains(text(),'Shopping cart')]")));
// 2.16 Change the Qty to "2" and Click on "Update shopping cart"
        shoppingCartPage.changeTheQuantityTo2AndClickOnUpdateShoppingCart();
// 2.17 Verify the Total"$2,950.00"
        assertAssert("Not Matching", shoppingCartPage.exptectedTextMessage("$2,950.00"),
                shoppingCartPage.actualTextToVerify(By.xpath("(//strong[text()='$2,950.00'])[2]")));
// 2.18 click on checkbox “I agree with the terms of service”
        shoppingCartPage.selectCheckBox("click on checkbox I agree with the terms of service", By.id("termsofservice"));
// 2.19 Click on “CHECKOUT”
        shoppingCartPage.selectPressButton("Pressing checkout Button", By.id("checkout"));
// 2.20 Verify the Text “Welcome, Please Sign In!”
        assertAssert("Not Matching", shoppingCartPage.exptectedTextMessage("Welcome, Please Sign In!"),
                shoppingCartPage.actualTextToVerify(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")));
// 2.21Click on “CHECKOUT AS GUEST” Tab
        shoppingCartPage.selectPressButton("Click on “CHECKOUT AS GUEST”Tab", By.xpath("//button[contains(text(),'Checkout as Guest')]"));
// 2.22 Fill the all mandatory field // 2.23 Click on “CONTINUE”
        shoppingCartPage.fillingMandatoryFields("Entering Fist Name", "Prime", By.id("BillingNewAddress_FirstName"));
        shoppingCartPage.fillingMandatoryFields("Entering Last Name", "Testing", By.id("BillingNewAddress_LastName"));
        shoppingCartPage.randomEmailGeneratorAndSendText(By.id("BillingNewAddress_Email"), "Prime", "Testing");
        shoppingCartPage.selectByDropDown("Selecting Country", By.id("BillingNewAddress_CountryId"), "India");
        shoppingCartPage.fillingMandatoryFields("Entering city", "Ahmedabad", By.id("BillingNewAddress_City"));
        shoppingCartPage.fillingMandatoryFields("Entering Address1", "999 Raghunath Ni Pol", By.id("BillingNewAddress_Address1"));
        shoppingCartPage.fillingMandatoryFields("Entering Zip Code", "380011", By.id("BillingNewAddress_ZipPostalCode"));
        shoppingCartPage.fillingMandatoryFields("Entering Phone number", "9989711425", By.id("BillingNewAddress_PhoneNumber"));
        shoppingCartPage.selectPressButton("Click on Continue", By.name("save"));
// 2.24 Click on Radio Button “Next Day Air($0.00)” // 2.25 Click on “CONTINUE”
        shoppingCartPage.selectRadioButton("Click on Radio Button Next Day Air($0.00)", By.id("shippingoption_1"));
        shoppingCartPage.selectPressButton("clicking CONTINUE", By.xpath("//button[@onclick='ShippingMethod.save()']"));
// 2.26 Select Radio Button “Credit Card”
        shoppingCartPage.selectRadioButton("Select Radio Button Credit Card", By.id("paymentmethod_1"));
        shoppingCartPage.selectPressButton("clicking CONTINUE", By.xpath("//button[@onclick='PaymentMethod.save()']"));
// 2.27 Select “Master card” From Select credit card dropdown
        shoppingCartPage.selectByDropDown("Select Master card From Select credit card dropdown", By.id("CreditCardType"), "Master card");
// 2.28 Fill all the details
        shoppingCartPage.fillingMandatoryFields("Fill the name", "Prime Testing", By.id("CardholderName"));
        shoppingCartPage.fillingMandatoryFields("Entering Credit Card number", "5357793919621142", By.id("CardNumber"));
        shoppingCartPage.selectByDropDown("Selecting Expiry Date", By.id("ExpireMonth"), "10");
        shoppingCartPage.selectByDropDown("Selecting Expiry Month", By.id("ExpireYear"), "2025");
        shoppingCartPage.fillingMandatoryFields("Entering Credit Card Code", "283", By.id("CardCode"));
// 2.29 Click on “CONTINUE”
        shoppingCartPage.selectPressButton("Click Continue Button", By.id("payment-info-buttons-container"));
// 2.30 Verify “Payment Method” is “Credit Card”
        assertAssert("Verify Payment Method is Credit Card", shoppingCartPage.exptectedTextMessage("Payment Method:"),
                shoppingCartPage.actualTextToVerify(By.xpath("//span[contains(text(), 'Payment Method:')]")));
        assertAssert("Verify Payment Method is Credit Card", shoppingCartPage.exptectedTextMessage("Credit Card"),
                shoppingCartPage.actualTextToVerify(By.xpath("//span[contains(text(), 'Credit Card')]")));
// 2.32 Verify “Shipping Method” is “Next Day Air”
        assertAssert("Verify “Shipping Method” is Next Day Air", shoppingCartPage.exptectedTextMessage("Shipping Method:"),
                shoppingCartPage.actualTextToVerify(By.xpath("//span[contains(text(), 'Shipping Method:')]")));
        assertAssert("Verify “Shipping Method” is Next Day Air", shoppingCartPage.exptectedTextMessage("Next Day Air"),
                shoppingCartPage.actualTextToVerify(By.xpath("//span[contains(text(), 'Next Day Air')]")));
// 2.33 Verify Total is “$2,950.00”
        assertAssert("Verify Total is $2,950.00", shoppingCartPage.exptectedTextMessage("$2,950.00"),
                shoppingCartPage.actualTextToVerify(By.xpath("(//strong[text()='$2,950.00'])[2]")));
// 2.34 Click on “CONFIRM”
        shoppingCartPage.selectPressButton("Click on CONFIRM", By.xpath("//button[@onclick='ConfirmOrder.save()']"));
// 2.35 Verify the Text “Thank You”
        assertAssert("Verify the Text Thank You", shoppingCartPage.exptectedTextMessage("Thank you"),
                shoppingCartPage.actualTextToVerify(By.xpath("//h1[text()='Thank you']")));
// 2.36 Verify the message “Your order has been successfully processed!”
        assertAssert("Verify the message Your order has been successfully processed!",
                shoppingCartPage.exptectedTextMessage("Your order has been successfully processed!"),
                shoppingCartPage.actualTextToVerify(By.xpath("//strong[contains(text(), 'fully processed!')]")));
// 2.37 Click on “CONTINUE”
        shoppingCartPage.selectPressButton("Click on CONTINUE", By.xpath("//button[@onclick='setLocation(\"/\")']"));
// 2.37 Verify the text “Welcome to our store”
        assertAssert("Verify the text Welcome to our store", shoppingCartPage.exptectedTextMessage("Welcome to our store"),
                shoppingCartPage.actualTextToVerify(By.xpath("//h2[text()='Welcome to our store']")));

    }
}
