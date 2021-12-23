import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {

    WebDriver driver=null;

    @FindBy(className = "register-btn")
    WebElement registracijaButton;

    //Webelementi u modalu Registracija

    @FindBy(className = "modal-content")
    WebElement registracijaModalContent;

    @FindBy(id = "reg_firstname")
    WebElement registracijaIme;

    @FindBy(id = "reg_lastname")
    WebElement registracijaPrezime;

    @FindBy(id = "reg_email")
    WebElement registracijaEmail;

    @FindBy(id = "reg_phone")
    WebElement registracijaTelefon;

    @FindBy(id = "reg_city")
    WebElement registracijaGrad;

    @FindBy(id = "reg_postcode")
    WebElement registracijaPostanskiBroj;

    @FindBy(id = "reg_address")
    WebElement registracijaAdresa;

    @FindBy(id = "reg_street_no")
    WebElement registracijaBrojULice;

    @FindBy(id = "reg_password")
    WebElement registracijaLozinka;

    @FindBy(id = "reg_password_repeat")
    WebElement registracijaPonoviteLozinku;

    @FindBy(xpath = "//label[@for='reg_gender_2']")
    WebElement registracijaPolZenski;

    @FindBy(id = "reg_confirm")
    WebElement registracijaSlazemSeSaUslovimaKoriscenja;

    @FindBy(id = "reg_sendNewsletter")
    WebElement registracijaObavestenjaNaMail;

    @FindBy(id = "reg_loyaltyRequest")
    WebElement registracijaLoyaltyRequest;

    @FindBy(xpath = "//form[@id='registration_modal']//button[@type='submit']")
    WebElement registracijaPotvrdiRegistracijuButton;

    @FindBy(id = "reg_anti")
    WebElement registracijaAntiSpamField;

    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-6']//label[@for='reg_anti']")
    WebElement registracijaAntiSpamPitanje;

    @FindBy(xpath = "//form[@id='registration_modal']//button[@class='close']")
    WebElement registracijaCloseModal;

//    @FindBy(xpath = "//div[@class='modal-dialog']//ul[@id=\"parsley-id-9083\"]")
     //       @FindBy(xpath = "//div[@class='modal-dialog']//ul[@id=\"parsley-id-9083\"]//li[@class='parsley-required']")
//       @FindBy(xpath = "//div[@class='modal-dialog']//div[@class='col-xs-12 col-sm-6']//ul[@id='parsley-id-3135']")

       @FindBy(xpath = "//div[@class='modal-dialog']//div[@class='col-xs-12 col-sm-6']//li[text()='Ovo polje je obavezno.']")
       WebElement registracijaValidationError;


    //Konstruktor

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements ( driver, this );
    }

    //Metode

    public void clickRegistracijaButton(){
        assert isElementPresent ( registracijaButton );
        registracijaButton.click ();
    }

    public void registracijaUnesiIme(){
        assert isElementPresent ( registracijaIme ):"Error. Registration modal is not open";
        registracijaIme.click ();
        registracijaIme.sendKeys ( Strings.REGISTRACIJA_IME );
    }
    public void registracijaUnesiPrezime(){
        assert isElementPresent ( registracijaPrezime ):"Error. Registration modal is not open";
        registracijaPrezime.click ();
        registracijaPrezime.sendKeys ( Strings.REGISTRACIJA_PREZIME );
    }
    public void registracijaUnesiEmail(){
        assert isElementPresent ( registracijaEmail ):"Error. Registration modal is not open";
        registracijaEmail.click ();
        registracijaEmail.sendKeys ( Strings.REGISTRACIJA_EMAIL );
    }
    public void registracijaUnesiTelefon(){
        assert isElementPresent ( registracijaTelefon ):"Error. Registration modal is not open";
        registracijaTelefon.click ();
        registracijaTelefon.sendKeys ( Strings.REGISTRACIJA_TELEFON );
    }
    public void registracijaUnesiGrad(){
        assert isElementPresent ( registracijaGrad ):"Error. Registration modal is not open";
        registracijaGrad.click ();
        registracijaGrad.sendKeys ( Strings.REGISTRACIJA_GRAD );
    }
    public void registracijaUnesiPostanskiBroj(){
        assert isElementPresent ( registracijaPostanskiBroj ):"Error. Registration modal is not open";
        registracijaPostanskiBroj.click ();
        registracijaPostanskiBroj.sendKeys ( Strings.REGISTRACIJA_POSTANSKI_BROJ );
    }
    public void registracijaUnesiAdresu(){
        assert isElementPresent ( registracijaAdresa ):"Error. Registration modal is not open";
        registracijaAdresa.click ();
        registracijaAdresa.sendKeys ( Strings.REGISTRACIJA_ADRESA );
    }
    public void registracijaUnesiBrojUlice(){
        assert isElementPresent ( registracijaBrojULice ):"Error. Registration modal is not open";
        registracijaBrojULice.click ();
        registracijaBrojULice.sendKeys ( Strings.REGISTRACIJA_BROJ_ULICE );
    }

//TODO uradi aserte kako treba

    public void registracijaUnesiLozinku(){
        assert isElementPresent ( registracijaLozinka ):"Error. Registration modal is not open";
        registracijaLozinka.sendKeys (Strings.REGISTRACIJA_UNESI_LOZINKU);
    }
    public void registracijaPonovoUnesiLozinku(){
        assert isElementPresent ( registracijaPonoviteLozinku ):"Error. Registration modal is not open";
        registracijaPonoviteLozinku.sendKeys ( Strings.REGISTRACIJA_UNESI_LOZINKU );
    }

    //PROBLEM
    public void registracijaOznaciPolZenski(){

        assert isElementPresent ( registracijaPolZenski ):"Error. Registration modal is not open";
        registracijaPolZenski.click ();
    }
    public void registracijaOznaciSlazemSeSaUslovimaKoriscenja(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].scrollIntoView();", registracijaPotvrdiRegistracijuButton );
        assert isElementPresent ( registracijaSlazemSeSaUslovimaKoriscenja ):"Error. Registration modal is not open";
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click();", registracijaSlazemSeSaUslovimaKoriscenja);
    }

    public void registracijaOznaciLoyaltyRequest(){
        assert isElementPresent ( registracijaLoyaltyRequest ):"Error. Registration modal is not open";
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", registracijaLoyaltyRequest);

    }
    public void registracijaPotvrdiRegistracijuButtonClick(){
        assert isElementPresent ( registracijaPotvrdiRegistracijuButton ):"Error. Registration modal is not open";
        registracijaPotvrdiRegistracijuButton.click ();
        sleep ();
    }

    public void registracijaDaLiJeErrorMessagePrisutan(){
        assert isElementPresent ( registracijaValidationError ):"Error. ";
    }
    public void registracijaCloseModal(){
        assert isElementPresent ( registracijaCloseModal ):"Error. Registration modal is not open";
        registracijaCloseModal.click ();
    }






}
