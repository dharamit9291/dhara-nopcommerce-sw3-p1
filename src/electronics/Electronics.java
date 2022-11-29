package electronics;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

import java.util.Random;

public class Electronics extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp (){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        // 1.1 Mouse Hover on “Electronics”Tab
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        //   1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //   1.3 Verify the text “Cell phones”
        String expText = "Cell phones";
        Thread.sleep(5000);
        String actText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Not correct text", expText, actText);
    }
        @Test
        public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

          //  2.1 Mouse Hover on “Electronics” Tab
            mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
         //   2.2 Mouse Hover on “Cell phones” and click
            mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
         //   2.3 Verify the text “Cell phones”
            String expText = "Cell phones";

            String actText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
            Assert.assertEquals("Not correct text", expText, actText);
            //2.4 Click on List View Tab
            clickOnElement(By.xpath("//a[contains(text(),'List')]"));
            //2.5 Click on product name “Nokia Lumia 1020” link
            Thread.sleep(2000);
            clickOnElement(By.xpath("//h2/a[contains(text(),'Nokia Lumia 1020')]"));
            //2.6 Verify the text “Nokia Lumia 1020”
            String expNText = "Nokia Lumia 1020";
            Thread.sleep(2000);
            String actNText = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
            Assert.assertEquals("Not correct text", expNText, actNText);
            //2.7 Verify the price “$349.00”
            String expPrice = "$349.00";
            String actPrice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
            Assert.assertEquals("Not correct text", expPrice, actPrice);
           // 2.8 Change quantity to 2
            driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
            sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");
            // 2.9 Click on “ADD TO CART” tab
            clickOnElement(By.id("add-to-cart-button-20"));
            //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
            String expMessage = "The product has been added to your shopping cart";
            String actMessage = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
            Assert.assertEquals("Not correct text", expMessage, actMessage);
            clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
            //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
            mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
            clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
            //2.12 Verify the message "Shopping cart"
            String expSMessage = "Shopping cart";
            String actSMessage = getTextFromElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
            Assert.assertEquals("Not correct message", expSMessage, actSMessage);
            //2.13 Verify the quantity is 2
            String expQuantity = "2";
            String actQuantity = getTextFromElement(By.xpath("//span[contains(text(),'(2)')]"));
            Assert.assertEquals("Not correct message",expQuantity, actQuantity.substring(1,2));
            //2.14 Verify the Total $698.00
            Thread.sleep(2000);
            String expTotal = "$698.00";
            String actTotal = getTextFromElement(By.xpath("(//strong[text()='$698.00'])[2]"));
            System.out.println(actTotal);
            Assert.assertEquals("Not correct total ",expTotal, actTotal);
            //2.15 click on checkbox “I agree with the terms of service”
            clickOnElement(By.xpath("//input[@id='termsofservice']"));
            //2.16 Click on “CHECKOUT”
            clickOnElement(By.xpath("//button[@id='checkout']"));
           //2.17 Verify the Text “Welcome, Please Sign In!”
            String expTMessage = "Welcome, Please Sign In!";
            String actTMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
            Assert.assertEquals("Not correct message", expTMessage, actTMessage);
           //2.18 Click on “REGISTER” tab
            clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
           //2.19 Verify the text “Register”
            String expRMessage = "Register";
            String actRMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
            Assert.assertEquals("Not correct message", expRMessage, actRMessage);
           // 2.20 Fill the mandatory fields
            sendTextToElement(By.xpath("//input[@id='FirstName']"),"Prime");
            sendTextToElement(By.xpath("//input[@id='LastName']"),"Testing");

            Random ran = new Random();
            int emailNum = ran.nextInt(9999);
            sendTextToElement(By.id("Email"), "ram.lax"+emailNum+"@gmail.com" );
            sendTextToElement(By.xpath("//input[@id='Password']"),"asdfgh");
            sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"asdfgh");

           //2.21 Click on “REGISTER” Button
            clickOnElement(By.xpath("//button[@id='register-button']"));

           // 2.22 Verify the message “Your registration completed”
            String expVMessage = "Your registration completed";
            String actVMessage = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
            Assert.assertEquals("Not correct message", expVMessage, actVMessage);
           // 2.23 Click on “CONTINUE” tab
           clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
           // 2.24 Verify the text “Shopping cart”
            String expSText = "Shopping cart";
            String actSText = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
            Assert.assertEquals("Not correct message", expSText, actSText);
           //2.25 click on checkbox “I agree with the terms of service”
            clickOnElement(By.xpath("//input[@id='termsofservice']"));
           // 2.26 Click on “CHECKOUT”
            clickOnElement(By.xpath("//button[@id='checkout']"));
           // 2.27 Fill the Mandatory fields
            selectByValue(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"233");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"London");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"50 Brent Road");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"HA0 1AB");
            sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"071234567891");

           // 2.28 Click on “CONTINUE”
           clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
           // 2.29 Click on Radio Button “2nd Day Air ($0.00)”
            clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
           // 2.30 Click on “CONTINUE”
            clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
          //  2.31 Select Radio Button “Credit Card”
            clickOnElement(By.xpath("//input[@id = 'paymentmethod_1']"));
          //  2.32 Select “Visa” From Select credit card dropdown
          //clickOnElement(By.xpath("//select[@id='CreditCardType']"));
            clickOnElement(By.xpath(" //button[@class='button-1 payment-method-next-step-button']"));
          //  2.33 Fill all the details
            selectByValue(By.id("CreditCardType"),"visa");
            sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Mr A Smith");
            sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5244301009707149");
            selectByValue(By.xpath("//select[@id='ExpireMonth']"),"4");
            selectByValue(By.xpath("//select[@id='ExpireYear']"),"2028");
            sendTextToElement(By.xpath("//input[@id='CardCode']"),"808");
           // 2.34 Click on “CONTINUE”
            clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
           // 2.35 Verify “Payment Method” is “Credit Card”
            String expectedPaymentMethod1 = "Payment Method:";
            String actualTextPaymentMethod1 = getTextFromElement(By.xpath("//span[contains(text(), 'Payment Method:')]"));
            Assert.assertEquals("This is not payment method", expectedPaymentMethod1, actualTextPaymentMethod1);

            String expPaymentMethod = "Credit Card";
            String actPaymentMethod = getTextFromElement(By.xpath("//span[contains(text(), 'Credit Card')]"));
            Assert.assertEquals("Not correct payment method",expPaymentMethod,actPaymentMethod);

          // 2.36 Verify “Shipping Method” is “2nd Day Air”
            String expectedShippingMethod1 = "Shipping Method:";
            String actualShippingMethod1 = getTextFromElement(By.xpath("//span[contains(text(), 'Shipping Method:')]"));
            Assert.assertEquals("This is not shipping method", expectedShippingMethod1, actualShippingMethod1);

            String expShippingMethod = "2nd Day Air";
            String actShippingMethod = getTextFromElement(By.xpath("//span[contains(text(),'2nd Day Air')]"));
            Assert.assertEquals("Not correct payment method",expShippingMethod,actShippingMethod);
            //2.37 Verify Total is “$698.00”
            String expETotal = "$698.00";
            String actETotal = getTextFromElement(By.xpath("(//strong[text()='$698.00'])[2]"));
            Assert.assertEquals("Not matching total",expETotal,actETotal);
            //2.38 Click on “CONFIRM”
            clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
            //2.39 Verify the Text “Thank You”
            String expVText = "Thank you";
            String actVText = getTextFromElement(By.xpath("//h1[text()='Thank you']"));
            Assert.assertEquals("Not correct text",expVText,actVText);
           // 2.40 Verify the message “Your order has been successfully processed!”
            String expOMessage = "Your order has been successfully processed!";
            String actOMessage = getTextFromElement(By.xpath(" //strong[contains(text(), 'fully processed!')]"));
            Assert.assertEquals("Not correct message",expOMessage,actOMessage);
           // 2.41 Click on “CONTINUE”
            clickOnElement(By.xpath(" //button[@onclick='setLocation(\"/\")']"));
          //  2.42 Verify the text “Welcome to our store”
            String expWText = "Welcome to our store";
            String actWText = getTextFromElement(By.xpath("//h2[text()='Welcome to our store']"));
            Assert.assertEquals("Not correct message",expWText,actWText);
          // 2.43 Click on “Logout” link
            clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
         // 2.44 Verify the URL is “https://demo.nopcommerce.com/”
            String expUrl = "https://demo.nopcommerce.com/";
            String actUrl = driver.getCurrentUrl();
            Assert.assertEquals("Not matching URL",expUrl,actUrl);
        }
    @After
    public void tearDown(){
        closeBrowser();
    }
    }

