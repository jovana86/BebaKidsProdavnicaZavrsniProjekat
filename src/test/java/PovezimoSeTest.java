import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PovezimoSeTest extends BaseTest{
    @Test
    public void povezimoSeFBTest(){
       WebDriver driver =  openChromeDriver ();
       try {
           BasePage basePage = new BasePage (driver);
           basePage.clickPovezimoSeYouTube ();
           basePage.clickPoveZimoSeFB ();
           basePage.clickPovezimoSeInstagram ();

       }finally {
           driver.quit ();
       }
    }


}
