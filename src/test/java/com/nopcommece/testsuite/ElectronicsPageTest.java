package com.nopcommece.testsuite;

import com.nopcommece.pages.ElectronicsPage;
import com.nopcommece.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElectronicsPageTest extends BaseTest {
   ElectronicsPage electronicsPage;
   @BeforeMethod(alwaysRun = true)
   public void inIt(){
      electronicsPage = new ElectronicsPage();
   }

   @Test(groups = {"sanity", "regression"})
   public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
      electronicsPage.clickOnElectronicsMenuAndCellPhone();
      Assert.assertEquals(electronicsPage.getCellPhoneText(), "Cell phones", "Not Matching");

   }

   @Test(groups = {"smoke", "regression"})
   public void TheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

// 2.1 Mouse Hover on “Electronics” Tab
// 2.2 Mouse Hover on “Cell phones” and click
// 2.3 Verify the text “Cell phones”
// 2.4 Click on List View Tab
      electronicsPage.clickOnElectronicsMenuAndCellPhone();
      Assert.assertEquals(electronicsPage.getCellPhoneText(), "Cell phones", "Not Matching");
      electronicsPage.clickOnListTab();
// 2.5 Click on product name “Nokia Lumia 1020” link
      electronicsPage.clickOnNokiaLumia1020();
// 2.6 Verify the text “Nokia Lumia 1020”
      Assert.assertEquals(electronicsPage.getNokiaLumiaText(), "Nokia Lumia 1020", "Text Not Matching");
// 2.7 Verify the price “$349.00”
      Assert.assertEquals(electronicsPage.getPriceForNokiaLumia(), "$349.00", "Price Not Matching");
// 2.8 Change quantity to 2
      electronicsPage.updateQuantityTo2();
// 2.9 Click on “ADD TO CART” tab
      electronicsPage.setAddToCart();
// 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
// After that close the bar clicking on the cross button.
      Assert.assertEquals(electronicsPage.getAddedToCartMessage(), "The product has been added to your shopping cart",
              "Not Matching");
      electronicsPage.closePopUpMessage();
// 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
      electronicsPage.clickOnGoToCart();
// 2.12 Verify the message "Shopping cart"
      Assert.assertEquals(electronicsPage.shoppingCartMessage(), "Shopping cart", "Not Matching");
// 2.13 Verify the quantity is 2
      Assert.assertEquals(electronicsPage.updateQuantityMessage(), "2", "Not Matching");
// 2.14 Verify the Total $698.00
      Assert.assertEquals(electronicsPage.verifyTotal(), "$698.00", "Not matching");
// 2.15 click on checkbox “I agree with the terms of service”
      electronicsPage.clickOnCheckBox();
// 2.16 Click on “CHECKOUT”
      electronicsPage.setClickOnCheckoutBox();
// 2.17 Verify the Text “Welcome, Please Sign In!”
      Assert.assertEquals(electronicsPage.verifyWelcomeText(), "Welcome, Please Sign In!", "Not Matching");
// 2.18 Click on “REGISTER” tab
      electronicsPage.clickOnRegisterLink();
// 2.19 Verify the text “Register”
      Assert.assertEquals(electronicsPage.verifyRegisterText(), "Register", "Not Matching");

// 2.20 Fill the mandatory fields // 2.20 Fill the mandatory fields
      electronicsPage.selectRadioButton("", By.id("gender-male"));
      electronicsPage.fillingMandatoryFields("Enter Fist Name", "Prime", By.id("FirstName"));
      electronicsPage.fillingMandatoryFields("Enter Last Name", "Testing", By.id("LastName"));
      electronicsPage.selectByDropDown("Selecting Birth Date", By.name("DateOfBirthDay"), "16");
      Thread.sleep(1000);
      electronicsPage.selectByDropDown("Selecting Birth Month", By.name("DateOfBirthMonth"), "December");
      Thread.sleep(1000);
      electronicsPage.selectByDropDown("Selecting Birth Year", By.name("DateOfBirthYear"), "1965");
      electronicsPage.randomEmailGeneratorAndSendText(By.id("Email"), "Prime", "Testing");
      electronicsPage.randomPasswordGeneratorAndSendText(By.id("Password"), "Testing");
      electronicsPage.randomPasswordGeneratorAndSendText(By.id("ConfirmPassword"), "Testing");
      electronicsPage.selectPressButton("", By.id("register-button"));

// 2.22 Verify the message “Your registration completed”
      assertAssert("Verify the message Your registration completed", electronicsPage.exptectedTextMessage("Your registration completed"),
              electronicsPage.actualTextToVerify(By.xpath("//div[@class='result' and text()='Your registration completed']")));

// 2.23 Click on “CONTINUE” tab
      electronicsPage.selectPressButton("Click on CONTINUE tab", By.xpath("//a[contains(@class, 'continue-button')]"));

// 2.24 Verify the text “Shopping card”
      assertAssert("Verify the text Shopping card", electronicsPage.exptectedTextMessage("Shopping cart"),
              electronicsPage.actualTextToVerify(By.xpath("//h1[text()='Shopping cart']")));

// 2.25 click on checkbox “I agree with the terms of service”
      electronicsPage.selectCheckBox("click on checkbox I agree with the terms of service", By.id("termsofservice"));
