import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    WebDriver driver=null;


    //Web elementi zajednicki za sve

    @FindBy(xpath = "//div[@class='modal-content text-center']//button[@class='close']")
    WebElement ostvariPopustModalClose;

    @FindBy(xpath = "//label[contains(text(),'Statistika')]")
    WebElement cookieStatistika;

     @FindBy(xpath = "//label[contains(text(),'Marketing')]")
     WebElement cookieMarketing;

     @FindBy(className = "cookie-agree-gdpr")
     WebElement cookieSlazemSe;

     @FindBy(xpath = "//i[@class='icon fa fa-search']")
     WebElement searchButton;

     @FindBy(id = "search-text")
     WebElement searchTextField;

     @FindBy(className = "register-btn")
     WebElement registracijaButton;

     @FindBy(className = "login-btn")
     WebElement prijaviteSeButton;

    // @FindBy(xpath = "//div[@class='img-wrapper']//img[@alt='Facebook']")
     @FindBy(xpath = "//img[@alt='Facebook']")
     WebElement povezimoSeFB;

     @FindBy(xpath = "//a[@aria-label='Фејсбук']")
     WebElement logoFB;

     @FindBy(xpath = "//div[@class='bi6gxh9e aov4n071']/h2")
     WebElement nazivNaFBStranici;

     @FindBy(xpath = "//div[@class='aovydwv3 j83agx80 wkznzc2l dlu2gh78']")
     WebElement slikaNaFBStranici;

     @FindBy(xpath = "//img[@alt='YouTube']")
     WebElement povezimoSeYouTube;

     @FindBy(id = "logo-icon")
     WebElement logoYouTube;

     @FindBy(xpath = "//div[@class='b3onmgus hv4rvrfc byvelhso j83agx80 bp9cbjyn']")
     WebElement prijaviSeFB;

     @FindBy(xpath = "//img[@alt='Instagram']")
     WebElement povezimoSeInstagram;

     @FindBy(xpath = "//h1[text()='Instagram']")
     WebElement naslovnaInstagram;





//Registration modal id = "registration_modal"
    // poruka  class = alert alert-success get text
    ////da se ugasi modal xpath = "form[@id='registration_modal']//button[@class='close']"

    //Konstruktor

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements ( driver, this );
    }

    public BasePage() {
    }

    //Методе
    public void clickOstvariPopustModalClose(){
        waitForElement ( ostvariPopustModalClose );
        assert  isElementPresent ( ostvariPopustModalClose ): "Error. Modal is not open";
        ostvariPopustModalClose.click ();
    }

    public void clickCookieStatistika(){
        waitForElement ( cookieStatistika );
        cookieStatistika.click ();
    }

    public void clickCookieMarketing(){
        waitForElement ( cookieMarketing );
        cookieMarketing.click ();
    }

    public void clickCookieSlazemSe(){
        cookieSlazemSe.click ();
    }

    public void clickCookieMarketingCookieStatistikaISlazemSe(){
        this.clickCookieStatistika ();
        this.clickCookieMarketing ();
        this.clickCookieSlazemSe ();
    }

    public void clickSearchButton(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", searchButton);
        waitForElement ( searchButton );
    }

    public void enterTextInSearchField(String text) {
        searchTextField.sendKeys ( text );
        searchTextField.sendKeys ( Keys.ENTER );
    }

    public void clickRegistracijaButton(){
        assert isElementPresent ( registracijaButton ):"Error. Registracija button is not present.";
        registracijaButton.click ();
    }

    public void clickLoginButton(){
        assert isElementPresent ( prijaviteSeButton ):"Error. Login Button is not present.";
        prijaviteSeButton.click ();
    }
    public void clickPoveZimoSeFB(){

        assert isElementPresent ( povezimoSeFB ):"Error. Povezimo se nije prisutna opcija na stranici";
        povezimoSeFB.click ();
        List<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        sleep ();

        print ( "Verifikacija da je Facebook prijavi se prisutan na stranici" );
        assert isElementPresent (prijaviSeFB ):"Error. Nisi na Facebook stranici. ";
        driver.close();
        driver.switchTo().window(tabs.get(0));


    }

    public void clickPovezimoSeYouTube(){
        povezimoSeYouTube.click ();

        List<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        print ( "Verifikacija da je YouTube logo prisutan na stranici" );
        assert isElementPresent (logoYouTube ):"Error. Nisi na YouTube stranici. ";
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void clickPovezimoSeInstagram(){
        povezimoSeInstagram.click ();
        List<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        sleep ();
        print ( "Verifikacija da je Instagram naslov prisutan na stranici" );
        assert isElementPresent (naslovnaInstagram ):"Error. Nisi na Instagram stranici. ";

        driver.close();
        driver.switchTo().window(tabs.get(0));
    }



    //neke helper metode
    public void print(String text) {

        System.out.println (text);
    }

    public void sleep() {

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //provera da li je neki element prisutan na stranici
    public boolean isElementPresent(WebElement element) {
        print("isElementPresent");
        try {
            boolean isPresent=element.isDisplayed();
            return true;
        }catch (Exception e){
            print ( e.getMessage () );
            print ( "Element is not present on page" );
            return false;
        }
    }
    //opsta metoda za cekanje bilo kog webelementa
    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait ( driver, 15 );
        wait.until( ExpectedConditions.visibilityOf (element) );
    }


}
