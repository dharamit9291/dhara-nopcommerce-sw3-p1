package computer;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Computer;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

import java.awt.*;
import java.util.Random;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //Click on Computer Menu
        //Click on Desktop
        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        WebElement desktop = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));

        actions.moveToElement(computer).moveToElement(desktop).click().build().perform();
        //Select Sort By position "Name: Z to A"
        selectByValue(By.id("products-orderby"), "6");
        //Verify the Product will arrange in Descending order
        String expSortBy= "Name: Z to A";
        String actSortBy= getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        Assert.assertEquals("Not Matching",expSortBy,actSortBy);

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        // Click on Computer Menu.
        // Click on Desktop

        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        WebElement desktop = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));

        actions.moveToElement(computer).moveToElement(desktop).click().build().perform();
        // 2.3 Select Sort By position "Name: A to Z"
        selectByValue(By.id("products-orderby"), "5");
        Thread.sleep(5000);
        // 2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("(//button[contains(text(),'to cart')])[1]"));
        //2.5 Verify the Text "Build your own computer"
        String expectedMessage  = "Build your own computer";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Not verifying",expectedMessage,actualMessage);
       // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.name("product_attribute_1"),"2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7 Select "8GB [+$60.00]" using Select class
        selectByVisibleTextFromDropDown(By.name("product_attribute_2"),"8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.id("product_attribute_5_10"));
        clickOnElement(By.id("product_attribute_5_10"));
        clickOnElement(By.id("product_attribute_5_12"));
        Thread.sleep(5000);
        //2.11 Verify the price "$1,475.00"
        String expTextPrice = "$1,475.00";
        String actTextPrice = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        Assert.assertEquals("Not added correctly",expTextPrice,actTextPrice);

        //2.12 Click on "ADD TO CARD" Button
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expAddMessage = "The product has been added to your shopping cart";
        String actualAddMessage = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("Product not added to cart",expAddMessage,actualAddMessage);
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        //2.14  Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//body/div[6]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //2.15 Verify the message "Shopping cart"
        String expGoToCartMessage = "Shopping cart";
        String actGoToCartMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Not added to shopping cart",expGoToCartMessage,actGoToCartMessage);
        //2.16 Change the Qty to "2" and Click on "Update shopping cart
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendTextToElement(By.xpath("//input[@class='qty-input']"),"2");
        clickOnElement(By.id("updatecart"));
        //2.17 Verify the Total"$2,950.00
        String expTotalValue = "$2,950.00";
        String actTotalValue = getTextFromElement(By.xpath("(//strong[text()='$2,950.00'])[2]"));
        Assert.assertEquals("Not matching total",expGoToCartMessage,actGoToCartMessage);
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expText = "Welcome, Please Sign In!";
        String actText = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Not matching text",expText,actText);
        //2.21Click on “CHECKOUT AS GUEST”Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Prime");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Testing");

        Random ran = new Random();
        int emailNum = ran.nextInt(9999);
        sendTextToElement(By.id("BillingNewAddress_Email"), "ram.lax"+emailNum+"@gmail.com" );

       // sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"prime456@gmail.com");
        selectByValue(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"233");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"London");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"50 Brent Road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"HA0 1AB");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"071234567891");
        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id = 'paymentmethod_1']"));
        //2.27 Select “Master card” From Select credit card dropdown
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //2.28 Fill all the details
        selectByValue(By.id("CreditCardType"),"MasterCard");
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Mr A Smith");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5244301009707149");
        selectByValue(By.xpath("//select[@id='ExpireMonth']"),"4");
        selectByValue(By.xpath("//select[@id='ExpireYear']"),"2028");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"808");
        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        //2.30 Verify “Payment Method” is “Credit Card”
        String expectedPaymentMethod1 = "Payment Method:";
        String actualTextPaymentMethod1 = getTextFromElement(By.xpath("//span[contains(text(), 'Payment Method:')]"));
        Assert.assertEquals("This is not payment method", expectedPaymentMethod1, actualTextPaymentMethod1);

        String expPaymentMethod = "Credit Card";
        String actPaymentMethod = getTextFromElement(By.xpath("//span[contains(text(), 'Credit Card')]"));
        Assert.assertEquals("Not correct payment method",expPaymentMethod,actPaymentMethod);
        //2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedShippingMethod1 = "Shipping Method:";
        String actualShippingMethod1 = getTextFromElement(By.xpath("//span[contains(text(), 'Shipping Method:')]"));
        Assert.assertEquals("This is not shipping method", expectedShippingMethod1, actualShippingMethod1);

        String expShippingMethod = "Next Day Air";
        String actShippingMethod = getTextFromElement(By.xpath("//span[contains(text(),'Next Day Air')]"));
        Assert.assertEquals("Not correct payment method",expShippingMethod,actShippingMethod);
        //2.33 Verify Total is “$2,950.00”
        String expTotal = "$2,950.00";
        String actTotal = getTextFromElement(By.xpath("(//strong[text()='$2,950.00'])[2]"));
        Assert.assertEquals("Not matching total",expTotal,actTotal);
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.35 Verify the Text “Thank You”
        String expVText = "Thank you";
        String actVText = getTextFromElement(By.xpath("//h1[text()='Thank you']"));
        Assert.assertEquals("Not correct text",expVText,actVText);
        //2.36 Verify the message “Your order has been successfully processed!”
        String expVMessage = "Your order has been successfully processed!";
        String actVMessage = getTextFromElement(By.xpath(" //strong[contains(text(), 'fully processed!')]"));
        Assert.assertEquals("Not correct message",expVMessage,actVMessage);
        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath(" //button[@onclick='setLocation(\"/\")']"));
        //2.38 Verify the text “Welcome to our store”
        String expWText = "Welcome to our store";
        String actWText = getTextFromElement(By.xpath("//h2[text()='Welcome to our store']"));
        Assert.assertEquals("Not correct message",expWText,actWText);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
