import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        assert isElementPresent ( registracijaButton );
        registracijaButton.click ();
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
        WebDriverWait wait = new WebDriverWait ( driver,15 );
        wait.until( ExpectedConditions.visibilityOf (element) );
    }


}
