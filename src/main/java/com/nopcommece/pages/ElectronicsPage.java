package com.nopcommece.pages;

import com.nopcommece.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.Random;

public class ElectronicsPage extends Utility {

    @CacheLookup
    By electronicsMenu = By.xpath("//ul[@class ='top-menu notmobile']/li/a[@href = '/electronics']");

    @CacheLookup
    By cellPhone = By.xpath("//ul[@class ='top-menu notmobile']//a[@href = '/cell-phones']");
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Cell phones')]")
    WebElement getTextCellPhone;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'List')]")
    WebElement clickOnListTab;
    @CacheLookup
    @FindBy(xpath = "//h2/a[contains(text(),'Nokia Lumia 1020')]")
    WebElement clickOnNokiaLumia1020;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Nokia Lumia 1020')]")
    WebElement getTextNokiaLumia1020;
    @CacheLookup
    @FindBy(xpath = "//span[@id='price-value-20']")
    WebElement getPriceForNokiaLumia;
    @CacheLookup
    @FindBy(xpath = "//input[@id='product_enteredQuantity_20']")
    WebElement updateQuantity;
    @CacheLookup
    @FindBy(id = "add-to-cart-button-20")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]/p[1]")
    WebElement addedToCartMessage;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]/span[1]")
    WebElement closeMessage;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
    WebElement hoverToShoppingCart;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Go to cart')]")
    WebElement clickOnGoToCart;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
    WebElement shoppingCartMessage;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'(2)')]")
    WebElement quantityMessage;

    @CacheLookup
    @FindBy(xpath = "(//strong[text()='$698.00'])[2]")
    WebElement total698;

    @CacheLookup
    @FindBy(xpath = "//input[@id='termsofservice']")
    WebElement clickOnCheck;
    @CacheLookup
    @FindBy
    By clickOnCheckout = By.xpath("//button[@id='checkout']");

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeMessage;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Register')]")
    WebElement clickRegister;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement verifyRegister;

    public void clickOnElectronicsMenuAndCellPhone() {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(electronicsMenu)).moveToElement(driver.findElement(cellPhone)).click().build().perform();
    }

    public String getCellPhoneText() throws InterruptedException {
        Thread.sleep(2000);

        return getTextFromElement(getTextCellPhone);
    }

    public void clickOnListTab() {
        clickOnElement(clickOnListTab);
    }

    public void clickOnNokiaLumia1020() throws InterruptedException {
        Thread.sleep(3000);
        Reporter.log("click on nokia lumia "+clickOnNokiaLumia1020);
        clickOnElement(clickOnNokiaLumia1020);
    }

    public String getNokiaLumiaText() {
        Reporter.log("get nokia text");

        return getTextFromElement(getTextNokiaLumia1020);
    }

    public String getPriceForNokiaLumia() {
    Reporter.log("get price for nokia ");
        return getTextFromElement(getPriceForNokiaLumia);
    }

    public void updateQuantityTo2() {
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(updateQuantity, "2");
    }

    public void setAddToCart() {
        Reporter.log("add to the cart");
        clickOnElement(addToCart);
    }

    public String getAddedToCartMessage() {

        return getTextFromElement(addedToCartMessage);
    }

    public void closePopUpMessage() {
        clickOnElement(closeMessage);
    }

    public void clickOnGoToCart() {
        mouseHoverToElement(hoverToShoppingCart);
        clickOnElement(clickOnGoToCart);
    }

    public String shoppingCartMessage() {
        Reporter.log("shopping cart message "+ shoppingCartMessage.getText());
        return getTextFromElement(shoppingCartMessage);
    }

    public String updateQuantityMessage() {

        return getTextFromElement(quantityMessage).substring(1, 2);
    }

    public String verifyTotal() {
        Reporter.log("verified total"+total698.getText());
        return getTextFromElement(total698);
    }

    public void clickOnCheckBox() {
        clickOnElement(clickOnCheck);
    }

    public void setClickOnCheckoutBox() {
        clickOnElement(clickOnCheckout);
    }

    public String verifyWelcomeText() {
        Reporter.log("verify welcome text"+welcomeMessage.getText());
        return getTextFromElement(welcomeMessage);
    }

    public void clickOnRegisterLink() {
        clickOnElement(clickRegister);
    }

    public String verifyRegisterText() {

        return getTextFromElement(verifyRegister);
    }

    public void fillingMandatoryFields(String message, String sendText, By by) {
        sendTextToElement(by, sendText);
    }

    public void selectRadioButton(String message, By by) {
        clickOnElement(by);
    }

    public void selectByDropDown(String message, By by, String name) {
        selectByVisibleTextFromDropDown(by, name);
    }

    public void randomEmailGeneratorAndSendText(By by, String firstName, String lastName) {
        Random randomGenerator = new Random();
        int emailNum = randomGenerator.nextInt(9999);
        String email = firstName + "." + lastName + emailNum + "@email.com";
        sendTextToElement(by, email);
    }

    public void randomPasswordGeneratorAndSendText(By by, String lastName) {
//        Random randomGenerator = new Random();
//        int passNum = randomGenerator.nextInt(999);
        int passNum = 156;
        String password = lastName + "#" + passNum;
        sendTextToElement(by, password);
    }

    public void selectPressButton(String message, By by) {

        clickOnElement(by);
    }
    //==================these methods allow to compare text by taking parameters==============
    public String exptectedTextMessage(String expected) {
        System.out.println("Expected Text or Message is : " + expected);
        return expected;
    }

    public String actualTextToVerify(By by) {
        String actual = driver.findElement(by).getText();
        System.out.println("Actual Text or Message is : " + actual);
        return actual;
    }
    //==================these methods allow to compare text by taking parameters==============

    public void selectCheckBox(String message, By by) {
        clickOnElement(by);
    }

    public void verifyCurrentURL(String urlText) {
        String expectedUrl = urlText;
        String actualUrl = driver.getCurrentUrl();
        assertAssert("url not matching", expectedUrl, actualUrl);
    }
}
