import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    WebDriver driver = null;

    @FindBy(className = "login-btn")
    WebElement prijaviteSeButton;

    //WebElementi u Modalu Prijava

    @FindBy(id = "login_email")
    WebElement loginEmail;

    @FindBy(id = "login_password")
    WebElement loginLozinka;

    @FindBy(className = "forgotten-password")
    WebElement zaboraviliSteLozinku;

    @FindBy(xpath = "//form[@class='login_form']//button[@type='submit']")
    WebElement loginPrijava;

    @FindBy(xpath = "//form[@class='login_form']//a[@title='Registrujte se']")
    WebElement loginRegistracija;

    //@FindBy(linkText = "https://www.bebakids.com/profil")
    @FindBy(xpath = "//li[@class='item item-username']")
    WebElement profilKorisnika;

    @FindBy(xpath = "//a[@title='Postani VIP']")
    WebElement postaniVip;

    @FindBy(xpath = "//a[@title='Odjava']")
    WebElement odjavaSaProfila;

    @FindBy(xpath = "//li[text()='Unesite validan email.']")
    WebElement errorPorukaZaPrijavuSaNevalidnimKredencijalima;

   @FindBy(xpath = "//div[@class='modal-body']//ul[@id='parsley-id-8544']//li[text()='Ovo polje je obavezno.']")
    //@FindBy(xpath = "ul[@id='parsley-id-8544']")
    WebElement errorPorukaZaPrazanEmail;

    @FindBy(xpath = "//div[@class='modal-body']//ul[@id='parsley-id-2591']//li[text()='Ovo polje je obavezno.']")
    //@FindBy(xpath = "ul[@id='parsley-id-2591']")
    WebElement errorPorukaZaPraznuLozinku;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    WebElement errorAlertZaPogresnuLozinku;



    //Konstruktor

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements ( driver, this );
    }

    //Metode

    public void prijaviteSeButtonClick(){
        isElementPresent ( prijaviteSeButton );
        prijaviteSeButton.click ();
    }
    public void unesiLoginEmail(){
        assert isElementPresent ( loginEmail ):"Error. Login Modal is not open.";
        loginEmail.click ();
        loginEmail.sendKeys ( Strings.LOGIN_EMAIL );
    }
    public void unesiNevalidanEmail(){
        assert isElementPresent ( loginEmail ):"Error. Login Modal is not open.";
        loginEmail.click ();
        loginEmail.sendKeys ( Strings.REGISTRACIJA_NEVALIDNI_EMAIL );
    }
    public void unesiLoginLozinka(){
        assert isElementPresent ( loginLozinka ):"Error. Login Modal is not open.";
        loginLozinka.click ();
        loginLozinka.sendKeys ( Strings.LOGIN_LOZINKA );
    }
    public void unesiNevalidnuLozinku(){
        assert isElementPresent ( loginLozinka ):"Error. Login Modal is not open.";
        loginLozinka.click ();
        loginLozinka.sendKeys ( Strings.REGISTRACIJA_DO6KARAKTERA_LOZINKA );
    }
    public void loginPrijavaClick(){
        assert isElementPresent ( loginPrijava ):"Error. Login Modal is not open.";
        loginPrijava.click ();
    }
    public void profilKorisnikaPrisutanNaStranici(){
        //waitForElement ( profilKorisnika );
         assert isElementPresent ( profilKorisnika ):"Error. You are not logged in.";
    }
    public void postaniVipPrisutanNaStranici(){
        assert isElementPresent ( postaniVip ):"Error. You are not logged in.";
    }
    public void odjavaSaProfilaPrisutnaNaStranici(){
        assert isElementPresent ( odjavaSaProfila ):"Error. You are not logged in.";
    }
    public void daLiJePrisutnaErrorPorukaZaPrijavuSaNevalidnimKredencijalima(){
        assert isElementPresent ( errorPorukaZaPrijavuSaNevalidnimKredencijalima ):"Error. Error message is not shown.";
    }
    public void daLiJePrisutnaErrorPorukaZaPrijavuBezEmailAdrese(){
        assert isElementPresent ( errorPorukaZaPrazanEmail ):"Error. Error message is not shown.";
    }
    public void daLiJePrisutnaErrorPorukaZaPrijavuBezLozinke(){
        assert isElementPresent ( errorPorukaZaPraznuLozinku ):"Error. Error message is not shown.";
    }
    public void daLiJeErrorAlertPrisutan(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].scrollIntoView();", errorAlertZaPogresnuLozinku );

        assert isElementPresent ( errorAlertZaPogresnuLozinku ):"Error. Error message is not shown.";
    }






}
