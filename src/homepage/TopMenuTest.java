package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";
    static String menu = "Computers";
    @Before
    public void setUp (){
        openBrowser(baseUrl);
    }


    public void selectMenu(String menu){
    clickOnElement(By.linkText(menu));

    }

    @Test
    public void verifyPageNavigation(){
        selectMenu("Computers");
        String expText = "Computers";
        String actText = getTextFromElement(By.xpath("//h1[contains(text()," + "'" + menu +"')]"));
        System.out.println(actText);
        Assert.assertEquals("Not matching",expText,actText);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
