import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    WebDriver driver = null;

    //   Metoda za otvaranje Chrome drivera

    public WebDriver openChromeDriver() {
        print ( "Opening Chrome Driver" );
        ChromeOptions options = new ChromeOptions ();
//    options.addArguments (  new String []{"--start-maximized"});
        options.addArguments ( new String[]{"--ignore-certificate-errors"} );
        options.addArguments ( new String[]{"--disable-popup-blocking"} );
        options.addArguments ( new String[]{"--incognito"} );
        ChromeDriver driver = new ChromeDriver ( options );
        driver.get ( "https://www.bebakids.com/" );
        //proveri da li ovo moze ovde
        BasePage basePage = new BasePage (driver);
        basePage.clickOstvariPopustModalClose ();
        basePage.clickCookieMarketingCookieStatistikaISlazemSe ();
        basePage.sleep ();
        return driver;
    }
    public void print(String text) {

        System.out.println (text);
    }

    public  boolean isCurrentUrlEqualsTo(String expectedUrl){
        print ( "isCurrentUrlEqualsTo ( " + expectedUrl + " ) ");
        String currentUrl = driver.getCurrentUrl ();
        print ( "User is on " + currentUrl );
        boolean b = currentUrl.equals ( expectedUrl );
        return b;
//        return  driver.getCurrentUrl ().equals ( expectedUrl );


    }
    public boolean verifySearchItemIsShown(String search, WebDriver driver){
        List<WebElement> searchItems = driver.findElements ( By.xpath ( "//div[@class='item sel-filter']")  );
        ArrayList<String> searchItemText = new ArrayList<> ();
        for(WebElement item: searchItems){
            String text = item.getText ();
            searchItemText.add ( text );
        }
        return searchItemText.contains ( search );
    }
}
