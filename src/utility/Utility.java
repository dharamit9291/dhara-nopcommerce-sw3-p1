package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseClass {

    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
       /* WebElement emailField  = driver.findElement(by);
        //Type email to email field
        emailField.sendKeys(text);*/
    }
    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }

    //**************************************** Alert methods ********************************
    /**
     * This method will switch to alert
     */
    public void switchToAlert(){
        driver.switchTo().alert();
    }
    public void switchToAcceptAlert(){
        driver.switchTo().alert().accept();
    }
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    public String getTextFromAlert(By xpath){
        return driver.switchTo().alert().getText();
    }
    public void sendTextToAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    // Homework 4 method acceptAlert, dismissAlert, String getTextFromAlert, sendTextToAlert (String text)


    //********************************** Select Class Methods ******************************
    /**
     * This method will select option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }
    /* This method will select the option by value
     */
    public void selectByValue(By by, String text){
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(text);
    }
    /* This method will select the option by index
     */
    public void selectByIndex(By by, int index){
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }
    /*
     * This method will select the option by contains text
     */
    public void selectContainsText(By by){
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        List<WebElement> list = select.getOptions();
    }

    //************************** Window Handle ************************************************
    //**************************Action Class *************************************************

    //mouseHoverToElement(By by), mouseHoverToElementAndClick(By by)
    public void mouseHoverToElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
    public void mouseHoverToElementAndClick(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
}