// 2.26 Click on “CHECKOUT”
      electronicsPage.selectPressButton("Click on CHECKOUT", By.id("checkout"));

// 2.26 Click on “CHECKOUT”
      electronicsPage.selectByDropDown("Selecting Country", By.id("BillingNewAddress_CountryId"), "India");
      electronicsPage.fillingMandatoryFields("Entering city", "Ahmedabad", By.id("BillingNewAddress_City"));
      electronicsPage.fillingMandatoryFields("Entering Address1", "999 Raghunath Ni Pol", By.id("BillingNewAddress_Address1"));
      electronicsPage.fillingMandatoryFields("Entering Zip Code", "380011", By.id("BillingNewAddress_ZipPostalCode"));
      electronicsPage.fillingMandatoryFields("Entering Phone number", "9989711425", By.id("BillingNewAddress_PhoneNumber"));

// 2.28 Click on “CONTINUE”
      electronicsPage.selectPressButton("Click on CONTINUE", By.name("save"));
// 2.28 Click on “CONTINUE”
      electronicsPage.selectRadioButton("Click on Radio Button 2nd Day Air ($0.00)", By.id("shippingoption_2"));
// 2.30 Click on “CONTINUE”
      electronicsPage.selectPressButton("Click on CONTINUE", By.xpath("//button[@onclick='ShippingMethod.save()']"));

// 2.31 Select Radio Button “Credit Card”
      electronicsPage.selectRadioButton("Select Radio Button Credit Card", By.id("paymentmethod_1"));
      electronicsPage.selectPressButton("click save", By.xpath("//button[@onclick='PaymentMethod.save()']"));

// 2.32 Select “Visa” From Select credit card dropdown
      electronicsPage.selectByDropDown("Select Visa From select credit card dropdown", By.id("CreditCardType"), "Visa");
// 2.33 Fill all the details
      electronicsPage.fillingMandatoryFields("Enter card holder name", "Prime Testing", By.id("CardholderName"));
      electronicsPage.fillingMandatoryFields("Enter card number", "4024007105297690", By.id("CardNumber"));
      electronicsPage.selectByDropDown("Select expiry month", By.id("ExpireMonth"), "10");
      electronicsPage.selectByDropDown("Select expiry year", By.id("ExpireYear"), "2023");
      electronicsPage.fillingMandatoryFields("Entering Credit Card Code", "728", By.id("CardCode"));
// 2.34 Click on “CONTINUE”
      electronicsPage.selectPressButton("Click Continue", By.id("payment-info-buttons-container"));

// 2.35 Verify “Payment Method” is “Credit Card”
      assertAssert("Verify Payment Method is Credit Card", electronicsPage.exptectedTextMessage("Payment Method:"),
              electronicsPage.actualTextToVerify(By.xpath("//span[contains(text(), 'Payment Method:')]")));
      assertAssert("Verify Payment Method is Credit Card", electronicsPage.exptectedTextMessage("Credit Card"),
              electronicsPage.actualTextToVerify(By.xpath("//span[contains(text(), 'Credit Card')]")));

// 2.36 Verify “Shipping Method” is “2nd Day Air”
      assertAssert("Verify Shipping Method” is 2nd Day Air", electronicsPage.exptectedTextMessage("Shipping Method:"),
              electronicsPage.actualTextToVerify(By.xpath("//span[contains(text(), 'Shipping Method:')]")));
      assertAssert("Verify Shipping Method is 2nd Day Air", electronicsPage.exptectedTextMessage("2nd Day Air"),
              electronicsPage.actualTextToVerify(By.xpath("//span[contains(text(), '2nd Day Air')]")));
// 2.37 Verify Total is “$698.00”
      assertAssert("Verify Total is $698.00", electronicsPage.exptectedTextMessage("$698.00"),
              electronicsPage.actualTextToVerify(By.xpath("(//strong[text()='$698.00'])[2]")));
// 2.38 Click on “CONFIRM”
      electronicsPage.selectPressButton("Click continue", By.xpath("//button[@onclick='ConfirmOrder.save()']"));

// 2.39 Verify the Text “Thank You”
      assertAssert("Verify the Text Thank You", electronicsPage.exptectedTextMessage("Thank you"),
              electronicsPage.actualTextToVerify(By.xpath("//h1[text()='Thank you']")));
// 2.40 Verify the message “Your order has been successfully processed!”
      assertAssert("Verify the message Your order has been successfully processed!",
              electronicsPage.exptectedTextMessage("Your order has been successfully processed!"),
              electronicsPage.actualTextToVerify(By.xpath("//strong[contains(text(), 'fully processed!')]")));
// 2.41 Click on “CONTINUE”
      electronicsPage.selectPressButton("Click continue", By.xpath("//button[@onclick='setLocation(\"/\")']"));

// 2.42 Verify the text “Welcome to our store”
      assertAssert("Verify the text Welcome to our store", electronicsPage.exptectedTextMessage("Welcome to our store"),
              electronicsPage.actualTextToVerify(By.xpath("//h2[text()='Welcome to our store']")));
// 2.43 Click on “Logout” link
      electronicsPage.selectPressButton("Click on Logout link", By.linkText("Log out"));

// 2.44 Verify the URL is “https://demo.nopcommerce.com/”
      electronicsPage.verifyCurrentURL("https://demo.nopcommerce.com/");


   }
   }